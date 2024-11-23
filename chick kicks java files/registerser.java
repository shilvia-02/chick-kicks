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

/**
 *
 * @author ASUS
 */
public class registerser extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       String name=request.getParameter("uname"); 
        String pwd=request.getParameter("pwd");
        String email=request.getParameter("uemail"); 
        String cpwd=request.getParameter("cpwd");
        
        try{
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
        Statement s=con.createStatement();
        PreparedStatement ps =con.prepareStatement("insert into register_details(name,email,pwd,cpwd) values(?,?,?,?)");
        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,pwd);
        ps.setString(4,cpwd);
        
        
        ps.executeUpdate();
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
                    rd.include(request, response);
        }   
    

    catch(Exception e)
    {
    out.println(e);
}
    }

}