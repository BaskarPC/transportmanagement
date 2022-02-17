<%@ include file="/include/taglibs.jsp"%>

<html:html>
	<head>
	<title>General Note Form</title>
	</head>
	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
<script language="JavaScript">
function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/general.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function savedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/generalnote.do?invoke=jobMethod";	
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
<html:form action="generalnote" enctype="multipart/form-data">

	<table border="0" width="99%" cellspacing="7" cellpadding="7" height="452">
	
	<tr>
    	<td width="25%" height="40">
     	 <p align="center" class="maintitle">
		</td>
    	<td width="9%" height="40">
      	<p align="right">
		&nbsp;</td>
    	<td width="9%" height="40" class="maintitle">
		<img border="0" src="<%=request.getContextPath()%>/images/general%20note.jpg" align="right"></td>
    	<td width="57%" height="40" class="maintitle">GENERAL NOTE</td>
    	<td width="2%"></td>
     </tr>

  	<tr>
    <td width="97%" height="94" colspan="5" align="center">
      <table border="0" width="80%" id="table4" height="75">
		<tr>
		</tr>

		<tr>
			<td width="99">
			<p>&nbsp;Bill Date</td>
			<td width="166"><html:text property="billDate" style="width:113"/>
			<a href="#" onClick="showCalendar(this,document.GeneralNoteForm.billDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.GeneralNoteForm.billDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
								<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
						</a>
</td>
			<td width="110">
			<p align="left">Bill Number&nbsp;</td>
			<td width="197">
			<html:text property="billNo" style="width:113"/></td>
			<td width="84">
			Goods Type</td>
			<td>
			<html:text property="goodsType" style="width:113"/></td>
		</tr>
		<tr>
			<td width="99">
			<p align="left">&nbsp;Delivered Date</td>
			<td width="166"><html:text property="deliveredDate" style="width:113"/>
			<a href="#" onClick="showCalendar(this,document.GeneralNoteForm.deliveredDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.GeneralNoteForm.deliveredDate,'anchor03','dd MMM yyyy'); return false;" NAME="anchor04" ID="anchor04">
								<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
						</a>

			</td>
			<td width="110">
			Company Name</td>
			<td width="197">
			<html:text property="companyName" style="width:113"/>&nbsp;&nbsp;
			<img border="0" src="<%=request.getContextPath()%>/images/ADD.jpg" width="60" height="18"></td>
			<td width="84">
			Place</td>
			<td><html:text property="place" style="width:113"/></td>
		</tr>
		</table>
    </td>
  </tr>
   <tr>
    <td width="97%" height="176" colspan="5" align="center">
      <table border="1" width="79%">
        <tr>
          <td width="5%" align="center" class="fieldname" height="28"><b>S.No</b></td>
          <td width="35%" align="center" class="fieldname" height="28"><b>Item 
			Description</b></td>
          <td width="21%" align="center" height="28">
            <p class="fieldname"><b>Quantity Purchased</b></td>
          <td width="20%" align="center" class="fieldname" height="28"><b>Unit Price</b></td>
          <td width="17%" align="center" class="fieldname" height="28"><b>Amount</b></td>
        </tr>
        
          <tr>
  <td width="5%" align="center" class="fieldname">1.</td>
          <td width="35%" align="center">
			<html:select property="itemDes1" size="1" >
                    <html:option value="0"> - - Choose Type - -</html:option>
          <html:option value="1">Asian</html:option>
          <html:option value="2">Rubilux</html:option>
            </html:select></td>
          <td width="21%" align="center"><html:text property="qtyPurchased1" style="width:113"/></td>
          <td width="20%">
			<p align="center"><html:text property="unitPrice1" style="width:113"/></td>
          <td width="17%">
			<p align="center"><html:text property="amount1"  style="width:113"/></td>
        </tr>
         
         <tr>
  <td width="5%" align="center" class="fieldname">1.</td>
          <td width="35%" align="center">
			<html:select property="itemDes2" size="1" >
                    <html:option value="0"> - - Choose Type - -</html:option>
          <html:option value="1">Asian</html:option>
          <html:option value="2">Rubilux</html:option>
            </html:select></td>
          <td width="21%" align="center"><html:text property="qtyPurchased1" style="width:113"/></td>
          <td width="20%">
			<p align="center"><html:text property="unitPrice1" style="width:113"/></td>
          <td width="17%">
			<p align="center"><html:text property="amount1"  style="width:113"/></td>
        </tr>
         <tr>
  <td width="5%" align="center" class="fieldname">1.</td>
          <td width="35%" align="center">
			<html:select property="itemDes3" size="1" >
                    <html:option value="0"> - - Choose Type - -</html:option>
          <html:option value="1">Asian</html:option>
          <html:option value="2">Rubilux</html:option>
            </html:select></td>
          <td width="21%" align="center"><html:text property="qtyPurchased3" style="width:113"/></td>
          <td width="20%">
			<p align="center"><html:text property="unitPrice3" style="width:113"/></td>
          <td width="17%">
			<p align="center"><html:text property="amount3"  style="width:113"/></td>
        </tr>

    <tr>
  <td width="5%" align="center" class="fieldname">1.</td>
          <td width="35%" align="center">
			<html:select property="itemDes4" size="1" >
                    <html:option value="0"> - - Choose Type - -</html:option>
          <html:option value="1">Asian</html:option>
          <html:option value="2">Rubilux</html:option>
            </html:select></td>
          <td width="21%" align="center"><html:text property="qtyPurchased4" style="width:113"/></td>
          <td width="20%">
			<p align="center"><html:text property="unitPrice4" style="width:113"/></td>
          <td width="17%">
			<p align="center"><html:text property="amount4"  style="width:113"/></td>
        </tr>
         <tr>
  <td width="5%" align="center" class="fieldname">1.</td>
          <td width="35%" align="center">
			<html:select property="itemDes5" size="1" >
                    <html:option value="0"> - - Choose Type - -</html:option>
          <html:option value="1">Asian</html:option>
          <html:option value="2">Rubilux</html:option>
            </html:select></td>
          <td width="21%" align="center"><html:text property="qtyPurchased5" style="width:113"/></td>
          <td width="20%">
			<p align="center"><html:text property="unitPrice5" style="width:113"/></td>
          <td width="17%">
			<p align="center"><html:text property="amount5"  style="width:113"/></td>
        </tr>
         </table>
   <tr>
    <td width="97%" height="40" colspan="5">
      <table border="0" width="89%" id="table5">
		<tr>
			<td>
			<p align="right">Total Amount</td>
			<td width="118">
			<p align="center"><html:text property="totalAmount" style="width:113"/></p></td>
		</tr>
		</table>
	</td>
     </tr>
     <tr>
    <td width="97%" height="46" colspan="5" align="center">
			
	<img border="0" src="<%=request.getContextPath()%>/images/SAVE.jpg">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg">
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg">
		
     </tr>        
      
</table>
</html:form>
</body>
</html:html>
