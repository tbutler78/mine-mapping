<cfinclude template="minedata.cfm">

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
   <head>
      <title></title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
      <script type="text/javascript" src="http://dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=6"></script>
      <cfoutput>
      <script type="text/javascript">
      var map = null;
            
      function GetMap()
      {
         map = new VEMap('myMap');
		 map.SetDashboardSize(VEDashboardSize.Normal);
         map.LoadMap(new VELatLong(#startLat#, #startLong#), 10, 'r', false, VEMapMode.Hybrid, true);
<cfset counter = 1>		 
<cfloop query="qryMines">
<cfset currentName = "#replaceNoCase(replaceNoCase(minename,'"','\"','all'),"'","\'","all")#">		 
		 var shape#counter# = new VEShape(VEShapeType.Pushpin, new VELatLong(#latitude#, #longitude#)); 
		title = "#listFirst(currentname,"(")#";
		details = "<br><cfif len(trim(listRest(currentName,"(")))>#listRest(currentName,"(")#<br></cfif><br>#countyName# County<br>Lat:#latitude#<br>Longitude:#longitude#";
//		shape.SetCustomIcon(pinIcon); // if you wanted to set a custom icon
		shape#counter#.SetTitle("<div class=\"pinTitle\">" + title + "</div>");
		shape#counter#.SetDescription("<div class=\"pinDetails\">" + details + "</div>");
		map.AddShape(shape#counter#);				 
		<cfset counter++>
</cfloop>
  map.ClearInfoBoxStyles();
      }   
	  



      </script>
      </cfoutput>
   </head>
   <body onload="GetMap();">
      <div id='myMap' style="position:relative; width:90%; height:90%;"></div>
      
      <cfinclude template="mineForm.cfm">
   </body>
</html>
      