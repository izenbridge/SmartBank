<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Cash Withdrawal - SmartBank ATM</title>
    <link href='<c:url value="/style/main.css" />' rel="stylesheet" />
</head>
<body>
<p><img src="<c:url value="/image/SmartBank-logo.jpg" />" /></p>

<h1 style="text-align: center; font-size:36px;color:navy">Cash Withdrawal</h1>

<form:form method="POST" action="/SmartBank/withdrawal" commandName="withdrawalRequest">
<form:hidden path="debitCardNumber" name="debitCardNumber" />

<c:if test="${not empty errorMsg}">
	<p class="error"><c:out value="${errorMsg}" /></p>
</c:if>
<c:if test="${empty errorMsg}">
	<p>Please enter the amount you wish to withdraw from your account.</p>
</c:if>

<br/>
<p>Amount to Withdraw: <form:input path="requestedAmount" maxlength="5" size="6" name="requestedAmount"/></p>
<p class="note">NOTE: The amount must be in multiples of Rs 100 and be less than Rs 25,000.</p>

<p><input type="button" value="CLEAR" onclick="document.getElementById('requestedAmount').value=''" /> 
&nbsp; <input type="submit" value="WITHDRAW" /></p>
</form:form>


<br/>
<input type="button" class="cancel" value="EXIT / CANCEL" onclick="window.location='/SmartBank/'" />

</body>
</html>
