package com.sm.dp.creational.singleton.lazysingleton;

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

public class TestLazySingleton {

	public static void main(String[] args) {
		
		/**
		 * normal testing of lazy singleton
		 */
		//singleThreadTestOfLazySingleTon();
		
		
		/**
		 * multi-threaded testing
		 * getInstance method returns multiple instance object 
		 * 
		 * output :
		 * hashcode through getinstance method through multi-thread : 1479956983
		 * hashcode through getinstance method through multi-thread : 397450409
		 * hashcode through getinstance method through multi-thread : 1479956983
		 */		
		//multiThreadTestingForLazySingleton();
		
		/**
		 * multi-threaded testing
		 * getInstanceSyn : added synchronized keyword to method
		 * adding synchronized keyword at method level can cause performance issue
		 * so it's better to go with double check locking with lazy singleton
		 */		
		//multiThreadTestingForSynchronizedForLazySingleton();
		
		/**
		 * Test with clone
		 */
		//testWithClone();
		
		/**
		 * Test with reflection
		 */
		//testWithReflection();

		/**
		 * test with de-serialization
		 */
		testWithDeserialization();
	}

	
	/**
	 * testing with single thread
	 */
	private static void singleThreadTestOfLazySingleTon() {
		LazySingleton obj1=LazySingleton.getInstance();
		System.out.println("hashcode through single thread "+ obj1.hashCode());
		
		LazySingleton obj2=LazySingleton.getInstance();
		System.out.println("hashcode through single thread "+obj2.hashCode());
	}
	
	/**
	 * getInstance method returns multiple instance object 
	 */
	private static void multiThreadTestingForLazySingleton() {
		Runnable runnable=()->{
			LazySingleton obj3=LazySingleton.getInstance();
			System.out.println("hashcode through getinstance method through multi-thread : "+ obj3.hashCode());
		};
		
		Thread th1=new Thread(runnable,"th1");
		Thread th2=new Thread(runnable,"th2");
		Thread th3=new Thread(runnable,"th3");
		
		th1.start();
		th2.start();
		th3.start();
	}
	
	/**
	 * testing with multi-thread with synchronized method
	 */
	private static void multiThreadTestingForSynchronizedForLazySingleton() {
		Runnable runnable=()->{
			LazySingleton obj3=LazySingleton.getInstanceSyn();
			System.out.println("hashcode through getInstanceSyn synchronized method through multi-thread : "+ obj3.hashCode());
		};
		
		Thread th1=new Thread(runnable,"th1");
		Thread th2=new Thread(runnable,"th2");
		Thread th3=new Thread(runnable,"th3");
		
		th1.start();
		th2.start();
		th3.start();
		
	}
	
	/**
	 * test with clone
	 */
	private static void testWithClone() {
		LazySingleton obj1 = LazySingleton.getInstance();
		System.out.println(" hashcode through LazySingleton clone " +obj1.hashCode());
		
		LazySingleton obj2;
		try {
			obj2 = (LazySingleton)obj1.clone();
			System.out.println(" hashcode through LazySingleton clone " +obj2.hashCode());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * test with reflection
	 */
	private static void testWithReflection() {
		LazySingleton obj1 = LazySingleton.getInstance();
		System.out.println("hashcode through reflection EagerSingleton "+ obj1.hashCode());
		LazySingleton reflectionInstance = null;

		Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();

		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			try {
				reflectionInstance = (LazySingleton) constructor.newInstance();
				System.out.println("hashcode through reflection EagerSingleton "+reflectionInstance.hashCode());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * test with de-serialization
	 */
	private static void testWithDeserialization()  {
		try {
			LazySingleton obj1 = LazySingleton.getInstance();
			ObjectOutput output = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
			output.writeObject(obj1);
			output.close();
			
			ObjectInput input = new ObjectInputStream(new FileInputStream("singleton.ser"));
			LazySingleton obj2 =(LazySingleton) input.readObject();
			
			System.out.println("hashcode through de-serialization : "+ obj1.hashCode());
			System.out.println("hashcode through de-serialization : "+obj2.hashCode());
			
		} catch (IOException | ClassNotFoundException e) {			
			e.printStackTrace();
		} 
	}

}
