package com.sm.dp.creational.singleton.eagersingleton;

import java.io.Serializable;

import com.sm.dp.creational.singleton.MyClone;

public class EagerSingleton extends MyClone implements Serializable{


	//declare constructor private
	private EagerSingleton() {
		if(instance!=null) {
			throw new IllegalStateException("instance cannot be created through reflection");
		}
	}
	
	//static instance so that static method will return it.
	private static final EagerSingleton instance=new EagerSingleton();
	
	//static get method to return single instance.
	public static EagerSingleton getInstance() {
		return instance;
	}

	/**
	 * Stop clonnig of object
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	/**
	 * readResolve method to handle object duplication at time of de-serialization
	 * so return same instance
	 * @return
	 */
	protected Object readResolve() {
		return instance;
	}
	
	
	//disadvantage of this approach is that instance is created irrespective if object is created or not.
}
