<%@ include file="/include/taglibs.jsp"%>


<%
	String url =  request.getContextPath()+"/paintsparepurchase.do";
%>
<html:html>
	<head>
		<title>Paint Spare Purchase Form</title>
	</head>
<script>
function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparepurchase.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparepurchasevalidate.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparepurchase.do?invoke=okMethod";	
		document.forms[0].submit();
	}
function listpartNumber1()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparepurchase.do?invoke=partNumberMethod1";	
		document.forms[0].submit();
	}
	function listpartNumber2()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparepurchase.do?invoke=partNumberMethod2";	
		document.forms[0].submit();
	}
	function listpartNumber3()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparepurchase.do?invoke=partNumberMethod3";	
		document.forms[0].submit();
	}
	function listpartNumber4()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparepurchase.do?invoke=partNumberMethod4";	
		document.forms[0].submit();
	}
	function listpartNumber5()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparepurchase.do?invoke=partNumberMethod5";	
		document.forms[0].submit();
	}
	function availableQuantity1()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparepurchase.do?invoke=quantityMethod1";	
		document.forms[0].submit();
	}
	function availableQuantity2()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparepurchase.do?invoke=quantityMethod2";	
		document.forms[0].submit();
	}
	function availableQuantity3()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparepurchase.do?invoke=quantityMethod3";	
		document.forms[0].submit();
	}
	function availableQuantity4()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparepurchase.do?invoke=quantityMethod4";	
		document.forms[0].submit();
	}
	function availableQuantity5()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/paintsparepurchase.do?invoke=quantityMethod5";	
		document.forms[0].submit();
	}
</script>
<body> 
<html:form action="paintsparepurchase" enctype="multipart/form-data">

<table width="100%" align="center">
		<tr>
			<td align="center" width="950" height="60" colspan="4">
			<table border="0" width="876" height="56">
				<tr>
					<td width="426" height="52">
			<img border="0" src="<%=request.getContextPath()%>/images/paint.jpg" align="right" ></td>
					<td class="maintitle" height="52" width="444">Paint/Spare Parts Details</td>
				</tr>
			</table>
			</td>
			
			
		</tr>
        <tr>
			<td width="101" height="110">
			
&nbsp;</td>
			<td width="5" height="110">
			
&nbsp;</td>
			<td width="1100" height="110" colspan="2">
			<table border="0" width="100%" height="80" align="center">
				<tr>
					<td height="76" width="846">
                    <table border="0" width="104%" height="63" id="table9" align="center">
                      <tr>
                        <td width="16%" height="23">&nbsp;Bill Date</td>
                        <td width="25%" height="23"><html:text property="billDate"/></td>
                        <td width="16%" height="23">&nbsp;Bill Number</td>
                        <td width="12%" height="23"><html:text property="billNo"/></td>
                        <td width="12%" height="23">Delivered Date</td>
                        <td width="16%" height="23">&nbsp;<html:text property="deliveredDate"/></td>
                      </tr>
                      <tr>
                        <td width="16%" height="34">Company Name</td>
                        <td width="25%" height="34">
                        
                        
                        <html:select property="companyName">
                            
                            <html:option value="0">-- Company --</html:option>
                            <html:option value="1">cinamman</html:option>
                            <html:option value="2">sri</html:option>
							<html:option value="1">lakshmi</html:option>                                                                                              
                        </html:select>
                        
                         
						<img border="0" src="<%=request.getContextPath()%>/images/ADD.jpg" width="60" height="18"></td>
                        <td width="16%" height="34">&nbsp;Place</td>
                        <td width="12%" height="34"> <html:select property="place">
                            
                            <html:option value="0">-- Company --</html:option>
                            <html:option value="1">Erode</html:option>
                            <html:option value="2">Namakkal</html:option>
							<html:option value="1">Salem</html:option>                                                                                              
                        </html:select>
                        </td>
                        <td width="12%" height="34">Type</td>
                        <td width="16%" height="34">&nbsp;
                        
                        
                        <html:select property="itemDes">
                            
                            <html:option value="0">-- select --</html:option>
                            <html:option value="1">Paint</html:option>
                            <html:option value="2">Spare Parts</html:option>
                                                                                              
                        </html:select>
                      
            </td>
                      </tr>
                    </table>
                    </td>
				</tr>
				</table>
			</td>
        </tr>
        <tr>
					
			<table border="1" width="50%" id="table7" align="center">
        <tr>
          <td width="6%" align="center" height="32" class="fieldname"><b>S.No</b></td>
          <td width="19%" align="center" height="32" class="fieldname"><b>Brand 
			Name</b></td>
          <td width="22%" align="center" height="32" class="fieldname"><b>Brand 
			Type</b></td>
          <td width="15%" align="center" height="32" class="fieldname"><b>Part Number</b></td>
          <td width="8%" align="center" height="32" class="fieldname"><b>Availability</b></td>
          <td width="8%" align="center" height="32" class="fieldname"><b>Quantity Purchased</b></td>
          <td width="8%" align="center" height="32" class="fieldname"><b>Unit Rate</b></td>
          <td width="6%" align="center" height="32" class="fieldname"><b>VAT %</b></td>
          <td width="8%" align="center" height="32" class="fieldname"><b>VAT</b>
			<b>Amount</b></td>
          <td width="8%" align="center" height="32" class="fieldname"><b>
			Additional</b> <b>Amount</b></td>
          <td width="7%" align="center" height="32" class="fieldname"><b>Amount</b></td>
        </tr>
        <tr>
          <td width="6%" align="center">1.</td>
          <td width="19%" align="center">
          
          <html:select property="brandName1" style="width:150">
							<logic:present property="typeList" name="PaintSparepartsPurchaseForm">	
								<bean:define id="typeList" name="PaintSparepartsPurchaseForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
            
            </td>
          <td width="22%" align="center">
          <html:select property="brandType1" style="width:150" onchange="javascript:listpartNumber1()">
							<logic:present property="typeList" name="PaintSparepartsPurchaseForm">	
								<bean:define id="typeList" name="PaintSparepartsPurchaseForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
         
            
            </td>
          <td width="15%" align="center">
            <p align="center">
            <html:select property="partNo1" style="width:150" onchange="javascript:availableQuantity1()">
							<logic:present property="partList1" name="PaintSparepartsPurchaseForm">	
								<bean:define id="partList1" name="PaintSparepartsPurchaseForm" property="partList1" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="partList1" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select>
                
            </td>
          <td width="5%" align="center">
			<html:text property="availableQty1" style="width:60"/></td>
          <td width="8%" align="center">
			<html:text property="qtyPurchased1" style="width:60"/></td>
          <td width="8%" align="center">
			<html:text property="unitPrice1" style="width:100"/></td>
          <td width="6%" align="center">
			<html:text property="vatPercent1" style="width:60"/></td>
          <td width="8%" align="center">
			<html:text property="vatAmount1" style="width:100"/></td>
          <td width="8%" align="center">
			<html:text property="additionalAmount1" style="width:100"/></td>
          <td width="7%" align="center">
			<html:text property="amount1" style="width:100"/></td>
        </tr>
        <tr>
          <td width="6%" align="center">2.</td>
          <td width="19%" align="center">
           
          <html:select property="brandName2" style="width:150" onchange="javascript:listpartNumber2()">
							<logic:present property="typeList" name="PaintSparepartsPurchaseForm">	
								<bean:define id="typeList" name="PaintSparepartsPurchaseForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
            
            </td>
          <td width="22%" align="center">
          <html:select property="brandType2" style="width:150" onchange="javascript:listpartNumber2()">
							<logic:present property="typeList" name="PaintSparepartsPurchaseForm">	
								<bean:define id="typeList" name="PaintSparepartsPurchaseForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
         
            </td>
          <td width="15%" align="center">
          
           <html:select property="partNo2" style="width:150" onchange="javascript:availableQuantity2()">
							<logic:present property="partList2" name="PaintSparepartsPurchaseForm">	
								<bean:define id="partList2" name="PaintSparepartsPurchaseForm" property="partList2" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="partList2" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select>
			
            </td>
          <td width="5%" align="center">
			<html:text property="availableQty2" style="width:60"/></td>
          <td width="8%" align="center">
			<html:text property="qtyPurchased2" style="width:60"/></td>
          <td width="8%" align="center">
			<html:text property="unitPrice2" style="width:100"/></td>
          <td width="6%" align="center">
			<html:text property="vatPercent2" style="width:60"/></td>
          <td width="8%" align="center">
			<html:text property="vatAmount2" style="width:100"/></td>
          <td width="8%" align="center">
			<html:text property="additionalAmount2" style="width:100"/></td>
          <td width="7%" align="center">
			<html:text property="amount2" style="width:100"/></td>
        </tr>
        
        
        
        
        
        <tr>
          <td width="6%" align="center" class="fieldname">3.</td>
          <td width="19%" align="center">
           
          <html:select property="brandName3" style="width:150" onchange="javascript:listpartNumber3()">
							<logic:present property="typeList" name="PaintSparepartsPurchaseForm">	
								<bean:define id="typeList" name="PaintSparepartsPurchaseForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
            </td>
          <td width="22%" align="center">
           <html:select property="brandType3" style="width:150" onchange="javascript:listpartNumber3()">
							<logic:present property="typeList" name="PaintSparepartsPurchaseForm">	
								<bean:define id="typeList" name="PaintSparepartsPurchaseForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
         
            </td>
          <td width="15%" align="center">
           <html:select property="partNo3" style="width:150" onchange="javascript:availableQuantity3()">
							<logic:present property="partList3" name="PaintSparepartsPurchaseForm">	
								<bean:define id="partList3" name="PaintSparepartsPurchaseForm" property="partList3" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="partList3" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
			           	</html:select>
            </td>
          <td width="5%" align="center">
			<html:text property="availableQty3" style="width:60"/></td>
          <td width="8%" align="center">
			<html:text property="qtyPurchased3" style="width:60"/></td>
          <td width="8%" align="center">
			<html:text property="unitPrice3" style="width:100"/></td>
          <td width="6%" align="center">
			<html:text property="vatPercent3" style="width:60"/></td>
          <td width="8%" align="center">
			<html:text property="vatAmount3" style="width:100"/></td>
          <td width="8%" align="center">
			<html:text property="additionalAmount3" style="width:100"/></td>
          <td width="7%" align="center">
			<html:text property="amount3" style="width:100"/></td>
        </tr>
        
        
        <tr>
          <td width="6%" align="center" height="27">4.</td>
          <td width="19%" align="center" height="27">
           
          <html:select property="brandName4" style="width:150" onchange="javascript:listpartNumber4()">
							<logic:present property="typeList" name="PaintSparepartsPurchaseForm">	
								<bean:define id="typeList" name="PaintSparepartsPurchaseForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
            </td>
          <td width="22%" align="center" height="27">
          <html:select property="brandType4" style="width:150" onchange="javascript:listpartNumber4()">
							<logic:present property="typeList" name="PaintSparepartsPurchaseForm">	
								<bean:define id="typeList" name="PaintSparepartsPurchaseForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
          
            </td>
          <td width="15%" align="center" height="27">
          <html:select property="partNo4" style="width:150" onchange="javascript:availableQuantity4()">
							<logic:present property="partList4" name="PaintSparepartsPurchaseForm">	
								<bean:define id="partList4" name="PaintSparepartsPurchaseForm" property="partList4" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="partList4" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select>
			           
            </td>
          <td width="5%" align="center" height="27">
			<html:text property="availableQty4" style="width:60"/></td>
          <td width="8%" align="center" height="27">
			<html:text property="qtyPurchased4" style="width:60"/></td>
          <td width="8%" align="center" height="27">
			<html:text property="unitPrice4" style="width:100"/></td>
          <td width="6%" align="center" height="27">
		<html:text property="vatPercent4" style="width:60"/></td>
          <td width="8%" align="center" height="27">
			<html:text property="vatAmount4" style="width:100"/></td>
          <td width="8%" align="center" height="27">
			<html:text property="additionalAmount4" style="width:100"/></td>
          <td width="7%" align="center" height="27">
			<html:text property="amount4" style="width:100"/></td>
        </tr>
        
        
        <tr>
          <td width="6%" align="center" class="fieldname">5.</td>
          <td width="19%" align="center">
           
          <html:select property="brandName5" style="width:150" onchange="javascript:listpartNumber5()">
							<logic:present property="typeList" name="PaintSparepartsPurchaseForm">	
								<bean:define id="typeList" name="PaintSparepartsPurchaseForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
            </td>
          <td width="22%" align="center">
          <html:select property="brandType5" style="width:150" onchange="javascript:listpartNumber5()">
							<logic:present property="typeList" name="PaintSparepartsPurchaseForm">	
								<bean:define id="typeList" name="PaintSparepartsPurchaseForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="typeList" property="spareId" labelProperty="spareType"></html:options>
							</logic:present>
						</html:select>
          
            </td>
          <td width="15%" align="center">
          <html:select property="partNo5" style="width:150" onchange="javascript:availableQuantity5()">
							<logic:present property="partList5" name="PaintSparepartsPurchaseForm">	
								<bean:define id="partList5" name="PaintSparepartsPurchaseForm" property="partList5" type="java.util.Collection" ></bean:define>
								<html:option value="0">--Choose Spare--</html:option>
								<html:options collection="partList5" property="spareId" labelProperty="spareNumber"></html:options>
							</logic:present>
						</html:select>
       
            
            </td>
          <td width="5%" align="center">
			<html:text property="availableQty5" style="width:60"/></td>
          <td width="8%" align="center">
			<html:text property="qtyPurchased5" style="width:60"/></td>
          <td width="8%" align="center">
			<html:text property="unitPrice5" style="width:100"/></td>
          <td width="6%" align="center">
			<html:text property="vatPercent5" style="width:60"/></td>
          <td width="8%" align="center">
			<html:text property="vatAmount5" style="width:100"/></td>
          <td width="8%" align="center">
			<html:text property="additionalAmount5" style="width:100"/></td>
          <td width="7%" align="center">
			<html:text property="amount5" style="width:100"/></td>
			</tr>
        	</table>
        	<table border="0" width="104%" height="63" id="table9" align="center">
                      <tr>
                        <td width="16%" height="23">&nbsp;</td>
                        <td width="25%" height="23"></td>
                        <td width="16%" height="23">&nbsp;</td>
                        <td width="12%" height="23">Total Amount</td>
                        <td width="12%" height="23"><html:text property="totalAmount"/></td>
                        <td width="16%" height="23">&nbsp;</td>
                      </tr>
                      </table>
          
	<p style="text-align: center">
	
	<img border="0" src="<%=request.getContextPath()%>/images/SAVE.jpg" width="60" height="18" onclick="javascript:okdone()">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="javascript:submitdone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18" onclick="javascript:issuedone()">
        <img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18" onclick="javascript:approvedone()">&nbsp;

	
	
	
</html:form>
</body>
</html:html>		
			


