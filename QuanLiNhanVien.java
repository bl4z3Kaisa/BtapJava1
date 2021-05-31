/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assigment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class QuanLiNhanVien {

    Scanner sc = new Scanner(System.in);
    ArrayList<NhanVien> ListNV = new ArrayList<>();

    public void menu() {
        while (true) {
            System.out.println("+===========================MENU==============================+");
            System.out.println("|1. Nhập danh sách nhân viên từ bàn phím                      |");
            System.out.println("|2. Xuất danh sách nhân viên ra màn hình                      |");
            System.out.println("|3. Tìm và hiển thị nhân viên theo mã nhập từ bàn phím        |");
            System.out.println("|4. Xóa nhân viên theo mã nhập từ bàn phím                    |");
            System.out.println("|5. Cập nhật thông tin nhân viên theo mã nhập từ bàn phím     |");
            System.out.println("|6. Tìm các nhân viên theo khoảng lương nhập từ bàn phím      |");
            System.out.println("|7. Sắp xếp nhân viên theo họ và tên                          |");
            System.out.println("|8. Sắp xếp nhân viên theo thu nhập                           |");
            System.out.println("|9. Xuất 5 nhân viên có thu nhập cao nhất                     |");
            System.out.println("|0. Thoát                                                     |");
            System.out.println("+=============================================================+");
            System.out.print("Nhập lựa chọn: ");
            int luachon = Integer.parseInt(sc.nextLine());
            switch (luachon) {
                case 1:
                    nhap();
                    break;
                case 2:
                    xuat();
                    break;
                case 3:
                    tim();
                    break;
                case 4:
                    xoa();
                    break;
                case 5:
                    sua();
                    break;
                case 6:
                    timluong();
                    break;
                case 7:
                    xepten();
                    break;
                case 8:
                    xeptn();
                    break;
                case 9:
                    xuat5();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập lại đê!!");
                    break;
            }
        }

    }

    public void nhap() {
        while (true) {
            System.out.print("Nhập mã nhân viên: ");
            String id = sc.nextLine();
            try {
                if (kiemtra(id) == true) {
                    System.out.println("Mã đã tồn tại! Nhập lại!");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Lỗi nhập mã");
            }
            System.out.print("Nhập tên nhân viên: ");
            String name = sc.nextLine();
            System.out.print("Nhập lương nhân viên: ");
            double luong = Double.parseDouble(sc.nextLine());
            System.out.println("1. Trưởng phòng");
            System.out.println("2. Tiếp thị");
            System.out.println("0. Nhân viên bình thường");
            System.out.print("Nhập chức vụ: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.print("Nhập trách nhiệm: ");
                    double tn = Double.parseDouble(sc.nextLine());
                    TruongPhong tp = new TruongPhong(tn, id, name, luong);
                    ListNV.add(tp);
                    break;
                case 2:
                    System.out.print("Nhập doanh số: ");
                    double ds = Double.parseDouble(sc.nextLine());
                    System.out.print("Nhập hoa hồng: ");
                    double hh = Double.parseDouble(sc.nextLine());
                    TiepThi tt = new TiepThi(ds, hh, id, name, luong);
                    ListNV.add(tt);
                    break;
                case 0:
                    NhanVien nv = new NhanVien(id, name, luong);
                    ListNV.add(nv);
                    break;
                default:
                    System.out.println("Nhập sai vui lòng nhập lại");
                    nhap();
                    break;
            }
            System.out.print("Nhập tiếp(Y/N)?: ");
            if (sc.nextLine().equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public void xuat() {
        if (ListNV.isEmpty()) {
            System.out.println("Danh sách trống vui lòng nhập dữ liệu");
        } else {
            for (NhanVien xxx : ListNV) {
                System.out.println(xxx);
            }
        }
    }

    public void tim() {
        if (ListNV.isEmpty()) {
            System.out.println("Danh sách trống vui lòng nhập dữ liệu");
        } else {
            System.out.print("Nhập mã nhân viên: ");
            String m = sc.nextLine();
            for (NhanVien xxx : ListNV) {
                if (xxx.getManv().equalsIgnoreCase(m)) {
                    System.out.println(xxx);
                }
            }
        }
    }

    public void xoa() {
        if (ListNV.isEmpty()) {
            System.out.println("Danh sách trống vui lòng nhập dữ liệu");
        } else {
            System.out.print("Nhập mã nhân viên cần xoá: ");
            String m = sc.nextLine();
            int index = -1;
            for (int i = 0; i < ListNV.size(); i++) {
                if (ListNV.get(i).getManv().equalsIgnoreCase(m)) {
                    index = i;
                }
            }
            if (index == -1) {
                System.out.println("Không tồn tại nhân viên này!!");
            } else {
                ListNV.remove(index);
                System.out.println("Nhân viên đã được xoá");
            }
        }
    }

    public void sua() {
        if (ListNV.isEmpty()) {
            System.out.println("Danh sách trống vui lòng nhập dữ liệu");
        } else {
            System.out.print("Nhập mã nhân viên cần sửa: ");
            String m = sc.nextLine();
            int i = 0;
            int count = 0;
            for (NhanVien xxx : ListNV) {
                if (xxx.getManv().equalsIgnoreCase(m)) {
                    System.out.print("Nhập tên nhân viên mới: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập lương nhân viên mới: ");
                    double luong = Double.parseDouble(sc.nextLine());
                    System.out.println("1. Trưởng phòng");
                    System.out.println("2. Tiếp thị");
                    System.out.println("0. Nhân viên bình thường");
                    System.out.print("Nhập chức vụ mới: ");
                    int choose = Integer.parseInt(sc.nextLine());
                    switch (choose) {
                        case 1:
                            System.out.print("Nhập trách nhiệm: ");
                            double tn = Double.parseDouble(sc.nextLine());
                            TruongPhong tp = new TruongPhong(tn, m, name, luong);
                            ListNV.set(i, tp);
                            break;
                        case 2:
                            System.out.print("Nhập doanh số: ");
                            double ds = Double.parseDouble(sc.nextLine());
                            System.out.print("Nhập hoa hồng: ");
                            double hh = Double.parseDouble(sc.nextLine());
                            TiepThi tt = new TiepThi(ds, hh, m, name, luong);
                            ListNV.set(i, tt);
                            break;
                        case 0:
                            NhanVien nv = new NhanVien(m, name, luong);
                            ListNV.set(i, nv);
                            break;
                        default:
                            System.out.println("Nhập sai vui lòng nhập lại!!");
                            sua();
                            break;
                    }
                }
                i++;
                count++;
            }
            if (count == 0) {
                System.out.println("Không tồn tại nhân viên này!");
            } else {
                System.out.println("Sửa hoàn tất!!");
            }
        }
    }

    public void timluong() {
        if (ListNV.isEmpty()) {
            System.out.println("Danh sách trống vui lòng nhập dữ liệu");
        } else {
            int i = 0;
            System.out.print("Nhập mức lương tối thiểu: ");
            double min = Double.parseDouble(sc.nextLine());
            System.out.println("Nhập mức lương tối đa");
            double max = Double.parseDouble(sc.nextLine());
            for (NhanVien xxx : ListNV) {
                if (xxx.getLuong() >= min && xxx.getLuong() <= max) {
                    System.out.println(xxx);
                }
                i++;
            }
            if (i == 0) {
                System.out.println("Không tồn tại nhân viên này!!");
            }
        }
    }

    public void xepten() {
        if (ListNV.isEmpty()) {
            System.out.println("Danh sách trống vui lòng nhập dữ liệu");
        } else {
            Collections.sort(ListNV, new Comparator<NhanVien>() {
                @Override
                public int compare(NhanVien t1, NhanVien t2) {
                    return (t1.getHoten().compareTo(t2.getHoten()));
                }
            });
            System.out.println("Danh sách sau khi sắp sếp là: ");
            for (NhanVien xxx : ListNV) {
                System.out.println(xxx);
            }
        }
    }

    public void xeptn() {
        if (ListNV.isEmpty()) {
            System.out.println("Danh sách trống vui lòng nhập dữ liệu");
        } else {
            Collections.sort(ListNV, (a, b) -> Double.compare(b.getThunhap(), a.getThunhap()));
            System.out.println("Danh sách sau khi sắp xếp: ");
            for (NhanVien xxx : ListNV) {
                System.out.println(xxx);
            }
        }
    }

    public void xuat5() {
        if (ListNV.isEmpty()) {
            System.out.println("Danh sách trống vui lòng nhập dữ liệu");
        } else {
            xeptn();
            if (ListNV.size() < 5) {
                System.out.println("Không đủ 5 nhân viên. Đây là toàn bộ só lượng nhân viên!!");
                for (NhanVien xxx : ListNV) {
                    System.out.println(xxx);
                }
            } else {
                System.out.println("5 nhân viên có thu nhập cao nhất là: ");
                for (int i = 0; i < 5; i++) {
                    System.out.println(ListNV.get(i));
                }
            }
        }
    }

    public boolean kiemtra(String x) {
        boolean kiemtra = false;
        for (int i = 0; i < ListNV.size(); i++) {
            if (ListNV.get(i).getManv().equals(x)) {
                kiemtra = true;
            }
        }
        return kiemtra;
    }
}
