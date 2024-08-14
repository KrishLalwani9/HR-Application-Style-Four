package com.krish.lalwani.hr.tags;
import com.krish.lalwani.hr.dl.*;
import com.krish.lalwani.hr.beans.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
public class DesignationsTagHandler extends BodyTagSupport
{
List<DesignationBean> designations;
int index;
public DesignationsTagHandler()
{
if(this.designations!=null)
{
this.designations.clear();
this.designations=null;
}
reset();
}
public void reset()
{
}
public int doStartTag()
{
List<DesignationDTO> dlDesignations=null;
try
{
dlDesignations=(new DesignationDAO()).getAll();
}catch(DAOException daoException)
{
return super.SKIP_BODY;
}
if(dlDesignations.size()==0) return super.SKIP_BODY;
index=0;
DesignationBean designationBean=null;
designations=new ArrayList<>();
for(DesignationDTO dlDesignation : dlDesignations)
{
designationBean=new DesignationBean();
designationBean.setCode(dlDesignation.getCode());
designationBean.setTitle(dlDesignation.getTitle());
designations.add(designationBean);
}
designationBean=designations.get(index);
pageContext.setAttribute("designationBean",designationBean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1));
return super.EVAL_BODY_INCLUDE;
}
public int doAfterBody()
{
index++;
if(index==designations.size()) return super.SKIP_BODY;
DesignationBean designationBean=designations.get(index);
pageContext.setAttribute("designationBean",designationBean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1));
return super.EVAL_BODY_AGAIN;
}
public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}