<%@taglib uri='/WEB-INF/mytags/kltags.tld' prefix='kl' %>
<kl:Module name='DESIGNATION' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/stylefour/js/Designations.js'></script>
<h2>Designations</h2>
<table border='1'>
<thead>
<tr>
<th colspan='4' class='table-heading'>
<a href='/stylefour/DesignationAddForm.jsp'>Add New Designation</a>
</th>
</tr>
<tr>
<th style='width:60px;text-align:center'> S.NO </th>
<th style='width:200px'> Designation </th>
<th style='width:100px'> Edit </th>
<th style='width:100px'> Delete </th>
</tr>
</thead>
<tbody id='designationsGridTableBody'>
<tr>
<td placeHolderId='code'></td>
<td placeHolderId='title'></td>
<td style='text-align:center' placeHolderId='editOption'></td>
<td style='text-align:center' placeHolderId='deleteOption'></td>
</tr>
</tbody>
</table>
<jsp:include page='/MasterPageBottomSection.jsp' />
