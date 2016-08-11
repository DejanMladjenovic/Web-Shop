package org.bildit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.model.bo.PhoneBoImpl;
import org.bildit.model.dto.Phone;

/**
 * Servlet implementation class AddPhone
 */
@WebServlet("/AddPhoneServlet")
public class AddPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPhoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Phone phone = new Phone();
		phone.setManufacturer(request.getParameter("manufacturer"));
		phone.setModel(request.getParameter("model"));
		phone.setOperating_system(request.getParameter("operating_system"));
		phone.setDescription(request.getParameter("description"));
		phone.setPrice(Integer.parseInt(request.getParameter("price")));
		phone.setAmount(Integer.parseInt(request.getParameter("amount")));
		phone.setPicture(request.getParameter("picture"));
		
		PhoneBoImpl phoneBo = new PhoneBoImpl();
		boolean result = phoneBo.insertPhone(phone);
		
		if(result) {
			request.setAttribute("addPhoneScreen", "Artikal je dodat!");
			request.getRequestDispatcher("addphone.jsp").forward(request, response);
		} else {
			request.setAttribute("addPhoneScreen", "Pokusajte ponovo!");
			response.sendRedirect("addphone.jsp");
		}	
	}

}
