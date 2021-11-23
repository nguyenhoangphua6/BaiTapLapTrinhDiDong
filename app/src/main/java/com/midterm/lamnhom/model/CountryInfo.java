package com.midterm.lamnhom.model;

import com.google.gson.annotations.SerializedName;

public class CountryInfo {
    private int _id;
    private String iso2;
    private String iso3;
    private int lat;
    @SerializedName("long")
    private float _long;
    private String flag;

    public CountryInfo(int _id, String iso2, String iso3, int lat, float _long, String flag) {
        this._id = _id;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.lat = lat;
        this._long = _long;
        this.flag = flag;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public float get_long() {
        return _long;
    }

    public void set_long(float _long) {
        this._long = _long;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
