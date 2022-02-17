<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/kerosene.do";
%>

<html:html>
	<head>
		<title>Kerosene Form</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/waste.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/wasteValidate.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/waste.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/waste.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	function listvehicletype()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/waste.do?invoke=listVehicleMethod";	
		document.forms[0].submit();
	}
	function listvehiclenumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/waste.do?invoke=listVehicleNumberMethod";	
		document.forms[0].submit();
	}
	function quantityupdate()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/wasteValidate.do?invoke=qtyUpdateMethod";	
		document.forms[0].submit();
	}
	
	
</script>

<body> 
<html:form action="waste" enctype="multipart/form-data">

<table border="0" width="100%" cellspacing="7" cellpadding="7" height="205">
<tr>
    <td width="25%" colspan="3" height="55"></td>
    <td width="4%" height="55">  </td>
    <td width="17%" colspan="3" height="55" class="maintitle">
		<img border="0" src="<%=request.getContextPath()%>/images/wastecloth.jpg" width="40" height="40" align="right"></td>
    <td width="51%" colspan="6" height="55" class="maintitle">WASTE CLOTH REQUISITION FORM</td>
  </tr>
  <tr>
    <td width="25%" height="21" colspan="2">&nbsp;</td>
    <td width="21%" height="21" colspan="4">&nbsp;</td>
    <td width="11%" height="21" >&nbsp;</td>
    <td width="44%" height="21" colspan="6">&nbsp;</td>
  </tr>
  <tr>
    <td width="13%" height="21"></td>
    <td width="24%" height="21" colspan="3" class="fieldname">Date</td>
    <td width="15%" height="21" colspan="3">
	<html:text property="requestedDate" style="width:113"/>
	<a href="#" onClick="showCalendar(this,document.KeroseneForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.KeroseneForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
    <td width="11%" height="21" align="left"> &nbsp;</td>
    <td width="17%" height="21" align="left" class="fieldname">Bill Number</td>
    <td width="38%" height="21" align="left" colspan="4">
      <html:text property="billNumber" style="width:113"/></td>
  </tr>
  <tr>
    <td width="13%" height="21"></td>
    <td width="24%" height="21" align="left" colspan="3" class="fieldname">Name of the Institution</td>
    <td width="15%" height="21" align="left" colspan="3">
      <html:select property="institutionName" style="width:150" onchange="javascript:listvehicletype()">
							<logic:present property="instList" name="WasteForm">	
								<bean:define id="instList" name="WasteForm" property="instList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Institution--</html:option>
								<html:options collection="instList" property="instid" labelProperty="instdesc"></html:options>
							</logic:present>
						</html:select></td>
    <td width="11%" height="21" align="left">
      &nbsp;</td>
    <td width="17%" height="21" align="left" class="fieldname"> Vehicle Type </td>
    <td width="38%" height="21" align="left" colspan="4">
      <html:select property="vehicleType" style="width:150" onchange="javascript:listvehiclenumber()">
							<logic:present property="vehicleTypeList" name="WasteForm">	
								<bean:define id="vehicleTypeList" name="WasteForm" property="vehicleTypeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Institution--</html:option>
								<html:options collection="vehicleTypeList" property="vehicletypeid" labelProperty="vehicletypedesc"></html:options>
							</logic:present>
						</html:select></td>
  </tr>
  <tr>
    <td width="13%" height="21"></td>
    <td width="24%" height="21" align="left" colspan="3" class="fieldname">Vehicle Number</td>
    <td width="15%" height="21" align="left" colspan="3">
   <html:select property="vehicleNumber" style="width:150">
							<logic:present property="vehicleNumberList" name="WasteForm">	
								<bean:define id="vehicleNumberList" name="WasteForm" property="vehicleNumberList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose number--</html:option>
								<html:options collection="vehicleNumberList" property="vehiclenumberid" labelProperty="vehiclenumberdesc"></html:options>
							</logic:present>
						</html:select></td>
    <td width="11%" height="21" align="left">&nbsp;</td>
    <td width="17%" height="21" align="left" class="fieldname">Other Purpose</td>
    <td width="38%" height="21" align="left" colspan="4">
    <html:text property="otherPurpose" style="width:150"/></td>
  </tr>
  <tr>
    <td width="13%" height="21">&nbsp;</td>
    <td width="24%" height="21" align="left" colspan="3" class="fieldname">Driver Name</td>
    <td width="15%" height="21" align="left" colspan="3">
    <html:text property="driverName" style="width:150"/></td>
    <td width="11%" height="21" align="left">&nbsp;</td>
    <td width="17%" height="21" align="left" class="fieldname">Requested Driver Name</td>
    <td width="38%" height="21" align="left" colspan="4">
    <html:text property="requestedDriverName" style="width:150"/></td>
  </tr>
  <tr>
    <td width="13%" height="21">&nbsp;</td>
    <td width="24%" height="21" align="left" colspan="3">&nbsp;</td>
    <td width="15%" height="21" align="left" colspan="3">&nbsp;</td>
    <td width="11%" height="21" align="left">&nbsp;</td>
    <td width="17%" height="21" align="left">&nbsp;</td>
    <td width="38%" height="21" align="left" colspan="4">&nbsp;</td>
  </tr>
  
   <tr>
    <td width="13%" height="21"></td>
    <td width="23%" height="21" align="left" colspan="3">Available Quantity</td>
    <td width="15%" height="21" align="left" colspan="3"><b>
	<html:text property="totalAvailableQuantity" style="width:150"/></b></td>
    <td width="11%" height="21" align="left">&nbsp;</td>
    <td width="17%" height="21" align="left">&nbsp;</td>
    <td width="38%" height="21" align="left" colspan="4">&nbsp;</td>
  </tr>
  <tr>
    <td width="13%" height="25"></td>
    <td width="25%" height="25" colspan="3">Required Quantity</td>
    <td width="15%" height="25" colspan="3">
	<b>
	<html:text property="requiredQuantity" style="width:150" onblur="javascript:quantityupdate()"/></b></td>
    <td width="11%" height="25">
	&nbsp;</td>
    <td width="17%" height="25">
	Reason</td>
    <td width="38%" height="25" colspan="4">
	<b><html:select property="wasteReason" style="width:150">
							<logic:present property="reasonList" name="WasteForm">	
								<bean:define id="reasonList" name="WasteForm" property="reasonList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Reason--</html:option>
								<html:options collection="reasonList" property="greasereasonid" labelProperty="greasereasondesc"></html:options>
							</logic:present>
						</html:select></b></td>
  </tr>
 
<tr>
    <td width="13%" height="25">&nbsp;</td>
    <td width="25%" height="25" colspan="3">&nbsp;</td>
    <td width="8%" height="25" colspan="2">
	&nbsp;</td>
    <td width="11%" height="25">
	&nbsp;</td>
    <td width="11%" height="25">
	&nbsp;</td>
    <td width="17%" height="25">
	&nbsp;</td>
    <td width="16%" height="25" colspan="2">
	&nbsp;</td>
    <td width="11%" height="25">
	&nbsp;</td>
    <td width="11%" height="25">
	&nbsp;</td>
  </tr>
<tr>
    <td width="13%" height="25" rowspan="2">&nbsp;</td>
    <td width="25%" height="25" colspan="3" rowspan="2" class="fieldname">Issuing Quantity </td>
    <td width="8%" height="13" colspan="2" class="fieldname">NEW</td>
    <td width="11%" height="13" class="fieldname">OLD</td>
    <td width="11%" height="25" rowspan="2">
	&nbsp;</td>
    <td width="17%" height="25" rowspan="2">
	Rate/Liter</td>
    <td width="7%" height="13" class="fieldname">OLD</td>
    <td width="7%" height="13" class="fieldname">NEW</td>
    <td width="13%" height="25" rowspan="2">
	&nbsp;</td>
    <td width="11%" height="25" rowspan="2">
	&nbsp;</td>
  </tr>
<tr>
    <td width="8%" height="12" colspan="2">
	
	<html:text property="oldAvailable" style="width:50"/></td>
    <td width="11%" height="12">
	
	<html:text property="newAvailable" style="width:50"/></td>
    <td width="7%" height="12">
	
	<html:text property="oldRate" style="width:50"/></td>
    <td width="7%" height="12">
	<html:text property="newRate" style="width:50"/></td>
  </tr>
<tr>
    <td width="13%" height="25"></td>
    <td width="25%" height="25" colspan="3" class="fieldname">Total Amount</td>
    <td width="15%" height="25" colspan="3">
	<html:text property="totalAmount" style="width:150"/></td>
    <td width="11%" height="25">
	&nbsp;</td>
    <td width="17%" height="25" class="fieldname">Remaining Quantity</td>
    <td width="38%" height="25" colspan="4">
	<html:text property="remainingQuantity" style="width:150"/></td>
  </tr>
<tr>
    <td width="13%" height="25"></td>
    <td width="25%" height="25" colspan="3">&nbsp;</td>
    <td width="15%" height="25" colspan="3">&nbsp;</td>
    <td width="11%" height="25">
	&nbsp;</td>
    <td width="11%" height="25">
	&nbsp;</td>
    <td width="22%" height="25" colspan="2">
	&nbsp;</td>
    <td width="22%" height="25" colspan="2">
	&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21" colspan="2">&nbsp;</td>
    <td width="21%" height="21" colspan="4">&nbsp;</td>
    <td width="11%" height="21" align="center">&nbsp;</td>
    <td width="44%" height="21" colspan="6">&nbsp;</td>
  </tr>
  <html:errors /> 
  <tr>
    <td width="25%" height="21" colspan="2"></td>
    <td width="18%" height="21" colspan="3"> </td>
    <td width="52%" height="21" colspan="8">
	
	<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="javascript:submitdone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18" onclick="javascript:issuedone()">
        <img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18" onclick="javascript:approvedone()">
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18" onclick="javascript:okdone()"></td>
  </tr>
  </table>
</html:form>
</body>

</html:html>