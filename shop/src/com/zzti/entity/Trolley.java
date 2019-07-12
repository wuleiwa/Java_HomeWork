package com.zzti.entity;

public class Trolley {
	private int busiNum;
	private String busiName;
	private String busiType;
	private int busiValue;

	public int getBusiNum() {
		return busiNum;
	}

	public void setBusiNum(int busiNum) {
		this.busiNum = busiNum;
	}

	public String getBusiName() {
		return busiName;
	}

	public void setBusiName(String busiName) {
		this.busiName = busiName;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public int getBusiValue() {
		return busiValue;
	}

	public void setBusiValue(int busiValue) {
		this.busiValue = busiValue;
	}

	public Trolley() {
		// TODO Auto-generated constructor stub
	}

	public Trolley(int busiNum, String busiName, String busiType, int busiValue) {
		super();
		this.busiNum = busiNum;
		this.busiName = busiName;
		this.busiType = busiType;
		this.busiValue = busiValue;
	}
	
}
