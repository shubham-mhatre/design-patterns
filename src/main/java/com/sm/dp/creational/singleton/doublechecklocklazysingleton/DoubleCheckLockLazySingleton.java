package com.sm.dp.creational.singleton.doublechecklocklazysingleton;

import java.io.Serializable;

import com.sm.dp.creational.singleton.MyClone;

public class DoubleCheckLockLazySingleton extends MyClone implements Serializable{
	
	private static DoubleCheckLockLazySingleton instance;
	
	private DoubleCheckLockLazySingleton() {
		if(instance !=null) {
			throw new IllegalStateException("cannot create object through reflection of singleton class");
		}
	}	
	
	public static DoubleCheckLockLazySingleton getInstance() {
		if(instance==null) {
			synchronized (DoubleCheckLockLazySingleton.class) {
				if(instance==null) {
					 instance = new DoubleCheckLockLazySingleton();
				}
			} 
		}
		return instance;
	}

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

}
