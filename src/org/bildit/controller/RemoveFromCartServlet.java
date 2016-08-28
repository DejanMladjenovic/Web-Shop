package org.bildit.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bildit.model.dto.Phone;


/**
 * Servlet implementation class MyCartServlet
 */
@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCartServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	    LinkedHashMap<Phone, Integer> map = (LinkedHashMap<Phone, Integer>) request.getSession().getAttribute("cart");

		int id = Integer.parseInt(request.getParameter("id"));
		List<Phone> list = (List<Phone>) session.getAttribute("phones");
		for (Phone p : list) {
			if (p.getPhoneId() == id){
				int value = map.get(p);
				if(value > 1){
					value--;
					map.put(p, value);
				} else {
					map.remove(p);
				}
			}
		}
	    
		request.getSession().setAttribute("cart", map);
		response.sendRedirect("mycart.jsp");
	}

}
