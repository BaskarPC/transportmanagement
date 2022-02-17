
<%@ include file="/include/taglibs.jsp"%>
<%
	String url =  request.getContextPath()+"/BusAllotment.do";
%>
<html:html>

	<head>
		<title>Bus Allotment Details</title>
 	</head>
 		<script language="JavaScript" src = "<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	<script language="JavaScript">
	
		function equipmentForm()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/equipmentallotment.do?invoke=defaultMethod";	
		document.forms[0].submit();
	}	
		function nameretrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/busallotment.do?invoke=nameretrieveMethod";	
		document.forms[0].submit();
	}		
		function insert()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/busallotmentvalidate.do?invoke=insertMethod";	
		document.forms[0].submit();
	}
	function update()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/busallotmentvalidate.do?invoke=updateMethod";	
		document.forms[0].submit();
	}
	   function vehicletyperetrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/busallotment.do?invoke=vehicletyperetrieveMethod";	
		document.forms[0].submit();
	}	
	  function vehicleretrieve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/busallotment.do?invoke=vehicleretrieveMethod";	
		document.forms[0].submit();
	}
	  function retrieveall()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/busallotment.do?invoke=retrieveallMethod";	
		document.forms[0].submit();
	}	
		function clearform()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/busallotment.do?invoke=clearformMethod";	
		document.forms[0].submit();
	}		
		function deleteindicator()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/busallotment.do?invoke=deleteindicatorMethod";	
		document.forms[0].submit();
	}	
	</script>
<body>
<html:form action="busallotment" enctype="multipart/form-data">

<table border="0" width="100%" height="113%" cellpadding="5" cellspacing="8">
  <tr>
    <td width="15%" align="left" height="33" >
    </td>
    <td width="50" align="left" height="33" class="maintitle" >
      	<img border="0" src="<%=request.getContextPath()%>/images/icn_busallotment.jpg" width="40" height="40" align="right"></td>
    <td width="310" align="left" height="33" class="maintitle" >
      VEHICLE ALLOTMENT DETAILS</td>
  </tr>
  
  <tr>
    <td width="15%" align="left" height="21">
      </td>
    <td width="283" align="left" height="21" class="fieldname" colspan="2">
      <p align="left">Name of the Institution</td>
    <td width="549" align="left" height="21" class="fieldname">
            <html:select property="instituteName" style="width:145" onchange="vehicletyperetrieve()">
            <logic:present property="instList" name="BusAllotmentForm">
            <bean:define id="instList" property="instList" name="BusAllotmentForm" type="java.util.Collection">
            </bean:define>
             <html:option value="--Choose Institution --"></html:option>
         	<html:options collection="instList" property="instcode" labelProperty="instdesc"></html:options>
         	</logic:present>                                         
      	</html:select>
      </td>
  </tr>
  
  <tr>
    <td width="15%" align="left" height="21">
      </td>
    <td width="283" align="left" height="21" class="fieldname" colspan="2">
      <p align="left">Vehicle Type</td>
    <td width="549" align="left" height="21" class="fieldname">
            <html:select property="vehicleType" style="width:145" onchange="vehicleretrieve()">
            <logic:present property="vehicletypeList" name="BusAllotmentForm">
            <bean:define id="vehicletypeList" property="vehicletypeList" name="BusAllotmentForm" type="java.util.Collection">
            </bean:define>
             <html:option value="--Choose VehicleType --"></html:option>
         	<html:options collection="vehicletypeList" property="vehicletypecode" labelProperty="vehicletypedesc"></html:options>
         	</logic:present>                                         
      	</html:select>
      </td>
  </tr>
  
 <tr>
    <td width="15%" align="left" height="21">
     </td>
    <td width="283" align="left" height="21" class="fieldname" colspan="2">
      Vehicle Registration Number</td>
    <td width="549" align="left" height="21" class="fieldname">
         <html:select property="vehicleId" style="width:145" onchange="retrieveall()">
         <logic:present property="vehicleidList" name="BusAllotmentForm">
         <bean:define id="vehicleidList" property="vehicleidList" name="BusAllotmentForm" type="java.util.Collection">
         </bean:define>
         <html:option value="--Choose Vehicle ID --"></html:option>
		 <html:options collection="vehicleidList" property="vehicleidcode" labelProperty="vehicleiddesc"></html:options>
		 </logic:present>
		 </html:select>
	 </td>
 </tr>
 
 <tr>
    <td width="15%" align="left" height="21">
    </td>
    <td width="283" align="left" height="21" class="fieldname" colspan="2">
      Driver ID</td>
    <td width="549" align="left" height="21" class="fieldname">
    <html:select property="driverId" style="width:145" onchange="nameretrieve()">
    <logic:present property="driveridList" name="BusAllotmentForm">
    <bean:define id="driveridList" property="driveridList" name="BusAllotmentForm" type="java.util.Collection">
    </bean:define>
    <html:option value="--Choose Driver ID --"></html:option>
	<html:options collection="driveridList" property="drivercode" labelProperty="driverdesc"></html:options>
    </logic:present> 
	</html:select>
    </td>
</tr>

<tr>
    <td width="15%" align="left" height="21">
      </td>
    <td width="283" align="left" height="21" class="fieldname" colspan="2">
    <p align="left">Driver Name</td>
    <td width="549" align="left" height="21" class="fieldname">
    <html:text property="driverName" style="width:113"/>
    </td>
 </tr>
 
   <tr>
    <td width="15%" align="left" height="25">
    </td>
    <td width="283" align="left" height="25" class="fieldname" colspan="2">
    <p align="left">Vehicle Allotted Date</td>
    <td width="549" align="left" height="25" class="fieldname">
    <html:text property="vehicleAllottedDate" style="width:113"/>
     <a href="#" onClick="showCalendar(this,document.BusAllotmentForm.vehicleAllottedDate,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.BusAllotmentForm.vehicleAllottedDate,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
	 <img src="<%=request.getContextPath()%>/images/icn_calendar.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	 </a>
     </td>
</tr>

<% 
out.println(session.getAttribute("VEHICLE_TYPE"));
if(session.getAttribute("VEHICLE_TYPE")!=null && session.getAttribute("VEHICLE_TYPE").toString().equals("Bus")) { 
%>

<tr>
    <td width="15%" align="left" height="1">
     </td>
    <td width="283" align="left" height="1" class="fieldname" colspan="2">
     <p align="left">Route Number</td>
    <td width="549" align="left" height="1" class="fieldname">
    <html:text property="routeNo" style="width:113"/>
    </td>
</tr>
<tr>
    <td width="15%" align="left" height="19">
    </td>
    <td width="283" align="left" height="19" class="fieldname" colspan="2">
      KM Traveled per day</td>
    <td width="549" align="left" height="19" class="fieldname">
    <html:text property="kmTravelledPerDay" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="15%" align="left" height="19">
      </td>
    <td width="283" align="left" height="19" class="fieldname" colspan="2">
      <p align="left">Starting place</td>
    <td width="549" align="left" height="19" class="fieldname">
     <html:text property="startPlace" style="width:113"/>
     </td>
  </tr>
  
  <tr>
    <td width="15%" align="left" height="19" class="fieldname">
      </td>
    <td width="283" align="left" height="19" class="fieldname" colspan="2">
      Via</td>
    <td width="549" align="left" height="19" class="fieldname">
     <html:text property="via" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="15%" align="left" height="19">
      </td>
    <td width="283" align="left" height="19" class="fieldname" colspan="2">
      <p align="left">Last Stop</td>
    <td width="549" align="left" height="19" class="fieldname">
    <html:text property="lastStop" style="width:113"/>
    </td>
  </tr>
  
  <tr>
    <td width="15%" align="left" height="19">
      </td>
    <td width="283" align="left" height="19" class="fieldname" colspan="2">
      Halt Place</td>
    <td width="549" align="left" height="19" class="fieldname">
    <html:text property="haltPlace" style="width:113"/></td>
  </tr>
  
  <tr>
    <td width="15%" align="left" height="19">
      </td>
    <td width="283" align="left" height="19" class="fieldname" colspan="2">
      <p align="left">Phone Number of Halt Place</td>
    <td width="549" align="left" height="19">
    </td>
  </tr>
  
  <tr>
    <td width="15%" align="center" height="18">
    </td>
    <td width="283" align="center" height="18" class="fieldname" colspan="2">
      <p align="center">
           Residential</p>
    </td>
    <td width="549" align="left" height="18" class="fieldname">
         <html:text property="residentialNo" style="width:113"/>
      </td>
  </tr>
  
  <tr>
    <td width="15%" align="center" height="19">
      </td>
    <td width="283" align="center" height="19" class="fieldname" colspan="2">
      <p align="center">Office</td>
    <td width="549" align="left" height="19" class="fieldname">
             <html:text property="officeNo" style="width:113"/>
    </td>
  </tr>
  <tr>
    <td width="15%" align="left" height="19">
     </td>
    <td width="283" align="left" height="19" class="fieldname" colspan="2">
      <p align="left">Permitted Districts</td>
    <td width="549" align="left" height="19" class="fieldname">
          <html:select property="districtarray" style="width:145" multiple="true">
 		  <logic:present property="districtList" name="BusAllotmentForm">
 		  <bean:define id="districtList" property="districtList" name="BusAllotmentForm" type="java.util.Collection">
 		  </bean:define>
    		<html:option value="--Choose District--"></html:option>
			<html:options collection="districtList" property="districtcode" labelProperty="districtdesc"></html:options>
			</logic:present>
     		</html:select>
     		  <html:textarea property="permittedDistrict" style="width:100"/>
          </td>
  </tr>
  
   <% } %>
  
  <tr>
    <td width="15%" align="left" height="59">
              </td>
    <td width="830" align="left" height="59" colspan="3">
             
				<img border="0" src="<%=request.getContextPath()%>/images/btn_save.jpg" width="60" height="18" onclick="insert()">
				<img border="0" src="<%=request.getContextPath()%>/images/btn_edit.jpg" width="60" height="18">
				<img border="0" src="<%=request.getContextPath()%>/images/btn_update.jpg" width="60" height="18" onclick="update()">
				<img border="0" src="<%=request.getContextPath()%>/images/btn_delete.jpg" width="60" height="18" onclick="deleteindicator()">
				<img border="0" src="<%=request.getContextPath()%>/images/btn_clear.jpg" width="60" height="18" onclick="clearform()">
				<img border="0" src="<%=request.getContextPath()%>/images/btn_equipmentform.jpg" width="140" height="18" onclick ="equipmentForm()"></p>
   </td>
  </tr>
  </table>
</html:form>
</body>
</html:html>