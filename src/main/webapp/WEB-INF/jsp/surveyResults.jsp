<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home"/>
<%@include file="common/header.jspf" %>

<h1>Survey Poll</h1>

<c:forEach items="${parks}" var ="parks">
	<div>
	<c:url value="${parks.parkCode.toLowerCase()}" var="pic"/>
	<img src="img/parks/${pic}.jpg"/>
	<c:out value="${parks.parkName }"/>
	<c:out value="${parks.parkDescription }"/>
	</div><br><br>
</c:forEach>


<%@include file="common/footer.jspf" %>