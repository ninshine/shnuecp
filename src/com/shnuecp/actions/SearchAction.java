package com.shnuecp.actions;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shnuecp.domain.ProductDescription;
import com.shnuecp.forms.*;
import com.shnuecp.service.*;

public class SearchAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		return super.execute(mapping, form, request, response);
		SearchForm searchform = (SearchForm) form;
		ProductService ps = new ProductService();
		List<ProductDescription> res = new ArrayList<ProductDescription>();
		int pageSize = 2;
		int currentPage = 1;
		currentPage = searchform.getCurrentPage();
		int pageCount = 0;
		pageCount = ps.getPageCount(pageSize);
		System.out.println(pageSize);
		System.out.println(currentPage);
		
		if(searchform.getKeyword().equals("")){
			res = ps.getProductList(currentPage,pageSize);
			request.setAttribute("itemlist", res);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("keyword", searchform.getKeyword());
			return mapping.findForward("ok");
		}
		else{
			String KeyWord = null;
			KeyWord = '%'+searchform.getKeyword()+'%';
			res = ps.searchProductList(KeyWord,currentPage,pageSize);
			request.setAttribute("itemlist", res);
			request.setAttribute("currentPage", currentPage);
			pageCount = ps.getPageCountWithKeyword(pageSize,KeyWord);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("keyword", searchform.getKeyword());
			return mapping.findForward("ok");
		}
	}
	
}
