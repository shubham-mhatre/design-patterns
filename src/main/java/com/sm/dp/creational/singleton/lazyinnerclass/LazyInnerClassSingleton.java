package com.sm.dp.creational.singleton.lazyinnerclass;

import java.io.Serializable;

import com.sm.dp.creational.singleton.MyClone;

public class LazyInnerClassSingleton extends MyClone implements Serializable{
	
	//private constructor
	private LazyInnerClassSingleton() {
		
	}
	
	private static class lazyInnerClassHelper{
		private static final LazyInnerClassSingleton instance =new LazyInnerClassSingleton();
	}
	
	public static LazyInnerClassSingleton getInstance() {
		return lazyInnerClassHelper.instance;
	}

	/**
	 * stop clonning of object from Clone method
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
		return lazyInnerClassHelper.instance;
	}

}
