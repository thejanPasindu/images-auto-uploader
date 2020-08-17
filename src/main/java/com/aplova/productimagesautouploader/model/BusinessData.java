package com.aplova.productimagesautouploader.model;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "business")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
        @TypeDef(name = "list-array", typeClass = ListArrayType.class)
})
public class BusinessData {

    @Id
    private String businessid;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String additionalinfodatas;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String address;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String appbuildinfo;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String appconfig;

    private String brandimage;

    private String businessdomain;

    @Type(type = "jsonb")
    @Column(name = "business_event_notifications", columnDefinition = "jsonb")
    private String businessEventNotifications;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String charging;

    @Column(name="contactnumbers")
    private byte[] contactnumbers;

    private String country;
    private Date created_date;
    private String currency;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String deliveryhours;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String deliverysupportedareas;


    private String delivery_supported_range;
    private String description;
    private String discountpercentage;
    private String email;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String happyhours;

    @Column(name = "last_products_sync_date")
    private Date lastProductsSyncDate;

    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;
    private String name;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String openhours;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String orderahead;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String paymentproviders;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String peakhours;

    private String servicechargepercentage;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String socialmedialinks;

    private String status;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String stores;

    private String subscription_id;

    @Type(type = "jsonb")
    @Column(name = "subscription_status", columnDefinition = "jsonb")
    private String subscriptionStatus;

    private String taxpercentage;
    private String termsandconditionsurl;
    private String timezone;
    private String type;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String unitofmeasures;

    private String website;
    private String businessuser;
    private String parent_business;

    @Type(type = "jsonb")
    @Column(name = "pickup_setting", columnDefinition = "jsonb")
    private String pickupSetting;

    @Type(type = "jsonb")
    @Column(name = "storefront_configurations", columnDefinition = "jsonb")
    private String storefrontConfigurations;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String oauthproviders;

    @Type(type = "jsonb")
    @Column(name = "kiosk_configurations", columnDefinition = "jsonb")
    private String kioskConfigurations;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String preferences;

    @Type(type = "jsonb")
    @Column(name = "business_manager_configs", columnDefinition = "jsonb")
    private String businessManagerConfigs;

    @Type(type = "jsonb")
    @Column(name = "kiosk_business_manager_configs", columnDefinition = "jsonb")
    private String kioskBusinessManagerConfigs;

    @Type(type = "jsonb")
    @Column(name = "webstore_configs", columnDefinition = "jsonb")
    private String webstoreConfigs;

    @Type(type = "jsonb")
    @Column(name = "pa_configs",columnDefinition = "jsonb")
    private String paConfigs;

    @Type(type = "jsonb")
    @Column(name = "order_head_configs",columnDefinition = "jsonb")
    private String orderHeadConfigs;

    @Type(type = "jsonb")
    @Column(name = "legal_configs", columnDefinition = "jsonb")
    private String legalConfigs;

    @Type(type = "jsonb")
    @Column(name = "duration_groups", columnDefinition = "jsonb")
    private String durationGroups;

    @Type(type = "jsonb")
    @Column(name = "terminal_payment_providers", columnDefinition = "jsonb")
    private String terminalPaymentProviders;

    @Type(type = "jsonb")
    @Column(name = "business_dynamic_fields",columnDefinition = "jsonb")
    private String businessDynamicFields;

    @Type(type = "jsonb")
    @Column(name = "kitchen_display_configs", columnDefinition = "jsonb")
    private String kitchenDisplayConfigs;

    private String instance_id;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String deliveryproviders;

    @Column(name = "webstore_domain_url")
    private String webstoreDomainUrl;

    @Type(type = "jsonb")
    @Column(name = "order_throttling_enabled_time", columnDefinition = "jsonb")
    private String orderThrottlingEnabledTime;

    @Type(type = "jsonb")
    @Column(name = "purchase_unavailable_dates", columnDefinition = "jsonb")
    private String purchaseUnavailableDates;

    @Type(type = "jsonb")
    @Column(name = "merchantweb_configurations", columnDefinition = "jsonb")
    private String merchantwebConfigurations;

    public String getBusinessid() {
        return businessid;
    }

    public void setBusinessid(String businessid) {
        this.businessid = businessid;
    }

    public String getAdditionalinfodatas() {
        return additionalinfodatas;
    }

    public void setAdditionalinfodatas(String additionalinfodatas) {
        this.additionalinfodatas = additionalinfodatas;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAppbuildinfo() {
        return appbuildinfo;
    }

    public void setAppbuildinfo(String appbuildinfo) {
        this.appbuildinfo = appbuildinfo;
    }

    public String getAppconfig() {
        return appconfig;
    }

    public void setAppconfig(String appconfig) {
        this.appconfig = appconfig;
    }

    public String getBrandimage() {
        return brandimage;
    }

    public void setBrandimage(String brandimage) {
        this.brandimage = brandimage;
    }

    public String getBusinessdomain() {
        return businessdomain;
    }

    public void setBusinessdomain(String businessdomain) {
        this.businessdomain = businessdomain;
    }

    public String getBusinessEventNotifications() {
        return businessEventNotifications;
    }

    public void setBusinessEventNotifications(String businessEventNotifications) {
        this.businessEventNotifications = businessEventNotifications;
    }

    public String getCharging() {
        return charging;
    }

    public void setCharging(String charging) {
        this.charging = charging;
    }

    public byte[] getContactnumbers() {
        return contactnumbers;
    }

    public void setContactnumbers(byte[] contactnumbers) {
        this.contactnumbers = contactnumbers;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDeliveryhours() {
        return deliveryhours;
    }

    public void setDeliveryhours(String deliveryhours) {
        this.deliveryhours = deliveryhours;
    }

    public String getDeliverysupportedareas() {
        return deliverysupportedareas;
    }

    public void setDeliverysupportedareas(String deliverysupportedareas) {
        this.deliverysupportedareas = deliverysupportedareas;
    }

    public String getDelivery_supported_range() {
        return delivery_supported_range;
    }

    public void setDelivery_supported_range(String delivery_supported_range) {
        this.delivery_supported_range = delivery_supported_range;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscountpercentage() {
        return discountpercentage;
    }

    public void setDiscountpercentage(String discountpercentage) {
        this.discountpercentage = discountpercentage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHappyhours() {
        return happyhours;
    }

    public void setHappyhours(String happyhours) {
        this.happyhours = happyhours;
    }

    public Date getLastProductsSyncDate() {
        return lastProductsSyncDate;
    }

    public void setLastProductsSyncDate(Date lastProductsSyncDate) {
        this.lastProductsSyncDate = lastProductsSyncDate;
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

    public String getOpenhours() {
        return openhours;
    }

    public void setOpenhours(String openhours) {
        this.openhours = openhours;
    }

    public String getOrderahead() {
        return orderahead;
    }

    public void setOrderahead(String orderahead) {
        this.orderahead = orderahead;
    }

    public String getPaymentproviders() {
        return paymentproviders;
    }

    public void setPaymentproviders(String paymentproviders) {
        this.paymentproviders = paymentproviders;
    }

    public String getPeakhours() {
        return peakhours;
    }

    public void setPeakhours(String peakhours) {
        this.peakhours = peakhours;
    }

    public String getServicechargepercentage() {
        return servicechargepercentage;
    }

    public void setServicechargepercentage(String servicechargepercentage) {
        this.servicechargepercentage = servicechargepercentage;
    }

    public String getSocialmedialinks() {
        return socialmedialinks;
    }

    public void setSocialmedialinks(String socialmedialinks) {
        this.socialmedialinks = socialmedialinks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStores() {
        return stores;
    }

    public void setStores(String stores) {
        this.stores = stores;
    }

    public String getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(String subscription_id) {
        this.subscription_id = subscription_id;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public String getTaxpercentage() {
        return taxpercentage;
    }

    public void setTaxpercentage(String taxpercentage) {
        this.taxpercentage = taxpercentage;
    }

    public String getTermsandconditionsurl() {
        return termsandconditionsurl;
    }

    public void setTermsandconditionsurl(String termsandconditionsurl) {
        this.termsandconditionsurl = termsandconditionsurl;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnitofmeasures() {
        return unitofmeasures;
    }

    public void setUnitofmeasures(String unitofmeasures) {
        this.unitofmeasures = unitofmeasures;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBusinessuser() {
        return businessuser;
    }

    public void setBusinessuser(String businessuser) {
        this.businessuser = businessuser;
    }

    public String getParent_business() {
        return parent_business;
    }

    public void setParent_business(String parent_business) {
        this.parent_business = parent_business;
    }

    public String getPickupSetting() {
        return pickupSetting;
    }

    public void setPickupSetting(String pickupSetting) {
        this.pickupSetting = pickupSetting;
    }

    public String getStorefrontConfigurations() {
        return storefrontConfigurations;
    }

    public void setStorefrontConfigurations(String storefrontConfigurations) {
        this.storefrontConfigurations = storefrontConfigurations;
    }

    public String getOauthproviders() {
        return oauthproviders;
    }

    public void setOauthproviders(String oauthproviders) {
        this.oauthproviders = oauthproviders;
    }

    public String getKioskConfigurations() {
        return kioskConfigurations;
    }

    public void setKioskConfigurations(String kioskConfigurations) {
        this.kioskConfigurations = kioskConfigurations;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getBusinessManagerConfigs() {
        return businessManagerConfigs;
    }

    public void setBusinessManagerConfigs(String businessManagerConfigs) {
        this.businessManagerConfigs = businessManagerConfigs;
    }

    public String getKioskBusinessManagerConfigs() {
        return kioskBusinessManagerConfigs;
    }

    public void setKioskBusinessManagerConfigs(String kioskBusinessManagerConfigs) {
        this.kioskBusinessManagerConfigs = kioskBusinessManagerConfigs;
    }

    public String getWebstoreConfigs() {
        return webstoreConfigs;
    }

    public void setWebstoreConfigs(String webstoreConfigs) {
        this.webstoreConfigs = webstoreConfigs;
    }

    public String getPaConfigs() {
        return paConfigs;
    }

    public void setPaConfigs(String paConfigs) {
        this.paConfigs = paConfigs;
    }

    public String getOrderHeadConfigs() {
        return orderHeadConfigs;
    }

    public void setOrderHeadConfigs(String orderHeadConfigs) {
        this.orderHeadConfigs = orderHeadConfigs;
    }

    public String getLegalConfigs() {
        return legalConfigs;
    }

    public void setLegalConfigs(String legalConfigs) {
        this.legalConfigs = legalConfigs;
    }

    public String getDurationGroups() {
        return durationGroups;
    }

    public void setDurationGroups(String durationGroups) {
        this.durationGroups = durationGroups;
    }

    public String getTerminalPaymentProviders() {
        return terminalPaymentProviders;
    }

    public void setTerminalPaymentProviders(String terminalPaymentProviders) {
        this.terminalPaymentProviders = terminalPaymentProviders;
    }

    public String getBusinessDynamicFields() {
        return businessDynamicFields;
    }

    public void setBusinessDynamicFields(String businessDynamicFields) {
        this.businessDynamicFields = businessDynamicFields;
    }

    public String getKitchenDisplayConfigs() {
        return kitchenDisplayConfigs;
    }

    public void setKitchenDisplayConfigs(String kitchenDisplayConfigs) {
        this.kitchenDisplayConfigs = kitchenDisplayConfigs;
    }

    public String getInstance_id() {
        return instance_id;
    }

    public void setInstance_id(String instance_id) {
        this.instance_id = instance_id;
    }

    public String getDeliveryproviders() {
        return deliveryproviders;
    }

    public void setDeliveryproviders(String deliveryproviders) {
        this.deliveryproviders = deliveryproviders;
    }

    public String getWebstoreDomainUrl() {
        return webstoreDomainUrl;
    }

    public void setWebstoreDomainUrl(String webstoreDomainUrl) {
        this.webstoreDomainUrl = webstoreDomainUrl;
    }

    public String getOrderThrottlingEnabledTime() {
        return orderThrottlingEnabledTime;
    }

    public void setOrderThrottlingEnabledTime(String orderThrottlingEnabledTime) {
        this.orderThrottlingEnabledTime = orderThrottlingEnabledTime;
    }

    public String getPurchaseUnavailableDates() {
        return purchaseUnavailableDates;
    }

    public void setPurchaseUnavailableDates(String purchaseUnavailableDates) {
        this.purchaseUnavailableDates = purchaseUnavailableDates;
    }

    public String getMerchantwebConfigurations() {
        return merchantwebConfigurations;
    }

    public void setMerchantwebConfigurations(String merchantwebConfigurations) {
        this.merchantwebConfigurations = merchantwebConfigurations;
    }
}
