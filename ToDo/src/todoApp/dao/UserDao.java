package todoApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import todoApp.model.User;
import todoApp.utils.JDBCUtils;

// DAO 는 DB에 연결해 데이터를 조작하는 클래스
public class UserDao {
	//유저 입력 => DB에 유저데이터를 입력
	public int registerUser(User user) { // todoApp.model의 User //결과가 성공이면 1리턴 아니면 0이하 
		
		// 실행하려는 sql문
		String INSERT_USER_SQL = "INSERT INTO users(firstName,lastName,userName,password) "
				+ "VALUES (?,?,?,?)";
		
		int result = 0;
				
		try {
			Connection conn = JDBCUtils.getConnection(); // Connection을 불러옴
			PreparedStatement pstmt = conn.prepareStatement(INSERT_USER_SQL); //sql가져와서 pstmt에 모두 저장
			pstmt.setString(1, user.getFirstName()); //물음표 채울 값 넣기
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getPassword()); // pstmt 준비 완료 (아직 넣지않음)
			
			result = pstmt.executeUpdate(); //결과가 없는 업데이트,삭제,입력 등은 쿼리 업데이트 한줄의 갯수가 리턴됨
			
		} catch (SQLException e) {
			System.out.println("SQL 입력 에러");
		}
		
		return result; //결과가 성공이면 1리턴 아니면 0이하
	}
}
