// Student ID: W2084786
// Name: Imantha Sankalpa

package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Infinite loop until the user chooses to exit
        while (true) {
            System.out.println(" ");
            System.out.println("#######################################");
            System.out.println("Please select an option...");
            System.out.println("1: Enter 1 to solve a given text file ");
            System.out.println("2: Enter any key to exit the program");
            System.out.print("Your selected option: ");
            System.out.println(" ");

            String option = scanner.nextLine(); // Read user input

            // If user selects 1, ask for the file path
            if (option.equals("1")) {
                System.out.print("Enter the file path (folder name/filename.txt): ");
                String filePath = scanner.nextLine();
                solveFromFile(filePath); // Solve the flow network using the given file

                // If user selects any other key, exit the program
            } else {
                System.out.println("Exiting...");
                break;

            }

        }

        scanner.close();
    }

    // Method to solve the maximum flow problem from a file
    private static void solveFromFile(String filePath) {

        try {
            System.out.println("\nContents of the file:");
            // Read and print the contents of the file
            Files.lines(new File(filePath).toPath()).forEach(System.out::println);

            // Parse the flow network from the file
            FlowNetwork network = FlowNetworkParser.parse(filePath);

            // Create a solver with source node = 0 and sink node = (n-1)
            MaxFlowSolver solver = new MaxFlowSolver(network, 0, network.size() - 1);

            // Find and print the maximum flow value
            System.out.println("\nMaximum Flow: " + solver.findMaxFlow());
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}