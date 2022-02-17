<%@ include file="/include/taglibs.jsp"%>


<html:html>
	<head>
	<title>Order From EO</title>
	</head>
<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
<script>

	function cleardone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/orderFromEO.do?invoke=clearMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/orderFromEO.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	function forwardtoincharge()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/orderFromEO.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function purchase()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieselpurchase.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}
	
</script>
<body>
<html:form action="orderFromEO" enctype="multipart/form-data">
	
	<table border="0" width="100%" id="table1" align="center">
		<tr>
			<td height="47">
			<p align="center">
			&nbsp;</td>
			<td height="47" colspan="4" >
	
			&nbsp;<table border="0" width="100%" id="table2">
				<tr>
					<td width="88">	
					<img border="0" src="<%=request.getContextPath()%>/images/deisel req.jpg" align="right" ></td>
					<td width="163" class="maintitle">	
					ORDER FROM EO</td>
					<td>&nbsp;</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td width="28%" height="21">&nbsp;</td>
			<td width="69%" height="21" class="fieldname" colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td width="28%" height="26"></td>
			<td width="13%" height="26" class="fieldname">Date</td>
			<td width="4%" height="26" class="fieldname">&nbsp;</td>
			<td height="26" width="13%"> <html:text property="date"  style="width:113"/></td>
			<td height="26" width="39%"><a href="#" onClick="showCalendar(this,document.DieselOrderFromEOForm.date,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.DieselOrderFromEOForm.date,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
		</tr>
		<tr>
			<td width="28%" height="26">&nbsp;</td>
			<td width="13%" height="26" class="fieldname">From</td>
			<td width="4%" height="26" class="fieldname">&nbsp;</td>
			<td height="26" width="13%"> <html:text property="from"  style="width:113"/></td>
			<td height="26" width="39%">&nbsp;</td>
		</tr>
		<tr>
			<td width="28%" height="30">&nbsp;</td>
			<td width="13%" height="30" class="fieldname">Company Name</td>
			<td width="4%" height="30" class="fieldname">&nbsp;</td>
			<td height="30" width="13%"> 
			<html:select property="companyName" style="width:120" >

			<logic:present property="companylist" name="DieselOrderFromEOForm">	
			<bean:define id="companylist" name="DieselOrderFromEOForm" property="companylist" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Company"></html:option>
			<html:options collection="companylist" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
			</td>
		<td height="30" width="39%" align="left"><img border="0" src="<%=request.getContextPath()%>/images/ADD.jpg" ></td>
				</tr>
		<tr>
			<td width="28%" height="33">&nbsp;</td>
			<td width="13%" height="33" class="fieldname">Required Liters</td>
			<td width="4%" height="33" class="fieldname">&nbsp;</td>
			<td height="33" width="13%"><html:text property="requiredLiters"  style="width:113"/></td>
			<td height="33" width="39%" align="left">&nbsp;</td>
		</tr>
		<tr>
			<td width="28%" height="29">&nbsp;</td>
			<td width="13%" height="29" class="fieldname">Check Number</td>
			<td width="4%" height="29" class="fieldname">&nbsp;</td>
			<td height="29" width="13%"><html:text property="checkNo"  style="width:113"/></td>
			<td height="29" width="39%" align="left">&nbsp;</td>
		</tr>
		<tr>
			<td width="28%" height="25">&nbsp;</td>
			<td width="13%" height="25" class="fieldname">Bank Name</td>
			<td width="4%" height="25" class="fieldname">&nbsp;</td>
			<td height="25" width="13%"> <html:select property="bankName" style="width:120" >

			<logic:present property="banklist" name="DieselOrderFromEOForm">	
			<bean:define id="banklist" name="DieselOrderFromEOForm" property="banklist" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Bank"></html:option>
			<html:options collection="banklist" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select></td>
			<td height="25" width="39%" align="left"><html:text property="otherBank"  style="width:113"/></td>
		</tr>
		<tr>
			<td width="28%" height="36">&nbsp;</td>
			<td width="13%" height="36" class="fieldname">Amount</td>
			<td width="4%" height="36" class="fieldname">&nbsp;</td>
			<td height="36" width="13%"><html:text property="amount"  style="width:113"/></td>
			<td height="36" width="39%" align="left">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="5">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td colspan="4">
	&nbsp;<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg">
	<img border="0" src="<%=request.getContextPath()%>/images/FWD TO INCHARGE.jpg" onclick="forwardtoincharge()" >		
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" >
		<img border="0" src="<%=request.getContextPath()%>/images/btn_purchaseform.jpg" onclick="purchase()"></td>
		</tr>

	</table>
	<p align="center">
	&nbsp;</p>
</html:form>

</body>

</html:html>