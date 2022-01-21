package com.sj.s1.department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentView {

	public void view (List<DepartmentDTO>al) {
		
		for(int i=0; i<al.size();i++) {
			this.viewOne(al.get(i));
		}
		
	}
	
	public void viewOne(DepartmentDTO dd) {
		System.out.print(dd.getDepartment_id()+"\t");
		System.out.print(dd.getDepartment_name()+"\t");
		System.out.print(dd.getManager_id()+"\t");
		System.out.println(dd.getLocation_id());
		System.out.println("--------------------------------------------------");
	}

}
