<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	String strId = request.getParameter("id"); //url주소 파라미터 id 
	
	if(strId == null || strId.trim().equals("")){ // 아이디가 null이거나 공백이면
		out.print("아이디를 입력해주세요");
	} else {
		int id = Integer.parseInt(strId);

		try{
			String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
			Connection conn = DriverManager.getConnection(url,"root","1234");
			PreparedStatement pstmt = conn.prepareStatement("select * from members where id=?");
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				out.print("이미 가입된 이메일 있음");
			}else {
				out.print("사용 가능한 이메일");
				
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace(); //예외출력
		} 
	}
%>
