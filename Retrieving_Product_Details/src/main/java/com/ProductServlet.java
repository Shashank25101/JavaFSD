package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String pId = request.getParameter("pid");
        try {
            final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
            final String DB_URL = "jdbc:mysql://localhost:3306/ecommerce";
            final String USERNAME = "root";
            final String PASSWORD = "Shashank@2531";
            Class.forName(DRIVER_CLASS);
            // connection with the dB
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement ps = con.prepareStatement("select * from products where id=?");
            ps.setString(1, pId);
            pw.print("<table width=50% border=1>");
            pw.print("<caption><h1>Product Details are: </h1></caption>");
            ResultSet rs = ps.executeQuery();
            pw.print("</br></br>");
            ResultSetMetaData rsmd = rs.getMetaData();
            int total = rsmd.getColumnCount();
            pw.print("<tr>");
            for (int i = 1; i <= total; i++) {
                pw.print("<th>" + rsmd.getColumnName(i) + "</th>");
            }
            pw.print("</tr>");

            if (!rs.next()) {
                // No product found for the entered ID
                pw.print("<tr><td colspan='" + total + "' style='color:red;'>No product found! Press the 'Back' button below and please provide valid ID " + "</td></tr>");
            } else {
                // Display product details
                do {
                    pw.print("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>"
                            + rs.getBigDecimal(3) + "</td><td>" + rs.getString(4) + "</td></tr>");
                } while (rs.next());
            }

            // Add "Back" button regardless of the result
            pw.print("</table>");
            pw.print("<form action='index.html'>");
            pw.print("<input type='submit' value='Back'>");
            pw.print("</form>");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
