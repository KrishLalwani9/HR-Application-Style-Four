package com.krish.lalwani.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.io.*;
public class FormIdTagHandler extends TagSupport
{
public FormIdTagHandler()
{
reset();
}
public void reset()
{
//do nothing
}
public int doStartTag()
{
String formId=UUID.randomUUID().toString();
pageContext.setAttribute(formId,formId,PageContext.SESSION_SCOPE);
JspWriter jw=pageContext.getOut();
try
{
jw.print("<input type='hidden' id='formId' name='formId' value='"+formId+"'>");
}catch(IOException ioException)
{
//Do nothing
}
return super.SKIP_BODY;
}
public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}