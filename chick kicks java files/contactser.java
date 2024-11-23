/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author ASUS
 */
@WebServlet(urlPatterns = {"/contactser"})
public class contactser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String name=(String)session.getAttribute("name");
        //String name=request.getParameter("name");
        String email=request.getParameter("uemail");
        String cno=request.getParameter("cno"); 
        String type=request.getParameter("type");
        
        
        try{
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
        Statement s=con.createStatement();
        PreparedStatement ps =con.prepareStatement("insert into contact_details(name,email,cno,type) values(?,?,?,?)");
        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,cno);
        ps.setString(4,type);
        
        
        ps.executeUpdate();
            RequestDispatcher rd=request.getRequestDispatcher("shop.html");
                   rd.include(request, response);
        }   
    

    catch(Exception e)
    {
    out.println(e);
}
}
}