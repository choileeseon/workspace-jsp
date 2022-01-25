package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// 저장돼 있는 이메일/패스워드/메세지를 초기화 -> 로그인 정보는 post로 가므로 Get에서는 초기화
		request.setAttribute("email", "");
		request.setAttribute("password", "");
		request.setAttribute("valmessage", "");
		
				
		if(action == null) { // 액션값이 없을때 잘못된 파라미터이므로 다시 기본페이지(index.jsp)로 보냄
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else if(action.equals("login")) {	// 로그인 값이 있으면 로그인 페이지로 보냄		
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null) { // 액션값이 없을때 다시 기본페이지(index.jsp)로 보냄
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else if(action.equals("dologin")) {	// 로그인 값이 있으면 값을 가져와서(getParameter) 값을 저장하기(setAttribute)		
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			
			User user = new User(email,password);
			
			//유효성 검사해서 합격하면 로그인성공 페이지로 
			if(user.validate()) {
				request.getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			}else { //유효성 검사에서 실패 (실제 메세지를 request객체에 파라미터로 추가)
				request.setAttribute("valmessage", user.getMessage()); // request에 추가
				// 유효성 실패로 다시 로그인 페이지로 되돌아감
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}

}
