package com.lec.ex4Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 부서번호 입력 : ");
		String deptno = sc.next();
		
		/* 입력한 해당부서번호가 있는지 select 조회 */
		String selsql = "SELECT DEPTNO" + 
				"    FROM DEPT" + 
				"    WHERE DEPTNO = " + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selsql);
			
			if (rs.next()) {
				System.out.print("변경할 부서이름 입력 : ");
				String dname = sc.next().toUpperCase();
				
				System.out.print("바뀐 부서위치 입력 : ");
				String loc = sc.next().toUpperCase();
				
				String updtsql = "UPDATE DEPT" + 
						"    SET DNAME = '"+dname+"', LOC = '"+loc+"'" + 
						"    WHERE DEPTNO = " + deptno;
				
				int result = stmt.executeUpdate(updtsql);
				if (result > 0) {
					System.out.println(deptno + "번 부서 수정 성공");
				}
			} else {
				System.out.println("없는 부서번호입니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null ) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		sc.close();
	} // main
} // class














































