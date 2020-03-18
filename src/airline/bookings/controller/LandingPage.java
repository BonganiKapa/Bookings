package airline.bookings.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class LandingPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LandingPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getServletPath();
		
		switch(action) {
		
		case "/register":	
			registrationForm(request, response);
			break;
			
		case "/login":
			loginForm(request, response);
			break;
			
		case "/search":
			searchForm(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void registrationForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
		dispatcher.forward(request, response);
	}
	
	private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void searchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
}
