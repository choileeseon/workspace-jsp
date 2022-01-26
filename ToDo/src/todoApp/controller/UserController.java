package todoApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todoApp.dao.UserDao;
import todoApp.model.User;

@WebServlet("/register")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao; // 계속 쓸거라 객체를 생성해둠 ?????????

	@Override //source - override - servlet - init() 
	public void init() throws ServletException {
		// 서블릿이 만들어 질때 한번만 실행
		userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
		dispatcher.forward(request, response);
	}

	//post방식으로 register를 입력하는 이유는 패스워드같은 보안때문
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//유저 입력시 post로 옴. post로 입력 데이터를 전달
		request.setCharacterEncoding("UTF-8"); //한글설정
		// 파라메터 성,이름,유저,비번을 입력받음
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		// * todoApp.model의 User 클래스에 가서 generate Constructor 만들어줌
		User user = new User(firstName, lastName, userName, password);
		// DB에 위의 유저를 입력한다.
		
		int result = userDao.registerUser(user); //위의 user
		if(result == 1) { // 왜 1 ??????????
			System.out.println("회원 등록 완료!");
			request.setAttribute("MESSAGE", "회원등록 완료!");
		} else {
			request.setAttribute("MESSAGE", "회원등록 실패!");
		}

		// 화면을 보여주기(register 폴더 안의 register.jsp 페이지를 보여주기)
		RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
		dispatcher.forward(request, response);
		
		// 한줄로 쓰는 법
		// request.getRequestDispatcher("register/register.jsp").forward(request, response);
	}

}
