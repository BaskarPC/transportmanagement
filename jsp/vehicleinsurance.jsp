
<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/VehicleInsurance.do";
%>
<html:html>

	<head>
		<title>Vehicle Insurance Details</title>
 	</head>
 	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	
	function vehicletyperetrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicleinsurance.do?invoke=vehicletyperetrieveMethod";	
		document.forms[0].submit();
	}	
	function vehicleidretrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicleinsurance.do?invoke=vehicleidretrieveMethod";	
		document.forms[0].submit();
	}
	function insert()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicleinsurance.do?invoke=insertMethod";	
		document.forms[0].submit();
	}
	function update()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicleinsurance.do?invoke=updateMethod";	
		document.forms[0].submit();
	}
	function retrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicleinsurance.do?invoke=retrieveMethod";	
		document.forms[0].submit();
	}
	function clearform()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicleinsurance.do?invoke=clearformMethod";	
		document.forms[0].submit();
	}
 	</script>
 	
<body>
<html:form action="vehicleinsurance" enctype="multipart/form-data">
<table border="0" width="100%" cellspacing="8" cellpadding="5" height="100%">
  
  <tr>
    <td width="13%" height="36">
    <p align="right"></td>
    <td width="19%" height="36">
    <p align="right">
	<img border="0" src="<%=request.getContextPath()%>/images/icn_businsurance.jpg" width="40" height="40"></td>
    <td width="26%" height="36" class="maintitle">
    VEHICLE INSURANCE DETAILS</td>
    <td width="19%" height="36"></td>
    <td width="19%" height="36"></td>
  </tr>
  
  <tr>
    <td width="13%" height="21"></td>
    <td width="19%" height="21">Name of the Institution</td>
    <td width="26%" height="21">
          <html:select property="instituteName" style="width:145" onchange="vehicletyperetrieve()">
		   <logic:present property="instList" name="VehicleInsuranceForm">
            <bean:define id="instList" property="instList" name="VehicleInsuranceForm" type="java.util.Collection">
            </bean:define>
   			<html:option value="--Choose Institution --"></html:option>
   			<html:options collection="instList" property="instcode" labelProperty="instdesc"></html:options>
   			</logic:present>                                       
      	    </html:select>
      	    </td>
      	
    <td width="19%" height="21">
    Vehicle Registration Number</td>
    <td width="19%" height="21">     
       <html:select property="vehicleId" style="width:145" onchange="retrieve()">
       <logic:present property="vehicleidList" name="VehicleInsuranceForm">
       <bean:define id="vehicleidList" property="vehicleidList" name="VehicleInsuranceForm" type="java.util.Collection">
       </bean:define>
   		<html:option value="--Choose Vehicle ID --"></html:option>
   		<html:options collection="vehicleidList" property="vehicleidcode" labelProperty="vehicleiddesc"></html:options>
   		</logic:present>   		
		</html:select></td>
  </tr>
  
  <tr>
    <td width="13%" height="19"></td>
    <td width="19%" height="19">
    <p align="left">Vehicle Type</td>
    <td width="26%" height="19">
   <html:select property="vehicleType" style="width:145" onchange="vehicleidretrieve()">
          <logic:present property="vehicletypeList" name="VehicleInsuranceForm">
          <bean:define id="vehicletypeList" property="vehicletypeList" name="VehicleInsuranceForm" type="java.util.Collection">
          </bean:define>
          <html:option value="--Choose a Vehicle --"></html:option>
          <html:options collection="vehicletypeList" property="vehicletypecode" labelProperty="vehicletypedesc"></html:options>
          </logic:present>		                                      
      	</html:select></td>
      	<td width="19%" height="19">
    <p align="left">Vehicle Model</td>
    <td width="26%" height="19">
    <html:text property="vehicleModel" style="width:113"/></td>
     </tr>
 
  <tr>
    <td width="13%" height="19"></td>    
    <td width="19%" height="19">Market Value</td>
    <td width="19%" height="19">
     <html:text property="marketValue" style="width:113"/></td>
  </tr>
  
   <tr>
       <td width="13%" height="19"></td>
    <td width="19%" height="19" align="left">Insurance Valid Date</td>
    <td width="66%" height="19" colspan="3">
    </td>
  </tr>
  
  <tr>
    <td width="13%" height="19"></td>
    <td width="19%" height="19"align="center">From</td>
    <td width="26%" height="19">
    <html:text property="insuranceValidFrom" style="width:113"/>
    <a href="#" onClick="showCalendar(this,document.VehicleInsuranceForm.insuranceValidFrom,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.VehicleInsuranceForm.insuranceValidFrom,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
	 <img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a>						
    </td>
    <td width="19%" height="19">
    <p align="center">To</td>
    <td width="19%" height="19">
   <html:text property="insuranceValidTo" style="width:113"/>
   <a href="#" onClick="showCalendar(this,document.VehicleInsuranceForm.insuranceValidTo,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.VehicleInsuranceForm.insuranceValidTo,'anchor03','dd MMM yyyy'); return false;" NAME="anchor04" ID="anchor04">
   <img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
    </a>
   </td>
  </tr>
 
  <tr>
    <td width="13%" height="19"></td>
    <td width="19%" height="19">
    <p align="left"><b>Existing Insurance Details</b></td>
    <td width="26%"></td>
    <td colspan="2"><b>Proposed Insurance Details</b></td>
    </tr>
    
  <tr>
    <td width="13%" height="19"></td>
    <td width="19%" height="19">
    <p align="left">Insurance Company Name</td>
    <td width="26%" height="19">
    <html:text property="existInsuranceCmpyName" style="width:113"/></td>
    <td width="19%" height="19">
    Insurance Company Name</td>
    <td width="19%" height="19">
     <html:text property="proposedInsuranceCmpyName" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="13%" height="19"></td>
    <td width="19%" height="19">
    <p align="left">Vehicle Value insured</td>
    <td width="26%" height="19">
    <html:text property="existVehicleValue" style="width:113"/></td>
    <td width="19%" height="19">
    Vehicle Value insured</td>
    <td width="19%" height="19">
     <html:text property="proposedVehicleValue" style="width:113"/></td>
  </tr>
  
<tr>
    <td width="13%" height="19"></td>
    <td width="19%" height="19">
    <p align="left">Insured Premium Amount</td>
    <td width="26%" height="19">
   <html:text property="existInsurancePremiumAmt" style="width:113"/></td>
    <td width="19%" height="19">
    Insured Premium Amount</td>
    <td width="19%" height="19">
    <html:text property="proposedInsurancePremiumAmt" style="width:113"/></td>
</tr>
 	<tr>
    <td width="13%" height="19"></td>
    <td width="84%" height="19" colspan="4"> 
<p align="center">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="insert()">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_update.jpg" width="60" height="18" onclick="update()">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_clear.jpg" width="60" height="18" onclick="clearform()">
		</p>    
     </td>
  </tr>
</table>
</html:form>
</body>
</html:html>
