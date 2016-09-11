package com.example.baseadaptertest;

public class Candidate {
	private String name;
	private String mobileno;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public Candidate(String name, String mobileno) {
		super();
		this.name = name;
		this.mobileno = mobileno;
	}
	
}
