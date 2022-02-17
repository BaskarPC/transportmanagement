<%@ include file="/include/taglibs.jsp"%>


<html:html>
	<head>
	<title>General Note Form</title>
	</head>
<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
<script>
function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function savedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function cleardone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=clearMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	
</script>
<body>
<html:form action="reqgeneralnote" enctype="multipart/form-data">
<table border="0" width="820" id="table1" height="580">

<tr>
			<td height="37" width="244" colspan="2">
            
            &nbsp;<p align="center"></p>
            <p align="center">
	&nbsp;<p align="left">&nbsp;</td>
			<td height="37" width="156">
            
	<img border="0" src="<%=request.getContextPath()%>/images/spaner.jpg" align="right"></td>
			<td height="17" width="481">
            
		
            
            <b><font size="3" class="maintitle">REQUISITION FOR GENERAL ITEMS</font></b></td>
		</tr>
        <tr>
			<td height="27" width="164"></td>
			<td height="27" width="650" colspan="3" class="fieldname">
			<table border="0" width="100%" id="table6">
				<tr>
					<td width="58">From</td>
					<td width="132">
            <html:text property="from"  style="width:113"/></td>
					<td width="63">Date</td>
					<td width="143">
			 <html:text property="date"  style="width:113"/></td>
					<td width="66">Reason</td>
					<td>
             <html:text property="reason"  style="width:113"/></td>
				</tr>
			</table>
			</td>
        </tr>
		    
        <tr>
			<td height="400" width="164" rowspan="4">&nbsp;</td>
			<td height="68" width="650" colspan="3">
			<table border="1" width="100%" id="table4">
        <tr>
          <td width="6%" align="center" height="32" class="fieldname"><b>S.No</b></td>
          <td width="30%" align="center" height="32" class="fieldname"><b>Item 
			Name</b></td>
          <td width="26%" align="center" height="32" class="fieldname"><b>Part 
			Number</b></td>
          <td width="10%" align="center" height="32" class="fieldname"><b>
			Availability</b></td>
          <td width="11%" align="center" height="32" class="fieldname"><b>
			Quantity&nbsp; Needed</b></td>
        </tr>
           <tr>
          <td width="6%" align="center" class="fieldname">1.</td>
          <td width="30%" align="center">
            <html:select size="1"property="itemName1">
              <html:option value="0">Select item name</html:option>
            	<html:option value="1">Lock</html:option>
				<html:option value="2">Clock</html:option>
				<html:option value="3">Uniform</html:option>
            </html:select></td>
          <td width="26%" align="center">
            <p align="center"  class="fieldname">
			<html:select size="1" property="partNo1" >
              <html:option value="0">11111</html:option>
            </html:select></td>
           <td width="10%" align="center"><html:text property="availableQty1"  style="width:113"/></td>
          <td width="11%" align="center"><html:text property="quantityNeeded1"  style="width:113"/></td>
        </tr>
        
        <tr>
          <td width="6%" align="center"  class="fieldname">2.</td>
          <td width="30%" align="center">
            <html:select size="1"property="itemName2">
              <html:option value="0">Select item name</html:option>
            	<html:option value="1">Lock</html:option>
				<html:option value="2">Clock</html:option>
				<html:option value="3">Uniform</html:option>
            </html:select></td>
          <td width="26%" align="center" class="fieldname">
			<html:select size="1" property="partNo2" >
              <html:option value="0">11111</html:option>
            </html:select></td>
           <td width="10%" align="center"><html:text property="availableQty2"  style="width:113"/></td>
          <td width="11%" align="center"><html:text property="quantityNeeded2"  style="width:113"/></td>
</tr>

        <tr>
          <td width="6%" align="center" class="fieldname">3.</td>
          <td width="30%" align="center">
           <html:select size="1"property="itemName2">
              <html:option value="0">Select item name</html:option>
            	<html:option value="1">Lock</html:option>
				<html:option value="2">Clock</html:option>
				<html:option value="3">Uniform</html:option>
            </html:select></td>
          <td width="26%" align="center">
			<html:select size="1" property="partNo2" >
              <html:option value="0">11111</html:option>
            </html:select></td>
          <td width="10%" align="center"><html:text property="availableQty3"  style="width:113"/></td>
          <td width="11%" align="center"><html:text property="quantityNeeded3"  style="width:113"/></td>
 </tr>
        <tr>
          <td width="6%" align="center" class="fieldname">4.</td>
          <td width="30%" align="center" >
            <html:select size="1"property="itemName2">
              <html:option value="0">Select item name</html:option>
            	<html:option value="1">Lock</html:option>
				<html:option value="2">Clock</html:option>
				<html:option value="3">Uniform</html:option>
            </html:select></td>
          <td width="26%" align="center" >
			<html:select size="1" property="partNo2" >
              <html:option value="0">11111</html:option>
            </html:select></td>
          <td width="10%" align="center"><html:text property="availableQty4"  style="width:113"/></td>
          <td width="11%" align="center"><html:text property="quantityNeeded4"  style="width:113"/></td>
  </tr>
  <tr>
          <td width="6%" align="center"  class="fieldname">5.</td>
          <td width="30%" align="center" >
            <html:select size="1"property="itemName2">
              <html:option value="0">Select item name</html:option>
            	<html:option value="1">Lock</html:option>
				<html:option value="2">Clock</html:option>
				<html:option value="3">Uniform</html:option>
            </html:select></td>
          <td width="26%" align="center" >
         <html:select size="1" property="partNo2" >
              <html:option value="0">11111</html:option>
            </html:select></td>
           <td width="10%" align="center"><html:text property="availableQty5"  style="width:113"/></td>
          <td width="11%" align="center"><html:text property="quantityNeeded5"  style="width:113"/></td>
</tr>
		       	
		   </table>
		   <tr>
			<td height="13" width="650" colspan="3">
			<b>Required New Item</b></td>
			<tr>
			<td height="33" colspan="3">
			<table border="1" width="100%" id="table5">
				<tr>
					<td width="38" align="center"><b>S.No</b></td>
					<td align="center" width="157"><b>Item&nbsp; Name</b></td>
					<td align="center" width="193"><b>Part Number</b></td>
					<td align="center"><b>Quantity&nbsp; Needed</b></td>
				</tr>
				<tr>
					<td width="38" align="center">1.</td>
					<td align="center" width="157">
            <html:text property="optionItemName1"  style="width:113"/></td>
					<td align="center" width="193">
            <html:text property="optionPartNo1"  style="width:113"/></td>
					<td align="center">
            <html:text property="optionQtyNeeded1"  style="width:113"/></td>
				</tr>
				
					<tr>
					<td width="38" align="center">2.</td>
					<td align="center" width="157">
            <html:text property="optionItemName2"  style="width:113"/></td>
					<td align="center" width="193">
            <html:text property="optionPartNo2"  style="width:113"/></td>
					<td align="center">
            <html:text property="optionQtyNeeded2"  style="width:113"/></td>
				</tr>
<tr>
					<td width="38" align="center">3.</td>
					<td align="center" width="157">
            <html:text property="optionItemName3"  style="width:113"/></td>
					<td align="center" width="193">
            <html:text property="optionPartNo3"  style="width:113"/></td>
					<td align="center">
            <html:text property="optionQtyNeeded3"  style="width:113"/></td>
				</tr>

				
		
		
		
   			</table>
			<tr>
			<td height="34" width="4">
			<p align="center">&nbsp;</td>
			<td height="34" width="639" colspan="2">
						
			<p align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img border="0" src="<%=request.getContextPath()%>/images/SAVE.jpg" >
		<img border="0" src="<%=request.getContextPath()%>/images/SUB TO EO.jpg" >
		
			<img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" >

			<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" >
		</td>	
        
     

</html:form>

</body>

</html:html>