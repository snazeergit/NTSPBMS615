<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: red; text-align: center;">Actor Information
	Report</h1>

<c:choose>
	<c:when test="${!empty actorsInfo }">
		<table border="1" align="center" bgcolor="yellow">
			<tr>
				<th>ActorID</th>
				<th>ActorName</th>
				<th>Category</th>
				<th>MobileNo</th>
				<th>Operation</th>
			</tr>
			<c:forEach var="artist" items="${actorsInfo }">
				<tr>
					<td>${artist.actorId }</td>
					<td>${artist.actorName }</td>
					<td>${artist.category }</td>
					<td>${artist.mobileNo }</td>
					<td><a href="actor_edit?aid=${artist.actorId }">edit<img
							src="images/edit.jpeg" width="30px" height="30px" /></a></td>
					<td><a href="actor_delete?aid=${artist.actorId }">delete<img
							src="images/delete.jpeg" width="30px" height="30px" /></a></td>
				</tr>
			</c:forEach>
		</table>
		<h1 style="text-align: center; color: green;">${resultMsg }</h1>
		<center>
			<a href="actor_add"><b>Register</b><img src="images/add.jpeg"
				width="30px" height="30px" /></a>
		</center>
		<br>
		<br>
		<center>
			<a href="./"><b>Home</b><img src="images/home.jpeg" width="30px"
				height="30px" /></a>
		</center>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center;">Actors not found</h1>
	</c:otherwise>
</c:choose>