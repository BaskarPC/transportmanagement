<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/issues.do";
%>
<html:html>
	<head>
		<title>issues</title>
	</head>
<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/sparevalidate.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	function selectInstName()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=instMethod";	
		document.forms[0].submit();
	}
	function selectVehicleType()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=vehicleMethod";	
		document.forms[0].submit();
	}
	function selectVehicleNumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=driverMethod";	
		document.forms[0].submit();
	}
	
	function listpartNumber1()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=partNumberMethod1";	
		document.forms[0].submit();
	}
	function listpartNumber2()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=partNumberMethod2";	
		document.forms[0].submit();
	}
	function listpartNumber3()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=partNumberMethod3";	
		document.forms[0].submit();
	}
	function listpartNumber4()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=partNumberMethod4";	
		document.forms[0].submit();
	}
	function listpartNumber5()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=partNumberMethod5";	
		document.forms[0].submit();
	}
	function listpartNumber6()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=partNumberMethod6";	
		document.forms[0].submit();
	}
	function listpartNumber7()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=partNumberMethod7";	
		document.forms[0].submit();
	}
	function listpartNumber8()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=partNumberMethod8";	
		document.forms[0].submit();
	}
	function listpartNumber9()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=partNumberMethod9";	
		document.forms[0].submit();
	}
	function listpartNumber10()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=partNumberMethod10";	
		document.forms[0].submit();
	}
	function quantityupdate1()
	{
	var availqty=document.forms[0].totalAvailableQuantity1.value;
		var wantedqty=document.forms[0].wantedQuantity1.value ;
		if(availqty<wantedqty)
		{
			var c=confirm("Please enter the minimum required quantity");
			if(c)
			{
				document.forms[0].wantedQuantity1.value="";
				document.forms[0].wantedQuantity1.focus();
			}	
		}
		else
		{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=qtyUpdateMethod1";	
		document.forms[0].submit();
		}
	}
	function quantityupdate2()
	{
	var availqty=document.forms[0].totalAvailableQuantity2.value;
		var wantedqty=document.forms[0].wantedQuantity2.value ;
		if(availqty<wantedqty)
		{
			var c=confirm("Please enter the minimum required quantity");
			if(c)
			{
				document.forms[0].wantedQuantity2.value="";
				document.forms[0].wantedQuantity2.focus();
			}	
		}
		else
		{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=qtyUpdateMethod2";	
		document.forms[0].submit();
		}
	}
	function quantityupdate3()
	{
	var availqty=document.forms[0].totalAvailableQuantity3.value;
		var wantedqty=document.forms[0].wantedQuantity3.value ;
		if(availqty<wantedqty)
		{
			var c=confirm("Please enter the minimum required quantity");
			if(c)
			{
				document.forms[0].wantedQuantity3.value="";
				document.forms[0].wantedQuantity3.focus();
			}	
		}
		else
		{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=qtyUpdateMethod3";	
		document.forms[0].submit();
		}
	}
	function quantityupdate4()
	{
	var availqty=document.forms[0].totalAvailableQuantity4.value;
		var wantedqty=document.forms[0].wantedQuantity4.value ;
		if(availqty<wantedqty)
		{
			var c=confirm("Please enter the minimum required quantity");
			if(c)
			{
				document.forms[0].wantedQuantity4.value="";
				document.forms[0].wantedQuantity4.focus();
			}	
		}
		else
		{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=qtyUpdateMethod4";	
		document.forms[0].submit();
		}
	}
	function quantityupdate5()
	{
		var availqty=document.forms[0].totalAvailableQuantity5.value;
		var wantedqty=document.forms[0].wantedQuantity5.value ;
		if(availqty<wantedqty)
		{
			var c=confirm("Please enter the minimum required quantity");
			if(c)
			{
				document.forms[0].wantedQuantity5.value="";
				document.forms[0].wantedQuantity5.focus();
			}	
		}
		else
		{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=qtyUpdateMethod5";	
		document.forms[0].submit();
		}
	}
	function quantityupdate6()
	{
			var availqty=document.forms[0].totalAvailableQuantity6.value;
		var wantedqty=document.forms[0].wantedQuantity6.value ;
		if(availqty<wantedqty)
		{
			var c=confirm("Please enter the minimum required quantity");
			if(c)
			{
				document.forms[0].wantedQuantity6.value="";
				document.forms[0].wantedQuantity6.focus();
			}	
		}
		else
		{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=qtyUpdateMethod6";	
		document.forms[0].submit();
		}
	}
	function quantityupdate7()
	{
		var availqty=document.forms[0].totalAvailableQuantity7.value;
		var wantedqty=document.forms[0].wantedQuantity7.value ;
		if(availqty<wantedqty)
		{
			var c=confirm("Please enter the minimum required quantity");
			if(c)
			{
				document.forms[0].wantedQuantity7.value="";
				document.forms[0].wantedQuantity7.focus();
			}	
		}
		else
		{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=qtyUpdateMethod7";	
		document.forms[0].submit();
		}
	}
	function quantityupdate8()
	{
	var availqty=document.forms[0].totalAvailableQuantity8.value;
		var wantedqty=document.forms[0].wantedQuantity8.value ;
		if(availqty<wantedqty)
		{
			var c=confirm("Please enter the minimum required quantity");
			if(c)
			{
				document.forms[0].wantedQuantity8.value="";
				document.forms[0].wantedQuantity8.focus();
			}	
		}
		else
		{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=qtyUpdateMethod8";	
		document.forms[0].submit();
		}
	}
	function quantityupdate9()
	{
		var availqty=document.forms[0].totalAvailableQuantity9.value;
		var wantedqty=document.forms[0].wantedQuantity9.value ;
		if(availqty<wantedqty)
		{
			var c=confirm("Please enter the minimum required quantity");
			if(c)
			{
				document.forms[0].wantedQuantity9.value="";
				document.forms[0].wantedQuantity9.focus();
			}	
		}
		else
		{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=qtyUpdateMethod9";	
		document.forms[0].submit();
		}
	}
	function quantityupdate10()
	{
	var availqty=document.forms[0].totalAvailableQuantity10.value;
		var wantedqty=document.forms[0].wantedQuantity10.value ;
		if(availqty<wantedqty)
		{
			var c=confirm("Please enter the minimum required quantity");
			if(c)
			{
				document.forms[0].wantedQuantity10.value="";
				document.forms[0].wantedQuantity10.focus();
			}	
		}
		else
		{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=qtyUpdateMethod10";	
		document.forms[0].submit();
		}
	}
	function listvehicletype()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=listVehicleMethod";	
		document.forms[0].submit();
	}
	function listvehiclenumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=listVehicleNumberMethod";	
		document.forms[0].submit();
	}
	function listrates1()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=listRates1Method";	
		document.forms[0].submit();
	}
	function listrates2()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=listRates2Method";	
		document.forms[0].submit();
	}
	function listrates3()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=listRates3Method";	
		document.forms[0].submit();
	}
	function listrates4()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=listRates4Method";	
		document.forms[0].submit();
	}
	function listrates5()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=listRates5Method";	
		document.forms[0].submit();
	}
	function listrates6()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=listRates6Method";	
		document.forms[0].submit();
	}
	function listrates7()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=listRates7Method";	
		document.forms[0].submit();
	}
	function listrates8()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=listRates8Method";	
		document.forms[0].submit();
	}
	function listrates9()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=listRates9Method";	
		document.forms[0].submit();
	}
	function listrates10()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=listRates10Method";	
		document.forms[0].submit();
	}
	function selectTotalAmount()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=totalAmountMethod";	
		document.forms[0].submit();
	}
</script>

<body> 
		<html:form action="spare" enctype="multipart/form-data">
			
			<table border="0" width="96%" cellspacing="7" cellpadding="7" height="205">
<tr>
    <td width="25%" colspan="3" height="55">
		</td>
    <td width="9%" colspan="2" height="55">
      	<p align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/spare.jpg" width="40" height="40"></td>
    <td width="63%" colspan="9" height="55" class="maintitle">SPARE PARTS REQUISITION FORM</td>
  </tr>

   <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21">&nbsp;</td>
    <td width="19%" height="21" colspan="5">&nbsp;</td>
    <td width="7%" height="21" colspan="2">&nbsp;</td>
    <td width="18%" height="21" colspan="2">&nbsp;</td>
    <td width="12%" height="21" colspan="2">&nbsp;</td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>

  <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21" class="fieldname">Institution</td>
    <td width="19%" height="21" colspan="5">
    <html:select property="institutionName" style="width:150" onchange="javascript:selectInstName()">
						<html:option value="0">--Choose an Institution--</html:option>
							<logic:present property="instList" name="SparePartsForm">	
								<bean:define id="instList" name="SparePartsForm" property="instList" type="java.util.Collection" ></bean:define>
								<html:options collection="instList" property="instId" labelProperty="instDesc"></html:options>
							</logic:present>
						</html:select>	 
	</td>
                        
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21" class="fieldname">Vehicle Number</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2">
    <html:select property="vehicleNumber" style="width:150" onchange="javascript:selectVehicleNumber()">
		<html:option value="0"> - - Choose a Vehicle Number --</html:option>
         <logic:present property="vehicleList" name="SparePartsForm">	
				<bean:define id="vehicleList" name="SparePartsForm" property="vehicleList" type="java.util.Collection" ></bean:define>
				<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
		</logic:present> 
	</html:select></td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  
    
   
  <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21" class="fieldname">Vehicle Type</td>
    <td width="19%" height="21" colspan="5" class="fieldname">
	<html:select property="vehicleType" style="width:150" onchange="javascript:selectVehicleType()">
		<html:option value="0">--Choose Vehicle Type--</html:option>
			<logic:present property="typeList" name="SparePartsForm">	
				<bean:define id="typeList" name="SparePartsForm" property="typeList" type="java.util.Collection" ></bean:define>
				<html:options collection="typeList" property="typeId" labelProperty="typeDesc"></html:options>
			</logic:present>  
	</html:select></td>
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21">Date</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2">
	<html:text property="requestedDate" style="width:113"/>
	<a href="#" onClick="showCalendar(this,document.SparePartsForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.SparePartsForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
			<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date"></td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="34%" height="21" colspan="4"></td>
    <td width="32%" height="21" colspan="8"></td>
    <td width="17%" height="21" colspan="2"></td>
  </tr>
  
  <tr>
    <td width="34%" height="21" colspan="4"></td>
    <td width="32%" height="21" colspan="8"></td>
    <td width="17%" height="21" colspan="2"></td>
  </tr>
 <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21" class="fieldname">Driver Name</td>
    <td width="19%" height="21" colspan="5" class="fieldname">
<html:text property="driverName" style="width:113"/></td>
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21">Bill Number</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2">
	<html:text property="billNumber" style="width:113"/></td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  
  <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21" class="fieldname">Requested Driver Name</td>
    <td width="19%" height="21" colspan="5" class="fieldname">
	<html:text property="requestedDriverName" style="width:113"/></td>
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21">Other Purpose</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2">
    <html:text property="otherPurpose" style="width:113"/>
	</td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  
 
  <tr>
    <td width="97%" height="21" colspan="14"></td>
  </tr>
  <tr>
    <td width="97%" height="21" colspan="14" align="center">
      <table border="1" width="86%">
        <tr>
          <td width="7%" align="center" class="fieldname" rowspan="2">S.No</td>
          <td width="17%" align="center" class="fieldname" rowspan="2">Item Description</td>
          <td width="17%" align="center" class="fieldname" rowspan="2">Sub Type</td>
          <td width="11%" align="center" rowspan="2">
            <p class="fieldname">Quantity Wanted</td>
            <td width="11%" align="center" rowspan="2">
            <p class="fieldname">Total Available Quantity</p></td>
          <td width="21%" colspan="2" align="center">
            <p class="fieldname">Available Quantity</p>
          </td>
          <td width="15%" colspan="2" align="center" class="fieldname">Unit 
			Rate</td>
          <td width="9%" rowspan="2" align="center" class="fieldname">Amount</td>
        </tr>
        <tr>
          <td width="12%" align="center">Old</td>
          <td width="8%" align="center">New</td>
          <td width="7%" align="center">Old</td>
          <td width="7%" align="center">New</td>
        </tr>
        <tr>
          <td width="1%" align="center" class="fieldname">1.</td>
          <td width="17%" align="center">
			   <html:select property="itemDescription1" style="width:150" onchange="javascript:listpartNumber1()">
							<logic:present property="itemTypeList" name="SparePartsForm">	
								<bean:define id="itemTypeList" name="SparePartsForm" property="itemTypeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose a Spare--</html:option>
								<html:options collection="itemTypeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select></td>
          <td width="17%" align="center">
			<html:select property="partNumber1" style="width:150" onchange="javascript:listrates1()">
							<logic:present property="partList1" name="SparePartsForm">	
								<bean:define id="partList1" name="SparePartsForm" property="partList1" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Part Number--</html:option>
								<html:options collection="partList1" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select></td>
          <td width="11%" align="center"><html:text property="wantedQuantity1" style="width:60" onblur="javascript:quantityupdate1()"/></td>
                    <td width="11%" align="center"><html:text property="totalAvailableQuantity1" style="width:60"/></td>
          <td width="12%" align="center"><html:text property="oldAvailable1" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="newAvailable1" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldRate1" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="newRate1" style="width:60"/></td>
          <td width="9%">
			<p align="center"><html:text property="totalAmount1" style="width:113"/></td>
        </tr>
        <tr>
          <td width="1%" align="center">2.</td>
          <td width="17%" align="center">
			<html:select property="itemDescription2" style="width:150" onchange="javascript:listpartNumber2()">
							<logic:present property="itemTypeList" name="SparePartsForm">	
								<bean:define id="itemTypeList" name="SparePartsForm" property="itemTypeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose a Spare--</html:option>
								<html:options collection="itemTypeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select></td>
          <td width="17%" align="center">
			<html:select property="partNumber2" style="width:150" onchange="javascript:listrates2()">
							<logic:present property="partList2" name="SparePartsForm">	
								<bean:define id="partList2" name="SparePartsForm" property="partList2" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Part Number--</html:option>
								<html:options collection="partList2" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select></td>
         <td width="11%" align="center"><html:text property="wantedQuantity2" style="width:60"/></td>
                   <td width="11%" align="center"><html:text property="totalAvailableQuantity2" style="width:60" onclick="javascript:quantityupdate2()"/></td>
          <td width="12%" align="center"><html:text property="oldAvailable2" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="newAvailable2" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldRate2" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="newRate2" style="width:60"/></td>
          <td width="9%">
			<p align="center"><html:text property="totalAmount2" style="width:113"/></td>
        </tr>
        <tr>
          <td width="1%" align="center">3.</td>
          <td width="17%" align="center">
			<html:select property="itemDescription3" style="width:150" onchange="javascript:listpartNumber3()">
							<logic:present property="itemTypeList" name="SparePartsForm">	
								<bean:define id="itemTypeList" name="SparePartsForm" property="itemTypeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose a Spare--</html:option>
								<html:options collection="itemTypeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select></td>
          <td width="17%" align="center">
			<html:select property="partNumber3" style="width:150" onchange="javascript:listrates3()">
							<logic:present property="partList3" name="SparePartsForm">	
								<bean:define id="partList3" name="SparePartsForm" property="partList3" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Part Number--</html:option>
								<html:options collection="partList3" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select></td>
         <td width="11%" align="center"><html:text property="wantedQuantity3" style="width:60"/></td>
          <td width="11%" align="center"><html:text property="totalAvailableQuantity3" style="width:60" onclick="javascript:quantityupdate3()"/></td>
          <td width="12%" align="center"><html:text property="oldAvailable3" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="newAvailable3" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldRate3" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="newRate3" style="width:60"/></td>
          <td width="9%">
			<p align="center"><html:text property="totalAmount3" style="width:113"/></td>
        </tr>
        <tr>
          <td width="1%" align="center">4.</td>
          <td width="17%" align="center"><html:select property="itemDescription4" style="width:150" onchange="javascript:listpartNumber4()">
							<logic:present property="itemTypeList" name="SparePartsForm">	
								<bean:define id="itemTypeList" name="SparePartsForm" property="itemTypeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose a Spare--</html:option>
								<html:options collection="itemTypeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select></td>
          <td width="17%" align="center">
			<html:select property="partNumber4" style="width:150" onchange="javascript:listrates4()">
							<logic:present property="partList4" name="SparePartsForm">	
								<bean:define id="partList4" name="SparePartsForm" property="partList4" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Part Number--</html:option>
								<html:options collection="partList4" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select></td>
          <td width="11%" align="center"><html:text property="wantedQuantity4" style="width:60"/></td>
                    <td width="11%" align="center"><html:text property="totalAvailableQuantity4" style="width:60" onclick="javascript:quantityupdate4()"/></td>
          <td width="12%" align="center"><html:text property="oldAvailable4" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="newAvailable4" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldRate4" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="newRate4" style="width:60"/></td>
          <td width="9%">
			<p align="center"><html:text property="totalAmount4" style="width:113"/></td>
        </tr>
        <tr>
          <td width="1%" align="center">5.</td>
          <td width="17%" align="center">
			<html:select property="itemDescription5" style="width:150" onchange="javascript:listpartNumber5()">
							<logic:present property="itemTypeList" name="SparePartsForm">	
								<bean:define id="itemTypeList" name="SparePartsForm" property="itemTypeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose a Spare--</html:option>
								<html:options collection="itemTypeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select></td>
          <td width="17%" align="center">
			<html:select property="partNumber5" style="width:150">
							<logic:present property="partList5" name="SparePartsForm">	
								<bean:define id="partList5" name="SparePartsForm" property="partList5" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Part Number--</html:option>
								<html:options collection="partList5" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select></td>
         <td width="11%" align="center"><html:text property="wantedQuantity5" style="width:60"/></td>
                   <td width="11%" align="center"><html:text property="totalAvailableQuantity5" style="width:60" onclick="javascript:quantityupdate5()"/></td>
          <td width="12%" align="center"><html:text property="oldAvailable5" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="newAvailable5" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldRate5" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="newRate5" style="width:60"/></td>
          <td width="9%">
			<p align="center"><html:text property="totalAmount5" style="width:113"/></td>
        </tr>
        <tr>
          <td width="1%" align="center">6.</td>
          <td width="17%" align="center">
			<html:select property="itemDescription6" style="width:150" onchange="javascript:listpartNumber6()">
							<logic:present property="itemTypeList" name="SparePartsForm">	
								<bean:define id="itemTypeList" name="SparePartsForm" property="itemTypeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose a Spare--</html:option>
								<html:options collection="itemTypeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select></td>
          <td width="17%" align="center">
			<html:select property="partNumber6" style="width:150">
							<logic:present property="partList6" name="SparePartsForm">	
								<bean:define id="partList6" name="SparePartsForm" property="partList6" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Part Number--</html:option>
								<html:options collection="partList6" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select></td>
          <td width="11%" align="center"><html:text property="wantedQuantity6" style="width:60"/></td>
                    <td width="11%" align="center"><html:text property="totalAvailableQuantity6" style="width:60" onclick="javascript:quantityupdate6()"/></td>
          <td width="12%" align="center"><html:text property="oldAvailable6" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="newAvailable6" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldRate6" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="newRate6" style="width:60"/></td>
          <td width="9%">
			<p align="center"><html:text property="totalAmount6" style="width:113"/></td>
        </tr>
        <tr>
          <td width="1%" align="center">7.</td>
          <td width="17%" align="center">
			<html:select property="itemDescription7" style="width:150" onchange="javascript:listpartNumber7()">
							<logic:present property="itemTypeList" name="SparePartsForm">	
								<bean:define id="itemTypeList" name="SparePartsForm" property="itemTypeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose a Spare--</html:option>
								<html:options collection="itemTypeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select></td>
          <td width="17%" align="center">
			<html:select property="partNumber7" style="width:150">
							<logic:present property="partList7" name="SparePartsForm">	
								<bean:define id="partList7" name="SparePartsForm" property="partList7" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Part Number--</html:option>
								<html:options collection="partList7" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select></td>
         <td width="11%" align="center"><html:text property="wantedQuantity7" style="width:60"/></td>
                   <td width="11%" align="center"><html:text property="totalAvailableQuantity7" style="width:60" onclick="javascript:quantityupdate7()"/></td>
          <td width="12%" align="center"><html:text property="oldAvailable7" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="newAvailable7" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldRate7" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="newRate7" style="width:60"/></td>
          <td width="9%">
			<p align="center"><html:text property="totalAmount7" style="width:113"/></td>
        </tr>
        <tr>
          <td width="1%" align="center">8.</td>
          <td width="17%" align="center">
			<html:select property="itemDescription8" style="width:150" onchange="javascript:listpartNumber8()">
							<logic:present property="itemTypeList" name="SparePartsForm">	
								<bean:define id="itemTypeList" name="SparePartsForm" property="itemTypeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose a Spare--</html:option>
								<html:options collection="itemTypeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select></td>
          <td width="17%" align="center">
			<html:select property="partNumber8" style="width:150">
							<logic:present property="partList8" name="SparePartsForm">	
								<bean:define id="partList8" name="SparePartsForm" property="partList8" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Part Number--</html:option>
								<html:options collection="partList8" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select></td>
          <td width="11%" align="center"><html:text property="wantedQuantity8" style="width:60"/></td>
                    <td width="11%" align="center"><html:text property="totalAvailableQuantity8" style="width:60" onclick="javascript:quantityupdate8()"/></td>
          <td width="12%" align="center"><html:text property="oldAvailable8" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="newAvailable8" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldRate8" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="newRate8" style="width:60"/></td>
          <td width="9%">
			<p align="center"><html:text property="totalAmount8" style="width:113"/></td>
        </tr>
        <tr>
          <td width="1%" align="center">9.</td>
          <td width="17%" align="center">
			<html:select property="itemDescription9" style="width:150" onchange="javascript:listpartNumber9()">
							<logic:present property="itemTypeList" name="SparePartsForm">	
								<bean:define id="itemTypeList" name="SparePartsForm" property="itemTypeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose a Spare--</html:option>
								<html:options collection="itemTypeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select></td>
          <td width="17%" align="center">
			<html:select property="partNumber9" style="width:150">
							<logic:present property="partList9" name="SparePartsForm">	
								<bean:define id="partList9" name="SparePartsForm" property="partList9" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Part Number--</html:option>
								<html:options collection="partList9" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select></td>
          <td width="11%" align="center"><html:text property="wantedQuantity9" style="width:60"/></td>
                    <td width="11%" align="center"><html:text property="totalAvailableQuantity9" style="width:60" onclick="javascript:quantityupdate9()"/></td>
          <td width="12%" align="center"><html:text property="oldAvailable9" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="newAvailable9" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldRate9" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="newRate9" style="width:60"/></td>
          <td width="9%">
			<p align="center"><html:text property="totalAmount9" style="width:113"/></td>
        </tr>
        <tr>
          <td width="1%" align="center">10.</td>
          <td width="17%" align="center">
			<html:select property="itemDescription10" style="width:150" onchange="javascript:listpartNumber10()">
							<logic:present property="itemTypeList" name="SparePartsForm">	
								<bean:define id="itemTypeList" name="SparePartsForm" property="itemTypeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose a Spare--</html:option>
								<html:options collection="itemTypeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select></td>
          <td width="17%" align="center">
			<html:select property="partNumber10" style="width:150">
							<logic:present property="partList10" name="SparePartsForm">	
								<bean:define id="partList10" name="SparePartsForm" property="partList10" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Part Number--</html:option>
								<html:options collection="partList10" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select></td>
         <td width="11%" align="center"><html:text property="wantedQuantity10" style="width:60"/></td>
                   <td width="11%" align="center"><html:text property="totalAvailableQuantity10" style="width:60" onclick="javascript:quantityupdate10()"/></td>
          <td width="12%" align="center"><html:text property="oldAvailable10" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="newAvailable10" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldRate10" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="newRate10" style="width:60"/></td>
          <td width="9%">
			<p align="center"><html:text property="totalAmount10" style="width:113"/></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td width="20%" height="21" colspan="2">
    </td>
    <td width="23%" height="21" colspan="8">
      <p align="right">
      Total Amount</p>
    </td>
    <td width="16%" height="21" colspan="2">
    	<html:text property="totalAmount" style="width:113" onclick="javascript:selectTotalAmount()"/>
    </td>
    <td width="17%" height="21" colspan="2">
    </td>
  </tr>
  <tr>
    <td width="20%" height="21" colspan="2">
      &nbsp;</td>
    <td width="23%" height="21" colspan="8">
      &nbsp;</td>
    <td width="16%" height="21" colspan="2">
      &nbsp;</td>
    <td width="17%" height="21" colspan="2">
      &nbsp;</td>
  </tr>
  <tr>
    <td width="20%" height="21" colspan="2">
      <p align="right">&nbsp;</td>
    <td width="12%" height="21" colspan="4">
      <p align="center" class="fieldname">Needed Spares</td>
    <td width="11%" height="21" colspan="4">
      <html:textarea property="neededSpares" style="width:150;height:100"/></td>
    <td width="16%" height="21" colspan="2">
      <p align="center">&nbsp;</td>
    <td width="17%" height="21" colspan="2">
      &nbsp;</td>
  </tr>
  <tr>
    <td width="76%" height="21" colspan="14">
      &nbsp;</td>
  </tr>
  
  <html:errors/>
  
  <tr>
    <td width="76%" height="21" colspan="14">
      <p align="center">
     	<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="javascript:submitdone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18" onclick="javascript:issuedone()">
        <img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18" onclick="javascript:approvedone()">
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18" onclick="javascript:okdone()"></td>
  </tr>
</table>
<p align="center">&nbsp;</p>
</html:form>
			
			
</body>
</html:html>