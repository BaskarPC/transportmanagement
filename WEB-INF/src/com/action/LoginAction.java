/**
 * 
 */
package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import com.formbean.LoginForm;
import com.service.LoginService;
import com.action.BaseDispatchAction;
import java.util.ArrayList;
import com.vo.UserVO;
import com.vo.UserVerifyVO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * 
 * @author 
 *
 */
public class LoginAction  extends BaseDispatchAction{
	private static final Logger logger=(Logger)Logger.getLogger(LoginAction.class);

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward defaultMethod(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("LoginAction: defaultMethod<-------------");
		String username=aRequest.getParameter("userId");
		HttpSession session = ((HttpServletRequest) aRequest).getSession();
		session.setAttribute("userId",username);
		UserVerifyVO userVerVO=authenticateUser(aForm);
		String path=userVerVO.getPath();
		logger.debug("path === "+path);
		LoginForm loginForm=(LoginForm)aForm;
		ArrayList userList=new ArrayList();	
		logger.debug("user list size +++"+userList.size());
		logger.debug("user list size +++"+userVerVO.getUserList().size());
		aRequest.setAttribute("userList", userVerVO.getUserList());
		loginForm.setUserList(userVerVO.getUserList());
		logger.debug("path === "+path);
		logger.debug("LoginAction:defaultMethod---------->");
		return aMapping.findForward(path);
	}
	
	/**
	 * 
	 * @param aMapping-
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 */
	public ActionForward LoginSuccess(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse){
		
		
		LoginForm loginForm=(LoginForm)aForm;
		String uid=loginForm.getUserId();
		loginForm.setPassWord(uid);
		return aMapping.findForward("Success");
	}
	
	/**
	 * 
	 * @param aForm
	 * @return
	 * @throws Exception
	 */
	private UserVerifyVO authenticateUser(ActionForm aForm)throws Exception
	{
		String path="failure";
		LoginForm loginForm=(LoginForm)aForm;
		UserVO userVO=new UserVO();
		UserVerifyVO userVerVO=new UserVerifyVO();
		ArrayList userList=new ArrayList();
		int listSize;	
		userVO.setUserId(loginForm.getUserId());
		userVO.setPassWord(loginForm.getPassWord());
		LoginService loginService=new LoginService();
		userList=loginService.fetchUser(userVO);
		listSize=userList.size();
		logger.debug("userList Size :"+listSize);
		userVerVO.setUserList(userList);
		for(int i=0;i<listSize;i++)
		{
			UserVO userTaken=new UserVO();
			userTaken=(UserVO)userList.get(i);
			logger.debug("userId "+i+"   :"+userTaken.getUserId());
			logger.debug("password "+i+"   :"+userTaken.getPassWord());
			if(loginForm.getUserId().equals((userTaken.getUserId().toString()).trim()) 
					&& loginForm.getPassWord().equals((userTaken.getPassWord().toString()).trim()))
			{
				path="success";
				logger.debug("inside if");
				break;
			}
		}
		userVerVO.setPath(path);
		
		return userVerVO;
	}
	
	/**
	 * 
	 * @param aMapping
	 * @param aForm
	 * @param aRequest
	 * @param aResponse
	 * @return
	 * @throws Exception
	 */
	public ActionForward changePassword(ActionMapping aMapping,
	        ActionForm aForm, HttpServletRequest aRequest,
	        HttpServletResponse aResponse)throws Exception{
		logger.debug("changePassword---------->");
		UserVerifyVO userVerVO=authenticateUser(aForm);
		String path=userVerVO.getPath();
		LoginForm loginForm=(LoginForm)aForm;
		if(path.equals("success"))
		{
			path="chgPassword";
		}else
		{
			path="failure";
		}	
		//aRequest.setAttribute("userId", loginForm.getUserId());
		logger.debug("changePassword<----------");
		return aMapping.findForward(path);
	}

}
