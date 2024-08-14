<%@taglib uri='/WEB-INF/mytags/kltags.tld' prefix='kl' %>
<script>
//Populating all the records in js array
var employee;
<kl:EntityList populatorClass='com.krish.lalwani.hr.bl.EmployeeBL' populatorMethod='getAll' name='employeeBean' >
employee=new Employee();
employee.employeeId="${employeeBean.employeeId}";
employee.name="${employeeBean.name}";
employee.designation="${employeeBean.designation}";
employee.dateOfBirth="${employeeBean.dateOfBirth}";
employee.gender="${employeeBean.gender}";
employee.isIndian=${employeeBean.isIndian};
employee.basicSalary="${employeeBean.basicSalary}";
employee.panNumber="${employeeBean.getPANNumber()}";
employee.aadharCardNumber="${employeeBean.aadharCardNumber}";
employees[${serialNumber-1}]=employee;
</kl:EntityList>
</script>