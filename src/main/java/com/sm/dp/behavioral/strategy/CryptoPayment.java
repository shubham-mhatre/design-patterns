package com.sm.dp.behavioral.strategy;

public class CryptoPayment implements PaymentStrategy {

	private String walletNo;
	public CryptoPayment(String walletNo) {
		this.walletNo = walletNo;
	}
	
	@Override
	public void pay(double amount) {
		System.out.println("payment of "+ amount +" made by crypto using wallet no "+walletNo);

	}

}
