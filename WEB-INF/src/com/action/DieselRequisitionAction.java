package com.action;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.dbcom.dbcom;
import com.formbean.DieselRequisitionForm;

import com.service.DieselRequisitionService;
import com.service.UploadDocService;

import com.util.imageUtil;
import com.vo.DieselRequisitionVO;


import com.wf.job;

//import com.wf.*;

public class DieselRequisitionAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(DieselRequisitionAction.class);
	job jb=new job();
	dbcom db=new dbcom();
	
	DieselRequisitionVO vo=new DieselRequisitionVO();
	DieselRequisitionService ds=new DieselRequisitionService();
	UploadDocService us=new UploadDocService();

	
	ArrayList res_list=new ArrayList();
	ArrayList res_list1=new ArrayList();
	ArrayList res_list2=new ArrayList();
	ArrayList res_list3=new ArrayList();
	int jobid=0;
	int taskid=0;
	/**
	 * default method
	 */
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,           
			HttpServletResponse response)
			throws Exception {		
			logger.debug("DieselAction:defaultMethod---------->");
			clear(form);
			ArrayList imglist=us.getImageList();
			logger.debug("imglist size "+imglist.size());
			HttpSession session = ((HttpServletRequest) request).getSession();
			String userName=(String) session.getAttribute("username");
			DieselRequisitionForm df=(DieselRequisitionForm)form;
			df.setFrom(userName);
			df.setTankCapacity("12000");
			String currentCapacity=ds.getCurrentCapacity();
			df.setCurrentCapacity(currentCapacity);
			
			df.setImagelist(imglist);
			return mapping.findForward("load");
		
	}
	
	/**
	 * This method is used to load the page
	 * 
	 * @param1 name: mapping Type: ActionMapping
	 * @param2 name: form Type: ActionForm
	 * @param3 name: request Type: HttpServletRequest
	 * @param4 name: res Type: HttpServletResponse
	 * @return ActionForward
	 * @throws TechAccountsException
	 * @description :
	 * 
	 */
	
	public ActionForward editMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			logger.debug("editMethod inside action class  <----------------");
			DieselRequisitionForm df = (DieselRequisitionForm) form;
			FormFile f=df.getFileName();
			String id=df.getImageName();
			logger.debug("image id"+id);
			us.editMethod(f,id);
			ArrayList imglist=us.getImageList();
			logger.debug("imglist size "+imglist.size());
			df.setImagelist(imglist);
			logger.debug("editMethod inside action class  ------------------->");
			return mapping.findForward("load");
	}
	
	public ActionForward uploadMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,           
			HttpServletResponse response) throws Exception
	{
		
		logger.debug("UploadDocument Method inside action class---->>>");
		DieselRequisitionForm df = (DieselRequisitionForm) form;
		FormFile f = df.getFileName();
		us.UploadFile(f,jobid,taskid);
		HttpSession session = ((HttpServletRequest) request).getSession();
		logger.debug("inside UPLOAD method");
		session.setAttribute("combo_display","true");
		ArrayList imglist=us.getImageList();
		logger.debug("imglist size "+imglist.size());
		df.setImagelist(imglist);
		logger.debug("UploadDocument Method inside action class <<<-------");
		return mapping.findForward("load");
		
	}
	public ActionForward deleteMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,           
			HttpServletResponse response) throws Exception
	{
	logger.debug("deleteMethod inside action class  <----------------");
	DieselRequisitionForm df = (DieselRequisitionForm) form;
	String imagename=df.getImageName();
	logger.debug("image name"+imagename);
	us.deleteImage(imagename);
	ArrayList imglist=us.getImageList();
	logger.debug("imglist size "+imglist.size());
	df.setImagelist(imglist);
	logger.debug("deleteMethod ------------->");
	return mapping.findForward("load");
		
	}
	
	public ActionForward viewMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,           
			HttpServletResponse response) throws Exception
	{
		
	logger.debug("viewMethod inside action class  <----------------");
	DieselRequisitionForm df = (DieselRequisitionForm) form;
	String strUploadCacheFolder = null;
	String strFileName = null;	
	String viewDocId = request.getParameter("documentId");
	String strIndexDocID=null;
	logger.debug("  viewDocId :" +  viewDocId );	
	if(viewDocId != null ) {
		strIndexDocID = viewDocId;
	} else {
		
	logger.debug("DieselRequisitionForm.getFiletxt():" +  strIndexDocID );
	}
	logger.debug("Document Id : " +  strIndexDocID );			
		File file = null;
		String strPath = getServletContext().getRealPath(request.getServletPath());
		int intIndex = strPath.lastIndexOf('/');
		if (intIndex == -1) {
			intIndex = strPath.lastIndexOf("\\");
		}
		strUploadCacheFolder = strPath.substring(0, intIndex);				
			strFileName = us.fetchFilename(strIndexDocID);
			file = us.retrieveFile(strIndexDocID,strUploadCacheFolder, strFileName);
			String strExt = "";
			String mimeType3 = null;
			int p = strFileName.lastIndexOf(".");
			logger.debug("index= " + p);
			strExt = strFileName.substring(p + 1, strFileName.length());				
			String header_info = request.getHeader("USER-AGENT");
			if (strExt != null) {
				mimeType3 = "text/x-whatever";
				response.reset();
			}
			mimeType3 = "text/x-whatever";
			if (("text/x- whatever".equals(mimeType3)) || ("application/pdf".equals(mimeType3))) {
				response.setHeader("Content-Disposition","attachment; filename=\"" + file.getName() + "\"");
			} else {
				response.setHeader("Content-Disposition","inline; filename=\"" + file.getName() + "\"");
			}				
			String mimeTypeName = getServletContext().getMimeType(file.getName()) + "; name=" + file.getName();
			HashMap indPayment = new HashMap();	
			indPayment.put("mimeType",mimeType3);
			indPayment.put("mimeTypeName",mimeTypeName);			
			logger.debug("ViewDoc");
			indPayment.put("header_info",header_info);	
			indPayment.put("file",file);
			imageUtil.viewDoc(response,indPayment);	
		
			logger.debug("imagenameMethod ------------->");
			return mapping.findForward("load");
			
    	}
	
	
	
	/**
	 *  to create the job and task
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	
	public ActionForward jobMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		String reqName="DieselRequisition";
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("username");
		String role=ds.getRole(userName);
		//if(role.equals("incharge"))
		//{
		logger.debug("inside job method");
		String ss1=mapping.getName();
		try{
		jobid=jb.creatJob(ss1,userName,reqName);
		}
		catch(Exception e)
		{
			logger.debug("error in job"+e);
		}
		logger.debug("job executed");
		insertvalues(jobid,form);
		logger.debug("insert executed");
		return mapping.findForward("success");
		//'}
		//'return mapping.findForward("load");
	}
	
	
	
	
	
	/*public ActionForward jobMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		
		logger.debug("inside job method");
		String ss1=mapping.getName();
		try{
		jobid=jb.creatJob(ss1);
		}
		catch(Exception e)
		{
			logger.debug("error in job"+e);
		}
		logger.debug("job executed");
		insertvalues(jobid,form);
		
		logger.debug("insert executed");
		return mapping.findForward("inb");
	
	}*/
	
	/**
	 * passes the jobid,taskid to change the status to 2 for the approve task of that form 
	 * and 0 for issue task  for the corresponding form
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	
	public ActionForward approveMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			
			 HttpSession session = ((HttpServletRequest) request).getSession();
			logger.debug("inside approve method");
			int job=(Integer)session.getAttribute("jobseq");
			logger.debug("job in acquire"+job);
			int task=(Integer)session.getAttribute("taskseqseq");
			logger.debug("task in acquire"+task);
			jb.approveStatus(job,task);
			return mapping.findForward("subtoincharge");
	}
	
	
	/**
	 * passes the jobid,taskid to change the status to 2 for the issue task of that form
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward okMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			 HttpSession session = ((HttpServletRequest) request).getSession();
			logger.debug("inside approve method");
			int job=(Integer)session.getAttribute("jobseq");
			logger.debug("job in acquire"+job);
			int task=(Integer)session.getAttribute("taskseqseq");
			logger.debug("task in acquire"+task);
			jb.okStatus(job,task);
			return mapping.findForward("taskcomplete");
	}
	
	
/**
 * to display the values in form 
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
public ActionForward inboxMethod(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	DieselRequisitionForm df=(DieselRequisitionForm)form;
	clear(form);	
	ArrayList list=new ArrayList();
	HttpSession session = ((HttpServletRequest) request).getSession();
	int jobid=(Integer)session.getAttribute("jobseq");
	list=ds.retrieve(jobid);
	logger.debug("list size.."+list.size());
	vo=(DieselRequisitionVO)list.get(0);
	logger.debug(vo.getDate()+vo.getFrom()+vo.getTankCapacity()+vo.getCurrentCapacity()+vo.getQtyNeeded());
	df.setDate(vo.getDate());
	df.setFrom(vo.getFrom());
	df.setTankCapacity(vo.getTankCapacity());
	df.setCurrentCapacity(vo.getCurrentCapacity());
	df.setQtyNeeded(vo.getQtyNeeded());
	
	return mapping.findForward("load");
}





public ActionForward clearMethod(ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	
	clear(form);
	return mapping.findForward("load");
}

/**
 * to insert the values in table
 * @param jobid
 * @param form
 */
public void insertvalues(int jobid,ActionForm form)
{
	DieselRequisitionForm df=(DieselRequisitionForm)form;
	/*String reqdate,reqfrom;
	int tank,current,need;
	reqdate=df.getDate();
	reqfrom=df.getFrom();
	tank=Integer.parseInt(df.getTankCapacity());	
	current=Integer.parseInt(df.getCurrentCapacity());
	need=Integer.parseInt(df.getQtyNeeded());*/
	DieselRequisitionService ds=new DieselRequisitionService();
	DieselRequisitionVO vo=new DieselRequisitionVO();
	vo.setJobid(jobid);
	vo.setDate(df.getDate());
	vo.setFrom(df.getFrom());
	vo.setTankCapacity(df.getTankCapacity());
	vo.setCurrentCapacity(df.getCurrentCapacity());
	vo.setQtyNeeded(df.getQtyNeeded());
	ds.insert(vo);	
	logger.debug("insertvalues : passed to service method");
	

}
/**
 * 
 * @param form
 */
public void clear(ActionForm form)
{
	DieselRequisitionForm df=(DieselRequisitionForm)form;
	df.setDate(null);
	df.setFrom(null);
	df.setCurrentCapacity(null);
	df.setTankCapacity(null);
	df.setQtyNeeded(null);
	
	
	
}
/**
 * to list the vehicle type based on the institution name
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */

/**
 * to list those vehicle number based on institution name and vehicle type
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
void clear(DieselRequisitionForm f)
{
	f.setDate(null);
	f.setFrom(null);
	f.setCurrentCapacity(null);
	f.setTankCapacity(null);
	f.setQtyNeeded(null);
}
}
