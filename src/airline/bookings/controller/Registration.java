package airline.bookings.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airline.bookings.bean.ClientBean;
import airline.bookings.dao.ClientDAO;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ClientDAO clientDao;
	
	public void init() {
		clientDao = new ClientDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String idNum = request.getParameter("idNum");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String cell = request.getParameter("cell");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		
		ClientBean client = new ClientBean();
		client.setName(name);
		client.setSurname(surname);
		client.setIdNm(idNum);
		client.setGender(gender);
		client.setAddress(address);
		client.setCell(cell);
		client.setPhone(phone);
		client.setEmail(email);
		client.setPassword(password);
		client.setRepasssword(repassword);
	
		try {
			clientDao.registerClient(client);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		response.sendRedirect("Success.jsp");
	}
}
