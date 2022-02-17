<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/paint.do";
%>

<html:html>
	<head>
		<title>Paint Form</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=okMethod";	
		document.forms[0].submit();
	}
		function quantityupdate1()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=qtyUpdateMethod1";	
		document.forms[0].submit();
	}
	function quantityupdate2()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=qtyUpdateMethod2";	
		document.forms[0].submit();
	}
	function quantityupdate3()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=qtyUpdateMethod3";	
		document.forms[0].submit();
	}
	function quantityupdate4()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=qtyUpdateMethod4";	
		document.forms[0].submit();
	}
		function quantityupdate5()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=qtyUpdateMethod5";	
		document.forms[0].submit();
	}
	function quantityupdate6()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=qtyUpdateMethod6";	
		document.forms[0].submit();
	}
	function quantityupdate7()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=qtyUpdateMethod7";	
		document.forms[0].submit();
	}
	function quantityupdate8()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=qtyUpdateMethod8";	
		document.forms[0].submit();
	}
	function quantityupdate9()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=qtyUpdateMethod9";	
		document.forms[0].submit();
	}
	function quantityupdate10()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=qtyUpdateMethod10";	
		document.forms[0].submit();
	}
	function listvehicletype()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listVehicleMethod";	
		document.forms[0].submit();
	}
	function listvehiclenumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listVehicleNumberMethod";	
		document.forms[0].submit();
	}
	function listColor1()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listColorMethod1";	
		document.forms[0].submit();
	}
	function listColor2()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listColorMethod2";	
		document.forms[0].submit();
	}
	function listColor3()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listColorMethod3";	
		document.forms[0].submit();
	}
	function listColor4()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listColorMethod4";	
		document.forms[0].submit();
	}
	function listColor5()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listColorMethod5";	
		document.forms[0].submit();
	}
	function listColor6()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listColorMethod6";	
		document.forms[0].submit();
	}
	function listColor7()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listColorMethod7";	
		document.forms[0].submit();
	}
	function listColor8()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listColorMethod8";	
		document.forms[0].submit();
	}
	function listColor9()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listColorMethod9";	
		document.forms[0].submit();
	}
	function listColor10()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listColorMethod10";	
		document.forms[0].submit();
	}
	function listrates1()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listRates1Method";	
		document.forms[0].submit();
	}
	function listrates2()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listRates2Method";	
		document.forms[0].submit();
	}
	function listrates3()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listRates3Method";	
		document.forms[0].submit();
	}
	function listrates4()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listRates4Method";	
		document.forms[0].submit();
	}
	function listrates5()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listRates5Method";	
		document.forms[0].submit();
	}
	function listrates6()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listRates6Method";	
		document.forms[0].submit();
	}
	function listrates7()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listRates7Method";	
		document.forms[0].submit();
	}
	function listrates8()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listRates8Method";	
		document.forms[0].submit();
	}
	function listrates9()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listRates9Method";	
		document.forms[0].submit();
	}
	function listrates10()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paint.do?invoke=listRates10Method";	
		document.forms[0].submit();
	}
</script>

<body> 
<html:form action="paint" enctype="multipart/form-data">

<table border="0" width="97%" cellspacing="7" cellpadding="7" height="637">
<tr>
    <td width="25%" colspan="3" height="55"></td>
     <td width="15%" colspan="3" height="55"></td>
    <td width="9%" colspan="2" height="55" align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/paint.jpg" width="40" height="40"></td>
    <td width="63%" colspan="9" height="55" class="maintitle">PAINT FORM</td>
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
    <html:select property="institutionName" style="width:150" onchange="javascript:listvehicletype()">
							<logic:present property="instList" name="PaintForm">	
								<bean:define id="instList" name="PaintForm" property="instList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Institution--</html:option>
								<html:options collection="instList" property="instid" labelProperty="instdesc"></html:options>
							</logic:present>
						</html:select></td>
                        
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21" class="fieldname">Vehicle Type</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2"><html:select property="vehicleType" style="width:150" onchange="javascript:listvehiclenumber()">
							<logic:present property="vehicleTypeList" name="PaintForm">	
								<bean:define id="vehicleTypeList" name="PaintForm" property="vehicleTypeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Institution--</html:option>
								<html:options collection="vehicleTypeList" property="vehicletypeid" labelProperty="vehicletypedesc"></html:options>
							</logic:present>
						</html:select>
                       </td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  
    
   
  <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21" class="fieldname">Date</td>
    <td width="19%" height="21" colspan="5" class="fieldname">
	<html:text property="requestedDate" style="width:113"/>
	<a href="#" onClick="showCalendar(this,document.PaintForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.PaintForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21" class="fieldname">Vehicle Number</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2">
      <html:select property="vehicleNumber" style="width:150">
							<logic:present property="vehicleNumberList" name="PaintForm">	
								<bean:define id="vehicleNumberList" name="PaintForm" property="vehicleNumberList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose number--</html:option>
								<html:options collection="vehicleNumberList" property="vehiclenumberid" labelProperty="vehiclenumberdesc"></html:options>
							</logic:present>
						</html:select>
	</td>
    <td width="4%" height="21">&nbsp;</td>
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
    <td width="19%" height="21" class="fieldname">Requested Driver Name</td>
    <td width="19%" height="21" colspan="5" class="fieldname">
	<html:text property="requestedDriverName" style="width:113"/></td>
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21">Other Purpose</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2">
    <html:text property="otherPurpose" style="width:113"/>
	</td>
    <td width="4%" height="21"></td>
  </tr>
  <tr></tr>
  <tr></tr>
  <tr></tr>
  <tr></tr>  
    
    <tr>
    <td width="96%" height="227" colspan="22" align="center">
      <table border="1" width="86%">
      	
        <tr>
          <td width="5%" align="center" class="fieldname" rowspan="2">S.No</td>
          <td width="19%" align="center" class="fieldname" rowspan="2">Paint Type</td>
          <td width="21%" align="center" class="fieldname" rowspan="2">Paint Color</td>
          <td width="8%" align="center" rowspan="2" class="fieldname">Quantity Wanted</td>
          <td width="8%" align="center" rowspan="2" class="fieldname">Total Available Quantity</td>
          <td width="12%" colspan="2" align="center" class="fieldname">Issuing Quantity</td>
          <td width="9%" colspan="2" align="center" class="fieldname">Unit Rate</td>
          <td width="7%" rowspan="2" align="center" class="fieldname">Amount</td>
        </tr>
        <tr>
          <td width="7%" align="center" class="fieldname">Old</td>
          <td width="4%" align="center" class="fieldname">New</td>
          <td width="5%" align="center" class="fieldname">Old</td>
          <td width="4%" align="center" class="fieldname">New</td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">1.</td>
          <td width="19%" align="center">
          <html:select property="paintType1" style="width:150" onchange="javascript:listColor1()">
							<logic:present property="compList" name="PaintForm">	
								<bean:define id="compList" name="PaintForm" property="compList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Company Name--</html:option>
								<html:options collection="compList" property="paintId" labelProperty="paintType"></html:options>
							</logic:present>
						</html:select>
			
		  </td>
          <td width="21%" align="center">
					<html:select property="paintColor1" style="width:150" onchange="javascript:listrates1()">
							<logic:present property="colorList1" name="PaintForm">	
								<bean:define id="colorList1" name="PaintForm" property="colorList1" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Color--</html:option>
								<html:options collection="colorList1" property="paintId" labelProperty="paintColor"></html:options>
							</logic:present>
						</html:select>
		  </td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity1" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity1" style="width:60" onclick="javascript:quantityupdate1()"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable1" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable1" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate1" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate1" style="width:50"/></td>
          <td width="7%"><html:text property="totalAmount1" style="width:70"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">2.</td>
          <td width="19%" align="center">
				 <html:select property="paintType2" style="width:150" onchange="javascript:listColor2()">
							<logic:present property="compList" name="PaintForm">	
								<bean:define id="compList" name="PaintForm" property="compList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Company Name--</html:option>
								<html:options collection="compList" property="paintId" labelProperty="paintType"></html:options>
							</logic:present>
						</html:select>
		  </td>
          <td width="21%" align="center">
					<html:select property="paintColor2" style="width:150" onchange="javascript:listrates2()">
							<logic:present property="colorList2" name="PaintForm">	
								<bean:define id="colorList2" name="PaintForm" property="colorList2" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Color--</html:option>
								<html:options collection="colorList2" property="paintId" labelProperty="paintColor"></html:options>
							</logic:present>
						</html:select>
		  </td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity2" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity2" style="width:60" onclick="javascript:quantityupdate2()"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable2" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable2" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate2" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate2" style="width:50"/></td>
          <td width="7%"><html:text property="totalAmount2" style="width:70"/></td>
        </tr>
        
              <tr>
          <td width="5%" align="center" class="fieldname">3.</td>
          <td width="19%" align="center">
			 <html:select property="paintType3" style="width:150" onchange="javascript:listColor3()">
							<logic:present property="compList" name="PaintForm">	
								<bean:define id="compList" name="PaintForm" property="compList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Company Name--</html:option>
								<html:options collection="compList" property="paintId" labelProperty="paintType"></html:options>
							</logic:present>
						</html:select>
		  </td>
          <td width="21%" align="center">
					<html:select property="paintColor3" style="width:150" onchange="javascript:listrates3()">
							<logic:present property="colorList3" name="PaintForm">	
								<bean:define id="colorList3" name="PaintForm" property="colorList3" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Color--</html:option>
								<html:options collection="colorList3" property="paintId" labelProperty="paintColor"></html:options>
							</logic:present>
						</html:select>
	</td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity3" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity3" style="width:60" onclick="javascript:quantityupdate3()"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable3" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable3" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate3" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate3" style="width:50"/></td>
          <td width="7%"><html:text property="totalAmount3" style="width:70"/></td>
        </tr>
              <tr>
          <td width="5%" align="center" class="fieldname">4.</td>
          <td width="19%" align="center">
			 <html:select property="paintType4" style="width:150" onchange="javascript:listColor4()">
							<logic:present property="compList" name="PaintForm">	
								<bean:define id="compList" name="PaintForm" property="compList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Company Name--</html:option>
								<html:options collection="compList" property="paintId" labelProperty="paintType"></html:options>
							</logic:present>
						</html:select>
	</td>
          <td width="21%" align="center">
<html:select property="paintColor4" style="width:150" onchange="javascript:listrates4()">
							<logic:present property="colorList4" name="PaintForm">	
								<bean:define id="colorList4" name="PaintForm" property="colorList4" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Color--</html:option>
								<html:options collection="colorList4" property="paintId" labelProperty="paintColor"></html:options>
							</logic:present>
						</html:select>
	</td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity4" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity4" style="width:60" onclick="javascript:quantityupdate4()"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable4" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable4" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate4" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate4" style="width:50"/></td>
          <td width="7%"><html:text property="totalAmount4" style="width:70"/></td>
        </tr>
              <tr>
          <td width="5%" align="center" class="fieldname">5.</td>
          <td width="19%" align="center">
				 <html:select property="paintType5" style="width:150" onchange="javascript:listColor5()">
							<logic:present property="compList" name="PaintForm">	
								<bean:define id="compList" name="PaintForm" property="compList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Company Name--</html:option>
								<html:options collection="compList" property="paintId" labelProperty="paintType"></html:options>
							</logic:present>
						</html:select>
	</td>
          <td width="21%" align="center">
					<html:select property="paintColor5" style="width:150" onchange="javascript:listrates5()">
							<logic:present property="colorList5" name="PaintForm">	
								<bean:define id="colorList5" name="PaintForm" property="colorList5" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Color--</html:option>
								<html:options collection="colorList5" property="paintId" labelProperty="paintColor"></html:options>
							</logic:present>
						</html:select>
	</td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity5" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity5" style="width:60" onclick="javascript:quantityupdate5()"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable5" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable5" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate5" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate5" style="width:50"/></td>
          <td width="7%" align="center"><html:text property="totalAmount5" style="width:70"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">6.</td>
          <td width="19%" align="center">
			 <html:select property="paintType6" style="width:150" onchange="javascript:listColor6()">
							<logic:present property="compList" name="PaintForm">	
								<bean:define id="compList" name="PaintForm" property="compList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Company Name--</html:option>
								<html:options collection="compList" property="paintId" labelProperty="paintType"></html:options>
							</logic:present>
						</html:select>
		  </td>
          <td width="21%" align="center">
					<html:select property="paintColor6" style="width:150" onchange="javascript:listrates6()">
							<logic:present property="colorList6" name="PaintForm">	
								<bean:define id="colorList6" name="PaintForm" property="colorList6" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Color--</html:option>
								<html:options collection="colorList6" property="paintId" labelProperty="paintColor"></html:options>
							</logic:present>
						</html:select>
		  </td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity6" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity6" style="width:60" onclick="javascript:quantityupdate6()"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable6" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable6" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate6" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate6" style="width:50"/></td>
          <td width="7%"><html:text property="totalAmount6" style="width:70"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">7.</td>
          <td width="19%" align="center">
				 <html:select property="paintType7" style="width:150" onchange="javascript:listColor7()">
							<logic:present property="compList" name="PaintForm">	
								<bean:define id="compList" name="PaintForm" property="compList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Company Name--</html:option>
								<html:options collection="compList" property="paintId" labelProperty="paintType"></html:options>
							</logic:present>
						</html:select>
		  </td>
          <td width="21%" align="center">
					<html:select property="paintColor7" style="width:150" onchange="javascript:listrates7()">
							<logic:present property="colorList7" name="PaintForm">	
								<bean:define id="colorList7" name="PaintForm" property="colorList7" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Color--</html:option>
								<html:options collection="colorList7" property="paintId" labelProperty="paintColor"></html:options>
							</logic:present>
						</html:select>
		  </td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity7" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity7" style="width:60" onclick="javascript:quantityupdate7()"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable7" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable7" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate7" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate7" style="width:50"/></td>
          <td width="7%"><html:text property="totalAmount7" style="width:70"/></td>
        </tr>
        
              <tr>
          <td width="5%" align="center" class="fieldname">8.</td>
          <td width="19%" align="center">
			 <html:select property="paintType8" style="width:150" onchange="javascript:listColor8()">
							<logic:present property="compList" name="PaintForm">	
								<bean:define id="compList" name="PaintForm" property="compList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Company Name--</html:option>
								<html:options collection="compList" property="paintId" labelProperty="paintType"></html:options>
							</logic:present>
						</html:select>
		  </td>
          <td width="21%" align="center">
					<html:select property="paintColor8" style="width:150" onchange="javascript:listrates8()">
							<logic:present property="colorList8" name="PaintForm">	
								<bean:define id="colorList8" name="PaintForm" property="colorList8" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Color--</html:option>
								<html:options collection="colorList8" property="paintId" labelProperty="paintColor"></html:options>
							</logic:present>
						</html:select>
	</td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity8" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity8" style="width:60" onclick="javascript:quantityupdate8()"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable8" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable8" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate8" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate8" style="width:50"/></td>
          <td width="7%"><html:text property="totalAmount8" style="width:70"/></td>
        </tr>
              <tr>
          <td width="5%" align="center" class="fieldname">9.</td>
          <td width="19%" align="center">
			 <html:select property="paintType9" style="width:150" onchange="javascript:listColor9()">
							<logic:present property="compList" name="PaintForm">	
								<bean:define id="compList" name="PaintForm" property="compList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Company Name--</html:option>
								<html:options collection="compList" property="paintId" labelProperty="paintType"></html:options>
							</logic:present>
						</html:select>
	</td>
          <td width="21%" align="center">
<html:select property="paintColor9" style="width:150" onchange="javascript:listrates9()">
							<logic:present property="colorList9" name="PaintForm">	
								<bean:define id="colorList9" name="PaintForm" property="colorList9" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Color--</html:option>
								<html:options collection="colorList9" property="paintId" labelProperty="paintColor"></html:options>
							</logic:present>
						</html:select>
	</td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity9" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity9" style="width:60" onclick="javascript:quantityupdate9()"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable9" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable9" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate9" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate9" style="width:50"/></td>
          <td width="7%"><html:text property="totalAmount9" style="width:70"/></td>
        </tr>
              <tr>
          <td width="5%" align="center" class="fieldname">10.</td>
          <td width="19%" align="center">
				 <html:select property="paintType10" style="width:150" onchange="javascript:listColor10()">
							<logic:present property="compList" name="PaintForm">	
								<bean:define id="compList" name="PaintForm" property="compList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Company Name--</html:option>
								<html:options collection="compList" property="paintId" labelProperty="paintType"></html:options>
							</logic:present>
						</html:select>
	</td>
          <td width="21%" align="center">
           <html:select property="paintColor10" style="width:150" onchange="javascript:listrates10()">
							<logic:present property="colorList10" name="PaintForm">	
								<bean:define id="colorList10" name="PaintForm" property="colorList10" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Color--</html:option>
								<html:options collection="colorList10" property="paintId" labelProperty="paintColor"></html:options>
							</logic:present>
						</html:select>
					
	</td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity10" style="width:60"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity10" style="width:60" onclick="javascript:quantityupdate10()"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable10" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable10" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate10" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate10" style="width:50"/></td>
          <td width="7%" align="center"><html:text property="totalAmount10" style="width:70"/></td>
        </tr>
</table>

  <tr>
    <td width="96%" height="52" colspan="22">
      <p align="center">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="javascript:submitdone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18" onclick="javascript:issuedone()">
        <img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18" onclick="javascript:approvedone()">
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18" onclick="javascript:okdone()"></td>
     </tr>


</html:form>
			
			
</body>
</html:html>