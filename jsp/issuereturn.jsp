<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/return.do";
%>
<html:html>
	<head>
		<title>Return Form</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/return.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/return.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/return.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/return.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	
</script>

<body> 
		<html:form action="return" enctype="multipart/form-data"><table border="0" width="99%" cellspacing="7" cellpadding="7" height="676">
<tr>
    <td width="25%" colspan="3" height="55"></td>
    <td width="15%" colspan="3" height="55"></td>
    <td width="9%" colspan="2" height="55" align="right">
     	<img border="0" src="<%=request.getContextPath()%>/images/return.jpg" width="40" height="40"></td>
    <td width="63%" colspan="9" height="55" class="maintitle">RETURN FORM</td>
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
    <html:select property="institutionName" style="width:113">
    
    	<html:option value="hai"></html:option>
    	<html:option value="hello"></html:option>
    	<html:option value="bye"></html:option>
                                       
      </html:select></td>
                        
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21" class="fieldname">Vehicle Type</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2"><html:select property="vehicleType">
                            
                            <html:option value="0"> - - Choose a Vehicle Type --</html:option>
                            <html:option value="1">Bus</html:option>
                            <html:option value="2">Car</html:option>   
                            <html:option value="3">Lorry</html:option>                                                                    
                        </html:select>
                       </td>
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  
    
   
  <tr>
    <td width="7%" height="21">&nbsp;</td>
    <td width="13%" height="21" class="fieldname">Date</td>
    <td width="19%" height="21" colspan="5" class="fieldname">
	<html:text property="requestedDate" style="width:113"/>
	<a href="#" onClick="showCalendar(this,document.ReturnForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.ReturnForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
    <td width="2%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="12%" height="21" class="fieldname">Vehicle Number</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="11%" height="21" colspan="2">
     <html:select property="vehicleNumber">
                            
                            <html:option value="0"> - - Choose a Vehicle Number --</html:option>
                            <html:option value="1">TN33 H 8388</html:option>
                            <html:option value="2">TN27 U 7949</html:option>   
                            <html:option value="3">TN36 C 7701</html:option>                                                                    
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
    <td width="4%" height="21">&nbsp;</td>
  </tr>
  
 
  <tr>
    <td width="97%" height="361" colspan="15" align="center">
      <table border="1" width="82%">
        <tr>
          <td width="5%" align="center" class="fieldname">S.No</td>
          <td width="19%" align="center" class="fieldname">Bill Numbers</td>
          <td width="19%" align="center" class="fieldname">Type Of Return</td>
          <td width="19%" align="center" class="fieldname">Sub Type of the Products</td>
          <td width="10%" align="center" class="fieldname">Quantity Returned</td>
          <td width="10%" align="center" class="fieldname">Total Available Quantity</td>
          <td width="8%" align="center" class="fieldname">Amount</td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">1.</td>
          <td width="19%" align="center">
			<html:select property="returnBillNumber1">
		     <html:option value="0"> - - Choose a Bill No --</html:option>
             <html:option value="1">2</html:option>
             <html:option value="2">3</html:option>   
             <html:option value="3">5</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="productType1">
		     <html:option value="0"> - - Choose  Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="subProductType1">
		     <html:option value="0"> - - Choose Sub Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="10%" align="center">
			<html:text property="quantityReturned1" style="width:75"/></td>
          <td width="10%" align="center">
          <html:text property="totalAvailableQuantity1" style="width:75"/></td>
          <td width="8%">
			<html:text property="totalAmount1" style="width:75"/></td>
        </tr>
        <tr>
          <td width="5%" align="center">2.</td>
          <td width="19%" align="center">
			<html:select property="returnBillNumber2">
		     <html:option value="0"> - - Choose a Bill No --</html:option>
             <html:option value="1">2</html:option>
             <html:option value="2">3</html:option>   
             <html:option value="3">5</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="productType2">
		     <html:option value="0"> - - Choose  Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="subProductType2">
		     <html:option value="0"> - - Choose Sub Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="10%" align="center">
			<html:text property="quantityReturned2" style="width:75"/></td>
          <td width="10%" align="center">
          <html:text property="totalAvailableQuantity2" style="width:75"/></td>
          <td width="8%">
			<html:text property="totalAmount2" style="width:75"/></td>
        </tr>
        <tr>
          <td width="5%" align="center">3.</td>
         <td width="19%" align="center">
			<html:select property="returnBillNumber3">
		     <html:option value="0"> - - Choose a Bill No --</html:option>
             <html:option value="1">2</html:option>
             <html:option value="2">3</html:option>   
             <html:option value="3">5</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="productType3">
		     <html:option value="0"> - - Choose  Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="subProductType3">
		     <html:option value="0"> - - Choose Sub Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="10%" align="center">
			<html:text property="quantityReturned3" style="width:75"/></td>
          <td width="10%" align="center">
          <html:text property="totalAvailableQuantity3" style="width:75"/></td>
          <td width="8%">
			<html:text property="totalAmount3" style="width:75"/></td>
        </tr>
        <tr>
          <td width="5%" align="center">4.</td>
         <td width="19%" align="center">
			<html:select property="returnBillNumber4">
		     <html:option value="0"> - - Choose a Bill No --</html:option>
             <html:option value="1">2</html:option>
             <html:option value="2">3</html:option>   
             <html:option value="3">5</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="productType4">
		     <html:option value="0"> - - Choose  Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="subProductType4">
		     <html:option value="0"> - - Choose Sub Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="10%" align="center">
			<html:text property="quantityReturned4" style="width:75"/></td>
          <td width="10%" align="center">
          <html:text property="totalAvailableQuantity4" style="width:75"/></td>
          <td width="8%">
			<html:text property="totalAmount4" style="width:75"/></td>
        </tr>
        <tr>
          <td width="5%" align="center">5.</td>
          <td width="19%" align="center">
			<html:select property="returnBillNumber5">
		     <html:option value="0"> - - Choose a Bill No --</html:option>
             <html:option value="1">2</html:option>
             <html:option value="2">3</html:option>   
             <html:option value="3">5</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="productType5">
		     <html:option value="0"> - - Choose  Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="subProductType5">
		     <html:option value="0"> - - Choose Sub Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="10%" align="center">
			<html:text property="quantityReturned5" style="width:75"/></td>
          <td width="10%" align="center">
          <html:text property="totalAvailableQuantity5" style="width:75"/></td>
          <td width="8%">
			<html:text property="totalAmount5" style="width:75"/></td>
        </tr>
        <tr>
          <td width="5%" align="center">6.</td>
          <td width="19%" align="center">
			<html:select property="returnBillNumber6">
		     <html:option value="0"> - - Choose a Bill No --</html:option>
             <html:option value="1">2</html:option>
             <html:option value="2">3</html:option>   
             <html:option value="3">5</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="productType6">
		     <html:option value="0"> - - Choose  Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="subProductType6">
		     <html:option value="0"> - - Choose Sub Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="10%" align="center">
			<html:text property="quantityReturned6" style="width:75"/></td>
          <td width="10%" align="center">
          <html:text property="totalAvailableQuantity6" style="width:75"/></td>
          <td width="8%">
			<html:text property="totalAmount6" style="width:75"/></td>
        </tr>
        <tr>
          <td width="5%" align="center">7.</td>
          <td width="19%" align="center">
			<html:select property="returnBillNumber7">
		     <html:option value="0"> - - Choose a Bill No --</html:option>
             <html:option value="1">2</html:option>
             <html:option value="2">3</html:option>   
             <html:option value="3">5</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="productType7">
		     <html:option value="0"> - - Choose  Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="subProductType7">
		     <html:option value="0"> - - Choose Sub Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="10%" align="center">
			<html:text property="quantityReturned7" style="width:75"/></td>
          <td width="10%" align="center">
          <html:text property="totalAvailableQuantity7" style="width:75"/></td>
          <td width="8%">
			<html:text property="totalAmount7" style="width:75"/></td>
        </tr>
        <tr>
          <td width="5%" align="center">8.</td>
         <td width="19%" align="center">
			<html:select property="returnBillNumber8">
		     <html:option value="0"> - - Choose a Bill No --</html:option>
             <html:option value="1">2</html:option>
             <html:option value="2">3</html:option>   
             <html:option value="3">5</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="productType8">
		     <html:option value="0"> - - Choose  Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="subProductType8">
		     <html:option value="0"> - - Choose Sub Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="10%" align="center">
			<html:text property="quantityReturned8" style="width:75"/></td>
          <td width="10%" align="center">
          <html:text property="totalAvailableQuantity8" style="width:75"/></td>
          <td width="8%">
			<html:text property="totalAmount8" style="width:75"/></td>
        </tr>
        <tr>
          <td width="5%" align="center">9.</td>
          <td width="19%" align="center">
			<html:select property="returnBillNumber9">
		     <html:option value="0"> - - Choose a Bill No --</html:option>
             <html:option value="1">2</html:option>
             <html:option value="2">3</html:option>   
             <html:option value="3">5</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="productType9">
		     <html:option value="0"> - - Choose  Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="subProductType9">
		     <html:option value="0"> - - Choose Sub Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="10%" align="center">
			<html:text property="quantityReturned9" style="width:75"/></td>
          <td width="10%" align="center">
          <html:text property="totalAvailableQuantity9" style="width:75"/></td>
          <td width="8%">
			<html:text property="totalAmount9" style="width:75"/></td>
        </tr>
        <tr>
          <td width="5%" align="center">10.</td>
          <td width="19%" align="center">
			<html:select property="returnBillNumber10">
		     <html:option value="0"> - - Choose a Bill No --</html:option>
             <html:option value="1">2</html:option>
             <html:option value="2">3</html:option>   
             <html:option value="3">5</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="productType10">
		     <html:option value="0"> - - Choose  Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="19%" align="center">
			<html:select property="subProductType10">
		     <html:option value="0"> - - Choose Sub Type --</html:option>
             <html:option value="1">Spare Parts</html:option>
             <html:option value="2">diesel</html:option>   
             <html:option value="3">oil</html:option>                                                                    
         </html:select></td>
          <td width="10%" align="center">
			<html:text property="quantityReturned10" style="width:75"/></td>
          <td width="10%" align="center">
          <html:text property="totalAvailableQuantity10" style="width:75"/></td>
          <td width="8%">
			<html:text property="totalAmount10" style="width:75"/></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td width="97%" height="26" colspan="15">
      <p align="center">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18"></td>
     </tr>
</table>

</html:form>
</body>

</html:html>