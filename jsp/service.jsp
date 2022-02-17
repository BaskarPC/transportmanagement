<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/service.do";
%>
<html:html>
	<head>
		<title>Service Form</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/service.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/service.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/service.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/service.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	
</script>

<body> 
		<html:form action="service" enctype="multipart/form-data">
<table border="0" width="100%" cellspacing="7" cellpadding="7" height="205">
<tr>
    <td width="169" colspan="3" height="55">
      <p align="center">&nbsp;</td>
    <td width="85" colspan="2" height="55">
      &nbsp;</td>
    <td width="4%" height="55">
      &nbsp;</td>
    <td width="19%" height="55" colspan="2">
      <p align="right">
		<img border="0" src="<%=request.getContextPath()%>/images/service1.jpg" width="40" height="40"></td>
    <td width="368" colspan="7" height="55" class="maintitle">SERVICE FORM</td>
  </tr>
  <tr>
    <td width="9%" height="25" colspan="2">&nbsp;</td>
    <td width="7%" height="25" colspan="2">&nbsp;</td>
    <td width="12%" height="25" colspan="2">&nbsp;</td>
    <td width="16%" height="25" colspan="3">&nbsp;</td>
    <td width="10%" height="25">&nbsp;</td>
    <td width="14%" height="25" colspan="2">&nbsp;</td>
    <td width="18%" height="25">&nbsp;</td>
    <td width="11%" height="25" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="9%" height="25" colspan="2">&nbsp;</td>
    <td width="7%" height="25" colspan="2">&nbsp;</td>
    <td width="12%" height="25" colspan="2">Date </td>
    <td width="16%" height="25" colspan="3">
    <html:text property="requestedDate" style="width:113"/>
      <a href="#" onClick="showCalendar(this,document.ServiceForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.ServiceForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
    <td width="10%" height="25">&nbsp;</td>
    <td width="20%" height="25" class="fieldname" colspan="2">Bill Number</td>
    <td width="18%" height="25" class="fieldname">
	<html:text property="billNumber" style="width:113"/></td>
    <td width="11%" height="25" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="9%" height="25" colspan="2">&nbsp;</td>
    <td width="7%" height="25" colspan="2">&nbsp;</td>
    <td width="12%" height="25" colspan="2" class="fieldname">Institution</td>
    <td width="16%" height="25" colspan="3"><html:select property="institutionName" style="width:113">
    
    	<html:option value="KVITT"></html:option>
    	<html:option value="KASC"></html:option>
    	<html:option value="KEC"></html:option>
         <html:option value="KPTC"></html:option>                              
      </html:select></td>
    <td width="10%" height="25">&nbsp;</td>
    <td width="20%" height="25" class="fieldname" colspan="2">Driver Name</td>
    <td width="18%" height="25">
	<html:text property="driverName" style="width:113"/></td>
    <td width="11%" height="25" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="9%" height="25" colspan="2">&nbsp;</td>
    <td width="7%" height="25" colspan="2">&nbsp;</td>
    <td width="12%" height="25" colspan="2" class="fieldname">Vehicle Number</td>
    <td width="16%" height="25" colspan="3"><html:select property="vehicleNumber">
                      
                            <html:option value="0"> - - Choose a Vehicle Number --</html:option>
                            <html:option value="1">TN33 H 8388</html:option>
                            <html:option value="2">TN27 U 7949</html:option>   
                            <html:option value="3">TN36 C 7701</html:option>                                                                    
                        </html:select></td>
    <td width="10%" height="25">&nbsp;</td>
    <td width="20%" height="25" class="fieldname" colspan="2">Requested Driver Name</td>
    <td width="18%" height="25"><html:text property="requestedDriverName" style="width:113"/></td>
    <td width="11%" height="25" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="9%" height="25" colspan="2">&nbsp;</td>
    <td width="7%" height="25" colspan="2">&nbsp;</td>
    <td width="12%" height="25" colspan="2" class="fieldname">Vehicle Type</td>
    <td width="16%" height="25" colspan="3">
    <b><html:select property="vehicleType">
                            
                            <html:option value="0">- - Choose Vehicle type - -</html:option>
                            <html:option value="1">car</html:option>
                            <html:option value="2">bus</html:option>   
                            <html:option value="3">lorry</html:option>
                             <html:option value="1">Van (MiniBus)</html:option>
                            <html:option value="2">Ambulance</html:option>   
                            <html:option value="3">Tractor</html:option>    
                            <html:option value="2">Tempo</html:option>   
                            <html:option value="3">Others</html:option>                                                                      
                        </html:select></b></td>
    <td width="10%" height="25">&nbsp;</td>
    <td width="20%" height="25" class="fieldname" colspan="2">Location</td>
    <td width="18%" height="25"><html:select property="location">
                      
                            <html:option value="0"> - - Choose a Place --</html:option>
                            <html:option value="1">KVITT</html:option>
                            <html:option value="2">Perundurai</html:option>   
                            <html:option value="3">Karur</html:option>  
                             <html:option value="2">Erode</html:option>   
                            <html:option value="3">Salem</html:option>                                                                     
                        </html:select></td>
    <td width="11%" height="25" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="9%" height="25" colspan="2">&nbsp;</td>
    <td width="7%" height="25" colspan="2">&nbsp;</td>
    <td width="12%" height="25" colspan="2" class="fieldname">Workshop Name</td>
    <td width="16%" height="25" colspan="3"><html:select property="shopName">
                      
                            <html:option value="0"> - - - - - Choose a Workshop- - ---- --</html:option>
                            <html:option value="1">Chinnamman Automobiles</html:option>
                            <html:option value="2">Sree Saradhambal Automobiles (P) Ltd</html:option>   
                            <html:option value="3">Angalam Engineering Industries Pri</html:option>  
                             <html:option value="2">Aiswariya Lakshmi Auto Service</html:option>   
                            <html:option value="3">Others</html:option>                                                                     
                        </html:select></td>
    <td width="10%" height="25">&nbsp;</td>
    <td width="14%" height="25" class="fieldname" colspan="2">Others</td>
    <td width="18%" height="25"><html:text property="otherPurpose" style="width:113"/></td>
    <td width="11%" height="25" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="96%" colspan="15" height="22">&nbsp;</td>
  </tr>
  <tr>
    <td width="12%" height="21" colspan="2">
	</td>
    <td width="5%" height="21">
	&nbsp;</td>
    <td width="76%" height="21" colspan="12">&nbsp;</td>
  </tr>
  <tr>
    <td width="5%" height="284">&nbsp;</td>
    <td width="2%" height="284">&nbsp;</td>
    <td width="5%" height="284">&nbsp;</td>
    <td width="70%" colspan="10" height="284">
      <table border="1" width="100%" height="42">
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">
            <p align="center" class="fieldname">S.No</td>
          <td width="10%" height="36" align="center" class="fieldname">
            Name of the Service</td>
          <td width="15%" height="30" align="center" class="fieldname">KM Reading</td>
          <td width="21%" height="30" align="center" class="fieldname">Amount</td>
          <td width="13%" height="30" align="center" class="fieldname">Warranty/
            Guarantee</td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">1.</td>
          <td width="10%" height="36" align="center" class="fieldname">
			<html:select property="serviceName1">
                      
                            <html:option value="0"> - - Choose a Service Type --</html:option>
                            <html:option value="1">A/c Hose</html:option>
                            <html:option value="2">Air Compressor</html:option>   
                            <html:option value="3">Oil Service</html:option>  
                             <html:option value="2">Air  Filtter</html:option>   
                            <html:option value="3">Air Dank Union</html:option> 
                            <html:option value="3">Water Service</html:option>                                                                    
                        </html:select></td>
          <td width="15%" height="30" align="center">
			<html:text property="currentKm1" style="width:113"/></td>
          <td width="21%" height="11" align="center">
			<html:text property="totalAmount1" style="width:113"/></td>
          <td width="13%" height="30" align="center">
			<html:text property="serviceWarranty1" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">2.</td>
          <td width="10%" height="36" align="center" class="fieldname">
			<html:select property="serviceName2">
                      
                            <html:option value="0"> - - Choose a Service Type --</html:option>
                            <html:option value="1">A/c Hose</html:option>
                            <html:option value="2">Air Compressor</html:option>   
                            <html:option value="3">Oil Service</html:option>  
                             <html:option value="2">Air  Filtter</html:option>   
                            <html:option value="3">Air Dank Union</html:option> 
                            <html:option value="3">Water Service</html:option>                                                                    
                        </html:select></td>
          <td width="15%" height="30" align="center">
			<html:text property="currentKm2" style="width:113"/></td>
          <td width="21%" height="11" align="center">
			<html:text property="totalAmount2" style="width:113"/></td>
          <td width="13%" height="30" align="center">
			<html:text property="serviceWarranty2" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">3.</td>
          <td width="10%" height="36" align="center" class="fieldname">
			<html:select property="serviceName3">
                      
                            <html:option value="0"> - - Choose a Service Type --</html:option>
                            <html:option value="1">A/c Hose</html:option>
                            <html:option value="2">Air Compressor</html:option>   
                            <html:option value="3">Oil Service</html:option>  
                             <html:option value="2">Air  Filtter</html:option>   
                            <html:option value="3">Air Dank Union</html:option> 
                            <html:option value="3">Water Service</html:option>                                                                    
                        </html:select></td>
          <td width="15%" height="30" align="center">
			<html:text property="currentKm3" style="width:113"/></td>
          <td width="21%" height="11" align="center">
			<html:text property="totalAmount3" style="width:113"/></td>
          <td width="13%" height="30" align="center">
			<html:text property="serviceWarranty3" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">4.</td>
          <td width="10%" height="36" align="center" class="fieldname">
			<html:select property="serviceName4">
                      
                            <html:option value="0"> - - Choose a Service Type --</html:option>
                            <html:option value="1">A/c Hose</html:option>
                            <html:option value="2">Air Compressor</html:option>   
                            <html:option value="3">Oil Service</html:option>  
                             <html:option value="2">Air  Filtter</html:option>   
                            <html:option value="3">Air Dank Union</html:option> 
                            <html:option value="3">Water Service</html:option>                                                                    
                        </html:select></td>
          <td width="15%" height="30" align="center">
			<html:text property="currentKm4" style="width:113"/></td>
          <td width="21%" height="11" align="center">
			<html:text property="totalAmount4" style="width:113"/></td>
          <td width="13%" height="30" align="center">
			<html:text property="serviceWarranty4" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">5.</td>
          <td width="10%" height="36" align="center" class="fieldname">
			<html:select property="serviceName5">
                      
                            <html:option value="0"> - - Choose a Service Type --</html:option>
                            <html:option value="1">A/c Hose</html:option>
                            <html:option value="2">Air Compressor</html:option>   
                            <html:option value="3">Oil Service</html:option>  
                             <html:option value="2">Air  Filtter</html:option>   
                            <html:option value="3">Air Dank Union</html:option> 
                            <html:option value="3">Water Service</html:option>                                                                    
                        </html:select></td>
          <td width="15%" height="30" align="center">
			<html:text property="currentKm5" style="width:113"/></td>
          <td width="21%" height="11" align="center">
			<html:text property="totalAmount5" style="width:113"/></td>
          <td width="13%" height="30" align="center">
			<html:text property="serviceWarranty5" style="width:113"/></td>
        </tr>
      </table>
    </td>
       <td width="1%" height="284">&nbsp;</td>
       <td width="6%" height="284">&nbsp;</td>
  </tr>
  <tr>
    <td width="49%" height="15" colspan="7"></td>
    <td width="13%" height="15" colspan="2">Include Spare parts</td>
    <td width="12%" height="15" colspan="2"><html:select property="service">
                      
                            <html:option value="0"> - - Choose a Option --</html:option>
                            <html:option value="1">Yes</html:option>
                            <html:option value="2">No</html:option>   
                                                                                             
                        </html:select></td>
    <td width="24%" height="15" colspan="4"></td>
  </tr>
  <tr>
    <td width="5%" height="284">&nbsp;</td>
    <td width="2%" height="284">&nbsp;</td>
    <td width="5%" height="284">&nbsp;</td>
    <td width="70%" colspan="10" height="284">
      <table border="1" width="100%" height="42">
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">
            <p align="center" class="fieldname">S.No</td>
          <td width="10%" height="36" align="center" class="fieldname">
            Name of the Service</td>
          <td width="15%" height="30" align="center" class="fieldname">KM Reading</td>
          <td width="21%" height="30" align="center" class="fieldname">Amount</td>
          <td width="13%" height="30" align="center" class="fieldname">Warranty/
            Guarantee</td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">1.</td>
          <td width="10%" height="36" align="center" class="fieldname">
			<html:text property="nameOfService1" style="width:113"/></td>
          <td width="15%" height="30" align="center">
			<html:text property="currentKm6" style="width:113"/></td>
          <td width="21%" height="11" align="center">
			<html:text property="totalAmount6" style="width:113"/></td>
          <td width="13%" height="30" align="center">
			<html:text property="serviceWarranty6" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">2.</td>
          <td width="10%" height="36" align="center" class="fieldname">
			<html:text property="nameOfService2" style="width:113"/></td>
          <td width="15%" height="30" align="center">
			<html:text property="currentKm7" style="width:113"/></td>
          <td width="21%" height="11" align="center">
			<html:text property="totalAmount7" style="width:113"/></td>
          <td width="13%" height="30" align="center">
			<html:text property="serviceWarranty7" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">3.</td>
          <td width="10%" height="36" align="center" class="fieldname">
			<html:text property="nameOfService3" style="width:113"/></td>
          <td width="15%" height="30" align="center">
			<html:text property="currentKm8" style="width:113"/></td>
          <td width="21%" height="11" align="center">
			<html:text property="totalAmount8" style="width:113"/></td>
          <td width="13%" height="30" align="center">
			<html:text property="serviceWarranty8" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">4.</td>
          <td width="10%" height="36" align="center" class="fieldname">
			<html:text property="nameOfService4" style="width:113"/></td>
          <td width="15%" height="30" align="center">
			<html:text property="currentKm9" style="width:113"/></td>
          <td width="21%" height="11" align="center">
			<html:text property="totalAmount9" style="width:113"/></td>
          <td width="13%" height="30" align="center">
			<html:text property="serviceWarranty9" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">5.</td>
          <td width="10%" height="36" align="center" class="fieldname">
			<html:text property="nameOfService5" style="width:113"/></td>
          <td width="15%" height="30" align="center">
			<html:text property="currentKm10" style="width:113"/></td>
          <td width="21%" height="11" align="center">
			<html:text property="totalAmount10" style="width:113"/></td>
          <td width="13%" height="30" align="center">
			<html:text property="serviceWarranty10" style="width:113"/></td>
        </tr>
      </table>
    </td>
       <td width="1%" height="284"></td>
       <td width="6%" height="284"></td>
  </tr>
  <tr>
    <td width="78%" height="21" colspan="13"></td>
  </tr>
  <tr>
    <td width="78%" height="21" colspan="13">
      <p align="center">
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18" onclick="javascript:submitdone()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18" onclick="javascript:issuedone()">
        <img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18" onclick="javascript:approvedone()">
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18" onclick="javascript:okdone()"></td>
  
  </tr>
</table>
<p align="center">&nbsp;</p>
</html:form>
			
			
</body>
</html:html>