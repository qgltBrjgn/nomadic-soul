package com.nomadicsoulmgl.nomadicsoul.bean;

public class ConnectionInfoBean {
    private String connectionIpUrl;
    private String nation;
    private String province;
    private String city;
    private String adcode;
    private Long lat;
    private Long lang;

    private Long id;

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public Long getLat() {
        return lat;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    public Long getLang() {
        return lang;
    }

    public void setLang(Long lang) {
        this.lang = lang;
    }

    public String getConnectionIpUrl() {
        return connectionIpUrl;
    }

    public void setConnectionIpUrl(String connectionIpUrl) {
        this.connectionIpUrl = connectionIpUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
