<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/tyrefitting.do";
%>
<html:html>
	<head>
		<title>TyreFitting</title>
	</head>
	
	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrefitting.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	function cleardone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrefitting.do?invoke=clearMethod";	
		document.forms[0].submit();
	}
	function selectInstitutionName()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrefitting.do?invoke=vehicleTypeMethod";	
		document.forms[0].submit();
	}
	
	function selectVehicleType()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrefitting.do?invoke=vehicleNumberMethod";	
		document.forms[0].submit();
	}
	function selectTyreBrand()
	{
		
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrefitting.do?invoke=tyreNumberMethod";	
		document.forms[0].submit();
	}
	function setTyreStatus()
	{
	    
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrefitting.do?invoke=tyreStatusMethod";	
		document.forms[0].submit();
	}
	
</script>

<body>
<html:form action="tyrefitting" enctype="multipart/form-data">
 <html:errors/>
<table border="0" width="100%" cellspacing="7" cellpadding="7" height="205">
<tr>
    <td width="25%" height="55">
      <p align="center">&nbsp;</td>
    <td width="13%" height="55">
      <p align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/tyre fitting.jpg" width="44" height="46"></td>
    <td width="62%" colspan="4" height="55" class="maintitle">TYRE FITTING FORM</td>
  </tr>
   <tr>
    <td width="25%" height="20"></td>
    <td width="25%" height="20" colspan="3"></td>
    <td width="25%" height="20"></td>
    <td width="25%" height="20"></td>
  </tr>
  <tr>
    <td width="25%" height="22"></td>
    <td width="25%" height="22" colspan="3" align="justify" class="fieldname">Tyre Size</td>
    <td width="25%" height="22">  
   <html:select property="tyreSize" style="width:200">
	<logic:present property="tyreSizeList" name="TyreFittingForm">	
	<bean:define id="tyreSizeList" name="TyreFittingForm" property="tyreSizeList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Size--"></html:option>
	<html:options collection="tyreSizeList" property="tyresizeCode" labelProperty="tyresizeCdesc"></html:options>
	</logic:present>
	</html:select></td>
       
    <td width="25%" height="22"></td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="25%" height="21" colspan="3" align="justify" class="fieldname">
	Ply</td>
    <td width="25%" height="21">

 <html:select property="tyrePly" style="width:200">
	<logic:present property="tyrePlyList" name="TyreFittingForm">	
	<bean:define id="tyrePlyList" name="TyreFittingForm" property="tyrePlyList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Ply --"></html:option>
	<html:options collection="tyrePlyList" property="tyreplyCode" labelProperty="tyreplyCdesc"></html:options>
	</logic:present>
	</html:select></td>
		
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" align="justify" class="fieldname">Tyre Brand</td>
    <td width="25%" height="21">

 <html:select property="tyreBrand" style="width:200" onchange="javascript:selectTyreBrand()">
	<logic:present property="tyreBrandList" name="TyreFittingForm">	
	<bean:define id="tyreBrandList" name="TyreFittingForm" property="tyreBrandList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Brand --"></html:option>
	<html:options collection="tyreBrandList" property="tyrebrandCode" labelProperty="tyrebrandCdesc"></html:options>
	</logic:present>
	</html:select></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" align="justify" class="fieldname">Tyre Number</td>
    <td width="25%" height="21">
    
    <html:select property="tyreNumber" style="width:200" onchange="javascript:setTyreStatus()">
	<logic:present property="tyreNumberList" name="TyreFittingForm">	
	<bean:define id="tyreNumberList" name="TyreFittingForm" property="tyreNumberList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Number --"></html:option>
	<html:options collection="tyreNumberList" property="tyreNumber" labelProperty="tyreNumber"></html:options>
	</logic:present>
	</html:select> </td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" colspan="3" align="justify" class="fieldname">Name of the Institution</td>
     <td width="25%">
    <html:select property="institutionName" style="width:200" onchange="javascript:selectInstitutionName()">
	<logic:present property="institutionList" name="TyreFittingForm">	
	<bean:define id="institutionList" name="TyreFittingForm" property="institutionList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose an Institution --"></html:option>
	<html:options collection="institutionList" property="instId" labelProperty="instDesc"></html:options>
	</logic:present>
	</html:select></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
     <td width="25%" colspan="3" align="justify" class="fieldname">Vehicle Type</td>
     <td width="25%">
    <b>
   <html:select property="vehicleType" style="width:200" onchange="javascript:selectVehicleType()">
	<logic:present property="vehicleTypeList" name="TyreFittingForm">	
	<bean:define id="vehicleTypeList" name="TyreFittingForm" property="vehicleTypeList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose an Vehicel Type --"></html:option>
	<html:options collection="vehicleTypeList" property="typeId" labelProperty="typeDesc"></html:options>
	</logic:present>
	</html:select></b></td>

    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
   <td width="25%" colspan="3" align="justify" class="fieldname">Vehicle Number</td>
    <td width="25%">
    <html:select property="vehicleNumber" style="width:200">
	<logic:present property="vehicleNumberList" name="TyreFittingForm">	
	<bean:define id="vehicleNumberList" name="TyreFittingForm" property="vehicleNumberList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose an Vehicle Number --"></html:option>
	<html:options collection="vehicleNumberList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
	</logic:present>
	</html:select></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" align="justify" class="fieldname">Original/ Rebuilt</td>
    <td width="25%" height="21"><html:text property="tyreStatus" style="width:200"/></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" align="justify" class="fieldname">Position  </td>
    <td width="25%" height="21">
   <html:select property="tyrePosition" style="width:200">
	<logic:present property="tyrePositionList" name="TyreFittingForm">	
	<bean:define id="tyrePositionList" name="TyreFittingForm" property="tyrePositionList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Position --"></html:option>
	<html:options collection="tyrePositionList" property="tyrepositionCode" labelProperty="tyrepositionCdesc"></html:options>
	</logic:present>
	</html:select></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="20"></td>
    <td width="25%" height="20" colspan="3" align="justify" class="fieldname">Fitting Date</td>
    
    <td width="25%" height="21"><html:text property="fittingDate" style="width:200"/>
    <a href="#" onClick="showCalendar(this,document.TyreFittingForm.fittingDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.TyreFittingForm.fittingDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
	<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
	<td width="25%" height="20"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="25%" height="21" colspan="3" align="justify" class="fieldname">Fitting Kilometer</td>
    <td width="25%" height="21"><html:text property="fittingKM" style="width:200"/></td>
    <td width="25%" height="21"></td>
  </tr>
 
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="13%" height="21">&nbsp;</td>
    <td width="6%" height="21">
      <img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18" onclick="okdone()"></td>
    <td width="6%" height="21">
   <img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="cleardone()"></td>
    <td width="25%" height="21">&nbsp;</td>
    
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  </table>
</html:form>
</body>
</html:html>
	