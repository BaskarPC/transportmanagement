<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/scrap.do";
%>
<html:html>
	<head>
		<title>Scrap Maintenance</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/scrap.do?invoke=saveMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/scrap.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/scrap.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/scrap.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	function selectInstName()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/scrap.do?invoke=instMethod";	
		document.forms[0].submit();
	}
	function selectVehicleType()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/scrap.do?invoke=vehicleMethod";	
		document.forms[0].submit();
	}
	function selectGram()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/scrap.do?invoke=gramMethod";	
		document.forms[0].submit();
	}	
</script>

<body> 
		<html:form action="scrap" enctype="multipart/form-data">
<table border="0" width="99%" cellspacing="7" cellpadding="7" height="556">
 <tr>
    <td width="25%" colspan="5" height="55"></td>
    <td width="9%" colspan="5" height="55">&nbsp;</td>
    <td width="9%" colspan="2" height="55" class="maintitle">
		<img border="0" src="<%=request.getContextPath()%>/images/scrap.jpg" width="40" height="40" align="right"></td>
    <td width="57%" colspan="8" height="55" class="maintitle">SCRAP MAINTENANCE</td>
    <td width="22%"></td>
 </tr>
     
 <tr>
    <td width="9%" height="16"  colspan="5"></td>
    <td height="16"  colspan="2"></td>
    <td height="16"  colspan="8"></td>
    <td height="16"  colspan="2"></td>
    <td height="16" ></td>
    <td height="16" ></td>
   <td height="16"  colspan="2"></td>
   </tr>

  <tr>
    
    <td width="3%" height="24" >&nbsp;</td>
    <td height="24" >&nbsp;</td>
    <td height="24" >&nbsp;</td>
    <td height="24" class="fieldname" colspan="3">Institution</td>
    <td height="24"  colspan="5">
    	<html:select property="institutionName" style="width:150" onchange="javascript:selectInstName()">
				<html:option value="0">--Choose an Institution--</html:option>
						<logic:present property="instList" name="ScrapForm">	
								<bean:define id="instList" name="ScrapForm" property="instList" type="java.util.Collection" ></bean:define>
								<html:options collection="instList" property="instId" labelProperty="instDesc"></html:options>
						</logic:present>
		</html:select>	</td>
    
    <td height="24" colspan="3">&nbsp;</td>
    <td height="24" class="fieldname" colspan="2">Vehicle Type</td>
    <td height="24" class="fieldname" colspan="5">
		<html:select property="vehicleType" onchange="javascript:selectVehicleType()">
                      
                            <html:option value="0">--Choose Vehicle Type--</html:option>
							<logic:present property="typeList" name="ScrapForm">	
								<bean:define id="typeList" name="ScrapForm" property="typeList" type="java.util.Collection" ></bean:define>
								<html:options collection="typeList" property="typeId" labelProperty="typeDesc"></html:options>
							</logic:present>
                                                                                             
                        </html:select></td>
     
                    
     </tr>
  <tr>
    
    <td width="3%" height="34" >&nbsp;</td>
    
    <td height="34" >&nbsp;</td>
    
    <td height="34" >&nbsp;</td>
    
    <td height="34"  colspan="3">Date</td>
    
    <td height="34"  colspan="5">
    <html:text property="requestedDate" style="width:113"/>
     <a href="#" onClick="showCalendar(this,document.ScrapForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.ScrapForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a>
    </td>
    
    <td height="34" colspan="3">&nbsp;</td>
    <td height="34" class="fieldname" colspan="2">Vehicle Number</td>
    <td height="34" class="fieldname" colspan="5">
   <html:select property="vehicleNumber" onchange="javascript:selectVehicleNumber()">
               <html:option value="0"> - - Choose a Vehicle Number --</html:option>
                            <logic:present property="vehicleList" name="ScrapForm">	
								<bean:define id="vehicleList" name="ScrapForm" property="vehicleList" type="java.util.Collection" ></bean:define>
								<html:options collection="vehicleList" property="vehicleId" labelProperty="vehicleDesc"></html:options>
							</logic:present>                                                                  
                        </html:select>
    </td>
    
    
      
  </tr>
  <tr>
    
    <td width="3%" height="34" >&nbsp;</td>
    <td height="34" >&nbsp;</td>
    <td height="34" >&nbsp;</td>
    <td height="34" class="fieldname" colspan="3">Company</td>
    <td height="34" class="fieldname" colspan="5">
    <html:text property="companyName" style="width:113"/></td>
    <td height="34" class="fieldname" colspan="3">&nbsp;</td>
    <td height="34" class="fieldname" colspan="2"> Bill Number</td>
    <td height="34" class="fieldname" colspan="5">
    <html:text property="billNumber" style="width:113"/></td>
    
  
  </tr>

  <tr>
    <td width="97%" height="225" colspan="21" align="center">
      <table border="1" width="83%">
        <tr>
          <td width="5%" align="center" class="fieldname">S.No</td>
          <td width="19%" align="center" class="fieldname">Category</td>
          <td width="17%" align="center" class="fieldname">Item Name</td>
          <td width="16%" align="center" class="fieldname">Item Count</td>
          <td width="13%" align="center" class="fieldname">Kilogram </td>
          <td width="16%" align="center" class="fieldname">Gram</td>
        </tr>
        <tr>
          <td width="5%" align="center" class="fieldname">1.</td>
          <td width="19%" align="center">
          <html:select property="scrapCategory1">
           <html:option value="0">- - Choose A Category - -</html:option>
		     <logic:present property="categoryList" name="ScrapForm">	
								<bean:define id="categoryList" name="ScrapForm" property="categoryList" type="java.util.Collection" ></bean:define>
								<html:options collection="categoryList" property="categoryId" labelProperty="categoryDesc"></html:options>
							</logic:present> 
                                                      
         </html:select>
			</td>
          <td width="17%" align="center">
          
           <html:select property="scrapItemName1">
		     <html:option value="0">- - Choose Item Name - -</html:option>
             <logic:present property="categoryList" name="ScrapForm">	
								<bean:define id="categoryList" name="ScrapForm" property="categoryList" type="java.util.Collection" ></bean:define>
								<html:options collection="categoryList" property="categoryId" labelProperty="categoryDesc"></html:options>
							</logic:present> 
                                                      
         </html:select>

			</td>
          <td width="16%" align="center">
			<html:text property="scrapItemCount1" style="width:113"/></td>
          <td width="13%" align="center">
			<html:text property="scrapKilogram1" style="width:113" onchange="javascript:selectGram()"/></td>
          <td width="16%">
			<html:text property="scrapGram1" style="width:113"/></td>
        </tr>
        <tr>
          <td width="5%" align="center">2.</td>
          <td width="19%" align="center">
			<html:select property="scrapCategory2">
			 <html:option value="0">- - Choose A Category - -</html:option>
		     <logic:present property="categoryList" name="ScrapForm">	
								<bean:define id="categoryList" name="ScrapForm" property="categoryList" type="java.util.Collection" ></bean:define>
								<html:options collection="categoryList" property="categoryId" labelProperty="categoryDesc"></html:options>
							</logic:present> 
                                                      
         </html:select>
			</td>
          <td width="17%" align="center">
          
           <html:select property="scrapItemName2">
		     <html:option value="0">- - Choose Item Name - -</html:option>
             <logic:present property="categoryList" name="ScrapForm">	
								<bean:define id="categoryList" name="ScrapForm" property="categoryList" type="java.util.Collection" ></bean:define>
								<html:options collection="categoryList" property="categoryId" labelProperty="categoryDesc"></html:options>
							</logic:present> 
                                                      
         </html:select>
</td>
           <td width="16%" align="center">
			<html:text property="scrapItemCount2" style="width:113"/></td>
          <td width="13%" align="center">
			<html:text property="scrapKilogram2" style="width:113" onchange="javascript:selectGram()"/></td>
          <td width="16%">
			<html:text property="scrapGram2" style="width:113"/></td>
        </tr>
        <tr>
          <td width="5%" align="center">3.</td>
          <td width="19%" align="center">
			<html:select property="scrapCategory3">
			 <html:option value="0">- - Choose A Category - -</html:option>
		     <logic:present property="categoryList" name="ScrapForm">	
								<bean:define id="categoryList" name="ScrapForm" property="categoryList" type="java.util.Collection" ></bean:define>
								<html:options collection="categoryList" property="categoryId" labelProperty="categoryDesc"></html:options>
							</logic:present> 
         </html:select>
			</td>
          <td width="17%" align="center">
          
           <html:select property="scrapItemName3">
		     <html:option value="0">- - Choose Item Name - -</html:option>
             <logic:present property="categoryList" name="ScrapForm">	
								<bean:define id="categoryList" name="ScrapForm" property="categoryList" type="java.util.Collection" ></bean:define>
								<html:options collection="categoryList" property="categoryId" labelProperty="categoryDesc"></html:options>
							</logic:present>  
         </html:select>
</td>
           <td width="16%" align="center">
			<html:text property="scrapItemCount3" style="width:113"/></td>
          <td width="13%" align="center">
			<html:text property="scrapKilogram3" style="width:113" onchange="javascript:selectGram()"/></td>
          <td width="16%">
			<html:text property="scrapGram3" style="width:113"/></td>
        </tr>
        <tr>
          <td width="5%" align="center">4.</td>
          <td width="19%" align="center">
		<html:select property="scrapCategory4">
		     <html:option value="0">- - Choose A Category - -</html:option>
            <logic:present property="categoryList" name="ScrapForm">	
								<bean:define id="categoryList" name="ScrapForm" property="categoryList" type="java.util.Collection" ></bean:define>
								<html:options collection="categoryList" property="categoryId" labelProperty="categoryDesc"></html:options>
							</logic:present> 
         </html:select>
			</td>
          <td width="17%" align="center">
          
           <html:select property="scrapItemName4">
		     <html:option value="0">- - Choose Item Name - -</html:option>
             <logic:present property="categoryList" name="ScrapForm">	
								<bean:define id="categoryList" name="ScrapForm" property="categoryList" type="java.util.Collection" ></bean:define>
								<html:options collection="categoryList" property="categoryId" labelProperty="categoryDesc"></html:options>
							</logic:present>                       
         </html:select>
</td>
          <td width="16%" align="center">
			<html:text property="scrapItemCount4" style="width:113"/></td>
          <td width="13%" align="center">
			<html:text property="scrapKilogram4" style="width:113" onchange="javascript:selectGram()"/></td>
          <td width="16%">
			<html:text property="scrapGram4" style="width:113"/></td>
        </tr>
        <tr>
          <td width="5%" align="center">5.</td>
          <td width="19%" align="center">
			<html:select property="scrapCategory5">
		     <html:option value="0">- - Choose A Category - -</html:option>
             <logic:present property="categoryList" name="ScrapForm">	
								<bean:define id="categoryList" name="ScrapForm" property="categoryList" type="java.util.Collection" ></bean:define>
								<html:options collection="categoryList" property="categoryId" labelProperty="categoryDesc"></html:options>
							</logic:present> 
         </html:select>
			</td>
          <td width="17%" align="center">
          
           <html:select property="scrapItemName5">
		     <html:option value="0">- - Choose Item Name - -</html:option>
            <logic:present property="categoryList" name="ScrapForm">	
								<bean:define id="categoryList" name="ScrapForm" property="categoryList" type="java.util.Collection" ></bean:define>
								<html:options collection="categoryList" property="categoryId" labelProperty="categoryDesc"></html:options>
							</logic:present>                           
         </html:select>
</td>
           <td width="16%" align="center">
			<html:text property="scrapItemCount5" style="width:113"/></td>
          <td width="13%" align="center">
			<html:text property="scrapKilogram5" style="width:113" onchange="javascript:selectGram()"/></td>
          <td width="16%">
			<html:text property="scrapGram5" style="width:113"/></td>
        </tr>
        </table>
    </td>
  </tr>
  <tr>
    <td width="20%" height="36" colspan="4">
      </td>
    <td width="6%" height="36" colspan="4">
      &nbsp;</td>
    <td width="2%" height="36">
      &nbsp;</td>
    <td width="4%" height="36" colspan="4">
      Cumulative Kilogram</td>
    <td width="54%" height="36" colspan="8">
		<html:text property="scrapCumulativeKilogram" style="width:113"/></td>
    </tr>
  <tr>
    <td width="20%" height="23" colspan="4">
      &nbsp;</td>
    <td width="6%" height="23" colspan="4">
      &nbsp;</td>
    <td width="2%" height="23">
      &nbsp;</td>
    <td width="4%" height="23" colspan="4">
      Cumulative Gram</td>
    <td width="54%" height="23" colspan="8">
		<html:text property="scrapCumulativeGram" style="width:113"/></td>
    </tr>
    <tr/>
    <tr/>
  <tr>
    <td width="97%" height="26" colspan="21">
      <p align="center">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="javascript:submitdone()">
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18" onclick="javascript:issuedone()">
        <img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18" onclick="javascript:approvedone()">
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18" onclick="javascript:okdone()"></td>
     </tr>
</table>

</html:form>
</body>

</html:html>