package com.shnuecp.service;

import com.shnuecp.utils.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shnuecp.domain.*;

public class UserService {
	public boolean checkUser(Users user) throws SQLException
	{
		String sql="select * from user where username = ? limit 1";
		SqlHelper sqlHelper = new SqlHelper();
		String[] parameters = {user.getUsername()} ;
		
		ResultSet s = sqlHelper.executeQuery(sql, parameters);
		
		if(s.next()){
			if(user.getPassword().equals(s.getString("password").trim()))
				return true;
			else return false;
		}else
			return false;
	}
	
	public boolean checkUsername(Users user) throws SQLException{
		String sql="select * from user where username = ? limit 1";
		SqlHelper sqlHelper = new SqlHelper();
		String[] parameters = {user.getUsername()} ;
		
		ResultSet s = sqlHelper.executeQuery(sql, parameters);
		
		if(s.next()){
			return true;
		}else
			return false;
	}
	
	public int getBalance(Users user) throws SQLException{
		String sql="select * from user where username = ? limit 1";
		SqlHelper sqlHelper = new SqlHelper();
		String[] parameters = {user.getUsername()} ;
		ResultSet s = sqlHelper.executeQuery(sql, parameters);
		return s.getInt("balance");
	}
	
	public boolean userRegister(Users user) throws SQLException{
		//Register
		String sql="insert into user (username, password, isAdmin, balance) values (?, ?, ?, ?)";
		SqlHelper sqlHelper = new SqlHelper();
		String[] parameters = {user.getUsername(), user.getPassword(), String.valueOf(user.getIsAdmin()), String.valueOf(user.getBalance())} ;
		sqlHelper.executeUpdate(sql, parameters);
		//Check
		String nsql="select * from user where username = ? limit 1";
		SqlHelper nsqlHelper = new SqlHelper();
		String[] nparameters = {user.getUsername()} ;
		ResultSet ns = nsqlHelper.executeQuery(nsql, nparameters);
		if(ns.next()){
			return true;
		}else
			return false;
	}
	
	public boolean isAdmin(Users user) throws SQLException{
		String sql="select * from user where username = ? limit 1";
		SqlHelper sqlHelper = new SqlHelper();
		String[] parameters = {user.getUsername()} ;
		ResultSet s = sqlHelper.executeQuery(sql, parameters);
		if(s.next()){
			if(s.getInt("isAdmin")==1)
				return true;
			else 
				return false;
		}else
			return false;
	}
	
	public void updateBalance(Users user, int nbalance){
		String sql="update user set balance = ? where username = ?";
		SqlHelper sqlHelper = new SqlHelper();
		String[] parameters = {String.valueOf(nbalance),user.getUsername()} ;
		sqlHelper.executeUpdate(sql, parameters);
	}
}
