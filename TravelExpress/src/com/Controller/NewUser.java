package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Business.businessLayer;
import com.IBusiness.Ibusiness;

/**
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Ibusiness Ibusiness;
    public NewUser() {
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
		 String name= request.getParameter("name");
	     String address= request.getParameter("address");
	     String email=request.getParameter("emailId");
	     String contact=request.getParameter("contact");
	     String password=request.getParameter("password");
	     String confPassword=request.getParameter("confPassword");
	     if(password.equals(confPassword)){
	    	 Ibusiness.insertUser(name,address,email,contact,password);
	    	 RequestDispatcher rd= request.getRequestDispatcher("Welcome.jsp"); 
	 		rd.forward(request, response);
	     }
	     else{
	    	 //password doesnt match
	     }
	     
		
		/*RequestDispatcher rd= request.getRequestDispatcher("Welcome.jsp"); 
		rd.forward(request, response);*/
	}

}
