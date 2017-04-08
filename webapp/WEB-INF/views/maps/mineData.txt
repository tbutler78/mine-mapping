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

<cfset startLat = getcenter.avgLat>
<cfset startLong = getCenter.avgLong>

<span class="body">
<cfoutput>#qryMines.recordcount# Locations Found in #qryMines.countyName# County
For Keywords <cfif len(url.keywords)>"#url.keywords#" </cfif>"#url.feature#"
</cfoutput>

</span>