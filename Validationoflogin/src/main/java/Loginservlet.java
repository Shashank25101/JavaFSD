import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals(password)) {
			pw.print("Hello  "+username+"  Sucessfully Loggedin");
			//response.sendRedirect("sucess.html");
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("sucess.html");
			//RequestDispatcher rd=request.getRequestDispatcher("sucesspage");
			rd.include(request,response);
		}
		else {
			//pw.print("Invalid Credentials");
			pw.print("<html>"
					+ "<body>"
					+ "<h1>Login Failed "+username +"</h1>"
					+ "</body>"
					+"</html>");
		}
	}

}
