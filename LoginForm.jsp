<%@taglib uri='/WEB-INF/mytags/kltags.tld' prefix='kl' %>
<jsp:useBean id='errorBean' scope='request' class='com.krish.lalwani.hr.beans.ErrorBean' />
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>HR Application</title>
<script src='/stylefour/js/LoginForm.js'></script>
<link rel='stylesheet' type='text/css' href='/stylefour/css/styles.css'>
</head>
<body>
<!-- Main Continer starts here -->
<div class='main-container'>
<!-- header starts here -->
<div class='header'>
<a href='/stylefour/index.jsp'><image src='/stylefour/images/logo.png' class='logo'></a>
<div class='brand-name'>Krish Lalwani</div>
</div> <!-- header ends here -->
<!-- content-section starts here -->
<div class='content-panel'>
<h1 style='text-align:center'>Administrator</h1>
<!-- Login Panel Starts Here -->
<div class='login-panel'>
<form method='post' action='/stylefour/Login.jsp' onsubmit='return validateForm(this)'>
<table border='0'>
<tr>
<td colspan='2' align='center'><span class='error'>${errorBean.error}</span></td>
</tr>
<tr>
<td>Username</td>
<td><input type='text' name='username' id='username' maxlength='16' size='16'>
<span id='usernameErrorSection' class='error'></span>
</td>
</tr>
<tr>
<td>Password</td>
<td><input type='password' name='password' id='password' maxlength='16' size='16'>
<span id='passwordErrorSection' class='error'></span>
</td>
</tr>
<tr>
<td colspan='2'><button type='submit'>Login</button></td>
</tr>
</table>
</form>
</div> <!-- Login Panel ends here -->
</div> <!-- conten-section ends here -->
<!-- footer starts here -->
<div class='footer'>
&copy; Krish Lalwani 2050
</div> <!-- footer ends here -->
</div> <!-- Main Continer ends here -->
</body>
</html>