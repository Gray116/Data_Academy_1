package com.lec.ex1Person;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMain_UseDAO {
	public static void main(String[] args) {
		/* 1. 변수 선언 */
		PersonDAO dao = PersonDAO.getInstance();
		ArrayList<PersonDTO> person;
		Scanner sc = new Scanner(System.in);
		String fn;
		
		/* 2. 드라이버 로드 */
		do {
			System.out.println("1: 정보 입력, 2: 직업별 출력, 3: 전체 출력, 그외: 종료");
			System.out.print("번호 입력 : ");
			fn = sc.next();
			
			switch(fn) {
			case "1":
				System.out.print("이름 입력 : ");
				String name = sc.next();
				
				System.out.print("직업 입력(배우 or 가수 or MC만 가능) : ");
				String jname = sc.next().toUpperCase();
				
				System.out.print("국어 점수 입력 : ");
				int kor = sc.nextInt();
				
				System.out.print("영어 점수 입력 : ");
				int eng = sc.nextInt();
				
				System.out.print("수학 점수 입력 : ");
				int mat = sc.nextInt();
				
				PersonDTO newPerson = new PersonDTO(name, jname, kor, eng, mat);
				int result = dao.insertPerson(newPerson);
				System.out.println(result == PersonDAO.SUCCESSED? "입력 성공" : "입력 실패");
				break;
			
			case "2":
				System.out.print("조회 할 직업 입력(단, 가수,배우,MC만 가능) : ");
				jname = sc.next();
				
				person = dao.selectJname(jname);
				if(person.isEmpty()) {
					System.out.println("해당 직업의 사람이 없습니다.");
				} else {
					System.out.println("rank\t직업\t이름\t\t국어\t영어\t수학\t총점");
					for(PersonDTO p : person) {
						System.out.println(p);
					}
				}
				break;
			
			case "3":
				person = dao.selectAll(); // 전체 출력
				if (person.size() == 0) {
					System.out.println("입력된 사람이 없습니다.");
				} else {
					System.out.println("rank\t이름\t\t직업\t국어\t영어\t수학\t총점");
					for(PersonDTO p : person) {
						System.out.println(p);
					}
				}
			} // switch			
		} while(fn.equals("1") || fn.equals("2") || fn.equals("3")); // do-while
		sc.close();
		System.out.println("이용해주셔서 감사합니다.");		
	}// main
} // class



























