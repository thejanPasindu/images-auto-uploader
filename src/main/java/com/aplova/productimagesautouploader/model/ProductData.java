package com.aplova.productimagesautouploader.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
        @TypeDef(name = "list-array", typeClass = ListArrayType.class)
})
public class ProductData {
    @Id
    private String productid;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String addonlist;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String additionalinfo;

    private Date created_date;

    @Column(nullable=false)
    private Boolean deliverable;

    @Column(name = "description", length = 25000)
    private String description;

    @Type(type = "list-array")
    @Column(
            name = "images",
            columnDefinition = "TEXT[]"
    )
    private List<String> images;

    private Boolean active;

    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;

    private String name;

    @Column(nullable=false)
    private Float ratings;

    @Type(type = "list-array")
    @Column(
            name = "tags",
            columnDefinition = "TEXT[]"
    )
    private List<String> tags;

    @Column(name = "tax_percentage")
    private Float taxPercentage;

    @Type(type = "jsonb")
    @Column(name = "thumb_images", columnDefinition = "jsonb")
    private List<String> thumbImages;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String variant;

    private String business;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String taxelements;

    @Type(type = "jsonb")
    @Column(name = "video_urls", columnDefinition = "jsonb")
    private String videoUrls;

    @Column(name = "active_for_orderahead", columnDefinition = "boolean default true")
    private Boolean activeForOrderahead;

    @Column(columnDefinition = "boolean default true")
    private Boolean active_for_kiosk;

    @Column(name = "active_for_orderahead_webstore", columnDefinition = "boolean default true")
    private Boolean activeForOrderaheadWebstore;

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getAddonlist() {
        return addonlist;
    }

    public void setAddonlist(String addonlist) {
        this.addonlist = addonlist;
    }

    public String getAdditionalinfo() {
        return additionalinfo;
    }

    public void setAdditionalinfo(String additionalinfo) {
        this.additionalinfo = additionalinfo;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Boolean getDeliverable() {
        return deliverable;
    }

    public void setDeliverable(Boolean deliverable) {
        this.deliverable = deliverable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRatings() {
        return ratings;
    }

    public void setRatings(Float ratings) {
        this.ratings = ratings;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Float getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Float taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public List<String> getThumbImages() {
        return thumbImages;
    }

    public void setThumbImages(List<String> thumbImages) {
        this.thumbImages = thumbImages;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getTaxelements() {
        return taxelements;
    }

    public void setTaxelements(String taxelements) {
        this.taxelements = taxelements;
    }

    public String getVideoUrls() {
        return videoUrls;
    }

    public void setVideoUrls(String videoUrls) {
        this.videoUrls = videoUrls;
    }

    public Boolean getActiveForOrderahead() {
        return activeForOrderahead;
    }

    public void setActiveForOrderahead(Boolean activeForOrderahead) {
        this.activeForOrderahead = activeForOrderahead;
    }

    public Boolean getActive_for_kiosk() {
        return active_for_kiosk;
    }

    public void setActive_for_kiosk(Boolean active_for_kiosk) {
        this.active_for_kiosk = active_for_kiosk;
    }

    public Boolean getActiveForOrderaheadWebstore() {
        return activeForOrderaheadWebstore;
    }

    public void setActiveForOrderaheadWebstore(Boolean activeForOrderaheadWebstore) {
        this.activeForOrderaheadWebstore = activeForOrderaheadWebstore;
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "productid='" + productid + '\'' +
                ", addonlist='" + addonlist + '\'' +
                ", additionalinfo='" + additionalinfo + '\'' +
                ", created_date=" + created_date +
                ", deliverable=" + deliverable +
                ", description='" + description + '\'' +
                ", images='" + images + '\'' +
                ", active=" + active +
                ", last_updated_date=" + lastUpdatedDate +
                ", name='" + name + '\'' +
                ", ratings=" + ratings +
                ", tags='" + tags + '\'' +
                ", tax_percentage=" + taxPercentage +
                ", thumb_images='" + thumbImages + '\'' +
                ", variant='" + variant + '\'' +
                ", business='" + business + '\'' +
                ", taxelements='" + taxelements + '\'' +
                ", video_urls='" + videoUrls + '\'' +
                ", active_for_orderahead=" + activeForOrderahead +
                ", active_for_kiosk=" + active_for_kiosk +
                ", active_for_orderahead_webstore=" + activeForOrderaheadWebstore +
                '}';
    }
}
