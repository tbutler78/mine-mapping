<cfinclude template="mineData.cfM">

<html>
<head>
<script type="text/javascript" src="http://maps.yahooapis.com/v3.5/fl/javascript/apiloader.js?appid=YahooDemo">
</script>
<style type="text/css">
#mapContainer {
  height: 90%;
  width: 90%;
}
</style>
</head>
<body>
<div id="mapContainer"></div>

<cfoutput>
<script type="text/javascript">
// Create a latitude/longitude object
var latlon = new LatLon(#startlat#, #startLong#);

// Display the map centered on that location with zoom level 3.
// Include your application ID. 
var map = new Map("mapContainer", "YahooDemo", latlon, 7);
// Make the map draggable 
map.addTool( new PanTool(), true );
map.addWidget(new SatelliteControlWidget());
map.addWidget( new NavigatorWidget()); 
map.setMapViewType(MapViews.HYBRID);



<cfloop query="qryMines">
	<cfset currentName = "#replaceNoCase(replaceNoCase(minename,'"','\"','all'),"'","\'","all")#">
	var marker#id# = new CustomPOIMarker('#listFirst(currentName,"(")#', '#listRest(currentName,"(")#', 'Test#id#', '0xFF0000', '0xFFFFFF'); 
	latlon = new LatLon(#latitude#,#longitude#);
	map.addMarkerByLatLon(marker#id#, latlon)
</cfloop>

</script>
</cfoutput>

<cfinclude template="mineForm.cfm">
</body>
</html>