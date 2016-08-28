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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("delete"));
		PhoneBoImpl phoneBo = new PhoneBoImpl();
		Phone phone = phoneBo.readPhone(id);
		
		boolean result = phoneBo.deletePhone(phone);
		
		if (result) {
			request.setAttribute("Screen", "Artikal uspjesno izbrisan!");
		} else {
			request.setAttribute("Screen", "Doslo je do greske!");	
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
