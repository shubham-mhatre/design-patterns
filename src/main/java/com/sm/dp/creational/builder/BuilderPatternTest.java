package com.sm.dp.creational.builder;

public class BuilderPatternTest {

	public static void main(String[] args) {
		
		/**
		 * by creating object like by using constructor.
		 * we need to keep the proper sequence.
		 * also let say we don't want to pass some parameter, still we need to pass some default value.
		 * like the parameter count also matters.
		 * 
		 * to resolve this object creation complexity we can use builder pattern
		 */
		Car car = new Car("tata nexon","TN01110","EV",750000.00,"30km","2017");
		System.out.println(car);
		
		
		/**
		 * here with builder we only added 3 parameter also without any sequence
		 */
		Car carWithBuilder = new CarBuilder().setName("tata nexon").setModelNumber("TN01110").getCar();
		System.out.println(carWithBuilder);
	}
}
