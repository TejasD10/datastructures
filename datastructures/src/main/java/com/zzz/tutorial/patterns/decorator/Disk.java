package com.zzz.tutorial.patterns.decorator;

public class Disk extends ComputerDecorator {

	private Computer computer;

	public Disk(Computer c) {
		computer = c;
	}

	@Override
	public String description() {
		return computer.description() + " and a Disk";
	}

}
