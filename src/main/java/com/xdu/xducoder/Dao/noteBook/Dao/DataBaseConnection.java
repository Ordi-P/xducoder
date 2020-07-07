package com.xdu.xducoder.Dao.noteBook.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {


    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL =
            "jdbc:mysql://47.100.185.208:3306/XDUcoder?useUnicode=true&characterEncoding=utf8&useSSL=true";
    private static final String DBUSER = "root";
    private static final String PASSWORD = "xducoder";
    private Connection conn = null;

    public DataBaseConnection(String dbUrl, String dbUser, String dbPw){
        try{
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public DataBaseConnection() {
        try{
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.conn;
    }

    public void close(){
        if(this.conn!=null){
            try{
                this.conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}