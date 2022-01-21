package com.sj.s1.location;

import java.util.Scanner;

public class LocationController {
	
	private Scanner sc;
	private LocationView lv;
	private LocationDAO ld;
	private LocationDTO ldt;
	
	public LocationController(){
		sc = new Scanner(System.in);
		lv = new LocationView();
		ld = new LocationDAO();
		ldt = new LocationDTO();
	}
	
	public void start() throws Exception {
		boolean cheak = true;
		ldt = null;
		while(cheak) {
			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서 번호 검색");
			System.out.println("3. 종료");
			int select = sc.nextInt();
			
			if (select ==1) {			
					ld.getList();
					lv.locationView(ld.getList());		
				
			}else if (select ==2) {
				System.out.println("검색할 부서명을 입력하세요");
				ldt = new LocationDTO();
				ldt.setLocation_id(sc.nextInt());
				ldt = ld.getListOne(ldt);	
				if(ldt==null) {
					System.out.println("검색한 부서명이 없습니다.");
					continue;
				}else {
					lv.locationViewOne(ldt);
				}
				
			}else {
				cheak = false;
			}
			
		}
		
		
	}

}
