package com.sm.dp.creational.singleton.enumsingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.sm.dp.creational.singleton.doublechecklocklazysingleton.DoubleCheckLockLazySingleton;

public class TestEnumSingleton {

	public static void main(String[] args) {
		
		//testWithSingleThread();
		
		//multiThreadTestEnum();
		
		//testWithClone();
		
		//testWithReflection();
		
		testWithDeserialization();
	}

	private static void testWithSingleThread() {
		SingletonEnum obj1=SingletonEnum.Instance;
		
		SingletonEnum obj2=SingletonEnum.Instance;	
		
		System.out.println("hashcode singleton single thread enum : "+obj1.hashCode());
		System.out.println("hashcode singleton single thread enum : "+obj2.hashCode());
	}
	
	private static void multiThreadTestEnum() {
		Runnable runnable=()->{
			SingletonEnum obj3=SingletonEnum.Instance;
			System.out.println("hashcode check through multi-thread using enum : "+ obj3.hashCode());
		};
		
		Thread th1=new Thread(runnable,"th1");
		Thread th2=new Thread(runnable,"th2");
		Thread th3=new Thread(runnable,"th3");
		
		th1.start();
		th2.start();
		th3.start();
		
	}
	
	private static void testWithClone() {
		SingletonEnum obj1 = SingletonEnum.Instance;
		System.out.println(" hashcode through enum clone " +obj1.hashCode());
		
		SingletonEnum obj2;
//		try {
			//obj2 = (SingletonEnum)obj1.clone(); //clone method is not visible
			//System.out.println(" hashcode through enum clone " +obj2.hashCode());
//		} catch (CloneNotSupportedException e) {
//
//			e.printStackTrace();
//		}
		
	}
	
	/**
	 * test with reflection
	 * get error output as :
	 * Cannot reflectively create enum objects
	 */
	private static void testWithReflection() {
		SingletonEnum obj1 = SingletonEnum.Instance;
		System.out.println("hashcode through reflection EagerSingleton "+ obj1.hashCode());
		SingletonEnum reflectionInstance = null;

		Constructor[] constructors = SingletonEnum.class.getDeclaredConstructors();

		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			try {
				reflectionInstance = (SingletonEnum) constructor.newInstance();
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
			SingletonEnum obj1 = SingletonEnum.Instance;
			ObjectOutput output = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
			output.writeObject(obj1);
			output.close();
			
			ObjectInput input = new ObjectInputStream(new FileInputStream("singleton.ser"));
			SingletonEnum obj2 =(SingletonEnum) input.readObject();
			
			System.out.println("hashcode through de-serialization : "+ obj1.hashCode());
			System.out.println("hashcode through de-serialization : "+obj2.hashCode());
			
		} catch (IOException | ClassNotFoundException e) {			
			e.printStackTrace();
		} 
	}

}
