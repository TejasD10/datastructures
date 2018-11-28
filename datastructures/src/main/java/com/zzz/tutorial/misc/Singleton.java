package com.zzz.tutorial.misc;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

final class SingletonTest {
	private static final SingletonTest INSTANCE = new SingletonTest();

	private SingletonTest() {
		System.out.println("Instance created!");
	}

	public static SingletonTest getInstance() {
		return INSTANCE;
	}

}

public class Singleton {
	public static void main(String[] args) {
		Executor execute = Executors.newFixedThreadPool(4);

		execute.execute(new Runnable() {
			SingletonTest test1;

			public void run() {
				for (int i = 0; i < 5; i++) {
					test1 = SingletonTest.getInstance();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName());
				}
			}
		});
	}
}