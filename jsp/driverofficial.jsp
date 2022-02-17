<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/DriverOfficial.do";
%>
<html:html>

	<head>
		<title>Driver Official Details</title>
 	</head>
 	<script language="JavaScript">

	function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverofficialvalidate.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	function update()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverofficialvalidate.do?invoke=updateMethod";	
		document.forms[0].submit();
	}
	function retrieveall()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverofficial.do?invoke=retrieveallMethod";	
		document.forms[0].submit();
	}
	function licenceForm()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverlicence.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}
	
	function insuranceForm()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverpolicy.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}
	function clearform()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverofficial.do?invoke=clearformMethod";	
		document.forms[0].submit();
	}
</script>
 	
<body>
<html:form action="driverofficial" enctype="multipart/form-data">
<table  width="100%" cellspacing="8" cellpadding="5" border="0" height="85%">
 
  <tr> 
    <td width="152" height="43"></td>
    <td width="40" height="43" class="maintitle"><p align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/icn_driverofficial.jpg" width="40" height="40"></td>
    <td width="220" height="43" class="maintitle">DRIVER OFFICIAL DETAILS</td>
    <td width="555" height="43"></td>
  </tr>
  <tr> 
  	<tr> 
    <td width="152" height="38"></td>
    <td width="268" height="38" class="fieldname" colspan="2">Driver ID</td>
    <td width="555" height="38" class="fieldname">
    	<html:text property="driverId" style="width:113" onchange="retrieveall()"/> </td>
  </tr>
  	
    <td width="152" height="30"></td>
    <td width="268" height="30" class="fieldname" colspan="2">Name of the Institution</td>
    <td width="555" height="30" class="fieldname">  
    	<html:select property="instituteName" style="width:150">
    	<logic:present property="instlist" name="DriverOfficialForm">
      	<bean:define id="instlist" property="instlist" name="DriverOfficialForm" type="java.util.Collection">
      	</bean:define>
      	<html:option value="--Choose an Institution--"></html:option>
    	<html:options collection="instlist" property="instcode" labelProperty="instdesc"></html:options>
    	</logic:present>                                       
      	</html:select>  </td>
  </tr>
  <tr> 
    <td width="152" height="30"></td>
    <td width="268" height="30" class="fieldname" colspan="2">Department</td>
    <td width="555" height="30" class="fieldname">
     	<html:select property="department" style="width:155">
       	<logic:present property="deptlist" name="DriverOfficialForm">
       	<bean:define id="deptlist" name="DriverOfficialForm" property="deptlist" type="java.util.Collection">
       	</bean:define>
       	<html:option value=" --Choose a Department--"></html:option>
       	<html:options collection="deptlist" property="deptcode" labelProperty="deptdesc"></html:options>
       	</logic:present>
		</html:select></td>
  </tr>
  <tr> 
    <td width="152" height="38"></td>
    <td width="268" height="38" class="fieldname" colspan="2">Educational Qualification</td>
    <td width="555" height="38" class="fieldname">
    	<html:text property="educationalQualification" style="width:113"/> </td>
  </tr>
  <tr> 
    <td width="152" height="30"></td>
    <td width="268" height="30" class="fieldname" colspan="2">Percentage of Marks</td>
    <td width="555" height="30" class="fieldname"><html:text property="marks" style="width:113"/></td>
  </tr>
  <tr> 
    <td width="152" height="26"></td>
    <td width="268" height="26" class="subtitle" colspan="2">Experience</td>
    <td width="555" height="26"></td>
  </tr>
  <tr> 
    <td width="152" height="30"></td>
    <td width="268" height="30" class="fieldname" colspan="2">
	<p align="center">Transport</td>
    <td width="555" height="30" class="fieldname">
    	<html:text property="transport" style="width:113"/>
	</td>
  </tr>
  <tr> 
    <td width="152" height="30" class="fieldname"></td>
    <td width="268" height="30" class="fieldname" colspan="2">
	<p align="center">Non-Transport</td>
    <td width="555" height="30" class="fieldname">
    	<html:text property="nonTransport" style="width:113"/>
	</td>
  </tr>
  <tr> 
    <td width="152" height="30" class="fieldname"></td>
    <td width="268" height="30" class="fieldname" colspan="2">
	<p align="center">Non-Transport Description</td>
	<td width="555" height="30" class="fieldname">
    	<html:textarea property="nonTransportDesc" style="width:150;height:100"/>
	</td>
  </tr>
  
  <tr> 
    <td width="152" height="30"></td>
    <td width="268" height="30" class="fieldname" colspan="2">Blood Group</td>
    <td width="555" height="30">
        <html:select property="bloodGroup" style="width:170">
    	<logic:present property="bloodgplist" name="DriverOfficialForm">
       	<bean:define id="bloodgplist" name="DriverOfficialForm" property="bloodgplist" type="java.util.Collection">
       	</bean:define>
     	<html:option value="--Choose a Blood Group --"></html:option>
       	<html:options collection="bloodgplist" property="bloodgpcode" labelProperty="bloodgpdesc"></html:options>
       	</logic:present>
      	</html:select>  
    </td>
  </tr>
  <tr> 
    <td width="152" height="27"></td>
    <td width="268" height="27" class="fieldname" colspan="2">Licence Number</td>
    <td width="555" height="27" class="fieldname">
    <html:text property="licenceNo" style="width:113"/>
    	<img border="0" src="<%=request.getContextPath()%>/images/btn_licencedetails.jpg" onclick="licenceForm()">
	</td>
  </tr>
  <tr> 
    <td width="152" height="32"></td>
    <td width="268" height="32" class="fieldname" colspan="2">Insurance Number</td>
    <td width="555" height="32" class="fieldname">
    	<html:text property="insuranceNo" style="width:113"/>
        <img border="0" src="<%=request.getContextPath()%>/images/btn_insurancedetails.jpg" onclick="insuranceForm()">
	</td>
  </tr>
    <html:errors/>
  <tr> 
    <td align="center" width="152"></td>
    <td align="center" colspan="3" width="838">
	<p align="left">
	<img border="0" src="<%=request.getContextPath()%>/images/btn_update.jpg" width="60" height="18" onclick="update()">
	<img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="save()">
	<!--<img border="0" src="<%=request.getContextPath()%>/images/btn_edit.jpg" width="60" height="18">-->
	<img border="0" src="<%=request.getContextPath()%>/images/btn_clear.jpg" width="60" height="18" onclick="clearform()">
	</td>
  </tr>
</table>

</html:form>
</body>
</html:html>