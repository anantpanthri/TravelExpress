package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Business.businessLayer;
import com.IBusiness.Ibusiness;
import com.model.Itinerary;
import com.model.hoteModel;

/**
 * Servlet implementation class hotel
 */
@WebServlet("/hotel")
public class hotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Ibusiness Ibusiness;
    public hotel() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<hoteModel> hotelPriceList=new ArrayList<hoteModel>();
		Ibusiness= new businessLayer();
		
		String service_name=  (String) request.getParameter("service_name");
		String  price_per_mile=  (String) request.getParameter("price_per_mile");
		System.out.println("sname"+service_name);
		System.out.println("pname"+price_per_mile);
        Itinerary itobj= new Itinerary();
		HttpSession session = request.getSession();
		itobj=(Itinerary) session.getAttribute("itobj");
		itobj.setTRVAL_TYPE(price_per_mile);
		itobj.setMODE_OF_TRANSPORT(service_name);
		session.setAttribute("itobj",itobj);
		hotelPriceList=Ibusiness.hotelPriceList(itobj);
		request.setAttribute("hotelPriceList", hotelPriceList);
		RequestDispatcher rd= request.getRequestDispatcher("Hotel.jsp"); 
		rd.forward(request, response);
	}

}
