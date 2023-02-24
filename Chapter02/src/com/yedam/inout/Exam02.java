package com.yedam.inout;

import java.io.IOException;
import java.util.Scanner;



public class Exam02 {
	public static void main(String[] args) throws IOException {
		int keyCode;
		
		System.out.println("입력>");
		keyCode = System.in.read();
		System.out.println("keyCode :" + keyCode);
		
		System.out.println("입력>");
		keyCode = System.in.read();
		System.out.println("keyCode :" + keyCode);
		
		System.out.println("입력>");
		keyCode = System.in.read();
		System.out.println("keyCode :" + keyCode);
		
		//Scanner 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력>");
		
		String word = sc.nextLine();
		
		System.out.println(word);
		
		//문자열 데이터 비교, equals
		if(word.equals("test")) {
			System.out.println("equals");
		}
		if(word == "test") {
			System.out.println("==");
		}
		
	}
}
