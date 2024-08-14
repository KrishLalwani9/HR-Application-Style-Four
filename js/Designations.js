function designationsPopulator()
{
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status==200)
{
let responseData=this.responseText;
if(responseData=="Invalid")
{
alert('!Oops something is not good');
}
else
{
let designationsGridTableBody=document.getElementById('designationsGridTableBody');
let designationsGridTableBodyRowElement=designationsGridTableBody.getElementsByTagName('tr')[0];
designationsGridTableBodyRowElement.remove();
let designations=JSON.parse(responseData);
let dynamicRow;
let dynamicRowCells;
var cellTemplate;
let placeHolderId;
for(let i=0;i<designations.length;i++)
{
dynamicRow=designationsGridTableBodyRowElement.cloneNode(true);
designationsGridTableBody.appendChild(dynamicRow);
dynamicRowCells=dynamicRow.getElementsByTagName('td');
for(let j=0;j<dynamicRowCells.length;j++)
{
cellTemplate=dynamicRowCells[j];
placeHolderId=cellTemplate.getAttribute("placeHolderId");
if(placeHolderId==null) continue;
if(placeHolderId=='code') cellTemplate.innerHTML=i+1;
else if(placeHolderId=='title') cellTemplate.innerHTML=designations[i].title;
else if(placeHolderId=='editOption') cellTemplate.innerHTML="<a href='/stylefour/editDesignation?code="+designations[i].code+"'>Edit</a>";
else if(placeHolderId=='deleteOption') cellTemplate.innerHTML="<a href='/stylefour/confirmDeleteDesignation?code="+designations[i].code+"'>Delete</a>";
}
}
}
}
else
{
alert('some problem occured');
}
}
};
xmlHttpRequest.open("GET","designations",true);
xmlHttpRequest.send();
}
window.addEventListener('load',designationsPopulator);
