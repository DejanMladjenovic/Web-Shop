package org.bildit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.model.bo.PhoneBoImpl;
import org.bildit.model.dto.Phone;

/**
 * Servlet implementation class PhonesListServlet
 */
@WebServlet("/PhonesListServlet")
public class PhonesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhonesListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Phone> phones = new ArrayList<>();
		PhoneBoImpl phoneBo = new PhoneBoImpl();
		phones = phoneBo.readAllPhones();
		
		request.getSession().setAttribute("phones", phones);
	}

}
