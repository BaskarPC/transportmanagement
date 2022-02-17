<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/fc.do";
%>
<html:html>
	<head>
		<title>FC Smoke Test</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/fc.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/fc.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/fc.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/fc.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	
</script>

<body> 
		<html:form action="fc" enctype="multipart/form-data">
<table border="0" width="100%" cellspacing="7" cellpadding="7" height="205">
<tr>
    <td width="220" colspan="2" height="55">
      <p align="center"></td>
    <td width="28" height="55">
		&nbsp;</td>
    <td width="27" height="55">
		<img border="0" src="<%=request.getContextPath()%>/images/smoke%20.jpg" width="40" height="40"></td>
    <td width="604" height="55" colspan="3" class="maintitle">FC AND SMOKE TEST 
	MAINTENANCE</td>
  </tr>
	<tr>
	
		<td width="162">&nbsp;</td>
		<td width="230" colspan="4">&nbsp;</td>
		<td width="225">&nbsp;</td>
		<td width="232">&nbsp;</td>
	</tr>
	<tr>
	
		<td width="162">&nbsp;</td>
		<td width="230" colspan="4" class="fieldname">Date</td>
		<td width="225" class="fieldname">
		<html:text property="requestedDate" style="width:113"/>
		<a href="#" onClick="showCalendar(this,document.FcForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.FcForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
			<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
		</a></td>
		<td width="232"></td>
	</tr>
	<tr>
		<td height="30" width="162">&nbsp;</td>
    <td width="23%" height="21" align="left" colspan="4" class="fieldname">Bill Number</td>
    <td width="27%" height="21" align="left" class="fieldname">
      <b><html:text property="billNumber" style="width:113"/></b></td>
		<td height="30" width="232">&nbsp;</td>
	</tr>
	<tr>
		<td height="30" width="162"></td>
		<td width="230" colspan="4" class="fieldname">Name of the Institution</td>
		<td width="225" class="fieldname"><html:select property="institutionName" style="width:113">
    
    	<html:option value="KVITT"></html:option>
    	<html:option value="KASC"></html:option>
    	<html:option value="KEC"></html:option>
         <html:option value="KPTC"></html:option>                              
      </html:select></td>
		<td height="30" width="232"></td>
	</tr>
	<tr>
		<td height="30" width="162">&nbsp;</td>
		<td height="30" width="230" colspan="4" class="fieldname">Vehicle Type</td>
		<td height="30" width="225" class="fieldname">
        <b><html:select property="vehicleType">
                            
                            <html:option value="0"> - - Choose a Vehicle Type --</html:option>
                            <html:option value="1">Bus</html:option>
                            <html:option value="2">Car</html:option>   
                            <html:option value="3">Lorry</html:option> 
                            <html:option value="1">Van (MiniBus)</html:option>
                            <html:option value="2">Ambulance</html:option>   
                            <html:option value="3">Tractor</html:option>    
                            <html:option value="2">Tempo</html:option>   
                            <html:option value="3">Others</html:option>                                                                    
                        </html:select></b></td>
		<td height="30" width="232">&nbsp;</td>
	</tr>
	<tr>
		<td height="30" width="162"></td>
		<td height="30" width="230" colspan="4" class="fieldname">Vehicle Number</td>
		<td height="30" width="225" class="fieldname">
        <html:select property="vehicleNumber">
                      
                            <html:option value="0"> - - Choose a Vehicle Number --</html:option>
                            <html:option value="1">TN33 H 8388</html:option>
                            <html:option value="2">TN27 U 7949</html:option>   
                            <html:option value="3">TN36 C 7701</html:option>                                                                    
                        </html:select></td>
		<td height="30" width="232"></td>
	</tr>
<tr>
		<td height="30" width="162">&nbsp;</td>
		<td height="30" width="230" colspan="4" class="fieldname">Driver Name</td>
		<td height="30" width="225" class="fieldname">
        <html:text property="driverName" style="width:113"/></td>
    <td width="232" height="25">&nbsp;</td>
</tr>
	<tr>
		<td height="30" width="162">&nbsp;</td>
		<td height="30" width="230" colspan="4" class="fieldname">FC/Smoke</td>
		<td height="30" width="225" class="fieldname">
        <html:select property="fcReason">
                            
                            <html:option value="0"> - - Choose a Service --</html:option>
                            <html:option value="2">Paint</html:option>   
                            <html:option value="3">Others</html:option>                                                                     
                        </html:select></td>
		<td height="30" width="232">
        &nbsp;</td>
	</tr>
	<tr>
		<td height="30" width="162">&nbsp;</td>
		<td height="30" width="230" colspan="4" class="fieldname">Amount</td>
		<td height="30" width="225" class="fieldname">
        <html:text property="totalAmount" style="width:113"/><p>&nbsp;</td>
		<td height="30" width="232">
        &nbsp;</td>
	</tr>
	<tr>
	
		<td height="30" width="162">&nbsp;</td>
		<td height="30" width="115" colspan="3">&nbsp;</td>
		<td height="30" width="115">&nbsp;</td>
		<td height="30" width="225">&nbsp;</td>
		<td height="30" width="232">
        &nbsp;</td>
	</tr>
  <tr>
    <td width="120%" height="21" colspan="7">
      <p align="center">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="javascript:submitdone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18" onclick="javascript:issuedone()">
        <img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18" onclick="javascript:approvedone()">
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18" onclick="javascript:okdone()"></td>
		<td height="30" width="162">&nbsp;</td>
		<td height="30" width="162">&nbsp;</td>
		<td height="30" width="162">&nbsp;</td>
		<td height="30" width="162">&nbsp;</td>
		
  </tr>
</table>
<p align="center">&nbsp;</p>
</html:form>
			
			
</body>
</html:html>