package com.xdu.xducoder.Dao.noteBook.DaoImpl;

import com.xdu.xducoder.Dao.noteBook.Dao.DataBaseConnection;
import com.xdu.xducoder.Dao.noteBook.Dao.UserDao;
import com.xdu.xducoder.Entity.noteBook.UserVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Override
    public boolean insert(UserVO user) {
        if (user == null) return false;
        if (user.getUserId() == null || user.getName() == null) return false;
        String sql = String.format(
                "INSERT INTO tb_user(userId, name, path) VALUES('%s', '%s', '%s')",
                user.getUserId(),
                user.getName(),
                user.getPath()
        );
        return execute(sql);
    }

    @Override
    public boolean deleteByPrimaryKey(String userId) {
        if (userId == null) return false;
        String sql = String.format(
                "DELETE FROM tb_user WHERE userId = '%s'",
                userId
        );
        return execute(sql);
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserVO user) {
        if (user == null) return false;
        try {
            UserVO t = selectByPrimaryKey(user.getUserId());
            if (t == null) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = String.format(
                "UPDATE tb_user SET name='%s', path = '%s' WHERE userId = '%s';",
                user.getName(),
                user.getPath(),
                user.getUserId()
        );
        return execute(sql);
    }

    @Override
    public UserVO selectByPrimaryKey(String userId) throws SQLException {
        DataBaseConnection dbConnection =  new DataBaseConnection();
        Connection connection = dbConnection.getConnection();
        if (connection == null) return null;

        UserVO user = null;
        String sql = String.format("SELECT * FROM tb_user WHERE userId = '%s';", userId);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet == null) return null;

        if (resultSet.next()){
            user = new UserVO(userId, resultSet.getString("name"), resultSet.getString("path"));
            user.setUserId(userId);
        }

        resultSet.close();
        connection.close();
        return user;
    }

}
