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
			</tr>
			<c:forEach var="artist" items="${actorsInfo }">
				<tr>
					<td>${artist.actorId }</td>
					<td>${artist.actorName }</td>
					<td>${artist.category }</td>
					<td>${artist.mobileNo }</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center;">Actors not found</h1>
	</c:otherwise>
</c:choose>