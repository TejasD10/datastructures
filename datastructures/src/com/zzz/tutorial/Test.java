package com.zzz.tutorial;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {

	public static final void main(String[] args) throws IOException {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Runtime.getRuntime().addShutdownHook(new Thread() {
			
			@Override
			public void run() {
				System.out.println("Shutting down");
				
			}
		});
	}

}
