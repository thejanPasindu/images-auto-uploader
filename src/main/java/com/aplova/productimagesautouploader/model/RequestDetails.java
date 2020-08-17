package com.aplova.productimagesautouploader.model;

public class RequestDetails {
    private String businessId;
    private String path;
    private String thumbnailPath;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    @Override
    public String toString() {
        return "RequestDetails{" +
                "businessId='" + businessId + '\'' +
                ", path='" + path + '\'' +
                ", thumbnailPath='" + thumbnailPath + '\'' +
                '}';
    }
}
