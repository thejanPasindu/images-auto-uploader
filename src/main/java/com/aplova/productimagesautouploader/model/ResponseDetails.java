package com.aplova.productimagesautouploader.model;

import java.util.List;

public class ResponseDetails {
    private String productId;
    private String productName;
    private List<String> imageUrls;
    private List<String> thumbnailUrls;

    public ResponseDetails() {
    }

    public ResponseDetails(String productId, String productName, List<String> url, List<String> thumbnailUrls) {
        this.productId = productId;

        this.productName = productName;
        this.imageUrls = url;
        this.thumbnailUrls = thumbnailUrls;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public List<String> getThumbnailUrls() {
        return thumbnailUrls;
    }

    public void setThumbnailUrls(List<String> thumbnailUrls) {
        this.thumbnailUrls = thumbnailUrls;
    }

    @Override
    public String toString() {
        return "ResponseDetails{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", imageUrls=" + imageUrls +
                ", thumbnailUrls=" + thumbnailUrls +
                '}';
    }
}
