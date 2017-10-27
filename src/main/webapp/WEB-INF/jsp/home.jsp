<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home"/>
<%@include file="common/header.jspf" %>
<div class="backgroundImgHome">
	<c:url var="homeUrl" value="/"/>
	<form:form method="GET" action="${homeUrl}">
	<div>
	<c:forEach items="${allParks}" var="park">
		<h2 class="textPos heading"><strong><c:out value="${park.parkName }"/></strong></h2><br>
		<div class="container space">
			<div class="row">
				<div class="col " >
				<c:url value="/parkDetail/${park.parkCode}" var="parkDetail"/>
				<c:url value="img/parks/${park.parkCode.toLowerCase()}.jpg" var="image"/>
				<a href="${parkDetail}"> <img style="float:left" class="picReform" src="${image}"/> </a> 
				</div>

				<div class="col fontPara">
				<h3><c:out value="${park.state }"/></h3><br>
				<c:out value="${park.parkDescription}"/>
				</div>
				
			</div>
		</div>
		
	</c:forEach>
	</div>
	</form:form>
	</div>
	<%@include file="common/footer.jspf" %>