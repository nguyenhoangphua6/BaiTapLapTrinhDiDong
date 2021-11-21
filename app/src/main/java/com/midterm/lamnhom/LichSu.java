package com.midterm.lamnhom;

public class LichSu {
    private int id;
    private String diaDiem;
    private String thoiGian;
    private String phuongTien;

    public LichSu(int id, String diaDiem, String thoiGian, String phuongTien) {
        this.id = id;
        this.diaDiem = diaDiem;
        this.thoiGian = thoiGian;
        this.phuongTien = phuongTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
