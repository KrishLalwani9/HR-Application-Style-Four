package com.krish.lalwani.hr.beans;
import com.krish.lalwani.hr.dl.*;
import java.util.*;
public class AnyClassBean
{
List<DesignationBean> designations;
public AnyClassBean()
{
this.designations=null;
}
public List<DesignationBean> getAll()
{
List<DesignationDTO> dlDesignations=null;
try
{
dlDesignations=(new DesignationDAO()).getAll();
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
DesignationBean designationBean=null;
designations=new ArrayList<>();
for(DesignationDTO dlDesignation : dlDesignations)
{
designationBean=new DesignationBean();
designationBean.setCode(dlDesignation.getCode());
designationBean.setTitle(dlDesignation.getTitle());
designations.add(designationBean);
}
return designations;
}
}