package com.xdu.xducoder.Entity;

import java.io.Serializable;

public class Notebook implements Serializable {
    private String nbID;

    private String name;

    private String userID;

    private String srcID;

    private String path;

    private static final long serialVersionUID = 1L;

    public Notebook(String nbID, String name, String userID, String srcID, String path) {
        this.nbID = nbID;
        this.name = name;
        this.userID = userID;
        this.srcID = srcID;
        this.path = path;
    }

    public Notebook(){ }

    public String getNbID() {
        return nbID;
    }

    public void setNbID(String nbID) {
        this.nbID = nbID == null ? null : nbID.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID == null ? null : userID.trim();
    }

    public String getSrcID() {
        return srcID;
    }

    public void setSrcID(String srcID) {
        this.srcID = srcID == null ? null : srcID.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nbID=").append(nbID);
        sb.append(", name=").append(name);
        sb.append(", userID=").append(userID);
        sb.append(", srcID=").append(srcID);
        sb.append(", path=").append(path);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}