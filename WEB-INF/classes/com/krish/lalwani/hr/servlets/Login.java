package com.krish.lalwani.hr.servlets;
import com.krish.lalwani.hr.dl.*;
import com.krish.lalwani.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Login extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
AdministratorBean administratorBean=(AdministratorBean)request.getAttribute("administratorBean");
if(administratorBean==null)
{
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
}
String username=administratorBean.getUsername();
String password=administratorBean.getPassword(); // comes from user or form qs
AdministratorDAO administratorDAO=new AdministratorDAO();
try
{
AdministratorDTO administrator=administratorDAO.getByUsername(username);
if(password.equals(administrator.getPassword())==false) throw new DAOException("Invalid Password : "+password);
HttpSession session=request.getSession();
session.setAttribute("username",username);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/index.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
RequestDispatcher requestDispatcher; //used for forwarding the request
requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e) // unchecked Exception ServletException
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