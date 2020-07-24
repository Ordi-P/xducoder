package com.xdu.xducoder.Entity;

import java.io.Serializable;

public class Steps implements Serializable {
    private String stepName;

    private String stepDescription;

    private String stepUrl;

    private String courseID;

    private Integer stepID;

    private String nbID;

    private static final long serialVersionUID = 1L;

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName == null ? null : stepName.trim();
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription == null ? null : stepDescription.trim();
    }

    public String getStepUrl() {
        return stepUrl;
    }

    public void setStepUrl(String stepUrl) {
        this.stepUrl = stepUrl == null ? null : stepUrl.trim();
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

    public String getNbID() {
        return nbID;
    }

    public void setNbID(String nbID) {
        this.nbID = nbID == null ? null : nbID.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stepName=").append(stepName);
        sb.append(", stepDescription=").append(stepDescription);
        sb.append(", stepUrl=").append(stepUrl);
        sb.append(", courseID=").append(courseID);
        sb.append(", stepID=").append(stepID);
        sb.append(", nbID=").append(nbID);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}