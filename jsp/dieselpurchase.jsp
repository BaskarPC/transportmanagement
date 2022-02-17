<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/dieselpurchase.do";
%>
<html:html>
	<head>
		<title>Diesel Purchase Form</title>
	</head>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	
<script>
	
	function amt()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieselpurchase.do?invoke=amtMethod";	
		document.forms[0].submit();
	}
	function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieselpurchase.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	function totalamount()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieselpurchase.do?invoke=totalAmountMethod";	
		document.forms[0].submit();
	}
	function vatamount()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/dieselpurchase.do?invoke=vatMethod";	
		document.forms[0].submit();
	}
	function upload()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/req_diesel.do?invoke=uploadMethod";	
		document.forms[0].submit();
	}
	function edit()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/req_diesel.do?invoke=editMethod";	
		document.forms[0].submit();
	}
	function del()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/req_diesel.do?invoke=deleteMethod";	
		document.forms[0].submit();
	}
	function imageview()
	{
	if (document.DieselRequisitionForm.imageName.value=="Select Image") {
	alert("Select correct image name")	
	} else {
	alert(document.DieselRequisitionForm.imageName.value)
		var strURLParam = "<%=request.getContextPath()%>"+"/req_diesel.do?invoke=viewMethod&documentId="+document.DieselRequisitionForm.imageName.value;	
		top.window.name = 'Show Document';
		win = window.open(strURLParam,'winShowDoc','');
		
	}
</script>

<body> 
		<html:form action="dieselpurchase" enctype="multipart/form-data">
 <table width="70%" align="center" height="548">
<tr>
      <td width="213%" height="51" colspan="4">
		<table border="0" width="100%" id="table1" height="74">
			<tr>
				<td width="208">&nbsp;</td>
				<td width="68">
		&nbsp;</td>
				<td class="maintitle">
		&nbsp;</td>
			</tr>
			<tr>
				<td width="208">&nbsp;</td>
				<td width="68">
		<img border="0" src="<%=request.getContextPath()%>/images/deisel purchase.jpg" align="right"></td>
				<td class="maintitle">
		DIESEL PURCHASE FORM</td>
			</tr>
		</table>
		</td>
</tr>
    
<tr>
      <td width="28%" height="36">&nbsp;</td>
      <td width="39%" height="36">&nbsp;</td>
      <td width="28%" height="36">&nbsp;</td>
      <td width="86%" height="36">&nbsp;</td>
 </tr>
    
<tr>
      <td width="28%" height="36">Bill Date</td>
      <td width="39%" height="36"><font size="3" face="Times New Roman">
		<html:text property="billDate"/><a href="#" onClick="showCalendar(this,document.DieselPurchaseForm.billDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.DieselPurchaseForm.billDate,'anchor03','dd MMM yyyy'); return false;" NAME="anchor04" ID="anchor04">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
      <td width="28%" height="36"><font face="Times New Roman" size="3" class="fieldname">VAT 
		Percentage</font></td>
      <td width="80%" height="36"><font size="3" face="Times New Roman">
		<html:text property="vatPercent" onchange="vatamount()"/></font></td>
 </tr>
  <tr>
      <td width="28%" height="36">Bill Number</td>
      <td width="39%" height="36"><font size="3" face="Times New Roman">
		<html:text property="billNo"/></font></td>
      <td width="28%" height="36">VAT 
		Amount</font></td>
      <td width="80%" height="36"><font size="3" face="Times New Roman">
		<html:text property="vatAmount" onblur="totalAmount()"/></font></td>
   </tr>
   <tr>
      <td width="28%" height="36" class="fieldname"> Delivered Date </td>
      <td width="39%" height="36">
		<html:text property="deliveredDate"/><a href="#" onClick="showCalendar(this,document.DieselPurchaseForm.deliveredDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.DieselPurchaseForm.deliveredDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
      <td width="28%" height="36" class="fieldname">Additional Amount</td>
      <td width="80%" height="36"><font size="3" face="Times New Roman">
		<html:text property="additionalAmount" onchange="totalamount()"/></font></td>
    </tr>
    <tr>
      <td width="28%" height="36" class="fieldname"> Goods Type</td>
      <td width="39%" height="36"><font size="3" face="Times New Roman">
		<html:text property="goodsType"/></font></td>
      <td width="28%" height="36" class="fieldname">Delivery Amount</td>
      <td width="80%" height="36"><font size="3" face="Times New Roman">
		<html:text property="deliveryAmount" onchange="totalamount()"/></font></td>
      
    </tr>
    <tr>
      <td width="28%" height="36" class="fieldname">Company Name</td>
      <td width="39%" height="36"><font size="3" face="Times New Roman">
		<html:text property="companyName"/></font></td>
      <td width="28%" height="35"><font face="Times New Roman" size="3" class="fieldname">Delivery 
		Vehicle Number</font></td>
      <td width="80%" height="35"><font size="3" face="Times New Roman">
		<html:text property="deliveryVehicleNo"/></font></td>
    </tr>
    <tr>
      <td width="28%" height="35" class="fieldname">Place</td>
      <td width="39%" height="35" class="fieldname">
      <html:text property="place"/></td>
      <td width="28%" height="36"><font size="3" face="Times New Roman" class="fieldname">Driver 
		Name</font></td>
      <td width="80%" height="36"><font size="3" face="Times New Roman">
		<html:text property="driverName"/></font></td>
    </tr>
    <tr>
      <td width="28%" height="36"><font size="3" face="Times New Roman" class="fieldname">Load Number</font></td>
      <td width="39%" height="36"><font size="3" face="Times New Roman"><html:text property="loadNo"/></font></td>
      <td width="28%" height="29" class="fieldname">Total Amount</td>
      <td width="80%" height="29"><font size="3" face="Times New Roman">
		<html:text property="totalAmount"/></font></td>
    </tr>
     <tr>
      <td width="28%" height="29">Quantity </td>
      <td width="39%" height="29"><font size="3" face="Times New Roman"><html:text property="qtyPurchased"/></font></td>
      <td width="28%" height="33"><font size="3" face="Times New Roman" class="fieldname">Delivery 
		Time</font></td>
      <td width="80%" height="33"><font size="3" face="Times New Roman">
		<html:text property="deliveryTime"/></font></td>
    </tr>
     <tr>
      <td width="28%" height="33"> Rate Per Unit</td>
      <td width="39%" height="33"><html:text property="unitPrice" onchange="amt()"/></td>
      <td width="28%" height="33"><font face="Times New Roman" size="3" class="fieldname">Tip 
		Scale</font></td>
      <td width="80%" height="33"><font size="3" face="Times New Roman"><html:text property="tipScale"/></font></td>
    </tr>
     <tr>
      <td width="28%" height="5">Amount </td>
      <td width="39%" height="33"><html:text property="amount" /></td>
      
    </tr>
    <tr>
      <td width="28%" height="21">&nbsp;</td>
      <td width="39%" height="21">&nbsp;</td>
      <td width="28%" height="21">&nbsp;</td>
      <td width="79%" height="21">&nbsp;</td>
    </tr>
    <tr>
    	
      <td width="187%" height="39" colspan="4">
		<p align="center">
        <img border="0" src="<%=request.getContextPath()%>/images/SAVE.jpg" onclick="save()" >
		<img border="0" src="<%=request.getContextPath()%>/images/SUB TO EO.jpg">
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" >
		</td>
      
	
    </tr>
    <tr>
    <td>
    <html:file  property="fileName" size ="10"></html:file><img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" onclick="javascript:upload()">
			</td>
			
			<td>
            <html:select property="imageName" style="width:100" >
			<logic:present property="imagelist" name="DieselRequisitionForm">	
			<bean:define id="imagelist" name="DieselRequisitionForm" property="imagelist" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Image"></html:option>
			<html:options collection="imagelist" property="id" labelProperty="imageName"></html:options>
			</logic:present>
			</html:select></td>
			
			<!--<td><% if (session.getAttribute("combo_display")=="true") { %>
			<html:text property="qtyNeeded"  style="width:113"/>
			<% } %>
			</td>-->
		</tr>		
		<tr>
		<td>
		<img border="0" src="<%=request.getContextPath()%>/images/EDIT.jpg" onclick="javascript:edit()" >
		<img border="0" src="<%=request.getContextPath()%>/images/DELETE.jpg" onclick="javascript:del()" >
		<img border="0" src="<%=request.getContextPath()%>/images/VIEW.jpg" onclick="javascript:imageview()">
		<>
		</tr>
  </table>
<p align="center">&nbsp;</p>
</html:form>
			
			
</body>
</html:html>