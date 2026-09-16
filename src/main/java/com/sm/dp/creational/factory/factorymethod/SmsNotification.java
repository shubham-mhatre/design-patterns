package com.sm.dp.creational.factory.factorymethod;

//concrete product
public class SmsNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("sms notification sent !");

	}

}
