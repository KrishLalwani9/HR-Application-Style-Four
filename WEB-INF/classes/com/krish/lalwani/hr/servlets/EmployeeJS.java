package com.krish.lalwani.hr.servlets;
import com.krish.lalwani.hr.bl.*;
import java.util.*;
import com.krish.lalwani.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class EmployeeJS extends HttpServlet
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
response.setContentType("text/javascript");
//But the following is a very bad idea hence commented
//File file=new File("c:\\tomcat9\\webapps\\styletwo\\WEB-INF\\js\\Employees.js");
ServletContext servletContext=getServletContext();
File file=new File(servletContext.getRealPath("")+File.separator+"WEB-INF"+File.separator+"js"+File.separator+"Employees.js");
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"r");
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
pw.println(randomAccessFile.readLine());
}
List<EmployeeBean> employees=new EmployeeBL().getAll();
pw.println("var employee");
int i=0;
for(EmployeeBean employee:employees)
{
pw.println("employee=new Employee();");
pw.println("employee.employeeId=\""+employee.getEmployeeId()+"\"");
pw.println("employee.name=\""+employee.getName()+"\";");
pw.println("employee.designation=\""+employee.getDesignation()+"\";");
pw.println("employee.dateOfBirth=\""+employee.getDateOfBirth()+"\";");
pw.println("employee.gender=\""+employee.getGender()+"\";");
pw.println("employee.isIndian="+employee.getIsIndian()+";");
pw.println("employee.basicSalary=\""+employee.getBasicSalary()+"\";");
pw.println("employee.panNumber=\""+employee.getPANNumber()+"\";");
pw.println("employee.aadharCardNumber=\""+employee.getAadharCardNumber()+"\";");
pw.println("employees["+i+"]=employee;");
i++;
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