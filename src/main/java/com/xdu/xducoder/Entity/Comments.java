package com.xdu.xducoder.Entity;

import java.io.Serializable;
import java.util.Date;

public class Comments implements Serializable {
    private String courseID;

    private String commentID;

    private String commentTitle;

    private String comment;

    private String commentUser;

    private Date commentDate;

    private byte[] commentType;

    private static final long serialVersionUID = 1L;

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID == null ? null : courseID.trim();
    }

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID == null ? null : commentID.trim();
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle == null ? null : commentTitle.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser == null ? null : commentUser.trim();
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public byte[] getCommentType() {
        return commentType;
    }

    public void setCommentType(byte[] commentType) {
        this.commentType = commentType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseID=").append(courseID);
        sb.append(", commentID=").append(commentID);
        sb.append(", commentTitle=").append(commentTitle);
        sb.append(", comment=").append(comment);
        sb.append(", commentUser=").append(commentUser);
        sb.append(", commentDate=").append(commentDate);
        sb.append(", commentType=").append(commentType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}