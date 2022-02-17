<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/passingbill.do";
%>

<html:html>
	<head>
		<title>Passing Bill Form</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/passingbill.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/passingbill.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/passingbill.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/passingbill.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	
	function selectType()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/passingbill.do?invoke=goodstypeMethod";	
		document.forms[0].submit();
	}
	function selectBillNumber()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/passingbill.do?invoke=billnumberMethod";	
		document.forms[0].submit();
	}
	function selectServiceStation()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/passingbill.do?invoke=servicestationMethod";	
		document.forms[0].submit();
	}
</script>

<body> 
<html:form action="passingbill" enctype="multipart/form-data">
<table border="0" width="100%" cellspacing="10" cellpadding="10" height="388">
<tr>
    <td width="21%" height="55">
      <p align="center">&nbsp;</td>
    <td width="12%" height="55">
      <p align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/bill.jpg" width="40" height="40"></td>
    <td width="25%" colspan="2" height="55" class="maintitle">PASSING BILL</td>
    <td width="50%" colspan="2" height="55">
      &nbsp;</td>
  </tr>
 <tr>
    <td width="21%">&nbsp;</td>
    <td width="42%" colspan="3">&nbsp;</td>
    <td width="50%" colspan="2">&nbsp;</td>
  </tr>
 <tr>
    <td width="21%"></td>
    <td width="21%" colspan="2" class="fieldname">Date</td>
    <td width="16%"><html:text property="requestedDate" style="width:113"/>
      <a href="#" onClick="showCalendar(this,document.PassingBillForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.PassingBillForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
    <td width="41%" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="21%">&nbsp;</td>
    <td width="21%" colspan="2" class="fieldname">Passing Bill Bill number</td>
    <td width="7%"><html:text property="billNumber" style="width:113"/></td>
    <td width="50%" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="21%">&nbsp;</td>
    <td width="21%" colspan="2" class="fieldname">Purchase / Issue</td>
    <td width="7%">
    <html:select property="purchaseIssue" onchange="javascript:selectType()">
		   <html:option value="0">--Choose a Type--</html:option>
					<logic:present property="purchaseissueList" name="PassingBillForm">	
					<bean:define id="purchaseissueList" name="PassingBillForm" property="purchaseissueList" type="java.util.Collection" ></bean:define>
					<html:options collection="purchaseissueList" property="purchaseissueId" labelProperty="purchaseissueDesc"></html:options>
		  </logic:present> 
   	</html:select></td>
    <td width="50%" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="21%">&nbsp;</td>
    <td width="21%" colspan="2" class="fieldname">Type of Product</td>
    <td width="7%">
    
    <html:select property="typeOfProduct" onchange="javascript:selectBillNumber()">
		     <html:option value="0">--Choose a Type--</html:option>
					<logic:present property="goodsList" name="PassingBillForm">	
					<bean:define id="goodsList" name="PassingBillForm" property="goodsList" type="java.util.Collection" ></bean:define>
					<html:options collection="goodsList" property="goodsId" labelProperty="goodsDesc"></html:options>
		  </logic:present>   
   	</html:select>
   </td>
    <td width="50%" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="21%"></td>
    <td width="21%" colspan="2" class="fieldname">Bill Number</td>
    <td width="7%">
    <html:select property="passingBillNumber" onchange="javascript:selectServiceStation()">
		     <html:option value="0">--Choose Bill Number--</html:option>
					<logic:present property="billnumberList" name="PassingBillForm">	
					<bean:define id="billnumberList" name="PassingBillForm" property="billnumberList" type="java.util.Collection" ></bean:define>
					<html:options collection="billnumberList" property="billnumberId" labelProperty="billnumberId"></html:options>  
					</logic:present>
   	</html:select>
   </td>
    <td width="50%" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="21%"></td>
    <td width="21%" colspan="2" class="fieldname">Name of the Institution</td>
    <td width="7%"><html:text property="institutionName" style="width:113"/></td>
    <td width="50%" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="21%"></td>
    <td width="21%" colspan="2" class="fieldname">Vehicle Number</td>
    <td width="7%"><html:text property="vehicleNumber" style="width:113"/></td>
    <td width="50%" colspan="2">&nbsp;</td>
  </tr>
<tr>
		<td width="21%"></td>
		<td width="21%" colspan="2" class="fieldname">Location of the Service 
		Station</td>
		<td width="8%"><html:text property="serviceStationLocation" style="width:113"/></td>
		<td width="50%" colspan="2">&nbsp;</td>
</tr>
<tr>
		<td width="21%">&nbsp;</td>
		<td width="21%" colspan="2" class="fieldname">Name of the Service 
		Station</td>
		<td width="8%"><html:text property="serviceName" style="width:113"/></td>
		<td width="50%" colspan="2">&nbsp;</td>
</tr>
  <tr>
    <td width="21%"></td>
    <td width="21%" colspan="2" class="fieldname">Bill Date</td>
    <td width="7%"><html:text property="billDate" style="width:113"/></td>
    <td width="50%" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="21%"></td>
    <td width="21%" colspan="2" class="fieldname">Head of Account debit</td>
    <td width="7%"><html:text property="headOfAccountDebit" style="width:113"/></td>
    <td width="50%" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="21%"></td>
    <td width="21%" colspan="2" class="fieldname">Bill Amount</td>
    <td width="7%"><html:text property="billAmount" style="width:113"/></td>
    <td width="50%" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="21%"></td>
    <td width="42%" colspan="3"></td>
    <td width="25%"></td>
    <td width="25%"></td>
  </tr>
  <tr>
    <td width="21%"></td>
    <td width="42%" colspan="3"></td>
    <td width="25%"></td>
    <td width="25%"></td>
  </tr>
<tr>
		<td width="21%">&nbsp;</td>
		<td width="77%" colspan="5">
		<p align="left">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" onclick="javascript:cleardone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" onclick="javascript:submitdone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" onclick="javascript:approvedone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" onclick="javascript:issuedone()"></td>
</tr>
</table>
</html:form>
</body>
</html:html>