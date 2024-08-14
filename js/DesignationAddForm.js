function addDesignation()
{
var title=document.getElementById('title').value;

var titleErrorSection=document.getElementById('titleErrorSection');
titleErrorSection.innerHTML='';
if(title.length==0)
{
titleErrorSection.innerHTML='Designation Required';
//title.focus();
return;
}
var designationJson={
"code":0,
"title":title
};
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(this.readyState==4)
{
if(this.status==200)
{
var responseData=this.responseText;
alert(responseData);
if(responseData=='Invalid')
{
alert("Invalid designation title");
}
else
{
var designation=JSON.parse(responseData);
}
}
else
{
alert('some problem occured');
}
}
};
xmlHttpRequest.open('POST','addDesignation',true);
xmlHttpRequest.setRequestHeader("Content-Type","application/json");
xmlHttpRequest.send(JSON.stringify(designationJson));
}
function cancelAddition()
{
document.getElementById('cencelAdditionForm').submit();
}
