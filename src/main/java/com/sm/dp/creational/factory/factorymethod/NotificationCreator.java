package com.sm.dp.creational.factory.factorymethod;

//Creator (abstract) — declares the factory method
public abstract class NotificationCreator {

	// Factory method
	public abstract Notification createNotification();
	
	// Template method using the product
	public void sendNotification() {
		Notification notification = createNotification();
		notification.notifyUser();
		
	}
}
