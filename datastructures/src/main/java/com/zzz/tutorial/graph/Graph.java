package com.zzz.tutorial.graph;

import java.util.*;

public class Graph {

    // Maintains the list of nodes with the key and the value
    private Map<Integer, Node> nodes;

    public Map<Integer, Node> getNodes() {
        return nodes;
    }

    public void setNodes(Map<Integer, Node> nodes) {
        this.nodes = nodes;
    }

    public Graph() {
        // Initialize the graph
        nodes = new HashMap<>();
    }

    // Add nodes to the graph
    public void addNode(int key) {
        // No Boundary checks required as key can be anything
        nodes.put(key, new Node(key));
    }

    // Add an edge from a source to a destination
    public void addEdge(Node source, Node dest, int weight) {
        if (source == null || dest == null) return;
        // Make sure that the source and dest are present in the graph
        if (!this.nodes.containsKey(source.getKey()))
            this.nodes.put(source.getKey(), source);
        if (!this.nodes.containsKey(dest.getKey()))
            this.nodes.put(dest.getKey(), dest);
        // Add a directed edge from source to destination
        this.nodes.get(source.getKey()).addAdjacent(dest, weight);
    }

    // Add undirected edge
    public void addUndirectedEdge(Node source, Node dest, int weight) {
        this.addEdge(source, dest, weight);
        // As this is undirected, add an edge in the opposite diretion too
        this.addEdge(dest, source, weight);
    }

    // Depth First Search for a graph
    public void dfs(Node source) {
        if (!validate(source)) return;
        dfsUtil(source);
    }

    // Breadth first search for the graph
    public void bfs(Node source) {
        if (!validate(source)) return;
        // Create a queue for the implementation
        Queue<Node> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            top.setVisitState(State.VISITED);// Mark it as visited
            System.out.println(top.getKey());
            for (Node child : top.getAdjacentNodes().values()) {
                if (child.getVisitState() == State.UNVISITED) {
                    queue.offer(child);
                }
            }
        }
    }

    private void dfsUtil(Node source) {
        // Mark the source as visited
        source.setVisitState(State.VISITED);
        // Visit the node
        System.out.println(source.getKey());
        // Get all the adjacents nodes and visit them if they are not already visited
        for (Node des : source.getAdjacentNodes().values()) {
            if (des.getVisitState() == State.UNVISITED) {
                dfsUtil(des);
            }
        }
    }

    /*
    Print the topological sorting of a graph
    starting at the source of the graph
     */
    public void topologicalSort() {
        // check if there are any nodes in the graph
        if (this.nodes.isEmpty()) return;
        // Create a stack to store the sorted elements
        Stack<Integer> stack = new Stack<>();
        // For all vertices in the graph, pick one and call DFS on it
        for (Map.Entry<Integer, Node> item : this.nodes.entrySet()) {
            if (item.getValue() != null && item.getValue().getVisitState() == State.UNVISITED)
                topologicalSortUtil(item.getValue(), stack);
        }
        // When we reach here all the nodes are visited
        // print the nodes which is the top sort for the graph
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    private void topologicalSortUtil(Node source, Stack<Integer> stack) {
        // Perform a DFS beginning with the source
        // Mark the source as visited
        source.setVisitState(State.VISITED);

        // Get all the children for the source and perform a DFS for each
        for (Node node : source.getAdjacentNodes().values()) {
            // Perform a DFS from here if it is not performed
            if (node.getVisitState() == State.UNVISITED)
                topologicalSortUtil(node, stack);
        }
        // We've completed visited all the adjacent nodes of the source
        // add it to the stack
        stack.push(source.getKey());
    }

    private boolean validate(Node source) {
        if (source == null) return false;
        if (!this.nodes.containsKey(source.getKey()))
            return false;
        return true;
    }


}