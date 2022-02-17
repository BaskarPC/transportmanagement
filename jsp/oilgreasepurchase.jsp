<%@ include file="/include/taglibs.jsp"%>

<html:html>
	<head>
	<title>General Note Form</title>
	</head>
	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
<script>

<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
<script>
function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/greaseoil.do?invoke=saveMethod";	
		document.forms[0].submit();
	}

function placelist()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/greaseoil.do?invoke=fetchplacelist";	
		document.forms[0].submit();
	}
	
	function vatpercent()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/greaseoil.do?invoke=vatpercentMethod";	
		document.forms[0].submit();
	}
		function amount()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/greaseoil.do?invoke=amountMethod";	
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
	
	function totalamount()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/greaseoil.do?invoke=totalamountMethod";	
		document.forms[0].submit();
	}
	
	function availableqty()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/greaseoil.do?invoke=availableQtyMethod";	
		document.forms[0].submit();
	}
</script>
<body>
<html:form action="greaseoil" enctype="multipart/form-data">
	<table border="0" width="969" id="table1" height="259">
<tr>
			<td colspan="5" width="100" height="46">
			</td>
			<td colspan="8" width="856" height="46">
			<table border="0" width="100%" id="table5">
				<tr>
					<td width="293">
				&nbsp;</td>
					<td class="maintitle">&nbsp;</td>
				</tr>
				<tr>
					<td width="293">
				<img border="0" src="<%=request.getContextPath()%>/images/oil_grease%20pur.jpg" align="right"></td>
					<td class="maintitle">GREASE/OIL PURCHASE FORM</td>
				</tr>
				<tr>
					<td width="293">
				&nbsp;</td>
					<td class="maintitle">&nbsp;</td>
				</tr>
			</table>
			</td>
		</tr>
		
				
		<tr>
			<td width="99" colspan="4" height="13"></td>
			<td width="824" colspan="9" height="13">
			<table border="0" width="101%" id="table6" height="96">
				<tr>
					<td width="128">Bill Date</td>
					<td width="207">
			<html:text property="billDate" style="width:113"/>
			<a href="#" onClick="showCalendar(this,document.greaseOilForm.billDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.greaseOilForm.billDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
								<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
						</a>

</td>
					<td width="106">
					<p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Bill No</td>
					<td width="124">
			<html:text property="billNumber" style="width:113"/></td>
					<td width="107">
					<p align="center">Delivered Date</td>
					<td>
		<html:text property="deliveredDate" style="width:113"/>				</tr>
		
				<tr>
					<td width="128">Company Name </td>
					<td width="207">
			<html:select property="companyName" size="1" onchange="placelist()">
			<logic:present property="companyNameList" name="OilGreasePurchaseForm">	
			<bean:define id="companyNameList" name="OilGreasePurchaseForm" property="companyNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SELECT COMPANY"></html:option>
			<html:options collection="companyNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<img border="0" src="<%=request.getContextPath()%>/images/ADD.jpg" width="60" height="18"></td>
					<td width="106">
					<p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Place</td>
					<td width="124">
			<html:select property="place" size="1">
			<logic:present property="placeList" name="OilGreasePurchaseForm">	
			<bean:define id="placeList" name="OilGreasePurchaseForm" property="placeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SELECT PLACE"></html:option>
			<html:options collection="placeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select></td>
					<td width="107">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="128">Type</td>
					<td width="207">
					
					<html:select property="reqItem" size="1" >
           <logic:present property="itemDesList" name="OilGreasePurchaseForm" >	
			<bean:define id="itemDesList" name="OilGreasePurchaseForm" property="itemDesList" type="java.util.Collection" >
			</bean:define>	
			<html:option value=""></html:option>
			<html:options collection="itemDesList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select></td>
					<td width="106">
					<p align="center">&nbsp;Part Number</td>
					<td width="124">
			<html:text property="partNo" style="width:113"/></td>
					<td width="107">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td colspan="3" width="68" height="17"></td>
			<td colspan="10" width="908" height="17"></td>
		</tr>
		<tr>
			<td width="88" height="182"></td>
			<td colspan="12" width="908" height="182">
            <table border="1" width="100%" height="127">
        <tr>
          <td width="35" align="center" height="32"><b>S.No</b></td>
          <td width="174" align="center" height="32"><b>Brand Name</b></td>
          <td width="197" align="center" height="32"><b>Category</b></td>
          <td width="60" align="center" height="32"><b>Availability</b></td>
          <td width="68" align="center" height="32"><b>Quantity Purchased</b></td>
          <td width="57" align="center" height="32"><b>Unit&nbsp; Rate</b></td>
          <td width="48" align="center" height="32"><b>VAT </b> &nbsp;%</td>
          <td width="70" align="center" height="32"><b>VAT&nbsp;&nbsp; Amount</b></td>
          <td width="60" align="center" height="32"><b>Additional Amount</b></td>
          <td width="72" align="center" height="32"><b>Amount</b></td>
        </tr>
        <tr>
          <td width="35" align="center">1.</td>
          <td width="174" align="center">
            
            <html:select property="brandName1" size="1" >
              <logic:present property="brandNameList" name="OilGreasePurchaseForm">	
			<bean:define id="brandNameList" name="OilGreasePurchaseForm" property="brandNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandName"></html:option>
			<html:options collection="brandNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
				</html:select>
			</td>
          <td width="197" align="center">
             <html:select property="brandType1" size="1" >             
            <logic:present property="brandCategoryList" name="OilGreasePurchaseForm">	
			<bean:define id="brandCategoryList" name="OilGreasePurchaseForm" property="brandCategoryList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandType"></html:option>
			<html:options collection="brandCategoryList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select></td>
          <td width="60" align="center"><html:text property="availableQty1" style="width:50" onclick="availableqty()" /></td>
          <td width="68" align="center">
			<html:text property="qtyPurchased1" style="width:50"/></td>
          <td width="57" align="center">
			<html:text property="unitRate1" style="width:50"/></td>
			<td width="48" align="center">
			<html:text property="vatPercent1" style="width:50" onchange="vatpercent()"/></td>
          <td width="70" align="center">
			<html:text property="vatAmount1" style="width:70"/></td>
          <td width="60" align="center">
			<html:text property="additionalAmount1" style="width:70"/></td>
          <td width="72" align="center">
			<html:text property="amount1" style="width:70" onfocus="amount()"/></td>
        </tr>
        <tr>
          <td width="35" align="center">2.</td>
          <td width="174" align="center">
            
            <html:select property="brandName2" size="1" >
              <logic:present property="brandNameList" name="OilGreasePurchaseForm">	
			<bean:define id="brandNameList" name="OilGreasePurchaseForm" property="brandNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandName"></html:option>
			<html:options collection="brandNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
				</html:select></td>
          <td width="197" align="center">
               <html:select property="brandType2" size="1" >             
            <logic:present property="brandCategoryList" name="OilGreasePurchaseForm">	
			<bean:define id="brandCategoryList" name="OilGreasePurchaseForm" property="brandCategoryList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandType"></html:option>
			<html:options collection="brandCategoryList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select></td>

         <td width="60" align="center"><html:text property="availableQty2" style="width:50" onclick="availableqty()"/></td>
          <td width="68" align="center">
			<html:text property="qtyPurchased2" style="width:50"/></td>
          <td width="57" align="center">
			<html:text property="unitRate2" style="width:50"/></td>
			<td width="48" align="center">
			<html:text property="vatPercent2" style="width:50" onchange="vatpercent()"/></td>

         <td width="70" align="center">
			<html:text property="vatAmount2" style="width:70"/></td>
          <td width="60" align="center">
			<html:text property="additionalAmount2" style="width:70"/></td>
          <td width="72" align="center">
			<html:text property="amount2" style="width:70" onfocus="amount()"/></td>
        </tr>
        <tr>
          <td width="35" align="center">3.</td>
          <td width="174" align="center">
              <html:select property="brandName3" size="1" >
              <logic:present property="brandNameList" name="OilGreasePurchaseForm">	
			<bean:define id="brandNameList" name="OilGreasePurchaseForm" property="brandNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandName"></html:option>
			<html:options collection="brandNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
				</html:select></td>
          <td width="197" align="center">
              <html:select property="brandType3" size="1" >             
            <logic:present property="brandCategoryList" name="OilGreasePurchaseForm">	
			<bean:define id="brandCategoryList" name="OilGreasePurchaseForm" property="brandCategoryList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandType"></html:option>
			<html:options collection="brandCategoryList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select></td>
         <td width="60" align="center"><html:text property="availableQty3" style="width:50" onclick="availableqty()"/></td>
          <td width="68" align="center">
			<html:text property="qtyPurchased3" style="width:50"/></td>
          <td width="57" align="center">
			<html:text property="unitRate3" style="width:50"/></td>
			<td width="48" align="center">
			<html:text property="vatPercent3" style="width:50" onchange="vatpercent()"/></td>

          <td width="70" align="center">
			<html:text property="vatAmount3" style="width:70"/></td>
          <td width="60" align="center">
			<html:text property="additionalAmount3" style="width:70"/></td>
          <td width="72" align="center">
			<html:text property="amount3" style="width:70" onfocus="amount()"/></td>
        </tr>
        <tr>
          <td width="35" align="center" height="27">4.</td>
          <td width="174" align="center" height="27">
           <html:select property="brandName4" size="1" >
              <logic:present property="brandNameList" name="OilGreasePurchaseForm">	
			<bean:define id="brandNameList" name="OilGreasePurchaseForm" property="brandNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandName"></html:option>
			<html:options collection="brandNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
				</html:select></td>
          <td width="197" align="center">
             <html:select property="brandType4" size="1" >             
            <logic:present property="brandCategoryList" name="OilGreasePurchaseForm">	
			<bean:define id="brandCategoryList" name="OilGreasePurchaseForm" property="brandCategoryList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandType"></html:option>
			<html:options collection="brandCategoryList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select></td>
         <td width="60" align="center"><html:text property="availableQty4" style="width:50" onclick="availableqty()"/></td>
          <td width="68" align="center">
			<html:text property="qtyPurchased4" style="width:50"/></td>
          <td width="57" align="center">
			<html:text property="unitRate4" style="width:50"/></td>
			<td width="48" align="center">
			<html:text property="vatPercent4" style="width:50" onchange="vatpercent()"/></td>

          <td width="70" align="center">
			<html:text property="vatAmount4" style="width:70"/></td>
          <td width="60" align="center">
			<html:text property="additionalAmount4" style="width:70"/></td>
          <td width="72" align="center">
			<html:text property="amount4" style="width:70" onfocus="amount()"/></td>
        </tr>
        <tr>
          <td width="35" align="center">5.</td>
          <td width="174" align="center">
            <html:select property="brandName5" size="1" >
              <logic:present property="brandNameList" name="OilGreasePurchaseForm">	
			<bean:define id="brandNameList" name="OilGreasePurchaseForm" property="brandNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandName"></html:option>
			<html:options collection="brandNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
				</html:select></td>
          <td width="197" align="center">
              <html:select property="brandType5" size="1" >             
            <logic:present property="brandCategoryList" name="OilGreasePurchaseForm">	
			<bean:define id="brandCategoryList" name="OilGreasePurchaseForm" property="brandCategoryList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandType"></html:option>
			<html:options collection="brandCategoryList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select></td>
          <td width="60" align="center"><html:text property="availableQty5" style="width:50" onclick="availableqty()"/></td>
          <td width="68" align="center">
			<html:text property="qtyPurchased5" style="width:50"/></td>
          <td width="57" align="center">
			<html:text property="unitRate5" style="width:50"/></td>
		<td width="48" align="center">
			<html:text property="vatPercent5" style="width:50" onchange="vatpercent()"/></td>
	
		          <td width="70" align="center">
			<html:text property="vatAmount5" style="width:70"/></td>
          <td width="60" align="center">
			<html:text property="additionalAmount5" style="width:70"/></td>
          <td width="72" align="center">
			<html:text property="amount5" style="width:70" onfocus="amount()"/></td>
			</tr>
			
			 <tr>
          <td width="35" align="center">6.</td>
          <td width="174" align="center">
              <html:select property="brandName6" size="1" >
              <logic:present property="brandNameList" name="OilGreasePurchaseForm">	
			<bean:define id="brandNameList" name="OilGreasePurchaseForm" property="brandNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandName"></html:option>
			<html:options collection="brandNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
				</html:select></td>
          <td width="197" align="center">
              <html:select property="brandType6" size="1" >             
            <logic:present property="brandCategoryList" name="OilGreasePurchaseForm">	
			<bean:define id="brandCategoryList" name="OilGreasePurchaseForm" property="brandCategoryList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandType"></html:option>
			<html:options collection="brandCategoryList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select></td>
         <td width="60" align="center"><html:text property="availableQty6" style="width:50" onclick="availableqty()"/></td>
          <td width="68" align="center">
			<html:text property="qtyPurchased6" style="width:50"/></td>
          <td width="57" align="center">
			<html:text property="unitRate6" style="width:50"/></td>
			<td width="48" align="center">
			<html:text property="vatPercent6" style="width:50" onchange="vatpercent()"/></td>

          <td width="70" align="center">
			<html:text property="vatAmount6" style="width:70" /></td>
          <td width="60" align="center">
			<html:text property="additionalAmount6" style="width:70"/></td>
          <td width="72" align="center">
			<html:text property="amount6" style="width:70" onfocus="amount()"/></td>
        </tr>
        <tr>
          <td width="35" align="center" height="27">7.</td>
          <td width="174" align="center" height="27">
           <html:select property="brandName7" size="1" >
              <logic:present property="brandNameList" name="OilGreasePurchaseForm">	
			<bean:define id="brandNameList" name="OilGreasePurchaseForm" property="brandNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandName"></html:option>
			<html:options collection="brandNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
				</html:select></td>
          <td width="197" align="center">
             <html:select property="brandType7" size="1" >             
            <logic:present property="brandCategoryList" name="OilGreasePurchaseForm">	
			<bean:define id="brandCategoryList" name="OilGreasePurchaseForm" property="brandCategoryList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandType"></html:option>
			<html:options collection="brandCategoryList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select></td>
         <td width="60" align="center"><html:text property="availableQty7" style="width:50" onclick="availableqty()"/></td>
          <td width="68" align="center">
			<html:text property="qtyPurchased7" style="width:50"/></td>
          <td width="57" align="center">
			<html:text property="unitRate7" style="width:50"/></td>
			<td width="48" align="center">
			<html:text property="vatPercent7" style="width:50" onchange="vatpercent()"/></td>

          <td width="70" align="center">
			<html:text property="vatAmount7" style="width:70" /></td>
          <td width="60" align="center">
			<html:text property="additionalAmount7" style="width:70"/></td>
          <td width="72" align="center">
			<html:text property="amount7" style="width:70" onfocus="amount()"/></td>
        </tr>
        <tr>
          <td width="35" align="center">8.</td>
          <td width="174" align="center">
            <html:select property="brandName8" size="1" >
              <logic:present property="brandNameList" name="OilGreasePurchaseForm">	
			<bean:define id="brandNameList" name="OilGreasePurchaseForm" property="brandNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandName"></html:option>
			<html:options collection="brandNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
				</html:select></td>
          <td width="197" align="center">
              <html:select property="brandType8" size="1" >             
            <logic:present property="brandCategoryList" name="OilGreasePurchaseForm">	
			<bean:define id="brandCategoryList" name="OilGreasePurchaseForm" property="brandCategoryList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select BrandType"></html:option>
			<html:options collection="brandCategoryList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select></td>
          <td width="60" align="center"><html:text property="availableQty8" style="width:50" onclick="availableqty()"/></td>
          <td width="68" align="center">
			<html:text property="qtyPurchased8" style="width:50"/></td>
          <td width="57" align="center">
			<html:text property="unitRate8" style="width:50"/></td>
		<td width="48" align="center">
			<html:text property="vatPercent8" style="width:50" onchange="vatpercent()"/></td>
	
		          <td width="70" align="center">
			<html:text property="vatAmount8" style="width:70"/></td>
          <td width="60" align="center">
			<html:text property="additionalAmount8" style="width:70"/></td>
          <td width="72" align="center">
			<html:text property="amount8" style="width:70" onfocus="amount()"/></td>
			</tr>
		</table></td>
		</tr>
		<tr>
			<td colspan="2" width="98" height="1"></td>
			<td colspan="5" width="176" height="1"></td>
			<td width="165" height="1"></td>
			<td width="48" height="1"></td>
			<td colspan="2" width="57" height="1"></td>
			<td width="170" height="1"></td>
			<td width="359" height="1"></td>
		</tr>
		<tr>
			<td colspan="13" width="963" height="11">
			<table border="0" width="100%" id="table4">
				<tr>
					<td width="13%">
					&nbsp;</td>
					<td width="63%">
					&nbsp;</td>
					<td width="16%">
			<p align="center">Total Amount </td>
					<td width="7%">
			<p align="left">
			<html:text property="totalAmount" style="width:70" onfocus="totalamount()"/></td>
				</tr>
				<tr>
					<td width="13%">
					&nbsp;</td>
					<td colspan="2">
					<p align="center">
<img border="0" src="<%=request.getContextPath()%>/images/SAVE.jpg" onclick="javascript:save()">
 
		<img border="0" src="<%=request.getContextPath()%>/images/SUB TO EO.jpg" onclick="javascript:submittoEO()">&nbsp;
		
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" >
		
	
	
		<img border="0" src="<%=request.getContextPath()%>/images/CLOSE.jpg"></td>
					<td width="7%">
			&nbsp;</td>
				</tr>
			</table>
			</td>
		</tr>
		</table>

		</td>
	
		</p>
</html:form>
</body>

</html:html>