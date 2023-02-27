package com.Physical.exe;

import java.util.Scanner;

import com.Physical.service.PhysicalService;

public class ExeApp {
	
	
	private String menu = null;
	private Scanner sc = new Scanner(System.in);
	private PhysicalService ps = new PhysicalService();

	public void run() {

		while (true) {
			menu();

			
		}
	}

	private void menu() {
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
}
