function Employee() //this is class 
{
this.employeeId=""; //this is public properties 
this.name="";
this.designation="";
this.dateOfBirth="";
this.gender="";
this.isIndian=true;
this.basicSalary="";
this.panNumber="";
this.aadharCardNumber="";
}
var employees=[];
var selectedRow=null;
var i=0;
function selectEmployee(row,employeeId)
{
if(row==selectedRow) return;
if(selectedRow!=null)
{
selectedRow.style.background='white'
selectedRow.style.color='black';
}
row.style.background='#7C7B7B';
row.style.color='white';
selectedRow=row;
for(i=0;i<employees.length;i++)
{
if(employees[i].employeeId==employeeId)
{
document.getElementById('detailsPanel_employeeId').innerHTML=employees[i].employeeId;
document.getElementById('detailsPanel_name').innerHTML=employees[i].name;
document.getElementById('detailsPanel_designation').innerHTML=employees[i].designation;
document.getElementById('detailsPanel_dateOfBirth').innerHTML=employees[i].dateOfBirth;
document.getElementById('detailsPanel_gender').innerHTML=employees[i].gender;
document.getElementById('detailsPanel_isIndian').innerHTML=((employees[i].isIndian) ? 'Yes' : 'No');
document.getElementById('detailsPanel_basicSalary').innerHTML=employees[i].basicSalary;
document.getElementById('detailsPanel_panNumber').innerHTML=employees[i].panNumber;
document.getElementById('detailsPanel_aadharCardNumber').innerHTML=employees[i].aadharCardNumber;
break;
}
}
}
function createDynamicRowClickHandler(dynamicRow,employeeId)
{
return function(){selectEmployee(dynamicRow,employeeId)};
}
function populateEmployeesGridTable()
{
var employeesGridTable=document.getElementById('employeesGridTable');
let employeesGridTableBody=employeesGridTable.getElementsByTagName('tbody')[0];
let employeesGridTableBodyRowTemplate=employeesGridTableBody.getElementsByTagName('tr')[0];
employeesGridTableBodyRowTemplate.remove(); //removed from dom but not from memory
let cellTemplate;
var dynamicRow;
let dynamicRowCells;
let placeHolderFor;
let employee;
for(let k=0;k<employees.length;k++)
{
dynamicRow=employeesGridTableBodyRowTemplate.cloneNode(true); //for deep cloning write true
employeesGridTableBody.appendChild(dynamicRow); 
//dynamicRow.addEventListener('click',selectEmployee(dynamicRow,employee.employeeId));
dynamicRowCells=dynamicRow.getElementsByTagName('td');
employee=employees[k];
for(let i=0;i<dynamicRowCells.length;i++)
{
cellTemplate=dynamicRowCells[i];
placeHolderFor=cellTemplate.getAttribute('placeHolderId');
if(placeHolderFor==null) continue;
if(placeHolderFor=='serialNumber') cellTemplate.innerHTML=k+1;
else if(placeHolderFor=='employeeId') cellTemplate.innerHTML=employee.employeeId;
else if(placeHolderFor=='name') cellTemplate.innerHTML=employee.name;
else if(placeHolderFor=='designationCode') cellTemplate.innerHTML=employee.designationCode;
else if(placeHolderFor=='designation') cellTemplate.innerHTML=employee.designation;
else if(placeHolderFor=='dateOfBirth') cellTemplate.innerHTML=employee.dateOfBirth;
else if(placeHolderFor=='gender') cellTemplate.innerHTML=employee.gender;
else if(placeHolderFor=='isIndian') cellTemplate.innerHTML=employee.isIndian;
else if(placeHolderFor=='basicSalary') cellTemplate.innerHTML=employee.basicSalary;
else if(placeHolderFor=='panNumber') cellTemplate.innerHTML=employee.panNumber;
else if(placeHolderFor=='aadharCardNumber') cellTemplate.innerHTML=employee.aadharCardNumber;
else if(placeHolderFor=='editOption') cellTemplate.innerHTML="<a href='/styletwo/editEmployee?employeeId="+employee.employeeId+"'>Edit</a>";
else if(placeHolderFor=='deleteOption') cellTemplate.innerHTML="<a href='/styletwo/confirmDeleteEmployee?employeeId="+employee.employeeId+"'>Delete</a>";
}
dynamicRow.onclick=createDynamicRowClickHandler(dynamicRow,employee.employeeId);
//onclick='selectEmployee(this,"${employeeBean.employeeId}")'
} //employees loop emds here
}
window.addEventListener('load',populateEmployeesGridTable); <!-- we are saying to window(the global variable) that when whole document is loaded in memory call this function -->