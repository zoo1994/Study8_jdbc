package com.sj.s1.department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentView {

	public void view (List<DepartmentDTO>al) {
		
		for(int i=0; i<al.size();i++) {
			System.out.print(al.get(i).getDepartment_id()+"\t");
			System.out.print(al.get(i).getDepartment_name()+"\t");
			System.out.print(al.get(i).getManager_id()+"\t");
			System.out.println(al.get(i).getLocation_id());
			System.out.println("---------------------------------------------");
		}
		
	}

}
