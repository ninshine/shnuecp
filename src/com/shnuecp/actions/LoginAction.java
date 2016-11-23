package com.shnuecp.actions;

import com.shnuecp.domain.*;
import com.shnuecp.service.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shnuecp.forms.UserForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserForm userform = (UserForm)form;
		
		UserService userService = new UserService();
		Users user = new Users();
		user.setUsername(userform.getUsername());
		user.setPassword(userform.getPassword());
		if(userService.checkUsername(user)){
			if(userService.checkUser(user)){
				return mapping.findForward("ok");
			}else{
				request.setAttribute("err", "UPErr");
				return mapping.findForward("err");
			}
		}
		else{
			request.setAttribute("err", "NameErr");
			return mapping.findForward("err");
		}
		
	}
}
