
<%@ include file="/include/taglibs.jsp"%>


<%
	String url =  request.getContextPath()+"/oilgreaserequisition.do";
%>
<html:html>
	<head>
		<title>Grease and Oil Requisition Form</title>
	</head>
<script>
	function approve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oilgreaserequisition.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	function availableqty()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oilgreaserequisition.do?invoke=availableQtyMethod";	
		document.forms[0].submit();
	}
	
	function ok()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oilgreaserequisition.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	
	function submittoEO()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oilgreaserequisitionvalidate.do?invoke=jobMethod";	
		document.forms[0].submit();
	}

	function brandname()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oilgreaserequisition.do?invoke=brandnameMethod";	
		document.forms[0].submit();
	}
	function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oilgreaserequisition.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	function itemreq()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/oilgreaserequisition.do?invoke=itemReqMethod";	
		document.forms[0].submit();
	}
	function purchase()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/greaseoil.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}
	
	</script>
<body> 
		<html:form action="oilgreaserequisition" enctype="multipart/form-data">
		<table border="0" width="945" cellpadding="7" cellspacing="7" height="693">
    
 
		<tr>
    <td width="76" height="21"></td>
    <td width="12" height="21"></td>
			<td width="356" height="21" colspan="4"></td>
			<td height="21" width="373" colspan="2"></td>
        </tr>
  <tr>
    <td width="76" height="42">&nbsp;</td>
    <td width="12" height="42">&nbsp;</td>
			<td width="748" height="42" colspan="6" align="center" >
            <table border="0" width="737" id="table6">
				<tr>
					<td width="210">
            <img border="0" src="<%=request.getContextPath()%>/images/oil_grease pur.jpg" align="right" class="maintitle"></td>
					<td width="513"><b><span style="font-size: 11pt">GREASE/OIL REQUISITION 
					FORM</span></b></td>
				</tr>
			</table>
	</td>
        </tr>
  <tr>
    <td width="76" height="1">&nbsp;</td>
    <td width="12" height="1">&nbsp;</td>
			<td width="37" height="1">&nbsp;</td>
			<td width="138" height="1">&nbsp;</td>
			<td width="41" height="1">&nbsp;</td>
			<td height="1" width="104">&nbsp;</td>
			<td height="1" width="373" colspan="2">&nbsp;&nbsp;</td>
        </tr>
  <tr>
    <td width="76" height="40">&nbsp;</td>
    <td width="12" height="40">&nbsp;</td>
			<td width="37" height="40" class="fieldname">Date</td>
			<td width="138" height="40"><b>
			<html:text property="date" style="width:80"/></b><a href="#" onClick="showCalendar(this,document.OilGreaseRequisitionForm.date,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.OilGreaseRequisitionForm.date,'anchor01','dd MMM yyyy'); return false;" NAME="anchor3" ID="anchor3">
								<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
						</a></td>

			<td width="41" height="40">From</td>
			<td height="40" width="104">
			<html:text property="from" style="width:80"/>
			</td>
			<td height="40" width="124" class="fieldname">Required 
			Item</td>
			<td height="40" width="249">
			 
            <html:select property="itemDes" style="width:100" onchange="javascript:itemreq()">

			<logic:present property="itemDesList" name="OilGreaseRequisitionForm">	
			<bean:define id="itemDesList" name="OilGreaseRequisitionForm" property="itemDesList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Brand"></html:option>
			<html:options collection="itemDesList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
			
			</td>
        </tr>
       
        <tr>
			<td width="76" height="21"></td>
			<td width="12" height="21"></td>
			<td height="21" colspan="6" width="724">&nbsp;</td>
        </tr>
        <tr>
			<td width="76" height="182">&nbsp;</td>
			<td width="12" height="182">&nbsp;</td>
			<td width="748" height="182" colspan="6">			
			<table border="1" width="668" id="table8">
        <tr>
          <td width="34" align="center" height="32" class="fieldname"><b>S.No</b></td>
          <td width="189" align="center" height="32" class="fieldname"><b>Brand 
			Name</b></td>
          <td width="162" align="center" height="32" class="fieldname"><b>Category</b></td>
          <td width="100" align="center" height="32" class="fieldname"><b>Availability</b></td>
          <td width="109" align="center" height="32" class="fieldname"><b>Quantity Needed</b></td>
          <td width="131" align="center" height="32" class="fieldname"><b>Approve Status</b></td>
        </tr>
        <tr>
          <td width="34" align="center" class="fieldname">1.</td>
          <td width="189" align="center">
                      
            <html:select property="brandName1">

			<logic:present property="brandNameList" name="OilGreaseRequisitionForm">	
			<bean:define id="brandNameList" name="OilGreaseRequisitionForm" property="brandNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Brand"></html:option>
			<html:options collection="brandNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
			
			
			</td>
          <td width="162" align="center">
          
          
        <html:select property="brandType1" onchange="availableqty()" >
                            
            <logic:present property="brandCategoryList" name="OilGreaseRequisitionForm">	
			<bean:define id="brandCategoryList" name="OilGreaseRequisitionForm" property="brandCategoryList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Category"></html:option>
			<html:options collection="brandCategoryList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="100" align="center">
			<html:text property="availableQty1"/></td>
			 <td width="89" align="center"><html:text property="qtyNeeded1"/></td>
          <td width="151" align="center">
            <p align="center">
            
             <html:select property="approveStatus1">
			<logic:present property="approveStatusList" name="OilGreaseRequisitionForm">	
			<bean:define id="approveStatusList" name="OilGreaseRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Status"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
              </p>
           
          </td>
         
        </tr>
        
        
               <tr>
          <td width="34" align="center" class="fieldname">2.</td>
          <td width="189" align="center">
                      
            <html:select property="brandName2" >

			<logic:present property="brandNameList" name="OilGreaseRequisitionForm">	
			<bean:define id="brandNameList" name="OilGreaseRequisitionForm" property="brandNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Brand"></html:option>
			<html:options collection="brandNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
			
			
			</td>
          <td width="162" align="center">
          
          
        <html:select property="brandType2" onchange="availableqty()">
                            
            <logic:present property="brandCategoryList" name="OilGreaseRequisitionForm">	
			<bean:define id="brandCategoryList" name="OilGreaseRequisitionForm" property="brandCategoryList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Category"></html:option>
			<html:options collection="brandCategoryList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="100" align="center">
			<html:text property="availableQty2"/></td>
			 <td width="89" align="center"><html:text property="qtyNeeded2"/></td>
			
          <td width="151" align="center">
            <p align="center">&nbsp;
            
             <html:select property="approveStatus2">
			<logic:present property="approveStatusList" name="OilGreaseRequisitionForm">	
			<bean:define id="approveStatusList" name="OilGreaseRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Status"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
              
              &nbsp;</p>
          </td>
         
        </tr>
       
        <tr>
          <td width="34" align="center" class="fieldname">3.</td>
          <td width="189" align="center">
          
           <html:select property="brandName3" >
                           <logic:present property="brandNameList" name="OilGreaseRequisitionForm">	
			<bean:define id="brandNameList" name="OilGreaseRequisitionForm" property="brandNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Brand"></html:option>
			<html:options collection="brandNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
			
			</td>
          <td width="162" align="center">
          
           <html:select property="brandType3" onchange="availableqty()">
                           <logic:present property="brandCategoryList" name="OilGreaseRequisitionForm">	
			<bean:define id="brandCategoryList" name="OilGreaseRequisitionForm" property="brandCategoryList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Category"></html:option>
			<html:options collection="brandCategoryList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="100" align="center">
			<html:text property="availableQty3"/></td>
			 <td width="89" align="center">
			<html:text property="qtyNeeded3"/></td>
			
          <td width="151" align="center">
            &nbsp;
            
            
           <html:select property="approveStatus3">
			<logic:present property="approveStatusList" name="OilGreaseRequisitionForm">	
			<bean:define id="approveStatusList" name="OilGreaseRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Status"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
              
              &nbsp;</td>
         
        </tr>
      
        <tr>
          <td width="34" align="center" height="27" class="fieldname">4.</td>
          <td width="189" align="center" height="27">
          
			<html:select property="brandName4" >
                            
                           <logic:present property="brandNameList" name="OilGreaseRequisitionForm">	
			<bean:define id="brandNameList" name="OilGreaseRequisitionForm" property="brandNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Brand"></html:option>
			<html:options collection="brandNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
			
			</td>
          <td width="162" align="center" height="27">
          
           <html:select property="brandType4" onchange="availableqty()" >
                          <logic:present property="brandCategoryList" name="OilGreaseRequisitionForm">	
			<bean:define id="brandCategoryList" name="OilGreaseRequisitionForm" property="brandCategoryList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Category"></html:option>
			<html:options collection="brandCategoryList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="100" align="center" height="27">
			<html:text property="availableQty4"/></td>
			
			 <td width="89" align="center" height="27">
			<html:text property="qtyNeeded4"/></td>
			
          <td width="151" align="center" height="27">
          
          
            <html:select property="approveStatus4">
			<logic:present property="approveStatusList" name="OilGreaseRequisitionForm">	
			<bean:define id="approveStatusList" name="OilGreaseRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Status"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
              
              
          </td>
          
          
         
        </tr>
        
        
        <tr>
          <td width="34" align="center" class="fieldname">5.</td>
          <td width="189" align="center">
          
           <html:select property="brandName5" >
                            
                           <logic:present property="brandNameList" name="OilGreaseRequisitionForm">	
			<bean:define id="brandNameList" name="OilGreaseRequisitionForm" property="brandNameList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Brand"></html:option>
			<html:options collection="brandNameList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
			
			</td>
          <td width="162" align="center">
          
           <html:select property="brandType5" onchange="availableqty()">
                            
                            <logic:present property="brandCategoryList" name="OilGreaseRequisitionForm">	
			<bean:define id="brandCategoryList" name="OilGreaseRequisitionForm" property="brandCategoryList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Category"></html:option>
			<html:options collection="brandCategoryList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="100" align="center"><html:text property="availableQty5"/></td>
          
           <td width="89" align="center">
			<html:text property="qtyNeeded5"/></td>
          <td width="151" align="center">
            
            
             <html:select property="approveStatus5">
			<logic:present property="approveStatusList" name="OilGreaseRequisitionForm">	
			<bean:define id="approveStatusList" name="OilGreaseRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Status"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
              
              </td>
         
			</tr>
        
       </table>
       <tr>
			<td width="76" height="21">&nbsp;</td>
			<td width="12" height="21">&nbsp;</td>
			<td width="748" height="21" colspan="6">			
			<b><font size="2">Required New Grease / Oil</font></b><tr>
			<td width="76" height="125">&nbsp;</td>
			<td width="12" height="125">&nbsp;</td>
			<td width="748" height="125" colspan="6">			
			<table border="1" width="670" id="table9">
				<tr>
					<td width="62" align="center"><b>S.No</b></td>
					<td align="center" width="159"><b><font size="2">Brand Name</font></b></td>
					<td align="center" width="147" ><b>Category</b></td>
					<td align="center" width="114"><b>Quantity&nbsp; Needed</b></td>
					<td align="center" width="154"><b>Approve Status</b></td>
				</tr>
				<tr>
					<td width="62" align="center">1.</td>
					<td align="center" width="159">
            <html:text property="newBrandName1"/></td>
					<td align="center" width="147">
            <html:text property="newBrandType1"/></td>
            <td align="center" width="114">
            <html:text property="newQtyNeeded1"/></td>
					<td align="center" width="154">
          
              <p>
              
              <html:select property="approveStatus6">
			<logic:present property="approveStatusList" name="OilGreaseRequisitionForm">	
			<bean:define id="approveStatusList" name="OilGreaseRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Status"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
              
              
           </p>
                    </td>
					
				</tr>
				<tr>
					<td width="62" align="center">2.</td>
					<td align="center" width="159">
             <html:text property="newBrandName2"/></td>
					<td align="center" width="147">
            <html:text property="newBrandType2"/></td>
            <td align="center" width="114">
           <html:text property="newQtyNeeded2"/></td>
					<td align="center" width="154">
           &nbsp;
           
            <html:select property="approveStatus7">
			<logic:present property="approveStatusList" name="OilGreaseRequisitionForm">	
			<bean:define id="approveStatusList" name="OilGreaseRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Status"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
           
           
           &nbsp;</td>
					
				</tr>
				<tr>
					<td width="62" align="center">3.</td>
					<td align="center" width="159">
             <html:text property="newBrandName3"/></td>
					<td align="center" width="147">
           <html:text property="newBrandType3"/></td>
           <td align="center" width="114">
            <html:text property="newQtyNeeded3"/></td>
           
					<td align="center" width="154">
          
            
               <html:select property="approveStatus8">
			<logic:present property="approveStatusList" name="OilGreaseRequisitionForm">	
			<bean:define id="approveStatusList" name="OilGreaseRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Status"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
					
				</tr>     
			</table>
			<tr>
			<td width="76" height="48">&nbsp;</td>
			<td width="12" height="48">&nbsp;</td>
			<td width="748" height="48" colspan="6">			
            &nbsp;<table border="0" width="609" id="table7">
				<tr>
					<td width="60"></td>
					<td width="535">
					<p align="center">			
		
	<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" onclick="javascript:ok()">
		<img border="0" src="<%=request.getContextPath()%>/images/SUB TO EO.jpg" onclick="javascript:submittoEO()" >
		
			<img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" onclick="javascript:approve()" >
<img border="0" src="<%=request.getContextPath()%>/images/UPDATE.jpg" onclick="javascript:purchase()">
			<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg">
		
		</p>

        			<p>&nbsp;</td>
				</tr>
	  	</table>
	</html:form>			
        </table>
</body>
</html:html>		
			


