<cfquery datasource="development" name="counties">
	SELECT * FROM counties
	ORDER BY countyName
</cfquery>


<cfloop query="counties">
<cfoutput>
e:\inetpub\tourre.com\tom\minesProject\IGSminesData_#countyName#.txt<br>
</cfoutput>
<cfif fileExists("e:\inetpub\tourre.com\tom\minesProject\IGSminesData_#countyName#.txt")>
<cffile action="read" file="e:\inetpub\tourre.com\tom\minesProject\IGSminesData_#countyName#.txt" variable="myFile">

<cfset init = 0>

<cftransaction>
<cfoutput>
<cfloop list="#myFile#" delimiters="#chr(10)#" index="ix">
	<cfscript>
		delim = chr(09);
		ix = replaceNoCase(ix,"#chr(09)##chr(09)#","#chr(09)# #chr(09)#","all");
		ix = replaceNoCase(ix,"#chr(09)##chr(09)#","#chr(09)# #chr(09)#","all");
		mine = structNew();
		mine.countyId = id;
		mine.sequenceNumber = listGetAt(ix,1,delim);
		mine.mineName = listGetAt(ix,2,delim);		
		mine.latitude = listGetAt(ix,3,delim);		
		mine.longitude = listGetAt(ix,4,delim);		
		mine.milsref = listGetAt(ix,5,delim);
		mine.mrdsrec = listGetAt(ix,6,delim);
		mine.orangeNumber = listgetAt(ix,7,delim);
	</cfscript>
	
	<cftry>
	<cfif len(trim(mine.latitude)) and len(trim(mine.longitude)) and init eq 1>
	<cfquery datasource="development">
		INSERT INTO mines(countyid,sequenceNumber,mineName,latitude,longitude,milsref,mrdsrec,orangeNumber)
		VALUES(#mine.countyid#,'#mine.sequenceNumber#','#mine.mineName#',#mine.latitude#,#mine.longitude#,'#mine.milsRef#','#mine.mrdsRec#','#mine.orangeNumber#')
	</cfquery> 
	</cfif>
	
	<cfcatch>
		#cfcatch.message#<br>
		#cfcatch.detail#<br><br>
		<cfdump var="#mine#">
	</cfcatch>
	</cftry>
	<cfset init = 1>
</cfloop>
</cfoutput>

</cftransaction>
</cfif>
</cfloop>
