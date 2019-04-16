package com.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetPriceFromDb {
	public List getPriceFromDb(Double price){ 
		Connection connection=null; 
		List<ProductDetails> list=new ArrayList<>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/shruthidb","shruthi","abc");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from product where price=?");
			preparedStatement.setDouble(1,price);  
			ResultSet resultSet=preparedStatement.executeQuery();
			list=(List) resultSet;
			
			if(resultSet.next()) { 
				System.out.println("Product availabe");
			    String name1=resultSet.getString("name");
			}
		}
		catch(Exception e) { 
			e.printStackTrace();
			
		} 
		return list; 
	} 
}
