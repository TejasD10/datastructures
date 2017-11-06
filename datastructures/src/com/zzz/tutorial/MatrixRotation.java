package com.zzz.tutorial;

/**
 * 
 * 1	2	3	4			
 * 5	6	7	8
 * 9	10	11	12
 * 13	14	15	16
 * 
 * Should result into
 * 
 * 4	8	12	16
 * 3	7	11	15
 * 2	6	10	14
 * 1	5	9	13
 * 
 *
 */
public class MatrixRotation {
	public static void main(String[] args) {
		/*int [][] input = {  {1,2,3,4}, 
							{5,6,7,8},
							{9,10,11,12},
							{13,14,15,16} };*/
		
		int [][] input = {  {1,2,3,4,5}, 
							{6,7,8,9,10},
							{11,12,13,14,15},
							{16,17,18,19,20},
							{21,22,23,24,25}};

		int n = input.length;
		rotateMatrix(input, n);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void rotateMatrix(int[][] input, int n) {
		int first, last, off=0, temp;
		
		for (int l = 0; l < n / 2; l++) {
			first = l;
			last = n - 1 - l;
			off = 0;
			for (int i = first; i < last; i++) {

				//Temp the first
				temp = input[first][i];
				
				//Bottom Right --> Top Right
				input[first][i] = input[i][last];
				
				//Bottom left to Bottom right
				input[i][last] = input[last][last-off];
				
				input[last][last-off] = input[last-off][first];

				//Bottom Left - Top
				input[last - off][first] = temp;
				
				off++;
				
			}
		}		
		
	}
}
