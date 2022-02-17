<!-- /*==================================================================================
 * Copyright ©  2009 Department of Computer Applications  ALL RIGHTS RESERVED.
 * Filename: menu.jsp
 * Purpose:  This jsp is used by menu screen.
 * Classes:  
 *==================================================================================*/
 -->
 
<%
	//String strAdmin= (String)session.getAttribute("wmt_admin")==null?"":(String)session.getAttribute("wmt_admin");
	//String strReadonly= (String)session.getAttribute("ReadOnly")==null?"":(String)session.getAttribute("ReadOnly");

	String strAdmin= "wmt_admin";
	String strReadonly= "ReadOnly";
%>

<LINK rel="stylesheet" href="<%=request.getContextPath()%>/styles//CascadeMenu.css"></LINK>
<SCRIPT LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/scripts//CascadeMenu.js"></SCRIPT>
<script>
  function selectSpareParts()
  {  
    document.forms(0).method="post";
    document.forms(0).action = "<%=request.getContextPath()%>/spare.do?invoke=defaultMethod";
    document.forms(0).target="_parent";
    document.forms(0).submit();
  }
  function selectOil()
  {
    document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/oil.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectOutside()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/dieseloutside.do?invoke=defaultMethod";
    document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectFuel()
  {
    document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/diesel.do?invoke=defaultMethod";
    document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectPassingBill()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/passingbill.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectIssueReturn()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/return.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectKerosene()
  {  
    document.forms(0).method="post";
    document.forms(0).action = "<%=request.getContextPath()%>/kerosene.do?invoke=defaultMethod";
    document.forms(0).target="_parent";
    document.forms(0).submit();
  }
  function selectGrease()
  {
    document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/grease.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectScrap()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/scrap.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectScrapAuction()
  {
    document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/scrapissue.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectSmoke()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/fc.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectGeneral()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/general.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectPaint()
  {  
    document.forms(0).method="post";
    document.forms(0).action = "<%=request.getContextPath()%>/paint.do?invoke=defaultMethod";
    document.forms(0).target="_parent";
    document.forms(0).submit();
  }
  function selectWaste()
  {
    document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/waste.do?invoke=defaultMethod";
document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectService()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/service.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectServiceReq()
  {
    document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/servicereq.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectLabour()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/labour.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
 
 function selectTyreFitting()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/tyrefitting.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectTyreRemoval()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/tyreremoval.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
 
 function selectTyreRebuilt()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/rebuilt.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  
  function selectTyreRebuiltRequisition()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/rebuiltrequisition.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  
  function selectTyreRepairWork()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/tyrerepair.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  
  function selectTyreRepairWorkRequisition()
  {
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/repairrequisition.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  
  function selectCondemnTyre()
  {
   document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>/condemntyre.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
   function selectDriverPersonalDetails()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/driverpersonal.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectDriverOfficialDetails()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/driverofficial.do?method=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectDriverLicenceDetails()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/driverlicence.do?method=defaultMethod&mode=onload";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectDriverInsuranceDetails()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/driverpolicy.do?method=defaultMethod&mode=onload";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectDriverLeaveDetails()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/driverleave.do?invoke=defaultMethod&mode=onload";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectBusAllotmentDetails()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/busallotment.do?invoke=defaultMethod&mode=onload";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
   function selectVehicleDetails()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/vehicledetails.do?invoke=defaultMethod&mode=onload";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
   function selectRoadTaxDetails()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/roadtax.do?invoke=defaultMethod&mode=onload";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
   function selectVehicleInsuranceDetails()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/vehicleinsurance.do?invoke=defaultMethod&mode=onload";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
   function selectAccidentDetails()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/accident.do?invoke=defaultMethod&mode=onload";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
   function selectBreakDownDetails()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/breakdown.do?invoke=defaultMethod&mode=onload";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  
  function selectPersonal()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/driverpersonal.do?invoke=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectOfficial()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/driverofficial.do?method=defaultMethod";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
    function selectTyrePurchase()
  {  
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>"+"/tyrepurchase.do?invoke=defaultMethod";
  document.forms(0).submit();
  }
  function selectTyreRequisition()
{
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>"+"/req_tyre.do?method=defaultMethod";
  document.forms(0).submit();
}
  function selectGeneralNotePurchase()
  {  
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>"+"/generalnote.do?invoke=defaultMethod";
  document.forms(0).submit();
  }
  function selectGeneralNoteRequisition()
  {  
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>"+"/reqgeneralnote.do?invoke=defaultMethod";
  document.forms(0).submit();
  }
  function selectDieselRequisition()
  {  
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>"+"/req_diesel.do?invoke=defaultMethod";
  document.forms(0).submit();
  }

  
function selectPaintSpareRequisition()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/req_paintspare.do?invoke=defaultMethod&mode=onload";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  function selectPaintSparePurchase()
{
  document.forms(0).action = "<%=request.getContextPath()%>/paintspare.do?invoke=defaultMethod&mode=onload";
document.forms(0).target="_parent";
document.forms(0).submit();
}
 function selectGreaseOilRequisition()
  {
  document.forms(0).action = "<%=request.getContextPath()%>/req_greaseoil.do?invoke=defaultMethod&mode=onload";
  document.forms(0).target="_parent";
  document.forms(0).submit();
  }
  
function selectGreaseOilPurchase()
{
document.forms(0).method="post";
document.forms(0).action = "<%=request.getContextPath()%>/greaseoil.do?invoke=defaultMethod&mode=onload";
document.forms(0).submit();
  }
  
  function selectKeroseneRequisition()
  {  
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>"+"/kerosenerequisition.do?invoke=defaultMethod";
  document.forms(0).submit();
  }
  
  function selectDieselPurchase()
  {  
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>"+"/dieselpurchase.do?invoke=defaultMethod";
  document.forms(0).submit();
  }
  
  function selectPaintSparePurchase()
  {  
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>"+"/paintsparepurchase.do?invoke=defaultMethod";
  document.forms(0).submit();
  }
  
   function selectPaintSpareRequisition()
  {  
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>"+"/paintsparerequisition.do?invoke=defaultMethod";
  document.forms(0).submit();
  }
  
   function selectOilGreaseRequisition()
  {  
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>"+"/oilgreaserequisition.do?invoke=defaultMethod";
  document.forms(0).submit();
  }
  
   function selectKerosenePurchase()
  {  
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>"+"/kerosenepurchase.do?invoke=defaultMethod";
  document.forms(0).submit();
  }
  
  function selectOrderFromEO()
  {  
  document.forms(0).method="post";
  document.forms(0).action = "<%=request.getContextPath()%>"+"/orderFromEO.do?invoke=defaultMethod";
  document.forms(0).submit();
  }
  
</script>

<body onload="InitMenu()"; onclick="HideMenu(menuBar)"; id="Bdy">

<table width="100%" border="0" cellpadding="0" cellspacing="0" id="table2">
	<tr valign="top" >
		<td class = "NavLeftTable" >
			<table id="table3">
				<tr>
					<td class = "NavLeftTable" height="15" style="width:50">
						<a href="<%=request.getContextPath()%>/home.do" target="_parent" class = "NavLeftTable">
							Home
						 </a>
						 
					</td>
					<td class = "NavLeftTable" height="15" style="width:50">
						<a href="<%=request.getContextPath()%>/searchDocNew.do" target="_parent" class = "NavLeftTable">
							Search
						 </a>
						 
					</td>

				<td class = "NavLeftTable" height="15" style="width:40">
						<a href="<%=request.getContextPath()%>/inbox.do?invoke-defaultMethod" target="_parent" class = "NavLeftTable">
							Inbox
						 </a>
						
					</td>
					<td height="15" Id="menuBar" class="menuBar">
						<DIV Id="Bar4" class="Bar"  menu="menu4" style="width:80">Operations</DIV>
						<DIV Id="Bar5" class="Bar"  menu="menu5">Store</DIV>
						<DIV Id="Bar6" class="Bar"  menu="menu6" style="width:100">Maintenance</DIV>
						<DIV Id="Bar7" class="Bar"  menu="menu7">General</DIV>
						<DIV Id="Bar8" class="Bar"  menu="menu8">Tyre</DIV>
					</td>

				            <div Id="menu4" class="menu" style="width:170" >
				            <div style="width:170" Id="menuItem4_1" class="menuItem" onclick="selectDriverPersonalDetails();">Driver Personal</div>
				            <div style="width:170" Id="menuItem4_2" class="menuItem" onclick="selectDriverOfficialDetails();">Driver Official</div>
				            <div style="width:170" Id="menuItem4_3" class="menuItem" onclick="selectDriverLicenceDetails();">Driver Licence</div>
				            <div style="width:170" Id="menuItem4_4" class="menuItem" onclick="selectDriverInsuranceDetails();">Driver Insurance</div>
				            <div style="width:170" Id="menuItem4_5" class="menuItem" onclick="selectDriverLeaveDetails();">Driver Leave</div>   
							<div style="width:170" Id="menuItem4_6" class="menuItem" onclick="selectVehicleDetails();">Vehicle Purchase</div>
							<div style="width:170" Id="menuItem4_7" class="menuItem" onclick="selectBusAllotmentDetails();">Bus Allotment</div>
							<div style="width:170" Id="menuItem4_8" class="menuItem" onclick="selectRoadTaxDetails();">RoadTax</div>
							<div style="width:170" Id="menuItem4_9" class="menuItem" onclick="selectVehicleInsuranceDetails();">Vehicle Insurance</div>
							<div style="width:170" Id="menuItem4_10" class="menuItem" onclick="selectAccidentDetails();">Accident</div>
							<div style="width:170" Id="menuItem4_11" class="menuItem" onclick="selectBreakDownDetails();">BreakDown</div>
				          </div>

				          
				          <div Id="menu5" class="menu" style="width:170" >
				            <div style="width:170" Id="menuItem5_1" class="menuItem" onclick="selectTyrePurchase()">Tyre Purchase</div>
  						   	<div style="width:170" Id="menuItem5_2" class="menuItem" onclick="selectTyreRequisition()">Tyre Requisition</div>
  						    <div style="width:170" Id="menuItem5_3" class="menuItem" onclick="selectDieselReqisition()">Diesel Requisition</div>
  						    <div style="width:170" Id="menuItem5_4" class="menuItem" onclick="selectOrderFromEO()">Diesel Order From EO</div>
  						   	<div style="width:170" Id="menuItem5_5" class="menuItem" onclick="selectGeneralNoteRequisition()">GeneralNote Requisition</div>
  						    <div style="width:170" Id="menuItem5_6" class="menuItem" onclick="selectGeneralNotePurchase()">General note Purchase</div>
  						    <div style="width:170" Id="menuItem5_7" class="menuItem" onclick="selectKeroseneRequisition()">Kerosene and Waste Cloth Requisition</div>
  						    <div style="width:170" Id="menuItem5_8" class="menuItem" onclick="selectKerosenePurchase()">Kerosene and Waste Cloth Purchase</div>
  						    <div style="width:170" Id="menuItem5_9" class="menuItem" onclick="selectDieselPurchase()">Diesel purchase</div>
  						    <div style="width:170" Id="menuItem5_10" class="menuItem" onclick="selectPaintSpareRequisition()">Spare parts and Paint Requisition</div>
  						    <div style="width:170" Id="menuItem5_11" class="menuItem" onclick="selectPaintSparePurchase()">Spare parts and Paint Purchase</div>
  						    <div style="width:170" Id="menuItem5_12" class="menuItem" onclick="selectOilGreaseRequisition()">Oil Grease Requisition</div>
  						    <div style="width:170" Id="menuItem5_13" class="menuItem" onclick="selectGreaseOilPurchase()">Oil Grease Purchase</div>
  						  </div>
				          
				          <div Id="menu6" class="menu" style="width:170" >
				            <div style="width:170" Id="menuItem6_1" class="menuItem" onclick="selectSpareParts()">Spare Parts</div>
				            <div style="width:170" Id="menuItem6_2" class="menuItem" onclick="selectFuel()">Fuel Entry</div>
				            <div style="width:170" Id="menuItem6_3" class="menuItem" onclick="selectOutside()">Outside Fuel Entry</div>
				            <div style="width:170" Id="menuItem6_4" class="menuItem" onclick="selectOil()">Oil </div>
				            <div style="width:170" Id="menuItem6_5" class="menuItem" onclick="selectGrease()">Grease </div>   
					    	<div style="width:170" Id="menuItem6_6" class="menuItem" onclick="selectKerosene()">Kerosene </div>
					    	<div style="width:170" Id="menuItem6_7" class="menuItem" onclick="selectWaste()">Waste Cloth </div>
					    	<div style="width:170" Id="menuItem6_8" class="menuItem" onclick="selectPaint()">Paint </div>
					    	<div style="width:170" Id="menuItem6_9" class="menuItem" onclick="selectServiceReq()">Service Requisition</div>
					    	<div style="width:170" Id="menuItem6_10" class="menuItem" onclick="selectService()">Service</div>
					      </div>
		
					      <div Id="menu7" class="menu" style="width:170">
				          	<div style="width:170" Id="menuItem7_1" class="menuItem" onclick="selectSmoke()">FC Smoke Test</div>
					    	<div style="width:170" Id="menuItem7_2" class="menuItem" onclick="selectIssueReturn()">Issue Return</div>
					    	<div style="width:170" Id="menuItem7_3" class="menuItem" onclick="selectGeneral()">General Note</div>
				            <div style="width:170" Id="menuItem7_4" class="menuItem" onclick="selectPassingBill()">Passing Bill</div>
				            <div style="width:170" Id="menuItem7_5" class="menuItem" onclick="selectLabour()">Labour Charge </div>   
					    	<div style="width:170" Id="menuItem7_6" class="menuItem" onclick="selectScrap()">Scrap</div>
					    	<div style="width:170" Id="menuItem7_7" class="menuItem" onclick="selectScrapAuction()">Scrap Auction </div>
					      </div>
					      
				         <div Id="menu8" class="menu" style="width:170" >
				            <div style="width:170" Id="menuItem8_1" class="menuItem" onclick="selectTyreFitting()">Tyre Fitting</div>
				            <div style="width:170" Id="menuItem8_2" class="menuItem" onclick="selectTyreRemoval()">Tyre Removal</div>
				            <div style="width:170" Id="menuItem8_3" class="menuItem" onclick="selectTyreRebuilt()">Tyre Rebuilt</div>
				            <div style="width:170" Id="menuItem8_4" class="menuItem" onclick="selectTyreRebuiltRequisition()">Tyre Rebuilt Requisition</div>
				            <div style="width:170" Id="menuItem8_5" class="menuItem" onclick="selectTyreRepairWork()">Tyre Repair Work</div>   
					    	<div style="width:170" Id="menuItem8_6" class="menuItem" onclick="selectTyreRepairWorkRequisition()">Tyre Repair Work Requsition</div>
					    	<div style="width:170" Id="menuItem8_7" class="menuItem" onclick="selectCondemnTyre()">Condemn Tyre</div>
					     </div>

				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
