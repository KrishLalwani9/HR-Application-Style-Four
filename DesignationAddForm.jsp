<%@taglib uri='/WEB-INF/mytags/kltags.tld' prefix='kl' %>
<kl:Module name='DESIGNATION' />
<jsp:include page='/MasterPageTopSection.jsp' />
<h2>Designation (Add Module)</h2>
<script src='/stylefour/js/DesignationAddForm.js'></script>
<span class='error' id='addDesignationErrorSection'></span>
Designation
<input type='text' id='title' maxlength='35' size='36'> 
<span id='titleErrorSection' class='error'></span><br> 
<button type='button' onclick='addDesignation()'>Add</button> 
<button type='button' onclick='cancelAddition()'>Cancel</button>
<form id='cencelAdditionForm' action='/stylefour/Designations.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />