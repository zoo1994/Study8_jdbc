package com.sj.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sj.s1.util.DBConnector;

public class DepartmentDAO {
	// dao : data access object
	private DBConnector dbConnector;

	public DepartmentDAO() {
		dbConnector = new DBConnector();
	}

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
}
