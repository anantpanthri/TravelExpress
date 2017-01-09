package com.Controller;

import java.io.IOException;
import java.util.Collections;

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

/**
 * Servlet implementation class Confirmation
 */
@WebServlet("/Confirmation")
public class Confirmation extends HttpServlet {
	Itinerary itobj= new Itinerary();
	private Ibusiness Ibusiness;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ibusiness= new businessLayer();
		String[] name = request.getParameterValues("dependentname"); 
		String[] relationship = request.getParameterValues("dependentrelationship");
		String[] sex = request.getParameterValues("dependentsex");
		String[] age = request.getParameterValues("dependentage");
		HttpSession session = request.getSession();
		itobj=(Itinerary) session.getAttribute("itobj");
		
		if(name!=null&&name.length>0&&name[0]!=""){
		for(int i=0;i<name.length;++i){
			Ibusiness.populateDependent(name[i],relationship[i],sex[i],age[i],itobj.getUSER_ID());
			
		}
		itobj.setNUMBER_OF_DEPENDENTS(name.length);
		}
		
		double total_price=0;
		if(itobj.getTRVAL_TYPE()!=null){
			total_price=Double.parseDouble(itobj.getTRVAL_TYPE());
		}
		total_price+=Double.parseDouble(itobj.getHOTEL_PRICE());
		if(itobj.getNUMBER_OF_DEPENDENTS()!=null){
			total_price=total_price*(itobj.getNUMBER_OF_DEPENDENTS()+1);
		}
		String username=Ibusiness.getUserName(itobj.getUSER_ID());
		request.setAttribute("username", username);
		request.setAttribute("total_price", total_price);
		if(request.getParameter("coupon")!=null){
			String couponcode=request.getParameter("couponcode");
			Double offer=Ibusiness.applyoffer(couponcode);
			total_price-=offer/100*total_price;
			total_price=Math.round(total_price);
			request.setAttribute("total_price", total_price);
			RequestDispatcher rd= request.getRequestDispatcher("Confirmation.jsp"); 
			rd.forward(request, response);
		}
		else if(request.getParameter("submit")!=null){
			request.setAttribute("itobj", itobj);
			System.out.println("itneary");
			RequestDispatcher rd= request.getRequestDispatcher("finalItnenary.jsp"); 
			rd.forward(request, response);
				
			
		}
		if(request.getParameter("done")!=null && request.getParameter("coupon")==null && request.getParameter("submit")==null){
		RequestDispatcher rd= request.getRequestDispatcher("Confirmation.jsp"); 
		rd.forward(request, response);
		}
				
	}

}
