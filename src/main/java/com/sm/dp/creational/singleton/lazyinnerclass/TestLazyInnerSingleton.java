package com.sm.dp.creational.singleton.lazyinnerclass;

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
import com.sm.dp.creational.singleton.lazysingleton.LazySingleton;

public class TestLazyInnerSingleton {

	public static void main(String[] args) {
		
		/**
		 * Test with single thread
		 */		
		//testWithSingleThread();
		
		/**
		 * Test with multi-thread
		 */
		//multiThreadTestingForLazySingleton();
		
		/**
		 * Test with clone
		 */
		//testingWithclone();
		
		/**
		 * test with de-serialization
		 */
		testWithDeserialization();
	}

	private static void testingWithclone() {
		LazyInnerClassSingleton obj1 = LazyInnerClassSingleton.getInstance();
		LazyInnerClassSingleton obj2;
		try {
			obj2 = (LazyInnerClassSingleton) obj1.clone();
			System.out.println(" hashcode through lazyinnerclass singleton clone " +obj1.hashCode());
			System.out.println(" hashcode through lazyinnerclass singleton clone " +obj2.hashCode());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void testWithSingleThread() {
		LazyInnerClassSingleton obj1 = LazyInnerClassSingleton.getInstance();
		System.out.println(" hashcode through lazyinnerclass singleton " +obj1.hashCode());
		
		LazyInnerClassSingleton obj2 = LazyInnerClassSingleton.getInstance();
		System.out.println(" hashcode through lazyinnerclass singleton " +obj2.hashCode());
	}
	
	private static void multiThreadTestingForLazySingleton() {
		Runnable runnable=()->{
			LazyInnerClassSingleton obj3=LazyInnerClassSingleton.getInstance();
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
	 * test with reflection
	 */
	private static void testWithReflection() {
		LazyInnerClassSingleton obj1 = LazyInnerClassSingleton.getInstance();
		System.out.println("hashcode through reflection EagerSingleton "+ obj1.hashCode());
		LazyInnerClassSingleton reflectionInstance = null;

		Constructor[] constructors = LazyInnerClassSingleton.class.getDeclaredConstructors();

		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			try {
				reflectionInstance = (LazyInnerClassSingleton) constructor.newInstance();
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
			LazyInnerClassSingleton obj1 = LazyInnerClassSingleton.getInstance();
			ObjectOutput output = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
			output.writeObject(obj1);
			output.close();
			
			ObjectInput input = new ObjectInputStream(new FileInputStream("singleton.ser"));
			LazyInnerClassSingleton obj2 =(LazyInnerClassSingleton) input.readObject();
			
			System.out.println("hashcode through de-serialization : "+ obj1.hashCode());
			System.out.println("hashcode through de-serialization : "+obj2.hashCode());
			
		} catch (IOException | ClassNotFoundException e) {			
			e.printStackTrace();
		} 
	}

}
