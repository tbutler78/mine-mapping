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
	SELECT * FROm mines
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

<cfoutput>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
   <head>
      <title></title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
      <script type="text/javascript" src="http://dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=6"></script>
      <script type="text/javascript">
         var map = null;
         
         function GetMap()
         {
            map = new VEMap('myMap');
            map.LoadMap(new VELatLong(#getCenter.avgLat#, #getCenter.avgLong#), 10 ,'h' ,false);
         }   

	  
       function AddPushpin(name,latitude,longitude)
      {
          var shape = new VEShape(VEShapeType.Pushpin, longitude,latitude);
          shape.SetTitle(name);
          shape.SetDescription('This is shape number '+pinid);
          pinid++;
          map.AddShape(shape);
      }
      </script>	  
   </head>
   <body onload="GetMap();">
      <div id='myMap' style="position:relative; width:800px; height:600px;"></div>
	  <script>

	  	AddPushpin('point#qryMines.id#','#qryMines.latitude#','#qryMines.longitude#');

	  </script>
   </body>
</html>   
      
</cfoutput>