package com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		
		RequestDispatcher rd= null;
		if(username.equalsIgnoreCase("tom") && password.equals("jerry")){
			rd=request.getRequestDispatcher("SuccessServlet");
			rd.forward(request, response);
		}else {
			rd=request.getRequestDispatcher("login.html");
			PrintWriter out=response.getWriter();
			response.setContentType("text/html; charset=utf-8");
			rd.include(request, response);
			out.println("<center> <span style='color:red'>Invalid Credentials!!</span></center>");
			
		}
	}

}
