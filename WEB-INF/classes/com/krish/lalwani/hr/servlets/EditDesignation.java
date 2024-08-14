package com.krish.lalwani.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.krish.lalwani.hr.dl.*;
import com.krish.lalwani.hr.beans.*;
public class EditDesignation extends HttpServlet
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
int code=Integer.parseInt(request.getParameter("code"));
System.out.println(code);
DesignationDAO designationDAO=new DesignationDAO();
DesignationDTO designation;
try
{
designation=designationDAO.getByCode(code);
System.out.println(designation.getTitle());
DesignationBean designationBean=new DesignationBean();
designationBean.setCode(code);
designationBean.setTitle(designation.getTitle());
request.setAttribute("designationBean",designationBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/DesignationEditForm.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println(exception.getMessage());
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
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
}
}