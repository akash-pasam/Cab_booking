<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@include file="../common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
<meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no" />
<script src="https://api.mapbox.com/mapbox-gl-js/v1.11.1/mapbox-gl.js"></script>
<link href="https://api.mapbox.com/mapbox-gl-js/v1.11.1/mapbox-gl.css" rel="stylesheet" />
<style>
	body { margin: 0; padding: 0; }
	#map { position: absolute; top: 0; bottom: 0; width: 100%; }
</style>
</head>
<body>
<script src="https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-geocoder/v4.5.1/mapbox-gl-geocoder.min.js"></script>
<link
rel="stylesheet"
href="https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-geocoder/v4.5.1/mapbox-gl-geocoder.css"
type="text/css"
/>
<link href="css/style.css" rel="stylesheet">
<!-- Promise polyfill script required to use Mapbox GL Geocoder in IE 11 -->
<script src="https://cdn.jsdelivr.net/npm/es6-promise@4/dist/es6-promise.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/es6-promise@4/dist/es6-promise.auto.min.js"></script>
<div id="map"></div>
<div id="geocoder" class="geocoder"></div>
<div id="geocoder2" class="geocoder2"></div>
<script>
	mapboxgl.accessToken = 'pk.eyJ1IjoiYWthc2gwOTgiLCJhIjoiY2tjdmlyaWl5MDRrbjJybnhtcTYyZzd4MiJ9.N3ejUNbWKRCltUK0NQTXgg';
	var map = new mapboxgl.Map({
		container: 'map',
		style: 'mapbox://styles/mapbox/streets-v11',
		center: [79,18],
		zoom: 6
		});
 
	map.addControl(new mapboxgl.NavigationControl());
	var geocoder = new MapboxGeocoder({
		accessToken: mapboxgl.accessToken,
		mapboxgl: mapboxgl
		});
	document.getElementById('geocoder').appendChild(geocoder.onAdd(map));
	var geocoder2 = new MapboxGeocoder({
		accessToken: mapboxgl.accessToken,
		mapboxgl: mapboxgl
		});

	document.getElementById('geocoder2').appendChild(geocoder2.onAdd(map));
	geocoder.on('result', function(ev){
		document.getElementById("from").value=ev.result.place_name;
		document.getElementById("lng1").value=ev.result.geometry.coordinates[0];
		document.getElementById("lat1").value=ev.result.geometry.coordinates[1];
	});
	geocoder2.on('result', function(ev){
		document.getElementById('to').value=ev.result.place_name;
		document.getElementById("lng2").value=ev.result.geometry.coordinates[0];
		document.getElementById("lat2").value=ev.result.geometry.coordinates[1];
	});
</script>
<form method="post">
    <div class="container">
      <h1>Book a cab</h1>
      <hr>
      <div class="fromlocation">
      <label>From location</label>
      <input  type="hidden" id="from" value="" name="from_location">
      <input type="hidden" id="lat1" name="latitude1" "value="">
      <input type="hidden" id="lng1" name="longitude1" value="">
      </div>
      <div class="tolocation">
      <label>To Location</label>
      <input type="hidden" id="to" value="" placeholder="To location" name="to_location" >
      <input type="hidden" id="lat2" name="latitude2" value="">
      <input type="hidden" id="lng2"  name="longitude2" value="">
      </div>
      <div class="passengers">
      <label> No of Passengers</label>
      <input type="number" placeholder="Enter No of Passengers" name="number" required>
      </div>
      <input class="booking-btn" type="submit">
      <hr>
    </div>
  </form>
</body>
</html>