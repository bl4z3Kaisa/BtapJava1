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
public class TruongPhong extends NhanVien{
    double trachNhiem;
    public TruongPhong(double trachNhiem, String manv, String hoten, double luong) {
        super(manv, hoten, luong);
        this.trachNhiem = trachNhiem;
    }

    public void setTrachNhiem(double trachNhiem) {
        this.trachNhiem = trachNhiem;
    }
    
    public double getTrachNhiem() {
        return trachNhiem;
    }

    @Override
    public double getThunhap() {
        thunhap=getLuong()+getTrachNhiem();
        if(thunhap>=9000000 && thunhap<=15000000){
            thunhap=thunhap*0.9;
        }
        if(thunhap>15000000){
            thunhap=thunhap*0.88;
        }
        return thunhap;
    }
    

    @Override
    public String toString() {
        return "TruongPhong{" + "manv=" + manv + ", hoten=" + hoten + ", luong=" + luong + "trachNhiem=" + trachNhiem + ", thunhap=" + getThunhap() +  '}';
    }
    
}
