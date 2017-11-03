package com.zzz.tutorial.util;

import java.util.Random;

public class RandomArray<Key extends Integer> {
	public static Integer[] generateRandomArray(int size){
		Integer randomArray[] = new Integer[size];
		Random rand = new Random();
		for(int i =0;i<size;i++){
			randomArray[i] = rand.nextInt(100);
		}
		return randomArray;
	}
	
	public static void print(Integer [] input){
		for(Integer elem: input){
			System.out.print(elem + " ");
		}
	}
}
