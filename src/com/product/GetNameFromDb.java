package com.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetNameFromDb {
	public List getNameFromDb(String name){ 
		Connection connection=null; 
		List<ProductDetails>  list=new ArrayList<>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/shruthidb","shruthi","abc");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from product where name=?");
			preparedStatement.setString(1,name); 
			ResultSet resultSet=preparedStatement.executeQuery();
//			list=(List) resultSet;
			
			while(resultSet.next()) { 
				System.out.println("Product availabe");
				int pid=resultSet.getInt("pid");
			    String name1=resultSet.getString("name");
			    Double price=resultSet.getDouble("price");
			    ProductDetails productDetails=new ProductDetails();
			    productDetails.setPid(pid);
			    productDetails.setName(name1);
			    productDetails.setPrice(price);
			    
			    System.out.print("pid= "+productDetails.getPid());
			    System.out.print("  name="+productDetails.getName());
			    System.out.println("	price= "+productDetails.getPrice());
			    
			    list.add(productDetails); 
			   
			}
		}
		catch(Exception e) { 
			e.printStackTrace();
			
		} 
		return list;
	}
			
}
