<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Product Detail"/>
<%@include file="common/header.jspf" %>

	<div class="backgroundimg">
		<div>
		<c:url value="/img/parks/${park.parkCode.toLowerCase()}.jpg" var="image"/>
		<img class="detailImage" src="${image}"/>
		</div>
		
		<div>
		<h2 class="heading"><c:out value="${park.parkName}"/></h2>
		</div>
		<div>
		<h3><c:out value="${park.state }"/></h3>
		</div>
		
		<div class="fontPara">
		<div><strong>Park Description:</strong> <c:out value="${park.parkDescription }"/></div>
		<div><strong>Acreage: </strong><c:out value="${park.acreage}"/> Acres </div>
		<div><strong>Elevation: </strong><c:out value="${park.elevationInFeet }"/> Feet</div>
		<div><strong>Miles of Trails: </strong><c:out value="${park.milesOfTrail}"/> Miles</div>
		<div><strong>Number of Campsites: </strong><c:out value="${park.numberOfCampsites }"/> Campsites</div>
		<div><strong>Climate: </strong><c:out value="${park.climate}"/></div>
		<div><strong>Year <c:out value="${park.parkName }"/> Joined the National Park System: </strong><c:out value="${park.yearFounded }"/></div>
		<div><strong>Visitors Annually:</strong> <c:out value="${park.annualVisitorCount}"/> Visitors</div>
		<div><strong>Park's Inspirational Quote:</strong> "<c:out value="${park.inspirationalQuote }"/>"</div>
		<div><strong>Quote From:</strong> <c:out value="${park.inspirationalQuoteSource}"/></div>
		<div><strong>Cost to Enter Park:</strong> $<c:out value="${park.entryFee}"/></div>
		<div><strong>Number of Animal Species within <c:out value="${park.parkName }"/>: </strong><c:out value="${park.numberOfAnimalSpecies }"/></div>
		</div><br><br>
	
		<div class="push"><h3>Today:</h3></div>
		<div>
			<div class="container-fluid">
				<div class="row">
			<c:forEach items="${weather}" var="weather">
				<c:url value="/img/weather/${weather.forecast}.png" var="image"/>
				<c:choose >
					<c:when test="${weather.fiveDayForecastValue < 2}">
					<div class="col-md-3">
					
					<img src="${image}" class="wPicBig"/>
					<div class="push">High: <c:out value="${weather.high}"/>&#176; </div>
					<div class="push">Low: <c:out value="${weather.low}"/>&#176;</div>
					<div class="push"><c:out value="${weather.forecast.toUpperCase()}"/></div>
					<div class=""><c:out value="${weather.printSaying(weather.forecast) }"/>
					<c:out value="${weather.printTempSaying(weather.high, weather.low) }"/></div>
					</div>
					</c:when>
					<c:otherwise>
					<div class="col-md-2">
					<img src="${image}" class="wPic"/>
					<div class="textCenter">High: <c:out value="${weather.high}"/> &#176;</div>
					<div class="textCenter">Low: <c:out value="${weather.low}"/> &#176;</div>
					</div>
					</c:otherwise>
					</c:choose>
			</c:forEach>
			</div>
			</div>
		</div>

	
	
	<c:url var="detailUrl" value="/parkDetail/${park.parkCode }"/>
	<form method="POST" action="${detailUrl}">
	
	<p>Fahrenheight or Celcius: </p>
	<input type="radio" name="tempLabel" value="celcius" /> Celcius<br>
	<input type="radio" name="tempLabel" value="fahrenheight" /> Fahrenheight<br>
	
	<input type="submit" value="submit"/>
	</form>
	</div>
	<%@include file="common/footer.jspf" %>