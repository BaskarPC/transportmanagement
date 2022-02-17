<tr>
	<%
		if(premRequired.equals("Y"))
		{
	%>
	<td CLASS="mlgTabSelected"  align = center>Premium
	</td>
	<%
		}
		else
		{
			//tabCount++;           
		//}
	%>
	<td CLASS="mlgTab"  align = center disabled=true>Premium</td>
	<%
		}
	%>

	<%
		if(StatRequired.equals("Y"))
		{
	%>
	<td CLASS="mlgTabSelected" align = center><a href = "javascript:clickStatRecon();" STYLE="TEXT-DECORATION: NONE">Statistics & Reconciliation</a>
	</td>
	<%
		}
		else
			{
				//tabCount++;           
		//}
	%>
	<td CLASS="mlgTab"  align = center disabled=true>Statistics & Reconciliation</td>
	<%
		}
	%>

	<%
		if(hasClaimsInd.equals("Y"))
		{
	%>
	<td CLASS="mlgTabSelected" align = center><a href = "javascript:clickClaims();" STYLE="TEXT-DECORATION: NONE">Claims </a>
	</td>
	<%
		}
		else
		{
			//tabCount++;           
		//}
	%>
	<td CLASS="mlgTab"  align = center disabled=true>Claims</td>
	<%
		}
	%>

	<%
		if(largeRequired.equals("Y"))
		{
	%>
	<td CLASS="mlgTabSelected" align = center><a href = "javascript:clickLargeLives();" STYLE="TEXT-DECORATION: NONE">Large Lives & Retro </a>
	</td>
	<%
		}
		else
		{
			//tabCount++;           
		//}
	%>
	<td CLASS="mlgTab"  align = center disabled=trueLarge Lives & Retro</td>
	<%
		}
	%>

	<%
		if(hasProfCommInd.equals("Y"))
		{
	%>
	<td CLASS="mlgTabSelected" align = center>
		<a href="javascript:clickProfitComm();" STYLE="TEXT-DECORATION: NONE">Profit 
			Commission </a>
	</td>
	<%
		}
		else
		{
		//tabCount++;           
		//}
	%>
	<td CLASS="mlgTab"  align = center disabled=true>Profit Commission</td>
	<%
		}
	%>

	<%
		if(generalRequired.equals("Y"))
		{
	%>
	<td CLASS="mlgTabSelected" align = center><a href = "clickGeneralBooking();" STYLE="TEXT-DECORATION: NONE">General Booking </a>
	</td>
	<%
		}
		else
		{
			//tabCount++;           
		//}
	%>
	<td CLASS="mlgTab"  align = center disabled=true>General Booking</td>
	<%
		}
	%>
</tr>