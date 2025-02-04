package com.lec.ex2selectwhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDeptno {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null; // DB연결 변수
		Statement  stmt = null;
		ResultSet  rs   = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("부서번호 입력 : ");
		int deptno = sc.nextInt();
		
		String sql = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			/* 해당부서번호가 있는지 없는지 */
			if (rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				System.out.println(deptno + "번 부서정보는 다음과 같습니다.");
				System.out.println("부서 이름 : " + dname);
				System.out.println("부서 위치 : " + loc);
			} else {
				System.out.println("해당부서 없음");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
	} // main
} // class


























