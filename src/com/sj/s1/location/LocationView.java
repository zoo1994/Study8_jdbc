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
			this.locationViewOne(al.get(i));
		}
	}
	
	public void locationViewOne(LocationDTO ld) {
		System.out.print(ld.getLocation_id()+"\t");
		System.out.print(ld.getStreet_address()+"\t");
		System.out.print(ld.getPostal_code()+"\t");
		System.out.print(ld.getCity()+"\t");
		System.out.print(ld.getState_province()+"\t");
		System.out.println(ld.getCountry_id());
		System.out.println("-------------------------------------------------");
	}
}
