package com.aplova.productimagesautouploader.model;

import java.util.List;

public class MainResponseDetails {
    private String businessId;
    private List<ResponseDetails> imageThumbnailAddedProducts;
    private List<ResponseDetails> onlyImagesAddedProducts;
    private List<ResponseDetails> imagesThumbnailNotAddedProducts;
    private List<ResponseDetails> imagesThumbnailExistingProducts;

    public MainResponseDetails(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public List<ResponseDetails> getImageThumbnailAddedProducts() {
        return imageThumbnailAddedProducts;
    }

    public void setImageThumbnailAddedProducts(List<ResponseDetails> imageThumbnailAddedProducts) {
        this.imageThumbnailAddedProducts = imageThumbnailAddedProducts;
    }

    public List<ResponseDetails> getOnlyImagesAddedProducts() {
        return onlyImagesAddedProducts;
    }

    public void setOnlyImagesAddedProducts(List<ResponseDetails> onlyImagesAddedProducts) {
        this.onlyImagesAddedProducts = onlyImagesAddedProducts;
    }

    public List<ResponseDetails> getImagesThumbnailNotAddedProducts() {
        return imagesThumbnailNotAddedProducts;
    }

    public void setImagesThumbnailNotAddedProducts(List<ResponseDetails> imagesThumbnailNotAddedProducts) {
        this.imagesThumbnailNotAddedProducts = imagesThumbnailNotAddedProducts;
    }

    public List<ResponseDetails> getImagesThumbnailExistingProducts() {
        return imagesThumbnailExistingProducts;
    }

    public void setImagesThumbnailExistingProducts(List<ResponseDetails> imagesThumbnailExistingProducts) {
        this.imagesThumbnailExistingProducts = imagesThumbnailExistingProducts;
    }

    @Override
    public String toString() {
        return "MainResponseDetails{" +
                "businessId='" + businessId + '\'' +
                ", imagesThumbnailAddedProducts=" + imageThumbnailAddedProducts +
                ", onlyImagesAddedProducts=" + onlyImagesAddedProducts +
                ", imagesThumbnailNotAddedProducts=" + imagesThumbnailNotAddedProducts +
                ", imagesThumbnailExistingProducts=" + imagesThumbnailExistingProducts +
                '}';
    }
}
