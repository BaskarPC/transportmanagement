
<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/DriverPersonal.do";
%>
<html:html>

	<head>
		<title>Driver Personal Details</title>
 	</head>
 		<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverpersonalvalidate.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	function update()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverpersonalvalidate.do?invoke=updateMethod";	
		document.forms[0].submit();
	}
	function retrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverpersonal.do?invoke=retrieveMethod";	
		document.forms[0].submit();
	}
	function deleteindicator()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverpersonal.do?invoke=deleteindicatorMethod";	
		document.forms[0].submit();
	}
	function clearform()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverpersonal.do?invoke=clearformMethod";	
		document.forms[0].submit();
	}
	function driverOfficialForm()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverofficial.do?invoke=defaultMethod";	
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
	function leaveForm()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverleave.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}
 	</script>
 	
<body>
<html:form action="driverpersonal" enctype="multipart/form-data">
<table border="0" width="100%" cellspacing="8" cellpadding="5" height="495">
  <tr>
    <td width="11%" height="36">
	<p align="right">
	</td>
    <td width="20%" height="36">
	<p align="right">
	<img border="0" src="<%=request.getContextPath()%>/images/icn_driverpersonal.jpg" width="40" height="40"></td>
    <td width="39%" height="36" class="maintitle" colspan="2">DRIVER PERSONAL DETAILS</td>
    <td width="26%" height="36" colspan="2"></td>
  </tr>
  <tr>
    <td width="11%" height="21"></td>
    <td width="20%" height="21" class="fieldname">Driver ID</td>
    <td width="21%" height="21" class="fieldname">
    	<html:select property="driverId" style="width:145" onchange="retrieve()">
		<logic:present property="driveridList" name="DriverPersonalForm">
      	<bean:define id="driveridList" property="driveridList" name="DriverPersonalForm" type="java.util.Collection">
      	</bean:define>
      	<html:option value="--Choose a DriverID--"></html:option>
      	<html:options collection="driveridList" property="drivercode" labelProperty="driverdesc"></html:options>
      	</logic:present>
		</html:select></td>
    <td width="18%" height="21" class="fieldname">Driver Name</td>
    <td width="26%" height="21" class="fieldname" colspan="2">
    	<html:text property="driverName" style="width:113"/></td>
  </tr>
  <tr>
    <td width="11%" height="19"></td>
    <td width="20%" height="19" class="fieldname">Permanent Address</td>
    <td width="21%" height="19" class="fieldname">
    	<html:textarea property="permanentAddress" style="width:150;height=100"/></td>
    <td width="18%" height="19" class="fieldname">Temporary Address</td>
    <td width="26%" height="19" class="fieldname" colspan="2">
		<html:textarea property="temporaryAddress" style="width:150;height=100"/></td>
  </tr>
  <tr>
    <td width="11%" height="21"></td>
    <td width="20%" height="21" class="fieldname">District</td>
    <td width="21%" height="21" class="fieldname">  
    	<html:select property="district1" style="width:150" >
  		<logic:present property="district1List" name="DriverPersonalForm">
    	<bean:define id="district1List" property="district1List" name="DriverPersonalForm" type="java.util.Collection">
    	</bean:define>
    	<html:option value="--Choose a District--"></html:option>
    	<html:options collection="district1List" property="district1code" labelProperty="district1desc"></html:options>
    	</logic:present>
		</html:select></td>
    <td width="18%" height="21" class="fieldname">District</td>
    <td width="26%" height="21" class="fieldname" colspan="2">
	 	<html:select property="district2" style="width:130" >
	 	<logic:present property="district2List" name="DriverPersonalForm">
     	<bean:define id="district2List" property="district2List" name="DriverPersonalForm" type="java.util.Collection">
     	</bean:define>
     	<html:option value="--Choose a District--"></html:option>
     	<html:options collection="district2List" property="district2code" labelProperty="district2desc"></html:options>
     	</logic:present>
     	</html:select></td>
  </tr>
  <tr>
    <td width="11%" height="21" class="fieldname"></td>
    <td width="20%" height="21" class="fieldname">State</td>
    <td width="21%" height="21" class="fieldname">
      	<html:select property="state1" style="width:120" >
      	<logic:present property="state1List" name="DriverPersonalForm">
      	<bean:define id="state1List" property="state1List" name="DriverPersonalForm" type="java.util.Collection">
      	</bean:define>
      	<html:option value="--Choose a State--"></html:option>
      	<html:options collection="state1List" property="state1code" labelProperty="state1desc"></html:options>
      	</logic:present>
	  	</html:select>     
	</td>
	<td width="18%" height="21" class="fieldname">State</td>
    <td width="26%" height="21" class="fieldname" colspan="2">
	 	<html:select property="state2" style="width:120" >
	 	<logic:present property="state2List" name="DriverPersonalForm">
      	<bean:define id="state2List" property="state2List" name="DriverPersonalForm" type="java.util.Collection">
      	</bean:define>
      	<html:option value="--Choose a State--"></html:option>
      	<html:options collection="state2List" property="state2code" labelProperty="state2desc"></html:options>
      	</logic:present>
	  	</html:select>
    </td>
  </tr>
  <tr>
    <td width="11%" height="21" class="fieldname"></td>
    <td width="85%" height="21" class="subtitle" colspan="5">Contact Number</td>
  </tr>
  <tr>
    <td width="11%" height="27"></td>
    <td width="20%" height="27" class="fieldname">Mobile Number</td>
    <td width="21%" height="27" class="fieldname">
    	<html:text property="mobileNo" style="width:113"/></td>
    <td width="18%" height="27" class="fieldname">Home Number</td>
    <td width="5%" height="27" class="fieldname">
		<html:text property="residentialNo1" style="width:50"/></td>
    <td width="5%" height="27" class="fieldname">
    	<html:text property="residentialNo2" style="width:113"/></td>
  </tr>
  <tr>
    <td width="11%" height="21"></td>
    <td width="20%" height="21" class="fieldname">Salary</td>
    <td width="21%" height="21" class="fieldname">
		<html:text property="salary" style="width:113"/></td>
    <td width="18%" height="21" class="fieldname">Community</td>
    <td width="26%" height="21" class="fieldname" colspan="2">
      <html:select property="community" style="width:155" >
      <logic:present property="communityList" name="DriverPersonalForm">
      <bean:define id="communityList" property="communityList" name="DriverPersonalForm" type="java.util.Collection">
      </bean:define>
      <html:option value="--Choose Community--"></html:option>
      <html:options collection="communityList" property="communitycode" labelProperty="communitydesc"></html:options>
      </logic:present>
	  </html:select>       
    </td>
  </tr>
  <tr>
    <td width="11%" height="24"></td>
    <td width="20%" height="24" class="fieldname">Date Of Birth</td>
    <td width="21%" height="24" class="fieldname">
    <html:text property="DOB" style="width:113"/>
		<a href="#" onClick="showCalendar(this,document.DriverPersonalForm.DOB,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.DriverPersonalForm.DOB,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
		</a>
    </td>
    <td width="18%" height="24">Religion</td>
    <td width="26%" height="24" class="fieldname" colspan="2">
    	<html:select property="religion" style="width:135" >
    	<logic:present property="religionList" name="DriverPersonalForm">
    	<bean:define id="religionList" property="religionList" name="DriverPersonalForm" type="java.util.Collection">
    	</bean:define>
    	<html:option value="--Choose Religion--"></html:option>
    	<html:options collection="religionList" property="religioncode" labelProperty="religiondesc"></html:options>
    	</logic:present>
		</html:select>
	</td>
  </tr>
  <tr>
  <td width="11%" height="24" class="fieldname"></td>
  <td width="20%" height="24" class="fieldname">Date of Joining</td>
  <td width="21%" height="24" class="fieldname">
  	<html:text property="DOJ" style="width:113"/>
  	<a href="#" onClick="showCalendar(this,document.DriverPersonalForm.DOJ,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.DriverPersonalForm.DOJ,'anchor03','dd MMM yyyy'); return false;" NAME="anchor04" ID="anchor04">
  	<img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
  	</a></td>
  <td width="18%" height="21" class="fieldname">Caste</td>
  <td width="26%" height="21" class="fieldname" colspan="2">
  	<html:text property="caste" style="width:113"/></td>
  </tr>
  <tr>
    <td width="11%" height="21"></td>
    <td width="87%" height="21" colspan="5"></td>
  </tr>
    <html:errors/>
  <tr>
    <td width="11%" height="21">     
    <p align="center"> </td>
    <td width="87%" height="21" colspan="5">
    <p align="center">
       <img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="save()">
       <img border="0" src="<%=request.getContextPath()%>/images/btn_update.jpg" width="60" height="18" onclick="update()">
		<!--<img border="0" src="<%=request.getContextPath()%>/images/btn_edit.jpg" width="60" height="18">-->
		<img border="0" src="<%=request.getContextPath()%>/images/btn_delete.jpg" width="60" height="18" onclick="deleteindicator()">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_clear.jpg" width="60" height="18" onclick="clearform()"></td>
  </tr>
     
</table>
</html:form>
</body>
</html:html>