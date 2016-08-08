package org.bildit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.model.bo.phone.PhoneBoImpl;
import org.bildit.model.dto.Phone;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PhoneBoImpl phoneBo = new PhoneBoImpl();
		String req = request.getParameter("update");
		Phone phone = phoneBo.readPhone(Integer.parseInt(req));
		request.setAttribute("phone", phone);
		request.getRequestDispatcher("updatephone.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PhoneBoImpl phoneBo = new PhoneBoImpl();
		String req = request.getParameter("submit");
		Phone newPhone= new Phone();
		newPhone.setPhoneId(Integer.parseInt(req));
		newPhone.setManufacturer(request.getParameter("manufacturer"));
		newPhone.setModel(request.getParameter("model"));
		newPhone.setOperating_system(request.getParameter("operating_system"));
		newPhone.setDescription(request.getParameter("description"));
		newPhone.setPrice(Integer.parseInt(request.getParameter("price")));
		newPhone.setAmount(Integer.parseInt(request.getParameter("amount")));
		newPhone.setPicture(request.getParameter("picture"));
		
		boolean result = phoneBo.updatePhone(newPhone);

		if (result) {
			request.setAttribute("Screen", "Azuriranje uspjesno izvrseno!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("Screen", "Doslo je do greske!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	

}
