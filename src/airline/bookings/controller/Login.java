package airline.bookings.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import airline.bookings.bean.LoginBean;
import airline.bookings.dao.LoginDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LoginDAO loginDao;
	
	public void init() {
		loginDao = new LoginDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginBean login = new LoginBean();
		login.setEmail(email);
		login.setPassword(password);
		
		try {
			if(loginDao.validate(login)) {
				response.sendRedirect("Home.jsp");
			}
			else {
				HttpSession session = request.getSession();
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("Home.jsp");
	}
}
