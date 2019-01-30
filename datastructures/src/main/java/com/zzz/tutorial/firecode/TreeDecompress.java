package com.zzz.tutorial.firecode;

import com.zzz.tutorial.trees.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class TreeDecompress {
    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int data) {
            this.data = data;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode decompressTree(String str) {
        if (str == null || str.length() == 0)
            return null;
        if (str.charAt(0) == '*')
            return null;
        List<String> input = Arrays.asList(str.split(","));
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.parseInt(input.get(0)), null, null);
        TreeNode parent;
        queue.offer(head);
        for (int i = 1; i <= input.size() - 2; i += 2) {
            parent = queue.poll();
            if (parent == null) continue;
            parent.left = input.get(i).equals("*") ? null : new TreeNode(Integer.parseInt(input.get(i)), null, null);
            queue.offer(parent.left);
            parent.right = input.get(i+1).equals("*") ? null : new TreeNode(Integer.parseInt(input.get(i+1)), null, null);
            queue.offer(parent.right);
        }
        return head;
    }

    private static void levelOrder(TreeNode head) {
        if (head == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            TreeNode item = queue.poll();
            System.out.print(item.data + " ");
            if (item.left != null)
                queue.offer(item.left);
            if (item.right != null)
                queue.offer(item.right);
        }
    }

    public static void main(String[] args) {
        levelOrder(decompressTree("1,2,3,4,5,6,7,*,*,2,*,1,*,1,*"));
    }
}
