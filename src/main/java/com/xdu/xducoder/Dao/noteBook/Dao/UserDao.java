package com.xdu.xducoder.Dao.noteBook.Dao;


import com.xdu.xducoder.Entity.noteBook.UserVO;

import java.sql.SQLException;

public interface UserDao {

    // 插入一个新用户
    boolean insert(UserVO user);

    // 删除一个用户
    boolean deleteByPrimaryKey(String userId);

    // 更新一个用户的信息
    boolean updateByPrimaryKeySelective(UserVO user);

    // 通过id查询一个用户
    UserVO selectByPrimaryKey(String userId) throws SQLException;

}
