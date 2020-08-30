/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/registration1"})
public class registration1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name=request.getParameter("name");
        String city=request.getParameter("city");
        String address=request.getParameter("address");
        String contact=request.getParameter("contact");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cust","root","");
            PreparedStatement ps=con.prepareStatement("insert into customer(name,city,address,contact) values(?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,city);
            ps.setString(3,address);
            ps.setString(4,contact);
            int i=ps.executeUpdate();
            if(i>0){
                out.println("Successful");
            }
        
        
            /* TODO output your page here. You may use following sample code. */
            
        }
            catch(Exception ex){
                out.println(ex);
        }
        }
    }


