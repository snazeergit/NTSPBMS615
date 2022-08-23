<%@page isELIgnored="false" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan.jsp</title>
</head>
<body>
	<h1 style="color: blue; text-align: center">Loan Approval Page</h1>
	<b> Your approved loan amount Rs <%=new Random().nextInt(1000000)%>
		/- INR
	</b>
	<br><br><br>
	<a href="./">Home</a>
	<!-- <a href="logout">Logout</a> -->
	<a href="signout">Signout</a>
</body>
</html>