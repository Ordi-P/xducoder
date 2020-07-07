package com.xdu.xducoder.service;

import com.raincur.exception.UserNotFoundException;
import com.xdu.xducoder.Dao.NotebookMapper;
import com.xdu.xducoder.Dao.UserinfoMapper;
import com.xdu.xducoder.Entity.Notebook;
import com.xdu.xducoder.Entity.NotebookExample;
import com.xdu.xducoder.Entity.Userinfo;
import com.xdu.xducoder.Entity.noteBook.UserVO;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class UserManager {
    // 注意路径
    private static final String root = "/home/jupyter";
    @Autowired
    private UserinfoMapper userDao;
    @Autowired
    private NotebookMapper nbDao;

    public boolean createUser(String userId, String name){
        // 用户路径
        String path = root + "/" + userId + name;
        File file = new File(path);
        boolean flag = false;
        if (!file.exists()){
            System.out.println(file);
            flag = file.mkdir();
        }
        if (!flag) return false;
        UserVO user = new UserVO(userId, name, path);
        System.out.println("[info] 创建用户,用户信息为: " + user);
        return true;
    }

    public boolean deleteUser(String userId) throws UserNotFoundException {
        File file;
        Userinfo user;
        try {
            user = userDao.selectByPrimaryKey(userId);
            file = new File(user.getPath());
        } catch (Exception e) {
            throw new UserNotFoundException(userId, e);
        }

        // 删除用户所有笔记本
        NotebookExample example = new NotebookExample();
        example.createCriteria().andUserIDEqualTo(userId);
        List<Notebook> notebooks = nbDao.selectByExample(example);
        Operator operator = new Operator();
        for (Notebook notebook : notebooks){
            operator.deleteNb(notebook.getNbID());
        }

        try {
            FileUtils.deleteDirectory(file);
            System.out.println("[info] 删除用户,用户信息为: " + user);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[warning] 删除用户失败! 用户信息为: " + user);
            return false;
        }
        return true;
    }
}
