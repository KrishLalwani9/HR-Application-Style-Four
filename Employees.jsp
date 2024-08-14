<%@taglib uri='/WEB-INF/mytags/kltags.tld' prefix='kl' %>
<kl:Module name='EMPLOYEE' />
<jsp:useBean id='errorBean' scope='request' class='com.krish.lalwani.hr.beans.ErrorBean' /> 
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/Employees.js'></script>
<link rel='stylesheet' type='text/css' href='/styletwo/css/employees.css' />
<!-- table panel starts here -->
<div class='employeeGrid'>
<h3>Employees</h3>
<table border='1' id='employeesGridTable'>
<thead>
<tr>
<th colspan='6' class='employeeGridHeader'>
<a href='/styletwo/getEmployeeAddForm'>Add Employee</a>
</th>
</tr>
<tr>
<th class='employeeGridSNOColumnTitle'>S.No.</th>
<th class='employeeGridEmployeeIdColumnTitle'>EmployeeId</th>
<th class='employeeGridNameColumnTitle'>Name</th>
<th class='employeeGridDesignationColumnTitle'>Designation</th>
<th class='employeeGridEditOptionColumnTitle'>Edit</th>
<th class='employeeGridDeleteOptionColumnTitle'>Delete</th>
</tr>
</thead>
<tbody>

<tr style='cursor:pointer'>
<td style='text-align:right' placeHolderId='serialNumber'></td>
<td placeHolderId='employeeId'></td>
<td placeHolderId='name'></td>
<td placeHolderId='designation'></td>
<td style='text-align:center' placeHolderId='editOption'></td>
<td style='text-align:center' placeHolderId='deleteOption'></td>
</tr>

</tbody>
</table>
</div><!-- table panel ends here -->
<!-- details panel starts here -->
<div style='height:19vh;marigin:5px;padding:5px;border:1px solid black'>
<lable style='background:gray;color:white;padding-left:5px;padding-right:5px'>Details</lable>
<table border='0' width='100%'>
<tr>
<td>EmployeeId : <span id='detailsPanel_employeeId' style='margin-right:30px'></span></td>
<td>Name : <span id='detailsPanel_name' style='margin-right:30px'></span></td>
<td>Desigantion : <span id='detailsPanel_designation' style='margin-right:30px'></span></td>
</tr>
<tr>
<td>Date of birth : <span id='detailsPanel_dateOfBirth' style='margin-right:30px'></span></td>
<td>Gender : <span id='detailsPanel_gender' style='margin-right:30px'></span></td>
<td>IsIndian : <span id='detailsPanel_isIndian' style='margin-right:30px'></span></td>
</tr>
<tr>
<td>Basic Salary : <span id='detailsPanel_basicSalary' style='margin-right:30px'></span></td>
<td>PAN Number : <span id='detailsPanel_panNumber' style='margin-right:30px'></span></td>
<td>Aadhar Card Number : <span id='detailsPanel_aadharCardNumber' style='margin-right:30px'></span></td>
</tr>
</table>
</div><!-- details panel ends here -->
<jsp:include page='/MasterPageBottomSection.jsp' />
