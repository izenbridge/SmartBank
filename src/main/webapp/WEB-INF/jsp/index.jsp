<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Welcome - SmartBank ATM</title>
    <link href='<c:url value="/style/main.css" />' rel="stylesheet" />
</head>
<body>
<p><img id="logo" src="<c:url value="/image/SmartBank-logo.jpg" />" /></p>

<h1 style="text-align: center;"><span style="font-size:36px;color:navy">Welcome!</span></h1>

<p>Welcome to SmartBank ATM where you can access your account at your convenience, <br/>any time of the day, any day of the week.&nbsp;</p>
<br/>
<p id="instructions" style="font-style:italic;">NOTE: To access your account, you will need your ATM card and your ATM PIN.&nbsp;</p>

<br/>

<p><input id="btnBegin" style="width:120px" type="submit" value="BEGIN &gt;&gt;" onclick="window.location='/SmartBank/login'" /></p>

</body>
</html>
