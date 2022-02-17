
<%@ include file="/include/taglibs.jsp"%>
<html:html>
	<head>
		<title>kerosene and Waste Cloth Requisition Form</title>
	</head>
	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script>
function available()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/kerosenerequisition.do?invoke=availableMethod";	
		document.forms[0].submit();
	}
	function approve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/kerosenerequisition.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function ok()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/kerosenerequisition.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	
	function submittoEO()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/kerosenerequisition.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function purchase()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/kerosenepurchase.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}
</script>
<body> 
		<html:form action="kerosenerequisition" >
	<table height="373">
    		<tr>
			<td height="76" width="314">
			&nbsp;</td>
			<td colspan="2" height="76" width="570">
            <table border="0" width="100%" id="table1" height="54">
				<tr>
					<td width="32">
			<img border="0" src="<%=request.getContextPath()%>/images/waste_kerosene.jpg" align="left"></td>
					<td width="371" class="maintitle">
					REQUISITION FOR KEROSENE/CLOTH</td>
					<td>&nbsp;</td>
				</tr>
			</table>
			</td>
		</tr>
		
		<tr>
			<td height="34" width="314" ></td>
			<td height="34" width="190" class="fieldname" >Date</td>
			<td height="34" width="250"><html:text property="date"/>
			</td>
		</tr>
		<tr>
			<td height="31" width="314" ></td>
			<td height="31" width="190" class="fieldname" >From</td>
			<td height="31" width=250"><html:text property="from"/>	                        

              
              </td>
		</tr>
		
		<tr>
			<td height="34" width="314"></td>
			<td height="34" width="190" class="fieldname">
			Required Item</td>
			<td height="34" width="376">
              <p align="left" class="fieldname">
              
             <html:select property="itemDes" style="width:100" onchange="available()">
			<logic:present property="itemList" name="KeroseneClothRequisitionForm">	
			<bean:define id="itemList" name="KeroseneClothRequisitionForm" property="itemList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Item"></html:option>
			<html:options collection="itemList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
				
				</p>
            </td>
		</tr>
		<tr>
			<td height="36" width="314"></td>
			<td height="36" width="190" class="fieldname">Available Stock</td>
			<td height="36" width="376"><html:text property="availableQty"/></td>
		</tr>
		<tr>
			<td height="36" width="314">&nbsp;</td>
			<td height="36" width="190" class="fieldname">
			Quantity Needed</td>
			<td height="36" width="376"><html:text property="qtyNeeded"/></td>
		</tr>
		<tr>
			<td height="34" width="314"></td>
			<td height="34" width="190" class="fieldname">
				Description</td>

	<td height="34" width="376"><html:text property="description"/></td>


		<tr>
			<td height="64" width="314"></td>
			<td height="64" width="570" colspan="2">
			<p align="left">
		

		<img border="0" src="<%=request.getContextPath()%>/images/SUB TO EO.jpg" onclick="submittoEO()">
			<img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" onclick="approve()">
				<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" onclick="ok()">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_purchaseform.jpg" onclick="purchase()">
		</td>
		</tr>
	  	</table>
		
		</table>
	</html:form>
			
			
</body>
</html:html>		
			


