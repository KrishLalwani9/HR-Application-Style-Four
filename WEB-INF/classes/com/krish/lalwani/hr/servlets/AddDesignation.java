package com.krish.lalwani.hr.servlets;
import com.krish.lalwani.hr.dl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.google.gson.*;
public class AddDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
HttpSession session=request.getSession();
String username=(String)session.getAttribute("username");
if(username==null)
{
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
PrintWriter pw=response.getWriter();
response.setContentType("application/json");
response.setCharacterEncoding("utf-8");

BufferedReader br=request.getReader();
StringBuilder sb=new StringBuilder();
String s;
while(true)
{
s=br.readLine();
if(s==null) break;
sb.append(s);
}
String rawString=sb.toString();
Gson gson=new Gson();
DesignationDTO designation=gson.fromJson(rawString,DesignationDTO.class);
if(designation.getTitle().length()==0)
{
pw.print("Invalid");
return;
}
DesignationDAO designationDAO=new DesignationDAO();
try
{
designationDAO.addDesignation(designation);
pw.print(gson.toJson(designation));
//RequestDispatcher requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
//requestDispatcher.forward(request,response);
pw.flush();
}catch(DAOException daoException)
{
pw.print("Invalid");
//RequestDispatcher requestDispatcher=request.getRequestDispatcher("/DesignationAddForm.jsp");
//requestDispatcher.forward(request,response);
return;
}
}catch(Exception exception)
{
try
{
response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
}catch(Exception e) // unchecked Exception ServletException
{
//do Nothing
}
}
}
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}catch(Exception e) // unchecked Exception ServletException
{
//do Nothing
}

}
}