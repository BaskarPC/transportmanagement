<%@ include file="/include/taglibs.jsp"%>


<%
	String url =  request.getContextPath()+"/kerosenepurchase.do";
%>
<html:html>
	<head>
		<title>Kerosene purchase Form</title>
	</head>
<script>
function amt()
	{
		document.forms[0].method="post";		
		document.forms[0].action ="<%=request.getContextPath()%>"+"/kerosenepurchase.do?invoke=amtMethod";	
		document.forms[0].submit();
	}
	
	function placelist()
	{
		document.forms[0].method="post";		
		document.forms[0].action ="<%=request.getContextPath()%>"+"/kerosenepurchase.do?invoke=fetchplacelist";	
		document.forms[0].submit();
	}
	function save()
	{
		document.forms[0].method="post";		
		document.forms[0].action ="<%=request.getContextPath()%>"+"/kerosenepurchase.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	
</script>
<body> 
<html:form action="kerosenepurchase" enctype="multipart/form-data">
<table height="554">
	<tr>
		<td colspan="3" height="79"> 
		<table border="0" width="100%" id="table1">
			<tr>
				<td width="300">&nbsp;</td>
				<td width="32">
				<img border="0" src="<%=request.getContextPath()%>/images/waste_kerosene.jpg" align="right"></td>
				<td>
				<b><font size="3" class="maintitle"> KEROSENE / WASTE CLOTH&nbsp;PURCHASE</font><font size="5"> </font>
				</b>
				</td>
			</tr>
		</table>
		</td>
		<td width height="79">&nbsp;</td>
	</tr>
	<tr>
		<td width>&nbsp;</td>
		<td width="188" height="34" class="fieldname">Bill Date</td>
		<td width="321" height="34"><html:text property="billDate"/></td>
		<td width>&nbsp;</td>
	</tr>
	<tr>
		<td width>&nbsp;</td>
		<td width="188" height="31" class="fieldname">Bill Number</td>
		<td width="321" height="31"><html:text property="billNo"/></td>
		<td width>&nbsp;</td>
	</tr>
	<tr>
		<td width="340" height="32">&nbsp;</td>
		<td width="188" height="32"class="fieldname">Delivered Date</td>
		<td width="321" height="32" class="fieldname">
		<html:text property="deliveredDate"/></td>
		<td width="32" height="32">&nbsp;</td>
	</tr>
	<tr>
		<td width="157" height="27"></td>
		<td width="193" height="27"class="fieldname">Required Item</td>
		<td width="499" height="27" class="fieldname">
		
		<html:select property="itemDes" style="width:130" >
			<logic:present property="itemList" name="KeroseneClothPurchaseForm">	
			<bean:define id="itemList" name="KeroseneClothPurchaseForm" property="itemList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Item"></html:option>
			<html:options collection="itemList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
		</td>
		<td width="32" height="27"></td>
		</tr>
		
	
	<tr>
		<td width="340" height="34">&nbsp;</td>
		<td width="188" height="34" class="fieldname">Company Name</td>
		<td width="321" height="34">
		
		<html:select property="companyName" style="width:130" onchange="placelist()">
			<logic:present property="companyList" name="KeroseneClothPurchaseForm">	
			<bean:define id="companyList" name="KeroseneClothPurchaseForm" property="companyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Company"></html:option>
			<html:options collection="companyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
		
		&nbsp; 
		<img border="0" src="<%=request.getContextPath()%>/images/ADD.jpg" width="60" height="18"></td>
		<td width="32" height="34">&nbsp;</td>
	</tr>
	<tr>
		<td width="340" height="33"></td>
		<td width="188" height="33" class="fieldname">Place</td>
		<td width="321" height="33">
		<html:select property="place" style="width:130" >
			<logic:present property="placeList" name="KeroseneClothPurchaseForm">	
			<bean:define id="placeList" name="KeroseneClothPurchaseForm" property="placeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Place"></html:option>
			<html:options collection="placeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select></td>
		<td width="32" height="33"></td>
	</tr>
	<tr>
		<td width="157" height="36">&nbsp;</td>
		<td width="193" height="36" class="fieldname">Quantity Purchased</font></td>
		<td width="499" height="36"><html:text property="qtyPurchased"/></td>
		<td width="32" height="36">&nbsp;</td>
	</tr>
	<tr>
		<td width="340" height="30">&nbsp;</td>
		<td width="188" height="30" class="fieldname">Rate Per Unit</td>
		<td width="321" height="30"><html:text property="unitPrice" onblur="amt()"/></td>
		<td width="32" height="30">&nbsp;</td>
	</tr>
	<tr>
		<td width="340" height="31">&nbsp;</td>
		<td width="188" height="31" class="fieldname">Amount</td>
		<td width="321" height="31">
		<html:text property="amount"/></td>
		<td width="32" height="31">&nbsp;</td>
	</tr>
	
	<tr>
		<td width="340" height="54">&nbsp;</td>
		<td width="513" height="54" colspan="2">
          <p align="left">&nbsp;&nbsp;
        	
		<img border="0" src="<%=request.getContextPath()%>/images/SAVE.jpg" onclick="save()">
		
		<img border="0" src="<%=request.getContextPath()%>/images/SUB TO EO.jpg">
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg">
		
		</p>
		
		<td width="32" height="54">&nbsp;</td>
	</tr>
	<tr>
		<td width="816" height="39" colspan="3">&nbsp;</td>
		<td width="32" height="39">&nbsp;</td>
	</tr>
</table>
</html:form>
</body>
</html:html>		
			

