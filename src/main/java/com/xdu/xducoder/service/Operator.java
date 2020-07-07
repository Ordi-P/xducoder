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

    // 项目的根目录,这里一定要注意!!!!!!!!!!!
    static private String root = "/home/jupyter";

    // 将一个笔记本拷贝到目标目录下
    public boolean copyNbToUser(Notebook src, String tarUserId){
        Userinfo tarUser;
        try {
            tarUser = userDao.selectByPrimaryKey(tarUserId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        // 目标笔记本的信息,笔记本id是自动生成的
        String tarNbId = tarUserId + Long.toHexString(System.currentTimeMillis());
        String tarPath = tarUser.getPath() + File.pathSeparator +
                        src.getPath() + File.pathSeparator +
                        src.getName();

        String srcPath = src.getPath() + File.pathSeparator + src.getName();
        // 复制
        try {
            Files.copy(Paths.get(srcPath), Paths.get(tarPath));
            Runtime.getRuntime().exec("chmod 777 " + tarPath);
            // 更新数据库
            Notebook tar = new Notebook(tarNbId, src.getName(), tarPath, src.getNbID(), src.getNbID());
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
//            src = nbDao.queryByOwnerIdAndName(ownerId, path, name);
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
        try {
            src = nbDao.selectByPrimaryKey(nbId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        String path = src.getPath() + " " + src.getName();
        try {
            Files.delete(Paths.get(path));
            nbDao.deleteByPrimaryKey(nbId);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
