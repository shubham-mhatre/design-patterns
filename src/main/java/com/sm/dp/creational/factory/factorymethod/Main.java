package com.sm.dp.creational.factory.factorymethod;

public class Main {

	/*
	 * Instead of one factory class with a switch, 
	 * each subclass decides which object to create by overriding a method.
	 * 
	 * Adding a new notification type now means adding a new class 
	 * — no existing code changes.
	 */
	
	public static void main(String[] args) {
		NotificationCreator notificationCreator = new EmailNotificationCreator();
		notificationCreator.sendNotification();
		
		notificationCreator = new SmsNotificationCreator();
		notificationCreator.sendNotification();
		
		notificationCreator = new PushNotificationCreator();
		notificationCreator.sendNotification();

	}

}
