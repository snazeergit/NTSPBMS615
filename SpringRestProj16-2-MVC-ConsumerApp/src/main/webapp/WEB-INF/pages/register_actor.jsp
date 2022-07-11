<%@page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<h1 style="text-align: center; color: blue">Actor registration form</h1>

<!-- modelAttribute name must match with @ModelAttribute specified in the handler method with GetMapping("/actor_add") -->
<!-- Specifying action and method are optional POST is the defult method used in mvc tags -->
<f:form action="actor_add" modelAttribute="actor" method="POST">
	<table bgcolor="cyan" align="center">
		<tr>
			<td>Actor Name :</td>
			<!-- path value must match with Model class properties i.e. Actor class variables -->
			<td><f:input path="actorName" /></td>
		</tr>

		<tr>
			<td>Category :</td>
			<!-- path value must match with Model class properties i.e. Actor class variables -->
			<td><f:input path="category" /></td>
		</tr>

		<tr>
			<td>Mobile No :</td>
			<!-- path value must match with Model class properties i.e. Actor class variables -->
			<td><f:input path="mobileNo" /></td>
		</tr>

		<tr>
			<td colspan="2" align="center"><input type="submit" value="register" /></td>
		</tr>

	</table>
</f:form>