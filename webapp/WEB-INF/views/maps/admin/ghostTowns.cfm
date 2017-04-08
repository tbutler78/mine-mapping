<cfif isDefined("form.townName")>

<cfquery datasource="development">
	INSERT INTO towns(countyid,latitude,longitude,townname)
    VALUES(#form.countyId#,'#form.latitude#','#form.longitude#','#townName#')
</cfquery>

</cfif>

<cfquery datasource="development" name="qrycounties">
	SELECT * FROM counties
    ORDER BY countyName
</cfquery>	

<cfquery datasource="development" name="qryTowns">
	SELECT * FROM towns
    ORDER BY townName
</cfquery>	

<cfoutput query="qryTowns">
	#townName#<br />
</cfoutput>




<form action="ghostTowns.cfm" method="post">
Name:	<input type="text" name="townName" /><br />
Latitude:    <input type="text" name="latitude" /><br />
Longitude: <input type="text" name="longitude" /><br />
County: <select name="countyID">
	<cfoutput query="qrycounties">
    <option value="#id#">#countyName#</option>
    </cfoutput>
    </select>
  <br /><br />
  <input type="submit" />

</form>