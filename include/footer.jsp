<!-- /**
 *********************************************************
 * Project Name		:	KONGU TRANSPORT MANAGEMENT SYSTEM 
 * Document Name	: 	Footer.jsp
 * Desc				:	This include jsp is used for Footer screen
 * Copyright (C) 2009 Department of Computer Applications
 * 
 **********************************************************
 */ -->
<!-- ===== FOOTER LINKS ===== -->
<html>
<head>
<LINK href="<%=request.getContextPath()%>/styles/footer.css" rel="styleSheet" type="text/css">

</head>

  <table>
	<tr>
	<img src=<%=request.getContextPath()%>/images/spacer.gif width=1 height=40>
	          </tr> 
  </table>


<!-- BEGIN TWO LEVEL FOOTER -->

  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr align=center>
      <td width=1 >
        <img src=<%=request.getContextPath()%>/images/spacer.gif width=1 height=17>
        </td>
      <td width="100%" class=medtop bgcolor=#81a7bd height="3%">
         <a href="filter.do?page=Home" target="_parent"><font color="#ffffff">Home</a> |</font>
         <a href="search.do?page=Search" target="_parent"><font color="#ffffff">Search</a> |</font>
	     <a href="contacts.do?" target="_parent"><font color="#ffffff">Contacts</a></font>
    </td>  
  </table>

<!-- END TWO LEVEL FOOTER -->

</html>