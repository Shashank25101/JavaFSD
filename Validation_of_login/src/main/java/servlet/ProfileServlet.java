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

public class ProfileServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("email", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		writer.println("<h4 style= \"text-align: center; color: green;\">You successfully logged out!</h4>");
		request.getRequestDispatcher("Login.html").include(request, response);
	}

}