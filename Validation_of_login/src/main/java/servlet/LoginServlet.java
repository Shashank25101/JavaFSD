package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(password.equals("qwerty")) {
			Cookie cookieEmail = new Cookie("email", email);
			response.addCookie(cookieEmail);
			request.getRequestDispatcher("Main.html").forward(request, response);
		} else {
			PrintWriter writer = response.getWriter();
			response.setContentType("text/html; charset=utf-8");
			request.getRequestDispatcher("Login.html").include(request, response);
			writer.println("<h4 style= \"text-align: center; color: red;\"> The password you entered is incorrect!</h4>");
		}
	}

}