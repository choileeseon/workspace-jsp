package controller;


import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.ContactDao;


@WebServlet("/ContactController")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	private ContactDao contactDao; //불러와서 

    @Resource(name = "jdbc/demo")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
    	contactDao = new ContactDao(dataSource);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<Contact> list = contactDao.findAll();
		//list.forEach(contact -> system.out.println(contact.toString()));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
