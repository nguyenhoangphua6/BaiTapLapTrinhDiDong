package com.midterm.lamnhom;

public class KhaiBao {
    private int id;
    private String name;
    private boolean sex;
    private String cccd;
    private String adress;
    private boolean camKet;


    public KhaiBao(int id, String name, boolean sex, String cccd, String adress, boolean camKet) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.cccd = cccd;
        this.adress = adress;
        this.camKet = camKet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isCamKet() {
        return camKet;
    }

    public void setCamKet(boolean camKet) {
        this.camKet = camKet;
    }
}
