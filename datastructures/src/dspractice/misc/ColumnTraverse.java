package dspractice.misc;

import java.util.*;

public class ColumnTraverse {
    private static final class ColumnFind<U> {
        private final int column;
        private final Node<U> node;

        public ColumnFind(int column, Node<U> node) {
            super();
            this.column = column;
            this.node = node;
        }
    }

    private static final class Node<T> {

        private Node<T> left, right;
        private final T value;

        public Node(T value, Node<T> left, Node<T> right) {
            super();
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node<T> left() {
            return left;
        }

        public Node<T> right() {
            return right;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public static final <N> void traverse(Node<N> root) {

        final TreeMap<Integer, List<Node<N>>> columnMap = new TreeMap<>();
        final Queue<ColumnFind<N>> queue = new LinkedList<>();

        queueChild(0, root, queue);

        while (!queue.isEmpty()) {
            ColumnFind<N> cf = queue.remove();
            int column = cf.column;
            Node<N> node = cf.node;
            columnMap.computeIfAbsent(column, c -> new ArrayList<>()).add(node);
            queueChild(column - 1, node.left(), queue);
            queueChild(column + 1, node.right(), queue);
        }

        for (Map.Entry<Integer, List<Node<N>>> entry : columnMap.entrySet()) {
            System.out.println("Column - " + entry.getKey() + " : " + entry.getValue());
        }
    }

    private static final <N> void queueChild(int column, Node<N> node, Queue<ColumnFind<N>> queue) {
        if (node == null) {
            return;
        }
        queue.add(new ColumnFind<>(column, node));
    }
    public static void main(String[] args) {
        Node<Integer> five = new Node<>(5, null, null);
        Node<Integer> four = new Node<>(4, null, five);
        Node<Integer> three = new Node<>(3, null, null);
        Node<Integer> two = new Node<>(2, null, four);
        Node<Integer> one = new Node<>(1, two, three);
        traverse(one);
    }
}
