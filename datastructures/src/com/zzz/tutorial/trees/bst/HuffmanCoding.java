package com.zzz.tutorial.trees.bst;

/**
 * The complete code is in HackR.
 * The input passed in for the sample test case is as below:
 *  	{?,5}
 *     0 /     \ 1
 *   {?,2}   {A,3}
 *   0/   		\1
 *{B,1} 	 	{C,1}  
 * S="1001011"
 * 
 * Sample Output:
 * ABACA
 *
 */

public class HuffmanCoding {
	
	private class Node {
		private int freq;
		private char data;
		private Node left, right;
	}
	
	public void decode(String s ,Node root)
    {
        if(root == null || s == null || s == "") return;
        
        Node temp = root;
        for(int i = 0;i < s.length(); i++){
            if(s.charAt(i) == '1'){
                temp = temp.right;
                if(temp.left == null && temp.right == null) {
                    System.out.print(temp.data);
                    temp = root;
                }
            }else if (s.charAt(i) == '0'){
                temp = temp.left;
                if(temp.left == null && temp.right == null) {
                    System.out.print(temp.data);
                    temp = root;
                }
            }
        }
       
    }

}
