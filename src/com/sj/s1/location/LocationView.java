package com.sj.s1.location;

import java.util.List;

public class LocationView {
//	location_id;
//	 street_address;
//	postal_code;
//	 city;
//	state_province;
//country_id;

	public void locationView(List<LocationDTO>al) {
		for(int i = 0; i<al.size();i++) {
			System.out.print(al.get(i).getLocation_id()+"\t");
			System.out.print(al.get(i).getStreet_address()+"\t");
			System.out.print(al.get(i).getPostal_code()+"\t");
			System.out.print(al.get(i).getCity()+"\t");
			System.out.print(al.get(i).getState_province()+"\t");
			System.out.println(al.get(i).getCountry_id());
			System.out.println("----------------------------------------");
		}
	}
}
