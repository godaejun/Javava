package com.Physical.service;

import java.util.List;
import java.util.Scanner;

public class PhysicalService {
	public static Phy100 PhysicalInfo = null;

	Scanner sc = new Scanner(System.in);

	// 1) 참가자 리스트(전체조회)
	public void getPhy100List() {
		System.out.println(" \n \n ");
		List<Phy100> list = PhysicalDAO.getInstance().getPhy100List();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
			System.out.println();
			System.out.println(" \n ");
		}
		System.out
				.println("============================= [ QUEST 1 : 고대 신화 5종 경기 ] ==================================");
		System.out.println(" \n \n");
		System.out.println("                       📢 첫번째 QUEST 가 시작됩니다 모두 준비해주세요 📢");
		System.out.println(" \n \n ");
		System.out.println("============================================================================================");
		
	}

	// 2) 퀘스트 1.

	public void Game1() {
		Phy100 phy100 = null;
		System.out.println("============================================================================================");
		System.out.println(" \n \n");
		System.out.println("                           📢 첫번째 QUEST 종료 📢 " );
		System.out.println(" \n \n");
		System.out.println("================================= [ 순위 발표 ] ===============================================");
		System.out.println(" \n \n");		
//			System.out.println("이름 입력 >");
//			String str = sc.nextLine();
		List<Phy100> list = PhysicalDAO.getInstance().Game1();

		// phy100.setPhy100Group(sc.nextLine());
		// System.out.println(phy100.toString());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(" RANK " + list.get(i).getRank() + "\t \t" + "정보 " + list.get(i).getPhy100Info() + "\t"
					+ "전투력 " + list.get(i).getPhy100Power() + " \t 조 : " + list.get(i).getPhy100Group() + " \t이름 "
					+ list.get(i).getPhy100Name());
			
		System.out.println(" \n ");
		}
		System.out.println("============================================================================================");
		System.out.println(" \n \n");
		
		

	}

	// 3) 생존자 조회 이후 !!
	public void getPhy101() {
		System.out.println("===================================[ 생존한 플레이어 ]===============================================");
		System.out.println(" \n \n");
		Phy100 phy100 = null;
		System.out.println(" 생존자 >");
		List<Phy100> list = PhysicalDAO.getInstance().getPhy101();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("이름 : " + list.get(i).getPhy100Name() + "  정보 : " + list.get(i).getPhy100Info()
					+ "\t전투력 : " + list.get(i).getPhy100Power() + "\t조 : " + list.get(i).getPhy100Group() + "\t 생존 "
					+ list.get(i).getPhy100Survival());
			System.out.println(" \n ");
		}
	}

	// 4) 탈락자 조회 => 삭제 !!
	public void getPhy102() {
		System.out.println(" \n \n");
		System.out.println("===================================[ 탈락한 플레이어 ]===================================================");
		System.out.println(" \n \n");
		Phy100 phy100 = null;
		System.out.println("탈락자 >");
		List<Phy100> list = PhysicalDAO.getInstance().getPhy102();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("이름 : " + list.get(i).getPhy100Name() + "  정보 : " + list.get(i).getPhy100Info()
					+ "\t전투력 : " + list.get(i).getPhy100Power() + "\t조 : " + list.get(i).getPhy100Group() + "\t 생존 "
					+ list.get(i).getPhy100Survival());
			System.out.println(" \n ");
		}
	}
	
//	// ) 탈락 !!
	public void deletePhy100() {
		
		System.out.println("이름 입력 > ");
		String phy100 = (sc.nextLine());

		int result = PhysicalDAO.getInstance().deletePhy100(sc.nextLine());

		if (result > 0) {

			System.out.println("탈락 [DEATH] ");
		} else {
			System.out.println("생존 [LIFE] ");
		}
		
	}
	

	// 5) 게임2. 결승전 참호전투 => 종료 !!

// 메인문 안에 사용가능 게임[2] 참호전   
//	int max = 0;
//		for (int i = 0; i < list.size(); i++) {
//			if (max < list.get(i).getPhy100Power()) {
//				max = list.get(i).getPhy100Power();
//			
	public void Winner() {
		System.out.println(" \n \n \n \n");
		Phy100 phy100 = null;
		System.out.println("============================================================================================");
		System.out.println(" \n ");
		System.out.println(" \t \t \t 🔥🔥 PHYSICAL 100 우승 🔥🔥    ");
		System.out.println(" \t \t \t ༼ つ ◕_◕ ༽つ📣 최후의 1인 !!  ");
		System.out.println(" \n ");
		System.out.println("============================================================================================");
		System.out.println(" \n \n");
		List<Phy100> list = PhysicalDAO.getInstance().Winner();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("이름 : " + list.get(i).getPhy100Name() + "  정보 : " + list.get(i).getPhy100Info()
					+ "\t전투력 : " + list.get(i).getPhy100Power() + "\t조 : " + list.get(i).getPhy100Group() + "\t 생존 "
					+ list.get(i).getPhy100Survival());
		System.out.println(" \n \n");
		}
	}

//	
//	
//
//	// ) 게임 2 !!
//
//	// 등록? !! 패자부활전에서 생존 = Life, 탈락 = Death.
//	public void insertWinner() {
//		Winner win = new Winner();
//		System.out.println("이름>");
//		win.setPhy100Name(sc.nextLine());
//
//		int result = PhysicalDAO.getInstance().insertWinner(win);
//
//		if (result > 0) {
//			System.out.println("생존자");
//
//		}
//
//	}
//	
//	// 정보 수정
////		public void modifyPhysical() {
////			
////			System.out.println("이름>");
////			Physical phy100 = new Physical();
////			phy100.setPhy100Id(sc.nextLine());
////			System.out.println("이름>");
////			phy100.setPhy100Name(sc.nextLine());
////			
////			
////			int result = PhysicalDAO.getInstance().updatePhy100(phy100);
////			
////			if(result>0) {
////				System.out.println("이름 수정 완료");
////			}else {
////				System.out.println("이름 수정 실패");
////			}
//
//}
}
