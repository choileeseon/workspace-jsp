<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	String email = request.getParameter("email"); 
	
	if(email.contains("@") && email.contains(".")){ 
		try{
			String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
			Connection conn = DriverManager.getConnection(url,"root","1234");

			PreparedStatement pstmt = conn.prepareStatement("select * from members where email=?");
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				out.print("이미 가입된 이메일 있음");
			}else {
				out.print("사용 가능한 이메일");
				
			}
			conn.close();
			
		} catch (Exception e) {
			out.print(e); //예외출력
		} 
		
	} else {
		out.print("잘못된 이메일 형식");

	}
%>
