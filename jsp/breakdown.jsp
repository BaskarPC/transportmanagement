<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/BreakDown.do";
%>
<html:html>
	<head>
		<title>BreakDown Details</title>
 	</head>
<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
<script language="JavaScript">
	function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/breakdownvalidate.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	function retrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/breakdown.do?invoke=retrieveMethod";	
		document.forms[0].submit();
	}
	function vehicleretrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/breakdown.do?invoke=vehicleretrieveMethod";	
		document.forms[0].submit();
	}
	function nameretrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/breakdown.do?invoke=nameretrieveMethod";	
		document.forms[0].submit();
	}
	function retrieveall()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/breakdown.do?invoke=retrieveallMethod";	
		document.forms[0].submit();
	}
	function clearform()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/breakdown.do?invoke=clearformMethod";	
		document.forms[0].submit();
	}
</script>

<body>
<html:form action="breakdown" enctype="multipart/form-data">
<table border="0" width="100%" cellspacing="8" cellpadding="5" height="74%">
  
  <tr>
    <td width="148" align="left" height="27">
	<p align="right">
	</td>
    <td width="46" align="left" height="27" class="maintitle">
	<img border="0" src="<%=request.getContextPath()%>/images/icn_busbreakdown.jpg" width="40" height="40" align="right"></td>
    <td width="208" align="left" height="27" class="maintitle">BREAK DOWN DETAILS</td>
    <td width="549" height="27"></td>
   </tr>
   
   <tr>
    <td width="148" align="left" height="27"></td>
    <td width="246" align="left" height="27" class="fieldname" colspan="2">Name of the Institution</td>
    <td width="549" height="27" class="fieldname">
        <html:select property="instituteName" style="width:145" onchange="vehicleretrieve()">
        <logic:present property="instList" name="BreakDownForm">
        <bean:define id="instList" property="instList" name="BreakDownForm" type="java.util.Collection">
        </bean:define>
        <html:option value="--Choose Institution --"></html:option>
        <html:options collection="instList" property="instcode" labelProperty="instdesc"></html:options>
        </logic:present>
        </html:select>  
  </td>
  </tr>
    
  <tr>
    <td width="148" align="left" height="29"></td>
    <td width="246" align="left" height="29" class="fieldname" colspan="2">Vehicle Registration Number</td>
    <td width="549" height="29" class="fieldname">
        <html:select property="vehicleId" style="width:145" onchange="retrieveall()">
        <logic:present property="vehicleList" name="BreakDownForm">
        <bean:define id="vehicleList" property="vehicleList" name="BreakDownForm" type="java.util.Collection">
        </bean:define>
        <html:option value="--Choose VehicleID--"></html:option>
        <html:options collection="vehicleList" property="vehicleidcode" labelProperty="vehicleiddesc"></html:options>
        </logic:present>
        </html:select>
  </td>
  </tr>
  
   <tr>
    <td width="148" align="left" height="25" class="fieldname"></td>
    <td width="246" align="left" height="25" class="fieldname" colspan="2">Driver ID</td>
    <td width="549" height="25" class="fieldname">
        <html:select property="driverId" style="width:145" onchange="retrieve()">
        <logic:present property="driverIdList" name="BreakDownForm">
        <bean:define id="driverIdList" property="driverIdList" name="BreakDownForm" type="java.util.Collection">
        </bean:define>
    	<html:option value="--Choose Driver ID --"></html:option>
		<html:options collection="driverIdList" property="drivercode" labelProperty="driverdesc"></html:options>
		</logic:present>
		</html:select>
   </td>
  </tr>
  
  <tr>
    <td width="148" align="left" height="25"></td>
    <td width="246" align="left" height="25" class="fieldname" colspan="2">Driver Name</td>
    <td width="549" height="25" class="fieldname">
        <html:text property="driverName" style="width:113"/>
       </td>
  </tr>
       
  <tr>
    <td width="148" align="left" height="21"></td>
    <td width="246" align="left" height="21" class="fieldname" colspan="2">Break Down Date</td>
    <td width="549" height="21" class="fieldname">
        <html:text property="breakDownDate" style="width:113"/>
        <a href="#" onClick="showCalendar(this,document.BreakDownForm.breakDownDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.BreakDownForm.breakDownDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
		</a>
  </td>
  </tr>
  
  <tr>
    <td width="148" align="left" height="25"></td>
    <td width="246" align="left" height="25" class="fieldname" colspan="2">Break Down Time</td>
    <td width="549" height="25" class="fieldname">
        <html:text property="breakDownTime" style="width:113"/>
    </td>
  </tr>
  
  <tr>
    <td width="148" align="left" height="25" class="fieldname"></td>
    <td width="246" align="left" height="25" class="fieldname" colspan="2">Break Down Place</td>
    <td width="549" height="25" class="fieldname">
          <html:text property="breakDownPlace" style="width:113"/>
      </td>
  </tr>
  
  
  <tr>
    <td width="148" align="left" height="27"></td>
    <td width="246" align="left" height="27" class="fieldname" colspan="2">Route Number</td>
    <td width="549" height="27">
    	<html:text property="routeNo" style="width:113"/>
  </td>
  </tr>
  
  <tr>
    <td width="148" align="left" height="34" ></td>
    <td width="246" align="left" height="34" class="fieldname" colspan="2">Nature of Break Down</td>
    <td width="549" height="34" class="fieldname">
    	<html:textarea property="natureOfBreakDown" style="width:140;height=50"/>
  </td>
  </tr>
  
  <tr>
    <td width="148" align="left" height="26"></td>
    <td width="246" align="left" height="26" class="fieldname" colspan="2">Alternate Bus Registration Number</td>
    <td width="549" height="26" class="fieldname">
    	<html:text property="alternateBusId" style="width:113"/>
  </td>
  </tr>
  
  <tr>
    <td width="148" align="left" height="34"></td>
    <td width="246" align="left" height="34" class="fieldname" colspan="2">Alternate Bus Driver ID</td>
    <td width="549" height="34" class="fieldname">
     <html:select property="alterdriverId" style="width:145" onchange="nameretrieve()" >
        <logic:present property="alterdriverIdList" name="BreakDownForm">
        <bean:define id="alterdriverIdList" property="alterdriverIdList" name="BreakDownForm" type="java.util.Collection">
        </bean:define>
       <html:option value="--Choose Driver ID --"></html:option>
       <html:options collection="alterdriverIdList" property="drivercode" labelProperty="driverdesc"></html:options>
       </logic:present>
       </html:select></td>
  </tr>
    
  <tr>
    <td width="148" align="left" height="34"></td>
    <td width="246" align="left" height="34" class="fieldname" colspan="2">Alternate Bus Driver Name</td>
    <td width="549" height="34" class="fieldname">
    <html:text property="alternateBusDriverName" style="width:113"/>
      </td>
  </tr>
  
  <tr>
    <td width="148" align="left" height="34"></td>
    <td width="246" align="left" height="34" class="fieldname" colspan="2">Remarks</td>
    <td width="549" height="34" class="fieldname">
     <html:textarea property="remarks" style="width:140;height=50"/>
  </td>
  </tr>
  
  <tr>
  <td width="148" height="32">
  </td>
  <td colspan="3" width="833" height="32">
  <p align="left">
	<img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="save()">
	<img border="0" src="<%=request.getContextPath()%>/images/btn_clear.jpg" width="60" height="18" onclick="clearform()">
	</td>
    </tr>
</table>
</html:form>
</body>
</html:html>
