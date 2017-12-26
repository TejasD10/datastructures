package com.zzz.tutorial.patterns.decorator;

/**
 * Core class that needs to be changed in future WE will design it so that it is
 * open for extension but closed for modification by using Decorator Design
 * Pattern
 * 
 *
 */
public class Computer {
	public Computer() {

	}

	public String description() {
		return "computer";
	}
}
