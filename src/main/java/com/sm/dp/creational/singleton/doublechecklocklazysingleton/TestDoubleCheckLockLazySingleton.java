package com.sm.dp.creational.singleton.doublechecklocklazysingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.sm.dp.creational.singleton.eagersingleton.EagerSingleton;

public class TestDoubleCheckLockLazySingleton {

	public static void main(String[] args) {
		
		/**
		 * as synchronized method cause performance issue,
		 * added synchronized block with double check locking
		 * method use to test with single thread
		 */
		//singleThreadTestForDoubleCheckLock();
		
		/**
		 * as synchronized method cause performance issue,
		 * added synchronized block with double check locking
		 * method use to test multi-thread
		 */
		//multiThreadTestForSynchronizedBlockForDoubleCheck();
		
		/**
		 * test with clone
		 */
		//testWithClone();
		
		/**
		 * test with reflection
		 */
		//testWithReflection();
		
		/**
		 * test with de-serialization
		 */
		testWithDeserialization();

	}

	private static void singleThreadTestForDoubleCheckLock() {
		DoubleCheckLockLazySingleton obj1=DoubleCheckLockLazySingleton.getInstance();
		System.out.println(" hashcode for obj1 "+obj1.hashCode());
		
		DoubleCheckLockLazySingleton obj2=DoubleCheckLockLazySingleton.getInstance();
		System.out.println(" hashcode for obj2 "+obj2.hashCode());
	}
	
	private static void multiThreadTestForSynchronizedBlockForDoubleCheck() {
		Runnable runnable=()->{
			DoubleCheckLockLazySingleton obj3=DoubleCheckLockLazySingleton.getInstance();
			System.out.println("hashcode through getInstance synchronized block double check through multi-thread : "+ obj3.hashCode());
		};
		
		Thread th1=new Thread(runnable,"th1");
		Thread th2=new Thread(runnable,"th2");
		Thread th3=new Thread(runnable,"th3");
		
		th1.start();
		th2.start();
		th3.start();
		
	}
	
	private static void testWithClone() {
		DoubleCheckLockLazySingleton obj1 = DoubleCheckLockLazySingleton.getInstance();
		System.out.println(" hashcode through DoubleCheckLockLazySingleton clone " +obj1.hashCode());
		
		DoubleCheckLockLazySingleton obj2;
		try {
			obj2 = (DoubleCheckLockLazySingleton)obj1.clone();
			System.out.println(" hashcode through DoubleCheckLockLazySingleton clone " +obj2.hashCode());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * test with reflection
	 */
	private static void testWithReflection() {
		DoubleCheckLockLazySingleton obj1 = DoubleCheckLockLazySingleton.getInstance();
		System.out.println("hashcode through reflection EagerSingleton "+ obj1.hashCode());
		DoubleCheckLockLazySingleton reflectionInstance = null;

		Constructor[] constructors = DoubleCheckLockLazySingleton.class.getDeclaredConstructors();

		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			try {
				reflectionInstance = (DoubleCheckLockLazySingleton) constructor.newInstance();
				System.out.println("hashcode through reflection EagerSingleton "+reflectionInstance.hashCode());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private static void testWithDeserialization()  {
		try {
			DoubleCheckLockLazySingleton obj1 = DoubleCheckLockLazySingleton.getInstance();
			ObjectOutput output = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
			output.writeObject(obj1);
			output.close();
			
			ObjectInput input = new ObjectInputStream(new FileInputStream("singleton.ser"));
			DoubleCheckLockLazySingleton obj2 =(DoubleCheckLockLazySingleton) input.readObject();
			
			System.out.println("hashcode through de-serialization : "+ obj1.hashCode());
			System.out.println("hashcode through de-serialization : "+obj2.hashCode());
			
		} catch (IOException | ClassNotFoundException e) {			
			e.printStackTrace();
		} 
	}

}
