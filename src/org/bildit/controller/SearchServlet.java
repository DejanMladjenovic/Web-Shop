package org.bildit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.model.bo.phone.PhoneBoImpl;
import org.bildit.model.dto.Phone;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String search = request.getParameter("search");
		List<Phone> phones = new ArrayList<>();
		PhoneBoImpl phoneBo = new PhoneBoImpl();
		phones = phoneBo.readMatchedPhones(search);
		
		request.setAttribute("phones", phones);
		request.getRequestDispatcher("phoneslist.jsp").forward(request, response);
		
	}

}
