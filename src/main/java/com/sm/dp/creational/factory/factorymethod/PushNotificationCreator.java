package com.sm.dp.creational.factory.factorymethod;

//Concrete creators — each decides what to instantiate
public class PushNotificationCreator extends NotificationCreator {

	@Override
	public Notification createNotification() {
		// TODO Auto-generated method stub
		return new PushNotification();
	}

	
}
