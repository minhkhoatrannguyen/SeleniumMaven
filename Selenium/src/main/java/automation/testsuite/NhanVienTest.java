package automation.testsuite;

import org.testng.annotations.*;

public class NhanVienTest {

	@Test
	public void NhanVienTest() {
		NhanVien nhanVien = new NhanVien();

        // Add employee names to the list
        nhanVien.themNhanVien("Nguyen Van A");
        nhanVien.themNhanVien("Tran Thi B");
        nhanVien.themNhanVien("Le Van C");

        // Print the list of employee names
        nhanVien.inDanhSachNhanVien();
	}

}
