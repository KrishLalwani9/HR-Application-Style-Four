package com.krish.lalwani.hr.bl;
import com.krish.lalwani.hr.dl.*;
import com.krish.lalwani.hr.beans.*;
import java.util.*;
public class DesignationBL
{
List<DesignationBean> designations;
public DesignationBL()
{
designations=new ArrayList<>();
}
public List<DesignationBean> getAll()
{
List<DesignationDTO> dlDesignations=null;
try
{
dlDesignations=(new DesignationDAO()).getAll();
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage()); //to be changed after some time
}
DesignationBean designationBean=null;
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