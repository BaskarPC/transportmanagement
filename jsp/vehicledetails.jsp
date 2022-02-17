<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/vehicledetails.do";
%>
<html:html>

	<head>
		<title>Vehicle Purchase Details</title>
 	</head>
 	
 	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
 	<script language="JavaScript">
	
		function oldvehicleForm()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oldvehiclepurchase.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}	
		function equipmentForm()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/equipmentdetails.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}
		function insertinst()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicledetails.do?invoke=insertinstMethod";	
		document.forms[0].submit();
	}
		function insertlookupvtype()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicledetails.do?invoke=Lookupinsertvtype";	
		document.forms[0].submit();
	}
		function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicledetails.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
		function update()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicledetails.do?invoke=updateMethod";	
		document.forms[0].submit();
	}
		function vehicletypecombo()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicledetails.do?invoke=comboMethod";	
		document.forms[0].submit();
	}
		function retrieveid()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicledetails.do?invoke=retrieveidMethod";	
		document.forms[0].submit();
	}	
		function deleteindicator()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/vehicledetails.do?invoke=deleteindicatorMethod";	
		document.forms[0].submit();
	}	
	</script>
 	
 	<body>
 	<html:form action="vehicledetails" enctype="multipart/form-data">
 	<table border="0" width="100%" cellpadding="5" cellspacing="8" height="121%">
    
  <tr>
    <td width="136" align="left" height="51">
    <p align="right">
	</td>
    <td width="10" align="left" height="51">
 	<img border="0" src="<%=request.getContextPath()%>/images/icn_vehicledetails.jpg" width="40" height="40" align="right"></td>
    <td width="235" align="left" height="51" class="maintitle">VEHICLE PURCHASE DETAILS
    </td>
    <td width="596" align="left" height="51">
 </td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="21">
    </td>
    <td width="257" align="left" height="21" colspan="2">Date of Purchase</td>
    <td width="596" align="left" height="21">      
        <html:text property="dateOfPurchase" style="width:113"/>
         <a href="#" onClick="showCalendar(this,document.VehicleDetailsForm.dateOfPurchase,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.VehicleDetailsForm.dateOfPurchase,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		  <img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
		   </a>    
    </td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25">
   </td>
    <td width="257" align="left" height="25" colspan="2">Manufacturing Date</td>
        <td width="596" align="left" height="25">      
        <html:text property="manufacturingDate" style="width:113"/>
         <a href="#" onClick="showCalendar(this,document.VehicleDetailsForm.manufacturingDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.VehicleDetailsForm.manufacturingDate,'anchor03','dd MMM yyyy'); return false;" NAME="anchor04" ID="anchor04">
		 <img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
		</a>
        </td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25">
   </td>
    <td width="257" align="left" height="25" colspan="2">
      Name of the Institution</td>
    <td width="596" align="left" height="25">  
    <html:select property="instituteName" style="width:100" >
	<logic:present property="instituteNameList" name="VehicleDetailsForm">	
	<bean:define id="instituteNameList" name="VehicleDetailsForm" property="instituteNameList" type="java.util.Collection" >
	</bean:define>	
	<html:option value="Choose Institute Name"></html:option>
	<html:options collection="instituteNameList" property="instcode" labelProperty="instdesc"></html:options>
	</logic:present>
	</html:select></td>          
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">Others(Insitution)</td>
    <td width="596" align="left" height="25">      
        <html:text property="othersInsitution" style="width:113"/>
        <img border="0" src="<%=request.getContextPath()%>/images/btn_insert.jpg" onclick="insertinst()">
        </td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">Vehicle Registration Number</td>
    <td width="596" align="left" height="25">      
        <html:text property="vehicleId" style="width:113" onchange="retrieveid()"/></td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25">
    </td>
    <td width="257" align="left" height="25" colspan="2">Price</td>
    <td width="596" align="left" height="25">      
        <html:text property="price" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">
      <p align="left">Name of  the Supplier</p></td>
    <td width="596" align="left" height="25">      
       <html:text property="supplierName" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">
      <p align="left">Vehicle Type</td>
    <td width="596" align="left" height="25">    
    <html:select property="vehicleType" style="width:100" >
	<logic:present property="vehicleList" name="VehicleDetailsForm">	
	<bean:define id="vehicleList" name="VehicleDetailsForm" property="vehicleList" type="java.util.Collection" >
	</bean:define>	
	<html:option value="Choose a Vehicle Type"></html:option>
	<html:options collection="vehicleList" property="vehicletypecode" labelProperty="vehicletypedesc"></html:options>
	</logic:present>
	</html:select>         
    </td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">Others( Vehicle Type)</td>
    <td width="596" align="left" height="25">      
        <html:text property="others" style="width:113"/>
        <img border="0" src="<%=request.getContextPath()%>/images/btn_insert.jpg" onclick="insertlookupvtype()">
        </td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25">
    </td>
    <td width="257" align="left" height="25" colspan="2">Make</td>
    <td width="596" align="left" height="25">      
        <html:text property="make" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">Chassis Number</td>
    <td width="596" align="left" height="25">      
        <html:text property="chassisNo" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">Engine Number</td>
    <td width="596" align="left" height="25">      
        <html:text property="engineNo" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">Type of Body</td>
    <td width="596" align="left" height="25">      
       <html:text property="bodyType" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">Tank Capacity</td>
    <td width="596" align="left" height="25">      
        <html:text property="tankCapacity" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">Seating Capacity</td>
    <td width="596" align="left" height="25">      
        <html:text property="seatCapacity" style="width:113"/></td>
  </tr>
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">Wheel Base</td>
    <td width="596" align="left" height="25">      
        <html:text property="wheelBase" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">Vehicle Status</td>
    <td width="596" align="left" height="25">
    <html:select property="vehicleStatus" style="width:100" >
	<logic:present property="vehiclestatusList" name="VehicleDetailsForm">	
	<bean:define id="vehiclestatusList" name="VehicleDetailsForm" property="vehiclestatusList" type="java.util.Collection" >
	</bean:define>	
	<html:option value="Choose a Vehicle Status"></html:option>
	<html:options collection="vehiclestatusList" property="vehiclestatuscode" labelProperty="vehiclestatusdesc"></html:options>
	</logic:present>
	</html:select>                             
    <img border="0" src="<%=request.getContextPath()%>/images/btn_oldvehiclepurchase.jpg" width="150" height="18" onclick="oldvehicleForm()"></td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="21"></td>
    <td width="257" align="left" height="21" colspan="2">Road Tax Paid</td>
    <td width="596" align="left" height="21">    
    <html:select property="roadyesNoOption" style="width:100" >
	<logic:present property="yesNoOptionList" name="VehicleDetailsForm">	
	<bean:define id="yesNoOptionList" name="VehicleDetailsForm" property="yesNoOptionList" type="java.util.Collection" >
	</bean:define>	
	<html:option value="Choose a Option"></html:option>
	<html:options collection="yesNoOptionList" property="optioncode" labelProperty="optiondesc"></html:options>
	</logic:present>
	</html:select>        
	</td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">From</td>
    <td width="596" align="left" height="25">
              <html:text property="roadTaxFrom" style="width:113"/>    
    </td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">To</td>
    <td width="596" align="left" height="25">
              <html:text property="roadTaxTo" style="width:113"/></td>
    </tr>
    
  <tr>
    <td width="136" align="left" height="21"></td>
    <td width="257" align="left" height="21" colspan="2">Insurance Paid</td>
    <td width="596" align="left" height="21">
    <html:select property="insuranceOption" style="width:145">    
   <logic:present property="insuranceOptionList" name="VehicleDetailsForm">	
<bean:define id="insuranceOptionList" name="VehicleDetailsForm" property="insuranceOptionList" type="java.util.Collection" >
</bean:define>	
<html:option value="Choose a option"></html:option>
<html:options collection="insuranceOptionList" property="insurancecode" labelProperty="insurancedesc"></html:options>
</logic:present>
</html:select>		      
    </td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="center" height="25" colspan="2">From
    <td width="596" align="left" height="25">
              <html:text property="insuranceFrom" style="width:113"/>
        </td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="center" height="25" colspan="2">To
    <td width="596" align="left" height="25">      
        <html:text property="insuranceTo" style="width:113"/>     
    </td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">Insurance Company Name</td>
    <td width="596" align="left" height="25">
             <html:text property="insuranceCmpyName" style="width:113"/></td>
    </tr>
  <tr>
  
    <td width="136" align="left" height="25"></td>
    <td width="257" align="left" height="25" colspan="2">FC Expiry Date</td>
    <td width="596" align="left" height="25">
             <html:text property="fcExpiryDate" style="width:113"/>
        </td>
  </tr>
  
  <tr>
    <td width="136" align="left" height="22"></td>
    <td width="257" align="left" height="22" colspan="2">Valid Permit Date</td>
    <td width="596" align="left" height="22">
             <html:text property="validPermitDate" style="width:113"/>
        </td>
  </tr>
  
  <tr>      
    <td width="136" align="left" height="59">      
    <td width="845" align="left" height="59" colspan="3">  
        <p>	
		<img border="0" src="<%=request.getContextPath()%>/images/btn_update.jpg" width="60" height="18" onclick="update()">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="save()">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_edit.jpg" width="60" height="18">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_delete.jpg" width="60" height="18" onclick="deleteindicator()">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_equipmentform.jpg" width="140" height="18" onclick="equipmentForm()"></tr>
  
  </table>
</html:form>
</body>
</html:html>
