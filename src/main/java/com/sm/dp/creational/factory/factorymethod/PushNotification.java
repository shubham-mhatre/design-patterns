package com.sm.dp.creational.factory.factorymethod;

//concrete product
public class PushNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("push notification sent !");

	}

}
