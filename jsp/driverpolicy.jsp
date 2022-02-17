<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/DriverPolicy.do";
%>
<html:html>

	<head>
		<title>Driver Insurance Policy Details</title>
 	</head>
 	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function back()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverpolicy.do?invoke=backMethod";	
		document.forms[0].submit();
	}
	function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverpolicyvalidate.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	function update()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverpolicyvalidate.do?invoke=updateMethod";	
		document.forms[0].submit();
	}
	function comboretrieve()
	{
	  	document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverpolicy.do?invoke=retrieveMethod";	
		document.forms[0].submit();
	}
	function clearform()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverpolicy.do?invoke=clearformMethod";	
		document.forms[0].submit();
	}
	
 	</script>
 	
<body>
<html:form action="driverpolicy" enctype="multipart/form-data">

<table border="0" width="914" cellspacing="8" cellpadding="5"  height="78%" >
	<tr>
    	<td width="137" height="53"></td>
   		<td width="49" height="53" class="maintitle">
   		<img border="0" src="<%=request.getContextPath()%>/images/icn_driverpolicy.jpg" width="40" height="41" align="right"></td>
   		<td width="259" height="53" class="maintitle">DRIVER INSURANCE DETAILS</td>
	</tr>
	<tr>
 		<td width="137" height="39"></td>
   		<td width="308" height="39" colspan="2"><p align="left" class="fieldname">Driver ID</p></td>
    	<td width="431" height="39" class="fieldname">
    	  	<html:select property="driverId" style="width:145" onchange="comboretrieve()">
      	  	<logic:present property="idList" name="DriverPolicyForm">
      	  	<bean:define id="idList" property="idList" name="DriverPolicyForm" type="java.util.Collection"></bean:define>
	        <html:option value="--Choose a DriverID--"></html:option>
    	    <html:options collection="idList" property="drivercode" labelProperty="driverdesc"></html:options>
        	</logic:present>
          	</html:select>
     	</td>
 	</tr>
 	<tr>
     	<td width="137" height="25"></td>
    	<td width="308" height="25" class="fieldname" colspan="2">Driver Name</td>
    	<td width="431" height="25" class="fieldname">
        	 <html:text property="driverName" style="width:113"/></td>
  	</tr>
  	<tr>
   		 <td width="137" height="25"></td>
	     <td width="308" height="25" colspan="2"><p align="left" class="fieldname">Policy Number</p></td>
    	 <td width="431" height="25" class="fieldname">
       		 <html:text property="policyNo" style="width:113"/></td>
  	</tr>
  	<tr>
    	<td width="137" height="25"></td>
	    <td width="308" height="25" class="fieldname" colspan="2"><p align="left">Policy Name</p></td>
	    <td width="431" height="25" class="fieldname">
    	   <html:text property="policyName" style="width:113"/>
    	</td>
  	</tr>
  	<tr>
   		 <td width="137" height="46"></td>
	     <td width="308" height="46" class="fieldname" colspan="2"><p align="left">Coverage</p></td>
	     <td width="431" height="46" class="fieldname">
    		<html:textarea property="coverage" style="width:140;height=50"/></td>
    </tr>
  	<tr>
    	<td width="137" height="30"></td>
	    <td width="308" height="30" class="fieldname" colspan="2"><p align="left">Premium Amount</p></td>
	    <td width="431" height="30" class="fieldname">
    		 <html:text property="premiumAmt" style="width:113"/></td>
  	</tr>
  	<tr>
    	<td width="137" height="40"></td>
	    <td width="308" height="40" class="fieldname" colspan="2"><p align="left">Insurance Company Address</p></td>
	    <td width="431" height="40" class="fieldname">
    		 <html:textarea property="insuranceCmpyAddress" style="width:140;height=50"/></td>
  	</tr>
  	<tr >
    	<td width="137" height="26"></td>
   		<td width="749" colspan="3" height="26" class="subtitle"><p align="left"> Validity Period</p></td>   
  	</tr>
  	<tr>
		<td align="center" height="27" width="137"></td>
		<td align="center" height="27" width="308" class="fieldname" colspan="2"><p>From</p></td>
		<td height="27" width="431" class="fieldname">
                  <html:text property="validFrom" style="width:113" readonly="true"/>
                  <a href="#" onClick="showCalendar(this,document.DriverPolicyForm.validFrom,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.DriverPolicyForm.validFrom,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
	    			<img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date"></a>
        </td>
	</tr>
	<tr>
		<td align="center" height="26" width="137"></td>
		<td align="center" height="26" width="308" class="fieldname" colspan="2"><p>To</p></td>
		<td height="26" width="431" class="fieldname">
                <html:text property="validTo" style="width:113" readonly="true"/>
                <a href="#" onClick="showCalendar(this,document.DriverPolicyForm.validTo,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.DriverPolicyForm.validTo,'anchor03','dd MMM yyyy'); return false;" NAME="anchor04" ID="anchor04">
				<img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date"></a>
                </td>
	</tr>
  	<tr>
    	<td width="137" height="34"></td>
	    <td width="308" height="34" class="fieldname" colspan="2"><p align="left">Insurance Covered Hospitals</p></td>
	    <td width="431" height="34" class="fieldname">
   			<html:textarea property="tieUp" style="width:140;height=50"/></td>
    </tr>
  	<tr>
    	<td width="137" height="33"></td>
	    <td width="308" height="33" class="fieldname" colspan="2"><p align="left">Compensation</p></td>
	    <td width="431" height="33" class="fieldname">
    	    <html:text property="compensationAmt" style="width:113"/></td>
  	</tr>
  	<tr>
    	<td width="137" height="33"></td>
	    <td width="308" height="33" colspan="2"><p align="left">Hospital Expenses</p></td>
	    <td width="431" height="33" class="fieldname">
    		 <html:text property="hospitalExpenses" style="width:113"/></td>
  	</tr>
  	<tr>
    	 <td width="137" height="29"></td>
	     <td width="308" height="29" class="fieldname" colspan="2">Buffer</td>
		 <td width="431" height="29" class="fieldname">
			   <html:text property="buffer" style="width:113"/></td>
  	</tr>
    <tr>
   		 <td width="137" height="29"></td>
	     <td width="308" height="29" class="subtitle" colspan="2"><p align="left">Constraints</p></td>
		 <td width="431" height="29"></td>
  	</tr>
    <tr>
  		 <td align="center" height="131" width="137"></td>
	     <td align="center" colspan="3" height="131" width="749" class="fieldname">
    		 <html:textarea property="constraints" style="width:500;height=100"/></td>
  	</tr>
   <html:errors/>
  	<tr>
   		<td align="center" height="40" width="137"></td>
        <td align="center" colspan="3" height="40" width="749"><p align="center">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="save()">
		<!--<img border="0" src="<%=request.getContextPath()%>/images/btn_edit.jpg" width="60" height="18">-->
		<img border="0" src="<%=request.getContextPath()%>/images/btn_update.jpg" width="60" height="18" onclick="update()">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_clear.jpg" width="60" height="18" onclick="clearform()">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_back.jpg" width="60" height="18" onclick="back()"></p></td>
  	</tr>
  </table>
  </html:form>
  </body>
  </html:html>
