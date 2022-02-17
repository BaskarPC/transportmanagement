<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/dieseloutside.do";
%>
<html:html>
	<head>
		<title>Diesel Outside</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieseloutside.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieseloutside.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieseloutside.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieseloutside.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	function selectInstName()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieseloutside.do?invoke=instMethod";	
		document.forms[0].submit();
	}
	function selectVehicleType()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieseloutside.do?invoke=vehicleMethod";	
		document.forms[0].submit();
	}
	function selectVehicleNumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieseloutside.do?invoke=driverMethod";	
		document.forms[0].submit();
	}
	function selectFuelName()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieseloutside.do?invoke=lastFillingKMMethod";	
		document.forms[0].submit();
	}
	function selectQuantity()
	{
		
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieseloutside.do?invoke=quantityMethod";	
		document.forms[0].submit();
	}
	function selectDifference()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieseloutside.do?invoke=differenceMethod";	
		document.forms[0].submit();
	}
	
</script>

<body> 
		<html:form action="dieseloutside" enctype="multipart/form-data">
		<table border="0" width="100%" cellspacing="7" cellpadding="7" height="205">
<tr>
    <td width="25%" colspan="2" height="55">
      <p align="center">&nbsp;</td>
    <td width="13%" height="55">
      <p align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/icn_dieselout.jpg" width="40" height="40"></td>
    <td width="32%" height="55" class="maintitle">OUTSIDE FUEL ENTRY FORM</font></td>
    <td width="50%" colspan="3" height="55">
      &nbsp;</td>
  </tr>  
  <tr>
    <td width="13%" height="21">&nbsp;</td>
    <td width="72%" height="21" colspan="5">&nbsp;</td>
    <td width="15%" height="21">&nbsp;</td>
  </tr>
  
  <tr>
    <td width="13%" height="20"></td>
    <td width="72%" colspan="5" height="20">
    </td>
    <td width="15%" height="20"></td>
  </tr>
  <tr>
    <td width="13%" height="158"></td>
    <td width="72%" colspan="5" height="158">
      <table border="2" width="98%" cellspacing="3" cellpadding="3">
        <tr>
          <td width="23%" class="fieldname">Date</td>
          <td width="28%" class="fieldname"><html:text property="requestedDate" style="width:113"/>
          <a href="#" onClick="showCalendar(this,document.DieselOutsideForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.DieselOutsideForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
          <td width="19%" class="fieldname">Bill Number</td>
          <td width="25%" colspan="2" class="fieldname">
			<p align="left">
			<html:text property="billNumber" style="width:113"/></td>
			        </tr>
			        <tr>
          <td width="22%" class="fieldname">Name of the Institution</td>
          <td width="32%" class="fieldname">
          		<html:select property="institutionName" onchange="javascript:selectInstName()">
                        <html:option value="0">- - Choose Institution - -</html:option>
                            <logic:present property="instList" name="DieselOutsideForm">	
								<bean:define id="instList" name="DieselOutsideForm" property="instList" type="java.util.Collection" ></bean:define>
								<html:options collection="instList" property="instId" labelProperty="instDesc"></html:options>
							</logic:present>                                                                          
                        </html:select></td>
          <td width="17%" class="fieldname">Fuel Type</td>
          <td width="26%" class="fieldname">
          		<html:select property="fuelType" onchange="javascript:selectFuelName()">
     				  <html:option value="0">- -Choose Fuel Type - -</html:option>
                     <logic:present property="fuelList" name="DieselOutsideForm">	
								<bean:define id="fuelList" name="DieselOutsideForm" property="fuelList" type="java.util.Collection" ></bean:define>
								<html:options collection="fuelList" property="fuelId" labelProperty="fuelDesc"></html:options>
							</logic:present>   
                   </html:select></td>
        </tr>
        <tr>
          <td width="22%" class="fieldname">Bunk Name</td>
          <td width="32%" class="fieldname"><html:select property="bunkName">
                         <html:option value="0">- - Choose Bunk Name - -</html:option>
                                                                                              
                        </html:select></td>
          <td width="17%" class="fieldname">Other Bunk Name</td>
          <td width="26%" class="fieldname">
			<html:text property="otherBunkName" style="width:113"/></td>
        </tr>
			        
			        
        
        <tr>
          <td width="22%" class="fieldname">Vehicle Type</td>
          <td width="32%" class="fieldname">
          				<html:select property="vehicleType" onchange="javascript:selectVehicleType()">
          				<html:option value="0">--Choose Vehicle Type--</html:option>
                                <logic:present property="typeList" name="DieselOutsideForm">	
								<bean:define id="typeList" name="DieselOutsideForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:options collection="typeList" property="typeId" labelProperty="typeDesc"></html:options>
							</logic:present>                                                                   
                        </html:select></td>
          <td width="17%" class="fieldname">Rate/Liter</td>
          <td width="26%" class="fieldname">
			<html:text property="unitRate" style="width:113"/></td>
        </tr>
        <tr>
          <td width="22%" class="fieldname">Vehicle Number</td>
          <td width="32%" class="fieldname">
          		<html:select property="vehicleNumber" onchange="javascript:selectVehicleNumber()">
                           <html:option value="0"> - - Choose a Vehicle Number --</html:option>
                           <logic:present property="vehicleList" name="DieselOutsideForm">	
								<bean:define id="vehicleList" name="DieselOutsideForm" property="vehicleList" type="java.util.Collection" ></bean:define>
								<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
							</logic:present>                                                                    
                        </html:select></td>
          <td width="17%" class="fieldname">Quantity Wanted</td>
          <td width="26%" class="fieldname">
			<html:text property="wantedQuantity" style="width:113" onblur="selectQuantity()"/></td>
        </tr>
        <tr>
          <td width="22%" class="fieldname">Route Number</td>
          <td width="32%" class="fieldname">
			<html:text property="routeNumber" style="width:113"/></td>
          <td width="17%" class="fieldname">Amount</td>
          <td width="26%" class="fieldname">
			<html:text property="totalAmount" style="width:113"/></td>
        </tr>
        </table>
    	</td>
    <td width="15%" height="158"></td>
  </tr>
  <tr>
    <td width="15%" height="15"></td>
  </tr>
  <tr>
    <td width="13%" height="21"></td>
    <td width="72%" height="21" colspan="5" class="subtitle">TO BE FILLED BY THE DRIVER</td>
    <td width="15%" height="21"></td>
  </tr>
  <tr>
    <td width="13%" height="21"></td>
    <td width="15%" height="21" colspan="4"></td>
    <td width="57%" height="21"></td>
    <td width="15%" height="21"></td>
  </tr>
  <tr>
    <td width="13%" height="21"></td>
    <td width="72%" height="21" colspan="5">
      <table border="2" width="98%" cellspacing="3" cellpadding="3">
        <tr>
          <td width="25%" class="fieldname">Driver Name</td>
          <td width="25%" class="fieldname"><html:text property="driverName" style="width:113"/></td>
          <td width="25%" class="fieldname">Requested Driver Name</td>
          <td width="20%" class="fieldname"><html:text property="requestedDriverName" style="width:113"/></td>
        </tr>
        <tr>
          <td width="25%" class="fieldname">Present KM</td>
          <td width="25%" class="fieldname"><html:text property="presentKm" style="width:113" onblur="javascript:selectDifference()"/></td>
          <td width="25%" class="fieldname">Difference KM</td>
          <td width="20%" class="fieldname"><html:text property="differenceKm" style="width:113"/></td>
        </tr>
        <tr>
          <td width="25%" class="fieldname">Last Filling KM</td>
          <td width="25%" class="fieldname"><html:text property="lastFillingKm" style="width:113"/></td>
          <td width="25%" class="fieldname">Average KM</td>
          <td width="20%" class="fieldname">
          <html:text property="averageKm" style="width:113"/></td>
        </tr>
        <tr>
          <td width="25%" class="fieldname"></td>
          <td width="25%" class="fieldname">Remarks</td>
          <td width="45%" class="fieldname" colspan="2">
			<html:text property="remarks" style="width:113"/></td>
        </tr>
        </table>
    </td>
    <td width="15%" height="21"></td>
  </tr>
  <tr>
    <td width="13%" height="21">&nbsp;</td>
    <td width="15%" height="21" colspan="4">&nbsp;</td>
    <td width="57%" height="21">&nbsp;</td>
    <td width="15%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21" colspan="2">
    </td>
    <td width="2%" height="21">
      Image Upload</td>
    <td width="5%" height="21">
     </td>
  </tr>
  <tr>
    <td width="100%" height="21" colspan="7">
      &nbsp;</td>
  </tr>
  <tr>
    <td width="100%" height="21" colspan="7">
      <p align="center">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="javascript:submitdone()">&nbsp; 
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18" onclick="javascript:issuedone()">&nbsp; 
		<img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18" onclick="javascript:approvedone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18" onclick="javascript:okdone()"></td>
  </tr>
</table>
</html:form>


</body>
</html:html>