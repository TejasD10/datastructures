package com.zzz.tutorial.binary;

/**
 * Write a function to determine the number of bits required to convert integer
 * A to integer B. Input: 31, 14 Output: 2
 * 
 * Use XOR to check how many bits are different, that is the answer
 *
 */
public class ConvertAtoB {
	public static void main(String[] args) {
		int a = 4, b = 3;

		System.out.println(convertBits(a, b));
		System.out.println(convertBits2(a, b));
		

	}

	private static int convertBits(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c > 0; c >>= 1) {
			count += c & 1;
		}
		return count;
	}

	private static int convertBits2(int a, int b) {
		int countA = 0;
		for (int i = 1; i <= a; i <<= 1) {
			if ((i & a) > 0)
				countA++;
		}
		for (int i = 1; i <= b; i <<= 1) {
			if ((i & b) > 0)
				countA++;
		}
		return countA;
	}
}
