package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Contact;


public class ContactDao {
//DB에 있는 contacts 테이블을 CRUD 하는 클래스
	private DataSource dataSource; // jdbc/demo 커넥션 풀 연결 객체
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	public ContactDao(DataSource dataSource) {
		this.dataSource = dataSource; // 커넥션 풀 dataSource를 입력
	}
	
	
	//모든 연락처를 리스트로 리턴
	public List<Contact> findAll(){
		List<Contact> list = new ArrayList<Contact>(); // 빈 리스트 생성
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select * from contacts");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setPhone(rs.getString("phone"));
				
				list.add(contact);
				
			}
			
		} catch (Exception e) {
			System.out.println("SQL 에러");
		} finally { //에러와 상관없이 무조건 실행
			//DB연결 객체들을 닫는 과정이 필요하다.
			closeAll();
		}
		return list;
	}


	private void closeAll() { //모든 DB를 닫아주는 역할
		
		try {
			// 나중에 생성한 순서부터 닫음 rs => pstmt => conn(풀로 돌아감)
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
		} catch (Exception e2) {
			System.out.println("DB연결 닫을때 에러발생");
		}	
	}
	
	public Contact find(int id) {
		
		Contact  contact = new Contact();
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select * from contacts where id = ?");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setPhone(rs.getString("phone"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			closeAll();
		}
		return contact;
	}
	
	// 입력된 contact객체를 DB에 저장
	public boolean save(Contact contact) {
		boolean rowAffected = false;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO `contacts` (`name`,`email`,`phone`)\r\n"
					+ "VALUES (?,?,?)");
			pstmt.setString(1, contact.getName());
			pstmt.setString(2, contact.getEmail());
			pstmt.setString(3, contact.getPhone());
			
			rowAffected = pstmt.executeUpdate() > 0;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			closeAll();
		}
		return rowAffected;
	} 
	
	// 입력된 contact객체를 DB에 업데이트
	public boolean update(Contact contact) {
		boolean rowAffected = false;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("update `contacts` set name=?, email=?, phone=? where id=?");
			
			pstmt.setString(1, contact.getName());
			pstmt.setString(2, contact.getEmail());
			pstmt.setString(3, contact.getPhone());
			pstmt.setInt(4, contact.getId());
			
			rowAffected = pstmt.executeUpdate() > 0;
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			closeAll();
		}
		return rowAffected;
	}
	
	// 삭제하기
	public boolean delete(int id) {
		boolean rowAffected = false;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("delete from contacts where id=?");
			
			pstmt.setInt(1, id);
			
			rowAffected = pstmt.executeUpdate() > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			closeAll();
		}
		return rowAffected;
	}
}
























