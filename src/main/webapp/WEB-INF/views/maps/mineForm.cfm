  



    
    
	<div class="body">
  <cfoutput><strong>#qryMines.recordcount# locations returned</strong></cfoutput><br>    
   	<table>
    	<tr>
        	
		<form action="<cfoutput>#cgi.script_name#</cfoutput>" method="get">
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
    