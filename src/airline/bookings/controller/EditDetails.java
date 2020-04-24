package airline.bookings.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airline.bookings.bean.EditBean;
import airline.bookings.dao.EditDAO;

/**
 * Servlet implementation class EditDetails
 */
@WebServlet("/EditDetails")
public class EditDetails extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private EditDAO editDao;
	
	public void init() {
		editDao = new EditDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String name = request.getParameter("name");
        String surname = request.getParameter("lastName");
        String cell = request.getParameter("cell");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String pswd = request.getParameter("password");
        String rpswd = request.getParameter("repassword");
        
        EditBean edit = new EditBean();
        edit.setName(name);
        edit.setLastName(surname);
        edit.setCell(cell);
        edit.setPhone(phone);
        edit.setEmail(email);
        edit.setAddres(address);
        edit.setPassword(pswd);
        edit.setRepassowrd(rpswd);
        
        try {
        	editDao.updateClient(edit);
        	
        	
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
	}
}
