<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/equipmentallotment.do";
%>
<html:html>

	<head>
		<title>Equipment Allotment Details</title>
 	</head>
 	<script language="JavaScript">
		function insert()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/equipmentallotment.do?invoke=insertMethod";	
		document.forms[0].submit();
	}	
	function add()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/equipmentallotment.do?invoke=addMethod";	
		document.forms[0].submit();
	}
	function back()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/equipmentallotment.do?invoke=backMethod";	
		document.forms[0].submit();
	}
	function clearform()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/equipmentallotment.do?invoke=clearformMethod";	
		document.forms[0].submit();
	}	
	</script>
 	
<body>
<html:form action="equipmentallotment" enctype="multipart/form-data">
<table border="0" width="100%" cellpadding="5" cellspacing="8" height="31%">
<tr>
    <td width="14%" align="left" height="53">
    <p align="right">
	</td>
    <td width="200" align="right" height="53"  >
	<img border="0" src="<%=request.getContextPath()%>/images/icn_equipmentallotment.jpg" width="40" height="40" align="right"></td>
    <td width="20%" align="right" height="53" class="maintitle">EQUIPMENT ALLOTMENT </td>
<td width="10%" align="left" height="53" class="maintitle">DETAILS</td>
   <td width="277" align="left" height="53" ></td>

<tr>
<td width="14%" align="left" height="26"></td>
<td align="left" class="maintitle">EQUIPMENT NAME</td>
<td align="left" class="maintitle">QUANTITY</td>
<td align="left" width="400" rowspan="8"> 
  <table border="1" width="100%">
    
    <tr>    
    <td>
    <logic:present property="tableList" name="EquipmentAllotmentForm">
    <bean:define id="tableList" name="EquipmentAllotmentForm" property="tableList" scope="session" type="java.util.Collection"/>
	<display:table name="tableList" requestURI="<%=url%>" decorator="com.util.EquipmentAllotmentUtil">
	<display:column property="equipmentName"  title="Equipment Name"/>
	</display:table>
	</logic:present>
	<logic:notPresent name="tableList" scope="request">No Tasks Found 
	</logic:notPresent>
	</td>
    </tr>    
  </table></td></tr>
  
  <tr>
    <td width="62" align="left" height="26">
    </td>
     <td width="164" align="left" height="26">      
      <html:select property="combo1" style="width:150">
      <logic:present property="combo1List" name="EquipmentAllotmentForm">
	  <bean:define id="combo1List" property="combo1List" name="EquipmentAllotmentForm" type="java.util.Collection">
	  </bean:define>
	  <html:option value="--Choose a Equipment --"></html:option>
      <html:options collection="combo1List" property="combo1code" labelProperty="combo1desc"></html:options>
      </logic:present>	
      </html:select>                                  
  	</td>
  
  	<td width="300" align="left" height="1" class="fieldname">
    <html:text property="quantity1" style="width:113"/>
    </td>
  	</tr>
  
   <tr>
     <td width="14%" align="left" height="26">
    </td>
     <td width="150" align="left" height="26">      
      <html:select property="combo2" style="width:150">
      <logic:present property="combo2List" name="EquipmentAllotmentForm">
	  <bean:define id="combo2List" property="combo2List" name="EquipmentAllotmentForm" type="java.util.Collection">
	  </bean:define>
	  <html:option value="--Choose a Equipment --"></html:option>
      <html:options collection="combo2List" property="combo2code" labelProperty="combo2desc"></html:options>
      </logic:present>	
      </html:select>                                  
  	</td>
  	<td width="549" align="left" height="1" class="fieldname">
    <html:text property="quantity2" style="width:113"/>
    </td>
  	</tr>
  	
  	<tr>
    <td width="14%" align="left" height="26">
    </td>
    <td width="150" align="left" height="26">      
      <html:select property="combo3" style="width:150">
      <logic:present property="combo3List" name="EquipmentAllotmentForm">
	  <bean:define id="combo3List" property="combo3List" name="EquipmentAllotmentForm" type="java.util.Collection">
	  </bean:define>
	  <html:option value="--Choose a Equipment --"></html:option>
      <html:options collection="combo3List" property="combo3code" labelProperty="combo3desc"></html:options>
      </logic:present>	
      </html:select>                                  
  	</td>
  	<td width="549" align="left" height="1" class="fieldname">
    <html:text property="quantity3" style="width:113"/>
    </td>
  	</tr>
  	
  	<tr>
   <td width="14%" align="left" height="26">
    </td>
    <td width="150" align="left" height="26">      
      <html:select property="combo4" style="width:150">
      <logic:present property="combo4List" name="EquipmentAllotmentForm">
	  <bean:define id="combo4List" property="combo4List" name="EquipmentAllotmentForm" type="java.util.Collection">
	  </bean:define>
	  <html:option value="--Choose a Equipment --"></html:option>
      <html:options collection="combo4List" property="combo4code" labelProperty="combo4desc"></html:options>
      </logic:present>	
      </html:select>                                  
  	</td>
  	
    <td width="549" align="left" height="1" class="fieldname">
    <html:text property="quantity4" style="width:113"/>    
    <img border="0" src="<%=request.getContextPath()%>/images/btn_add.jpg" width="60" height="18" onclick="add()">
  	</td>
  	</tr>
  	
  	<tr><td width="14%" align="left" height="26"></td>
  	<td align="center">TYRE DETAILS</td></tr>	  	
  	 
  <tr>
    <td width="14%" align="left" height="26"></td>
      <td width="27%" align="left" height="26">      
      <html:select property="frontLeftTyre" style="width:150">
      <logic:present property="tyresizeList" name="EquipmentAllotmentForm">
	  <bean:define id="tyresizeList" property="tyresizeList" name="EquipmentAllotmentForm" type="java.util.Collection">
	  </bean:define>
	  <html:option value="--Choose a Front Left Tyre --"></html:option>
      <html:options collection="tyresizeList" property="tyresizecode" labelProperty="tyresizedesc"></html:options>
      </logic:present>	
      </html:select>                                  
  	</td>
  	<td width="300" align="left" height="1" class="fieldname">
    <html:text property="quantity5" style="width:113"/>
    </td>
  	</tr>
      	
     <tr>	
      	<td width="14%" align="left" height="26"></td>   	
      <td width="27%" align="left" height="26">      
      <html:select property="frontRightTyre" style="width:150">
      <logic:present property="tyresizeList" name="EquipmentAllotmentForm">
	  <bean:define id="tyresizeList" property="tyresizeList" name="EquipmentAllotmentForm" type="java.util.Collection">
	  </bean:define>
	  <html:option value="--Choose a Front Right Tyre --"></html:option>
      <html:options collection="tyresizeList" property="tyresizecode" labelProperty="tyresizedesc"></html:options>
      </logic:present>	
      </html:select>                                  
  	</td>
  	<td width="300" align="left" height="1" class="fieldname">
    <html:text property="quantity6" style="width:113"/>
    </td>
  	</tr>
  
  <tr>
    <td width="14%" align="left" height="26">
    </td>
     <td width="217" align="left" height="26">      
      <html:select property="backLeftInTyre" style="width:150">
	  <logic:present property="tyresizeList" name="EquipmentAllotmentForm">
	  <bean:define id="tyresizeList" property="tyresizeList" name="EquipmentAllotmentForm" type="java.util.Collection">
	  </bean:define>
	  <html:option value="--Choose a Back Left In Tyre --"></html:option>
      <html:options collection="tyresizeList" property="tyresizecode" labelProperty="tyresizedesc"></html:options>
      </logic:present>	
      </html:select>    
      </td>
      <td width="300" align="left" height="1" class="fieldname">
      <html:text property="quantity7" style="width:113"/></td>
      </tr>
      		
     <tr>
     <td width="14%" align="left" height="26">
    </td>
     <td width="27%" align="left" height="26">      
      <html:select property="backLeftOutTyre" style="width:150">
	  <logic:present property="tyresizeList" name="EquipmentAllotmentForm">
	  <bean:define id="tyresizeList" property="tyresizeList" name="EquipmentAllotmentForm" type="java.util.Collection">
	  </bean:define>
	  <html:option value="--Choose a Back Left Out Tyre --"></html:option>
      <html:options collection="tyresizeList" property="tyresizecode" labelProperty="tyresizedesc"></html:options>
      </logic:present>	
      	</html:select>
      	</td>	
      	<td width="300" align="left" height="1" class="fieldname">
        <html:text property="quantity8" style="width:113"/></td>
      	</tr>
  
  <tr>
    <td width="14%" align="left" height="26">
    </td>
    <td width="217" align="left" height="26">      
      <html:select property="backRightInTyre" style="width:150">
	  <logic:present property="tyresizeList" name="EquipmentAllotmentForm">
	  <bean:define id="tyresizeList" property="tyresizeList" name="EquipmentAllotmentForm" type="java.util.Collection">
	  </bean:define>
	  <html:option value="--Choose a Back Right In Tyre --"></html:option>
      <html:options collection="tyresizeList" property="tyresizecode" labelProperty="tyresizedesc"></html:options>
      </logic:present>	
      </html:select>    
      </td>
      <td width="300" align="left" height="1" class="fieldname">
    <html:text property="quantity9" style="width:113"/>
    </td>
      </tr>
      
     <tr> 	
     <td width="14%" align="left" height="26"> </td>	   	
     <td width="27%" align="left" height="26">      
    <html:select property="backRightOutTyre" style="width:150">
	   <logic:present property="tyresizeList" name="EquipmentAllotmentForm">
	  <bean:define id="tyresizeList" property="tyresizeList" name="EquipmentAllotmentForm" type="java.util.Collection">
	  </bean:define>
	  <html:option value="--Choose a Back Right Out Tyre --"></html:option>
      <html:options collection="tyresizeList" property="tyresizecode" labelProperty="tyresizedesc"></html:options>
      </logic:present>	
    </html:select>   
       </td> 	
       <td width="300" align="left" height="1" class="fieldname">
    <html:text property="quantity10" style="width:113"/>
    </td>        		
  </tr>
  
  <tr>
      <td width="981" align="center" height="21" colspan="5">
      <p>
		<img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="insert()">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_clear.jpg" width="60" height="18" onclick="clearform()">
		<img border="0" src="<%=request.getContextPath()%>/images/btn_back.jpg" width="60" height="18" onclick="back()">
  
</table>  
</html:form>
</body>
</html:html>