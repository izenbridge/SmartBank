<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false" %>

<html>
<head>
	<title>ATM Login - SmartBank ATM</title>
    <link href="<c:url value="/style/main.css" />" rel="stylesheet" />
</head>

<body>
<p><img src="<c:url value="/image/SmartBank-logo.jpg" />" /></p>

<form:form method="POST" action="/SmartBank/login" commandName="loginRequest">
<c:if test="${not empty errorMsg}">
	<p class="error"><c:out value="${errorMsg}" /></p>
	<br/>
</c:if>
<p>Please enter your Debit Card number and ATM PIN to access your account:</p>
<p>DEBIT CARD #: <form:input path="debitCardNumber" maxlength="16" name="txtCardNo" size="20" /></p>
<p>ATM PIN: <form:password path="atmPin" maxlength="4" name="txtPIN" size="6" /></p>

<p><input type="submit" value="ACCESS ACCOUNT" /></p>
</form:form>

<br/>
<input type="button" class="cancel" value="EXIT / CANCEL" onclick="window.location='/SmartBank/'" />

</body>
</html>
