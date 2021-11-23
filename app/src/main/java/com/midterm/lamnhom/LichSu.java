package com.midterm.lamnhom;

public class LichSu {
    private String cccd;
    private String diaDiem;
    private String thoiGian;
    private String phuongTien;

    public LichSu(String cccd, String diaDiem, String thoiGian, String phuongTien) {
        this.cccd = cccd;
        this.diaDiem = diaDiem;
        this.thoiGian = thoiGian;
        this.phuongTien = phuongTien;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getPhuongTien() {
        return phuongTien;
    }

    public void setPhuongTien(String phuongTien) {
        this.phuongTien = phuongTien;
    }
}
