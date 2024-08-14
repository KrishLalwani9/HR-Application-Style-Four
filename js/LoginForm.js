function validateForm(frm)
{
var uname=frm.username.value.trim();
var usernameErrorSection=document.getElementById('usernameErrorSection');
usernameErrorSection.innerHTML='';
if(uname.length==0)
{
usernameErrorSection.innerHTML='username Required';
frm.username.focus();
return false;
}
var pwd=frm.password.value.trim();
var passwordErrorSection=document.getElementById('passwordErrorSection');
passwordErrorSection.innerHTML='';
if(pwd.length==0)
{
passwordErrorSection.innerHTML='password Required';
frm.password.focus();
return false;
}
return true;
}
