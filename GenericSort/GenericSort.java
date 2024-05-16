// Tom Le
// COSC 2336
// Instructor: Dr. Jane Liu
// Programming Assignment 2
// Due: 9/14/22
// Write a test program that: prompts the user to enter 10 integers, 
// invokes this method to sort the numbers, and displays the numbers in ascending order
// and prompts the user to enter 5 strings, invokes this method to sort the strings, 
// and displays the strings in ascending (alphabetical) order

import java.util.ArrayList;
import java.util.Scanner;

public class GenericSortTomLe<E> {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        // Create array lists for Integer and String
        ArrayList<Integer> intArray = new ArrayList<Integer>();
        ArrayList<String> stringArray = new ArrayList<String>();

        // Create scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter 10 integers
        System.out.print("Enter 10 integers: ");
        for (int i = 0; i < 10; i++) {
            Integer integer = input.nextInt();
            intArray.add(integer);
        }

        // Call the sort method to sort the array of integers
        sort(intArray);
        System.out.print("The sorted numbers are: ");
        
        // Print the sorted integers evenly spaced
        for (int i = 0; i < intArray.size(); i++) {
            System.out.print(intArray.get(i) + " ");
        }
        System.out.println();

        // Prompt the user to enter 5 strings
        System.out.print("Enter 5 strings: ");
        for (int i = 0; i < 5; i++) {
            String string = input.next();
            stringArray.add(string);
        }

        // Call the sort method to sort the array of strings
        sort(stringArray);
        System.out.print("The sorted strings are: ");

        // Print the sorted strings evenly spaced
        for (int i = 0; i < stringArray.size(); i++) {
            System.out.print(stringArray.get(i) + " ");
        }
        System.out.println();

        // Close scanner
        input.close();
    }

    // Sort an array of comparable objects
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        E currentMin;
        int currentMinIndex;

        for (int i = 0; i < list.size() - 1; i++) {
            // Find the minimum in the list.get(i)
            currentMin = list.get(i);
            currentMinIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (currentMin.compareTo(list.get(j)) > 0) {
                    currentMin = list.get(j);
                    currentMinIndex = j;
                }
            }

            // Swap list.get(i) with currentMinIndex
            if (currentMinIndex != i) {
                list.set(currentMinIndex, list.get(i));
                list.set(i, currentMin);
            }
        }
    }
}