<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/labour.do";
%>
<html:html>
	<head>
		<title>Labour Charge</title>
	</head>
	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/labour.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/labour.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/labour.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/labour.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	function selectInstName()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/labour.do?invoke=instMethod";	
		document.forms[0].submit();
	}
	function selectVehicleType()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/labour.do?invoke=vehicleMethod";	
		document.forms[0].submit();
	}
	
</script>

<body> 
		<html:form action="labour" enctype="multipart/form-data">
<table border="0" width="100%" cellspacing="7" cellpadding="7" height="205">
<tr>
    <td width="25%" colspan="2" height="55">
      <p align="center">&nbsp;</td>
    <td width="13%" height="55">
      <p align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/labour.jpg" width="40" height="40"></td>
    <td width="62%" colspan="3" height="55" class="maintitle">LABOUR CHARGE</td>
  </tr>
	
	<tr>
	<td width="16%"></td>
		<td width="16%">&nbsp;</td>
		<td width="32%" colspan="3"></td>
		<td width="36%"></td>
		<td width="14%"></td>
	</tr>
	
	<tr>
	
		<td width="16%"></td>
		<td width="8%"></td>
		<td width="24%" colspan="2" class="fieldname">Date</td>
		<td width="36%"><html:text property="requestedDate" style="width:113"/>
		<a href="#" onClick="showCalendar(this,document.LabourForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.LabourForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
			<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
		</a>
		</td>
		
		<td width="14%"></td>
	</tr>
	<tr>
	
		<td width="16%"></td>
		<td width="8%">;</td>
		<td width="24%" colspan="2" class="fieldname">Name of the Institution</td>
		<td width="36%">
			<html:select property="institutionName" style="width:113" onchange="javascript:selectInstName()">
    			<html:option value="0">--Choose an Institution--</html:option>
    						<logic:present property="instList" name="LabourForm">	
								<bean:define id="instList" name="LabourForm" property="instList" type="java.util.Collection" ></bean:define>
								<html:options collection="instList" property="instId" labelProperty="instDesc"></html:options>
							</logic:present>                              
      		</html:select></td>
		<td width="14%"></td>
	</tr>
	<tr>
		<td width="16%">&nbsp;</td>
		<td width="8%">&nbsp;</td>
		<td width="24%" colspan="2" class="fieldname">Vehicle Type</td>
		<td width="36%">
    			<html:select property="vehicleType" style="width:113" onchange="javascript:selectVehicleType()">
                            <html:option value="0">--Choose Vehicle Type--</html:option>
							<logic:present property="typeList" name="LabourForm">	
								<bean:define id="typeList" name="LabourForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:options collection="typeList" property="typeId" labelProperty="typeDesc"></html:options>
							</logic:present>                                                                
                </html:select></td>
		<td width="14%">&nbsp;</td>
	</tr>
	<tr>
		<td width="16%">&nbsp;</td>
		<td width="8%">&nbsp;</td>
		<td width="24%" colspan="2" class="fieldname">Vehicle Number</td>
		<td width="36%">
					<html:select property="vehicleNumber">
                            <html:option value="0"> - - Choose a Vehicle Number --</html:option>
                            <logic:present property="vehicleList" name="LabourForm">	
								<bean:define id="vehicleList" name="LabourForm" property="vehicleList" type="java.util.Collection" ></bean:define>
								<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
							</logic:present>                                                                  
                        </html:select></td>
		<td width="14%">&nbsp;</td>
	</tr>
	<tr>
		<td width="16%"></td>
		<td width="8%"></td>
		<td width="24%" colspan="2" class="fieldname">Nature Of Work</td>
		<td width="36%">
				<html:select property="labourReason">
                            <html:option value="0"> - - Choose a Service --</html:option>
                            <logic:present property="labourList" name="LabourForm">	
								<bean:define id="labourList" name="LabourForm" property="labourList" type="java.util.Collection" ></bean:define>
								<html:options collection="labourList" property="labourId" labelProperty="labourDesc"></html:options>
							</logic:present>                                                                     
                        </html:select></td>
		<td width="14%">&nbsp;</td>
	</tr>
	<tr>
		<td width="16%"></td>
		<td width="8%"></td>
		<td width="24%" colspan="2" class="fieldname">Others</td>
		<td width="36%"><html:text property="otherPurpose" style="width:113"/></td>
		<td width="14%"></td>
	</tr>
	<tr>
		<td width="16%">&nbsp;</td>
		<td width="8%">&nbsp;</td>
		<td width="24%" colspan="2" class="fieldname">Total Amount</td>
		<td width="36%"><html:text property="totalAmount" style="width:113"/></td>
		<td width="14%">&nbsp;</td>
	</tr>
	<tr>
		<td width="16%"></td>
		<td width="32%" colspan="3"></td>
		<td width="36%"></td>
		<td width="14%"></td>
	</tr>
  <tr>
  
    <td width="50%" height="21" colspan="7">
      <p align="center">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="javascript:submitdone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18" onclick="javascript:issuedone()">
        <img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18" onclick="javascript:approvedone()">
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18" onclick="javascript:okdone()"></td>
		 <td width="50%" height="21" colspan="7"></td>
		  <td width="50%" height="21" colspan="7"></td>
		  
  </tr>
</table>
<p align="center">&nbsp;</p>
</html:form>
			
			
</body>
</html:html>