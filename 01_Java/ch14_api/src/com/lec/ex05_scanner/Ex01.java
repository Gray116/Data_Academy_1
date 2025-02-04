package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.println("입력하신 나이는 : " + age);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next(); // buffer에 처음나오는 \n은 무시하고 whiteSpace가 나오기전까지
		System.out.println("입력하신 이름은 " + name);
		
		System.out.print("주소를 입력하세요 : ");
		sc.nextLine(); // buffer에 \n이 나오는 앞까지 취하고 buffer에 남아있는 내용은 제거
		String address = sc.nextLine();
		System.out.println("입력하신 주소는 " + address);
		
		sc.close();
	}
}