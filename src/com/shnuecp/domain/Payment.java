package com.shnuecp.domain;

import com.shnuecp.service.*;

public class Payment {
	public boolean Pay(Users user, int totalPrice){
		int nbalance = user.getBalance();
		nbalance -= totalPrice;
		if(nbalance < 0){
			return false;
		}else{
			UserService us = new UserService();
			us.updateBalance(user, nbalance);
			user.setBalance(nbalance);
			return true;
		}
		
	}
}
