package com.Manager.service;

public class Manager {

//	MANAGER_ID   NOT NULL VARCHAR2(20) 
//	MANAGER_PW   NOT NULL VARCHAR2(20) 
//	MANAGER_NAME NOT NULL VARCHAR2(20) 
//	MANAGER_TELL          NUMBER(15)
	
	private String managerId;
	private String managerPw;
	private String managerName;
	private int managerTell;
	

	
		
	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerPw() {
		return managerPw;
	}

	public void setManagerPw(String managerPw) {
		this.managerPw = managerPw;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getManagerTell() {
		return managerTell;
	}

	public void setManagerTell(int managerTell) {
		this.managerTell = managerTell;
	}


	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerPw=" + managerPw + ", managerName=" + managerName
				+ ", managerTell=" + managerTell + "]";
	}
	
	
}
