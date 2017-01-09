package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Business.businessLayer;
import com.IBusiness.Ibusiness;
import com.model.Air;
import com.model.Bus;
import com.model.Itinerary;
import com.model.Rail;
import com.model.hoteModel;

/**
 * Servlet implementation class SelectRegion
 */
@WebServlet("/SelectRegion")
public class SelectRegion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Ibusiness Ibusiness;  
    public SelectRegion() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Itinerary itobj= new Itinerary();
		Integer userid = Integer.parseInt((String) request.getParameter("itobj"));
		itobj.setUSER_ID(userid);
		itobj.setDEPARTURE_CITY((String) request.getParameter("depCity"));
		itobj.setARRIVAL_CITY((String) request.getParameter("arivCity"));
	//	itobj.setDATE_OF_DEPARTURE((Date) request.getParameter("From"));
	//	itobj.setDATE_OF_RETURN((Date) request.getParameter("To"));
		itobj.setMODE_OF_TRANSPORT((String) request.getParameter("Mode"));
		HttpSession session = request.getSession();
		session.setAttribute("itobj",itobj);
		//request.setAttribute("itobj", itobj);
		//firing the function

		
		if(request.getParameter("Mode").equals("Air")){
		//request.setAttribute("databaseList", regionList);
		List<Air>databaseAirList=new ArrayList<Air>();
		Ibusiness= new businessLayer();
		Ibusiness.createProcedureRATE_CALCULATION(itobj);
		databaseAirList=Ibusiness.populateAirList();
		request.setAttribute("databaseAirList", databaseAirList);
		RequestDispatcher rd= request.getRequestDispatcher("TransportAirMode.jsp"); 
		rd.forward(request, response);
		}
		else if(request.getParameter("Mode").equals("Rail")){
			List<Rail>databaseRailList=new ArrayList<Rail>();
			Ibusiness= new businessLayer();
			Ibusiness.createProcedureRATE_CALCULATION(itobj);
			databaseRailList=Ibusiness.populateRailList();
			request.setAttribute("databaseRailList", databaseRailList);
			RequestDispatcher rd= request.getRequestDispatcher("TransportRailMode.jsp"); 
			rd.forward(request, response);
		}
		else if(request.getParameter("Mode").equals("Bus")){
			List<Bus>databaseBusList=new ArrayList<Bus>();
			Ibusiness= new businessLayer();
			Ibusiness.createProcedureRATE_CALCULATION(itobj);
			databaseBusList=Ibusiness.populateBusList();
			request.setAttribute("databaseBusList", databaseBusList);
			RequestDispatcher rd= request.getRequestDispatcher("TransportBusMode.jsp"); 
			rd.forward(request, response);
		}
		else if(request.getParameter("Mode").equals("Mode")){
			// to initialize the hotels
			List<hoteModel> hotelPriceList=new ArrayList<hoteModel>();
			Ibusiness= new businessLayer();
			hotelPriceList=Ibusiness.hotelPriceList(itobj);
			request.setAttribute("hotelPriceList", hotelPriceList);
			RequestDispatcher rd= request.getRequestDispatcher("Hotel.jsp"); 
			rd.forward(request, response);
		}
	}

}
