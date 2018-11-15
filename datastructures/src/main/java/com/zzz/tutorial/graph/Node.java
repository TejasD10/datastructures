package com.zzz.tutorial.graph;

import java.util.HashMap;
import java.util.Map;

enum State {
    VISITED, UNVISITED, VISITING;
}

public class Node {
    // ID of the node
    private int key;
    private int incoming_count;
    private Map<Integer, Node> adjacentNodes; // stores the key of the neighbor and the neighbor node
    private Map<Integer, Integer> weights; // Stores the weights of the neighbor with its key.
    private State visitState;

    public Node(int key) {
        this.key = key;
        this.incoming_count = 0;
        this.adjacentNodes = new HashMap<>();
        this.weights = new HashMap<>();
        visitState = State.UNVISITED;
    }

    // Add Adjacent node
    public void addAdjacent(Node adj, int weight) {
        if (adj == null || weight < 0) return;
        this.adjacentNodes.put(adj.getKey(), adj);
        this.weights.put(adj.getKey(), weight);
        this.incoming_count++;
    }

    // Remove adjacent Node
    public void removeAdjacent(Node adj) {
        if (adj == null) return;
        if (!this.adjacentNodes.containsKey(adj.getKey()))
            return;
        this.incoming_count--;
        this.adjacentNodes.remove(adj.getKey());
        this.weights.remove(adj.getKey());
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", incoming_count=" + incoming_count +
                ", adjacentNodes=" + adjacentNodes +
                ", weights=" + weights +
                ", visitState=" + visitState +
                '}';
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getIncoming_count() {
        return incoming_count;
    }

    public void setIncoming_count(int incoming_count) {
        this.incoming_count = incoming_count;
    }

    public Map<Integer, Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Integer, Node> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public Map<Integer, Integer> getWeights() {
        return weights;
    }

    public void setWeights(Map<Integer, Integer> weights) {
        this.weights = weights;
    }

    public State getVisitState() {
        return visitState;
    }

    public void setVisitState(State visitState) {
        this.visitState = visitState;
    }
}