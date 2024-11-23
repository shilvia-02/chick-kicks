/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class loginser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
          String username=request.getParameter("name");
        String password=request.getParameter("pwd");
        HttpSession session=request.getSession();
          session.setAttribute("name",username);
        
        try{
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
        Statement s=con.createStatement();
        PreparedStatement ps =con.prepareStatement("SELECT * FROM \"public\".register_details where name=? AND pwd=?");
        ps.setString(1,username);
        ps.setString(2,password);
        
        ResultSet rs;
        rs=ps.executeQuery();
        if(rs.next()){
            response.sendRedirect("home.html");
        }
        else{
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
                    rd.include(request, response);
                    out.println("<h2>kindly register</h2>");
        }
         
    }

    catch(Exception e)
    {
    out.println(e);
}
}}