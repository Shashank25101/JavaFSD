package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Profile.html");
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		String email = ""; 
		Cookie cookieArray[] = request.getCookies();
		if(cookieArray!=null) {
			for(Cookie cookie : cookieArray) {
				email = cookie.getValue();
			}
		}
		writer.println("<h4 style= \"text-align: center; color: green;\"> Welcome to your profile "+email+" !</h4>");
		dispatcher.include(request, response);
	}
	
}