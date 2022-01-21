package com.sj.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sj.s1.util.DBConnector;

public class LocationDAO {

	private DBConnector dbConnector;

	public LocationDAO() {
		dbConnector = new DBConnector();
	}

	public List<LocationDTO> getList() throws Exception {
		// 1 db 로그인
		// 2. sql 쿼리문 작성
		// 3. 뭐리분 미리 전송
		// 4 ? 값을 세팅, 없으면 통과
		// 5. 최종 전송 후 결과 처리
		// 6. 연결해제

		ArrayList<LocationDTO>al = new ArrayList<>();
		
		Connection con = dbConnector.getConnect(); //1번
		
		String sql = "select * from locations"; //2번
		
		PreparedStatement ps = con.prepareStatement(sql); //3번

		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			LocationDTO ld = new LocationDTO();
			ld.setLocation_id(rs.getInt("location_id"));
			ld.setStreet_address(rs.getString("street_address"));
			ld.setPostal_code(rs.getString("postal_code"));
			ld.setCity(rs.getString("city"));
			ld.setState_province(rs.getString("state_province"));
			ld.setCountry_id(rs.getString("country_id"));
			
			al.add(ld);
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return al;

	}
	
	public LocationDTO getListOne(LocationDTO ld) throws Exception {
		ld= null;
		Connection com = dbConnector.getConnect();
		String sql = "select*from locations where location_id = ?";
		PreparedStatement ps = com.prepareStatement(sql);
		ps.setInt(1, ld.getLocation_id());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			ld= new LocationDTO();
			ld.setLocation_id(rs.getInt("location_id"));
			ld.setStreet_address(rs.getString("street_address"));
			ld.setPostal_code(rs.getString("postal_code"));
			ld.setCity(rs.getString("city"));
			ld.setState_province(rs.getString("state_province"));
			ld.setCountry_id(rs.getString("country_id"));			
		}
		rs.close();
		ps.close();
		com.close();
		return ld;
	}

}
