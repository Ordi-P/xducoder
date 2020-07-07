package com.xdu.xducoder.service;

import com.xdu.xducoder.Entity.noteBook.UserVO;
import com.raincur.exception.UserNotFoundException;
import com.xdu.xducoder.Dao.UserinfoMapper;
import com.xdu.xducoder.Entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class UserManager {
    // 注意路径
    private static final String rootPath = "/home/jupyter";
    @Autowired
    private UserinfoMapper userDao;

    public boolean createUser(String userId, String name){
        String path = rootPath + "\\" + userId + name;
        File file = new File(path);
        boolean flag = false;
        if (!file.exists()){
            System.out.println(file);
            flag = file.mkdir();
        }
        if (!flag) return false;
        System.out.println("创建了一个文件夹, 名字为:" + file);
        UserVO user = new UserVO(userId, name, path);
        System.out.println("用户信息为:" + user);
        return true;
    }

    public boolean deleteUser(String userId) throws UserNotFoundException {
        File file;
        try {
            Userinfo user = userDao.selectByPrimaryKey(userId);
            file = new File(user.getPath());
        } catch (Exception e) {
            throw new UserNotFoundException(userId, e);
        }
        if (!file.exists()) return false;
//        userDao.deleteByPrimaryKey(userId);
        return file.delete();
    }
}
