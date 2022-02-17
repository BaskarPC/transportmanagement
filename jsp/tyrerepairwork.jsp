<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/tyrerepair.do";
%>
<html:html>
	<head>
		<title></title>
	</head>

	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	function cleardone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=clearMethod";	
		document.forms[0].submit();
	}
	function selectTyreNumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=tyreNumberMethod";	
		document.forms[0].submit();
	}
	function setTyreNumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=setTyreNumberMethod";	
		document.forms[0].submit();
	}
	function setTyreNumber1()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=setTyreNumberMethod1";	
		document.forms[0].submit();
	}
	function setTyreNumber2()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=setTyreNumberMethod2";	
		document.forms[0].submit();
	}
	function setTyreNumber3()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=setTyreNumberMethod3";	
		document.forms[0].submit();
	}
	function setTyreNumber4()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=setTyreNumberMethod4";	
		document.forms[0].submit();
	}
	function setTyreNumber5()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=setTyreNumberMethod5";	
		document.forms[0].submit();
	}
	function setTyreNumber6()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=setTyreNumberMethod6";	
		document.forms[0].submit();
	}
	function setTyreNumber7()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=setTyreNumberMethod7";	
		document.forms[0].submit();
	}
	function setTyreNumber8()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=setTyreNumberMethod8";	
		document.forms[0].submit();
	}
	function setTyreNumber9()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=setTyreNumberMethod9";	
		document.forms[0].submit();
	}
	function setTyreNumber10()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrerepair.do?invoke=setTyreNumberMethod10";	
		document.forms[0].submit();
	}

		
	
</script>

<body> 
<html:form action="tyrerepair" enctype="multipart/form-data">

<table border="0" width="99%" cellspacing="7" cellpadding="7" height="689">
<tr>
    <td width="25%" colspan="3" height="44">
      <p align="center" class="maintitle">
		</td>
    <td width="9%" colspan="4" height="44">
      	<p align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/tyre repair.jpg" width="40" height="40"></td>
    <td width="66%" colspan="8" height="44" class="maintitle">TYRE REPAIR WORK FORM</td>
    <td width="11%" height="44"></td>
     </tr>

  <tr>
    
    <td width="9%" height="13" class="fieldname" colspan="3"></td>
    <td height="13" class="fieldname" colspan="2"></td>
    <td height="13" class="fieldname" colspan="6"></td>
    <td height="13" class="fieldname"></td>
    <td height="13" class="fieldname"></td>
    <td height="13" class="fieldname"></td>
    <td height="13" class="fieldname" colspan="2"></td>
         </tr>
  <tr>
        <td width="1%" height="21" class="fieldname">&nbsp;</td>
        <td height="21" class="fieldname">&nbsp;</td>
        <td height="21" class="fieldname" colspan="2">Date</td>
        <td height="21" class="fieldname" colspan="2">
       <html:text property="billDate" style="width:200"/></td>
        <td height="21" class="fieldname" colspan="2">
       <a href="#" onClick="showCalendar(this,document.TyreRepairWorkForm.billDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.TyreRepairWorkForm.billDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
       <img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date" align="left">
	</a></td>
        <td height="21">Bill Number
        <td width="50%" height="21" class="fieldname" colspan="8"> 
        <%-- <td width="60" height="34" class="fieldname" colspan="6" align="left"> --%>
        <html:text property="billNumber" style="width:200"/></td>
            
  </tr>
  
  <tr>
        <td width="1%" height="21" class="fieldname">&nbsp;</td>
        <td height="21" class="fieldname">&nbsp;</td>
        <td height="21" class="fieldname" colspan="2">Company Name</td>
        <td height="21" class="fieldname" colspan="2">
       <html:text property="companyName" style="width:200"/></td>
        <td height="21" class="fieldname" colspan="2">
       </td>
        <td height="21">Amount
        <td width="50%" height="21" class="fieldname" colspan="8"> 
        <%-- <td width="60" height="34" class="fieldname" colspan="6" align="left"> --%>
        <html:text property="billAmount" style="width:200"/></td>
            
  </tr>
  

 <tr>
    <td width="13%" height="21" colspan="2" align="center">&nbsp;</td>
    <td width="12%" height="21" colspan="2" align="left"> Tyre Ply</td>
    <td width="12%" height="21" colspan="3" align="left"><p align="left">
	 <html:select property="tyrePly" style="width:200">
	<logic:present property="tyrePlyList" name="TyreRepairWorkForm">	
	<bean:define id="tyrePlyList" name="TyreRepairWorkForm" property="tyrePlyList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Ply --"></html:option>
	<html:options collection="tyrePlyList" property="tyreplyCode" labelProperty="tyreplyCdesc"></html:options>
	</logic:present>
	</html:select></td>
    <td width="4%" height="21" align="left">
      &nbsp;</td>
      
      <td width="15%" height="150" align="left" rowspan="4">Tyre Number</td>
    <td width="250" height="150" colspan="7" align="left" rowspan="4">
	<html:select property="tyreNumbers" style="width:200" multiple="true" >
	<logic:present property="tyreNumberList" name="TyreRepairWorkForm">	
	<bean:define id="tyreNumberList" name="TyreRepairWorkForm" property="tyreNumberList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Number --"></html:option>
	<html:options collection="tyreNumberList" property="tyreNumber" labelProperty="tyreNumber"></html:options>
	</logic:present>
	</html:select>
	</td>
  </tr>
  <tr>
    <td width="13%" height="21" colspan="2" align="center">
      &nbsp;</td>
    <td width="12%" height="21" colspan="2" align="left">
      Tyre Size</td>
    <td width="12%" height="21" colspan="3" align="left">
			<html:select property="tyreSize" style="width:200">
	<logic:present property="tyreSizeList" name="TyreRepairWorkForm">	
	<bean:define id="tyreSizeList" name="TyreRepairWorkForm" property="tyreSizeList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Size --"></html:option>
	<html:options collection="tyreSizeList" property="tyresizeCode" labelProperty="tyresizeCdesc"></html:options>
	</logic:present>
	</html:select></td>
    <td width="4%" height="21" align="left">
			&nbsp;</td>
  </tr>
  <tr>
    <td width="13%" height="21" colspan="2" align="center">
      &nbsp;</td>
    <td width="12%" height="21" colspan="2" align="left">
      Tyre Brand</td>
    <td width="12%" height="21" colspan="3" align="left">
			<html:select property="tyreBrand" style="width:200" onchange="javascript:selectTyreNumber()">
	<logic:present property="tyreBrandList" name="TyreRepairWorkForm">	
	<bean:define id="tyreBrandList" name="TyreRepairWorkForm" property="tyreBrandList" type="java.util.Collection" ></bean:define>
	<html:option value="-- Choose Tyre Brand --"></html:option>
	<html:options collection="tyreBrandList" property="tyrebrandCode" labelProperty="tyrebrandCdesc"></html:options>
	</logic:present>
	</html:select></td>
    <td width="4%" height="21" align="left">
			&nbsp;</td>
  </tr>
  <tr>
    <td width="13%" height="21" colspan="2" align="center">
      &nbsp;</td>
    <td width="12%" height="21" colspan="2" align="left">
      <p align="left">&nbsp;</td>
    <td width="12%" height="21" colspan="3" align="left">
      <p align="left">
			&nbsp;</td>
    <td width="4%" height="21" align="left">
      &nbsp;</td>
    <td width="5%" height="21" align="left">
      &nbsp;</td>
    <td width="272" height="21" align="center">
      &nbsp;</td>
  </tr>
  <tr>
    <td width="97%" height="281" colspan="16" align="center">
      <table border="1" width="75%">
        <tr>
          <td width="5%" align="center" class="fieldname">S.No</td>
          <td width="21%" align="center" class="fieldname">Tyre Number</td>
          <td width="5%" align="center" class="fieldname">Tyre Brand</td>
          <td width="21%" align="center" class="fieldname">Tyre Size</td>
          <td width="25%" align="center" class="fieldname">Repair Work</td>
          <td width="24%" align="center" class="fieldname">Reason </td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">1.</td>
          <td width="21%">
			<p align="center">
			<html:text property="tyreNumber1" style="width:150" onclick="setTyreNumber1()"/></td>
          <td width="25%" align="center">
           <p><html:text property="tyreBrand1" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="tyreSize1" style="width:150"/></td>
          <td width="25%" align="center">
			<p><html:text property="repairWork1" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="repairReason1" style="width:150"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">2.</td>
          <td width="21%">
			<p align="center">
			<html:text property="tyreNumber2" style="width:150" onclick="setTyreNumber2()"/></td>
          <td width="25%" align="center">
           <p><html:text property="tyreBrand2" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="tyreSize2" style="width:150"/></td>
          <td width="25%" align="center">
			<p><html:text property="repairWork2" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="repairReason2" style="width:150"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">3.</td>
          <td width="21%">
			<p align="center">
			<html:text property="tyreNumber3" style="width:150" onclick="setTyreNumber3()"/></td>
          <td width="25%" align="center">
           <p><html:text property="tyreBrand3" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="tyreSize3" style="width:150"/></td>
          <td width="25%" align="center">
			<p><html:text property="repairWork3" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="repairReason3" style="width:150"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">4.</td>
          <td width="21%">
			<p align="center">
			<html:text property="tyreNumber4" style="width:150" onclick="setTyreNumber4()"/></td>
          <td width="25%" align="center">
           <p><html:text property="tyreBrand4" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="tyreSize4" style="width:150"/></td>
          <td width="25%" align="center">
			<p><html:text property="repairWork4" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="repairReason4" style="width:150"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">5.</td>
          <td width="21%">
			<p align="center">
			<html:text property="tyreNumber5" style="width:150" onclick="setTyreNumber5()"/></td>
          <td width="25%" align="center">
           <p><html:text property="tyreBrand5" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="tyreSize5" style="width:150"/></td>
          <td width="25%" align="center">
			<p><html:text property="repairWork5" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="repairReason5" style="width:150"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">6.</td>
          <td width="21%">
			<p align="center">
			<html:text property="tyreNumber6" style="width:150" onclick="setTyreNumber6()"/></td>
          <td width="25%" align="center">
           <p><html:text property="tyreBrand6" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="tyreSize6" style="width:150"/></td>
          <td width="25%" align="center">
			<p><html:text property="repairWork6" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="repairReason6" style="width:150"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">7.</td>
          <td width="21%">
			<p align="center">
			<html:text property="tyreNumber7" style="width:150" onclick="setTyreNumber7()"/></td>
          <td width="25%" align="center">
           <p><html:text property="tyreBrand7" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="tyreSize7" style="width:150"/></td>
          <td width="25%" align="center">
			<p><html:text property="repairWork7" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="repairReason7" style="width:150"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">8.</td>
          <td width="21%">
			<p align="center">
			<html:text property="tyreNumber8" style="width:150" onclick="setTyreNumber8()"/></td>
          <td width="25%" align="center">
           <p><html:text property="tyreBrand8" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="tyreSize8" style="width:150"/></td>
          <td width="25%" align="center">
			<p><html:text property="repairWork8" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="repairReason8" style="width:150"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">9.</td>
          <td width="21%">
			<p align="center">
			<html:text property="tyreNumber9" style="width:150" onclick="setTyreNumber9()"/></td>
          <td width="25%" align="center">
           <p><html:text property="tyreBrand9" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="tyreSize9" style="width:150"/></td>
          <td width="25%" align="center">
			<p><html:text property="repairWork9" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="repairReason9" style="width:150"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">10.</td>
          <td width="21%">
			<p align="center">
			<html:text property="tyreNumber10" style="width:150" onclick="setTyreNumber10()"/></td>
          <td width="25%" align="center">
           <p><html:text property="tyreBrand10" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="tyreSize10" style="width:150"/></td>
          <td width="25%" align="center">
			<p><html:text property="repairWork10" style="width:150"/></td>
          <td width="24%" align="center">
			<html:text property="repairReason10" style="width:150"/></td>
        </tr>
        </table>
    </td>
  </tr>
 <tr>
    <td width="97%" height="26" colspan="16">
      <p align="center">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="javascript:cleardone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18" onclick="javascript:issuedone()">
        <img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18" onclick="javascript:approvedone()">
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18" onclick="javascript:okdone()"></td>
     </tr>
</table>
</html:form>		
</body>
</html:html>