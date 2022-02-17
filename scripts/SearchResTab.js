 /*==================================================================================
 * Copyright ©  2007 Swiss Re.  ALL RIGHTS RESERVED.
 * Filename: SearchResTab.js
 * Purpose:  Application Java Script's for the European Life Induction Tech Account application
 * 
 *==================================================================================*/

	 function clickClaims()
    {
		alert("clickClaims alert");
		document.forms[0].method="post"
        document.forms[0].action = "searchResClaim.do?invoke=defaultMethod&docSeqId1=<%=request.getParameter("docSeqId1")%>";
		document.forms[0].submit();
    }
	
	function clickGeneralBooking()
	{
		alert("clickGeneralBooking alert");
		document.forms[0].method="post"
        document.forms[0].action = "searchResGeneral.do?invoke=defaultMethod&docSeqId1=<%=request.getParameter("docSeqId1")%>";
		document.forms[0].submit();
	}

	function clickLargeLives()
	{
		alert("clickLargeLives alert");
		document.forms[0].method="post"
        document.forms[0].action = "searchResLarge.do?invoke=defaultMethod&docSeqId1=<%=request.getParameter("docSeqId1")%>";
		document.forms[0].submit();
	}
	function clickPremium()
	{
		alert("clickPremium alert");
		document.forms[0].method="post"
        document.forms[0].action = "searchResPremium.do?invoke=defaultMethod&docSeqId1=<%=request.getParameter("docSeqId1")%>";
		document.forms[0].submit();
	}
	function clickProfitComm()
	{
		alert("clickProfitComm alert");
		document.forms[0].method="post"
        document.forms[0].action = "searchResProfComm.do?invoke=defaultMethod&docSeqId1=<%=request.getParameter("docSeqId1")%>";
		document.forms[0].submit();

	}
	function clickStatRecon()
	{
		alert("clickStatRecon alert");
		document.forms[0].method="post"
		document.forms[0].action = "searchResStatRecon.do?invoke=defaultMethod&docSeqId1=<%=request.getParameter("docSeqId1")%>";	
		document.forms[0].submit();
           
	}

	
