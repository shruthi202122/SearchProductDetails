package com.productServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.GetNameFromDb;
import com.product.GetPriceFromDb;
import com.product.ProductDetails;
import com.product.SearchProduct;

public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Double price;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String price1=request.getParameter("price");
		
		String name=request.getParameter("name");
		//System.out.println("name= "+name);
		Double price=null;
		List<ProductDetails> list=new ArrayList<>();
		
		if(name.trim()!="" && price1.trim()=="") {
			System.out.println("name= "+name);
			GetNameFromDb getname=new GetNameFromDb();
			list=getname.getNameFromDb(name);
		}
	
		else if((name.trim()==""||name==null) && (price1==null||price1.trim()=="")) {
			SearchProduct search=new SearchProduct();
				list=search.searchProduct();
		}
		if(price1.trim()!="") {
			price=Double.parseDouble(price1);
			this.price=price; 
			System.out.println("price= "+price); 
		}
		if(name.trim()=="" && price!=null){ 
			System.out.println("price= "+price); 
			GetPriceFromDb getprice=new GetPriceFromDb();
			list=getprice.getPriceFromDb(price);
		}
		
		
		if(list!=null){
			for (int index = 0; index < list.size(); index++) {
				ProductDetails productDetails = (ProductDetails)list.get(index);
				int pid=productDetails.getPid();
				String name1=productDetails.getName();
				Double price2=productDetails.getPrice();
				System.out.print(pid+"  "); 
				System.out.print(name1+"  ");
				System.out.println(price2); 
				request.setAttribute("productDetails1",productDetails);
							
			}
			request.getRequestDispatcher("/view/success.jsp").forward(request,response); 

		}
		else {
			System.out.println("list is null");
		}
		
	}
	
}
