package com.Manager.exe;

import java.util.Scanner;

import com.Manager.service.Manager;
import com.Manager.service.ManagerDAO;
import com.Manager.service.ManagerService;
import com.Physical.service.PhysicalService;

public class ExeApp {
	PhysicalService ps = new PhysicalService();
	ManagerService ms = new ManagerService();
	Scanner sc = new Scanner(System.in);
	boolean run = true;
	String menu = "";
	

	public ExeApp() {
		run();
	}
	
//	MANAGER_ID   NOT NULL VARCHAR2(20) 
//	MANAGER_PW   NOT NULL VARCHAR2(20) 
//	MANAGER_NAME NOT NULL VARCHAR2(20) 
//	MANAGER_TELL          NUMBER(25) 
	
	

	private void run() {
		// 내정보 조회, 탈퇴, 수정
		// 회원조회, 등록, 탈퇴, 수정 + 로그인, 로그아웃
		// static -> 로그인 로그아웃 |프로그램 종료 or 로그아웃때까지 로그인 상태
		boolean run1 = true;
		while (run1) {
			// 1. 로그인이 되어 있을 때 메뉴
			if (ManagerService.managerInfo != null) {// 로그인 되었다.
				// 로그인 후 메뉴
				loginMenu();
			} else if (ManagerService.managerInfo == null) {// 로그인 안되었다.
				// 로그인 전 메뉴
				logoutMenu();
			}
			// 2. 로그인이 되어 있지 않을 때 메뉴
		}

	}

	// 마지막 로그인 전 메뉴.
	private void logoutMenu() {
		
		System.out.println("1. 로그인 | 2. 종료");
		System.out.println("입력 >");
		menu = sc.nextLine();
		if (menu.equals("1")) {
			ms.login();
		} else if (menu.equals("2")) {
			run = false;
			System.out.println("프로그램 종료");
		}
	}

	// 1) 로그인 후 메뉴.
	private void loginMenu() {
		

			while (true) {
				pmenu();

				
			}
		}

		private void pmenu() {
			// 참가자 전체 조회,  생존(등록), 탈락,  종료
			System.out.println("==================================================");
			System.out.println("1. PHYSICAL100 참가자 리스트 | 2. 게임[1] 시작 | 3. 생존자 조회 | 4. 탈락자 조회 | 5. 게임 [2] | 6.  종료 ");
			System.out.println("==================================================");
			System.out.println("입력>");
			menu = sc.nextLine();
			
			if (menu.equals("1")) {
			// 피지컬100 참가자 조회.
				ps.getPhy100List();
				
			} else if (menu.equals("2")) {
			// 조별 대진표 조회 => 게임[1] 실행.
				ps.Game1();
				
			} else if (menu.equals("3")) {
			// 생존자 조회 이후 winner table에 등록(Insert).
				ps.getPhy101();
				//ps.insertPhy100();
				
			} else if (menu.equals("4")) {
			// 탈락자 조회 => 삭제(Delete)
				ps.getPhy102();
				//ps.deletePhy102();
				
			} else if (menu.equals("5")) {
				// 게임 [2] 실행 => 최후의 1인 = 우승자 = 미스터 추.
				ps.Winner();
				
			} else {
				System.out.println(" 게임 종료 ");
				System.out.println("\n\n\n\n\n\n");
				//break;
			}
		}
		
		
		
		
		
		// 내정보조회, 탈퇴, 수정
//		System.out.println("==================================================");
//		System.out.println("== 1.조회 2.수정 3. 탈퇴 ==");
//		System.out.println("==================================================");
//		System.out.println("입력>");
//		menu = sc.nextLine();
//
//		switch (menu) {
//		case "1":
//			// 조회
//			ms.getManager();
//			break;
//		case "2":
//			// 수정
//			ms.modifyManager();
//			break;
//		case "3":
//			// 탈퇴
//			ms.deleteManager();
//			break;
//		case "4":
//			// 탈퇴
//		
//		case "5":
//			// 탈퇴
//			
//		case "6":
//			// 로그아웃
//			// 1ms.logout();
//			break;
//		}
//
	
	
	
	
	
	

	private void menu() {
		// 학생 정보 조회(전체, 단건), 등록, 제적, 전공 변경, 종료
		System.out.println("1. 전체 참가자 조회 | 2. 이름 조회 | 3. 등록 | " + "4. 삭제 | 5. 탈락 | 7. 종료");
		System.out.println("입력>");
		menu = sc.nextLine();
	}
}
