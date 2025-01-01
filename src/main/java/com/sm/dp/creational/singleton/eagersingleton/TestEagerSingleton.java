package com.sm.dp.creational.singleton.eagersingleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestEagerSingleton {

	public static void main(String[] args) {

		//testWithSingleThread();

		// testWithClone();

		/**
		 * test with reflection
		 */
		//testWithReflection();
		
		/**
		 * test with de-serialization
		 */
		testWithDeserialization();

	}

	/**
	 * test with reflection
	 */
	private static void testWithReflection() {
		EagerSingleton obj1 = EagerSingleton.getInstance();
		System.out.println("hashcode through reflection EagerSingleton "+ obj1.hashCode());
		EagerSingleton reflectionInstance = null;

		Constructor[] constructors = EagerSingleton.class.getDeclaredConstructors();

		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			try {
				reflectionInstance = (EagerSingleton) constructor.newInstance();
				System.out.println("hashcode through reflection EagerSingleton "+reflectionInstance.hashCode());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void testWithSingleThread() {
		EagerSingleton obj1 = EagerSingleton.getInstance();
		System.out.println(obj1.hashCode());

		EagerSingleton obj2 = EagerSingleton.getInstance();
		System.out.println(obj2.hashCode());
	}

	private static void testWithClone() {
		try {
			EagerSingleton obj1 = EagerSingleton.getInstance();
			EagerSingleton obj2 = (EagerSingleton) obj1.clone();
			System.out.println(obj1.hashCode());
			System.out.println(obj2.hashCode());
		} catch (CloneNotSupportedException e) {
			System.out.println("clonning is not supported for singleton class");
		}
	}
	
	private static void testWithDeserialization()  {
		try {
			EagerSingleton obj1 = EagerSingleton.getInstance();
			ObjectOutput output = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
			output.writeObject(obj1);
			output.close();
			
			ObjectInput input = new ObjectInputStream(new FileInputStream("singleton.ser"));
			EagerSingleton obj2 =(EagerSingleton) input.readObject();
			
			System.out.println("hashcode through de-serialization : "+ obj1.hashCode());
			System.out.println("hashcode through de-serialization : "+obj2.hashCode());
			
		} catch (IOException | ClassNotFoundException e) {			
			e.printStackTrace();
		} 
	}

}
