<%@taglib uri='/WEB-INF/mytags/kltags.tld' prefix='kl' %>
<kl:If condition='${username==null}'> <!-- my approach -->
<jsp:forward page='/LoginForm.jsp' />
</kl:If>
<kl:Guard> <!-- sir's approach -->
<jsp:forward page='/LoginForm.jsp' />
</kl:Guard>
<kl:Module name='DESIGNATION' />
<jsp:useBean id='designationBean' scope='request' class='com.krish.lalwani.hr.beans.DesignationBean' />
<jsp:setProperty name='designationBean' property='*' />
<jsp:forward  page='/updateDesignation' />