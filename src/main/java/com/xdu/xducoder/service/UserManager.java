package com.xdu.xducoder.service;

import com.raincur.exception.UserNotFoundException;
import com.xdu.xducoder.Dao.NotebookMapper;
import com.xdu.xducoder.Dao.UserinfoMapper;
import com.xdu.xducoder.Entity.Notebook;
import com.xdu.xducoder.Entity.NotebookExample;
import com.xdu.xducoder.Entity.Userinfo;
import com.xdu.xducoder.Entity.noteBook.UserVO;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class UserManager {
    // 注意路径
    private static final String root = "/home/guest/jupyter";
    @Autowired
    private UserinfoMapper userDao;
    @Autowired
    private NotebookMapper nbDao;

    private Logger logger = LoggerFactory.getLogger(UserManager.class);

    public boolean createUser(String userId, String name){
        logger.debug(String.format("创建用户,userId: %s, name: %s", userId, name));
        // 用户路径
        String path = root + "/" + userId + name;
        File file = new File(path);
        boolean flag = false;
        if (!file.exists()){
            flag = file.mkdir();
            logger.debug(String.format("创建用户目录,path: %s", file.toString()));
        }else{
            logger.warn(String.format("用户目录已存在!path: %s", file.toString()));
            flag = true;
        }
        if (!flag) return false;
        UserVO user = new UserVO(userId, name, path);
        logger.info("成功创建用户,用户信息为: " + user);
        return true;
    }

    public boolean deleteUser(String userId) throws UserNotFoundException {
        logger.debug(String.format("删除用户,userId: %s", userId));
        Userinfo user = userDao.selectByPrimaryKey(userId);
        if (user == null){
            logger.error(String.format("用户未找到!userId: %s", userId));
            throw new UserNotFoundException(userId);
        }
        File file = new File(user.getPath());
        // 删除用户所有笔记本
        NotebookExample example = new NotebookExample();
        example.createCriteria().andUserIDEqualTo(userId);
        List<Notebook> notebooks = nbDao.selectByExample(example);
        Operator operator = new Operator();
        for (Notebook notebook : notebooks){
            operator.deleteNb(notebook.getNbID());
            logger.debug(String.format("删除笔记本,ndId: %s", notebook.getNbID()));
        }

        try {
            FileUtils.deleteDirectory(file);
            logger.info(String.format("删除用户目录,path: %s", file.toString()));
        } catch (IOException e) {
            logger.error(String.format("用户目录未找到!path: %s", file.toString()));
            e.printStackTrace();
            return false;
        }
        logger.info(String.format("删除用户成功!userId: %s", userId));
        return true;
    }
}
