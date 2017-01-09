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
 * Servlet implementation class NewPassword
 */
@WebServlet("/NewPassword")
public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Ibusiness Ibusiness;
    public NewPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("password");
		String email_id=request.getParameter("email_id");
		String confpassword=request.getParameter("confpassword");
		if(password.equals(confpassword)){
			Ibusiness= new businessLayer();
			Ibusiness.updatePassword(password, email_id);
			RequestDispatcher rd= request.getRequestDispatcher("Welcome.jsp"); 
	 		rd.forward(request, response);
			
			
			
		}
		
	
	
	}

}
