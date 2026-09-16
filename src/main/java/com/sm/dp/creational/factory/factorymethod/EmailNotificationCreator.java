package com.sm.dp.creational.factory.factorymethod;

//Concrete creators — each decides what to instantiate
public class EmailNotificationCreator extends NotificationCreator{

	@Override
	public Notification createNotification() {
		return new EmailNotification();
	}

}
