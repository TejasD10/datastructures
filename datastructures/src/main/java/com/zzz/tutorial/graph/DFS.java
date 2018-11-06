package com.zzz.tutorial.graph;

import java.util.*;

public class DFS {

    public static class Graph {

        // Number of vertices in the graph
        private int vertices;
        // Adjacency list representation, so contains a linked list for each vertex
        private LinkedList<Integer> adjacentList[];

        // Constructor that initializes the Graph and creates V adjacency lists
        public Graph(int vertices) {
            this.vertices = vertices;

            this.adjacentList = new LinkedList[this.vertices];
            // Initialize the list
            for (int i = 0; i < vertices; i++)
                this.adjacentList[i] = new LinkedList<>();
        }

        /**
         * Add an edge to the graph
         */
        public void addEdge(int source, int dest) {
            if (validateSource(source))
                this.adjacentList[source].add(dest);
        }

        /**
         * Remove an edge from the graph
         */
        public void removeEdge(int source, int dest) {
            if (validateSource(source))
                this.adjacentList[source].remove(dest);
        }

        private boolean validateSource(int source) {
            if (this.adjacentList.length < source)
                return false;
            return true;
        }

        /**
         * DFS for the graph
         */
        public void dfs(int source) {
            if (!validateSource(source))
                return;
            Set<Integer> visited = new HashSet<>();
            dfsUtil(source, visited);
        }

        private void dfsUtil(int source, Set<Integer> visited) {

            // Add the source to visited
            visited.add(source);
            System.out.print(source + " ");
            // Get the adjacency list for the source and perform a depth first traversal
            Iterator<Integer> iterator = this.adjacentList[source].iterator();
            while (iterator.hasNext()) {
                int vertex = iterator.next();
                if (!visited.contains(vertex))
                    dfsUtil(vertex, visited);
            }
        }

        public void bfs(int source) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            queue.add(source);
            while (!queue.isEmpty()) {
                int pop = queue.poll();
                System.out.print(pop + " ");
                visited.add(source);
                Iterator<Integer> iterator = this.adjacentList[pop].iterator();
                while (iterator.hasNext()) {
                    int n = iterator.next();
                    if (!visited.contains(n)) {
                        queue.offer(n);
                        visited.add(n);
                    }
                }
            }
        }

    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
//        g.dfs(2);
        g.bfs(2);
    }
}
