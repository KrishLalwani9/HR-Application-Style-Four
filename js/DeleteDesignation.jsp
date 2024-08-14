<jsp:useBean id='designationBean' socpe='request' class='com.krish.lalwani.hr.beans.DesignationBean' />
<jsp:getProperty name='designationBean' property='*' />
<jsp:forward page='/deleteDesignation' />