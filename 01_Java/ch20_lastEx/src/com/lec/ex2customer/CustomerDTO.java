package com.lec.ex2customer;

public class CustomerDTO {
	private int cno;
	private String name;
	private String tel;
	private int point;
	
	public CustomerDTO(int cno, String tel, String name, int point) {
		this.cno = cno;
		this.name = name;
		this.tel = tel;
		this.point = point;
	}
	
	public CustomerDTO(String tel, String name, int point) {
		this.name = name;
		this.tel = tel;
		this.point = point;
	}

	@Override
	public String toString() {
		return cno + "\t" + tel + "\t" + name + "\t" + point + "\n";
	}

	public int getCno() {
		return cno;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public int getPoint() {
		return point;
	}
}