<%-- 
    Document   : registration
    Created on : 30 Jun, 2019, 4:42:14 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%String name=request.getParameter("name");
        String city=request.getParameter("city");
        String address=request.getParameter("addresss");
        String contact=request.getParameter("contact");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","admin1","1234");
            PreparedStatement ps=con.prepareStatement("insert into customer(name,city,address,contact)values(?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,city);
            ps.setString(3,address);
            ps.setString(4,contact);
            int i=ps.executeUpdate();
            if(i>0){
                out.print("welcome");
            }else{
                out.print("error");
            }
        }catch(Exception e){
            out.print(e);
        }
            %>
        <h1>Hello World!</h1>
    </body>
</html>
