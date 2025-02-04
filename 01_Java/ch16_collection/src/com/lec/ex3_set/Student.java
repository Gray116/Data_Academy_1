package com.lec.ex3_set;

public class Student {
	private int grade;
	private String name;

	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return grade + "학년 " + name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Student) {
//			boolean gradeChk = ( grade == ((Student)obj).grade );
//			boolean nameChk = ( name.equals(((Student)obj).name) );
//			
//			return gradeChk && nameChk;
			
			return toString().equals(obj.toString());
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode(); // toString의 결과가 같으면 hashcode도 같은 주소값을 리턴함
	}
}