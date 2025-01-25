package com.sm.dp.creational.prototype;

import java.util.List;

public class PrototypeTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		//prototype pattern is used when we need to create heavy object,
		//we can create first prototype of it, and every time object is required,
		//we can clone our object from prototype and then use it further for modification.
		
		//in prototype, object should be created with clone method & not new keyword.
		//prototype should implement clonnable interface to provide object creation with clone method.
		Vehicle vehicle = new Vehicle();
		vehicle.setEngine("V8");
		vehicle.setModelNumber("m001");
		vehicle.setPrice(34782.23);
		vehicle.loadData();
		System.out.println(vehicle.toString());
		
		Vehicle fourVehiler = vehicle.clone();
		
		//this will remove vehicletype from original object as well as clone object.
		//because of shallow copy in clone method, so convert clone method to deep copy
		vehicle.getVehicleType().remove(0);		
		
		System.out.println(vehicle.toString());
		System.out.println(fourVehiler.toString());
	}

}
