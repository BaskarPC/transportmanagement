
<%@ include file="/include/taglibs.jsp"%>
<%@ include file="/include/Header.jsp"%>
<%@ include file="/include/menu.jsp"%>
<%
	String url =  request.getContextPath()+"/OldVehiclePurchase.do";
%>
<html:html>

	<head>
		<title>Old Vehicle Purchase</title>
 	</head>
 	
 	<script language="JavaScript">
		function back()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicledetails.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}		
	function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oldvehiclepurchase.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	</script>
 	<body>
<html:form action="oldvehiclepurchase" enctype="multipart/form-data">
<table border="0" width="100%" cellpadding="5" cellspacing="8" height="30%">
  
  <tr>
    <td width="147" align="left" height="25"></td>
    <td width="40" align="left" height="25">
 	<img border="0" src="<%=request.getContextPath()%>/images/icn_vehicledetails.jpg" width="40" height="40"></td>
    <td width="180" align="left" height="25" class="maintitle">OLD VEHICLE DETAILS</td>    
    <td width="653" align="left" height="25"></td>
  </tr>
  
  <tr>
    <td width="147" align="left" height="1"></td>
    <td width="194" align="left" height="1" colspan="2"></td>
    <td width="653" align="left" height="1"></td>
  </tr>
  
  <tr>
    <td width="147" align="left" height="1"></td>
    <td width="194" align="left" height="1" colspan="2">KM Traveled</td>
    <td width="653" align="left" height="1">      
    <html:text property="kmTraveled" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="147" align="left" height="1"></td>
    <td width="194" align="left" height="1" colspan="2">Age of the Vehicle</td>
    <td width="653" align="left" height="1">      
    <html:text property="vehicleAge" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="147" align="left" height="1"></td>
    <td width="194" align="left" height="1" colspan="2">Vehicle Body </td>
    <td width="653" align="left" height="1">
       <html:select property="vehiclestatus" style="width:145">
      <logic:present property="vehiclestatusList" name="OldVehiclePurchaseForm" >
      <bean:define id="vehiclestatusList" property="vehiclestatusList" name="OldVehiclePurchaseForm" type="java.util.Collection">
      </bean:define>
      <html:option value="--Choose a Vehicle Status--"></html:option>
      <html:options collection="vehiclestatusList" property="optioncode" labelProperty="optiondesc"></html:options>
      </login:present>
      </html:select>
       </td>
  </tr>
  
  <tr>
    <td width="147" align="left" height="1"></td>
    <td width="194" align="left" height="1" colspan="2">
     <p align="left">Company of Body</td>
    <td width="653" align="left" height="1">      
     <html:text property="bodyCmpy" style="width:113"/></td>
  </tr>
  
  <tr>      
    <td width="147" align="left" height="1">      
    <td width="834" align="left" height="1" colspan="3">       
		<img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="save()">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_clear.jpg" width="60" height="18">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_back.jpg" width="60" height="18" onclick="back()">
        </tr>  
</table>
</html:form>
</body>
</html:html>