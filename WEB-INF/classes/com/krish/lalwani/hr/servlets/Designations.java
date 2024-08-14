package com.krish.lalwani.hr.servlets;
import com.krish.lalwani.hr.dl.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.google.gson.*;
public class Designations extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("application/json");
response.setCharacterEncoding("utf-8");
List<DesignationDTO> designations;
try
{
designations=new DesignationDAO().getAll();
Gson gson=new Gson();
String jsonString=gson.toJson(designations);
pw.print(jsonString);
pw.flush();
}catch(DAOException daoException)
{
pw.print("Invalid");
}
}catch(Exception exception)
{
try
{
response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
}catch(IOException io)
{
//do nothing
}
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}catch(IOException ioException)
{
//do nothing
}
}
}