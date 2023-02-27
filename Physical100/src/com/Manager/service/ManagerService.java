package com.Manager.service;

import java.util.Scanner;

public class ManagerService {

	Scanner sc = new Scanner(System.in);

	public static Manager managerInfo = null;

	//0.회원가입
			public void signup() {
				System.out.println("==== 회원가입 ====");
				Manager signup = new Manager();
				System.out.println("ID를 입력하세요");
				signup.setManagerId(sc.nextLine());
				System.out.println("PW를 입력하세요");
				signup.setManagerPw(sc.nextLine());
				System.out.println("이름을 입력하세요");
				signup.setManagerName(sc.nextLine());
				System.out.println("전화번호를 입력하세요 ex)010-0000-0000");
				signup.setManagerTel(sc.nextLine());
				
				int result = ManagerDAO.getInstance().signup(signup);
				
				if(result > 0) {
					System.out.println("회원가입 완료");
				}else {
					System.out.println("회원가입 실패");
				}
				}

	
	// 1.로그인
	public void login() {
		Manager manager = null;
		System.out.println("ID :");
		String manId = sc.nextLine();
		System.out.println("PW :");
		String manPw = sc.nextLine();

		manager = ManagerDAO.getInstance().login(manId);

		if (manager != null) {
			if (manager.getManagerPw().equals(manPw)) {
				System.out.println("============================================================================================");
				System.out.println("\n\n\n");
				System.out.println("\t \t \t \t ☜ (●'◡'●) 로그인 성공 (●'◡'●) ☞");
				System.out.println("\n\n\n");
				System.out.println( " 🙈🙉 " + manager.getManagerName() + "님 환영합니다 🙉🙈 ");
				managerInfo = manager;
			} else {
				System.out.println("비밀번호가 다릅니다.");
			}
		} else {
			System.out.println("회원 아이디가 존재하지 않습니다.");
		}
	}

	// 2.수정
	public void modifyManager() {
		Manager manager = new Manager();
		System.out.println("바꿀 전화번호>");
		String man = sc.nextLine();
		manager.setManagerTel(man);
		System.out.println("누구의? >");
		String name = sc.nextLine();
		manager.setManagerName(name);
		ManagerDAO.getInstance().modifyMember(manager);

		System.out.println("조회한 결과>");
		System.out.println(manager.toString());
	}

	// 3.삭제
	public void deleteManager() {
		System.out.println("이름 입력>");
		int result = ManagerDAO.getInstance().deleteManager(sc.nextLine());

		System.out.println("관리자 정보 삭제 완료");

	}

	// 관리자 아이디 조회
	public void getManager() {
		Manager manager = ManagerDAO.getInstance().getManager();
		System.out.println(manager.toString());
	}

	
		
	

}
