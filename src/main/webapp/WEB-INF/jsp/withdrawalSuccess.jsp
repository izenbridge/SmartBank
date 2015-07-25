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

<h1 style="text-align: center; font-size:36px;color:navy">Please collect your cash!</h1>
<br/>
<br/>

<p>Do you wish make another transaction?</p>
<br/>
<p>
<input type="button" value="YES" onclick="window.location='/SmartBank/options'" />
&nbsp;
<input type="button" class="cancel" value="NO" onclick="window.location='/SmartBank/logout'" />
</p>
</body>
</html>
