package com.action;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.action.BaseDispatchAction;
import com.formbean.CondemnTyreForm;
import com.formbean.TyreFittingForm;
import com.service.CondemnTyreService;
import com.service.TyreFittingService;
import com.vo.CondemnTyreVO;

public class CondemnTyreAction extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(CondemnTyreAction.class);
	CondemnTyreService condemntyreservice =new CondemnTyreService();
	CondemnTyreVO condemntyrevo=new CondemnTyreVO();
	public ActionForward defaultMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		
		CondemnTyreForm condemntyreform=(CondemnTyreForm)form;	
		/**
		 * Setting  Tyre Size to Combo Box
		 */	
	    ArrayList tyreSizeList=new ArrayList();
	    tyreSizeList=condemntyreservice.tyreSizeCombo();
		condemntyreform.setTyreSizeList(tyreSizeList);
	    
	    /**
		 * Setting  Tyre Brand to Combo Box
		 */	
	    ArrayList tyreBrandList=new ArrayList();
	    tyreBrandList=condemntyreservice.tyreBrandCombo();
		condemntyreform.setTyreBrandList(tyreBrandList);
	    /**
		 * Setting  Tyre Ply to Combo Box
		 */	
	    ArrayList tyrePlyList=new ArrayList();
	    tyrePlyList=condemntyreservice.tyrePlyCombo();
		condemntyreform.setTyrePlyList(tyrePlyList);
	    return mapping.findForward("load");
    }
	
	public ActionForward tyreNumberMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		ArrayList list=new ArrayList();
		CondemnTyreForm condemntyreform=(CondemnTyreForm)form;
		int tyreSize=Integer.parseInt(condemntyreform.getTyreSize());
		int tyrePly=Integer.parseInt(condemntyreform.getTyrePly());
		int tyreBrand=Integer.parseInt(condemntyreform.getTyreBrand());
		list=condemntyreservice.tyreNumberCombo(tyreSize,tyreBrand,tyrePly);
		condemntyreform.setTyreNumberList(list);
		return mapping.findForward("load");
	}
	
	public ActionForward tyreStatusMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		ArrayList tyreStatusList=new ArrayList();
		CondemnTyreForm condemntyreform=(CondemnTyreForm)form;
		String tyreNumber=condemntyreform.getTyreNumber();
		tyreStatusList=condemntyreservice.fetchTyreStatus(tyreNumber);
		condemntyrevo=(CondemnTyreVO)tyreStatusList.get(0);
		condemntyreform.setTyreStatus(condemntyrevo.getTyreStatus());
		return mapping.findForward("load");
	}
	
	public ActionForward saveMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		CondemnTyreForm condemntyreform=(CondemnTyreForm)form;
		String tyreNumber=condemntyreform.getTyreNumber();
		String tyreStatus=condemntyreform.getTyreStatus();
		String condemnDate=condemntyreform.getCondemnTyreDate();
		String condemnReason=condemntyreform.getCondemnTyreReason();
		condemntyreservice.insert(tyreNumber,tyreStatus,condemnDate,condemnReason);
		condemntyreservice.updateTyreMaster(tyreNumber);
		return mapping.findForward("load");
	}
	public ActionForward clearMethod(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		CondemnTyreForm condemntyreform=(CondemnTyreForm)form;
		condemntyreform.setTyreSize(null);
		condemntyreform.setTyreBrand(null);
		condemntyreform.setTyreNumber(null);
		condemntyreform.setTyrePly(null);
		condemntyreform.setCondemnTyreDate(null);
		condemntyreform.setCondemnTyreReason(null);
		condemntyreform.setTyreStatus(null);
		return mapping.findForward("load");
	}
}