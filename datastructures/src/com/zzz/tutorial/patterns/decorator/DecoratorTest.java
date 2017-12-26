package com.zzz.tutorial.patterns.decorator;

public class DecoratorTest {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer = new Disk(computer);
		computer = new CD(computer);
		
		System.out.println("You get " + computer.description());

	}
}
