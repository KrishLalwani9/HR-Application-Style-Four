package com.krish.lalwani.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
public class GuardTagHandler extends TagSupport
{
public GuardTagHandler()
{
reset();
}
public void reset()
{
//Do nothing
}

public int doStartTag()
{
String username=(String)pageContext.getAttribute("username",PageContext.SESSION_SCOPE);
if(username==null) return super.EVAL_BODY_INCLUDE;
return super.SKIP_BODY;
}

public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}
}