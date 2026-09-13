package com.sm.dp.behavioral.strategy;

public class PayPalPayment implements PaymentStrategy {

	private String email;

	PayPalPayment(String email) {
		this.email = email;
	}

	@Override
	public void pay(double amount) {
		System.out.println("payment of " + amount + " made using paypal by id " + email);

	}

}
