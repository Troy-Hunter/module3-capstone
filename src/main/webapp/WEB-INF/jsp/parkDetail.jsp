<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Product Detail"/>
<%@include file="common/header.jspf" %>

	
		<div>
		<c:url value="/img/parks/${park.parkCode.toLowerCase()}.jpg" var="image"/>
		<img src="${image}"/>
		</div>
		
		<div>
		<c:out value="${park.parkName}"/>
		</div>
		<div>
		<c:out value="${park.state }"/>
		</div>
		
		<div>
		<div>Park Description: <c:out value="${park.parkDescription }"/></div>
		<div>Acreage: <c:out value="${park.acreage}"/> Acres </div>
		<div>Elevation: <c:out value="${park.elevationInFeet }"/> Feet</div>
		<div>Miles of Trails: <c:out value="${park.milesOfTrail}"/> Miles</div>
		<div>Number of Campsites: <c:out value="${park.numberOfCampsites }"/> Campsites</div>
		<div>Climate: <c:out value="${park.climate}"/></div>
		<div>Year <c:out value="${park.parkName }"/> Joined the National Park System: <c:out value="${park.yearFounded }"/></div>
		<div>Visitors Annually: <c:out value="${park.annualVisitorCount}"/> Visitors</div>
		<div>Park's Inspirational Quote: "<c:out value="${park.inspirationalQuote }"/>"</div>
		<div>Quote From: <c:out value="${park.inspirationalQuoteSource}"/></div>
		<div>Cost to Enter Park: <c:out value="${park.entryFee}"/></div>
		<div>Number of Animal Species within <c:out value="${park.parkName }"/>: <c:out value="${park.numberOfAnimalSpecies }"/></div>
		</div>
	
		<div>
			<c:forEach items="${weather}" var="weather">
				<c:url value="/img/weather/${weather.forecast}.png" var="image"/>
				<img src="${image}"/>
				<div><c:out value="${weather.high}"/></div>
				<div><c:out value="${weather.low}"/></div>
				
				<div><c:out value="${weather.forecast}"/></div>
				<div><c:out value="${weather.printSaying(weather.forecast) }"/></div>
				<div><c:out value="${weather.printTempSaying(weather.high, weather.low) }"/></div>
			</c:forEach>
		</div>

	
	
	<c:url var="detailUrl" value="/parkDetail/${park.parkCode }"/>
	<form method="POST" action="${detailUrl}">
	
	<p>Fahrenheight or Celcius: </p>
	<input type="radio" name="tempLabel" value="celcius" /> Celcius<br>
	<input type="radio" name="tempLabel" value="fahrenheight" /> Fahrenheight<br>
	
	<input type="submit" value="submit"/>
	</form>
	
	<%@include file="common/footer.jspf" %>