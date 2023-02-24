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

			if (menu.equals("1")) {
				// 전체 참가자 조회
				//ss.getPhy100();
			} else if (menu.equals("2")) {
				// 아이디 조회
				//ss.getPhy100();
			} else if (menu.equals("3")) {
				// 등록
				ps.insertPhy100();
			} else if (menu.equals("4")) {
				// 탈락
				ps.deletePhy100();
			} else {
				System.out.println("end of Mission");
				break;
			}
		}
	}

	private void menu() {
		// 참가자 전체 조회,  생존(등록), 탈락,  종료
		System.out.println("1. 전체 참가자 조회 | 2. 참가자 등록 | 3. 탈락 | 4. 종료| ");
		System.out.println("입력>");
		menu = sc.nextLine();
	}
}
