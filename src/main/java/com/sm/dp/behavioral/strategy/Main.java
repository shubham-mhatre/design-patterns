package com.sm.dp.behavioral.strategy;

public class Main {

	public static void main(String[] args) {
		
		ShippingCart shippingCart = new ShippingCart();
		
		shippingCart.setPaymentStrategy(new PayPalPayment("shubham@mailinator.com"));
		shippingCart.checkout(500);
		
		shippingCart.setPaymentStrategy(new CreditCardPayment("72364284242234234234"));
		shippingCart.checkout(1000.50);
		
		shippingCart.setPaymentStrategy(new CryptoPayment("x07211111111111111111"));
		shippingCart.checkout(1050.70);
		

	}

}
