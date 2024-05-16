// Tom Le
// COSC 2336
// Instructor: Dr. Jane Liu
// Programming Assignment 11 + 12
// Due: 11/28/22
// Write a program that reads a connected graph from a file. 
// The graph is stored in a file using the format specified below. 
// Your program should prompt the user to enter the name of the file then two 
// vertices, and should display a shortest path between the two vertices. 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShortestPathsTomLe {
	
	public static void main(String[] args) throws FileNotFoundException {
		
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        String fileName = input.nextLine();
        

        // Init graphs
        ArrayList<WeightedEdge> edges = new ArrayList<>();
        ArrayList<Integer> vertices = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();

        // Read contents of file
        Scanner inputGraph = new Scanner(new File(fileName));
        int numberOfVertices = inputGraph.nextInt();
        
        System.out.println();
       
        while (inputGraph.hasNext()) {
            lines.add(inputGraph.nextLine());
        }
        
        
        // Parse contents of file
        lines.remove(0);
        for (String line : lines) {
            String[] portions = line.split("\\|");

            for (String portion : portions) {
                String[] e = portion.split("\\s*,\\s*");

                int u = Integer.parseInt(e[0].trim());
                int v = Integer.parseInt(e[1].trim());
                int weight = Integer.parseInt(e[2].trim());
                WeightedEdge we = new WeightedEdge(u, v, weight);
                WeightedEdge wei = new WeightedEdge(v, u, weight);

                if (!vertices.contains(u)) vertices.add(u);
                if (!vertices.contains(v)) vertices.add(v);
                edges.add(we);
                edges.add(wei);
            }
        }
        // Sort vertices and edges
        Collections.sort(vertices);
        Collections.sort(edges);

        // Create graph
        WeightedGraph<Integer> graph = new WeightedGraph<>(vertices, edges);

        // Display results
        System.out.print("Enter two vertices (integer indexes): "); // root for dfs
        int root = input.nextInt();
        int index = input.nextInt();
        
        System.out.println();
        
        System.out.println("The number of vertices is " + graph.getVertices().size()); 
        graph.printWeightedEdges(); 
        UnweightedGraph<Integer>.SearchTree st = graph.dfs(root);
        st.printPath(index);
        
        input.close();
    }
}