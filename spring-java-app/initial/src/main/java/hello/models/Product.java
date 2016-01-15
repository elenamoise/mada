package hello;

import java.util.List;
import java.util.ArrayList;

public class Product {
	private String name;
	private int id;
	private int quantity;

	public Product(){}

	public Product(int id,int quantity,String name){
		this.id=id;
		this.quantity=quantity;
		this.name=name;
	}

	
	public int getId(){
		return this.id;
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