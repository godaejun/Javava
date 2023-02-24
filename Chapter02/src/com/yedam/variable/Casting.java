package com.yedam.variable;

public class Casting {
	public static void main(String[] args) {
		int iVar = 65;
		byte bVar = (byte)iVar;
		System.out.println(bVar);
		
		char cVar = (char)iVar;
		System.out.println(cVar);
		
		//실수 -> 정수 강제 타입 변환
		double dVar = 3.14444;
		iVar = (int) dVar;
		System.out.println(iVar);
		//자동 타입 변환
		dVar = iVar;
		System.out.println(dVar);
		
		
		
	}
}
