package com.sm.dp.creational.factory;

public class FactoryPatternTest {

	public static void main(String[] args) {
		
		ComputeFactory factory =new ComputeFactory();
		Compute compute= factory.getInstance("mobile");
		compute.compute();
		
		Compute comput1= factory.getInstance("laptop");
		comput1.compute();
		
		Compute compute2= factory.getInstance("smartTv");
		compute2.compute();
		
	}

}
