package com.krish.lalwani.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
public class FormResubmittedTagHandler extends TagSupport
{
public FormResubmittedTagHandler()
{
reset();
}
public void reset()
{
//do Nothing
}
public int doStartTag()
{
HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
String formId=request.getParameter("formId");
if(formId==null)
{
return super.EVAL_BODY_INCLUDE;
}
String formIdInSession=(String)pageContext.getAttribute(formId,PageContext.SESSION_SCOPE);
if(formIdInSession==null) return super.EVAL_BODY_INCLUDE;
pageContext.removeAttribute(formId,PageContext.SESSION_SCOPE);
if(formId.equals(formIdInSession)) return super.SKIP_BODY;
else return super.EVAL_BODY_INCLUDE;
}
public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}
}