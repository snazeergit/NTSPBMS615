<%@page isELIgnored="false" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance.jsp</title>
</head>
<body>
	<h1 style="color: blue; text-align: center">Balance Check Page</h1>
	<b> Balance Amount :: Rs <%=new Random().nextInt(100000)%> /- INR
	</b><br><br><br>
	<a href="./">Home</a>
	<!-- <a href="logout">Logout</a> -->
	<a href="signout">Signout</a>
</body>
</html>