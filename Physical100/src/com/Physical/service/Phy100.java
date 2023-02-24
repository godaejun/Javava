package com.Physical.service;

public class Phy100 {
//	PHY100_ID     NOT NULL VARCHAR2(20) 
//	PHY100_NAME   NOT NULL VARCHAR2(15) 
//	PHY100_IMPO            VARCHAR2(30) 
//	PHY100_HEIGHT          NUMBER(10)   
//	PHY100_WEIGHT          NUMBER(10)   
//	PHY100_POWER           NUMBER(10)   
//	PHY100_GRADE           VARCHAR2(1)
	
	private String phy100Id;
	private String phy100Name;
	private String phy100Impo;
	private int phy100Height;
	private int phy100Weight;
	private int phy100Power;
	private String phy100Grade;
	
	public String getPhy100Id() {
		return phy100Id;
	}
	public void setPhy100Id(String phy100Id) {
		this.phy100Id = phy100Id;
	}
	public String getPhy100Name() {
		return phy100Name;
	}
	public void setPhy100Name(String phy100Name) {
		this.phy100Name = phy100Name;
	}
	public String getPhy100Impo() {
		return phy100Impo;
	}
	public void setPhy100Impo(String phy100Impo) {
		this.phy100Impo = phy100Impo;
	}
	public int getPhy100Height() {
		return phy100Height;
	}
	public void setPhy100Height(int phy100Height) {
		this.phy100Height = phy100Height;
	}
	public int getPhy100Weight() {
		return phy100Weight;
	}
	public void setPhy100Weight(int phy100Weight) {
		this.phy100Weight = phy100Weight;
	}
	public int getPhy100Power() {
		return phy100Power;
	}
	public void setPhy100Power(int phy100Power) {
		this.phy100Power = phy100Power;
	}
	public String getPhy100Grade() {
		return phy100Grade;
	}
	public void setPhy100Grade(String phy100Grade) {
		this.phy100Grade = phy100Grade;
	}
	
	@Override
	public String toString() {
		return "Phy100 [phy100Id=" + phy100Id + ", phy100PName=" + phy100Name + ", phy100Impo=" + phy100Impo
				+ ", phy100Height=" + phy100Height + ", phy100Weight=" + phy100Weight + ", phy100Power=" + phy100Power + ", phy100Grade=" + phy100Grade + "] ";
	
}
}

	
	
	