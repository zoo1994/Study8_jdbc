package com.sj.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sj.s1.util.DBConnector;

public class DepartmentDAO {
	// dao : data access object
	private DBConnector dbConnector;
	
	public DepartmentDAO() {
		dbConnector = new DBConnector();
	}
//전체조회
	public List<DepartmentDTO> getList() throws Exception {
		ArrayList<DepartmentDTO> al = new ArrayList<>();
		// select*from departments;
		// 1. db로그인
		Connection con = dbConnector.getConnect();
		// 2.sql query문 작성
		// JAVA에서는 ;제외
		String sql = "SELECT * FROM DEPARTMENTS";
		// 3 작성한 SQL QUERY에 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4 ? 값을 세팅, 없으면 통과
		// 5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		// 커셔가 한줄 읽는 메서드 next() 리턴은 데이터가 잇으면 true 없으면 false
		while (rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
			departmentDTO.setLocation_id(rs.getInt("location_id"));
			al.add(departmentDTO);
		}
		// 6외부연결해제
		// 연결된순서의 역순
		rs.close();
		st.close();
		con.close();
		return al;
	}
	
	//부서번호로 조회
	public DepartmentDTO getOne(DepartmentDTO dep) throws Exception {
		DepartmentDTO dd = null;
		//db로그인
		Connection con = dbConnector.getConnect(); 
		//쿼리명 작성
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
		//쿼리문 미리전송
		PreparedStatement st= con.prepareStatement(sql);
		// ?값을 세팅
		//st.set데이터타입 (int index, 값);
		//index는 ?의 순서번호
		//오라클은 1번부터 시작
		st.setInt(1,dep.getDepartment_id() );
		//최종 전송 후 결과처리
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			dd = new DepartmentDTO();
			dd.setDepartment_id(rs.getInt("department_id"));
			dd.setDepartment_name(rs.getString("department_name"));
			dd.setLocation_id(rs.getInt("location_id"));
			dd.setManager_id(rs.getInt("manager_id"));						
		}
		//외부연결해제
		rs.close();
		st.close();
		con.close();
		
		return dd;
		
	}
	
}
