package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Itinerary;

/**
 * Servlet implementation class PreConfirmation
 */
@WebServlet("/PreConfirmation")
public class PreConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreConfirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hotel_name=(String)request.getParameter("hotel_name");
		String price_per_person=(String)request.getParameter("price_per_night");
		Itinerary itobj= new Itinerary();
		HttpSession session = request.getSession();
		itobj=(Itinerary) session.getAttribute("itobj");
		itobj.setHOTEL_NAME(hotel_name);
		itobj.setHOTEL_PRICE(price_per_person);
		session.setAttribute("itobj",itobj);
		RequestDispatcher rd= request.getRequestDispatcher("preconfirmation.jsp"); 
		rd.forward(request, response);
				
	}

}
