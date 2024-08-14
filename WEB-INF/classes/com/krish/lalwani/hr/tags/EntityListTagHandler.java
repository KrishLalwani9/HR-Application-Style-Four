package com.krish.lalwani.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.lang.reflect.*;
public class EntityListTagHandler extends BodyTagSupport
{
private List entities;
private int index;
private String populatorClass;
private String populatorMethod;
private String name;
public EntityListTagHandler()
{
reset();
}
public void reset()
{
this.populatorClass="";
this.populatorMethod="";
this.name="";
this.entities=null;
}
public void setPopulatorMethod(String populatorMethod)
{
this.populatorMethod=populatorMethod;
}
public String getPopulatorMethod()
{
return this.populatorMethod;
}
public void setPopulatorClass(String populatorClass)
{
this.populatorClass=populatorClass;
}
public String getPopulatorClass()
{
return this.populatorClass;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public int doStartTag()
{
try
{
if(name==null || name.trim().length()==0) return super.SKIP_BODY;
Class c=Class.forName(populatorClass);
Object obj=c.newInstance();
Class parameters[]=new Class[0];
Method m=c.getMethod(populatorMethod,parameters);
entities=(List)m.invoke(obj);
if(entities.size()==0) return super.SKIP_BODY;
index=0;
Object entity=entities.get(index);
pageContext.setAttribute(name,entity,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1),PageContext.REQUEST_SCOPE);
}catch(Throwable t)
{
// some login act done later on (in next styles)
System.out.println(t);
return super.SKIP_BODY;
}
return super.EVAL_BODY_INCLUDE;
}
public int doAfterBody()
{
index++;
if(index==entities.size()) return super.SKIP_BODY;
Object entity=entities.get(index);
pageContext.setAttribute(name,entity,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1),PageContext.REQUEST_SCOPE);
return super.EVAL_BODY_AGAIN;
}
public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}