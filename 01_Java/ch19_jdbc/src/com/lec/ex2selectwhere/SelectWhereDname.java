package com.lec.ex2selectwhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("부서이름 입력 : ");
		String dname = sc.next().toUpperCase();
		
		String sql = "SELECT * FROM DEPT WHERE DNAME = '"+dname+"'";
		/*
		sql = String.format("SELECT * FROM DEPT WHERE DNAME = '%s'", dname);
		*/
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			/* 해당부서번호가 있는지 없는지 */
			if (rs.next()) {
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				
				System.out.println(dname + " 부서정보는 다음과 같습니다.");
				System.out.println("부서 번호 : " + deptno);
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
	}
}