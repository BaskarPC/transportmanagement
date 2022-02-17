package com.action;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;

import com.action.BaseDispatchAction;
import com.formbean.OilGreaseRequisitionForm;
import com.formbean.PaintRequisitionForm;
import com.service.OilGreaseRequisitionService;
import com.service.PaintRequisitionService;
import com.vo.OilGreaseRequisitionVO;
import com.vo.PaintRequisitionVO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
public class PaintRequisitionAction extends BaseDispatchAction{
private static final Logger logger=(Logger)Logger.getLogger(PaintRequisitionAction.class);
PaintRequisitionService ps=new PaintRequisitionService();
PaintRequisitionVO vo=new PaintRequisitionVO();
	ArrayList list;
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm form, HttpServletRequest request,
	        HttpServletResponse response)throws Exception{
		logger.debug("PaintRequisitionAction: defaultMethod<-------------");
		PaintRequisitionForm pf=(PaintRequisitionForm)form;	
		ArrayList list=new ArrayList();
		HttpSession session = ((HttpServletRequest) request).getSession();
		String userName=(String) session.getAttribute("username");
		pf.setFrom(userName);
		pf.setItemDes("Paint");
		list=ps.fetchbrandlist();
		pf.setBrandNameList(list);		
		return aMapping.findForward("load");
	}
	public ActionForward paintColorMethod(ActionMapping aMapping,
	        ActionForm form, HttpServletRequest request,
	        HttpServletResponse response)throws Exception{
		logger.debug("PaintRequisitionAction: paintColorMethod<-------------");
		logger.debug("iddddd :"+request.getParameter("id"));
		int id=Integer.parseInt(request.getParameter("id"));
		PaintRequisitionForm pf=(PaintRequisitionForm)form;
		if(id==1) {
			String brandcode=pf.getBrandName1();
			list=ps.fetchbrandtype(brandcode);
			pf.setBrandCategoryList1(list);
			}
		else if(id==2) {
		 	String brandcode=pf.getBrandName2();
			list=ps.fetchbrandtype(brandcode);
			pf.setBrandCategoryList2(list);
			}
		else if(id==3) {
		 	String brandcode=pf.getBrandName3();
			list=ps.fetchbrandtype(brandcode);
			pf.setBrandCategoryList3(list);
			}
		else if(id==4) {
		 	String brandcode=pf.getBrandName4();
			list=ps.fetchbrandtype(brandcode);
			pf.setBrandCategoryList4(list);
			}
		else if(id==5) {
		 	String brandcode=pf.getBrandName5();
			list=ps.fetchbrandtype(brandcode);
			pf.setBrandCategoryList5(list);
			}
		
		return aMapping.findForward("load");
}
	public ActionForward availableMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
			PaintRequisitionForm pf=(PaintRequisitionForm)form;
		    logger.debug("availableQty Mtd --------->");
		    logger.debug("iddddd :"+request.getParameter("id"));
			int id=Integer.parseInt(request.getParameter("id"));
		    if(id==1) {
		    	logger.debug("inside id=1");
				logger.debug("available qty mtd :"+pf.getBrandName1() + "hai" + pf.getBrandType1());
				logger.debug(Integer.parseInt(pf.getBrandType1()));
				ArrayList list=ps.fetchAvailableQty(Integer.parseInt(pf.getBrandName1()),Integer.parseInt(pf.getBrandType1()));
				logger.debug("LIST SIZE :"+list.size());
				vo=(PaintRequisitionVO)list.get(0);
				logger.debug("available :"+vo.getAvailableQty1());
				//if(vo.getAvailableQty1().equals("null"))''
				String s=vo.getAvailableQty1();
				pf.setAvailableQty1(s);
				logger.debug("get available qty :"+pf.getAvailableQty1());
			}
			else  if(id==2) {
				
				logger.debug("available qty mtd :"+Integer.parseInt(pf.getBrandName2())+Integer.parseInt(pf.getBrandType2()));
				ArrayList list=ps.fetchAvailableQty(Integer.parseInt(pf.getBrandName2()),Integer.parseInt(pf.getBrandType2()));
				vo=(PaintRequisitionVO)list.get(0);
				pf.setAvailableQty2(vo.getAvailableQty2());
			}
			else  if(id==3) {
				
				logger.debug("available qty mtd :"+Integer.parseInt(pf.getBrandName3())+Integer.parseInt(pf.getBrandType3()));
				ArrayList list=ps.fetchAvailableQty(Integer.parseInt(pf.getBrandName3()),Integer.parseInt(pf.getBrandType3()));
				vo=(PaintRequisitionVO)list.get(0);
				pf.setAvailableQty3(vo.getAvailableQty3());
			}
			else  if(id==4) {
	
				logger.debug("available qty mtd :"+Integer.parseInt(pf.getBrandName4())+Integer.parseInt(pf.getBrandType4()));
				ArrayList list=ps.fetchAvailableQty(Integer.parseInt(pf.getBrandName4()),Integer.parseInt(pf.getBrandType4()));
				vo=(PaintRequisitionVO)list.get(0);
				pf.setAvailableQty4(vo.getAvailableQty4());
			}
			else  if(id==5) {
	
				logger.debug("available qty mtd :"+Integer.parseInt(pf.getBrandName5())+Integer.parseInt(pf.getBrandType5()));
				ArrayList list=ps.fetchAvailableQty(Integer.parseInt(pf.getBrandName5()),Integer.parseInt(pf.getBrandType5()));
				vo=(PaintRequisitionVO)list.get(0);
				pf.setAvailableQty5(vo.getAvailableQty5());
			}
			return mapping.findForward("load");
	}
}
