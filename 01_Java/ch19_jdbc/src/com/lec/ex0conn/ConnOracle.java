package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null; // DB연결 변수
		
		/* 1단계 - 드라이버를 로드한다 */
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			/* DB와 연결객체 생성 */
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("오라클 연결 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "연결 오류");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "드라이버 오류");
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage() + "닫기 오류");
			}
		}
	}// main
} // class