package com.problem;

import java.io.*;

import java.sql.*;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.*;

public class Search extends HttpServlet {

       public void doGet(HttpServletRequest request, HttpServletResponse response)

                     throws ServletException, IOException {

              response.setContentType("text/html");

              PrintWriter out = response.getWriter();        

              String id=request.getParameter("id");                          

              try{

                     Class.forName("com.mysql.jdbc.Driver");

                     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","manager");               

                     PreparedStatement ps=con.prepareStatement("select * from kartik_111915058_detail where ID_number=?");
                     PreparedStatement ps1=con.prepareStatement("select * from kartik_111915058_salary where ID_number=?");

                     ps.setString(1,id);     
                     ps1.setString(1,id);          

                     out.print("<table width=25% border=2>");

                     out.print("<center><h1>Result:</h1></center>");

                     ResultSet rs=ps.executeQuery();                
                     ResultSet rs1=ps1.executeQuery();            
                     /* Printing column names */

                     ResultSetMetaData rsmd=rs.getMetaData();
                     ResultSetMetaData rsmd1=rs1.getMetaData();
                     
                     while(rs.next())

                        {

                     out.print("<tr>");

                     out.print("<td>"+rsmd.getColumnName(1)+"</td>");

                        out.print("<td>"+rs.getString(1)+"</td></tr>");

                        out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");

                        out.print("<td>"+rs.getString(2)+"</td></tr>");

                        out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");

                        out.print("<td>"+rs.getString(3)+"</td></tr>");

                        out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");

                        out.print("<td>"+rs.getString(4)+"</td></tr>");    
                        
                        out.print("<td>"+rsmd.getColumnName(5)+"</td>");

                        out.print("<td>"+rs.getString(5)+"</td></tr>");
                        
                        out.print("<td>"+rsmd.getColumnName(6)+"</td>");

                        out.print("<td>"+rs.getString(6)+"</td></tr>");
                        out.print("<td> </td>");
                     }
                     	
                     while(rs1.next())
                     {

                  out.print("<tr>");

                  out.print("<td>"+rsmd1.getColumnName(1)+"</td>");

                     out.print("<td>"+rs1.getString(1)+"</td></tr>");

                     out.print("<tr><td>"+rsmd1.getColumnName(2)+"</td>");

                     out.print("<td>"+rs1.getString(2)+"</td></tr>");

                     out.print("<tr><td>"+rsmd1.getColumnName(3)+"</td>");

                     out.print("<td>"+rs1.getString(3)+"</td></tr>");

                     out.print("<tr><td>"+rsmd1.getColumnName(4)+"</td>");

                     out.print("<td>"+rs1.getString(4)+"</td></tr>");    
                     
                     
                     out.print("<td> </td>");
                  }

                     out.print("</table>");

 

              }catch (Exception e2)

                {

                    e2.printStackTrace();

                }

 

              finally{out.close();

                }

       }

 

}