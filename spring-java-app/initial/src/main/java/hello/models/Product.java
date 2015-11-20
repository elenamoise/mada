package hello;

import java.util.List;
import java.util.ArrayList;

public class Product {
	private String name;
	private int code;
	private int quantity;

	public Product(){}

	public Product(int code,int quantity,String name){
		this.code=code;
		this.quantity=quantity;
		this.name=name;
	}

	
	public int getCode(){
		return this.code;
	}

	public int getQuantity(){
		return this.quantity;
	}

	public String getName(){
		return this.name;
	}


	public void setName(String Name) {
	this.name=Name;
    
  }
}