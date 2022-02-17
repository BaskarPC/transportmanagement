<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ include file="/include/taglibs.jsp"%>
<html:html>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//popcalendar.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/scripts//calendar1.js"> </script>
	
	<script>
	function clearmethod()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/req_diesel.do?invoke=clearMethod";	
		document.forms[0].submit();
	}
	function approve()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/req_diesel.do?invoke=approveMethod";	
		document.forms[0].submit();
	}
	
	function ok()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/req_diesel.do?invoke=okMethod";	
		document.forms[0].submit();
	}
	
	function submittoEO()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/req_diesel.do?invoke=jobMethod";	
		document.forms[0].submit();
	}
	function order()
	{
		alert("before")
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/orderFromEO.do?invoke=defaultMethod";	
		alert("after")
		document.forms[0].submit();
		alert("end")
	}
	function upload()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/req_diesel.do?invoke=uploadMethod";	
		document.forms[0].submit();
	}
	function edit()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/req_diesel.do?invoke=editMethod";	
		document.forms[0].submit();
	}
	function del()
	{
		document.forms[0].method="post";
		document.forms[0].action = "<%=request.getContextPath()%>"+"/req_diesel.do?invoke=deleteMethod";	
		document.forms[0].submit();
	}
	function imageview()
	{
	if (document.DieselRequisitionForm.imageName.value=="Select Image") {
	alert("Select correct image name")	
	} else {
	alert(document.DieselRequisitionForm.imageName.value)
		var strURLParam = "<%=request.getContextPath()%>"+"/req_diesel.do?invoke=viewMethod&documentId="+document.DieselRequisitionForm.imageName.value;	
		top.window.name = 'Show Document';
		win = window.open(strURLParam,'winShowDoc','');
	}
	}
	
</script>

<body > 
		<html:form action="req_diesel" enctype="multipart/form-data">
	
	<table border="0" width="985" id="table1" height="216">
		<tr>
			<td width="1147" colspan="4">
			<table border="0" width="100%" id="table2">
				<tr>
					<td width="324">&nbsp;</td>
					<td width="39">&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="324">&nbsp;</td>
					<td width="39">	
					<img border="0" src="<%=request.getContextPath()%>/images/deisel request.jpg" align="left"></td>
					<td class="maintitle">	
					<b>REQUISITION FOR DIESEL</b></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="324">&nbsp;</td>
					<td width="39">&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td width="328">
			<p align="left"></td>
			<td width="198" height="37" class="fieldname">
			<p align="left">Date</td>

			<td height="5" width="166">
			<p align="left"><html:text property="date"  style="width:113"/>
			
			<a href="#" onClick="showCalendar(this,document.DieselRequisitionForm.date,'dd mmm yyyy',null,1)" TITLE="cal01.select(document.DieselRequisitionForm.date,'anchor01','dd MMM yyyy'); return false;" NAME="anchor02" ID="anchor02">
		<img src="<%=request.getContextPath()%>/images/calendaricon.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date">
	</a>
			
			</td>

			<td height="5" width="276">
			<p align="left"></td>
		</tr>
		 <tr>
			<td width="328" height="37">&nbsp;</td>
			<td width="198" height="37" class="fieldname">
			<p align="left">Name</td>

			<td height="5" width="166">
			<p align="left"><html:text property="from"  style="width:113"/>
			</td>
	
			<td height="5" width="276">
			<p align="left"></td>
		</tr>
		
		<tr>
			<td width="328" height="31">&nbsp;</td>
			<td width="198" height="31" class="fieldname">
			<p align="left">Tank Capacity in Liters</td>

	
	
			<td height="5" width="166">
			<html:text property="tankCapacity"  style="width:113"/></td>
	
		<td height="5" width="276">
			<p align="left"></td>
		</tr>
		<tr>
			<td width="328" height="32">&nbsp;</td>
			<td width="198" height="32" class="fieldname">
			<p align="left">Current Capacity in Liters</td>

			<td height="5" width="166">
			<html:text property="currentCapacity"  style="width:113"/></td>

			<td height="5" width="276">
			<p align="left"></td>
		</tr>
		<tr>
			<td width="328" height="33">&nbsp;</td>
			<td width="198" height="33" class="fieldname">
			<p align="left">Needed Capacity in Liters</td>

			<td height="5" width="166">
			<html:text property="qtyNeeded"  style="width:113"/></td>
		<td height="5" width="276">
			<p align="left"></td>
		</tr>
		<tr>
			<td width="328">&nbsp;</td>
			<td width="198">&nbsp;</td>
			<td width="166">&nbsp;</td>
			<td width="276">&nbsp;</td>
		</tr>         
		<tr>
			<td width="500">&nbsp;</td>
			<td colspan="3">
			<p align="left">				
		<img border="0" src="<%=request.getContextPath()%>/images/CLEAR.jpg" onclick="javascript:clearmethod()">
		<img border="0" src="<%=request.getContextPath()%>/images/SUB TO EO.jpg" onclick="javascript:submittoEO()">&nbsp;
		<img border="0" src="<%=request.getContextPath()%>/images/APPROVE.jpg" onclick="javascript:approve()" >
		<img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" onclick="javascript:ok()" >
		<img border="0" src="<%=request.getContextPath()%>/images/btn_orderform.jpg" onclick="javascript:order()">
			
			<html:file  property="fileName" size ="10"></html:file><img border="0" src="<%=request.getContextPath()%>/images/OK.jpg" onclick="javascript:upload()">
			</td>
			<td>
            <html:select property="imageName" style="width:100" >
			<logic:present property="imagelist" name="DieselRequisitionForm">	
			<bean:define id="imagelist" name="DieselRequisitionForm" property="imagelist" type="java.util.Collection" >
			</bean:define>	
			<html:option value="Select Image"></html:option>
			<html:options collection="imagelist" property="id" labelProperty="imageName"></html:options>
			</logic:present>
			</html:select></td>
			
			<!--<td><% if (session.getAttribute("combo_display")=="true") { %>
			<html:text property="qtyNeeded"  style="width:113"/>
			<% } %>
			</td>-->
		</tr>		
		<tr>
		<img border="0" src="<%=request.getContextPath()%>/images/EDIT.jpg" onclick="javascript:edit()" >
		<img border="0" src="<%=request.getContextPath()%>/images/DELETE.jpg" onclick="javascript:del()" >
		<img border="0" src="<%=request.getContextPath()%>/images/VIEW.jpg" onclick="javascript:imageview()">
		</tr>
	</table>		
</html:form>

</body>

</html:html>