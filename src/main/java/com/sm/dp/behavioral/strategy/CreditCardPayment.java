package com.sm.dp.behavioral.strategy;

public class CreditCardPayment implements PaymentStrategy {

	private String cardNumber;

	public CreditCardPayment(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Payment of " + amount + " made using credit card option with card number ends with "
				+ cardNumber.substring(cardNumber.length() - 4));

	}

}
