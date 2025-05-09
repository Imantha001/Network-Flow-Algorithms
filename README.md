# Network Flow Algorithms

This project implements a program to solve the **Maximum Flow Problem** in a flow network using the **Edmonds-Karp Algorithm** (a BFS-based implementation of the Ford-Fulkerson method). The program reads flow network data from a text file, constructs the network, and calculates the maximum flow from the source node to the sink node.


### Key Files
- **[FlowNetwork.java](src/com/company/FlowNetwork.java)**: Defines the flow network structure and its edges.
- **[FlowNetworkParser.java](src/com/company/FlowNetworkParser.java)**: Parses a text file to construct a flow network.
- **[MaxFlowSolver.java](src/com/company/MaxFlowSolver.java)**: Implements the Edmonds-Karp algorithm to calculate the maximum flow.
- **[Main.java](src/com/company/Main.java)**: The entry point of the program. Handles user input and runs the solver.

### Example Input Files
- **[example1.txt](example/example1.txt)**: A sample flow network with 34 nodes.
- **[example2.txt](example/example2.txt)**: A smaller flow network with 4 nodes.

## How to Run

1. **Compile the Project**:
   Navigate to the `src` directory and compile the Java files:
   ```sh
   javac com/company/*.java

2. **Run the Program:** Execute the Main class
   ```sh
   java com.company.Main

3. **Provide Input:**
  - Select option 1 to solve a flow network from a text file.
  - Enter the file path (e.g., example/example1.txt).

4. **Output:**
The program will display the contents of the file and the calculated maximum flow

## Features
- **Flow Network Representation:** Uses adjacency lists to represent the network.
- **Edmonds-Karp Algorithm:** Finds the maximum flow using BFS to identify augmenting paths.
- **Error Handling:** Handles invalid file paths and malformed input files gracefully.
