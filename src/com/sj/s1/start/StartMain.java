package com.sj.s1.start;

import java.util.List;

import com.sj.s1.department.DepartmentDAO;
import com.sj.s1.department.DepartmentDTO;
import com.sj.s1.department.DepartmentView;
import com.sj.s1.location.LocationDAO;
import com.sj.s1.location.LocationDTO;
import com.sj.s1.location.LocationView;
import com.sj.s1.util.DBConnector;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트 시작");
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DepartmentView departmentView = new DepartmentView();
		LocationView lv = new LocationView();
		LocationDAO ld = new LocationDAO();
		try {
			List<DepartmentDTO> al = departmentDAO.getList();
			departmentView.view(al);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<LocationDTO>ldd = ld.getList();
			lv.locationView(ldd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		System.out.println("DB 연동 테스트 끝");
	}

}
