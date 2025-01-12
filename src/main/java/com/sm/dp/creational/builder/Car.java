package com.sm.dp.creational.builder;

public class Car {

	private String name;
	private String modelNumber;
	private String carType;
	private Double price;
	private String mileage;
	private String yearOfManufacture;
	
	
	
	public Car(String name, String modelNumber, String carType, Double price, String mileage,
			String yearOfManufacture) {
		super();
		this.name = name;
		this.modelNumber = modelNumber;
		this.carType = carType;
		this.price = price;
		this.mileage = mileage;
		this.yearOfManufacture = yearOfManufacture;
	}



	@Override
	public String toString() {
		return "Car [name=" + name + ", modelNumber=" + modelNumber + ", carType=" + carType + ", price=" + price
				+ ", mileage=" + mileage + ", yearOfManufacture=" + yearOfManufacture + "]";
	}
	
	
}
