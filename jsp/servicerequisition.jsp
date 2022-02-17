<%@ include file="/include/taglibs.jsp"%>

<%
	String url =  request.getContextPath()+"/servicereq.do";
%>

<html:html>
	<head>
		<title>Requisition For Service</title>
	</head>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	function submitdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/servicereq.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function issuedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/servicereq.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function approvedone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/servicereq.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function okdone()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/servicereq.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	
</script>

<body> 
<html:form action="servicereq" enctype="multipart/form-data">

<table border="0" width="100%" height="855" >
<tr>
    <td width="169" colspan="3" height="55"></td>
    <td width="85" colspan="2" height="55"></td>
    <td width="5%" height="55"></td>
    <td width="16%" height="55" align="right">
    <img border="0" src="<%=request.getContextPath()%>/images/service2.jpg"></td>
    <td width="368" colspan="6" height="55" class="maintitle">REQUISITION FOR SERVICE / REPAIR</td>
  </tr>
  <tr>
    <td width="9%" height="25" colspan="2">&nbsp;</td>
    <td width="7%" height="25" colspan="2">&nbsp;</td>
    <td width="12%" height="25" colspan="2">&nbsp;</td>
    <td width="16%" height="25" colspan="2">&nbsp;</td>
    <td width="11%" height="25">&nbsp;</td>
    <td width="15%" height="25">&nbsp;</td>
    <td width="19%" height="25">&nbsp;</td>
    <td width="11%" height="25" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="9%" height="25" colspan="2">&nbsp;</td>
    <td width="7%" height="25" colspan="2">&nbsp;</td>
    <td width="12%" height="25" colspan="2">Date </td>
    <td width="16%" height="25" colspan="2">
    <html:text property="requestedDate" style="width:113"/>
      <a href="#" onClick="showCalendar(this,document.ServiceReqForm.requestedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.ServiceReqForm.requestedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a></td>
    <td width="11%" height="25">&nbsp;</td>
    <td width="11%" height="25" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="9%" height="25" colspan="2">&nbsp;</td>
    <td width="7%" height="25" colspan="2">&nbsp;</td>
    <td width="12%" height="25" colspan="2" class="fieldname">Institution</td>
    <td width="16%" height="25" colspan="2"><html:select property="institutionName" style="width:113">
    
    	<html:option value="hai"></html:option>
    	<html:option value="hello"></html:option>
    	<html:option value="bye"></html:option>
                                       
      </html:select></td>
     
    <td width="11%" height="25">&nbsp;</td>
    <td width="15%" height="25" class="fieldname">Driver Name</td>
    <td width="19%" height="25">
	<html:text property="driverName" style="width:113"/></td>
    <td width="11%" height="25" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="9%" height="25" colspan="2">&nbsp;</td>
    <td width="7%" height="25" colspan="2">&nbsp;</td>
    <td width="12%" height="25" colspan="2" class="fieldname">Vehicle Type</td>
    <td width="16%" height="25" colspan="2">
   <html:select property="vehicleType">
                            
                            <html:option value="0"> - - Choose a Vehicle Type --</html:option>
                            <html:option value="1">Bus</html:option>
                            <html:option value="2">Car</html:option>   
                            <html:option value="3">Lorry</html:option>                                                                    
                        </html:select></td>
    <td width="11%" height="25">&nbsp;</td>
    <td width="15%" height="25" class="fieldname">Requested Driver Name</td>
    <td width="19%" height="25"><html:text property="requestedDriverName" style="width:113"/></td>
    <td width="11%" height="25" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="9%" height="25" colspan="2">&nbsp;</td>
    <td width="7%" height="25" colspan="2">&nbsp;</td>
    <td width="12%" height="25" colspan="2" class="fieldname">Vehicle No</td>
    <td width="16%" height="25" colspan="2"><html:select property="vehicleNumber">
                            
                            <html:option value="0"> - - Choose a Vehicle Number --</html:option>
                            <html:option value="1">TN33 H 8388</html:option>
                            <html:option value="2">TN27 U 7949</html:option>   
                            <html:option value="3">TN36 C 7701</html:option>                                                                    
                        </html:select></td>
    <td width="11%" height="25">&nbsp;</td>
    <td width="15%" height="25" class="fieldname">Present KM</td>
    <td width="19%" height="25"><html:text property="currentKm" style="width:113"/></td>
    <td width="11%" height="25" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td width="96%" colspan="13" height="22">&nbsp;</td>
  </tr>
  <tr>
    <td width="1%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="70%" colspan="8" height="21" class="subtitle">REQUIRED SERVICES</td>
       <td width="2%" height="21">&nbsp;</td>
       <td width="7%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="1%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="70%" colspan="8" height="21">
      <table border="1" width="100%" height="170">
        <tr>
          <td width="10%" align="center" height="19" class="fieldname">S.No</td>
          <td width="47%" align="center" height="19" class="fieldname">Work details</td>
          <td width="43%" align="center" height="19" class="fieldname">Reason</td>
        </tr>
        <tr>
          <td width="10%" align="center" height="23">1.</td>
          <td width="47%" align="center" height="23">
          <html:select property="workDetails1">
		     <html:option value="0"> - - Choose a Service Type --</html:option>
             <html:option value="1">A/c Hose</html:option>
             <html:option value="2">Air Compressor</html:option>   
             <html:option value="3">Air Dank Union</html:option>  
              <html:option value="3">Water Service</html:option>                                                                  
         </html:select>
         </td>
          <td width="43%" align="center" height="23">
			<html:text property="serviceReason1" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" align="center" height="23">2.</td>
          <td width="47%" align="center" height="23">
			<html:select property="workDetails2">
		     <html:option value="0"> - - Choose a Service Type --</html:option>
             <html:option value="1">A/c Hose</html:option>
             <html:option value="2">Air Compressor</html:option>   
             <html:option value="3">Air Dank Union</html:option>  
              <html:option value="3">Water Service</html:option>                                                                  
         </html:select>
</td>
          <td width="43%" align="center" height="23">
			<html:text property="serviceReason2" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" align="center" height="23">3.</td>
          <td width="47%" align="center" height="23">
			<html:select property="workDetails3">
		     <html:option value="0"> - - Choose a Service Type --</html:option>
             <html:option value="1">A/c Hose</html:option>
             <html:option value="2">Air Compressor</html:option>   
             <html:option value="3">Air Dank Union</html:option>  
              <html:option value="3">Water Service</html:option>                                                                  
         </html:select>
</td>
          <td width="43%" align="center" height="23">
			<html:text property="serviceReason3" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" align="center" height="23">4.</td>
          <td width="47%" align="center" height="23">
			<html:select property="workDetails4">
		     <html:option value="0"> - - Choose a Service Type --</html:option>
             <html:option value="1">A/c Hose</html:option>
             <html:option value="2">Air Compressor</html:option>   
             <html:option value="3">Air Dank Union</html:option>  
              <html:option value="3">Water Service</html:option>                                                                  
         </html:select>
</td>
          <td width="43%" align="center" height="23">
			<html:text property="serviceReason4" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" align="center" height="23">5.</td>
          <td width="47%" align="center" height="23">
		<html:select property="workDetails5">
		     <html:option value="0"> - - Choose a Service Type --</html:option>
             <html:option value="1">A/c Hose</html:option>
             <html:option value="2">Air Compressor</html:option>   
             <html:option value="3">Air Dank Union</html:option>  
              <html:option value="3">Water Service</html:option>                                                                  
         </html:select>
</td>
          <td width="43%" align="center" height="23">
			<html:text property="serviceReason5" style="width:113"/></td>
        </tr>
      </table>
    </td>
       <td width="2%" height="21">&nbsp;</td>
       <td width="7%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="12%" height="21" colspan="2">
	&nbsp;</td>
    <td width="5%" height="21">
	&nbsp;</td>
    <td width="76%" height="21" colspan="10" class="subtitle">&nbsp;</td>
  </tr>
  <tr>
    <td width="12%" height="21" colspan="2">
	</td>
    <td width="5%" height="21">
	&nbsp;</td>
    <td width="76%" height="21" colspan="10" class="subtitle">PREVIOUS SERVICE DETAILS</td>
  </tr>
  <tr>
    <td width="1%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="70%" colspan="8" height="21">
      <table border="1" width="100%" height="42">
        <tr>
          <td width="10%" rowspan="2" height="36" align="center" class="fieldname">
            S.No</td>
          <td width="13%" rowspan="2" height="36" align="center" class="fieldname">
            <p align="center" class="fieldname">Name of the Serivce</td>
          <td width="18%" colspan="2" height="19" align="center" class="fieldname">Serviced</td>
          <td width="12%" height="30" align="center" rowspan="2" class="fieldname">
			Difference KM Reading</td>
          <td width="12%" height="30" align="center" class="fieldname" rowspan="2">
			Amount</td>
          <td width="15%" height="30" align="center" rowspan="2" class="fieldname">Warranty/
            Guarantee</td>
          <td width="21%" height="30" align="center" rowspan="2" class="fieldname">Workshop Name</td>
        </tr>
        <tr>
          <td width="8%" height="11" align="center" class="fieldname">Date</td>
          <td width="10%" height="11" align="center" class="fieldname">KM</td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">1.</td>
          <td width="13%" height="36" align="center" class="fieldname">
			<html:text property="serviceName1" style="width:113"/></td>
          <td width="8%" height="11" align="center">
			<html:text property="previousServicedDate1" style="width:113"/></td>
          <td width="10%" height="11" align="center">
			<html:text property="previousServicedKm1" style="width:113"/></td>
          <td width="12%" height="30" align="center">
			<html:text property="differenceKm1" style="width:113"/></td>
          <td width="12%" height="11" align="center">
			<html:text property="previouslyServicedAmount1" style="width:113"/></td>
          <td width="15%" height="30" align="center">
			<html:text property="previouslyServicedWarranty1" style="width:113"/></td>
          <td width="21%" height="30" align="center">
			<html:text property="previouslyServicedWorkshopName1" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">2.</td>
          <td width="13%" height="36" align="center" class="fieldname">
			<html:text property="serviceName2" style="width:113"/></td>
          <td width="8%" height="11" align="center">
			<html:text property="previousServicedDate2" style="width:113"/></td>
          <td width="10%" height="11" align="center">
			<html:text property="previousServicedKm2" style="width:113"/></td>
          <td width="12%" height="30" align="center">
			<html:text property="differenceKm2" style="width:113"/></td>
          <td width="12%" height="11" align="center">
			<html:text property="previouslyServicedAmount2" style="width:113"/></td>
          <td width="15%" height="30" align="center">
			<html:text property="previouslyServicedWarranty2" style="width:113"/></td>
          <td width="21%" height="30" align="center">
			<html:text property="previouslyServicedWorkshopName2" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">3.</td>
          <td width="13%" height="36" align="center" class="fieldname">
			<html:text property="serviceName3" style="width:113"/></td>
          <td width="8%" height="11" align="center">
			<html:text property="previousServicedDate3" style="width:113"/></td>
          <td width="10%" height="11" align="center">
			<html:text property="previousServicedKm3" style="width:113"/></td>
          <td width="12%" height="30" align="center">
			<html:text property="differenceKm3" style="width:113"/></td>
          <td width="12%" height="11" align="center">
			<html:text property="previouslyServicedAmount3" style="width:113"/></td>
          <td width="15%" height="30" align="center">
			<html:text property="previouslyServicedWarranty3" style="width:113"/></td>
          <td width="21%" height="30" align="center">
			<html:text property="previouslyServicedWorkshopName3" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">4.</td>
          <td width="13%" height="36" align="center" class="fieldname">
			<html:text property="serviceName4" style="width:113"/></td>
          <td width="8%" height="11" align="center">
			<html:text property="previousServicedDate4" style="width:113"/></td>
          <td width="10%" height="11" align="center">
			<html:text property="previousServicedKm4" style="width:113"/></td>
          <td width="12%" height="30" align="center">
			<html:text property="differenceKm4" style="width:113"/></td>
          <td width="12%" height="11" align="center">
			<html:text property="previouslyServicedAmount4" style="width:113"/></td>
          <td width="15%" height="30" align="center">
			<html:text property="previouslyServicedWarranty4" style="width:113"/></td>
          <td width="21%" height="30" align="center">
			<html:text property="previouslyServicedWorkshopName4" style="width:113"/></td>
        </tr>
        <tr>
          <td width="10%" height="36" align="center" class="fieldname">5.</td>
          <td width="13%" height="36" align="center" class="fieldname">
			<html:text property="serviceName5" style="width:113"/></td>
          <td width="8%" height="11" align="center">
			<html:text property="previousServicedDate5" style="width:113"/></td>
          <td width="10%" height="11" align="center">
			<html:text property="previousServicedKm5" style="width:113"/></td>
          <td width="12%" height="30" align="center">
			<html:text property="differenceKm5" style="width:113"/></td>
          <td width="12%" height="11" align="center">
			<html:text property="previouslyServicedAmount5" style="width:113"/></td>
          <td width="15%" height="30" align="center">
			<html:text property="previouslyServicedWarranty5" style="width:113"/></td>
          <td width="21%" height="30" align="center">
			<html:text property="previouslyServicedWorkshopName5" style="width:113"/></td>
        </tr>
      </table>
    </td>
       <td width="2%" height="21">&nbsp;</td>
       <td width="7%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="1%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="70%" colspan="8" height="21" class="subtitle">&nbsp;</td>
       <td width="2%" height="21">&nbsp;</td>
       <td width="7%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="1%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="70%" colspan="8" height="21" class="subtitle">SERVICE RECOMMENDATION</td>
       <td width="2%" height="21">&nbsp;</td>
       <td width="7%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="1%" height="21">&nbsp;</td>
    <td width="7%" height="21">&nbsp;</td>
    <td width="5%" height="21">&nbsp;</td>
    <td width="70%" colspan="8" height="21">
      <table border="2" width="100%" height="178">
        <tr>
          <td width="8%" height="22" align="center" class="fieldname">S.No</td>
          <td width="32%" height="22" align="center">
            <p align="center" class="fieldname">Recommendation</td>
          <td width="32%" height="22" align="center">
            Mechanic Name</td>
        </tr>
        <tr>
          <td width="8%" height="19" align="center" class="fieldname">1.</td>
          <td width="32%" height="19" align="center">
            <html:select property="recommendation1">
		     <html:option value="0"> - - Choose Yes/No --</html:option>
             <html:option value="1">Yes</html:option>
             <html:option value="2">No</html:option>   
    		 </html:select>
</td>
          <td width="32%" height="19" align="center">
            <html:text property="mechanicName1" style="width:113"/></td>
        </tr>
        <tr>
          <td width="8%" height="19" align="center" class="fieldname">2.</td>
          <td width="32%" height="19" align="center">
           <html:select property="recommendation2">
		     <html:option value="0"> - - Choose Yes/No --</html:option>
             <html:option value="1">Yes</html:option>
             <html:option value="2">No</html:option>   
    		 </html:select>
</td>
          <td width="32%" height="19" align="center">
            <html:text property="mechanicName2" style="width:113"/></td>
        </tr>
        <tr>
          <td width="8%" height="19" align="center" class="fieldname">3.</td>
          <td width="32%" height="19" align="center">
            <html:select property="recommendation3">
		     <html:option value="0"> - - Choose Yes/No --</html:option>
             <html:option value="1">Yes</html:option>
             <html:option value="2">No</html:option>   
    		 </html:select>
</td>
          <td width="32%" height="19" align="center">
            <html:text property="mechanicName3" style="width:113"/></td>
        </tr>
        <tr>
          <td width="8%" height="19" align="center" class="fieldname">4.</td>
          <td width="32%" height="19" align="center">
            <html:select property="recommendation4">
		     <html:option value="0"> - - Choose Yes/No --</html:option>
             <html:option value="1">Yes</html:option>
             <html:option value="2">No</html:option>   
    		 </html:select>
</td>
          <td width="32%" height="19" align="center">
            <html:text property="mechanicName4" style="width:113"/></td>
        </tr>
        <tr>
          <td width="8%" height="19" align="center" class="fieldname">5.</td>
          <td width="32%" height="19" align="center">
            <html:select property="recommendation5">
		     <html:option value="0"> - - Choose Yes/No --</html:option>
             <html:option value="1">Yes</html:option>
             <html:option value="2">No</html:option>   
    		 </html:select>
</td>
          <td width="32%" height="19" align="center">
            <html:text property="mechanicName5" style="width:113"/></td>
        </tr>
      </table>
    </td>
       <td width="2%" height="21">&nbsp;</td>
       <td width="7%" height="21">&nbsp;</td>
  </tr>
  <tr>
    <td width="98%" height="21" colspan="13">&nbsp;</td>
  </tr>
  <tr>
    <td width="78%" height="21" colspan="11">
      <p align="center">
		<img border="0" src="<%=request.getContextPath()%>/images/SUB%20TO%20EO.jpg" width="100" height="18">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" width="60" height="18">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" width="60" height="18">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" width="80" height="18"></td>
  
  </tr>
</table>
</html:form>
</body>
</html:html>