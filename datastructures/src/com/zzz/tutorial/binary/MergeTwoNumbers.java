package com.zzz.tutorial.binary;

/**
 * Given two 32 bit numbers, i and j, say M=10000000 and N=00010101, make N a
 * substring of M starting from j to i
 * 
 *
 */
public class MergeTwoNumbers {
	public static void main(String[] args) {
		Integer M = 128; // 10000000
		Integer N = 21; // 10101
		int i = 2;
		int j = 6;
		System.out.println("M = " + Integer.toBinaryString(M));
		System.out.println("N = " + Integer.toBinaryString(N));

		Integer max = ~0;
		System.out.println("MAX = " + Integer.toBinaryString(max));

		int left = max - ((1 << j) - 1);
		System.out.println("Left = " + Integer.toBinaryString(left));
		
		int right = ((1 << i) - 1);
		System.out.println("Right = " + Integer.toBinaryString(right));
		
		System.out.println(Integer.toBinaryString(left | right));
		int mask = left | right;
		
		System.out.println("Masked: " + Integer.toBinaryString(M & mask));
		
		int output = (M & mask) | N << i;
		System.out.println("Output: " + Integer.toBinaryString(output));
	}
}
