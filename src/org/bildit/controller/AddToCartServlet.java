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
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession();
	    LinkedHashMap<Phone, Integer> map = (LinkedHashMap<Phone, Integer>) request.getSession().getAttribute("cart");
	    
	    if(map == null){
	    	map = new LinkedHashMap<>();
	    	request.getSession().setAttribute("cart", map);
	    }
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<Phone> list = (List<Phone>) session.getAttribute("phones");
		for (Phone p : list) {
			if (p.getPhoneId() == id){
				if(!map.containsKey(p)){
					map.put(p, 1);
				} else{
					int value = map.get(p);
					if(value == p.getAmount()) {
						request.setAttribute("message", "Nema vise na stanju!");
						request.getRequestDispatcher("phoneslist.jsp").forward(request, response);
						break;
					} else {
					value++;
					map.put(p, value);
					}
				}
			}
		}
	    
		request.getSession().setAttribute("cart", map);
		request.getRequestDispatcher("mycart.jsp").forward(request, response);;
	}

}
