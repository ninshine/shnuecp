package com.shnuecp.forms;

import org.apache.struts.action.ActionForm;

public class SearchForm extends ActionForm {
	private String keyword= "";
	private int currentPage = 1;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
