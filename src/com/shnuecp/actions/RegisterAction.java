package com.shnuecp.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shnuecp.domain.*;
import com.shnuecp.forms.*;
import com.shnuecp.service.*;

public class RegisterAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userform = (UserForm)form;
		Users user = new Users();
		UserService us = new UserService();
		user.setUsername(userform.getUsername());
		user.setPassword(userform.getPassword());
		user.setBalance(userform.getBalance());
		
		if(us.checkUsername(user)){
			return mapping.findForward("err");
		}else{
			if(user.getUsername().equals("")||user.getPassword().equals("")){
				return mapping.findForward("err");
			}
			else{
				us.userRegister(user);
				return mapping.findForward("ok");
			}
			
		}
	}

}
