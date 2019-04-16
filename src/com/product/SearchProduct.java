package com.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchProduct {
	public List searchProduct(){ 
		Connection connection=null;
		List<ProductDetails> list=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/shruthidb","shruthi","abc");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from product");
			ResultSet resultSet=preparedStatement.executeQuery();
			list=new ArrayList<>();
			
			while(resultSet.next()) { 
				System.out.println("Product availabe");
				int pid=resultSet.getInt(1);
			    String name1=resultSet.getString(2);
			    Double price=resultSet.getDouble(3);
			    ProductDetails productDetails=new ProductDetails();
			    productDetails.setPid(pid);
			    productDetails.setName(name1);
			    productDetails.setPrice(price);
			 
			    list.add(productDetails);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
		finally{ 
			if(connection!=null) {
				try {
					connection.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	
	}
}
