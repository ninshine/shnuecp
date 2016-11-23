package com.shnuecp.domain;

import java.util.*;

public class Sale {
	List<SaleLineItem> lineItems = new ArrayList<SaleLineItem>();
	
	public void makeLineItem(ProductDescription pd, int qty){
		boolean flag = true;
		SaleLineItem temp;
		
		Iterator<SaleLineItem> iter = lineItems.iterator();  
        
        while(iter.hasNext())  
        {  
        	temp = iter.next();
        	if(temp.getId() == pd.getId()){
        		temp.addQuantity(qty);
				flag = false;
				break;
			}
        }
        
		if(flag){
			SaleLineItem si = new SaleLineItem(pd,qty);
			lineItems.add(si);
		}
	}
	
	public void delLineItem(ProductDescription pd){
		for(int i=0; i<lineItems.size();i++){
			if(lineItems.get(i).getId()==pd.getId()){
				lineItems.remove(i);
				break;
			}
		}
	}
	
	public boolean makePayment(Users user){
		int totalPrice = 0;
		Payment p = new Payment();
		Iterator<SaleLineItem> iter = lineItems.iterator();  
        
        while(iter.hasNext())  
        {  
        	totalPrice += iter.next().getSubtotal();
        }
        
        if(p.Pay(user,totalPrice)){
        	lineItems.clear();
        	return true;
        }
        else{
        	return false;
        }
	}
	
	public boolean isEmpty(){
		Iterator<SaleLineItem> iter = lineItems.iterator();  
		if(iter.hasNext()){
			return true;
		}
		else 
			return false;
	}
	
	public void emptyCart(){
		lineItems.clear();
	}
	
	public List<String> getList(){
		SaleLineItem temp;
		List<String> ls = new ArrayList<String>();
		Iterator<SaleLineItem> iter = lineItems.iterator();  
        
        while(iter.hasNext())  
        {  
        	temp = iter.next();
        	ls.add(temp.getId()+" " +temp.getName()+" "+temp.getQuantity()+" "+temp.getSubtotal());
        }
        return ls;
	}
}
