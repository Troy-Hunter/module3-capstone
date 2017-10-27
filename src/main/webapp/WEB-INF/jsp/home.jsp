<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home"/>
<%@include file="common/header.jspf" %>

	<c:url var="homeUrl" value="/"/>
	<form:form method="GET" action="${homeUrl}">
	<div class="background">
	<c:forEach items="${allParks}" var="park">
		<div class="inline"><c:url value="/parkDetail/${park.parkCode}" var="parkDetail"/>
		<c:url value="img/parks/${park.parkCode.toLowerCase()}.jpg" var="image"/>
		<a href="${parkDetail}"> <img src="${image}"/> </a> </div>
		<div class="inline">
		<div><c:out value="${park.parkName }"/></div>
		<div><c:out value="${park.state }"/></div>
		<div><c:out value="${park.parkDescription}"/></div>
		</div>
	</c:forEach>
	</div>
	</form:form>
	
	<%@include file="common/footer.jspf" %>