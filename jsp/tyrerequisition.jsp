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
	function submittoEO()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/req_tyre.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function savedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/req_tyre.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function canceldone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/spare.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	function avail()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/req_tyre.do?invoke=availableMethod";	
		document.forms[0].submit();
	}
	function purchase()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/tyrepurchase.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}
	
</script>
<body> 
		<html:form action="req_tyre" enctype="multipart/form-data">
	
	<table border="0" width="960" height="91">
		<tr>
			<td colspan="7" height="2" width="924" align="left">
			</td>
		</tr>
		<tr>
			<td height="83" width="101" align="left">
				<p align="left">
			</td>
			<td height="83" width="101" colspan="2" align="left">
				&nbsp;</td>
			<td height="83" width="260">
            &nbsp;</td>
			<td height="83" width="38" align="left" >
			
			<img border="0" src="<%=request.getContextPath()%>/images/tyre%20req.jpg" align="left"></td>
		
			<td height="83" width="347" align="left" class="maintitle">
			
			<b>REQUISITION FOR TYRES</b></td>
			<td height="83" width="157" align="center">
			&nbsp;</td>
			</tr>
						
			
			<tr>

			<td width="1" height="20" align="left" colspan="2">&nbsp;</td>
			<td width="903" colspan="5" height="20">
			<table border="0" width="896">
				<tr>
					<td width="88">
					<p align="center">Date</td>
					<td width="180" >
           <html:text property="date"  style="width:113"/>
           <a href="#" onClick="showCalendar(this,document.reqTyreForm.date,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.reqTyreForm.date,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
								<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
						</a>

           </td>
					<td width="74">From</td>
					<td width="190">
            <html:text property="from"  style="width:113"/></td>
					<td width="132">Vehicle Number </td>
					<td width="194">
              <html:text property="vehicleNo"  style="width:113"/></td>
				</tr>			
				
				<tr>
					<td width="88">
					&nbsp;</td>
					<td width="180" >
           &nbsp;</td>
					<td width="74">&nbsp;</td>
					<td width="190">
            &nbsp;</td>
					<td width="132">&nbsp;</td>
					<td width="194">
              &nbsp;</td>
				</tr>			
				
			</table>
            </td>
		</tr>
				<tr>
			<td height="192" width="1" align="left" colspan="2">&nbsp;</td>
			<td colspan="5" height="192" width="903">
            <table border="1" width="96%" height="166">
        <tr>
          <td width="7%" align="center" height="30" class="fieldname"><b>S.No</b></td>
          <td width="17%" align="center" height="30" class="fieldname"><b>Tyre
            Type</b></td>
          <td width="13%" align="center" height="30" class="fieldname"><b>Tyre
            Size</b></td>
          <td width="11%" align="center" height="30" class="fieldname"><b>Tyre
            Ply</b></td>
          <td width="18%" align="center" height="30" class="fieldname"><b>Tyre&nbsp;Parts</b></td>
          <td width="11%" align="center" height="30" class="fieldname"><b>
			Available</b></td>
          <td width="14%" align="center" height="30" class="fieldname"><b>Needed&nbsp;Qty</b></td>
          <td width="21%" align="center" height="30" class="fieldname"><b>Approve
            Status</b></td>
        </tr>
        			
            <tr>
          <td width="7%" align="center" class="fieldname" height="19">1.</td>
          <td width="17%" align="center" height="19">
          
                  
              <html:select property="tyreType1" size="1" >
			<logic:present property="tyreTypeList" name="TyreRequisitionForm">	
			<bean:define id="tyreTypeList" name="TyreRequisitionForm" property="tyreTypeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="BRAND"></html:option>
			<html:options collection="tyreTypeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            
            </td>
          <td width="13%" align="center"  height="19">
            <p align="center" class="fieldname" >
                          
             <html:select property="tyreSize1" size="1" >
			<logic:present property="tyreSizeList" name="TyreRequisitionForm">	
			<bean:define id="tyreSizeList" name="TyreRequisitionForm" property="tyreSizeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SIZE"></html:option>
			<html:options collection="tyreSizeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            
            </td>
          <td width="11%" align="center" class="fieldname" height="19">
          
       
			<html:select property="tyrePly1" size="1" >
			<logic:present property="tyrePlyList" name="TyreRequisitionForm">	
			<bean:define id="tyrePlyList" name="TyreRequisitionForm" property="tyrePlyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PLY"></html:option>
			<html:options collection="tyrePlyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            
            </td>
          <td width="18%" align="center" height="19">
           
              <html:select property="tyreParts1" size="1" multiple="true">
			<logic:present property="tyrePartsList" name="TyreRequisitionForm">	
			<bean:define id="tyrePartsList" name="TyreRequisitionForm" property="tyrePartsList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PARTS"></html:option>
			<html:options collection="tyrePartsList" property="des" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="11%" align="center" height="19"> <html:text property="qtyAvailable1"  style="width:113" onclick="avail()"/></td>
          <td width="14%" align="center" height="19">
			 <html:text property="needQty1"  style="width:113"/></td>
          <td width="21%" align="center" height="19">
            
              <p>
              
             <html:select property="approveStatus1" size="1" >
			<logic:present property="approveStatusList" name="TyreRequisitionForm">	
			<bean:define id="approveStatusList" name="TyreRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="STATUS"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
              
              </p>
            
          </td>
        </tr>
           
         <tr>
          <td width="7%" align="center" class="fieldname" height="20">2.</td>
          <td width="17%" align="center" height="20" >
          
          <html:select property="tyreType2" size="1" >
			<logic:present property="tyreTypeList" name="TyreRequisitionForm">	
			<bean:define id="tyreTypeList" name="TyreRequisitionForm" property="tyreTypeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="BRAND"></html:option>
			<html:options collection="tyreTypeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="13%" align="center" class="fieldname" height="20">
          
	 <html:select property="tyreSize2" size="1" >
			<logic:present property="tyreSizeList" name="TyreRequisitionForm">	
			<bean:define id="tyreSizeList" name="TyreRequisitionForm" property="tyreSizeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SIZE"></html:option>
			<html:options collection="tyreSizeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
          	  
          	  
          	  </td>
          	<td width="11%" align="center" class="fieldname" height="20">
          	
	<html:select property="tyrePly2" size="1" >
			<logic:present property="tyrePlyList" name="TyreRequisitionForm">	
			<bean:define id="tyrePlyList" name="TyreRequisitionForm" property="tyrePlyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PLY"></html:option>
			<html:options collection="tyrePlyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
             <td width="18%" align="center" height="20">
             
		 <html:select property="tyreParts2" size="1" >
			<logic:present property="tyrePartsList" name="TyreRequisitionForm">	
			<bean:define id="tyrePartsList" name="TyreRequisitionForm" property="tyrePartsList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PARTS"></html:option>
			<html:options collection="tyrePartsList" property="des" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="11%" align="center" height="20">
			 <html:text property="qtyAvailable2"  style="width:113" onclick="avail()"/></td>
          <td width="14%" align="center" height="20">
			 <html:text property="needQty2"  style="width:113"/></td>
          <td width="21%" align="center" height="20">
          
            <html:select property="approveStatus2" size="1" >
			<logic:present property="approveStatusList" name="TyreRequisitionForm">	
			<bean:define id="approveStatusList" name="TyreRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="STATUS"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
			
          </td>
        </tr>
            
                  
        <tr>
          <td width="7%" align="center" class="fieldname" height="20">3.</td>
          <td width="17%" align="center" height="20" >
          
          
         <html:select property="tyreType3" size="1" >
			<logic:present property="tyreTypeList" name="TyreRequisitionForm">	
			<bean:define id="tyreTypeList" name="TyreRequisitionForm" property="tyreTypeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="BRAND"></html:option>
			<html:options collection="tyreTypeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="13%" align="center" class="fieldname" height="20">
          
          <html:select property="tyreSize3" size="1" >
			<logic:present property="tyreSizeList" name="TyreRequisitionForm">	
			<bean:define id="tyreSizeList" name="TyreRequisitionForm" property="tyreSizeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SIZE"></html:option>
			<html:options collection="tyreSizeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="11%" align="center" class="fieldname" height="20">
          
          
			<html:select property="tyrePly3" size="1" >
			<logic:present property="tyrePlyList" name="TyreRequisitionForm">	
			<bean:define id="tyrePlyList" name="TyreRequisitionForm" property="tyrePlyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PLY"></html:option>
			<html:options collection="tyrePlyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            
            </td>
            <td width="18%" align="center" height="20">
            
       <html:select property="tyreParts3" size="1" >
			<logic:present property="tyrePartsList" name="TyreRequisitionForm">	
			<bean:define id="tyrePartsList" name="TyreRequisitionForm" property="tyrePartsList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PARTS"></html:option>
			<html:options collection="tyrePartsList" property="des" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            
            </td>
         <td width="11%" align="center" height="20">
			 <html:text property="qtyAvailable2"  style="width:113" onclick="avail()"/></td>
          <td width="14%" align="center" height="20">
			 <html:text property="needQty2"  style="width:113"/></td>
          <td width="21%" align="center" height="20">
          
         <html:select property="approveStatus3" size="1" >
			<logic:present property="approveStatusList" name="TyreRequisitionForm">	
			<bean:define id="approveStatusList" name="TyreRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="STATUS"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
              
              
          </td>
                 </tr>
			    
            <tr>
			  
          <td width="7%" align="center" height="21" class="fieldname">4.</td>
          <td width="17%" align="center" height="21">
          
          
          <html:select property="tyreType4" size="1" >
			<logic:present property="tyreTypeList" name="TyreRequisitionForm">	
			<bean:define id="tyreTypeList" name="TyreRequisitionForm" property="tyreTypeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="BRAND"></html:option>
			<html:options collection="tyreTypeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            
            </td>
          <td width="13%" align="center" height="21">
          
			<html:select property="tyreSize4" size="1" >
			<logic:present property="tyreSizeList" name="TyreRequisitionForm">	
			<bean:define id="tyreSizeList" name="TyreRequisitionForm" property="tyreSizeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SIZE"></html:option>
			<html:options collection="tyreSizeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="11%" align="center" height="21">
          
          
			<html:select property="tyrePly4" size="1" >
			<logic:present property="tyrePlyList" name="TyreRequisitionForm">	
			<bean:define id="tyrePlyList" name="TyreRequisitionForm" property="tyrePlyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PLY"></html:option>
			<html:options collection="tyrePlyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="18%" align="center" height="21">
          
          
            <html:select property="tyreParts4" size="1" >
			<logic:present property="tyrePartsList" name="TyreRequisitionForm">	
			<bean:define id="tyrePartsList" name="TyreRequisitionForm" property="tyrePartsList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PARTS"></html:option>
			<html:options collection="tyrePartsList" property="des" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            
            </td>
          <td width="11%" align="center" height="21">
			 <html:text property="qtyAvailable4"  style="width:113" onclick="avail()"/> </td>
          <td width="14%" align="center" height="21">
			 <html:text property="needQty4"  style="width:113"/> </td>
          <td width="21%" align="center" height="21">
          
  <html:select property="approveStatus4" size="1" >
			<logic:present property="approveStatusList" name="TyreRequisitionForm">	
			<bean:define id="approveStatusList" name="TyreRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="STATUS"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
              
              
 </td>
        </tr>
          <tr>
			  
          <td width="7%" align="center" height="21" class="fieldname">5.</td>
          <td width="17%" align="center" height="21">
          
          <html:select property="tyreType5" size="1" >
			<logic:present property="tyreTypeList" name="TyreRequisitionForm">	
			<bean:define id="tyreTypeList" name="TyreRequisitionForm" property="tyreTypeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="BRAND"></html:option>
			<html:options collection="tyreTypeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            
            </td>
          <td width="13%" align="center" height="21">
          
          
			<html:select property="tyreSize5" size="1">
			<logic:present property="tyreSizeList" name="TyreRequisitionForm">	
			<bean:define id="tyreSizeList" name="TyreRequisitionForm" property="tyreSizeList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="SIZE"></html:option>
			<html:options collection="tyreSizeList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            
            </td>
          <td width="11%" align="center" height="21">
          
			<html:select property="tyrePly5" size="1" >
			<logic:present property="tyrePlyList" name="TyreRequisitionForm">	
			<bean:define id="tyrePlyList" name="TyreRequisitionForm" property="tyrePlyList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PLY"></html:option>
			<html:options collection="tyrePlyList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="18%" align="center" height="21">
          
           <html:select property="tyreParts5" size="1" >
			<logic:present property="tyrePartsList" name="TyreRequisitionForm">	
			<bean:define id="tyrePartsList" name="TyreRequisitionForm" property="tyrePartsList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="PARTS"></html:option>
			<html:options collection="tyrePartsList" property="des" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
            
            </td>
          <td width="11%" align="center" height="21">
			 <html:text property="qtyAvailable5"  style="width:113" onclick="avail()"/> </td>
          <td width="14%" align="center" height="21">
			 <html:text property="needQty5"  style="width:113"/> </td>
          <td width="21%" align="center" height="21">
          
 <html:select property="approveStatus5" size="1" >
			<logic:present property="approveStatusList" name="TyreRequisitionForm">	
			<bean:define id="approveStatusList" name="TyreRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="STATUS"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
              
              
 </td>
        </tr>
				
		</table>

            <table border="0" width="100%" height="52">
              <tr>
                <td width="100%" height="46"><b>Required New Tyres</b></td>
              </tr>
            </table>

            <table border="1" width="96%">
              <tr>
                <td width="7%" align="center"><b>S.No</b></td>
                <td width="18%">
                  <p align="center"><b>Tyre
            Type</b></td>
                <td width="17%">
                  <p align="center"><b>Tyre
            Size</b></td>
                <td width="15%">
                  <p align="center"><b>Tyre
            Ply</b></td>
                <td width="20%">
                  <p align="center"><b>Tyre&nbsp;Parts</b></td>
                <td width="20%">
                  <p align="center"><b>Needed&nbsp;Qty</b></td>
                <td width="25%">
                  <p align="center"><b>Approve Status</b></td>
              </tr>
              <tr>
                <td width="7%" align="center">1.</td>
                <td width="18%"> <html:text property="newTyreType1"  style="width:113"/></td>
                <td width="17%"> <html:text property="newTyreSize1"  style="width:113"/></td>
                <td width="15%"> <html:text property="newTyrePly1"  style="width:113"/></td>
                <td width="20%"> <html:text property="newTyreParts1"  style="width:113"/></td>
                <td width="20%"> <html:text property="newNeededQty1"  style="width:113"/></td>
                <td width="25%" align="center"> 
                
                <html:select property="newApproveStatus1" size="1" >
			<logic:present property="approveStatusList" name="TyreRequisitionForm">	
			<bean:define id="approveStatusList" name="TyreRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="STATUS"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
                
                </td>
              </tr>
              <tr>
                <td width="7%" align="center">2.</td>
                 <td width="18%"> <html:text property="newTyreType2"  style="width:113"/></td>
                <td width="17%"> <html:text property="newTyreSize2"  style="width:113"/></td>
                <td width="15%"> <html:text property="newTyrePly2"  style="width:113"/></td>
                <td width="20%"> <html:text property="newTyreParts2"  style="width:113"/></td>
                <td width="20%"> <html:text property="newNeededQty2"  style="width:113"/></td>
                <td width="25%" align="center">
                <html:select property="newApproveStatus2" size="1" >
			<logic:present property="approveStatusList" name="TyreRequisitionForm">	
			<bean:define id="approveStatusList" name="TyreRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="STATUS"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
                 
                 </td>
              </tr>
              <tr>
                <td width="7%" align="center">3.</td>
                 <td width="18%"> <html:text property="newTyreType3"  style="width:113"/></td>
                <td width="17%"> <html:text property="newTyreSize3"  style="width:113"/></td>
                <td width="15%"> <html:text property="newTyrePly3"  style="width:113"/></td>
                <td width="20%"> <html:text property="newTyreParts3"  style="width:113"/></td>
                <td width="20%"> <html:text property="newNeededQty3"  style="width:113"/></td>
                <td width="25%" align="center"> 
                
               <html:select property="newApproveStatus3" size="1" >
			<logic:present property="approveStatusList" name="TyreRequisitionForm">	
			<bean:define id="approveStatusList" name="TyreRequisitionForm" property="approveStatusList" type="java.util.Collection" >
			</bean:define>	
			<html:option value="STATUS"></html:option>
			<html:options collection="approveStatusList" property="code" labelProperty="des"></html:options>
			</logic:present>
			</html:select>
                
                </td>
              </tr>
            </table>

<p style="text-align: center">
		
	<img border="0" src="<%=request.getContextPath()%>/images/SAVE.jpg" >
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" onclick="javascript:submittoEO()">
		
			<img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" onclick="javascript:approve()">
<img border="0" src="<%=request.getContextPath()%>/images/UPDATE.jpg" onclick="javascript:purchase()">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg">
		


</html:form>
        </table>
</body>

</html:html>