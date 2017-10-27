<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home"/>
<%@include file="common/header.jspf" %>

<div id="survey">
<h1 class="text4">Favorite Parks</h1>
<section class="jumbotron album card jumbotron p:last-child jumbotron-heading jumbotron .container card > img card-text ">
<div class="container-fluid">
<div class = "row">
<c:forEach items="${parks}" var ="parks">
	
	<div class="col-md-4">
			<c:url value="${parks.parkCode.toLowerCase()}" var="pic"/>
			<img src="img/parks/${pic}.jpg" class="size"/>
			<div class="text2">
			<c:out value="${parks.parkName }"/><br>
			</div>
			<c:out value="${parks.parkDescription }"/>
			</div>	
</c:forEach>
	</div>
	</div>
	<br><br>
<!-- 	<div> -->
<!-- 		<table> -->
<!-- 		 <tr> -->
<%-- 			<td><c:url value="${parks.parkCode.toLowerCase()}" var="pic"/> --%>
<%-- 			<img src="img/parks/${pic}.jpg" class="size"/></td> --%>
<!-- 			</tr> -->
<!-- 		 <tr class="text2"> -->
<%-- 			<td><c:out value="${parks.parkName }"/><br></td></tr> --%>
<!-- 		 <tr class="text3"> -->
<%-- 			<td><c:out value="${parks.parkDescription }"/></td> --%>
<!-- 		 </tr> -->
<!-- 		</table> -->
<!-- 	</div><br><br> -->

</div>
</div>
</section>

<%@include file="common/footer.jspf" %>