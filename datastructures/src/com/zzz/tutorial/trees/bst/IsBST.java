package com.zzz.tutorial.trees.bst;

public class IsBST {
	boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean checkBST(Node root, int min, int max){
        if(root == null) return true;
        if(root.left != null &&  ((root.left.data >= root.data)
          || (root.left.data < min || root.left.data > max)) ) return false;
        if(root.right != null &&  ((root.right.data <= root.data)
           || (root.right.data < min || root.right.data > max)) ) return false;
        if(!checkBST(root.left, min, root.data - 1) || !checkBST(root.right, root.data + 1, max)) return false;
        return true;
    }
    
    private class Node{
    	int data;
    	Node left;
    	Node right;
    }
}
