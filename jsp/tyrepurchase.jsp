<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/issues.do";
%>
<html:html>
	<head>
		<title>issues</title>
	</head>
	<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>


<script>
function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrepurchase.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
function placelist()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrepurchase.do?invoke=fetchplacelist";	
		document.forms[0].submit();
	}
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrepurchase.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function savedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrepurchase.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrepurchase.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function canceldone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrepurchase.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	function vatpercent()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrepurchase.do?invoke=vatpercentMethod";	
		document.forms[0].submit();
	}
		function amount()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrepurchase.do?invoke=amountMethod";	
		document.forms[0].submit();
	}

</script>

<body> 
		<html:form action="tyrepurchase" enctype="multipart/form-data">
	
	<table border="0" width="991" id="table1" height="608">
	<tr>
	<td height="94" width="1046">
            
            <table border="0" width="100%">
              <tr>
                <td width="25%">&nbsp;</td>
                <td width="20%">&nbsp;<img border="0" src="<%=request.getContextPath()%>/images/tyre details.jpg" align="right"></td>
                <td width="30%">&nbsp;<b><font size="3" class="maintitle">TYRE DETAILS</font></b></td>
                <td width="25%">&nbsp;</td>
              </tr>
            </table>
    </td>
			
		</tr>
				
		
    <td width="962" height="506">
				
		
		      <table border="0" width="1056" height="488" id="table2">
                <tr>
                  <td width="20" height="40">&nbsp;</td>
                  <td width="123" height="40">Bill Date</td>
                  <td width="233" height="40"><html:text property="billDate"  style="width:100"/>
                   <a href="#" onClick="showCalendar(this,document.TyrePurchaseForm.billDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.TyrePurchaseForm.billDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
								<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
						</a>

                  </td>
                  <td width="95" height="40">Bill Number</td>
                  <td width="126" height="40"><html:text property="billNo"  style="width:100"/></td>
                  <td width="160" height="40">Delivered Date</td>
                  <td width="255" height="40"> 
					<html:text property="deliveredDate"  style="width:100"/> 
					 <a href="#" onClick="showCalendar(this,document.TyrePurchaseForm.deliveredDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.TyrePurchaseForm.deliveredDate,'anchor03','dd MMM yyyy'); return false;" NAME="anchor04" ID="anchor04">
								<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
						</a>
					 </td>  
				  </tr>
				  
                <tr>
                  <td width="20" height="40">&nbsp;</td>
                  <td width="123" height="40">Company Name</td>
                  <td width="233" height="40">
                  
                  
                   <html:select property="companyName" size="1" onchange="placelist()">
			<logic:present property="companyNameList" name="TyrePurchaseForm">	
			<bean:define id="companyNameList" name="TyrePurchaseForm" property="companyNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SELECT COMPANY"></html:option>
			<html:options collection="companyNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>  
                  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <img border="0" src="<%=request.getContextPath()%>/images/ADD.jpg" width="60" height="18"></td>
                  <td width="95" height="40">Place</td>
                  <td width="126" height="40"> 
                  
					<html:select property="place" size="1">
			<logic:present property="placeList" name="TyrePurchaseForm">	
			<bean:define id="placeList" name="TyrePurchaseForm" property="placeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SELECT PLACE"></html:option>
			<html:options collection="placeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
					
					</td>
                  <td width="160" height="40">Part number</td>
                  <td width="255" height="40">
                  <html:text property="partNo"  style="width:100"/> 
                  </td>
                </tr>
                
                <tr>
                  <td width="1012" height="366" colspan="7">
 
            <table border="1" width="100%" id="table3">
        <tr>
          <td width="33" align="center" height="32" class="fieldname"><b>S.No</b></td>
          <td width="148" align="center" height="32" class="fieldname"><b>Tyre Type</b></td>
          <td width="107" align="center" height="32" class="fieldname"><b>Tyre Size</b></td>
          <td width="88" align="center" height="32" class="fieldname"><b>Tyre Ply</b></td>
          <td width="93" align="center" height="32" class="fieldname"><b>Tyre
            Parts</b></td>
          <td width="114" align="center" height="32" class="fieldname"><b>Tyre
            Number</b></td>
          <td width="64" align="center" height="32" class="fieldname"><b>Rate</b></td>
          <td width="52" align="center" height="32" class="fieldname"><b>VAT</b>
			<b>%</b></td>
          <td width="52" align="center" height="32" class="fieldname"><b>VAT</b>
			<b>Amount</b></td>
          <td width="80" align="center" height="32" class="fieldname"><b>
			Additional</b> <b>Amount</b></td>
          <td width="84" align="center" height="32" class="fieldname"><b>Amount</b></td>
        </tr>
                 
         <tr>
          <td width="33" align="center" class="fieldname">1.</td>
          <td width="148" align="center">
          
            <html:select property="tyreType1" size="1" >
			<logic:present property="tyreTypeList" name="TyrePurchaseForm">	
			<bean:define id="tyreTypeList" name="TyrePurchaseForm" property="tyreTypeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="BRAND"></html:option>
			<html:options collection="tyreTypeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="107" align="center">
            <p align="center">
            
            <html:select property="tyreSize1" size="1" >
			<logic:present property="tyreSizeList" name="TyrePurchaseForm">	
			<bean:define id="tyreSizeList" name="TyrePurchaseForm" property="tyreSizeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SIZE"></html:option>
			<html:options collection="tyreSizeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="88" align="center">
			
			<html:select property="tyrePly1" size="1" >
			<logic:present property="tyrePlyList" name="TyrePurchaseForm">	
			<bean:define id="tyrePlyList" name="TyrePurchaseForm" property="tyrePlyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PLY"></html:option>
			<html:options collection="tyrePlyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="93" align="center">
          
            <html:select property="tyreParts1" size="1" multiple="true">
			<logic:present property="tyrePartsList" name="TyrePurchaseForm">	
			<bean:define id="tyrePartsList" name="TyrePurchaseForm" property="tyrePartsList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PARTS"></html:option>
			<html:options collection="tyrePartsList" property="des" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          
<td width="114" align="center"><html:text property="tyreNo1"  style="width:113"/></td>
          <td width="64" align="center">
			<html:text property="tyreRate1"  style="width:50"/></td>
           <td width="52" align="center">
			<html:text property="VATPercent1"  style="width:50" onchange="vatpercent()"/></td>    
         
       
            <td width="52" align="center">
			<html:text property="VATAmount1"  style="width:70"/></td>
               
  			<td width="80" align="center">
			<html:text property="additionalAmt1"  style="width:70"/></td>
			 <td width="84" align="center">
			<html:text property="amount1"  style="width:70" onfocus="amount()"/></td>       
        </tr>
        
          <tr>
          <td width="33" align="center" class="fieldname">2.</td>
          <td width="148" align="center">
          
          <html:select property="tyreType2" size="1" >
			<logic:present property="tyreTypeList" name="TyrePurchaseForm">	
			<bean:define id="tyreTypeList" name="TyrePurchaseForm" property="tyreTypeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="BRAND"></html:option>
			<html:options collection="tyreTypeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="107" align="center">
          
          <html:select property="tyreSize2" size="1" >
			<logic:present property="tyreSizeList" name="TyrePurchaseForm">	
			<bean:define id="tyreSizeList" name="TyrePurchaseForm" property="tyreSizeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SIZE"></html:option>
			<html:options collection="tyreSizeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="88" align="center">
          
			<html:select property="tyrePly2" size="1" >
			<logic:present property="tyrePlyList" name="TyrePurchaseForm">	
			<bean:define id="tyrePlyList" name="TyrePurchaseForm" property="tyrePlyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PLY"></html:option>
			<html:options collection="tyrePlyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
           <td width="93" align="center">
           
           <html:select property="tyreParts2" size="1" multiple="true">
			<logic:present property="tyrePartsList" name="TyrePurchaseForm">	
			<bean:define id="tyrePartsList" name="TyrePurchaseForm" property="tyrePartsList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PARTS"></html:option>
			<html:options collection="tyrePartsList" property="des" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="114" align="center">
			<html:text property="tyreNo2"  style="width:113"/></td>
          <td width="64" align="center">
			<html:text property="tyreRate2"  style="width:50"/></td>
          <td width="52" align="center">
			<html:text property="VATPercent2"  style="width:50" onchange="vatpercent()"/></td>
          <td width="52" align="center">
			<html:text property="VATAmount2"  style="width:70"/></td>
          <td width="80" align="center">
		<html:text property="additionalAmt2"  style="width:70"/></td>
          <td width="84" align="center">
			<html:text property="amount2"  style="width:70" onfocus="amount()"/></td>
        </tr>
        <tr>
          <td width="33" align="center" class="fieldname">3.</td>
          <td width="148" align="center">
          
          <html:select property="tyreType3" size="1" >
			<logic:present property="tyreTypeList" name="TyrePurchaseForm">	
			<bean:define id="tyreTypeList" name="TyrePurchaseForm" property="tyreTypeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="BRAND"></html:option>
			<html:options collection="tyreTypeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="107" align="center">
          
            <html:select property="tyreSize3" size="1" >
			<logic:present property="tyreSizeList" name="TyrePurchaseForm">	
			<bean:define id="tyreSizeList" name="TyrePurchaseForm" property="tyreSizeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SIZE"></html:option>
			<html:options collection="tyreSizeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="88" align="center">
          
			<html:select property="tyrePly3" size="1" >
			<logic:present property="tyrePlyList" name="TyrePurchaseForm">	
			<bean:define id="tyrePlyList" name="TyrePurchaseForm" property="tyrePlyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PLY"></html:option>
			<html:options collection="tyrePlyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="93" align="center">
          
           <html:select property="tyreParts3" size="1" multiple="true">
			<logic:present property="tyrePartsList" name="TyrePurchaseForm">	
			<bean:define id="tyrePartsList" name="TyrePurchaseForm" property="tyrePartsList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PARTS"></html:option>
			<html:options collection="tyrePartsList" property="des" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
           <td width="114" align="center">
			<html:text property="tyreNo3"  style="width:113"/></td>
          <td width="64" align="center">
			<html:text property="tyreRate3"  style="width:50"/></td>
          <td width="52" align="center">
			<html:text property="VATPercent3"  style="width:50" onchange="vatpercent()"/></td>
          <td width="52" align="center">
			<html:text property="VATAmount3"  style="width:70"/></td>
          <td width="80" align="center">
		<html:text property="additionalAmt3"  style="width:70"/></td>
          <td width="84" align="center">
			<html:text property="amount3"  style="width:70" onfocus="amount()"/></td>
        </tr>
        <tr>
          <td width="33" align="center" height="27" class="fieldname">4.</td>
          <td width="148" align="center" height="27">
          
        <html:select property="tyreType4" size="1" >
			<logic:present property="tyreTypeList" name="TyrePurchaseForm">	
			<bean:define id="tyreTypeList" name="TyrePurchaseForm" property="tyreTypeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="BRAND"></html:option>
			<html:options collection="tyreTypeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="107" align="center" height="27">
          
			 <html:select property="tyreSize4" size="1" >
			<logic:present property="tyreSizeList" name="TyrePurchaseForm">	
			<bean:define id="tyreSizeList" name="TyrePurchaseForm" property="tyreSizeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SIZE"></html:option>
			<html:options collection="tyreSizeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="88" align="center" height="27">
          
			<html:select property="tyrePly4" size="1" >
			<logic:present property="tyrePlyList" name="TyrePurchaseForm">	
			<bean:define id="tyrePlyList" name="TyrePurchaseForm" property="tyrePlyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PLY"></html:option>
			<html:options collection="tyrePlyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="93" align="center" height="27">
          
            <html:select property="tyreParts4" size="1" multiple="true">
			<logic:present property="tyrePartsList" name="TyrePurchaseForm">	
			<bean:define id="tyrePartsList" name="TyrePurchaseForm" property="tyrePartsList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PARTS"></html:option>
			<html:options collection="tyrePartsList" property="des" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="114" align="center" height="27">
			<html:text property="tyreNo4"  style="width:113"/></td>
          <td width="64" align="center" height="27">
			<html:text property="tyreRate4"  style="width:50"/></td>
          <td width="52" align="center" height="27">
			<html:text property="VATPercent4"  style="width:50" onchange="vatpercent()"/></td>
          <td width="52" align="center" height="27">
			<html:text property="VATAmount4"  style="width:70"/></td>
          <td width="80" align="center" height="27">
			<html:text property="additionalAmt4"  style="width:70"/></td>
          <td width="84" align="center" height="27">
			<html:text property="amount4"  style="width:70" onfocus="amount()"/></td>
        </tr>
         <tr>
          <td width="33" align="center" height="27" class="fieldname">5.</td>
          <td width="148" align="center" height="27">
          
          <html:select property="tyreType5" size="1" >
			<logic:present property="tyreTypeList" name="TyrePurchaseForm">	
			<bean:define id="tyreTypeList" name="TyrePurchaseForm" property="tyreTypeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="BRAND"></html:option>
			<html:options collection="tyreTypeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>

          <td width="107" align="center" height="27">
          
			<html:select property="tyreSize5" size="1" >
			<logic:present property="tyreSizeList" name="TyrePurchaseForm">	
			<bean:define id="tyreSizeList" name="TyrePurchaseForm" property="tyreSizeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SIZE"></html:option>
			<html:options collection="tyreSizeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="88" align="center" height="27">
          
			<html:select property="tyrePly5" size="1" >
			<logic:present property="tyrePlyList" name="TyrePurchaseForm">	
			<bean:define id="tyrePlyList" name="TyrePurchaseForm" property="tyrePlyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PLY"></html:option>
			<html:options collection="tyrePlyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="93" align="center" height="27">
          
             <html:select property="tyreParts5" size="1" multiple="true">
			<logic:present property="tyrePartsList" name="TyrePurchaseForm">	
			<bean:define id="tyrePartsList" name="TyrePurchaseForm" property="tyrePartsList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PARTS"></html:option>
			<html:options collection="tyrePartsList" property="des" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="114" align="center" height="27">
			<html:text property="tyreNo5"  style="width:113"/></td>
          <td width="64" align="center" height="27">
			<html:text property="tyreRate5"  style="width:50"/></td>
          <td width="52" align="center" height="27">
			<html:text property="VATPercent5"  style="width:50" onchange="vatpercent()"/></td>
          <td width="52" align="center" height="27">
			<html:text property="VATAmount5"  style="width:70"/></td>
          <td width="80" align="center" height="27">
			<html:text property="additionalAmt5"  style="width:70"/></td>
          <td width="84" align="center" height="27">
			<html:text property="amount5"  style="width:70" onfocus="amount()"/></td>
        </tr>
        
         <tr>
          <td width="33" align="center" height="27" class="fieldname">6.</td>
          <td width="148" align="center" height="27">
          <html:select property="tyreType6" size="1" >
			<logic:present property="tyreTypeList" name="TyrePurchaseForm">	
			<bean:define id="tyreTypeList" name="TyrePurchaseForm" property="tyreTypeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="BRAND"></html:option>
			<html:options collection="tyreTypeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            </td>

          <td width="107" align="center" height="27">
          <html:select property="tyreSize6" size="1" >
			<logic:present property="tyreSizeList" name="TyrePurchaseForm">	
			<bean:define id="tyreSizeList" name="TyrePurchaseForm" property="tyreSizeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SIZE"></html:option>
			<html:options collection="tyreSizeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            </td>
          <td width="88" align="center" height="27">
          <html:select property="tyrePly6" size="1" >
			<logic:present property="tyrePlyList" name="TyrePurchaseForm">	
			<bean:define id="tyrePlyList" name="TyrePurchaseForm" property="tyrePlyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PLY"></html:option>
			<html:options collection="tyrePlyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            </td>
          <td width="93" align="center" height="27">
          <html:select property="tyreParts6" size="1" multiple="true">
			<logic:present property="tyrePartsList" name="TyrePurchaseForm">	
			<bean:define id="tyrePartsList" name="TyrePurchaseForm" property="tyrePartsList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PARTS"></html:option>
			<html:options collection="tyrePartsList" property="des" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            </td>
          <td width="114" align="center" height="27">
          <html:text property="tyreNo6"  style="width:113"/>
          </td>
          <td width="64" align="center" height="27">
          <html:text property="tyreRate6"  style="width:50"/>
          </td>
          <td width="52" align="center" height="27">
          <html:text property="VATPercent6"  style="width:50" onchange="vatpercent()"/>
          </td>
          <td width="52" align="center" height="27">
          <html:text property="VATAmount6"  style="width:70"/>
          </td>
          <td width="80" align="center" height="27">
          <html:text property="additionalAmt6"  style="width:70"/>
          </td>
          <td width="84" align="center" height="27">
          <html:text property="amount6"  style="width:70" onfocus="amount()"/>
          </td>
        </tr>
        
         <tr>
          <td width="33" align="center" height="27" class="fieldname">7.</td>
          <td width="148" align="center" height="27">
          <html:select property="tyreType7" size="1" >
			<logic:present property="tyreTypeList" name="TyrePurchaseForm">	
			<bean:define id="tyreTypeList" name="TyrePurchaseForm" property="tyreTypeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="BRAND"></html:option>
			<html:options collection="tyreTypeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            </td>

          <td width="107" align="center" height="27">
           <html:select property="tyreSize7" size="1" >
			<logic:present property="tyreSizeList" name="TyrePurchaseForm">	
			<bean:define id="tyreSizeList" name="TyrePurchaseForm" property="tyreSizeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SIZE"></html:option>
			<html:options collection="tyreSizeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            </td>
          <td width="88" align="center" height="27">
          <html:select property="tyrePly7" size="1" >
			<logic:present property="tyrePlyList" name="TyrePurchaseForm">	
			<bean:define id="tyrePlyList" name="TyrePurchaseForm" property="tyrePlyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PLY"></html:option>
			<html:options collection="tyrePlyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            </td>
          <td width="93" align="center" height="27">
           <html:select property="tyreParts7" size="1" multiple="true">
			<logic:present property="tyrePartsList" name="TyrePurchaseForm">	
			<bean:define id="tyrePartsList" name="TyrePurchaseForm" property="tyrePartsList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PARTS"></html:option>
			<html:options collection="tyrePartsList" property="des" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            </td>
          <td width="114" align="center" height="27">
            <html:text property="tyreNo7"  style="width:113"/>
          </td>
          <td width="64" align="center" height="27">
          <html:text property="tyreRate7"  style="width:50"/>
          </td>
          <td width="52" align="center" height="27">
           <html:text property="VATPercent7"  style="width:50" onchange="vatpercent()"/>
          </td>
          <td width="52" align="center" height="27">
           <html:text property="VATAmount7"  style="width:70"/>
          </td>
          <td width="80" align="center" height="27">
            <html:text property="additionalAmt7"  style="width:70"/>
          </td>
          <td width="84" align="center" height="27">
           <html:text property="amount7"  style="width:70" onfocus="amount()"/>
          </td>
        </tr>
        
         <tr>
          <td width="33" align="center" height="27" class="fieldname">8.</td>
          <td width="148" align="center" height="27">
           <html:select property="tyreType8" size="1" >
			<logic:present property="tyreTypeList" name="TyrePurchaseForm">	
			<bean:define id="tyreTypeList" name="TyrePurchaseForm" property="tyreTypeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="BRAND"></html:option>
			<html:options collection="tyreTypeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            </td>

          <td width="107" align="center" height="27">
          <html:select property="tyreSize8" size="1" >
			<logic:present property="tyreSizeList" name="TyrePurchaseForm">	
			<bean:define id="tyreSizeList" name="TyrePurchaseForm" property="tyreSizeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SIZE"></html:option>
			<html:options collection="tyreSizeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            </td>
          <td width="88" align="center" height="27">
          <html:select property="tyrePly8" size="1" >
			<logic:present property="tyrePlyList" name="TyrePurchaseForm">	
			<bean:define id="tyrePlyList" name="TyrePurchaseForm" property="tyrePlyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PLY"></html:option>
			<html:options collection="tyrePlyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            </td>
          <td width="93" align="center" height="27">
           <html:select property="tyreParts8" size="1" multiple="true">
			<logic:present property="tyrePartsList" name="TyrePurchaseForm">	
			<bean:define id="tyrePartsList" name="TyrePurchaseForm" property="tyrePartsList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PARTS"></html:option>
			<html:options collection="tyrePartsList" property="des" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            </td>
          <td width="114" align="center" height="27">
            <html:text property="tyreNo7"  style="width:113"/>
          </td>
          <td width="64" align="center" height="27">
          <html:text property="tyreRate8"  style="width:50"/>
          </td>
          <td width="52" align="center" height="27">
           <html:text property="VATPercent8"  style="width:50" onchange="vatpercent()"/>
          </td>
          <td width="52" align="center" height="27">
          <html:text property="VATAmount8"  style="width:70"/>
          </td>
          <td width="80" align="center" height="27">
          <html:text property="additionalAmt8"  style="width:70"/>
          </td>
          <td width="84" align="center" height="27">
           <html:text property="amount8"  style="width:70" onfocus="amount()"/>
          </td>
        </tr>
        
        </table>
	
    <p style="text-align: center">
     <img border="0" src="<%=request.getContextPath()%>/images/SAVE.jpg" onclick="javascript:save()">
    <img border="0" src="<%=request.getContextPath()%>/images/SUB TO EO.jpg" >
    <img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" >
        <img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" >
       

    &nbsp;&nbsp;&nbsp;
</p>
                  </td>
                </tr>
                <tr>
 
            <td width="20" height="1">
</html:form>
      </table>
        </table>
</body>
</html:html>