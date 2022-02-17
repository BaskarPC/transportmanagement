
<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/RoadTax.do";
%>
<html:html>

	<head>
		<title>RoadTax Details</title>
 	</head>
 	
 	<script language="JavaScript">
 	
	function save()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/roadtax.do?invoke=saveMethod";	
		document.forms[0].submit();
	}	
	function update()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/roadtax.do?invoke=updateMethod";	
		document.forms[0].submit();
	}		
	function retrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/roadtax.do?invoke=retrieveMethod";	
		document.forms[0].submit();
	}
	function clearform()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/roadtax.do?invoke=clearformMethod";	
		document.forms[0].submit();
	}
	function choosevehicletype()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/roadtax.do?invoke=choosevehicletypeMethod";	
		document.forms[0].submit();
	}
	function choosevehicleid()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/roadtax.do?invoke=choosevehicleidMethod";	
		document.forms[0].submit();
	}
	function taxamtcalc()
	{
	
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/roadtax.do?invoke=taxamtcalcMethod";	
		document.forms[0].submit();
	}
	function reductionamtcalc()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/roadtax.do?invoke=reductionamtcalcMethod";	
		document.forms[0].submit();
	}
	function subtaxamtcalc()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/roadtax.do?invoke=subtaxamtcalcMethod";	
		document.forms[0].submit();
	}
 	</script>
<body>

<html:form action="roadtax" enctype="multipart/form-data">
<table border="0" width="100%" CELLSPACING="8" CELLPADDING="5" height="93%">
  <tr>
    <td width="15%" height="29" >
	</td>
    <td width="5%" height="29" >
	<img border="0" src="<%=request.getContextPath()%>/images/icn_roadtax.jpg" width="40" height="40" align="right"></td>
    <td width="18%" height="29" class="maintitle">ROAD TAX DETAILS</td>
  </tr>

  <tr>
    <td width="15%" height="27">&nbsp;</td>
    <td width="24%" height="27" colspan="2">Name of the Institution</td>
    <td width="55%" height="27">      
       <html:select property="instituteName" style="width:145" onchange="choosevehicletype()">
       <logic:present property="instList" name="RoadTaxForm">
       <bean:define id="instList" property="instList" name="RoadTaxForm" type="java.util.Collection">
       </bean:define>
       	<html:option value="--Choose Institution --"></html:option>
		<html:options collection="instList" property="instcode" labelProperty="instdesc"></html:options>
		</logic:present>    		
      	</html:select></td>
  </tr>
  
  <tr>
    <td width="15%" height="25"></td>
    <td width="24%" height="25" colspan="2">Vehicle Type</td>
    <td width="55%" height="25">    
       <html:select property="vehicleType" style="width:145" onchange="choosevehicleid()">
          <logic:present property="vehicletypeList" name="RoadTaxForm">
          <bean:define id="vehicletypeList" property="vehicletypeList" name="RoadTaxForm" type="java.util.Collection">
          </bean:define>
          <html:option value="--Choose a Vehicle --"></html:option>
          <html:options collection="vehicletypeList" property="vehicletypecode" labelProperty="vehicletypedesc"></html:options>
          </logic:present> 			                                      
      	</html:select>
      </td>
  </tr>
  
  <tr>
    <td width="15%" height="27"></td>
    <td width="24%" height="27" colspan="2">Vehicle Registration Number</td>
    <td width="55%" height="27">      
        <html:select property="vehicleId" style="width:145" onchange="retrieve()" >
         <logic:present property="vehicleidList" name="RoadTaxForm">
          <bean:define id="vehicleidList" property="vehicleidList" name="RoadTaxForm" type="java.util.Collection">
          </bean:define>
         <html:option value="--Choose Vehicle ID --"></html:option>
          <html:options collection="vehicleidList" property="vehicleidcode" labelProperty="vehicleiddesc"></html:options>
          </logic:present>          
		</html:select>     
    </td>
    </tr>
    
  <tr>
    <td width="15%" height="25"></td>
    <td width="24%" height="25" colspan="2">Seating Capacity</td>
    <td width="55%" height="25"><html:text property="seatCapacity" style="width:113"/></td>
  </tr>
  <tr>
    <td width="15%" height="25"></td>
    <td width="24%" height="25" colspan="2">Rate per Seat/Year </td>
    <td width="55%" height="25"><html:text property="ratePerSeat" style="width:113" onchange="taxamtcalc()"/></td>
  </tr>
  <tr>
    <td width="15%" height="21"></td>
    <td width="24%" height="21" colspan="2">Tax Amount</td>
    <td width="55%" height="21"><html:text property="taxAmt" style="width:113" /></td>
  </tr>
  <tr>
    <td width="15%" height="29">&nbsp;</td>
    <td width="24%" height="29" colspan="2">Road Tax Period</td>
    <td width="55%" height="29">      
      <html:select property="roadTaxPeriod" style="width:145" >
       <logic:present property="periodList" name="RoadTaxForm">
          <bean:define id="periodList" property="periodList" name="RoadTaxForm" type="java.util.Collection">
          </bean:define>
          <html:option value="--Choose a Period --"></html:option>
          <html:options collection="periodList" property="periodcode" labelProperty="perioddesc"></html:options>
          </logic:present>  
      </html:select>
      </td>
  </tr>
  <tr>
    <td width="15%" height="29"></td>
    <td width="24%" height="29" colspan="2">Reduction Allowed</td>
    <td width="55%" height="29">         
     <html:select property="yesNoOption" style="width:145">
       <logic:present property="optionList" name="RoadTaxForm">
          <bean:define id="optionList" property="optionList" name="RoadTaxForm" type="java.util.Collection">
          </bean:define>
          <html:option value="--Choose an Option --"></html:option>
          <html:options collection="optionList" property="optioncode" labelProperty="optiondesc"></html:options>
          </logic:present>  
		</html:select>
         </td>
  </tr>
  
  <tr>
    <td width="15%" height="25"></td>
    <td width="24%" height="25" colspan="2">Percentage of Reduction</td>
    <td width="55%" height="25"><html:text property="percentOfReduction" style="width:113" onchange="reductionamtcalc()"/></td>
  </tr>
  <tr>
    <td width="15%" height="25"></td>
    <td width="24%" height="25" colspan="2">Reduction Amount</td>
    <td width="55%" height="25"><html:text property="reductionAmt" style="width:113"/></td>
  </tr>

  <tr>
    <td width="15%" height="27"></td>
    <td width="24%" height="27" colspan="2">Total Amount After Reduction</td>
    <td width="55%" height="27"><html:text property="totalAmtAfterReduction" style="width:113" /></td>
  </tr>
  <tr>
    <td width="15%" height="29"></td>
    <td width="24%" height="29" colspan="2">Sub charges : Tax Percentage</td>
    <td width="55%" height="29"><html:text property="subTaxPercent" style="width:113" onchange="subtaxamtcalc()"/></td>
  </tr>
  <tr>
    <td width="15%" height="24"></td>
    <td width="24%" height="24" colspan="2">Sub charges :Tax Amount</td>
    <td width="55%" height="24"><html:text property="subTaxAmt" style="width:113" /></td>
  </tr>
  <tr>
    <td width="15%" height="23"></td>
    <td width="24%" height="23" colspan="2">Grand Total</td>
    <td width="55%" height="23"><html:text property="grandTotal" style="width:113" /></td>
   </tr> 
   <tr>  
   
   <td width="15%" height="53"></td>
  <td width="83%" colspan="3" height="53">
             <p align="left">
             	<img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="save()">
				<img border="0" src="<%=request.getContextPath()%>/images/btn_edit.jpg" width="60" height="18">
				<img border="0" src="<%=request.getContextPath()%>/images/btn_update.jpg" width="60" height="18" onclick="update()">
				<img border="0" src="<%=request.getContextPath()%>/images/btn_clear.jpg" width="60" height="18" onclick="clearform()">
				</p>  
      </td>
  </tr>
</table>
</html:form>
</body>
</html:html>