package com.xdu.xducoder.service;

import com.xdu.xducoder.Dao.NotebookMapper;
import com.xdu.xducoder.Dao.UserinfoMapper;
import com.xdu.xducoder.Entity.Notebook;
import com.xdu.xducoder.Entity.NotebookExample;
import com.xdu.xducoder.Entity.Userinfo;
import com.xdu.xducoder.Entity.UserinfoExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class Operator {

    @Autowired
    public NotebookMapper nbDao;
    @Autowired
    public UserinfoMapper userDao;

    private final Logger logger = LoggerFactory.getLogger(Operator.class);

    // 将一个笔记本拷贝到目标目录下
    public boolean copyNbToUser(Notebook src, String tarUserId){
        logger.debug(String.format("复制笔记本,src: %s, tarUserId: %s", src.toString(), tarUserId));

        NotebookExample ne = new NotebookExample();
        ne.createCriteria().andSrcIDEqualTo(src.getNbID()).andUserIDEqualTo(tarUserId);
        if (nbDao.selectByExample(ne).size() > 0) {
            logger.warn(String.format("笔记本已经存在! src: %s, tarUserId: %s",src.toString(), tarUserId));
            return false;
        }

        UserinfoExample example1 = new UserinfoExample();
        example1.createCriteria().andUserIDEqualTo(tarUserId);
        Userinfo tarUser = (Userinfo) userDao.selectByExample(example1);

        UserinfoExample example2 = new UserinfoExample();
        example2.createCriteria().andUserIDEqualTo(src.getUserID());
        Userinfo srcUser = (Userinfo) userDao.selectByExample(example2);

        if (srcUser == null){
            logger.error(String.format("用户未找到!srcUserId: %s", src.getUserID()));
            return false;
        }
        if (tarUser == null){
            logger.error(String.format("用户未找到!tarUserId: %s", tarUserId));
            return false;
        }

        // 目标笔记本的信息,笔记本id是自动生成的
        String tarNbId = tarUserId + Long.toHexString(System.currentTimeMillis());
        String tarPath = tarUser.getPath() + "/"+ src.getPath() + "/" + src.getName();
        // 源笔记本的路径
        String srcPath = srcUser.getPath() + "/" + src.getPath() + "/" + src.getName();

        // 复制
        try {
            logger.debug(String.format("复制文件,源文件path: %s, 目标path: %s", srcPath, tarPath));
            Files.copy(Paths.get(srcPath), Paths.get(tarPath));
            Runtime.getRuntime().exec("chmod 777 " + tarPath);
            // 更新数据库
            Notebook tar = new Notebook(tarNbId, src.getName(), tarPath, src.getNbID(), src.getPath());
            nbDao.insert(tar);
            logger.debug(String.format("更新NoteBook数据库,插入: %s", tar.toString()));
        } catch (IOException e) {
            logger.error(String.format("复制失败!源文件path: %s, 目标path: %s", srcPath, tarPath));
            e.printStackTrace();
            return false;
        }
        logger.info(String.format("复制笔记本成功!, src: %s, tarUserId: %s", src.toString(), tarUserId));
        return true;
    }

    public boolean copyNbToUser(String nbId, String tarUserId){
        logger.debug(String.format("copyNbToUser(nbId: %s, tarUserId: %s)", nbId, tarUserId));
        logger.debug(String.format("查找笔记本,nbId: %s", nbId));
        Notebook src = nbDao.selectByPrimaryKey(nbId);
        if (src == null) {
            logger.error(String.format("笔记本未找到!nbId: %s", nbId));
            return false;
        }
        logger.debug("copyNbToUser(Notebook src, String tarUserId)");
        return copyNbToUser(src, tarUserId);
    }


    // 将一个笔记本拷贝到目标目录下
    public boolean copyNbToUser(String UserID, String path, String name, String tarUserId){
        logger.debug(String.format("copyNbToUser(UserID: %s, path: %s, name: %s, tarUserId: %s)",
                UserID, path, name, tarUserId));
        // 源笔记本
        List<Notebook> src;
        logger.debug("查询数据库");
        NotebookExample example = new NotebookExample();
        example.createCriteria().andPathEqualTo(path).andUserIDEqualTo(UserID).andNameEqualTo(name);
        src = nbDao.selectByExample(example);
        if (src.size() == 1){
            logger.debug("copyNbToUser(Notebook src, String tarUserId)");
            return copyNbToUser(src.get(0), tarUserId);
        } else {
            logger.error(String.format("结果数量为%d,不为一!", src.size()));
            return false;
        }
    }

    // 删除一个笔记本,通过其id
    public boolean deleteNb(String nbId){
        logger.debug(String.format("deleteNb(nbId: %s)", nbId));
        logger.debug(String.format("查询笔记本,nbId: %s", nbId));
        Notebook src = nbDao.selectByPrimaryKey(nbId);
        if (src == null){
            logger.error(String.format("未找到笔记本,nbId: %s", nbId));
            return false;
        }
        logger.debug(String.format("查询用户,userId: %s", src.getUserID()));
        Userinfo user = userDao.selectByPrimaryKey(src.getUserID());
        if (user == null){
            logger.error(String.format("用户未找到,userId: %s", src.getUserID()));
            return false;
        }

        NotebookExample example = new NotebookExample();
        example.createCriteria().andSrcIDEqualTo(nbId);
        List<Notebook> notebooks = nbDao.selectByExample(example);
        for (Notebook notebook : notebooks){
            logger.debug(String.format("删除依赖,nbId: %s, srcId: %s", notebook.getNbID(), notebook.getSrcID()));
            notebook.setSrcID(null);
            nbDao.updateByPrimaryKey(notebook);
        }

        String path = user.getPath() + "/" + src.getPath() + "/" + src.getName();
        try {
            logger.debug(String.format("删除文件,path: %s", path));
            Files.delete(Paths.get(path));
            nbDao.deleteByPrimaryKey(nbId);
            logger.info(String.format("成功删除文件,path: %s", path));
        } catch (IOException e) {
            logger.error(String.format("文件删除失败,path: %s", path));
            e.printStackTrace();
            return false;
        }
        logger.info(String.format("成功删除笔记本,nbId: %s", nbId));
        return true;
    }

    // 重置一个笔记本,此笔记本必须是复制得来的笔记本
    public boolean resetNb(String nbId){
        logger.info(String.format("重置笔记本,nbId: %s", nbId));
        Notebook tarNb, srcNb;
        tarNb = nbDao.selectByPrimaryKey(nbId);
        if (tarNb == null || tarNb.getSrcID() == null) {
            return false;
        }
        srcNb = nbDao.selectByPrimaryKey(tarNb.getSrcID());

        String srcPath = userDao.selectByPrimaryKey(srcNb.getUserID()).getPath()
                + "/" + srcNb.getPath() + "/" + srcNb.getName();
        String tarPath = userDao.selectByPrimaryKey(tarNb.getUserID()).getPath()
                + "/" + tarNb.getPath() + "/" + tarNb.getName();
        logger.info(String.format("笔记本路径,srcPath: %s,tarPath: %s", srcPath, tarPath));
        File src = new File(srcPath);
        File tar = new File(tarPath);

        if (!src.exists()){
            logger.error("源笔记本不存在,源笔记本: " + src);
            return false;
        }
        if (!tar.exists()){
            logger.error("目标笔记本不存在,目标笔记本: " + tar);
            return false;
        }

        try {
            if(!tar.delete()){
                logger.error("笔记本无法被删除,笔记本: " + tar);
                return false;
            }
            Files.copy(src.toPath(), tar.toPath());
            nbDao.deleteByPrimaryKey(nbId);
        } catch (IOException e) {
            logger.error(String.format("复制失败!srcPath: %s,tarPath: %s", srcPath, tarPath));
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
