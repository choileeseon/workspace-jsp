package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {

	private Connection conn;

	public Account(Connection conn) {
		this.conn = conn;
	}

	// 로그인(이메일,패스워드) DB에서 같은 이메일,패스워드 확인해서 false true 리턴
	public boolean login(String email, String password) throws SQLException {

		String sql = "SELECT COUNT(*) AS count FROM users WHERE email=? and password=?"; // ?는 PreparedStatemen는 그때그때 적은
																							// 이메일과 비번들을 넣음?

		PreparedStatement pstmt = conn.prepareStatement(sql); // 프리페어드 sql문으로 준비

		pstmt.setString(1, email); // 1번째 ?에 email 입력
		pstmt.setString(2, password); // 2번째 ?에 password 입력

		// 결과는 rs
		ResultSet rs = pstmt.executeQuery(); // SQL문 실행

		int count = 0;

		if (rs.next()) { // 결과가 있으면
			count = rs.getInt("count"); // (SELECT COUNT(*) AS count -> as count) count 열의 값을 리턴(int형)
		}

		rs.close();

		if (count == 0)
			return false; // 없으면 false, 있으면 true
		else
			return true;
	}

	public boolean exists(String email) throws SQLException {
		String sql = "SELECT COUNT(*) AS count FROM users WHERE email=?";
		PreparedStatement pstmt = conn.prepareStatement(sql); // 프리페어드 sql문으로 준비
		pstmt.setString(1, email); //1의 뜻 첫번째 물음표 
		ResultSet rs = pstmt.executeQuery(); // 준비된 sql을 실행

		int count = 0;

		if (rs.next()) { // 결과가 있으면
			count = rs.getInt("count"); // (SELECT COUNT(*) AS count -> as count) count 열의 값을 리턴(int형)
		}

		rs.close();

		if (count == 0)
			return false; // 없으면 false, 있으면 true
		else
			return true;
	}

	public void create(String email, String password) throws SQLException {
		// DB에 새 user email,password 입력
		String sql = "INSERT INTO uers(email,password) VALUES(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);

		pstmt.executeUpdate(); // 결과 rs가 없을 경우(입력,수정,삭제) executeUpdate() 사용
		pstmt.close();
	}
}
