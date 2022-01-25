package gui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/urlpara")
public class URLParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("user parameter : " + user);
		// Deployement/urlpara?user=Sunny 를 넣으면 request 요청객체가 user을 인지?
		out.println("id parameter : " + id);
		//Deployement/urlpara?user=Sunny&id=123 
		out.println("<html>");
	}

}
