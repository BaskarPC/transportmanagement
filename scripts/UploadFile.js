 /*==================================================================================
 * Copyright ©  2007 Swiss Re.  ALL RIGHTS RESERVED.
 * Filename: UploadFile.js
 * Purpose:  Application Java Script's for the European Life Induction Tech Account application
 * 
 *==================================================================================*/

 function clickOK()
    {		
		
			 
			var frm = document.forms[0]; 
			frm.action = "uploadDocNew.do?invoke=UploadDocument";
			frm.submit();	 
		 
    }
	 function validateFile(field)
    {
        alert("Please select the file.");
        document.wmtUploadDocForm.fileName.focus();

    }
	
    var buttonCheck ="NEW";
	function checkDBClick()
	{
		
		if(buttonCheck=='OLD')
		{
			alert("This form has already been submitted.  Thanks!");
			return false;
		}
	}

	function populateUploadedDoc()
	{
		if (document.forms[0].filetxt.value=="")
		{
			document.forms[0].filetxt.focus();
			return false;
		}
		var docid = document.forms[0].filetxt.options[document.forms[0].filetxt.selectedIndex].value
		document.forms[0].hiddocumentId.value = docid;  
		document.forms[0].method="post";
		document.forms[0].action="uploadDocNew.do?invoke=defaultMethod";
		document.forms[0].submit();
	}
	function checkEnter()
	{

		if(event.keyCode == 13 && buttonCheck=='OLD')
		{
		  alert("This form has already been submitted.  Thanks!");
		  return false;
		}
	}
	function clickShow()
	{
		var strURLParam = "uploadDocNew.do?invoke=ViewDocument";		
            top.window.name = 'Show Document';
            win = window.open(strURLParam,'winShowDoc','');
			document.forms[0].submit();

	}
	function clickDelete()
	{
		document.forms[0].method="post"
		document.forms[0].action = "uploadDocNew.do?invoke=docDelete";	
		document.forms[0].submit();
           
	}

	function clickEdit()
	{
		if (document.forms[0].fileName.value=="")
		{
			alert("Select a file to upload ");
			document.forms[0].fileName.focus();
			return false;
		}
		else
		{
			document.forms[0].method="post"
			document.forms[0].action = "uploadDocNew.do?invoke=updateDocument";
			document.forms[0].submit();
		}
           
	}

