package com.action;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import com.action.BaseDispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
public class PaintPurchaseAction extends BaseDispatchAction{
private static final Logger logger=(Logger)Logger.getLogger(PaintPurchaseAction.class);

	
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("PaintSparepartsPurchaseAction: defaultMethod<-------------");		
		return aMapping.findForward("paipur");
		
	}

}
