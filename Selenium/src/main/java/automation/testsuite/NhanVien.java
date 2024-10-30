package automation.testsuite;

import java.util.ArrayList;
import java.util.List;

public class NhanVien {

	private List<String> danhSachNhanVien;

    // Constructor
    public NhanVien() {
        danhSachNhanVien = new ArrayList<>();
    }

    // Method to add employee name
    public void themNhanVien(String tenNhanVien) {
        danhSachNhanVien.add(tenNhanVien);
    }

    // Method to print employee names
    public void inDanhSachNhanVien() {
        System.out.println("Danh sách nhân viên:");
        for (String ten : danhSachNhanVien) {
            System.out.println(ten);
        }
    }
}
