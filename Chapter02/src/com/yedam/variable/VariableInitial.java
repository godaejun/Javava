package com.yedam.variable;

public class VariableInitial {
public static void main(String[] args) {
	//변수 value
	int value = 10;
	
	int result = value + 10;
	System.out.println(result);
	
	//연산식, 출력문
	int hour =5;
	int minute = 3;
	
	//출력문
	System.out.println(hour + "시간" + minute + "분");
	
	//연산식
	int totalMinute = (hour*60) + minute;
	System.out.println("총" + totalMinute + "분");
	
	//변수 교환
	// x => 10 y =>3
	int x =3;
	int y = 10;
	int z;
	
	System.out.println("x :" + x +", y : " + y);
	//1) x의 데이터 -> z에 담아준다. x=3, z=3
	z = x;
	//2) y의 데이터 -> x에 담아준다. x=10, y=10
	x = y;
	//3) z(x)의 데이터 -> y에 담아준다. y=3, z=3
	y = z;
	
	System.out.println("x :" + x +", y : " + y);
	
	//번수의 사용 범위(Scope)
	
	int v1 = 15;
	
	if(v1 > 10) {
		int v2;
		v2 = v1 - 10;
	}
	
	//int v3 = v1 + v2 +5;
}	
	//v1 = 5;
	
	
	
	

}
