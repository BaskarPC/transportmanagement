<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/general.do";
%>

<html:html>
	<head>
		<title>General Note</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	function selectInstName()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=instMethod";	
		document.forms[0].submit();
	}
	function selectVehicleType()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=vehicleMethod";	
		document.forms[0].submit();
	}
	function selectVehicleNumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=driverMethod";	
		document.forms[0].submit();
	}
	function selectQuantity1()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=quantityMethod1";	
		document.forms[0].submit();
	}
		function selectQuantity2()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=quantityMethod2";	
		document.forms[0].submit();
	}
		function selectQuantity3()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=quantityMethod3";	
		document.forms[0].submit();
	}
		function selectQuantity4()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=quantityMethod4";	
		document.forms[0].submit();
	}
		function selectQuantity5()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=quantityMethod5";	
		document.forms[0].submit();
	}
	function selectQuantity6()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=quantityMethod6";	
		document.forms[0].submit();
	}
		function selectQuantity7()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=quantityMethod7";	
		document.forms[0].submit();
	}
		function selectQuantity8()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=quantityMethod8";	
		document.forms[0].submit();
	}
		function selectQuantity9()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=quantityMethod9";	
		document.forms[0].submit();
	}
		function selectQuantity10()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=quantityMethod10";	
		document.forms[0].submit();
	}
</script>

<body> 
<html:form action="general" enctype="multipart/form-data">

<table border="0" width="97%" cellspacing="7" cellpadding="7" height="637">
<tr>
    <td width="25%" colspan="3" height="55"></td>
    <td width="15%" colspan="2" height="55"></td>
    <td width="9%" colspan="2" height="55" align="right">
     	<img border="0" src="<%=request.getContextPath()%>/images/general note.jpg"></td>
    <td width="63%" colspan="6" height="55" class="maintitle">GENERAL NOTE</td>
  </tr>

   <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21">&nbsp;</td>
    <td width="19%" height="21" colspan="4">&nbsp;</td>
    <td width="7%" height="21" colspan="2">&nbsp;</td>
    <td width="18%" height="21" colspan="2">&nbsp;</td>
    <td width="12%" height="21" colspan="2">&nbsp;</td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>

   <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21" class="fieldname">Institution</td>
    <td width="19%" height="21" colspan="4">
   	<html:select property="institutionName" style="width:150" onchange="javascript:selectInstName()">
		<html:option value="0">--Choose an Institution--</html:option>
				<logic:present property="instList" name="GeneralNoteForm">	
				<bean:define id="instList" name="GeneralNoteForm" property="instList" type="java.util.Collection" ></bean:define>
				<html:options collection="instList" property="instId" labelProperty="instDesc"></html:options>
				</logic:present>
		</html:select>	</td>
                        
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21" class="fieldname">Vehicle Type</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2">
    		<html:select property="vehicleType" onchange="javascript:selectVehicleType()">
                   <html:option value="0">--Choose Vehicle Type--</html:option>
							<logic:present property="typeList" name="GeneralNoteForm">	
								<bean:define id="typeList" name="GeneralNoteForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:options collection="typeList" property="typeId" labelProperty="typeDesc"></html:options>
							</logic:present>                                                              
            </html:select>
                       </td>
    <td width="4%" height="21"></td>
  </tr>
  
    
   
  <tr>
    <td width="7%" height="21"></td>
    <td width="13%" height="21" class="fieldname"></td>
    <td width="19%" height="21" colspan="4" class="fieldname">
    </td>
    <td width="2%" height="21"></td>
    <td width="7%" height="21"></td>
    <td width="12%" height="21" class="fieldname"></td>
    <td width="5%" height="21"></td>
    <td width="11%" height="21" colspan="2">
	</td>
    <td width="4%" height="21"></td>
  </tr>
  
    
   
  <tr>
    <td width="7%" height="21"></td>
    <td width="13%" height="21" class="fieldname">Date</td>
    <td width="19%" height="21" colspan="4" class="fieldname">
	<html:text property="requestedDate" style="width:113"/>
	<a href="#" onClick="showCalendar(this,document.GeneralForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.GeneralForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21" class="fieldname">Bill Number</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2">
    	<html:text property="billNumber" style="width:113"/>	
	</td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  
  <tr>
    <td width="34%" height="21" colspan="4"></td>
    <td width="32%" height="21" colspan="7"></td>
    <td width="17%" height="21" colspan="2"></td>
  </tr>
  
   <tr/>
   <tr/>
   <tr/>
   <tr/>
   
    <tr>
    <td width="96%" height="227" colspan="13" align="center">
      <table border="1" width="85%" height="121">
        <tr>
          <td width="5%" align="center" class="fieldname" height="38">S.No</td>
          <td width="19%" align="center" class="fieldname" height="38">Vehicle Number</td>
          <td width="19%" align="center" class="fieldname" height="38">Item Description</td>
          <td width="11%" align="center" class="fieldname" height="38">Available Quantity</td>
          <td width="11%" align="center" class="fieldname" height="38">Quantity Wanted</td>
          <td width="12%" align="center" class="fieldname" height="38">Unit Rate</td>
          <td width="15%" align="center" class="fieldname" height="38">Amount</td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname" height="19">1.</td>
          <td width="19%" align="center" height="19"><html:select property="vehicleNumber1" onchange="javascript:selectVehicleNumber()" style="width:100">
                 <html:option value="0"> - - Choose --</html:option>
                    <logic:present property="vehicleList" name="GeneralNoteForm">	
						<bean:define id="vehicleList" name="GeneralNoteForm" property="vehicleList" type="java.util.Collection" ></bean:define>
						<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
					</logic:present>                                                                  
            </html:select>
		  </td>
          <td width="19%" align="center" height="19">
			<html:select property="itemDescription1" size="1">
                            <html:option value="0"> - -Choose a Type- -</html:option>
                            <logic:present property="generalNoteList" name="GeneralNoteForm">	
								<bean:define id="generalNoteList" name="GeneralNoteForm" property="generalNoteList" type="java.util.Collection" ></bean:define>
								<html:options collection="generalNoteList" property="generalNoteId" labelProperty="generalNoteDesc"></html:options>
							</logic:present>                                                   
            </html:select>
		  </td>
          <td width="1%" align="center" height="19"><html:text property="totalAvailableQuantity1" style="width:60" onblur="javascript:selectQuantity1()"/></td>
          <td width="11%" align="center" height="19"><html:text property="wantedQuantity1" style="width:60"/></td>
          <td width="11%" align="center" height="19"><html:text property="totalAmount1" style="width:50"/></td>
          <td width="7%" align="center" height="19"><html:text property="remainingQuantity1" style="width:40"/></td>
        </tr>
             <tr>
          <td width="5%" align="center" class="fieldname" height="19">2.</td>
          <td width="19%" align="center" height="19">
          <html:select property="vehicleNumber2" onchange="javascript:selectVehicleNumber()" style="width:100">
                 <html:option value="0"> - - Choose --</html:option>
                    <logic:present property="vehicleList" name="GeneralNoteForm">	
						<bean:define id="vehicleList" name="GeneralNoteForm" property="vehicleList" type="java.util.Collection" ></bean:define>
						<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
					</logic:present>                                                                  
            </html:select>
		  </td>
          <td width="19%" align="center" height="19">
			<html:select property="itemDescription2" size="1">
                            <html:option value="0"> - -Choose a Type- -</html:option>
                            <logic:present property="generalNoteList" name="GeneralNoteForm">	
								<bean:define id="generalNoteList" name="GeneralNoteForm" property="generalNoteList" type="java.util.Collection" ></bean:define>
								<html:options collection="generalNoteList" property="generalNoteId" labelProperty="generalNoteDesc"></html:options>
							</logic:present>                                                   
            </html:select>
		  </td>
          <td width="1%" align="center" height="19"><html:text property="totalAvailableQuantity2" style="width:60" onblur="javascript:selectQuantity2()"/></td>
          <td width="11%" align="center" height="19"><html:text property="wantedQuantity2" style="width:60"/></td>
          <td width="11%" align="center" height="19"><html:text property="totalAmount2" style="width:50"/></td>
          <td width="7%" align="center" height="19"><html:text property="remainingQuantity2" style="width:40"/></td>
        </tr>
            <tr>
          <td width="5%" align="center" class="fieldname" height="19">3.</td>
          <td width="19%" align="center" height="19">
          <html:select property="vehicleNumber3" onchange="javascript:selectVehicleNumber()" style="width:100">
                 <html:option value="0"> - - Choose --</html:option>
                    <logic:present property="vehicleList" name="GeneralNoteForm">	
						<bean:define id="vehicleList" name="GeneralNoteForm" property="vehicleList" type="java.util.Collection" ></bean:define>
						<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
					</logic:present>                                                                  
            </html:select>
		  </td>
          <td width="19%" align="center" height="19">
			<html:select property="itemDescription3" size="1">
                            <html:option value="0"> - -Choose a Type- -</html:option>
                            <logic:present property="generalNoteList" name="GeneralNoteForm">	
								<bean:define id="generalNoteList" name="GeneralNoteForm" property="generalNoteList" type="java.util.Collection" ></bean:define>
								<html:options collection="generalNoteList" property="generalNoteId" labelProperty="generalNoteDesc"></html:options>
							</logic:present>                                                  
            </html:select>
		  </td>
          <td width="1%" align="center" height="19"><html:text property="totalAvailableQuantity3" style="width:60" onblur="javascript:selectQuantity3()"/></td>
          <td width="11%" align="center" height="19"><html:text property="wantedQuantity3" style="width:60"/></td>
          <td width="11%" align="center" height="19"><html:text property="totalAmount3" style="width:50"/></td>
          <td width="7%" align="center" height="19"><html:text property="remainingQuantity3" style="width:40"/></td>
        </tr>
            <tr>
          <td width="5%" align="center" class="fieldname" height="19">4.</td>
          <td width="19%" align="center" height="19">
          <html:select property="vehicleNumber4" onchange="javascript:selectVehicleNumber()" style="width:100">
                 <html:option value="0"> - - Choose --</html:option>
                    <logic:present property="vehicleList" name="GeneralNoteForm">	
						<bean:define id="vehicleList" name="GeneralNoteForm" property="vehicleList" type="java.util.Collection" ></bean:define>
						<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
					</logic:present>                                                                  
            </html:select>
		  </td>
          <td width="19%" align="center" height="19">
			<html:select property="itemDescription4" size="1">
                            <html:option value="0"> - -Choose a Type- -</html:option>
                            <logic:present property="generalNoteList" name="GeneralNoteForm">	
								<bean:define id="generalNoteList" name="GeneralNoteForm" property="generalNoteList" type="java.util.Collection" ></bean:define>
								<html:options collection="generalNoteList" property="generalNoteId" labelProperty="generalNoteDesc"></html:options>
							</logic:present>                                                   
            </html:select>
		  </td>
          <td width="1%" align="center" height="19"><html:text property="totalAvailableQuantity4" style="width:60" onblur="javascript:selectQuantity4()"/></td>
          <td width="11%" align="center" height="19"><html:text property="wantedQuantity4" style="width:60"/></td>
          <td width="11%" align="center" height="19"><html:text property="totalAmount4" style="width:50"/></td>
          <td width="7%" align="center" height="19"><html:text property="remainingQuantity4" style="width:40"/></td>
        </tr>
            <tr>
          <td width="5%" align="center" class="fieldname" height="19">5.</td>
          <td width="19%" align="center" height="19">
          <html:select property="vehicleNumber5" onchange="javascript:selectVehicleNumber()" style="width:100">
                 <html:option value="0"> - - Choose --</html:option>
                    <logic:present property="vehicleList" name="GeneralNoteForm">	
						<bean:define id="vehicleList" name="GeneralNoteForm" property="vehicleList" type="java.util.Collection" ></bean:define>
						<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
					</logic:present>                                                                  
            </html:select>
		  </td>
          <td width="19%" align="center" height="19">
			<html:select property="itemDescription5" size="1">
                            <html:option value="0"> - -Choose a Type- -</html:option>
                            <logic:present property="generalNoteList" name="GeneralNoteForm">	
								<bean:define id="generalNoteList" name="GeneralNoteForm" property="generalNoteList" type="java.util.Collection" ></bean:define>
								<html:options collection="generalNoteList" property="generalNoteId" labelProperty="generalNoteDesc"></html:options>
							</logic:present>                                                    
            </html:select>
		  </td>
          <td width="1%" align="center" height="19"><html:text property="totalAvailableQuantity5" style="width:60" onblur="javascript:selectQuantity5()"/></td>
          <td width="11%" align="center" height="19"><html:text property="wantedQuantity5" style="width:60"/></td>
          <td width="11%" align="center" height="19"><html:text property="totalAmount5" style="width:50"/></td>
          <td width="7%" align="center" height="19"><html:text property="remainingQuantity5" style="width:40"/></td>
        </tr>
             <tr>
          <td width="5%" align="center" class="fieldname" height="1">6.</td>
          <td width="19%" align="center" height="1">
          <html:select property="vehicleNumber6" onchange="javascript:selectVehicleNumber()" style="width:100">
                 <html:option value="0"> - - Choose --</html:option>
                    <logic:present property="vehicleList" name="GeneralNoteForm">	
						<bean:define id="vehicleList" name="GeneralNoteForm" property="vehicleList" type="java.util.Collection" ></bean:define>
						<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
					</logic:present>                                                                  
            </html:select>
		  </td>
          <td width="19%" align="center" height="1">
			<html:select property="itemDescription6" size="1">
                            <html:option value="0"> - -Choose a Type- -</html:option>
                           <logic:present property="generalNoteList" name="GeneralNoteForm">	
								<bean:define id="generalNoteList" name="GeneralNoteForm" property="generalNoteList" type="java.util.Collection" ></bean:define>
								<html:options collection="generalNoteList" property="generalNoteId" labelProperty="generalNoteDesc"></html:options>
							</logic:present>                                                   
            </html:select>
		  </td>
          <td width="1%" align="center" height="1"><html:text property="totalAvailableQuantity6" style="width:60" onblur="javascript:selectQuantity6()"/></td>
          <td width="11%" align="center" height="1"><html:text property="wantedQuantity6" style="width:60"/></td>
          <td width="11%" align="center" height="1"><html:text property="totalAmount6" style="width:50"/></td>
          <td width="7%" align="center" height="1"><html:text property="remainingQuantity6" style="width:40"/></td>
        </tr>
            <tr>
          <td width="5%" align="center" class="fieldname" height="19">7.</td>
          <td width="19%" align="center" height="19">
          <html:select property="vehicleNumber7" onchange="javascript:selectVehicleNumber()" style="width:100">
                 <html:option value="0"> - - Choose --</html:option>
                    <logic:present property="vehicleList" name="GeneralNoteForm">	
						<bean:define id="vehicleList" name="GeneralNoteForm" property="vehicleList" type="java.util.Collection" ></bean:define>
						<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
					</logic:present>                                                                  
            </html:select>
		  </td>
          <td width="19%" align="center" height="19">
			<html:select property="itemDescription7" size="1">
                            <html:option value="0"> - -Choose a Type- -</html:option>
                            <logic:present property="generalNoteList" name="GeneralNoteForm">	
								<bean:define id="generalNoteList" name="GeneralNoteForm" property="generalNoteList" type="java.util.Collection" ></bean:define>
								<html:options collection="generalNoteList" property="generalNoteId" labelProperty="generalNoteDesc"></html:options>
							</logic:present>                                                 
            </html:select>
		  </td>
          <td width="1%" align="center" height="19"><html:text property="totalAvailableQuantity7" style="width:60" onblur="javascript:selectQuantity7()"/></td>
          <td width="11%" align="center" height="19"><html:text property="wantedQuantity7" style="width:60"/></td>
          <td width="11%" align="center" height="19"><html:text property="totalAmount7" style="width:50"/></td>
          <td width="7%" align="center" height="19"><html:text property="remainingQuantity7" style="width:40"/></td>
        </tr>
            <tr>
          <td width="5%" align="center" class="fieldname" height="19">8.</td>
          <td width="19%" align="center" height="19">
          <html:select property="vehicleNumber8" onchange="javascript:selectVehicleNumber()" style="width:100">
                 <html:option value="0"> - - Choose --</html:option>
                    <logic:present property="vehicleList" name="GeneralNoteForm">	
						<bean:define id="vehicleList" name="GeneralNoteForm" property="vehicleList" type="java.util.Collection" ></bean:define>
						<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
					</logic:present>                                                                  
            </html:select>
		  </td>
          <td width="19%" align="center" height="19">
			<html:select property="itemDescription8" size="1">
                            <html:option value="0"> - -Choose a Type- -</html:option>
                            <logic:present property="generalNoteList" name="GeneralNoteForm">	
								<bean:define id="generalNoteList" name="GeneralNoteForm" property="generalNoteList" type="java.util.Collection" ></bean:define>
								<html:options collection="generalNoteList" property="generalNoteId" labelProperty="generalNoteDesc"></html:options>
							</logic:present>                                                  
            </html:select>
		  </td>
          <td width="1%" align="center" height="19"><html:text property="totalAvailableQuantity8" style="width:60" onblur="javascript:selectQuantity8()"/></td>
          <td width="11%" align="center" height="19"><html:text property="wantedQuantity8" style="width:60"/></td>
          <td width="11%" align="center" height="19"><html:text property="totalAmount8" style="width:50"/></td>
          <td width="7%" align="center" height="19"><html:text property="remainingQuantity8" style="width:40"/></td>
        </tr>
            <tr>
          <td width="5%" align="center" class="fieldname" height="19">9.</td>
          <td width="19%" align="center" height="19">
          <html:select property="vehicleNumber9" onchange="javascript:selectVehicleNumber()" style="width:100">
                 <html:option value="0"> - - Choose --</html:option>
                    <logic:present property="vehicleList" name="GeneralNoteForm">	
						<bean:define id="vehicleList" name="GeneralNoteForm" property="vehicleList" type="java.util.Collection" ></bean:define>
						<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
					</logic:present>                                                                  
            </html:select>
		  </td>
          <td width="19%" align="center" height="19">
			<html:select property="itemDescription9" size="1">
                            <html:option value="0"> - -Choose a Type- -</html:option>
                            <logic:present property="generalNoteList" name="GeneralNoteForm">	
								<bean:define id="generalNoteList" name="GeneralNoteForm" property="generalNoteList" type="java.util.Collection" ></bean:define>
								<html:options collection="generalNoteList" property="generalNoteId" labelProperty="generalNoteDesc"></html:options>
							</logic:present>                                                   
            </html:select>
		  </td>
          <td width="1%" align="center" height="19"><html:text property="totalAvailableQuantity9" style="width:60" onblur="javascript:selectQuantity9()"/></td>
          <td width="11%" align="center" height="19"><html:text property="wantedQuantity9" style="width:60"/></td>
          <td width="11%" align="center" height="19"><html:text property="totalAmount9" style="width:50"/></td>
          <td width="7%" align="center" height="19"><html:text property="remainingQuantity9" style="width:40"/></td>
        </tr>
            <tr>
          <td width="5%" align="center" class="fieldname" height="19">10.</td>
          <td width="19%" align="center" height="19">
          <html:select property="vehicleNumber10" onchange="javascript:selectVehicleNumber()" style="width:100">
                 <html:option value="0"> - - Choose--</html:option>
                    <logic:present property="vehicleList" name="GeneralNoteForm">	
						<bean:define id="vehicleList" name="GeneralNoteForm" property="vehicleList" type="java.util.Collection" ></bean:define>
						<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
					</logic:present>                                                                  
            </html:select>
		  </td>
          <td width="19%" align="center" height="19">
			<html:select property="itemDescription10" size="1">
                            <html:option value="0"> - -Choose a Type- -</html:option>
                            <logic:present property="generalNoteList" name="GeneralNoteForm">	
								<bean:define id="generalNoteList" name="GeneralNoteForm" property="generalNoteList" type="java.util.Collection" ></bean:define>
								<html:options collection="generalNoteList" property="generalNoteId" labelProperty="generalNoteDesc"></html:options>
							</logic:present>                                                   
            </html:select>
		  </td>
          <td width="1%" align="center" height="19"><html:text property="totalAvailableQuantity10" style="width:60" onblur="javascript:selectQuantity10()"/></td>
          <td width="11%" align="center" height="19"><html:text property="wantedQuantity10" style="width:60"/></td>
          <td width="11%" align="center" height="19"><html:text property="totalAmount10" style="width:50"/></td>
          <td width="7%" align="center" height="19"><html:text property="remainingQuantity10" style="width:40"/></td>
        </tr>
        
</table>

  <tr>
    <td width="96%" height="52" colspan="13">
      <p align="center">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" onclick="javascript:cleardone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" onclick="javascript:submitdone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" onclick="javascript:approvedone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" onclick="javascript:issuedone()"></td>
     </tr>

</html:form>
</table>
</body>
</html:html>