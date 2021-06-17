package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null; 
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMP";
		
		try {
			/* 1단계 : 드라이버 로드 */
			Class.forName(driver);
			
			/* 2단계 : (DB를 연결하는)객체 생성 */
			conn = DriverManager.getConnection(url, "scott", "tiger");
			
			/* 3단계 : (SQL문을 전송해주는)객체 생성 */
			stmt = conn.createStatement();
			
			/* 4,5단계 : (SELECT문의 결과를 받는)객체 생성 및 결과 받기 */
			rs = stmt.executeQuery(sql);
			
			/* 6단계 : 데이터가 있다면 원하는 결과를 받아 로직 수행 */
			if (rs.next()) { // rs가 가져올 데이터가 있냐?
				System.out.println("사번\t 이름\t 직책\t 상사사번\t 입사일\t\t 급여\t상여\t부서번호");
				do {
					int 		empno 	  = rs.getInt("empno");
					String 		ename 	  = rs.getString("ename");
					String 		job 	  = rs.getString("job");
					int 		mgr 	  = rs.getInt("mgr");
					Date		hiredate  = rs.getDate("hiredate");
					Timestamp 	hiredates = rs.getTimestamp("hiredate");
					int 		sal		  = rs.getInt("sal");
					int 		comm	  = rs.getInt("comm");
					int 		deptno	  = rs.getInt("deptno");
					
					if(job != null && job.length() < 6) {
						System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n",
								   empno, ename, job, mgr, hiredate, sal, comm, deptno);
					} else {
						System.out.printf("%d\t %s\t %s %d\t %TF\t %d\t %d\t %d\n",
								   empno, ename, job, mgr, hiredate, sal, comm, deptno);
					}
				} while (rs.next());
			} else {
				System.out.println("조회 결과 없음");
			} // if-else
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "드라이버 오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			/* 7단계 : 연결 해제 */
			try {
				if (rs 	 != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
	} //main
} //class



















