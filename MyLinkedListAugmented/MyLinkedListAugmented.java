// Tom Le
// COSC 2336
// Instructor: Dr. Jane Liu
// Programming Assignment 7
// Due: 10/21/22
// Define a new class named MyLinkedListExtra that extends MyLinkedList to override these methods.

import java.util.Scanner;

public class MyLinkedListAugmentedTomLe {

	/** Main method */
	  public static void main(String[] args) {
	    // Create a list for strings
	    MyLinkedList<String> list = new MyLinkedListExtra<>();
	    
	    Scanner input = new Scanner(System.in);

	    // Print the original list
	    System.out.println("Original list: ");
	    
	    // Add elements to the list
	    list.add("Mike"); // Add Mike to the list
	    list.add("Jim"); // Add Jim to the list
	    list.add("Alice"); // Add Alice to the list
	    list.add("George"); // Add George to the list
	    list.add("Stevie"); // Add Stevie to the list
	    list.add("Cheryl"); // Add Cheryl to the list
	    list.add("George"); // Add George to the list
	    list.add("Jane"); // Add Jane to the list 
	    list.add("Ella"); // Add Ella to the list
	    list.add("Jenny"); // Add Jenny to the list	    
	    list.add("Kathy"); // Add Kathy to the list
	    list.add("Jane"); // Add Jane to the list
	    System.out.println(list);
	    
	    // Prompt the user to enter a name
	    System.out.print("Enter a name: ");
	    String name = input.nextLine();
	    
	    // Prompt the user to enter an index
	    System.out.print("Enter an index at which to store this name: ");
	    int index = input.nextInt();
	    
	    // Add the name to the index
	    list.add(index, name);
	    
	    // Print the revised list
	    System.out.println("Revised list: ");
	    System.out.println(list);
	   
	    // Check if name is in the list
	    System.out.println("List contains " + name + ": " + list.contains(name));
	    
	    // Print out the name at the inputed index
	    System.out.println("Item at index " + index + ": " + list.get(index));

	    // Get index of George
	    int index2 = list.indexOf("George");
	    
	    // Get last index of George
	    int index3 = list.lastIndexOf("George");
	    
	    // Print out the index of George
	    System.out.println("Index of George: " + index2);
	    
	    // Print out the last index of George
	    System.out.println("Last index of George: " + index3);

	    input.close(); // Close scanner
	    
	  }
	}