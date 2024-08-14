package com.krish.lalwani.hr.servlets;
import com.krish.lalwani.hr.beans.*;
import com.krish.lalwani.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ConfirmDeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
HttpSession session=request.getSession();
String username=(String)session.getAttribute("username");
RequestDispatcher requestDispatcher;
if(username==null)
{
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
String codeString=request.getParameter("code");
if(codeString==null || codeString.length()==0)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}
int code=0;
try
{
code=Integer.parseInt(codeString);
}catch(NumberFormatException nfe)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}
DesignationDTO designation;
DesignationDAO designationDAO=new DesignationDAO();
try
{
designation=designationDAO.getByCode(code);
DesignationBean designationBean=new DesignationBean();
designationBean.setCode(code);
designationBean.setTitle(designation.getTitle());
request.setAttribute("designationBean",designationBean);
requestDispatcher=request.getRequestDispatcher("/ConfirmDeleteDesignation.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp"); 
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
//do Nothing
}
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}
