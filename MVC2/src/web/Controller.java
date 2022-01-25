package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿 : 브라우저에서 요청이 들어온것을 어떤 요청인지 분석하고 처리 
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// 2. servlet -> jsp 
		String page = null;
		if(action == null) {
			page = "/error.jsp";
		} else if(action.equals("login")) {
			page = "/login.jsp";			
		} else if(action.equals("about")) {
			page = "/about.jsp";			
		} else {
			page = "/error.jsp";						
		}
		
		// 3. jsp -> javaBean
		// ex 로그인누르면? getServletContext() 은 MVC2,	getRequestDispatcher(page) 는 login.jsp 페이지로 forwrad보낸다
		getServletContext().getRequestDispatcher(page).forward(request, response);
	}

}
