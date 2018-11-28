package com.zzz.tutorial.patterns.decorator;

public class CD extends ComputerDecorator{

	private Computer computer;
	
	public CD(Computer c){
		computer = c;
	}
	@Override
	public String description() {
		return computer.description() + " and a CD";
	}

}
