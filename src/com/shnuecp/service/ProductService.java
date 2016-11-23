package com.shnuecp.service;

import com.shnuecp.utils.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shnuecp.domain.*;

public class ProductService {
	
	public boolean checkItemid(int id) throws SQLException{
		String sql="select * from item where id = ? limit 1";
		SqlHelper sqlHelper = new SqlHelper();
		String[] parameters = {String.valueOf(id)} ;
		
		ResultSet s = sqlHelper.executeQuery(sql, parameters);
		
		if(s.next()){
			return true;
		}else
			return false;
	}
	
	public ProductDescription getItemDesc(int id) throws SQLException{
		ProductDescription pd = null;
		String sql="select * from item where id = ? limit 1";
		SqlHelper sqlHelper = new SqlHelper();
		String[] parameters = {String.valueOf(id)} ;
		
		ResultSet s = sqlHelper.executeQuery(sql, parameters);
		
		pd.setId(s.getInt("id"));
		pd.setName(s.getString("name"));
		pd.setPrice(s.getInt("price"));
		return pd;
	}
	
	public List<ProductDescription> getProductList(int currentPage, int pageSize) throws SQLException{
		ProductDescription[] pd = new ProductDescription[100];
		List<ProductDescription> res = new ArrayList<ProductDescription>();
		String sql="select * from item limit "+(currentPage-1)*pageSize+","+pageSize;
		System.out.println((currentPage-1)*pageSize+","+pageSize);
		SqlHelper sqlHelper = new SqlHelper();
		String[] parameters = {};
		int i =0;
		ResultSet s = sqlHelper.executeQuery(sql, parameters);
		
		while(s.next()){
			pd[i] = new ProductDescription();
			pd[i].setId(s.getInt("id"));
			pd[i].setName(s.getString("name"));
			pd[i].setPrice(s.getInt("price"));
			res.add(pd[i]);
			i++;
		}
		return res;
	}
	
	public int getPageCount(int pageSize) throws SQLException{
		String sql="select count(*) from item";
		SqlHelper sqlHelper = new SqlHelper();
		String[] parameters = {} ;
		ResultSet s = sqlHelper.executeQuery(sql, parameters);
		int lines = 0;
		if(s.next()){
			lines = s.getInt("count(*)");
		}
		return (lines-1)/pageSize+1;
	}
	
	public int getPageCountWithKeyword(int pageSize, String keyword) throws SQLException{
		String sql="select count(*) from item where name like ?";
		SqlHelper sqlHelper = new SqlHelper();
		String[] parameters = {keyword} ;
		ResultSet s = sqlHelper.executeQuery(sql, parameters);
		int lines = 0;
		if(s.next()){
			lines = s.getInt("count(*)");
		}
		return (lines-1)/pageSize+1;
	}
	
	public List<ProductDescription> searchProductList(String keyword, int currentPage, int pageSize) throws SQLException{
		ProductDescription[] pd = new ProductDescription[pageSize+1];
		List<ProductDescription> res = new ArrayList<ProductDescription>();
		String sql="select * from item  where name like ? limit "+(currentPage-1)*pageSize+","+pageSize;
		SqlHelper sqlHelper = new SqlHelper();
		String[] parameters = {keyword} ;
		int i =0;
		ResultSet s = sqlHelper.executeQuery(sql, parameters);
		
		while(s.next()){
			pd[i] = new ProductDescription();
			pd[i].setId(s.getInt("id"));
			pd[i].setName(s.getString("name"));
			pd[i].setPrice(s.getInt("price"));
			res.add(pd[i]);
			i++;
		}
		return res;
	}
}
