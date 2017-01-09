package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import com.*;
import com.Business.businessLayer;
import com.IBusiness.Ibusiness;
import com.model.Itinerary;

@WebServlet("/WelcomePage")
public class WelcomePage extends HttpServlet {
	Itinerary itobj= new Itinerary();
	private Ibusiness Ibusiness;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
    	
    }
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String submit=request.getParameter("submit");
		Ibusiness= new businessLayer();
		
		if(request.getParameter("submit")!=null){
			boolean checkUser= Ibusiness.checkUser(username,password);
			if(checkUser==true){
				//pre populating region
				
				ArrayList regionList = new ArrayList();
				regionList=Ibusiness.populateRegion();
				request.setAttribute("databaseList", regionList);
				RequestDispatcher rd= request.getRequestDispatcher("SelectRegion.jsp"); 
				int user_id=Ibusiness.getUserId(username);
				itobj.setUSER_ID(user_id);
				request.setAttribute("itobj", itobj.getUSER_ID());
				rd.forward(request, response);
				
			}
			//if false return something in pw writer
		}
		else if(request.getParameter("newUser")!=null){
			//case is true going to sing up page
			RequestDispatcher rd= request.getRequestDispatcher("NewUser.jsp"); 
			rd.forward(request, response);
		
		}
		else if(request.getParameter("findpass")!=null){
			RequestDispatcher rd= request.getRequestDispatcher("NewPassword.jsp"); 
			rd.forward(request, response);
		}
		
		/**/
		
		
	}

}
