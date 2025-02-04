package com.lec.ex2selectwhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDnameEmp {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("부서이름 입력 : ");
		String dname = sc.next().toUpperCase();
		
		/* Query를 이용시 String.format으로 형식을 만들어 놓으면 편함 */
		/* 각 절은 앞이나 뒤를 띄어줘야 오류가 발생하지 않는다 */
		String sql1 = "SELECT * FROM DEPT WHERE DNAME = '"+dname+"'";
		String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER" + 
				"    FROM EMP W, EMP M, DEPT D" + 
				"    WHERE W.MGR = M.EMPNO" + 
				"        AND W.DEPTNO = D.DEPTNO" + 
				"        AND DNAME = '"+dname+"'";
		
		try {
			Class.forName(driver); // 1단계
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2단계
			stmt = conn.createStatement(); // 3단계
			rs = stmt.executeQuery(sql1); // 4,5 단계
			
			if (rs.next()) {
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				System.out.println("부서 번호 : " + deptno);
				System.out.println("부서 위치 : " + loc);
				
				rs.close(); // rs 연결 해제
				
				rs = stmt.executeQuery(sql2);
				
				if (rs.next()) {
					System.out.println("사번\t 이름\t 급여\t 상사명");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						
						System.out.printf("%d\t %s\t %d\t %s\n",
											empno, ename, sal, manager);
					} while (rs.next());
				} else {
					System.out.println("해당 부서 사원 없음");
				}
			} else {
				System.out.println("해당 부서 없음");
			}			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
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