package com.lec.ex5deleteDept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		
		Scanner sc = new Scanner(System.in);
		/* 실행하기전에 sql에서 commit이 되어있는지 꼭 먼저 확인! */
		System.out.print("삭제할 부서번호 입력 : ");
		int deptno = sc.nextInt();
		
		String sql = "DELETE FROM DEPT WHERE DEPTNO = " + deptno;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				System.out.println(deptno + "번 부서 삭제 완료");
			} else {
				System.out.println("존재하지 않는 부서");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		sc.close();
	}// main
} // class