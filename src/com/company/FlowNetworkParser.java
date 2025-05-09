// Student ID: W2084786
// Name: Imantha Sankalpa

package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Class to handle parsing a Flow Network from an input file
public class FlowNetworkParser {

    // Static method to parse a file and return a constructed FlowNetwork object
    public static FlowNetwork parse(String fileName) throws IOException {

        // Create a BufferedReader to read from the input file
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        // Read the first line which contains the number of nodes
        int nodes = Integer.parseInt(reader.readLine().trim());

        // Create a new FlowNetwork object with the given number of nodes
        FlowNetwork network = new FlowNetwork(nodes);

        String line;
        // Read the file line by line until there are no more lines
        while ((line = reader.readLine()) != null) {

            // Trim the line and split it into parts based on whitespace
            String[] parts = line.trim().split("\\s+");

            // Parse the 'from' node, 'to' node, and capacity values
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            int capacity = Integer.parseInt(parts[2]);

            // Add the edge to the network
            network.addEdge(from, to, capacity);

        }

        // Close the reader
        reader.close();

        // Return the constructed network
        return network;

    }

}