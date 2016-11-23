package com.shnuecp.domain;

import java.sql.SQLException;
import java.util.*;


public class Controller {
	Sale s = new Sale();
	ProductCatalog pc = new ProductCatalog();
	
	public boolean enterItem(int id, int qty) throws SQLException{
		ProductDescription pd = new ProductDescription();
		if(pc.checkProductId(id)){
			pd = pc.getProductDesc(id);
			s.makeLineItem(pd, qty);
			return true;
		}
		else
			return false;
	}
	
	public boolean endSale(Users user){
		if(s.makePayment(user)){
			return true;
		}else{
			return false;
		}
	}
	
	public void emptyCart(){
		s.emptyCart();
	}
	
	public boolean checkEmpty(){
		return s.isEmpty();
	}
	
	public List<String> showList(){
		return s.getList();
	}
	
	public boolean delItem(int id) throws SQLException{
		ProductDescription pd = new ProductDescription();
		if(pc.checkProductId(id)){
			pd = pc.getProductDesc(id);
			s.delLineItem(pd);
			return true;
		}
		else
			return false;
	}
}
