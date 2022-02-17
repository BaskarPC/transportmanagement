<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/DriverLeave.do";
%>
<html:html>

	<head>
		<title>Driver Leave Details</title>
 	</head>
 	
 	<script language="JavaScript">
	function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverleavevalidate.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	function update()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverleavevalidate.do?invoke=updateMethod";	
		document.forms[0].submit();
	}
	function comboretrieve()
	{
	  
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverleave.do?invoke=retrieveMethod";	
		document.forms[0].submit();
		
	}
	function change()
	{
	  
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverleave.do?invoke=calcMethod";	
		document.forms[0].submit();
		
	}
	function compcalc()
	{
	  
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverleave.do?invoke=compcalcMethod";	
		document.forms[0].submit();
		
	}
	function medicalcalc()
	{
	  
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverleave.do?invoke=medicalcalcMethod";	
		document.forms[0].submit();
		
	}
	function vacationcalc()
	{
	  
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverleave.do?invoke=vacationcalcMethod";	
		document.forms[0].submit();
		
	}
	function clearmtd()
	{
	  		
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverleave.do?invoke=clearmtdMethod";	
		document.forms[0].submit();
		
	}
 	</script>
 	
<body>
<html:form action="driverleave" enctype="multipart/form-data">
<table border="0" width="100%" cellspacing="8" cellpadding="5" height="59%" >
  <tr>
    <td width="137" align="left" height="48">
	<p align="right">
	</td>
    <td width="49" align="left" height="48" class=" maintitle">
	<img border="0" src="<%=request.getContextPath()%>/images/icn_driverleave.jpg" width="40" height="40" align="right"></td>
    <td width="261" align="left" height="48" class=" maintitle">DRIVER LEAVE DETAILS</td>
    <td width="422" align="left" height="48" ></td>
  </tr>
  <tr>
    <td width="137" align="left" height="36"></td>
    <td width="206" align="left" height="36" class="fieldname" colspan="2">Driver ID</td>
    <td width="630" align="left" height="36" class="fieldname">
      <html:select property="driverId" style="width:145" onchange="comboretrieve()">
      <logic:present property="idList" name="DriverLeaveForm">
      <bean:define id="idList" property="idList" name="DriverLeaveForm" type="java.util.Collection">
      </bean:define>
      <html:option value="--Choose a DriverID--"></html:option>
      <html:options collection="idList" property="drivercode" labelProperty="driverdesc"></html:options>
      </logic:present>
     </html:select>
     </td>
  </tr>
  <tr>
    <td width="137" align="left" height="36"></td>
    <td width="206" align="left" height="36" class="fieldname" colspan="2">Driver Name</td>
    <td width="630" align="left" height="36" class="fieldname">
       <html:text property="driverName" style="width:113"/>
    </td>
  </tr>
  <tr>
    <td width="137" align="left" height="28"></td>
    <td width="206" align="left" height="28" class="fieldname" colspan="2">Department</td>
    <td width="630" align="left" height="28" class="fieldname">
        <html:text property="department" style="width:113"/>
      </td>
  </tr>
  <tr>
    <td width="137" align="left" height="30"></td>
    <td width="206" align="left" height="30" class="fieldname" colspan="2" >Number of days Leave Required</td>
    <td width="630" align="left" height="30" class="fieldname">
       <html:text property="noOfDaysLeaveRequired" style="width:113" onchange="change()"/>
      </td>
  </tr>
  <tr>
    <td width="137" align="left" height="28"></td>
    <td width="206" align="left" height="28" class="fieldname" colspan="2">Leave Already Taken</td>
    <td width="630" align="left" height="28" class="fieldname">
   	   <html:text property="leaveAlreadyTaken" style="width:113"/>
       </td>
  </tr>
  <tr>
    <td width="137" align="left" height="28"></td>
    <td width="206" align="left" height="28" class="fieldname" colspan="2">Casual Leave Days</td>
    <td width="630" align="left" height="28" class="fieldname">
      <html:text property="casualLeave" style="width:113" />
     </td>
  </tr>
  <tr>
    <td width="137" align="left" height="31"></td>
    <td width="206" align="left" height="31" class="fieldname" colspan="2">Compensation Leave Days</td>
    <td width="630" align="left" height="31" class="fieldname">
   	   <html:text property="compensationLeave" style="width:113" onchange="compcalc()" />
      </td>
  </tr>
  <tr>
    <td width="137" align="left" height="31"></td>
    <td width="206" align="left" height="31" class="fieldname" colspan="2">Medical Leave Days</td>
    <td width="630" align="left" height="31" class="fieldname">
    	<html:text property="medicalLeave" style="width:113" onchange="medicalcalc()" />
        </td>
  </tr>
  <tr>
    <td width="137" align="left" height="31"></td>
    <td width="206" align="left" height="31" class="fieldname" colspan="2">Vacation Leave Days</td>
    <td width="630" align="left" height="31" class="fieldname">
      	<html:text property="vacationLeave" style="width:113" onchange="vacationcalc()"/>
       </td>
  </tr>
  <html:errors/>
  <tr> 
    <td align="center" width="137">
      </td>
    <td align="center" colspan="3" width="844">
	<p align="left">
	<img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="save()">
	<img border="0" src="<%=request.getContextPath()%>/images/btn_update.jpg" width="60" height="18" onclick="update()">
	<img border="0" src="<%=request.getContextPath()%>/images/btn_clear.jpg" width="60" height="18" onclick="javascript:clearmtd()">
	</td>
   </tr>
</table>



</html:form>
</body>
</html:html>