<%@taglib uri='/WEB-INF/mytags/kltags.tld' prefix='kl' %>
<kl:Module name='DESIGNATION' />
<jsp:useBean id='designationBean' scope='request' class='com.krish.lalwani.hr.beans.DesignationBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/ConfirmDeleteDesignation.js'></script>
<h2>Designation (Delete Module)</h2>
<form method='post' action='/styletwo/DeleteDesignation.jsp' onsubmit='return validateForm(this)'>
Designation :&nbsp;&nbsp;
<kl:FormId /> 
<input type='hidden' id='code' name='code' value='${designationBean.code}'>
<b>${designationBean.title}</b><br><br> <!-- We also can write <%=designationBean.getTitle()%> -->
Are you sure, you want to delete ?
<span id='titleErrorSection' class='error'></span><br> 
<button type='submit'>Yes</button> 
<button type='button' onclick='cancelDeletion()'>No</button>
</form> 
<form id='cancelDeletionForm' action='/styletwo/Designations.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />
