package com.xdu.xducoder.Entity;

import java.io.Serializable;
import java.util.Date;

public class Choosecourse implements Serializable {
    private String STDNum;

    private String courseID;

    private Integer stepID;

    private Date regDate;

    private Date completeDate;

    private byte[] courseScore;

    private static final long serialVersionUID = 1L;

    public String getSTDNum() {
        return STDNum;
    }

    public void setSTDNum(String STDNum) {
        this.STDNum = STDNum == null ? null : STDNum.trim();
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID == null ? null : courseID.trim();
    }

    public Integer getStepID() {
        return stepID;
    }

    public void setStepID(Integer stepID) {
        this.stepID = stepID;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public byte[] getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(byte[] courseScore) {
        this.courseScore = courseScore;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", STDNum=").append(STDNum);
        sb.append(", courseID=").append(courseID);
        sb.append(", stepID=").append(stepID);
        sb.append(", regDate=").append(regDate);
        sb.append(", completeDate=").append(completeDate);
        sb.append(", courseScore=").append(courseScore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}