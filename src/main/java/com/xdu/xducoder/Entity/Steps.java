package com.xdu.xducoder.Entity;

import java.io.Serializable;

public class Steps implements Serializable {
    private String courseID;

    private String stepName;

    private String stepDescription;

    private String stepUrl;

    private Integer stepID;

    private static final long serialVersionUID = 1L;

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID == null ? null : courseID.trim();
    }

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

    public Integer getStepID() {
        return stepID;
    }

    public void setStepID(Integer stepID) {
        this.stepID = stepID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseID=").append(courseID);
        sb.append(", stepName=").append(stepName);
        sb.append(", stepDescription=").append(stepDescription);
        sb.append(", stepUrl=").append(stepUrl);
        sb.append(", stepID=").append(stepID);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}