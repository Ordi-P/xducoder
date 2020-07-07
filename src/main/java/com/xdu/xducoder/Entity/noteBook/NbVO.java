package com.xdu.xducoder.Entity.noteBook;

public class NbVO {

    private String nbId;
    private String name;
    private String userId;
    private String path; // 相对路径
    private String srcId;

    public NbVO() {
    }

    public NbVO(String nbId, String name, String userId, String path, String srcId) {
        this.nbId = nbId;
        this.name = name;
        this.userId = userId;
        this.path = path;
        this.srcId = srcId;
    }

    public String getSrcId() {
        return srcId;
    }

    public void setSrcId(String srcId) {
        this.srcId = srcId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNbId() {
        return nbId;
    }

    public void setNbId(String nbId) {
        this.nbId = nbId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "nbId='" + nbId + '\'' +
                ", name='" + name + '\'' +
                ", ownerid='" + userId + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
