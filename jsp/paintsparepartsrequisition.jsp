
<%@ include file="/include/taglibs.jsp"%>


<%
	String url =  request.getContextPath()+"/paintsparerequisition.do";
%>
<html:html>
	<head>
		<title>Paint and Spare Parts Requisition Form</title>
	</head>
<script>
function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisitionvalidate.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=okMethod";	
		document.forms[0].submit();
	}
function listpartNumber1()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=partNumberMethod1";	
		document.forms[0].submit();
	}
	function listpartNumber2()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=partNumberMethod2";	
		document.forms[0].submit();
	}
	function listpartNumber3()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=partNumberMethod3";	
		document.forms[0].submit();
	}
	function listpartNumber4()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=partNumberMethod4";	
		document.forms[0].submit();
	}
	function listpartNumber5()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=partNumberMethod5";	
		document.forms[0].submit();
	}
	function availableQuantity1()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=quantityMethod1";	
		document.forms[0].submit();
	}
	function availableQuantity2()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=quantityMethod2";	
		document.forms[0].submit();
	}
	function availableQuantity3()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=quantityMethod3";	
		document.forms[0].submit();
	}
	function availableQuantity4()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=quantityMethod4";	
		document.forms[0].submit();
	}
	function availableQuantity5()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=quantityMethod5";	
		document.forms[0].submit();
	}
	function submitUpdate()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}
	function submitOldvehicle()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}
	</script>
<body> 
		<html:form action="paintsparerequisition" enctype="multipart/form-data">
		<table border="0" width="96%" cellpadding="7" cellspacing="7" height="121%">
    
 
		<tr>
			<td height="83" width="244" colspan="4">
            
            &nbsp;<p align="center"></p>
            <p align="center">
	&nbsp;<p align="left">&nbsp;</td>
			<td height="83" width="123" colspan="2">
            
	<img border="0" src="<%=request.getContextPath()%>/images/spaner.jpg" align="right"></td>
			<td height="83" width="676" colspan="6">
            
		
            
            <b><font size="3" class="maintitle">REQUISITION FOR PAINT / SPARE PARTS</font></b></td>
		</tr>
		<tr>
			<td height="1" width="122" colspan="2"></td>
			<td height="1" width="405" colspan="8"></td>
			<td height="1" width="186"></td>
			<td height="1" width="171"></td>
		</tr>
		<tr>
			<td height="27" width="150"></td>
			<td height="27" width="83" colspan="3" class="fieldname">From</td>
			<td height="27" width="281" colspan="5">
            <html:text property="from"/></td>
			<td height="27" width="141" class="fieldname">Date</td>
			<td height="27" width="186">
			<p align="center">
			<html:text property="date"/></td>
			<td height="27" width="171">&nbsp;</td>
		</tr>
        <tr>
			<td height="31" width="150"></td>
			<td height="31" width="83" colspan="3" class="fieldname">Reason</td>
			<td height="31" width="281" colspan="5">
            <html:text property="reason"/></td>
			<td height="31" width="141" class="fieldname">Vehicle Number&nbsp; </td>
			<td height="31" width="186">
			<p align="center">&nbsp;&nbsp;&nbsp; 
			
			
			<html:select property="vehicleNo">
                            
                            <html:option value="0">--Select--</html:option>
                            <html:option value="1">TN 27</html:option>
                                                                                            
                        </html:select>
			
			
			</td>
			<td height="31" width="171">&nbsp;</td>
        </tr>
		<tr>
			<td height="31" width="150">&nbsp;</td>
			<td height="31" width="83" colspan="2" class="fieldname">
			Required Item</td>
			<td height="31" width="207" colspan="4" class="fieldname">
			&nbsp;
			
			<html:select property="itemDes">
                            
                            <html:option value="0">-- Select --</html:option>
                            <html:option value="1">Paint</html:option>
                            <html:option value="2">Spare Parts</html:option>
                                                                                            
                        </html:select>
			
			
			</td>
			<td height="31" width="68">&nbsp;</td>
			<td height="31" width="89">&nbsp;</td>
			<td height="31" width="141">&nbsp;</td>
			<td height="31" width="186">&nbsp;</td>
			<td height="31" width="171">&nbsp;</td>
		</tr>
		<tr>
			<td height="14" width="150"></td>
			<td height="14" width="86"></td>
			<td height="14" width="22" colspan="3"></td>
			<td height="14" width="204" colspan="4"></td>
			<td height="14" width="141"></td>
			<td height="14" width="186"></td>
			<td height="14" width="171"></td>
		</tr>
		<tr>
			<td height="410" width="150" rowspan="4">&nbsp;</td>
			<td height="172" width="854" colspan="11">
			<table border="1" width="77%" id="table4">
        <tr>
          <td width="6%" align="center" height="32" class="fieldname"><b>S.No</b></td>
          <td width="30%" align="center" height="32" class="fieldname"><b>Part / 
			Paint Name</b></td>
          <td width="26%" align="center" height="32" class="fieldname"><b>Part 
			Number / Paint Color</b></td>
          <td width="10%" align="center" height="32" class="fieldname"><b>
			Availability</b></td>
          <td width="11%" align="center" height="32" class="fieldname"><b>
			Quantity&nbsp; Needed</b></td>
        </tr>
        <tr>
          <td width="6%" align="center" class="fieldname">1.</td>
          <td width="30%" align="center">
          
           <html:select property="brandName1" style="width:150" onchange="javascript:listpartNumber1()">
							<logic:present property="typeList" name="PaintSparepartsRequisitionForm">	
								<bean:define id="typeList" name="PaintSparepartsRequisitionForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
            
            </td>
          <td width="26%" align="center">
            <p align="center"  class="fieldname">
            
			<html:select property="brandType1" style="width:150" onchange="javascript:availableQuantity1()">
							<logic:present property="partList1" name="PaintSparepartsRequisitionForm">	
								<bean:define id="partList1" name="PaintSparepartsRequisitionForm" property="partList1" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="partList1" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select>
            
            </td>
          <td width="10%" align="center"><html:text property="availableQty1"/></td>
          <td width="11%" align="center"><html:text property="qtyNeeded1"/></td>
        </tr>
        <tr>
          <td width="6%" align="center"  class="fieldname">2.</td>
          <td width="30%" align="center">
          
           <html:select property="brandName2" style="width:150" onchange="javascript:listpartNumber2()">
							<logic:present property="typeList" name="PaintSparepartsRequisitionForm">	
								<bean:define id="typeList" name="PaintSparepartsRequisitionForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
            
            </td>
          <td width="26%" align="center" class="fieldname">
          
			<html:select property="brandType2" style="width:150" onchange="javascript:availableQuantity2()">
							<logic:present property="partList2" name="PaintSparepartsRequisitionForm">	
								<bean:define id="partList2" name="PaintSparepartsRequisitionForm" property="partList2" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="partList2" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select>
            
            </td>
          <td width="10%" align="center"><html:text property="availableQty2"/></td>
          <td width="11%" align="center"><html:text property="qtyNeeded2"/></td>
        </tr>
        <tr>
          <td width="6%" align="center" class="fieldname">3.</td>
          <td width="30%" align="center">
          
           <html:select property="brandName3" style="width:150" onchange="javascript:listpartNumber3()">
							<logic:present property="typeList" name="PaintSparepartsRequisitionForm">	
								<bean:define id="typeList" name="PaintSparepartsRequisitionForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
            
            </td>
          <td width="26%" align="center">
          
			<html:select property="brandType3" style="width:150" onchange="javascript:availableQuantity3()">
							<logic:present property="partList3" name="PaintSparepartsRequisitionForm">	
								<bean:define id="partList3" name="PaintSparepartsRequisitionForm" property="partList3" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="partList3" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select>
            
            </td>
          <td width="10%" align="center"><html:text property="availableQty3"/></td>
          <td width="11%" align="center"><html:text property="qtyNeeded3"/></td>
        </tr>
        <tr>
          <td width="6%" align="center" class="fieldname">4.</td>
          <td width="30%" align="center" >
          
           <html:select property="brandName4" style="width:150" onchange="javascript:listpartNumber4()">
							<logic:present property="typeList" name="PaintSparepartsRequisitionForm">	
								<bean:define id="typeList" name="PaintSparepartsRequisitionForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
            
            </td>
          <td width="26%" align="center" >
          
			<html:select property="brandType4" style="width:150" onchange="javascript:availableQuantity4()">
							<logic:present property="partList4" name="PaintSparepartsRequisitionForm">	
								<bean:define id="partList4" name="PaintSparepartsRequisitionForm" property="partList4" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="partList4" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select>
            </td>
          <td width="10%" align="center"><html:text property="availableQty4"/></td>
          <td width="11%" align="center"><html:text property="qtyNeeded4"/></td>
        </tr>
        <tr>
          <td width="6%" align="center"  class="fieldname">5.</td>
          <td width="30%" align="center" >
          
              <html:select property="brandName5" style="width:150" onchange="javascript:listpartNumber5()">
							<logic:present property="typeList" name="PaintSparepartsRequisitionForm">	
								<bean:define id="typeList" name="PaintSparepartsRequisitionForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
            </td>
          <td width="26%" align="center" >
          
         <html:select property="brandType5" style="width:150" onchange="javascript:availableQuantity5()">
							<logic:present property="partList5" name="PaintSparepartsRequisitionForm">	
								<bean:define id="partList5" name="PaintSparepartsRequisitionForm" property="partList5" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="partList5" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select>
            </td>
          <td width="10%" align="center"><html:text property="availableQty5"/></td>
          <td width="11%" align="center"><html:text property="qtyNeeded5"/></td>
			</tr>
		<tr>
		
			<td height="2" width="84%" colspan="5">

			</table>
			
            </td>
			<tr>
			<td height="45" width="854" colspan="11">
			<b>Required New Parts / Paint :</b></td>
			<tr>
			<td height="121" width="854" colspan="11">
			<table border="1" width="77%" id="table5">
				<tr>
					<td width="38" align="center"><b>S.No</b></td>
					<td align="center" width="234"><b>Part / Paint Name</b></td>
					<td align="center" width="199"><b>Part Number / Paint Color</b></td>
					<td align="center"><b>Quantity&nbsp; Needed</b></td>
				</tr>
				<tr>
					<td width="38" align="center">1.</td>
					<td align="center" width="234">
           <html:text property="newBrandName1"/></td>
					<td align="center" width="199">
            <html:text property="newBrandType1"/></td>
					<td align="center">
            <html:text property="newQtyNeeded1"/></td>
				</tr>
				<tr>
					<td width="38" align="center">2.</td>
					<td align="center" width="234">
             <html:text property="newBrandName2"/></td>
					<td align="center" width="199">
           <html:text property="newBrandType2"/></td>
					<td align="center">
             <html:text property="newQtyNeeded2"/></td>
				</tr>
				<tr>
					<td width="38" align="center">3.</td>
					<td align="center" width="234">
            <html:text property="newBrandName3"/></td>
					<td align="center" width="199">
            <html:text property="newBrandType3"/></td>
					<td align="center">
            <html:text property="newQtyNeeded3"/></td>
				</tr>
			</table>
			</td>
			<tr>
			<td height="66" width="83" colspan="3">
			<p align="center">&nbsp;</td>
			<td height="66" width="769" colspan="8">
						
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="javascript:submitdone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18" onclick="javascript:issuedone()">
        <img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18" onclick="javascript:approvedone()">
	</td>
		
		</td>
	  	</table>
	</html:form>
			
			
</body>
</html:html>		
			


