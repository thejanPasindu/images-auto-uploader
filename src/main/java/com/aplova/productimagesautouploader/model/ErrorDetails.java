package com.aplova.productimagesautouploader.model;

public class ErrorDetails {
    private String businessId;
    private String error;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "businessId='" + businessId + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
