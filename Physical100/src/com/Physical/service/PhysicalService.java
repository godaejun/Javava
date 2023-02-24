package com.Physical.service;

import java.util.List;
import java.util.Scanner;

public class PhysicalService {
	public static Phy100 PhysicalInfo = null;

	Scanner sc = new Scanner(System.in);

	// 참가자 리스트(전체조회)
	public void getPhy100List() {
		List<Phy100> list = PhysicalDAO.getInstance().getPhy100List();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
			System.out.println();
		}

		// 미션(게임) 시작 !!
		System.out.println("======= 미션이 시작됩니다. ========");
		System.out.println("이번 미션은 참호 전투 입니다.");
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			if (max < list.get(i).getPhy100Power()) {
				max = list.get(i).getPhy100Power();
			}
			
		}
		System.out.println("===승리===");
		System.out.println("===생존===");
		
		System.out.println("===패배===");
		System.out.println("===탈락===");

	}

//		int min = 0;
//		for (int j = 0; j < list.size(); j++) {
//			if (min > list.get(j)getPhy100Power()) {
//				min = list.get(j)getPhy100Power();
//			}
//		}
	
	// 단건조회 !!
//	public void getPhy100() {
//		System.out.println("이름 입력 >");
//		phy100 = (sc.nextLine());
//		System.out.println(phy100.toString());
//		
//	}

	// 탈락 !!
	public void deletePhy100() {
		System.out.println("====탈락회원===>");
		System.out.println("이름 입력 > ");
		String phy100 = (sc.nextLine());

		int result = PhysicalDAO.getInstance().deletePhy100(sc.nextLine());

		if (result > 0) {

			System.out.println("탈락 ");
		} else {
			System.out.println("생존");
		}
	}

	// 패자 부활전 게임

	// 등록? !! 패자부활전에서 생존시
	public void insertPhy100() {
		Phy100 phy100 = new Phy100();
		System.out.println("이름>");
		phy100.setPhy100Name(sc.nextLine());

		int result = PhysicalDAO.getInstance().insertPhy100(phy100);

		if (result > 0) {
			System.out.println("생존자");

		}

	}
	// 정보 수정
//		public void modifyPhysical() {
//			
//			System.out.println("이름>");
//			Physical phy100 = new Physical();
//			phy100.setPhy100Id(sc.nextLine());
//			System.out.println("이름>");
//			phy100.setPhy100Name(sc.nextLine());
//			
//			
//			int result = PhysicalDAO.getInstance().updatePhy100(phy100);
//			
//			if(result>0) {
//				System.out.println("이름 수정 완료");
//			}else {
//				System.out.println("이름 수정 실패");
//			}

}
