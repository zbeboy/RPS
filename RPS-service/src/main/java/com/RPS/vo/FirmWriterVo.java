package com.RPS.vo;

/**
 * Created by Administrator on 2016/5/10.
 */
public class FirmWriterVo {

    private String realName;


    private String enterpriseAddress;


    private String enterprisePhone;


    private String enterprisePerson;


    private String enterpriseIndustry;


    private String enterpriseScale;


    private String enterpriseIntroduce;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }

    public String getEnterprisePhone() {
        return enterprisePhone;
    }

    public void setEnterprisePhone(String enterprisePhone) {
        this.enterprisePhone = enterprisePhone;
    }

    public String getEnterprisePerson() {
        return enterprisePerson;
    }

    public void setEnterprisePerson(String enterprisePerson) {
        this.enterprisePerson = enterprisePerson;
    }

    public String getEnterpriseIndustry() {
        return enterpriseIndustry;
    }

    public void setEnterpriseIndustry(String enterpriseIndustry) {
        this.enterpriseIndustry = enterpriseIndustry;
    }

    public String getEnterpriseScale() {
        return enterpriseScale;
    }

    public void setEnterpriseScale(String enterpriseScale) {
        this.enterpriseScale = enterpriseScale;
    }

    public String getEnterpriseIntroduce() {
        return enterpriseIntroduce;
    }

    public void setEnterpriseIntroduce(String enterpriseIntroduce) {
        this.enterpriseIntroduce = enterpriseIntroduce;
    }

    @Override
    public String toString() {
        return "FirmWriterVo{" +
                "realName='" + realName + '\'' +
                ", enterpriseAddress='" + enterpriseAddress + '\'' +
                ", enterprisePhone='" + enterprisePhone + '\'' +
                ", enterprisePerson='" + enterprisePerson + '\'' +
                ", enterpriseIndustry='" + enterpriseIndustry + '\'' +
                ", enterpriseScale='" + enterpriseScale + '\'' +
                ", enterpriseIntroduce='" + enterpriseIntroduce + '\'' +
                '}';
    }
}
