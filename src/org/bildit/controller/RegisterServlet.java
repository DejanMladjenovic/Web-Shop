package org.bildit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.model.bo.UserBoImpl;
import org.bildit.model.dto.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setAddress(request.getParameter("address"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		
		UserBoImpl userBo = new UserBoImpl();
		boolean result =  userBo.createUser(user);
		
		if(result) {
			request.setAttribute("loginScreen", "Registracija uspjesna! Molimo prijavite se!");
		} else {
			if(userBo.readUser(user.getUsername(), user.getPassword()) != null)
				request.setAttribute("loginScreen", "Korisnicko ime zauzeto!");
			else
				request.setAttribute("loginScreen", "Doslo je do greske! Pokusajte ponovo!");	
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
