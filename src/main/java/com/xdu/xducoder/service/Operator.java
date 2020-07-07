package com.xdu.xducoder.service;

import com.xdu.xducoder.Dao.NotebookMapper;
import com.xdu.xducoder.Dao.UserinfoMapper;
import com.xdu.xducoder.Entity.Notebook;
import com.xdu.xducoder.Entity.NotebookExample;
import com.xdu.xducoder.Entity.Userinfo;
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

    // 将一个笔记本拷贝到目标目录下
    public boolean copyNbToUser(Notebook src, String tarUserId){
        Userinfo tarUser;
        Userinfo srcUser;
        try {
            tarUser = userDao.selectByPrimaryKey(tarUserId);
            srcUser = userDao.selectByPrimaryKey(src.getUserID());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        // 目标笔记本的信息,笔记本id是自动生成的
        String tarNbId = tarUserId + Long.toHexString(System.currentTimeMillis());
        String tarPath = tarUser.getPath() + "/"+ src.getPath() + "/" + src.getName();
        // 源笔记本的路径
        String srcPath = srcUser.getPath() + "/" + src.getPath() + "/" + src.getName();
        // 复制
        try {
            Files.copy(Paths.get(srcPath), Paths.get(tarPath));
            Runtime.getRuntime().exec("chmod 777 " + tarPath);
            // 更新数据库
            Notebook tar = new Notebook(tarNbId, src.getName(), tarPath, src.getNbID(), src.getPath());
            nbDao.insert(tar);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean copyNbToUser(String nbId, String tarUserId){
        Notebook src;
        try {
            src = nbDao.selectByPrimaryKey(nbId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return copyNbToUser(src, tarUserId);
    }

    // 将一个笔记本拷贝到目标目录下
    public boolean copyNbToUser(String UserID, String path, String name, String tarUserId){
        // 源笔记本
        List<Notebook> src;
        try {
            NotebookExample example = new NotebookExample();
            example.createCriteria().andPathEqualTo(path).andUserIDEqualTo(UserID).andNameEqualTo(name);
            src = nbDao.selectByExample(example);
            if (src.size() == 1)
            {
                return copyNbToUser(src.get(0), tarUserId);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 删除一个笔记本,通过其id
    public boolean deleteNb(String nbId){
        Notebook src = null;
        Userinfo user = null;
        try {
            src = nbDao.selectByPrimaryKey(nbId);
            user = userDao.selectByPrimaryKey(src.getUserID());

            NotebookExample example = new NotebookExample();
            example.createCriteria().andSrcIDEqualTo(nbId);
            List<Notebook> notebooks = nbDao.selectByExample(example);
            for (Notebook notebook : notebooks){
                notebook.setSrcID(null);
                nbDao.updateByPrimaryKey(notebook);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        String path = user.getPath() + "/" + src.getPath() + "/" + src.getName();
        try {
            Files.delete(Paths.get(path));
            nbDao.deleteByPrimaryKey(nbId);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // 重置一个笔记本,此笔记本必须是复制得来的笔记本
    public boolean resetNb(String nbId){
        Notebook tarNb, srcNb;
        tarNb = nbDao.selectByPrimaryKey(nbId);
        if (tarNb == null || tarNb.getSrcID() == null) return false;
        srcNb = nbDao.selectByPrimaryKey(tarNb.getSrcID());

        String srcPath = userDao.selectByPrimaryKey(srcNb.getUserID()).getPath()
                + "/" + srcNb.getPath() + "/" + srcNb.getName();
        String tarPath = userDao.selectByPrimaryKey(tarNb.getUserID()).getPath()
                + "/" + tarNb.getPath() + "/" + tarNb.getName();
        File src = new File(srcPath);
        File tar = new File(tarPath);

        if (!src.exists()){
            System.out.println("[error] 源笔记本不存在,源笔记本: " + src);
            return false;
        }
        if (!tar.exists()){
            System.out.println("[error] 目标笔记本不存在,目标笔记本: " + tar);
            return false;
        }

        try {
            if(!tar.delete()){
                System.out.println("[error] 笔记本无法被删除,笔记本: " + tar);
                return false;
            }
            Files.copy(src.toPath(), tar.toPath());
            nbDao.deleteByPrimaryKey(nbId);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
