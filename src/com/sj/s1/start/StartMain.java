package com.sj.s1.start;

import java.util.List;

import com.sj.s1.department.DepartMentController;
import com.sj.s1.department.DepartmentDAO;
import com.sj.s1.department.DepartmentDTO;
import com.sj.s1.department.DepartmentView;
import com.sj.s1.location.LocationController;
import com.sj.s1.location.LocationDAO;
import com.sj.s1.location.LocationDTO;
import com.sj.s1.location.LocationView;
import com.sj.s1.util.DBConnector;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트 시작");
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DepartmentView departmentView = new DepartmentView();
		DepartMentController dc = new DepartMentController();
		LocationView lv = new LocationView();
		LocationDAO ld = new LocationDAO();
		LocationController lc = new LocationController();
		
		try {
			lc.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("DB 연동 테스트 끝");
	}

}
