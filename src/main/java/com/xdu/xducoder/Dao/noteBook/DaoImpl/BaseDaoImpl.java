package com.xdu.xducoder.Dao.noteBook.DaoImpl;


import com.xdu.xducoder.Dao.noteBook.Dao.DataBaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class BaseDaoImpl {

    // 执行一个sql语句
    static boolean execute(String sql){
        DataBaseConnection dbConnection =  new DataBaseConnection();
        Connection connection = dbConnection.getConnection();
        if (connection == null) return false;
        System.out.println("数据库连接成功");
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println(sql + "执行成功");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            dbConnection.close();
        }
    }
}
