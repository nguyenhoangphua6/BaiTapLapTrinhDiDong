package com.midterm.lamnhom.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class LichSu implements Serializable {
    private String cccd;
    private String diaDiem;
    private String thoiGian;
    private String phuongTien;

    public LichSu(String cccd, String diaDiem,  String phuongTien, String thoiGian) {
        this.cccd = cccd;
        this.diaDiem = diaDiem;
        this.thoiGian = thoiGian;
        this.phuongTien = phuongTien;
    }


    @NonNull
    @Override
    public String toString() {
        String s = "------- \n" +
                   "       Thời gian: " + thoiGian + ";\n" +
                   "       Địa điểm : " + diaDiem + ";\n" +
                   "       Phương tiện: " + phuongTien + ";\n" +
                   "-------";


           //     s = "Thời gian: " +thoiGian + ";\n" + "Địa điểm: " + diaDiem + ";\n" + "Phương tiện: " + phuongTien + ".";
        return s;
    }

    public LichSu() {
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
