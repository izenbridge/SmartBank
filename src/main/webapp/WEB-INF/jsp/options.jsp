<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>ATM Options - SmartBank ATM</title>
    <link href='<c:url value="/style/main.css" />' rel="stylesheet" />
</head>
<body>
<p><img src="<c:url value="/image/SmartBank-logo.jpg" />" /></p>

<h1 style="text-align: center; font-size:36px;color:navy">Authentication Successful!</h1>

<p>Please select the transaction you wish to make:&nbsp;</p>
<br/>
<p><input type="button" value="WITHDRAWAL" onclick="window.location='/SmartBank/withdrawal'" /></p>
<br/>
<br/>
<input type="button" class="cancel" value="EXIT / CANCEL" onclick="window.location='/SmartBank/'" />

</body>
</html>
