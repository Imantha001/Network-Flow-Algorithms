// Student ID: W2084786
// Name: Imantha Sankalpa

package com.company;

import java.util.LinkedList;
import java.util.Queue;

// Class to solve the Maximum Flow problem in a Flow Network
public class MaxFlowSolver {

    private final FlowNetwork network; // The flow network to be solved
    private final int source, sink; // The source and sink nodes in the network

    // Constructor to initialize the solver with a network, source node, and sink
    // node
    public MaxFlowSolver(FlowNetwork network, int source, int sink) {
        this.network = network;
        this.source = source;
        this.sink = sink;
    }

    // Method to find the maximum flow from source to sink
    public int findMaxFlow() {
        int maxFlow = 0; // Variable to store the maximum flow value
        int[] parent = new int[network.size()]; // Array to store the path from source to sink

        // Keep searching for augmenting paths using BFS
        while (bfs(parent)) {
            int pathFlow = Integer.MAX_VALUE; // Initialize path flow to maximum value

            // Trace back the path from sink to source to find minimum residual capacity
            for (int v = sink; v != source; v = parent[v]) { // Start from sink and go back to source
                int u = parent[v]; // Get the parent node
                Edge edge = findEdge(u, v); // Find the edge in the network
                pathFlow = Math.min(pathFlow, edge.capacity - edge.flow); // Update path flow
            }

            // Update flow values both forward and backward edges
            for (int v = sink; v != source; v = parent[v]) { // Start from sink and go back to source
                int u = parent[v];
                findEdge(u, v).flow += pathFlow; // Increase flow in forward edge
                findEdge(v, u).flow -= pathFlow; // Decrease flow in backward edge
            }

            // Add the path flow to the total maximum flow
            maxFlow += pathFlow;

        }

        // Return the total maximum flow value
        return maxFlow;

    }

    // Method to perform Breadth-First Search (BFS) to find an augmenting path
    private boolean bfs(int[] parent) {
        boolean[] visited = new boolean[network.size()]; // Array to track visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS
        queue.add(source); // Start from the source node
        visited[source] = true; // Mark source as visited
        parent[source] = -1; // Source has no parent

        // Perform BFS until the queue is empty
        while (!queue.isEmpty()) {
            int u = queue.poll(); // Get the current node

            // Explore all edges connected to the current node
            for (Edge edge : network.getEdges(u)) {

                // Check for an unvisited node with available capacity
                if (!visited[edge.to] && edge.capacity > edge.flow) {
                    queue.add(edge.to);
                    parent[edge.to] = u;
                    visited[edge.to] = true;

                    // If we reach the sink node, return true
                    if (edge.to == sink) {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    // Method to find the edge between two nodes in the network
    private Edge findEdge(int from, int to) {
        // Iterate through the edges of the 'from' node to find the edge to 'to' node
        for (Edge edge : network.getEdges(from)) {
            if (edge.to == to) {
                return edge;
            }
        }
        return null;
    }

}