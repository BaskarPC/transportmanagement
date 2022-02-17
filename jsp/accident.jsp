
<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/accident.do";
%>
<html:html>

	<head>
		<title>Accident Details</title>
 	</head>
 	
 	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	
		function clear()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/accident.do?invoke=clearformMethod";	
		document.forms[0].submit();
	}	
		function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/accident.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
		function vehicletyperetrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/accident.do?invoke=vehicletyperetrieveMethod";	
		document.forms[0].submit();
	}
		function vehicleidretrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/accident.do?invoke=vehicleidretrieveMethod";	
		document.forms[0].submit();
	}
		function drivernameretrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/accident.do?invoke=drivernameretrieveMethod";	
		document.forms[0].submit();
	}
		function retrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/accident.do?invoke=retrieveMethod";	
		document.forms[0].submit();
	}
		function expensechange()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/accident.do?invoke=expensechangeMethod";	
		document.forms[0].submit();
	}
 	</script>
 	
<body>
<html:form action="accident" enctype="multipart/form-data">
<table border="0" cellspacing="5" cellpadding="5">

  <tr>
    <td width="11%" height="36">
	<p align="right">
	</td>
    <td width="25%" height="36">
	<p align="right">
	<img border="0" src="<%=request.getContextPath()%>/images/icn_accident.jpg" width="40" height="40"></td>
    <td width="16%" height="36" class="maintitle">ACCIDENT DETAILS</td>
    <td width="18%" height="36"></td>
    <td width="26%" height="36"></td>
    <td width="26%" height="36"></td>
  </tr>
  
  <tr>
    <td width="11%" height="21"></td>
    <td width="25%" height="21" class="fieldname">Accident Date</td>
    <td width="16%" height="21" class="fieldname"> 
    <html:text property="accidentDate" style="width:113"/>
    <a href="#" onClick="showCalendar(this,document.AccidentDetailsForm.accidentDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.AccidentDetailsForm.accidentDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
	<img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a>
    </td>
    <td width="18%" height="21" class="fieldname">Accident Time</td>
    <td width="26%" height="21" class="fieldname"> 
    <html:text property="accidentTime" style="width:113"/>
  </tr>
  
  <tr>
    <td width="11%" height="21"></td>
    <td width="25%" height="21" class="fieldname">Accident Place</td>
    <td width="16%" height="21" class="fieldname"> 
    <html:text property="accidentPlace" style="width:113"/></td>        
    <td width="18%" height="21" class="fieldname">Near By Police Station</td>
    <td width="26%" height="21" class="fieldname"> 
    <html:text property="nearByPoliceStation" style="width:113"/></td>
  </tr>
    
  <tr>
    <td width="11%" height="21"></td>
    <td width="25%" height="21" class="fieldname">Institute Name</td>
    <td width="16%" height="21" class="fieldname">  
    <html:select property="instituteName1" style="width:113" onchange="vehicletyperetrieve()">
    <logic:present property="instituteName1List" name="AccidentDetailsForm">	
   <bean:define id="instituteName1List" name="AccidentDetailsForm" property="instituteName1List" type="java.util.Collection" >
   </bean:define>	
   <html:option value="Choose a Institute Name"></html:option>
   <html:options collection="instituteName1List" property="inst1code" labelProperty="inst1desc"></html:options>
   </logic:present>
   </html:select>     
   </td>

    <td width="18%" height="21" class="fieldname">Vehicle Type</td>
    <td width="26%" height="21" class="fieldname">    
    <html:select property="vehicleType" style="width:113" onchange="vehicleidretrieve()">
    <logic:present property="vehicleTypeList" name="AccidentDetailsForm">	
    <bean:define id="vehicleTypeList" name="AccidentDetailsForm" property="vehicleTypeList" type="java.util.Collection" >
    </bean:define>	
	<html:option value="Choose a Vehicle Type"></html:option>
	<html:options collection="vehicleTypeList" property="vehicletypecode" labelProperty="vehicletypedesc"></html:options>
	</logic:present>
	</html:select></td>    
 	</tr>
 
  <tr>
    <td width="11%" height="21" class="fieldname"></td>
    <td width="25%" height="21" class="fieldname">Vehicle Registration Number</td>
    <td width="62%" height="21" colspan="3">      
    <html:select property="vehicleId" style="width:113" onchange="retrieve()">
    <logic:present property="vehicleIdList" name="AccidentDetailsForm">	
    <bean:define id="vehicleIdList" name="AccidentDetailsForm" property="vehicleIdList" type="java.util.Collection" >
     </bean:define>	
	<html:option value="Choose a Vehicle ID"></html:option>
	<html:options collection="vehicleIdList" property="vehicleidcode" labelProperty="vehicleiddesc"></html:options>
	</logic:present>
	</html:select>   
    </td>
    </tr>
  
  <tr>
    <td width="11%" height="21" class="fieldname"></td>
    <td width="25%" height="21" class="fieldname">Driver ID</td>
    <td width="16%" height="21" class="fieldname">
    <html:select property="driverId" style="width:113" onchange="drivernameretrieve()">
	<logic:present property="driverIdList" name="AccidentDetailsForm">	
   <bean:define id="driverIdList" name="AccidentDetailsForm" property="driverIdList" type="java.util.Collection" >
  </bean:define>	
	<html:option value="Choose a Driver ID"></html:option>
	<html:options collection="driverIdList" property="drivercode" labelProperty="driverdesc"></html:options>
	</logic:present>
	</html:select>     
	</td>
    <td width="18%" height="21" class="fieldname">Driver Name</td>
    <td width="26%" height="21" class="fieldname"> 
    <html:text property="driverName" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="11%" height="27"></td>
    <td width="25%" height="27" class="fieldname">Opponent Vehicle Registration Number</td>
    <td width="16%" height="27" class="fieldname"> 
    <html:text property="opponentVehicleId" style="width:113"/></td>
    <td width="18%" height="27" class="fieldname">Opponent Vehicle Type </td>
    <td width="26%" height="27" class="fieldname"> 
    <html:text property="opponentVehicleType" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="11%" height="21"></td>
    <td width="25%" height="21" class="fieldname">Number of Persons Injured</td>
    <td width="62%" height="21" colspan="3" class="fieldname">
	 <html:text property="noOfPersonsInjured" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="11%" height="21"></td>
    <td width="25%" height="21" class="fieldname">FIR Filed</td>
    <td width="16%" height="21" class="fieldname">
    <html:select property="FIROption" style="width:113">
    <logic:present property="FIRList" name="AccidentDetailsForm">
    <bean:define id="FIRList" name="AccidentDetailsForm" property="FIRList" type="java.util.Collection">
    </bean:define>
    <html:option value="--Choose an Option --"></html:option>
    <html:options collection="FIRList" property="optioncode" labelProperty="optiondesc"></html:options>
    </logic:present>	
	</html:select>
	</td>
	
	<td width="18%" height="21" class="fieldname">Case Closed</td>
    <td width="26%" height="21" class="fieldname">
    <html:select property="caseOption" style="width:113">
    <logic:present property="caseList" name="AccidentDetailsForm">
    <bean:define id="caseList" name="AccidentDetailsForm" property="caseList" type="java.util.Collection">
    </bean:define>
    <html:option value=" "></html:option>
    <html:options collection="caseList" property="casecode" labelProperty="casedesc"></html:options>
    </logic:present>			
	</html:select></td>
  </tr>
  
  <tr>
    <td width="11%" height="21"></td>
    <td width="25%" height="21" class="fieldname">Insurance Claimed</td>
    <td width="62%" height="21" colspan="3" class="fieldname">
    <html:select property="insuranceOption" style="width:113">
    <logic:present property="insuranceList" name="AccidentDetailsForm" >
    <bean:define id="insuranceList" name="AccidentDetailsForm" property="insuranceList" type="java.util.Collection">
    </bean:define>
    <html:option value="--Choose an Option --"></html:option>
    <html:options collection="insuranceList" property="insurancecode" labelProperty="insurancedesc"></html:options>
    </logic:present>			
	</html:select></td>
  </tr>
  
  <tr>
    <td width="11%" height="24"></td>
    <td width="25%" height="24" class="fieldname">Amount claimed from Insurance</td>
    <td width="16%" height="24" class="fieldname">
     <html:text property="amtClaimedFromInsurance" style="width:113"/></td>     
    <td width="18%" height="24">Amount claimed from Opponent</td>
    <td width="26%" height="24" class="fieldname">
     <html:text property="amtClaimedFromOpponent" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="11%" height="24"></td>
    <td width="25%" height="24" class="fieldname">Expenses</td>
    <td width="16%" height="24" class="fieldname">    
	 <html:select property="expense" style="width:113" onchange="expensechange()">
	 <logic:present property="expenseList" name="AccidentDetailsForm">	
     <bean:define id="expenseList" name="AccidentDetailsForm" property="expenseList" type="java.util.Collection" >
     </bean:define>	  
	<html:option value="Enter the option"></html:option>
	<html:options collection="expenseList" property="expensecode" labelProperty="expensedesc"></html:options>
	</logic:present>
	</html:select>     
     </td>	  
     </tr>
      
 <% 
 out.println(session.getAttribute("EXPENSES"));
if(session.getAttribute("EXPENSES")!=null && session.getAttribute("EXPENSES").toString().equals("DriverPaid")) { 
%>   
   
  <tr>
    <td width="11%" height="26"></td>
    <td width="25%" height="26" class="fieldname">Driver paid</td>
    <td width="62%" height="26" colspan="3" class="fieldname"> 
    <html:text property="driverPaid" style="width:113"/></td>
  </tr>
  
  <% } %>  
  
   <tr>
    <td width="11%" height="24"></td>
    <td width="25%" height="24" class="fieldname">Name of the Institution</td>
    <td width="16%" height="24" class="fieldname">    
	 <html:select property="instituteName" style="width:113">
	 <logic:present property="instituteNameList" name="AccidentDetailsForm">	
     <bean:define id="instituteNameList" name="AccidentDetailsForm" property="instituteNameList" type="java.util.Collection" >
     </bean:define>	  
	<html:option value=" "></html:option>
	<html:options collection="instituteNameList" property="instcode" labelProperty="instdesc"></html:options>
	</logic:present>
	</html:select>     
     </td>	
    <td width="18%" height="24" class="fieldname">Amount Paid by Institution</td>
    <td width="26%" height="24" class="fieldname">
	 <html:text property="amtPaidByInstitute" style="width:113"/></td>
  </tr>
  
   <tr>
    <td width="11%" height="42"></td>
    <td width="25%" height="42" class="fieldname">Accident Description</td>
    <td width="62%" height="42" colspan="3" class="fieldname">
	 <html:textarea property="accidentDesc" style="width:113;height=50"/></td>
  </tr>
  
  <tr>
    <td width="11%" height="60">     
    <p align="center"></td>
    <td width="87%" height="60" colspan="4">     
    <p align="center">          
		<img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="save()">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_edit.jpg" width="60" height="18">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_update.jpg" width="60" height="18">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_clear.jpg" width="60" height="18" onclick="clear()">
		</td>
  </tr>
</table>
</html:form>
</body>
</html:html>
