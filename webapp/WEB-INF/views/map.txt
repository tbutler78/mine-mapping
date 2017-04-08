<link rel="stylesheet" type="text/css" href="http://www.tourre.com/common_files/styles/contentstyle.css">

<cfparam name="url.countyid" default="1">
<cfparam name="url.feature" default="mine">
<cfparam name="url.keywords" default="">
<cfset featureList = "Mine,Prospect,Tunnel,Mill,Placer,Shaft,Adit,All">

<cfquery datasource="development" name="qrycounties">
	SELECT * FROM counties
	ORDER BY countYName
</cfquery>



<cfquery datasource="development" name="qryMines" >
	SELECT m.*, c.countyname FROm mines m
    left join counties c
    ON m.countyid = c.id
	WHERE 
		<cfif isNumeric(url.countyid)>countyid = #url.countyid#<cfelse>1=1</cfif>
		<cfif not findNoCase("all",url.feature)>
			<cfset temp="">
			AND(
				<cfloop list="#url.feature#" index="ix">
					#temp# mineName like '%#ix#%'
					<cfset temp="or">
				</cfloop>
			)
		</cfif>
		<cfif len(url.keywords)>
			AND mineName like '%#keywords#%'
		</cfif>
	ORDER BY mineName
</cfquery>

<cfquery datasource="development" name="getCenter">
	SELECT avg(latitude) as avgLat, avg(longitude) as avgLong
	FROM mines
	WHERE id in (#valueList(qryMines.id)#)
</cfquery>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>Holes In The Ground</title>
    <script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAkKZ40YJPUmbeWvqlzBMulhQzSwq367hR0KD7MpXnXW-SDGQxGhRD_mZNXAN3EVJNtzTgEds3EZdTJw"
      type="text/javascript"></script>
    <script type="text/javascript">

    //<![CDATA[

    function load() {
      if (GBrowserIsCompatible()) {
        var map = new GMap2(document.getElementById("map"));
		var mgrOptions = { borderPadding: 50, maxZoom: 15, trackMarkers: true };
//		var mgr = new GMarkerManager(map, mgrOptions);
// Add Map Controls	
		map.addControl(new GSmallMapControl());
		map.addControl(new GMapTypeControl());		
		map.addControl(new GScaleControl());
		map.addControl(new GOverviewMapControl());
		map.enableScrollWheelZoom();


		// New listener: display center coordinates when map is moved
		GEvent.addListener(map, "moveend", function() {
			var center = map.getCenter();		
			 document.getElementById("message").innerHTML = center.toString();
			});		
			
		// Creates a labelled marker at the given point
		function createMarker(point, label) {
			var marker = new GMarker(point);
			GEvent.addListener(marker, "click", function() {
				marker.openInfoWindowHtml("<b>" + label + "</b>");

		        map.setCenter(point);				
			 });
			return marker;
			}			
// Set map center point			
        map.setCenter(new GLatLng(<cfoutput>#getCenter.avgLat#,#getCenter.avgLong#</cfoutput>), 9);
		
		<cfoutput query="qryMines">
		var point#id# = new GLatLng(#latitude#, #longitude#);
		map.addOverlay(createMarker(point#id#, "#replaceNoCase(minename,'"','\"','all')#<br>#countyname# County<br><br>Coordinates - Lat: #latitude# Long: #longitude#"));	  
</cfoutput>
//	returns sw/ne coords
//	alert(map.getBounds());
      }
    }

    //]]>
    </script>
  </head>
<body onLoad="load()" onUnload="GUnload()">

  
  
  
  <cfoutput>#qryMines.recordcount# locations returned</cfoutput><br>
    <div id="map" style="width: 1000px; height: 600px"></div>
	<div id="message"></div>
    
    
	<div class="body">
   	<table>
    	<tr>
        	
		<form action="map.cfm" method="get">
        <td class="body" valign="top">
			Select County 
         </td>
         <td class="body" valign="top">
            <select name="countyid" class="body">
		        <option value="">Select County:</option>
				<option value=""></option>	
				<option value="">All Counties</option>		
				<cfoutput query="qryCounties">
					<option value="#id#" <cfif id eq url.countyid>selected</cfif>>#countyName#</option>
				</cfoutput>
			</select>
         </td>
         <td class="body" valign="top">
			Feature Type:
         </td>
         <td class="body" valign="top">
            <cfoutput>
			<select name="feature" multiple="multiple" class="body" size="3">
				<cfloop list="#featureList#" index="ix">
					<option value="#ix#" <cfif findNoCase(ix,url.feature)>selected</cfif>>#ix#</option>
				</cfloop>
            </select>
            </cfoutput>
            

		</td>
        <td class="body" valign="top">
        Keyword(s):
        </td>
        <td class="body" valign="top">
<input type="text" name="keywords" class="body">
		</td>
        <td valign="top">
<input type="submit" value=" begin search " class="body">
		</td>
</form>
</tr></table>
	</div>
<br>    
    
	<cfoutput query="qryMines">
	<a href="javascript:map.setCenter(new GLatLng(#latitude#,#longitude#), 9)">#mineName#</a><br>
	</cfoutput>
  </body>
</html>
</dvi>