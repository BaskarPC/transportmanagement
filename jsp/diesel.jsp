<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/diesel.do";
%>
<html:html>
	<head>
		<title>Diesel</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/diesel.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieselvalidate.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/diesel.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/diesel.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	function selectInstName()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/diesel.do?invoke=instMethod";	
		document.forms[0].submit();
	}
	function selectVehicleType()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/diesel.do?invoke=vehicleMethod";	
		document.forms[0].submit();
	}
	function selectVehicleNumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/diesel.do?invoke=driverMethod";	
		document.forms[0].submit();
	}
	function selectQuantity()
	{
		var availqty=document.forms[0].stock.value;
		var wantedqty=document.forms[0].wantedQuantity.value;
		if(availqty<wantedqty)
		{
			var c=confirm("Please enter the minimum required quantity");
			if(c)
			{
				document.forms[0].wantedQuantity.value="";
				document.forms[0].wantedQuantity.focus();
			}	
		}
		else
		{
			document.forms[0].method="post";
			document.forms[0].action = "<%=request.getContextPath()%>"+"/diesel.do?invoke=quantityMethod";	
			document.forms[0].submit();
		}
	}
	function selectDifference()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/diesel.do?invoke=differenceMethod";	
		document.forms[0].submit();
	}
</script>

<body> 
		<html:form action="diesel" enctype="multipart/form-data">
<table border="0" width="100%" cellspacing="7" cellpadding="7" height="205">
<tr>
    <td width="25%" colspan="2" height="55">
      <p align="center">&nbsp;</td>
    <td width="13%" height="55">
      <p align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/icn_diesel.jpg" width="40" height="40"></td>
    <td width="12%" height="55" class="maintitle">FUEL ENTRY FORM</font></td>
    <td width="50%" colspan="3" height="55">
      &nbsp;</td>
  </tr>
  
  <tr>
    <td width="13%" height="21">&nbsp;</td>
    <td width="72%" height="21" colspan="5">&nbsp;</td>
    <td width="15%" height="21">&nbsp;</td>
  </tr>
  
  <tr>
    <td width="13%" height="21"></td>
    <td width="72%" height="21" colspan="5" class="subtitle">BUNK NAME : K V I T T BUNK, K.E.C
      CAMPUS, PERUNDURAI</td>
    <td width="15%" height="21"></td>
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
      <table border="2" width="99%" cellspacing="3" cellpadding="3">
        <tr>
          <td width="23%" class="fieldname">Date</td>
          <td width="28%" class="fieldname"><html:text property="requestedDate" style="width:113"/>
          <a href="#" onClick="showCalendar(this,document.DieselForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.DieselForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a>
          </td>
          <td width="19%" class="fieldname">Bill Number</td>
          <td width="25%" colspan="2" class="fieldname">
			<p align="left">
			<html:text property="billNumber" style="width:113"/></td>
        </tr>
        <tr>
          <td width="23%" rowspan="2" class="fieldname">Name of the Institution</td>
          <td width="28%" rowspan="2" class="fieldname">
         				<html:select property="institutionName" style="width:150" onchange="javascript:selectInstName()">
						<html:option value="0">--Choose an Institution--</html:option>
							<logic:present property="instList" name="DieselForm">	
								<bean:define id="instList" name="DieselForm" property="instList" type="java.util.Collection" ></bean:define>
								<html:options collection="instList" property="instId" labelProperty="instDesc"></html:options>
							</logic:present>
						</html:select>	 
			</td>
          <td width="19%" rowspan="2" class="fieldname">Quantity Wanted</td>
          <td width="25%" class="fieldname" colspan="2">
			<html:text property="wantedQuantity" style="width:113" onblur="selectQuantity()"/></td>
        </tr>
        <tr>
        <td width="13%" rowspan="2">
            <p align="center" class="fieldname">&nbsp;&nbsp;&nbsp;&nbsp; New
            <html:text property="newRate" style="width:60" readonly="true"/>
            </p>
          </td>
         <td width="11%" rowspan="2">
            <p align="center" class="fieldname">&nbsp; Old
            <html:text property="oldRate" style="width:60" readonly="true"/>
            </p>
          </td>
                 
        </tr>
        <tr>
          <td width="23%" class="fieldname">Vehicle Type</td>
          <td width="28%" class="fieldname">
          <html:select property="vehicleType" onchange="javascript:selectVehicleType()">
                      
                            <html:option value="0">--Choose Vehicle Type--</html:option>
							<logic:present property="typeList" name="DieselForm">	
								<bean:define id="typeList" name="DieselForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:options collection="typeList" property="typeId" labelProperty="typeDesc"></html:options>
							</logic:present>
                                                                                             
                        </html:select></td>
          <td width="19%" class="fieldname">Rate/Liter</td>
        </tr>
        <tr>
          <td width="23%" class="fieldname">Vehicle Number</td>
          <td width="28%" class="fieldname">
          				<html:select property="vehicleNumber" onchange="javascript:selectVehicleNumber()">
                            <html:option value="0"> - - Choose a Vehicle Number --</html:option>
                            <logic:present property="vehicleList" name="DieselForm">	
								<bean:define id="vehicleList" name="DieselForm" property="vehicleList" type="java.util.Collection" ></bean:define>
								<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
							</logic:present>                                                                  
                        </html:select></td>
          <td width="19%" class="fieldname">Diesel filled (liter)</td>
          <td width="13%" class="fieldname">
			<p align="center"><html:text property="newAvailable" style="width:60" readonly="true"/></td>
          <td width="11%" class="fieldname">
			<p align="center"><html:text property="oldAvailable" style="width:60" readonly="true"/></td>
        </tr>
        <tr>
          <td width="23%" class="fieldname">Route Number</td>
          <td width="28%" class="fieldname"><b>
			<html:text property="routeNumber" style="width:113" readonly="true"/></b></td>
          <td width="19%" class="fieldname">Amount
          </td>
          <td width="25%" class="fieldname" colspan="2">
			<html:text property="totalAmount" style="width:113" readonly="true"/></td>
        </tr>
         <tr>
          <td width="23%" class="fieldname">&nbsp;</td>
          <td width="28%" class="fieldname">Others</td>
          <td width="44%" class="fieldname" colspan="3">
			<html:text property="otherPurpose" style="width:180"/>
          </td>
        </tr>
        
      </table>
    </td>
    <td width="15%" height="158"></td>
  </tr>
  <tr>
    <td width="13%" height="21"></td>
    <td width="72%" height="21" colspan="5"></td>
    <td width="15%" height="21"></td>
  </tr>
  <tr>
    <td width="13%" height="21"></td>
    <td width="72%" height="21" colspan="5" class="subtitle">TO BE FILLED BY THE DRIVER</td>
    <td width="15%" height="21"></td>
  </tr>
  <tr>
    <td width="13%" height="21"></td>
    <td width="15%" height="21" colspan="2"></td>
    <td width="57%" height="21" colspan="3"></td>
    <td width="15%" height="21"></td>
  </tr>
  <tr>
    <td width="13%" height="21"></td>
    <td width="72%" height="21" colspan="5">
      <table border="2" width="98%" cellspacing="3" cellpadding="3">
        <tr>
          <td width="25%" class="fieldname">Driver Name</td>
          <td width="25%" class="fieldname">
          <html:text property="driverName" style="width:113" readonly="true"/></td>
          <td width="25%" class="fieldname">Requested Driver Name</td>
          <td width="20%" class="fieldname">
          <html:text property="requestedDriverName" style="width:113"/></td>
        </tr>
        <tr>
          <td width="25%" class="fieldname">Present KM</td>
          <td width="25%" class="fieldname"><html:text property="presentKm" style="width:113" onblur="javascript:selectDifference()"/></td>
          <td width="25%" class="fieldname">Difference KM</td>
          <td width="20%" class="fieldname"><html:text property="differenceKm" style="width:113" readonly="true"/></td>
        </tr>
        <tr>
          <td width="25%" class="fieldname">Last Filling KM</td>
          <td width="25%" class="fieldname"><b><html:text property="lastFillingKm" style="width:113"/></b></td>
          <td width="25%" class="fieldname">Average KM</td>
          <td width="20%" class="fieldname"><html:text property="averageKm" style="width:113" readonly="true"/></td>
        </tr>
        <tr>
          <td width="25%" class="fieldname">&nbsp;</td>
          <td width="25%" class="fieldname">Remarks</td>
          <td width="25%" class="fieldname">
			<html:text property="remark" style="width:113"/></td>
          <td width="20%" class="fieldname">&nbsp;</td>
        </tr>
        
      </table>
    </td>
    <td width="15%" height="21"></td>
  </tr>
  <tr>
    <td width="13%" height="21">&nbsp;</td>
    <td width="15%" height="21" colspan="2">&nbsp;</td>
    <td width="57%" height="21" colspan="3">&nbsp;</td>
    <td width="15%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="13%" height="21"></td>
    <td width="15%" height="21" colspan="2" class="fieldname"><b>&nbsp;STOCK DETAILS</b></td>
    <td width="57%" height="21" colspan="3"></td>
    <td width="15%" height="21"></td>
  </tr>
  <tr>
    <td width="13%" height="21"></td>
    <td width="72%" height="21" colspan="5">
	<table border="1" width="98%" id="table4">
		<tr>
			<td width="172">&nbsp;</td>
			<td width="168" class="fieldname">Stock</td>
			<td width="178" class="fieldname"><b><html:text property="stock" style="width:113" readonly="true"/></b></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td width="172" class="fieldname">Opening Reading</td>
			<td width="168" class="fieldname"><b><html:text property="openingReading" style="width:113" readonly="true"/></b></td>
			<td width="178" class="fieldname">Closing Reading</td>
			<td class="fieldname"><b><html:text property="closingReading" style="width:113" readonly="true"/></b></td>
		</tr>
		<tr>
			<td width="172" class="fieldname">Consumption liters</td>
			<td width="168" class="fieldname"><b><html:text property="consumptionLitres" style="width:113" readonly="true"/></b></td>
			<td width="178" class="fieldname">Balance </td>
			<td class="fieldname"><b><html:text property="balance" style="width:113" readonly="true"/></b></td>
		</tr>
		</table>
	</td>
    <td width="15%" height="21"></td>
  </tr>
  <tr>
    <td width="13%" height="21">&nbsp;</td>
    <td width="15%" height="21" colspan="2">
      &nbsp;</td>
    <td width="19%" height="21">
      &nbsp;</td>
    <td width="18%" height="21">&nbsp;</td>
    <td width="20%" height="21">&nbsp;</td>
    <td width="15%" height="21">&nbsp;</td>
  </tr>
  <tr>
  <html:errors/>
    <td width="100%" height="21" colspan="7">
      <p align="center">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="javascript:submitdone()">
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18" onclick="javascript:issuedone()">
        <img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18" onclick="javascript:approvedone()">
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18" onclick="javascript:okdone()"></td>
  </tr>
</table>
<p align="center">&nbsp;</p>
</html:form>
			
			
</body>
</html:html>