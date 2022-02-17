<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/waste.do";
%>
<html:html>
	<head>
		<title>Waste Cloth</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/waste.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/waste.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/waste.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/waste.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	
</script>

<body> 
		<html:form action="waste" enctype="multipart/form-data">
		<table border="0" width="100%" cellspacing="7" cellpadding="7" height="506">
<tr>
    <td width="25%" colspan="2" height="55">
      </td>
    <td width="7%" height="55">
      <p align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/wastecloth.jpg" width="40" height="40"></td>
    <td width="68%" colspan="3" height="55" class="maintitle">WASTE CLOTH REQUISITION FORM</td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="19%" height="21" colspan="3">&nbsp;</td>
    <td width="30%" height="21" align="left">&nbsp;</td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="19%" height="21" colspan="3" class="fieldname">Date</td>
    <td width="30%" height="21" align="left" class="fieldname">
       <html:text property="requestedDate" style="width:113"/>
       <a href="#" onClick="showCalendar(this,document.WasteForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.WasteForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="23%" height="21" align="left" colspan="3" class="fieldname">Bill Number</td>
    <td width="27%" height="21" align="left" class="fieldname">
       <html:text property="billNumber" style="width:113"/></td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="19%" height="21" align="left" colspan="3" class="fieldname">Name of the Institution</td>
    <td width="30%" height="21" align="left" class="fieldname">
      <html:select property="institutionName" style="width:145">
			<html:option value="--Choose Institution --"></html:option>
    		<html:option value="KVITT"></html:option>
    		<html:option value="KEC"></html:option>
			<html:option value="KPTC"></html:option>
			<html:option value="KASC"></html:option>
			<html:option value="KNMS"></html:option>
                                       
      	</html:select>    </td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="19%" height="21" align="left" colspan="3" class="fieldname">Vehicle Type</td>
    <td width="30%" height="21" align="left" class="fieldname">
   <html:select property="vehicleType">
		     <html:option value="0"> - - Choose a Vehicle Type --</html:option>
             <html:option value="1">Bus</html:option>
             <html:option value="2">Car</html:option>   
             <html:option value="3">Lorry</html:option>                                                                    
         </html:select></td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="19%" height="21" align="left" colspan="3" class="fieldname">Vehicle Number</td>
    <td width="30%" height="21" align="left" class="fieldname">
    <html:select property="vehicleNumber">
                            
                            <html:option value="0"> --Choose a Vehicle Number--</html:option>
                            <html:option value="1">TN33 H 8388</html:option>
                            <html:option value="2">TN27 U 7949</html:option>   
                            <html:option value="3">TN36 C 7701</html:option>                                                                    
                  </html:select></td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="19%" height="21" align="left" colspan="3" class="fieldname">
	Other Purpose</td>
    <td width="30%" height="21" align="left" class="fieldname">
	 <html:text property="otherPurpose" style="width:113"/></td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="19%" height="21" align="left" colspan="3" class="fieldname">Driver Name</td>
    <td width="30%" height="21" align="left" class="fieldname"> 
    <html:text property="driverName" style="width:113"/></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="19%" height="21" align="left" colspan="3" class="fieldname">
	Requested Driver Name</td>
    <td width="30%" height="21" align="left" class="fieldname">
	 <html:text property="requestedDriverName" style="width:113"/></td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="19%" height="21" align="left" colspan="3" class="fieldname">Required Quantity</td>
    <td width="30%" height="21" align="left" class="fieldname"> 
    <html:text property="requiredQuantity" style="width:113"/></td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21"></td>
    <td width="19%" height="21" align="left" colspan="3" class="fieldname">Reason</td>
    <td width="30%" height="21" align="left" class="fieldname">
    <html:select property="wasteReason" style="width:145">
			<html:option value="--Choose Reason--"></html:option>
    		<html:option value="FC"></html:option>
    		<html:option value="Paint"></html:option>
			<html:option value="Wheel"></html:option>
			<html:option value="Maintenance"></html:option>
                                 
      	</html:select>
    </td>
    <td width="25%" height="21"></td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="19%" height="21" align="left" colspan="3" class="fieldname">Available Quantity</td>
    <td width="30%" height="21" align="left">
	 <html:text property="totalAvailableQuantity" style="width:113"/></td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="19%" height="21" align="left" colspan="3" class="fieldname">Unit Rate</td>
    <td width="30%" height="21" align="left">
	 <html:text property="unitRate" style="width:113"/></td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="19%" height="21" align="left" colspan="3" class="fieldname">Total Amount</td>
    <td width="30%" height="21" align="left">
	 <html:text property="totalAmount" style="width:113"/></td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="19%" height="21" align="left" colspan="3" class="fieldname">Remaining 
	Quantity</td>
    <td width="30%" height="21" align="left">
	 <html:text property="remainingQuantity" style="width:113"/></td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="25%" height="21">&nbsp;</td>
    <td width="19%" height="21" colspan="3">&nbsp;</td>
    <td width="30%" height="21" align="center">&nbsp;</td>
    <td width="25%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="100%" height="21" colspan="6">
	<p align="center">
	<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18">&nbsp;
	<img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18">&nbsp;
	<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18">&nbsp;
	<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18"></td>
  </tr>
  </table>
</html:form>
</body>

</html:html>