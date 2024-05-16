// Tom Le
// COSC 2336-01
// Instructor: Dr. Jane Liu
// Programming Assignment 5
// Due: 9/10/22
// Write an O(n) time program that prompts the user to enter two strings and 
// tests whether the second string is a substring of the first string.

import java.util.Scanner;

public class PatternMatchingTomLe {
    public static void main(String[] args) {
        // Create a scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two strings
        System.out.print("Enter a string s1: ");
        String s1 = input.nextLine();

        System.out.print("Enter a string s2: ");
        String s2 = input.nextLine();

        // Find the starting index of the substring
        int index = indexOf(s1, s2);

        if (index != -1) {
            System.out.println("matches at index " + index);
        } else {
            System.out.println("unmatched");
        }

        // Close scanner
        input.close();
    }

    // Method to find the index of the first occurrence of s2 in s1
    public static int indexOf(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // If s2 is longer than s1, it cannot be a substring
        if (m > n) {
            return -1;
        }

        // Loop through s1 and check for substring match
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i; // Substring found at index i
            }
        }
        return -1; // Substring not found
    }
}
