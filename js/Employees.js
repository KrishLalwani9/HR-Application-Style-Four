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
