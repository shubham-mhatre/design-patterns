package com.sm.dp.creational.factory.factorymethod;

//concrete product
public class EmailNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("email notification sent !");
	}

}
