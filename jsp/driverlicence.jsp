<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/DriverLicence.do";
%>
<html:html>

	<head>
		<title>Driver Licence Details</title>
 	</head>
 	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function back()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverlicence.do?invoke=backMethod";	
		document.forms[0].submit();
	}
	function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverlicencevalidate.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	function update()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverlicencevalidate.do?invoke=updateMethod";	
		document.forms[0].submit();
	}
	function insertothers()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverlicence.do?invoke=insertothersMethod";	
		document.forms[0].submit();
	}
	function clearform()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverlicence.do?invoke=clearformMethod";	
		document.forms[0].submit();
	}
	function retrieve()
	{
	   	document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/driverlicence.do?invoke=retrieveMethod";	
		document.forms[0].submit();
	}
	
	</script>
<body>
<html:form action="driverlicence" enctype="multipart/form-data">
<table border="0" width="100%" cellSpacing="8"  height="50%" cellpadding="5">
  
  <tr>
    <td width="144" height="44">
	<p align="right">
	</td>
    <td width="59" height="44" class="maintitle">
	<img border="0" src="<%=request.getContextPath()%>/images/icn_driverlicense.jpg" width="40" height="40" align="right"></td>
    <td width="218" height="44" class="maintitle">DRIVER LICENCE DETAILS</td>
    <td width="546" align="left" height="44"></td>
  </tr>
  <tr>
    <td width="144" height="21"></td>
    <td width="285" height="21" class="fieldname" colspan="2">Driver ID</td>
    <td width="546" align="left" height="21" class="fieldname">
   		<html:select property="driverId" style="width:145" onchange="retrieve()">
		<logic:present property="driveridList" name="DriverLicenceForm">
      	<bean:define id="driveridList" property="driveridList" name="DriverLicenceForm" type="java.util.Collection">
      	</bean:define>
      	<html:option value="--Choose a DriverID--"></html:option>
      	<html:options collection="driveridList" property="drivercode" labelProperty="driverdesc"></html:options>
      	</logic:present>
		</html:select>
      </td>
  </tr>
  <tr>
    <td width="144" height="28"></td>
    <td width="285" height="28" class="fieldname" colspan="2">Driver Name</td>
    <td width="546" align="left" height="28" class="fieldname">
            <html:text property="driverName" style="width:113"/></td>
  </tr>
  <tr>
    <td width="144" height="28"></td>
    <td width="285" height="28" class="fieldname" colspan="2">Driver Licence Number</td>
    <td width="546" align="left" height="28" class="fieldname">
           <html:text property="licenceNo" style="width:113"/>
     
    </td>
  </tr>
  <tr>
    <td width="144" height="28"></td>
    <td width="285" height="28" class="fieldname" colspan="2">Batch Number</td>
    <td width="546" align="left" height="28" class="fieldname">
         <html:text property="batchNo" style="width:113"/></td>
  </tr>
  <tr>
    <td width="144" height="28"></td>
    <td width="285" height="28" class="fieldname" colspan="2">Date of Licence</td>
    <td width="546" align="left" height="28" class="fieldname">
       <html:text property="dateOfLicence" style="width:113" readonly="true"/>
     	  <a href="#" onClick="showCalendar(this,document.DriverLicenceForm.dateOfLicence,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.DriverLicenceForm.dateOfLicence,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		  <img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
		  </a>     
    </td>
  </tr>
  <tr>
    <td width="144" height="27"></td>
    <td width="285" height="27" class="fieldname" colspan="2">Valid Period</td>
    <td width="546" align="left" height="27" class="fieldname">
      <html:text property="validPeriod" style="width:113" readonly="true"/>
      	<a href="#" onClick="showCalendar(this,document.DriverLicenceForm.validPeriod,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.DriverLicenceForm.validPeriod,'anchor03','dd MMM yyyy'); return false;" NAME="anchor04" ID="anchor04">
	  	<img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
		</a>
   </td>
  </tr>
  <tr >
     <td width="144" height="44"></td>
     <td width="285" height="44" class="fieldname" colspan="2">Category</td>
     <td width="546" class="fieldname">
     	<html:select property="categoryarray" style="width:145" multiple="true">
      	<logic:present property="categoryList" name="DriverLicenceForm">
      	<bean:define id="categoryList" property="categoryList" name="DriverLicenceForm" type="java.util.Collection">
      	</bean:define>
      	<html:option value="--Choose Category--"></html:option>
      	<html:options collection="categoryList" property="categorycode" labelProperty="categorydesc"></html:options>
      	</logic:present>
		</html:select>
		<html:text property="category" style="width:113" readonly="true"/>
    </td>
 </tr>
 <tr>
    <td width="144" height="28"></td>
    <td width="285" height="28" class="fieldname" colspan="2">Others</td>
    <td width="546" align="left" height="28" class="fieldname">
         <html:text property="others" style="width:113"/> 
         <img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="insertothers()"></td>
  </tr>
  <tr>
    <td width="144" height="33"></td>
    <td width="285" height="33" class="fieldname" colspan="2">Pre Driving Licence Expiry Date</td>
    <td width="546" align="left" height="33" class="fieldname">
       <html:text property="licenceExpiryDate" style="width:113" readonly="true"/>
 			<a href="#" onClick="showCalendar(this,document.DriverLicenceForm.licenceExpiryDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.DriverLicenceForm.licenceExpiryDate,'anchor05','dd MMM yyyy'); return false;" NAME="anchor06" ID="anchor06">
			<img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
			</a>
    </td>
  </tr>
  <tr>
    <td width="144" height="30"></td>
    <td width="285" height="30" class="fieldname" colspan="2">Endorsement</td>
    <td width="546" align="left" height="30" class="fieldname">
	     <html:select property="endorsementarray" style="width:145" multiple="true">
         <logic:present property="endorsementList" name="DriverLicenceForm">
    	 <bean:define id="endorsementList" property="endorsementList" name="DriverLicenceForm" type="java.util.Collection">
      	 </bean:define>
      	 <html:option value="--Choose a Number--"></html:option>
      	 <html:options collection="endorsementList" property="endorsementcode" labelProperty="endorsementdesc"></html:options>
      	 </logic:present>
		 </html:select>    
	     <html:text property="endorsement" style="width:113" readonly="true" />
    </td>
  </tr>
  <tr> 
    <td align="center" width="144"></td>
    <td align="center" width="285" class="fieldname" colspan="2">
	<p align="left">Punishments</td>
    <td align="left" width="546" class="fieldname">
		<html:textarea property="punishment" style="width:150;height:100"/>
	</td>
  </tr>
 <html:errors/>
   <tr> 
    <td align="center" width="144"></td>
    <td align="center" colspan="3" width="858">
	<p align="justify">
	<img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="save()">
	<!--<img border="0" src="<%=request.getContextPath()%>/images/btn_edit.jpg" width="60" height="18">-->
	<img border="0" src="<%=request.getContextPath()%>/images/btn_update.jpg" width="60" height="18" onclick="update()">
	<img border="0" src="<%=request.getContextPath()%>/images/btn_clear.jpg" width="60" height="18" onclick="clearform()">
	<img border="0" src="<%=request.getContextPath()%>/images/btn_back.jpg" width="60" height="18" onclick="back()">
	</td>
  </tr>
 </table>
</html:form>
</body>
</html:html>

