package com.krish.lalwani.hr.bl;
import com.krish.lalwani.hr.dl.*;
import com.krish.lalwani.hr.beans.*;
import java.util.*;
import java.text.*;
public class EmployeeBL
{
List<EmployeeBean> employees;
public EmployeeBL()
{
employees=new ArrayList<>();
}
public List<EmployeeBean> getAll()
{
List<EmployeeDTO> dlEmployees=null;
try
{
dlEmployees=(new EmployeeDAO()).getAll();
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage()); //to be changed after some time
}
EmployeeBean employeeBean=null;
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
for(EmployeeDTO dlEmployee : dlEmployees)
{
employeeBean=new EmployeeBean();
employeeBean.setEmployeeId(dlEmployee.getEmployeeId());
employeeBean.setName(dlEmployee.getName());
employeeBean.setDesignationCode(dlEmployee.getDesignationCode());
employeeBean.setDesignation(dlEmployee.getDesignation());
employeeBean.setDateOfBirth(sdf.format(dlEmployee.getDateOfBirth()));
employeeBean.setGender(dlEmployee.getGender());
employeeBean.setIsIndian(dlEmployee.getIsIndian());
employeeBean.setBasicSalary(dlEmployee.getBasicSalary().toPlainString());
employeeBean.setPANNumber(dlEmployee.getPANNumber());
employeeBean.setAadharCardNumber(dlEmployee.getAadharCardNumber());
employees.add(employeeBean);
}
return employees;
}
}