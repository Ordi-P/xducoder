package com.xdu.xducoder.Entity.noteBook;

/**
 * User类,教师和学生统称User,依靠后期封装进行区分
 * User类,原则上每个用户的数据只能被其自己直接更改
 *
 * User类并不关心自己所处于的班级
 */

public class UserVO {
    private String name;
    private String userId;
    private String path;

    public UserVO() {

    }

    public UserVO(String name, String userId, String path) {
        this.name = name;
        this.userId = userId;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userId=" + userId +
                ", path='" + path + '\'' +
                '}';
    }
}
