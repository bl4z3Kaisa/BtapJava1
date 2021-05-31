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
public class TiepThi extends NhanVien{
    double doanhSo;
    double hoaHong;
    public TiepThi(double doanhSo, double hoaHong, String manv, String hoten, double luong) {
        super(manv, hoten, luong);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }

    @Override
    public String toString() {
        return "TiepThi{" + "manv=" + manv + ", hoten=" + hoten + ", luong=" + luong  + ", hoaHong=" + hoaHong + "doanhSo=" + doanhSo + ", thunhap=" + getThunhap() + '}';
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getHoaHong() {
        return hoaHong;
    }

    public void setHoaHong(double hoaHong) {
        this.hoaHong = hoaHong;
    }

    @Override
    public double getThunhap() {
        thunhap=getLuong()+getHoaHong()+getDoanhSo();
        if(thunhap>=9000000 && thunhap<=15000000){
            thunhap=thunhap*0.9;
        }
        if(thunhap>15000000){
            thunhap=thunhap*0.88;
        }
        return thunhap;
    }
    
}
