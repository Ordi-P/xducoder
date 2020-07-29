package com.xdu.xducoder.Entity;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class Course implements Serializable {
    @JSONField(name="CourseID")
    private String courseID;
    @JSONField(name="CourseName")
    private String courseName;
    @JSONField(name="CourseDIF")
    private String courseDIF;
    @JSONField(name="CourseNum")
    private Integer courseNum;
    @JSONField(name="completeNum")
    private Integer completeNum;
    @JSONField(name="CourseDescription")
    private String courseDescription;

    private String coverUrl;

    private static final long serialVersionUID = 1L;

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID == null ? null : courseID.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseDIF() {
        return courseDIF;
    }

    public void setCourseDIF(String courseDIF) {
        this.courseDIF = courseDIF == null ? null : courseDIF.trim();
    }

    public Integer getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }

    public Integer getCompleteNum() {
        return completeNum;
    }

    public void setCompleteNum(Integer completeNum) {
        this.completeNum = completeNum;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription == null ? null : courseDescription.trim();
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl == null ? null : coverUrl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseID=").append(courseID);
        sb.append(", courseName=").append(courseName);
        sb.append(", courseDIF=").append(courseDIF);
        sb.append(", courseNum=").append(courseNum);
        sb.append(", completeNum=").append(completeNum);
        sb.append(", courseDescription=").append(courseDescription);
        sb.append(", coverUrl=").append(coverUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}