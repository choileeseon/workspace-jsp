package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
     // context는 무조건 하나여서 브라우저가 달라도 공유가 된다
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext(); // 이 애플리케이션의 컨텍스트 객체 리턴
		
		Integer hits = (Integer)context.getAttribute("hits"); //저장한 hits를 가져온다, 리턴타입은 object라서 ->Integer로 형변환이 필요 (Integer 객체주소 같게)

		if(hits == null) hits = 0;	// 처음 hits가 없을때 0으로 초기화
		else hits++;				// 저장 돼 있다면 +1 해준다
		
		context.setAttribute("hits", hits); //속성값을 context에 저장
		
		PrintWriter out = response.getWriter();
		out.println("Hits : "+hits);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
