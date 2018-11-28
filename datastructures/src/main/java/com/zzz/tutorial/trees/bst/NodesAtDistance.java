package com.zzz.tutorial.trees.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NodesAtDistance {

    // The result to return a list of nodes at distance
    private static class Result {
        private int distance;
        private List<Integer> nodes = new ArrayList<>();

        public Result(int distance, List<Integer> nodes) {
            this.distance = distance;
            this.nodes = nodes;
        }

        public Result distance(int dist) {
            this.distance = dist;
            return this;
        }

        public Result nodes(List<Integer> nodes) {
            this.nodes = nodes;
            return this;
        }
    }

    private static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "" + data;

        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value, null, null);
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        System.out.println(root.data + " ");
        list.add(root.data);
        if (root.left != null)
            list.addAll(preorder(root.left));
        if (root.right != null)
            list.addAll(preorder(root.right));
        return list;
    }

    private Node root;

    public Optional nodesAtDistance(int search, int k) {

        // Find the node which is the target and contains search as the data
        Node target = search(root, search);

        if (target == null) {
            return Optional.ofNullable(null);
        }

        return Optional.ofNullable(nodesAtDistHelper(root, target, k).nodes);

    }

    private Result nodesAtDistHelper(Node root, Node target, int k) {
        //Create the object to be returned
        Result response = new Result(-1, new ArrayList<>());
        if (root == null) // Reached Null
            return response.distance(-1); // No elements found from here

        if (root.data == target.data) {
            List<Integer> result = addNodes(target, 0, k); //Distance from the target node
            return response.distance(1).nodes(result);
        } else {
            // Search Left
            Result left = nodesAtDistHelper(root.left, target, k);
            if (left.distance > -1) {
                // root is at distance k from target
                if (left.distance == k) {
                    left.nodes.add(root.data);
                } else if (left.distance < k) {
                    left.nodes.addAll(addNodes(root.right, left.distance + 1, k));
                }
                return left.distance(left.distance + 1);
            }
            Result right = nodesAtDistHelper(root.right, target, k);
            if (right.distance > -1) {
                if (right.distance == k) {
                    right.nodes.add(root.data);
                } else if (right.distance < k) {
                    right.nodes.addAll(addNodes(root.left, right.distance + 1, k));
                }
                return right.distance(right.distance + 1);
            }
            return response.distance(-1);
        }

    }

    private List<Integer> addNodes(Node root, int remainingDist, int k) {
        // Check for null
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (remainingDist == k) {
            result.add(root.data);
        }
        result.addAll(addNodes(root.left, remainingDist + 1, k));
        result.addAll(addNodes(root.right, remainingDist + 1, k));
        return result;
    }


    private Node search(Node root, int search) {
        if (root == null) {
            return null;
        }
        if (root.data == search) {
            return root;
        }
        if (search < root.data)
            return search(root.left, search);
        else {
            return search(root.right, search);
        }

    }

    public static void main(String args[]) {
        NodesAtDistance nd = new NodesAtDistance();
        nd.insert(20);
        nd.insert(8);
        nd.insert(22);
        nd.insert(4);
        nd.insert(12);
        nd.insert(10);
        nd.insert(14);
        System.out.println(nd.nodesAtDistance(14, 3));

    }

}
