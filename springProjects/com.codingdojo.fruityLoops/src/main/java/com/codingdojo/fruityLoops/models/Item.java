package com.codingdojo.fruityLoops.models;

public class Item {
    
    // MEMBER VARIABLES
    public String name;
    public double price;
    
    // CONSTRUCTOR
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price){
		this.price = price;
	}
	
}
