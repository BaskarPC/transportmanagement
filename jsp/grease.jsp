<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/grease.do";
%>

<html:html>
	<head>
		<title>Grease Form</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
		function cleardone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=clear";	
		document.forms[0].submit();
	}
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/greasevalidate.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	function selectInstName()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=instMethod";	
		document.forms[0].submit();
	}
	function selectVehicleType()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=vehicleMethod";	
		document.forms[0].submit();
	}
	function selectVehicleNumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=driverMethod";	
		document.forms[0].submit();
	}
	function selectTypeMethod1()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=typeMethod1";	
		document.forms[0].submit();
	}
		function selectTypeMethod2()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=typeMethod2";	
		document.forms[0].submit();
	}
		function selectTypeMethod3()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=typeMethod3";	
		document.forms[0].submit();
	}
		function selectTypeMethod4()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=typeMethod4";	
		document.forms[0].submit();
	}
		function selectTypeMethod5()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=typeMethod5";	
		document.forms[0].submit();
	}
	function selectQuantity1()
	{	var availqty=document.forms[0].totalAvailableQuantity1.value;
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
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=quantityMethod1";	
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
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=quantityMethod2";	
		document.forms[0].submit();
		}
	}
		function selectQuantity3()
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
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=quantityMethod3";	
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
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=quantityMethod4";	
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
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=quantityMethod5";	
		document.forms[0].submit();
		}
	}
	function selectTotalAmount()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/grease.do?invoke=totalAmountMethod";	
		document.forms[0].submit();
	}
	
</script>

<body> 
<html:form action="grease" enctype="multipart/form-data">

<table border="0" width="97%" cellspacing="7" cellpadding="7" height="637">
<tr>
    <td width="25%" colspan="3" height="55"></td>
     <td width="15%" height="55"></td>
    <td width="9%" colspan="2" height="55" align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/grease.jpg" width="40" height="40"></td>
    <td width="63%" colspan="7" height="55" class="maintitle">GREASE FORM</td>
  </tr>

   <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21">&nbsp;</td>
    <td width="19%" height="21" colspan="3">&nbsp;</td>
    <td width="7%" height="21" colspan="2">&nbsp;</td>
    <td width="18%" height="21" colspan="4">&nbsp;</td>
    <td width="12%" height="21">&nbsp;</td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>

   <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21" class="fieldname">Institution</td>
    <td width="19%" height="21" colspan="3">
    <html:select property="institutionName" style="width:150" onchange="javascript:selectInstName()">
						<html:option value="0">--Choose an Institution--</html:option>
							<logic:present property="instList" name="GreaseForm">	
								<bean:define id="instList" name="GreaseForm" property="instList" type="java.util.Collection" ></bean:define>
								<html:options collection="instList" property="instId" labelProperty="instDesc"></html:options>
							</logic:present>
						</html:select></td>
                        
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21" class="fieldname" colspan="2">Vehicle Type</td>
    <td width="5%" height="21" colspan="2">&nbsp;</td>
    <td width="11%" height="21">
   <html:select property="vehicleType" onchange="javascript:selectVehicleType()">
                         <html:option value="0">--Choose Vehicle Type--</html:option>
							<logic:present property="typeList" name="GreaseForm">	
								<bean:define id="typeList" name="GreaseForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:options collection="typeList" property="typeId" labelProperty="typeDesc"></html:options>
							</logic:present>                                                              
                        </html:select>
                       </td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  
    
   
  <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21" class="fieldname">Date</td>
    <td width="19%" height="21" colspan="3" class="fieldname">
	<html:text property="requestedDate" style="width:113"/>
	<a href="#" onClick="showCalendar(this,document.GreaseForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.GreaseForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21" class="fieldname" colspan="2">Vehicle Number</td>
    <td width="5%" height="21" colspan="2">&nbsp;</td>
    <td width="11%" height="21">
     <html:select property="vehicleNumber" onchange="javascript:selectVehicleNumber()">
                            <html:option value="0"> - - Choose a Vehicle Number --</html:option>
                            <logic:present property="vehicleList" name="GreaseForm">	
								<bean:define id="vehicleList" name="GreaseForm" property="vehicleList" type="java.util.Collection" ></bean:define>
								<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
							</logic:present>                                                                  
                        </html:select>
	</td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
   <tr>
      <td width="1%" height="17"></td>
   </tr>

 <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21" class="fieldname">Driver Name</td>
    <td width="19%" height="21" colspan="3" class="fieldname">
<html:text property="driverName" style="width:113"/></td>
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21" colspan="2">Bill Number</td>
    <td width="5%" height="21" colspan="2">&nbsp;</td>
    <td width="11%" height="21">
	<html:text property="billNumber" style="width:113"/></td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  
  <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="19%" height="21" class="fieldname">Requested Driver Name</td>
    <td width="19%" height="21" colspan="3" class="fieldname">
	<html:text property="requestedDriverName" style="width:113"/></td>
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21" colspan="2">Other Purpose</td>
    <td width="5%" height="21" colspan="2">&nbsp;</td>
    <td width="11%" height="21">
    <html:text property="otherPurpose" style="width:113"/>
	</td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  
 
  <tr>
    <td width="97%" height="21" colspan="13"></td>
  </tr>
  <tr>
    <td width="96%" height="227" colspan="13" align="center">
      <table border="1" width="88%">
        <tr>
          <td width="5%" align="center" class="fieldname" rowspan="2">S.No</td>
          <td width="19%" align="center" class="fieldname" rowspan="2">Grease Type</td>
          <td width="21%" align="center" class="fieldname" rowspan="2">Reason</td>
          <td width="8%" align="center" rowspan="2" class="fieldname">Quantity Wanted In Kgs</td>
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
			<html:select property="greaseType1" size="1" onchange="javascript:selectTypeMethod1()">
			<html:option value="0"> - -Choose a Grease- -</html:option>
                  <logic:present property="greaseList" name="GreaseForm">	
						<bean:define id="greaseList" name="GreaseForm" property="greaseList" type="java.util.Collection" ></bean:define>
						<html:options collection="greaseList" property="greaseId" labelProperty="greaseDesc"></html:options>
				  </logic:present>                                       
            </html:select>
		  </td>
          <td width="21%" align="center">
					<html:select property="greaseReason1" size="1">
					<html:option value="0"> - - Choose a Reason --</html:option>
                           <logic:present property="greaseReasonList" name="GreaseForm">	
								<bean:define id="greaseReasonList" name="GreaseForm" property="greaseReasonList" type="java.util.Collection" ></bean:define>
								<html:options collection="greaseReasonList" property="greaseReasonId" labelProperty="greaseReasonDesc"></html:options>
							</logic:present>                                                              
                    </html:select>
		  </td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity1" style="width:60" onblur="javascript:selectQuantity1()"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity1" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable1" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable1" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate1" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate1" style="width:50"/></td>
          <td width="7%"><html:text property="totalAmount1" style="width:70"/></td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">2.</td>
          <td width="19%" align="center">
				<html:select property="greaseType2" size="1" onchange="javascript:selectTypeMethod2()">
				 	<html:option value="0"> - -Choose a Grease- -</html:option>
                        <logic:present property="greaseList" name="GreaseForm">	
						<bean:define id="greaseList" name="GreaseForm" property="greaseList" type="java.util.Collection" ></bean:define>
						<html:options collection="greaseList" property="greaseId" labelProperty="greaseDesc"></html:options>
				  </logic:present>                                                        
            	</html:select>
		  </td>
          <td width="21%" align="center">
					<html:select property="greaseReason2" size="1">
					<html:option value="0"> - - Choose a Reason --</html:option>
                            <logic:present property="greaseReasonList" name="GreaseForm">	
								<bean:define id="greaseReasonList" name="GreaseForm" property="greaseReasonList" type="java.util.Collection" ></bean:define>
								<html:options collection="greaseReasonList" property="greaseReasonId" labelProperty="greaseReasonDesc"></html:options>
							</logic:present>                                                              
                    </html:select>
		  </td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity2" style="width:60" onblur="javascript:selectQuantity2()"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity2" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable2" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable2" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate2" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate2" style="width:50"/></td>
          <td width="7%"><html:text property="totalAmount2" style="width:70"/></td>
        </tr>
        
              <tr>
          <td width="5%" align="center" class="fieldname">3.</td>
          <td width="19%" align="center">
			<html:select property="greaseType3" size="1" onchange="javascript:selectTypeMethod3()">
                            <html:option value="0"> - -Choose a Grease- -</html:option>
                            <logic:present property="greaseList" name="GreaseForm">	
						<bean:define id="greaseList" name="GreaseForm" property="greaseList" type="java.util.Collection" ></bean:define>
						<html:options collection="greaseList" property="greaseId" labelProperty="greaseDesc"></html:options>
				  </logic:present>                                                      
            </html:select>
		  </td>
          <td width="21%" align="center">
					<html:select property="greaseReason3" size="1">
                           <html:option value="0"> - - Choose a Reason --</html:option>
                           <logic:present property="greaseReasonList" name="GreaseForm">	
								<bean:define id="greaseReasonList" name="GreaseForm" property="greaseReasonList" type="java.util.Collection" ></bean:define>
								<html:options collection="greaseReasonList" property="greaseReasonId" labelProperty="greaseReasonDesc"></html:options>
							</logic:present>                                                              
                    </html:select>
	</td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity3" style="width:60" onblur="javascript:selectQuantity3()"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity3" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable3" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable3" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate3" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate3" style="width:50"/></td>
          <td width="7%"><html:text property="totalAmount3" style="width:70"/></td>
        </tr>
              <tr>
          <td width="5%" align="center" class="fieldname">4.</td>
          <td width="19%" align="center">
			<html:select property="greaseType4" size="1" onchange="javascript:selectTypeMethod4()">
                            <html:option value="0"> - -Choose a Grease- -</html:option>
                            <logic:present property="greaseList" name="GreaseForm">	
						<bean:define id="greaseList" name="GreaseForm" property="greaseList" type="java.util.Collection" ></bean:define>
						<html:options collection="greaseList" property="greaseId" labelProperty="greaseDesc"></html:options>
				  </logic:present>                                                       
            </html:select>
	</td>
          <td width="21%" align="center">
<html:select property="greaseReason4" size="1">
                            <html:option value="0"> - - Choose a Reason --</html:option>
                            <logic:present property="greaseReasonList" name="GreaseForm">	
								<bean:define id="greaseReasonList" name="GreaseForm" property="greaseReasonList" type="java.util.Collection" ></bean:define>
								<html:options collection="greaseReasonList" property="greaseReasonId" labelProperty="greaseReasonDesc"></html:options>
							</logic:present>                                                               
                    </html:select>
	</td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity4" style="width:60" onblur="javascript:selectQuantity4()"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity4" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable4" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable4" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate4" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate4" style="width:50"/></td>
          <td width="7%"><html:text property="totalAmount4" style="width:70"/></td>
        </tr>
              <tr>
          <td width="5%" align="center" class="fieldname">5.</td>
          <td width="19%" align="center">
				<html:select property="greaseType5" size="1" onchange="javascript:selectTypeMethod5()">
                            <html:option value="0"> - -Choose a Grease- -</html:option>
                            <logic:present property="greaseList" name="GreaseForm">	
						<bean:define id="greaseList" name="GreaseForm" property="greaseList" type="java.util.Collection" ></bean:define>
						<html:options collection="greaseList" property="greaseId" labelProperty="greaseDesc"></html:options>
				  </logic:present>                                                     
            </html:select>
	</td>
          <td width="21%" align="center">
					<html:select property="greaseReason5" size="1">
                            <html:option value="0"> - - Choose a Reason --</html:option>
                            <logic:present property="greaseReasonList" name="GreaseForm">	
								<bean:define id="greaseReasonList" name="GreaseForm" property="greaseReasonList" type="java.util.Collection" ></bean:define>
								<html:options collection="greaseReasonList" property="greaseReasonId" labelProperty="greaseReasonDesc"></html:options>
							</logic:present>                                                              
                    </html:select>
	</td>
          <td width="8%" align="center">
			<html:text property="wantedQuantity5" style="width:60" onblur="javascript:selectQuantity5()"/></td>
          <td width="8%" align="center"><html:text property="totalAvailableQuantity5" style="width:60"/></td>
          <td width="7%" align="center"><html:text property="oldAvailable5" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newAvailable5" style="width:40"/></td>
          <td width="5%" align="center"><html:text property="oldRate5" style="width:50"/></td>
          <td width="4%" align="center"><html:text property="newRate5" style="width:50"/></td>
          <td width="7%" align="center"><html:text property="totalAmount5" style="width:70"/></td>
        </tr>
</table>

  <tr>
    <td width="48%" height="52" colspan="6">
    </td>
    <td width="12%" height="52" colspan="2">
    </td>
    <td width="12%" height="52" colspan="2">
      Total Amount</td>
    <td width="24%" height="52" colspan="3">
      <html:text property="totalAmount" style="width:110" onclick="javascript:selectTotalAmount()"/></td>
     </tr>


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