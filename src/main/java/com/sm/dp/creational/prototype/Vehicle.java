package com.sm.dp.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Vehicle implements Cloneable {

	private String modelNumber;
	private String engine;
	private Double price;
	private List<String> vehicleType = new ArrayList<>();
	
	public void loadData() {
		vehicleType.add("EV");
		vehicleType.add("CNG");
		vehicleType.add("Petrol");
		vehicleType.add("Petrol-CNG");
		vehicleType.add("EV-CNG");		
	}

	public List<String> getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(List<String> vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public Vehicle clone() throws CloneNotSupportedException {
		//return (Vehicle) super.clone(); //shallow copy, this is default
		
		//this will create deep copy & changed in original object will not affect clone & vice versa
		Vehicle vehicleDeepCopy=new Vehicle();
		vehicleDeepCopy.setEngine(this.engine);
		vehicleDeepCopy.setModelNumber(this.modelNumber);
		vehicleDeepCopy.setPrice(this.price);
		
		for(String d : this.getVehicleType()) {
			vehicleDeepCopy.getVehicleType().add(d);
		}
		return vehicleDeepCopy;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle [modelNumber=" + modelNumber + ", engine=" + engine + ", price=" + price + ", vehicleType="
				+ vehicleType + "]";
	}



}
