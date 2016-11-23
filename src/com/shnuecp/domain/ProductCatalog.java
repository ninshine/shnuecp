package com.shnuecp.domain;

import java.sql.SQLException;
import com.shnuecp.service.*;

public class ProductCatalog {
	
	public ProductDescription getProductDesc(int id) throws SQLException{
		ProductService ps = new ProductService();
		return ps.getItemDesc(id);
	}
	
	public boolean checkProductId(int id) throws SQLException{
		ProductService ps = new ProductService();
		return ps.checkItemid(id);
	}
}
