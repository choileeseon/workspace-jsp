package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gallery")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Map<String, String> actionMap = new HashMap<>();
	
	public Controller() {
		// 컨트롤로 생성자(시작할때 한번 실행)
		actionMap.put("home", "/home.jsp"); //(key,value)값이 actionMap에 저장
		actionMap.put("image", "/image.jsp");
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		//만약 액션 파라미터가 없거나 actionMap에 없으면 => home.jsp
		if(action == null || !actionMap.containsKey(action)) action = "home"; //이상하게 적어도 기본 home이라는 뜻
		
		request.getRequestDispatcher(actionMap.get(action)).forward(request, response); //home이면 home.jsp로 가게끔
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet으로 처리
		doGet(request, response);
	}
	

}
