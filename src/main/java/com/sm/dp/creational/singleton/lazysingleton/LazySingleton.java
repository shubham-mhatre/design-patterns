package com.sm.dp.creational.singleton.lazysingleton;

import java.io.Serializable;

import com.sm.dp.creational.singleton.MyClone;

public class LazySingleton extends MyClone implements Serializable{
	
	//create private constructor
	
	private LazySingleton() {
		if(instance !=null) {
			throw new IllegalStateException("instance cannot be created through reflection of singleton class");
		}
	}
	
	private static LazySingleton instance;
	
	/**
	 * this approach will not work in multi-thread environment as multiple thread can access this method at same time
	 * race condition can happend
	 * 
	 * @return
	 */
	public static LazySingleton getInstance() {
		if(instance==null) {
			return instance=new LazySingleton();
		}else {
			return instance;
		}
	}
	
	/**
	 * to handle race condition we can make this method synchronized
	 * 
	 * @return
	 */
	public static synchronized LazySingleton getInstanceSyn() {
		if(instance==null) {
			return instance=new LazySingleton();
		}else {
			return instance;
		}
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
	

}
