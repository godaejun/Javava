package com.Physical.service;

// 패자 부활전
class ComBat  {
	public long DethMatch(int n) {
		long arr[] = new long[2001];

		arr[1] = 1;
		arr[2] = 2;

		for (int i = 3; i < 2001; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
		}
		return arr[n];

	}
}
// 등록
//public void insertPhy100() {
//	Phy100 phy100 = new Phy100();
//	System.out.println("이름>");
//	phy100.setPhy100Name(sc.nextLine());
//
//	int result = PhysicalDAO.getInstance().insertStd(phy100);
//
//	if (result > 0) {
//		System.out.println("생존자");
//
//	}
