/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assigment;

/**
 *
 * @author Admin
 */
public class NhanVien {
    String manv;
    String hoten;
    double luong;
    double thunhap;

    @Override
    public String toString() {
        return "NhanVien{" + "manv=" + manv + ", hoten=" + hoten + ", luong=" + luong + ", thunhap=" + getThunhap() + '}';
    }
    
    public NhanVien(String manv, String hoten, double luong) {
        this.manv = manv;
        this.hoten = hoten;
        this.luong = luong;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public double getThunhap() {
        if(getLuong()<9000000){
            thunhap=getLuong();
        } else if(getLuong()<=15000000){
            thunhap = getLuong()*0.9;
        } else thunhap=getLuong()*0.88;
        return thunhap;
    }
    
}
