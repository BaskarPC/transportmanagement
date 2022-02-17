<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/oil.do";
%>

<html:html>
	<head>
		<title>Oil Form</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function cleardone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=clear";	
		document.forms[0].submit();
	}
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oilvalidate.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	function selectInstName()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=instMethod";	
		document.forms[0].submit();
	}
	function selectVehicleType()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=vehicleMethod";	
		document.forms[0].submit();
	}
	function selectVehicleNumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=driverMethod";	
		document.forms[0].submit();
	}
		function selectTypeMethod1()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=typeMethod1";	
		document.forms[0].submit();
	}
		function selectTypeMethod2()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=typeMethod2";	
		document.forms[0].submit();
	}
		function selectTypeMethod3()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=typeMethod3";	
		document.forms[0].submit();
	}
		function selectTypeMethod4()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=typeMethod4";	
		document.forms[0].submit();
	}
		function selectTypeMethod5()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=typeMethod5";	
		document.forms[0].submit();
	}
	function selectQuantity1()
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
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=quantityMethod1";	
		document.forms[0].submit();
		}
		
	}
		function selectQuantity2()
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
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=quantityMethod2";	
		document.forms[0].submit();
		}
	}
		function selectQuantity3()
	{
		var availqty=document.forms[0].totalAvailableQuantity3.value;
		var wantedqty=document.forms[0].wantedQuantity4.value ;
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
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=quantityMethod3";	
		document.forms[0].submit();
		}
	}
		function selectQuantity4()
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
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=quantityMethod4";	
		document.forms[0].submit();
		}
	}
		function selectQuantity5()
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
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=quantityMethod5";	
		document.forms[0].submit();
		}
	}
	
	function selectDifferenceKm()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=differenceKmMethod";	
		document.forms[0].submit();
	}
	function selectTotalAmount()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oil.do?invoke=totalAmountMethod";	
		document.forms[0].submit();
	}
</script>

<body> 
<html:form action="oil" enctype="multipart/form-data">

<table border="0" width="97%" cellspacing="7" cellpadding="7" height="593">
<tr>
    <td width="25%" colspan="3" height="55"></td>
     <td width="15%" colspan="2" height="55"></td>
    <td width="9%" colspan="2" height="55" align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/oil.jpg" width="40" height="40"></td>
    <td width="63%" colspan="6" height="55" class="maintitle">OIL FORM</td>
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
							<logic:present property="instList" name="OilForm">	
								<bean:define id="instList" name="OilForm" property="instList" type="java.util.Collection" ></bean:define>
								<html:options collection="instList" property="instId" labelProperty="instDesc"></html:options>
							</logic:present>
						</html:select>	 
	</td>
                        
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21" class="fieldname">Vehicle Type</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2">
    			<html:select property="vehicleType" onchange="javascript:selectVehicleType()">
                         <html:option value="0">--Choose Vehicle Type--</html:option>
							<logic:present property="typeList" name="OilForm">	
								<bean:define id="typeList" name="OilForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:options collection="typeList" property="typeId" labelProperty="typeDesc"></html:options>
							</logic:present>                                                              
                        </html:select>
                       </td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  
    
   
  <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21" class="fieldname">Date</td>
    <td width="19%" height="21" colspan="4" class="fieldname">
	<html:text property="requestedDate" style="width:113"/>
	<a href="#" onClick="showCalendar(this,document.OilForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.OilForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21" class="fieldname">Vehicle Number</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2">
     <html:select property="vehicleNumber" onchange="javascript:selectVehicleNumber()">
                            <html:option value="0"> - - Choose a Vehicle Number --</html:option>
                            <logic:present property="vehicleList" name="OilForm">	
								<bean:define id="vehicleList" name="OilForm" property="vehicleList" type="java.util.Collection" ></bean:define>
								<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
							</logic:present>                                                                  
                        </html:select>
	</td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  <tr/>
  <tr/>
 <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21" class="fieldname">Driver Name</td>
    <td width="19%" height="21" colspan="4" class="fieldname">
<html:text property="driverName" style="width:113"/></td>
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21">Bill Number</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2">
	<html:text property="billNumber" style="width:113" readonly="false"/></td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  
  <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="19%" height="21" class="fieldname">Requested Driver Name</td>
    <td width="19%" height="21" colspan="4" class="fieldname">
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
    <td width="96%" height="227" colspan="13" align="center">
      <table border="1" width="84%">
        <tr>
          <td width="5%" align="center" class="fieldname" rowspan="2">S.No</td>
          <td width="19%" align="center" class="fieldname" rowspan="2">Oil Type</td>
          <td width="21%" align="center" class="fieldname" rowspan="2">Reason</td>
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
			<html:select property="oilType1" size="1" onchange="javascript:selectTypeMethod1()">
                        <html:option value="0">- -Choose a Oil- -</html:option>
                            <logic:present property="oilList" name="OilForm">	
								<bean:define id="oilList" name="OilForm" property="oilList" type="java.util.Collection" ></bean:define>
								<html:options collection="oilList" property="oilId" labelProperty="oilDesc"></html:options>
							</logic:present>                                                                                    
            </html:select>
		  </td>
          <td width="21%" align="center">
					<html:select property="oilReason1" size="1">
                          <html:option value="0"> - - Choose a Reason - - </html:option>
                         <logic:present property="oilReasonList" name="OilForm">	
								<bean:define id="oilReasonList" name="OilForm" property="oilReasonList" type="java.util.Collection" ></bean:define>
								<html:options collection="oilReasonList" property="oilReasonId" labelProperty="oilReasonDesc"></html:options>
							</logic:present>                                                            
                    </html:select>
		  </td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity1" style="width:60" onblur="javascript:selectQuantity1()"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity1" style="width:60" readonly="true"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable1" style="width:50" readonly="true"/></td>
          <td width="4%" align="center"><html:text property="newAvailable1" style="width:40" readonly="true"/></td>
          <td width="5%" align="center"><html:text property="oldRate1" style="width:50" readonly="true"/></td>
          <td width="4%" align="center"><html:text property="newRate1" style="width:50" readonly="true"/></td>
          <td width="7%"><html:text property="totalAmount1" style="width:70" readonly="true"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">2.</td>
          <td width="19%" align="center">
				<html:select property="oilType2" size="1" onchange="javascript:selectTypeMethod2()">
                             <html:option value="0">- -Choose a Oil- -</html:option>
                            <logic:present property="oilList" name="OilForm">	
								<bean:define id="oilList" name="OilForm" property="oilList" type="java.util.Collection" ></bean:define>
								<html:options collection="oilList" property="oilId" labelProperty="oilDesc"></html:options>
							</logic:present>                                                       
            	</html:select>
		  </td>
          <td width="21%" align="center">
					<html:select property="oilReason2" size="1">
                         <html:option value="0"> - - Choose a Reason - - </html:option>
                            <logic:present property="oilReasonList" name="OilForm">	
								<bean:define id="oilReasonList" name="OilForm" property="oilReasonList" type="java.util.Collection" ></bean:define>
								<html:options collection="oilReasonList" property="oilReasonId" labelProperty="oilReasonDesc"></html:options>
							</logic:present>                                                           
                    </html:select>
		  </td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity2" style="width:60" onblur="javascript:selectQuantity2()"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity2" style="width:60" readonly="true"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable2" style="width:50" readonly="true"/></td>
          <td width="4%" align="center"><html:text property="newAvailable2" style="width:40" readonly="true"/></td>
          <td width="5%" align="center"><html:text property="oldRate2" style="width:50" readonly="true"/></td>
          <td width="4%" align="center"><html:text property="newRate2" style="width:50" readonly="true"/></td>
          <td width="7%"><html:text property="totalAmount2" style="width:70" readonly="true"/></td>
        </tr>
        
              <tr>
          <td width="5%" align="center" class="fieldname">3.</td>
          <td width="19%" align="center">
			<html:select property="oilType3" size="1" onchange="javascript:selectTypeMethod3()">
                            <html:option value="0">- -Choose a Oil- -</html:option>
                            <logic:present property="oilList" name="OilForm">	
								<bean:define id="oilList" name="OilForm" property="oilList" type="java.util.Collection" ></bean:define>
								<html:options collection="oilList" property="oilId" labelProperty="oilDesc"></html:options>
							</logic:present>                                                       
            </html:select>
		  </td>
          <td width="21%" align="center">
					<html:select property="oilReason3" size="1">
                        <html:option value="0"> - - Choose a Reason - - </html:option>
                            <logic:present property="oilReasonList" name="OilForm">	
								<bean:define id="oilReasonList" name="OilForm" property="oilReasonList" type="java.util.Collection" ></bean:define>
								<html:options collection="oilReasonList" property="oilReasonId" labelProperty="oilReasonDesc"></html:options>
							</logic:present>                                                              
                    </html:select>
	</td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity3" style="width:60" onblur="javascript:selectQuantity3()"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity3" style="width:60" readonly="true"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable3" style="width:50" readonly="true"/></td>
          <td width="4%" align="center"><html:text property="newAvailable3" style="width:40" readonly="true"/></td>
          <td width="5%" align="center"><html:text property="oldRate3" style="width:50" readonly="true"/></td>
          <td width="4%" align="center"><html:text property="newRate3" style="width:50" readonly="true"/></td>
          <td width="7%"><html:text property="totalAmount3" style="width:70" readonly="true"/></td>
        </tr>
              <tr>
          <td width="5%" align="center" class="fieldname">4.</td>
          <td width="19%" align="center">
			<html:select property="oilType4" size="1" onchange="javascript:selectTypeMethod4()">
                             <html:option value="0">- -Choose a Oil- -</html:option>
                            <logic:present property="oilList" name="OilForm">	
								<bean:define id="oilList" name="OilForm" property="oilList" type="java.util.Collection" ></bean:define>
								<html:options collection="oilList" property="oilId" labelProperty="oilDesc"></html:options>
							</logic:present>                                                     
            </html:select>
	</td>
          <td width="21%" align="center">
<html:select property="oilReason4" size="1">
                          <html:option value="0"> - - Choose a Reason - - </html:option>
                            <logic:present property="oilReasonList" name="OilForm">	
								<bean:define id="oilReasonList" name="OilForm" property="oilReasonList" type="java.util.Collection" ></bean:define>
								<html:options collection="oilReasonList" property="oilReasonId" labelProperty="oilReasonDesc"></html:options>
							</logic:present>                                                               
                    </html:select>
	</td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity4" style="width:60" onblur="javascript:selectQuantity4()"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity4" style="width:60" readonly="true"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable4" style="width:50" readonly="true"/></td>
          <td width="4%" align="center"><html:text property="newAvailable4" style="width:40" readonly="true"/></td>
          <td width="5%" align="center"><html:text property="oldRate4" style="width:50" readonly="true"/></td>
          <td width="4%" align="center"><html:text property="newRate4" style="width:50" readonly="true"/></td>
          <td width="7%"><html:text property="totalAmount4" style="width:70" readonly="true"/></td>
        </tr>
              <tr>
          <td width="5%" align="center" class="fieldname">5.</td>
          <td width="19%" align="center">
				<html:select property="oilType5" size="1" onchange="javascript:selectTypeMethod5()">
                            <html:option value="0">- -Choose a Oil- -</html:option>
                            <logic:present property="oilList" name="OilForm">	
								<bean:define id="oilList" name="OilForm" property="oilList" type="java.util.Collection" ></bean:define>
								<html:options collection="oilList" property="oilId" labelProperty="oilDesc"></html:options>
							</logic:present>                                                       
            </html:select>
	</td>
          <td width="21%" align="center">
					<html:select property="oilReason5" size="1">
                           <html:option value="0"> - - Choose a Reason - - </html:option>
                            <logic:present property="oilReasonList" name="OilForm">	
								<bean:define id="oilReasonList" name="OilForm" property="oilReasonList" type="java.util.Collection" ></bean:define>
								<html:options collection="oilReasonList" property="oilReasonId" labelProperty="oilReasonDesc"></html:options>
							</logic:present>                                                         
                    </html:select>
	</td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity5" style="width:60" onblur="javascript:selectQuantity5()"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity5" style="width:60" readonly="true"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable5" style="width:50" readonly="true"/></td>
          <td width="4%" align="center"><html:text property="newAvailable5" style="width:40" readonly="true"/></td>
          <td width="5%" align="center"><html:text property="oldRate5" style="width:50" readonly="true"/></td>
          <td width="4%" align="center"><html:text property="newRate5" style="width:50" readonly="true"/></td>
          <td width="7%" align="center"><html:text property="totalAmount5" style="width:70" readonly="true"/></td>
        </tr>
        
</table>
<tr>
    <td width="20%" height="1" colspan="4"></td>
    <td width="6%" height="1" colspan="3"></td>
    <td width="11%" height="1">
    </td>
    <td width="20%" height="1" colspan="2">
    Total Amount
    </td>
    <td width="10%" height="1">
        <html:text property="totalAmount" style="width:110" onclick="javascript:selectTotalAmount()"/></td>
    <td width="13%" height="1" colspan="2">
    </td>
    </tr>
<tr>
    <td width="20%" height="24" colspan="4"></td>
    <td width="6%" height="24" colspan="3">Current KM</td>
    <td width="54%" height="24" colspan="6">
		<html:text property="currentKM" style="width:70" onblur="javascript:selectDifferenceKm()"/></td>
    </tr>
  <tr>
    <td width="20%" height="23" colspan="4"></td>
    <td width="6%" height="23" colspan="3">Previously Serviced KM</td>
    <td width="54%" height="23" colspan="6">
    <html:text property="previousServicedKM" style="width:70" readonly="true"/></td>
    </tr>
  <tr>
    <td width="20%" height="15" colspan="4"></td>
    <td width="6%" height="15" colspan="3">Difference KM</td>
    <td width="54%" height="15" colspan="6">
		<html:text property="differenceKM" style="width:70" readonly="true"/></td>
    </tr>
    <tr>
     <html:errors/>
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