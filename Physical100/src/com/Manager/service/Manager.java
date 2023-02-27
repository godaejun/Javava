package com.Manager.service;

public class Manager {

//	MANAGER_ID   NOT NULL VARCHAR2(20) 
//	MANAGER_PW   NOT NULL VARCHAR2(20) 
//	MANAGER_NAME NOT NULL VARCHAR2(20) 
//	MANAGER_TELL          NUMBER(15)
	
	private String managerId;
	private String managerPw;
	private String managerName;
	private String managerTel;
	

	
		
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

	public String getManagerTel() {
		return managerTel;
	}

	public void setManagerTel(String managerTel) {
		this.managerTel = managerTel;
	}


	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerPw=" + managerPw + ", managerName=" + managerName
				+ ", managerTel=" + managerTel + "]";
	}
	
	
}
