// Tom Le
// COSC 2336-01
// Programming Assignment 1
// Due: 9/7/22
// Submitted: 9/6/22
// Write a test program that prompts the user to enter a string and calls the 
// reverseDisplay method to display its reversal

import java.util.Scanner;

public class RecursiveReverseStringTomLe {

    public static void reverseDisplay(String value) {
        if (value.length() <= 1) { // Base Case
            System.out.println(value);
        } else {
            System.out.print(value.charAt(value.length() - 1)); // Starts at the last letter of the String
            reverseDisplay(value.substring(0, value.length() - 1)); // Substring between the first letter and last letter, but 
                                                                    // starting from the last letter to first letter
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in); // Create scanner object

        System.out.print("Enter a string: "); // Prompt the user to enter a string
        String value = input.nextLine();

        System.out.print("The reversal of " + value + " is ");
        reverseDisplay(value); // Display the input value in reverse order

        input.close(); // Close scanner 
    }
}
