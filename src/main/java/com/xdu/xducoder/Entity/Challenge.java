package com.xdu.xducoder.Entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class Challenge implements Serializable {
    @JSONField(name="STUNum")
    private String STUNum;
    @JSONField(name="CourseID")
    private String CourseID;

    public String getSTUNum() {
        return STUNum;
    }

    public void setSTUNum(String STUNum) {
        this.STUNum = STUNum;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "STUNum='" + STUNum + '\'' +
                ", CourseID='" + CourseID + '\'' +
                '}';
    }
}
