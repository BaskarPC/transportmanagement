<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/tyreremoval.do";
%>
<html:html>
	<head>
		<title>issues</title>
	</head>

	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyreremoval.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	function cleardone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyreremoval.do?invoke=clearMethod";	
		document.forms[0].submit();
	}
	function selectInstitutionName()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyreremoval.do?invoke=vehicleTypeMethod";	
		document.forms[0].submit();
	}
	
	function selectVehicleType()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyreremoval.do?invoke=vehicleNumberMethod";	
		document.forms[0].submit();
	}
	function selectVehicleNumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyreremoval.do?invoke=tyreNumberMethod";	
		document.forms[0].submit();
	}
	function selectTyreDetails()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyreremoval.do?invoke=tyreDetailsMethod";	
		document.forms[0].submit();
	}
	function calculateTotalKM()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyreremoval.do?invoke=calculateTotalKMMethod";	
		document.forms[0].submit();
	}
</script>

<body> 
<html:form action="tyreremoval" enctype="multipart/form-data">
<table border="0" width="100%" cellspacing="7" cellpadding="7" height="205">
<tr>
    <td width="25%" height="55">
      <p align="center">&nbsp;</td>
    <td width="13%" height="55">
      <p align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/tyre remove.jpg" width="40" height="40"></td>
    <td width="62%" colspan="4" height="55" class="maintitle">TYRE REMOVAL FORM</td>
  </tr>
 
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3"></td>
    <td width="25%" height="21"></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
        <td width="25%" colspan="3" align="justify" class="fieldname">Name of the Institution</td>
     <td width="25%">
    <html:select property="institutionName" style="width:200" onchange="javascript:selectInstitutionName()">
	<logic:present property="institutionList" name="TyreRemovalForm">	
	<bean:define id="institutionList" name="TyreRemovalForm" property="institutionList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose an Institution --"></html:option>
	<html:options collection="institutionList" property="instId" labelProperty="instDesc"></html:options>
	</logic:present>
	</html:select></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21" ></td>
    <td width="25%" height="21" colspan="3" class="fieldname">Vehicle Type</td>
    <td width="25%" height="21">
    <b><html:select property="vehicleType" style="width:200" onchange="javascript:selectVehicleType()">
	<logic:present property="vehicleTypeList" name="TyreRemovalForm">	
	<bean:define id="vehicleTypeList" name="TyreRemovalForm" property="vehicleTypeList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose an Vehicel Type --"></html:option>
	<html:options collection="vehicleTypeList" property="typeId" labelProperty="typeDesc"></html:options>
	</logic:present>
	</html:select></b></td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" class="fieldname">Vehicle Number</td>
    <td width="25%" height="21"><html:select property="vehicleNumber" style="width:200" onchange="javascript:selectVehicleNumber()" >
	<logic:present property="vehicleNumberList" name="TyreRemovalForm">	
	<bean:define id="vehicleNumberList" name="TyreRemovalForm" property="vehicleNumberList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose an Vehicle Number --"></html:option>
	<html:options collection="vehicleNumberList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
	</logic:present>
	</html:select></td>
    <td width="25%" height="21"></td>
  </tr>
 <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" class="fieldname">Tyre Number</td>
    <td width="25%" height="21"><html:select property="tyreNumber" style="width:200" onchange="javascript:selectTyreDetails()">
	<logic:present property="tyreNumberList" name="TyreRemovalForm">	
	<bean:define id="tyreNumberList" name="TyreRemovalForm" property="tyreNumberList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Number --"></html:option>
	<html:options collection="tyreNumberList" property="tyreNumber" labelProperty="tyreNumber"></html:options>
	</logic:present>
	</html:select></td>
    <td width="25%" height="21"></td>
 </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" class="fieldname">Original/ Rebuilt</td>
    <td width="25%" height="21"><html:text property="tyreStatus" style="width:200"/></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" class="fieldname">Position </td>
    <td width="25%" height="21"><html:text property="tyrePosition" style="width:200"/></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" class="fieldname">Removal Date </td>
    
    <td width="25%" height="21"><html:text property="removalDate" style="width:200"/>
    <a href="#" onClick="showCalendar(this,document.TyreRemovalForm.removalDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.TyreRemovalForm.removalDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
	<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
	 
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" class="fieldname">Fitting Kilometer</td>
    <td width="25%" height="21"><html:text property="fittingKM" style="width:200"/></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" class="fieldname">Removal (Kilometer)</td>
    <td width="25%" height="21"><html:text property="removalKM" style="width:200"/></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" class="fieldname">Total Kilometer </td>
    <td width="25%" height="21"><html:text property="totalKM" style="width:200" onclick="javascript:calculateTotalKM()" /></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" class="fieldname">Reason For Removal</td>
    <td width="25%" height="21"><html:textarea property="removalReason" style="width:150;height:100"/></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="50%" height="21" colspan="4">&nbsp;</td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="13%" height="21">&nbsp;</td>
    <td width="6%" height="21">
	<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18" onclick="okdone()"></td>
    <td width="6%" height="21">
   <img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="cleardone()"></td>
    <td width="25%" height="21">&nbsp;</td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3"></td>
    <td width="25%" height="21"></td>
    <td width="25%" height="21"></td>
  </tr>
</table>
</html:form>
</body>
</html:html>
