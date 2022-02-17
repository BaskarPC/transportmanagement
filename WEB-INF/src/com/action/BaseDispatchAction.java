
package com.action;

// util imports:
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

/**
 * Implementation of Action that encapsulate the common functionality. This
 * class is intended to be a base class for all dispatch actions.
 *
 * @version $Revision: 1.1 $
 */
public abstract class BaseDispatchAction extends DispatchAction {
    //~ Static fields/initializers ---------------------------------------------

    /** logger instance */
	private static final Logger logger =
		(Logger) Logger.getInstance(BaseDispatchAction.class);

    //~ Methods ----------------------------------------------------------------

    /**
     * <p>
     * Process the specified HTTP request, and create the corresponding HTTP
     * response (or forward to another web component that will create it).
     * Return an <code>ActionForward</code> instance describing where and how
     * control should be forwarded.
     * </p>
     *
     * @param aMapping The ActionMapping used to select this instance
     * @param aForm The optional ActionForm bean for this request (if any)
     * @param aRequest The HTTP request we are processing
     * @param aResponse The HTTP response we are creating
     * @param aName The method name
     *
     * @return ActionForward The next action
     *
     * @throws Exception in case failure
     */
    protected ActionForward dispatchMethod(ActionMapping aMapping,
        ActionForm aForm, HttpServletRequest aRequest,
        HttpServletResponse aResponse, String aName)
        throws Exception {
        ActionForward forward = null;

        try {
            if (logger.isDebugEnabled()) {
				logger.debug("Mapping parm = " + aMapping.getParameter());
            }

            if (logger.isDebugEnabled()) {
				logger.debug("Button selected = " +
                    aRequest.getParameter(aMapping.getParameter()));
            }

            if (aRequest.getParameter(aMapping.getParameter()) == null) {
                if (logger.isDebugEnabled()) {
					logger.debug("Default method call.");
                }

                forward = defaultMethod(aMapping, aForm, aRequest, aResponse);
            } else {
                if (logger.isDebugEnabled()) {
					logger.debug("Executing LookupDispatchAction.");
                }

                forward = super.dispatchMethod(aMapping, aForm, aRequest,
                        aResponse, aName);
            }
        } catch (Exception e) {
			logger.error("Executing LookupDispatchAction.",e);
            return catchException(aMapping, aRequest, e);
        }

        return forward;
    }

    /**
     * <p>
     * All sub-classes must implement this method where if not action is
     * supplied the defaultMethod implementation will be executed.
     * </p>
     *
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @return ActionForward The next action
     */
    public abstract ActionForward defaultMethod(ActionMapping aMapping,
        ActionForm aForm, HttpServletRequest aRequest,
        HttpServletResponse aResponse)
        throws Exception;

    /**
     * <p>
     * Retrieves signed on user object from HttpSession.
     * </p>
     *
     * @param aRequest The HTTP request we are processing
     *
     * @return User logged in user
     */
 /*   protected User getUser(HttpServletRequest aRequest) {
        return (User) getSessionAttribute(aRequest, User.SIGNED_ON_USER_KEY);
    }
    */
/*
     * <p>
     * Retrieves an object from HttpSession.
     * </p>
     *
     * @param aRequest The HTTP request we are processing
     * @param aName The name of the attribute to be retrieved.
     *
     * @return Object the object returned for HttpSession
     */
    protected Object getSessionAttribute(HttpServletRequest aRequest,
        String aName) {
        if (logger.isDebugEnabled()) {
			logger.debug("Getting " + aName + " from session.");
        }

        Object obj = null;
        HttpSession session = aRequest.getSession(false);

        if (session != null) {
            obj = session.getAttribute(aName);
        }

        return obj;
    }

    /**
     * <p>
     * Removes an attribute from HttpSession.
     * </p>
     *
     * @param aRequest The HTTP request we are processing
     * @param aName The name of the attribute to be removed.
     */
    protected void removeSessionAttribute(HttpServletRequest aRequest,
        String aName) {
        if (logger.isDebugEnabled()) {
			logger.debug("Removing " + aName + " from session.");
        }

        HttpSession session = aRequest.getSession(false);

        if (session != null) {
            session.removeAttribute(aName);
        }
    }

    /**
     * <p>
     * Sets an object to the HttpSession
     * </p>
     *
     * @param aRequest The HTTP request we are processing
     * @param aName The name key of object.
     * @param aObject The object to be set on HttpSession.
     */
    protected void setSessionAttribute(HttpServletRequest aRequest,
        String aName, Object aObject) {
        if (logger.isDebugEnabled()) {
			logger.debug("Setting " + aName + " of type " +
                aObject.getClass().getName() + " on session.");
        }

        HttpSession session = aRequest.getSession(false);

        if (session != null) {
            session.setAttribute(aName, aObject);
        }
    }

    /**
     * Retrieve an object from the application scope by its name. This is a
     * convience method.
     *
     * @param aName The name key of object.
     *
     * @return Object the object returned for Application Scope
     */
    protected Object getApplicationAttribute(String aName) {
        return getServletContext().getAttribute(aName);
    }

    /**
     * Convenience method to get servlet context.
     *
     * @return ServletContext The context of web application
     */
    protected ServletContext getServletContext() {
        return servlet.getServletContext();
    }

    /**
     * Convenience method to initialize action errors in a subclass.
     *
     * @param aRequest the current request
     *
     * @return the populated (or empty) messages
     */
  /*  public ActionErrors getErrors(HttpServletRequest aRequest) {
        ActionErrors errors = null;
        HttpSession session = aRequest.getSession(false);

        if (aRequest.getAttribute(Globals.ERROR_KEY) != null) {
            errors = (ActionErrors) aRequest.getAttribute(Globals.ERROR_KEY);
            saveErrors(aRequest, errors);
        } else if (session.getAttribute(Globals.ERROR_KEY) != null) {
            errors = (ActionErrors) session.getAttribute(Globals.ERROR_KEY);
            saveErrors(aRequest, errors);
            session.removeAttribute(Globals.ERROR_KEY);
        } else {
            errors = new ActionErrors();
        }

        return errors;
    }*/

    /**
     * Convenience method to initialize messages in a subclass.
     *
     * @param aRequest the current request
     *
     * @return the populated (or empty) messages
     */
    public ActionMessages getMessages(HttpServletRequest aRequest) {
        ActionMessages messages = null;
        HttpSession session = aRequest.getSession(false);

        if (aRequest.getAttribute(Globals.MESSAGE_KEY) != null) {
            messages = (ActionMessages) aRequest.getAttribute(Globals.MESSAGE_KEY);
            saveMessages(aRequest, messages);
        } else if (session.getAttribute(Globals.MESSAGE_KEY) != null) {
            messages = (ActionMessages) session.getAttribute(Globals.MESSAGE_KEY);
            saveMessages(aRequest, messages);
            session.removeAttribute(Globals.MESSAGE_KEY);
        } else {
            messages = new ActionMessages();
        }

        return messages;
    }

    /**
     * <p>
     * Get localize message.
     * </p>
     *
     * @param aRequest The HTTP request we are processing
     * @param aKey the requested description key of resource bundle
     *
     * @return String the description for the key
     */
    protected String getMessage(HttpServletRequest aRequest, String aKey) {
        Locale locale = getLocale(aRequest);

        return getResources(aRequest).getMessage(locale, aKey);
    }

    /**
     * <p>
     * Uniform way of handling exceptions.
     * </p>
     * 
     * <p></p>
     *
     * @param aMapping The ActionMapping used to select this instance
     * @param aRequest The HTTP request we are processing
     * @param aCause Exception
     *
     * @return ActionForward The error action instance
     */
	protected ActionForward catchException(ActionMapping aMapping,
		HttpServletRequest aRequest, Throwable aCause) {
		
	   /* try {
			if (aCause instanceof BaseException) {
				BaseException e = (BaseException) aCause;

				errorId = e.getUniqueID();
			} else if (aCause instanceof BaseRuntimeException) {
				BaseRuntimeException e = (BaseRuntimeException) aCause;

				errorId = e.getUniqueID();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		if (errorId == null) {
			errorId = "-------";
		}*/

		//aRequest.setAttribute("errorId", StackTraceUtil.getExceptionId(aCause));
		//aRequest.setAttribute("errorMsg", StackTraceUtil.getRootMessage(aCause));
		aRequest.setAttribute("errorLink", "home.do");

		return aMapping.findForward("error");
	}
}
