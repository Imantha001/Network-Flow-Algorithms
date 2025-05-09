// Student ID: W2084786
// Name: Imantha Sankalpa

package com.company;

import java.util.ArrayList;
import java.util.List;

// Defines the properties of an edge in the flow network:
// Each edge has a source node (from), destination node (to), capacity (maximum allowed flow), and current flow.
class Edge {
    int from, to, capacity, flow;

    // Constructor to initialize the edge with its properties
    Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }
}

// FlawNetwork Main class
public class FlowNetwork {
    private final List<Edge>[] adjacencyList; // Adjacency list representation of the flow network

    // Constructor to initialize the flow network with a given number of nodes
    @SuppressWarnings("unchecked") // Suppress warnings related to generic array creation
    public FlowNetwork(int nodes) {
        adjacencyList = new ArrayList[nodes]; // Create an array of lists for each node
        for (int i = 0; i < nodes; i++) {
            adjacencyList[i] = new ArrayList<>(); // Initialize each list for the nodes
        }
    }

    // Method to add an edge to the flow network
    public void addEdge(int from, int to, int capacity) {
        Edge forwardEdge = new Edge(from, to, capacity); // Create the actual edge with the given properties
        Edge backwardEdge = new Edge(to, from, 0); // Create the backward edge with zero initial capacity
        adjacencyList[from].add(forwardEdge); // Add the forward edge to the adjacency list of from node
        adjacencyList[to].add(backwardEdge); // Add the backward edge to the adjacency list of to node
    }

    // Method to get the list of edges connected to a specific node
    public List<Edge> getEdges(int node) {
        return adjacencyList[node];

    }

    // Method to get the total number of nodes in the network
    public int size() {
        return adjacencyList.length;

    }

}