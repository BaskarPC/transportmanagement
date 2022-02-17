<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/scrapissue.do";
%>

<html:html>
	<head>
		<title>Scrap Issue Form</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/scrapissue.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/scrapissue.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/scrapissue.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/scrapissue.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	
</script>

<body> 
<html:form action="scrapissue" enctype="multipart/form-data">


<table border="0" width="100%" id="table1" cellspacing="5" cellpadding="5">
<tr>
    <td width="25%" colspan="2" height="55">
      <p align="center">&nbsp;</td>
    <td width="18%" height="55" colspan="3">
      <p align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/scraps.jpg" width="40" height="40"></td>
    <td width="59%" height="55" colspan="3" class="maintitle">SCRAP ISSUE</td>
  </tr>
	<tr>
		<td width="24%">&nbsp;</td>
		<td width="21%" colspan="7">&nbsp;</td>
		
		
	</tr>
	<tr>
		<td width="24%">&nbsp;</td>
		<td width="6%" colspan="2">&nbsp;</td>
		<td width="10%" colspan="2" class="fieldname">Date</td>
		<td width="5%">&nbsp;</td>
		<td width="20%"><html:text property="requestedDate" style="width:113"/>
		  <a href="#" onClick="showCalendar(this,document.ScrapIssueForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.ScrapIssueForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
		<td width="22%">&nbsp;</td>
	</tr>
	<tr>
		<td width="24%">&nbsp;</td>
		<td width="6%" colspan="2">&nbsp;</td>
		<td width="11%" colspan="2" class="fieldname">Company</td>
		<td width="5%">&nbsp;</td>
		<td width="20%"><html:text property="companyName" style="width:113"/></td>
		<td width="22%">&nbsp;</td>
	</tr>
	<tr>
		<td width="24%"></td>
		<td width="6%" colspan="2">&nbsp;</td>
		<td width="3%" colspan="2" class="fieldname">Bill Number</td>
		<td width="2%">&nbsp;</td>
		<td width="16%"><html:text property="billNumber" style="width:113"/></td>
		<td width="22%"></td>
	</tr>
	<tr>
		<td width="24%">&nbsp;</td>
		<td width="6%" colspan="2">&nbsp;</td>
		<td width="3%" colspan="2" class="fieldname">Category</td>
		<td width="2%">&nbsp;</td>
		<td width="16%">
	
		<html:select property="categoryName">
		     <html:option value="0"> - - Choose A Category - -</html:option>
             <html:option value="1">Steel</html:option>
             <html:option value="2">Aluminium</html:option>  
              <html:option value="1">Copper</html:option>
             <html:option value="2">Clutch Blade</html:option>  
             <html:option value="1">Plastic</html:option>
             <html:option value="2">Bearing</html:option>  
              <html:option value="1">Brass</html:option>
   	</html:select>
		</td>
		<td width="22%">&nbsp;</td>
	</tr>
	<tr>
		<td width="24%" height="21"></td>
		<td width="6%" colspan="2" height="21">&nbsp;</td>
		<td width="3%" colspan="2" height="21" class="fieldname">Available Quantity</td>
		<td width="2%" height="21">&nbsp;</td>
		<td width="16%" height="21">
		<html:text property="availableQuantity" style="width:113"/></td>
		<td width="22%" height="21"></td>
	</tr>
	<tr>
		<td width="24%">&nbsp;</td>
		<td width="6%" colspan="2">&nbsp;</td>
		<td width="3%" colspan="2" class="fieldname">Quantity Sold</td>
		<td width="2%">&nbsp;</td>
		<td width="16%"><html:text property="quantitySold" style="width:113"/></td>
		<td width="22%">&nbsp;</td>
	</tr>
	<tr>
		<td width="24%" height="31">&nbsp;</td>
		<td width="6%" colspan="2" height="31">&nbsp;</td>
		<td width="3%" colspan="2" height="31" class="fieldname">Remaining Quantity </td>
		<td width="2%" height="31">&nbsp;</td>
		<td width="16%" height="31">
		<html:text property="remainingQuantity" style="width:113"/></td>
		<td width="22%" height="31">&nbsp;</td>
	</tr>
	<tr>
		<td width="24%">&nbsp;</td>
		<td width="21%" colspan="7">&nbsp;</td>
		
	
	</tr>
	<tr>
		<td width="24%">&nbsp;</td>
		<td width="26%" colspan="3">&nbsp;</td>
		<td width="34%" colspan="3">
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18"></td>
		<td width="6%">&nbsp;</td>
	
		
	</tr>
	
</table>

</html:form>

</body>

</html:html>
