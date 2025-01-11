package com.sm.dp.creational.factory;

public class ComputeFactory {

	//to implement hidden object creation login
	//we have this factory class, which will return object based on passed input
	public Compute getInstance(String type) {

		Compute instance=null;
		switch(type) {
		case "laptop":
			instance= new Laptop();
			break;
		case "mobile":
			instance= new Mobile();
			break;
		case "smartTv":
			instance= new SmartTv();
			break;
		default:
			System.out.println("invalid type receive to create object");
		}
		return instance;
	}
}
