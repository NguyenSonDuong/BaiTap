package com.group1.baitap;

public class NhanView {
    private String ma;
    private String ten;
    private int gioitinh;
    private boolean check;

    public NhanView() {
    }

    public NhanView(String ma, String ten, int gioitinh) {
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
