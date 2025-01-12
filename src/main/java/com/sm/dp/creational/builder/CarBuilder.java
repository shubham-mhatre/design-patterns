package com.sm.dp.creational.builder;

public class CarBuilder {

	/**
	 * add all fields of Car class.
	 * add all setter methods
	 * in setter method, instead of void, return object of CarBuilder
	 * create one more method which will return object of Car.
	 */
	
	private String name;
	private String modelNumber;
	private String carType;
	private Double price;
	private String mileage;
	private String yearOfManufacture;
	
	public CarBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public CarBuilder setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
		return this;
	}
	public CarBuilder setCarType(String carType) {
		this.carType = carType;
		return this;
	}
	public CarBuilder setPrice(Double price) {
		this.price = price;
		return this;
	}
	public CarBuilder setMileage(String mileage) {
		this.mileage = mileage;
		return this;
	}
	public CarBuilder setYearOfManufacture(String yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
		return this;
	}
	
	public Car getCar() {
		return new Car(name, modelNumber, carType, price, mileage, yearOfManufacture);
	}
	
	
}
