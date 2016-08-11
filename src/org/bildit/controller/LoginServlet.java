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
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserBoImpl userBo = new UserBoImpl();
		User user = userBo.readUser(username, password);
		if(user != null){
			request.getSession().setAttribute("user", user);
			response.sendRedirect("index.jsp");
		} else {
			request.setAttribute("loginScreen", "Pokusajte ponovo!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
