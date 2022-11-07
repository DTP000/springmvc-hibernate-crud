<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>CRM - Company Relationship Manager</h2>
			<hr />

			<input type="button" value="Add Company"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" />
				<br/><br/>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Company List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>Name</th>
							<th>Tel</th>
							<th>TaxNo</th>
							<th>Address</th>
							<th>Email</th>
							<th>Description</th>
						</tr>

						<!-- loop over and print our customers -->
						<c:forEach var="tempCompany" items="${companies}">

							<!-- construct an "update" link with customer id -->
							<c:url var="updateLink" value="/company/updateForm">
								<c:param name="companyId" value="${tempCompany.id}" />
							</c:url>

							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/company/delete">
								<c:param name="companyId" value="${tempCompany.id}" />
							</c:url>

							<tr>
								<td>${tempCompany.name}</td>
								<td>${tempCompany.tel}</td>
								<td>${tempCompany.taxNo}</td>
								<td>${tempCompany.address}</td>
								<td>${tempCompany.email}</td>
								<td>${tempCompany.description}</td>

								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>

				</div>
			</div>
		</div>

	</div>
</body>

</html>









