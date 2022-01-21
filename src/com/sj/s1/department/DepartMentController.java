package com.sj.s1.department;

import java.util.List;
import java.util.Scanner;

public class DepartMentController {
	private DepartmentDAO departmentDAO;
	private DepartmentView departmentView;
	private Scanner sc;
	
	public DepartMentController() {
		
		departmentDAO = new DepartmentDAO();
		departmentView = new DepartmentView();
		sc = new Scanner(System.in);
		
	}
	
	
	public void start() throws Exception {
		boolean flag = true ;
		DepartmentDTO departmentDTO = null;
		while(flag) {
			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서 번호 검색");
			System.out.println("3. 종료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1 :
				List<DepartmentDTO> al = departmentDAO.getList();
				departmentView.view(al);
				break;
			case 2 :
				System.out.println("검색할 부서 번호 입력하세요");
				departmentDTO= new DepartmentDTO();
				departmentDTO.setDepartment_id(sc.nextInt());
				departmentDTO = departmentDAO.getOne(departmentDTO);
				if (departmentDTO==null) {
					System.out.println("부서번호가 틀렸습니다.");
					break;
				}else {
					departmentView.viewOne(departmentDTO);
				}
				break;
			default :
				flag = false;
			}						
		}		
	}
}
