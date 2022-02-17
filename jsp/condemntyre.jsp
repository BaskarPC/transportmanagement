<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/condemntyre.do";
%>
<html:html>
	<head>
		<title></title>
	</head>

	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/condemntyre.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	function cleardone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/condemntyre.do?invoke=clearMethod";	
		document.forms[0].submit();
	}
	function selectTyreNumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/condemntyre.do?invoke=tyreNumberMethod";	
		document.forms[0].submit();
	}
	function setTyreStatus()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/condemntyre.do?invoke=tyreStatusMethod";	
		document.forms[0].submit();
	}
</script>

<body> 
<html:form action="condemntyre" enctype="multipart/form-data">

<table border="0" width="100%" cellspacing="7" cellpadding="7" height="205">
<tr>
    <td width="25%" height="55">
      <p align="center">&nbsp;</td>
    <td width="13%" height="55" colspan="2">
      <p align="right">
		<img border="0" src = "<%=request.getContextPath()%>/images/condemntyre.jpg" width="40" height="40"></td>
    <td width="62%" colspan="4" height="55" class="maintitle">CONDEMN TYRE FORM</td>
  </tr>
 

  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="25%" height="21" colspan="4">&nbsp;</td>
    <td width="25%" height="21">&nbsp;</td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="9%" height="21">&nbsp;</td>
    <td width="9%" height="21" colspan="2" class="fieldname">Tyre Size</td>
    <td width="8%" height="21">&nbsp;</td>
    <td width="25%" height="21">
	<html:select property="tyreSize" style="width:200">
	<logic:present property="tyreSizeList" name="CondemnTyreForm">	
	<bean:define id="tyreSizeList" name="CondemnTyreForm" property="tyreSizeList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Size --"></html:option>
	<html:options collection="tyreSizeList" property="tyresizeCode" labelProperty="tyresizeCdesc"></html:options>
	</logic:present>
	</html:select></td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="9%" height="21">&nbsp;</td>
    <td width="9%" height="21" colspan="2" class="fieldname">Tyre Ply</td>
    <td width="8%" height="21">&nbsp;</td>
    <td width="25%" height="21"><html:select property="tyrePly" style="width:200">
	<logic:present property="tyrePlyList" name="CondemnTyreForm">	
	<bean:define id="tyrePlyList" name="CondemnTyreForm" property="tyrePlyList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Ply --"></html:option>
	<html:options collection="tyrePlyList" property="tyreplyCode" labelProperty="tyreplyCdesc"></html:options>
	</logic:present>
	</html:select></td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="9%" height="21">&nbsp;</td>
    <td width="9%" height="21" colspan="2" class="fieldname">Tyre Brand</td>
    <td width="8%" height="21">&nbsp;</td>
    <td width="25%" height="21">
    <html:select property="tyreBrand" style="width:200" onchange="javascript:selectTyreNumber()">
	<logic:present property="tyreBrandList" name="CondemnTyreForm">	
	<bean:define id="tyreBrandList" name="CondemnTyreForm" property="tyreBrandList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Brand --"></html:option>
	<html:options collection="tyreBrandList" property="tyrebrandCode" labelProperty="tyrebrandCdesc"></html:options>
	</logic:present>
	</html:select>
	</td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
 
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="9%" height="21">&nbsp;</td>
    <td width="9%" height="21" colspan="2" class="fieldname">Tyre Number</td>
    <td width="8%" height="21">&nbsp;</td>
    <td width="25%" height="21"><html:select property="tyreNumber" style="width:200" onchange="javascript:setTyreStatus()">
	<logic:present property="tyreNumberList" name="CondemnTyreForm">	
	<bean:define id="tyreNumberList" name="CondemnTyreForm" property="tyreNumberList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Number --"></html:option>
	<html:options collection="tyreNumberList" property="tyreNumber" labelProperty="tyreNumber"></html:options>
	</logic:present>
	</html:select></td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="9%" height="21">&nbsp;</td>
    <td width="9%" height="21" colspan="2" class="fieldname">Date</td>
    <td width="8%" height="21">&nbsp;</td>
    <td width="25%" height="21"><html:text property="condemnTyreDate" style="width:200"/>
    <a href="#" onClick="showCalendar(this,document.CondemnTyreForm.condemnTyreDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.CondemnTyreForm.condemnTyreDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
	<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="19"></td>
    <td width="9%" height="19">&nbsp;</td>
    <td width="9%" height="19" colspan="2" class="fieldname">Original / Rebuilt</td>
    <td width="8%" height="19">&nbsp;</td>
    <td width="25%" height="19"><html:text property="tyreStatus" style="width:200"/></td>
    <td width="25%" height="19"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="9%" height="21">&nbsp;</td>
    <td width="9%" height="21" colspan="2" class="fieldname">Reason</td>
    <td width="8%" height="21">&nbsp;</td>
    <td width="25%" height="21"><html:textarea property="condemnTyreReason" style="width:150;height:100"/></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="13%" height="21" colspan="2">&nbsp;</td>
    <td width="12%" height="21" colspan="2">&nbsp;</td>
    <td width="25%" height="21">&nbsp;</td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="13%" height="21" colspan="2">&nbsp;</td>
    <td width="6%" height="21">
	<img border="0" src = "<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18"  onclick="okdone()"></td>
    <td width="6%" height="21">
	<img border="0" src = "<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18"  onclick="cleardone()"></td>
    <td width="25%" height="21">&nbsp;</td>
    <td width="25%" height="21"></td>
  </tr>
  </table>
</html:form>		
</body>
</html:html>