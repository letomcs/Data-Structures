// Tom Le
// COSC 2336-01
// Instructor: Dr. Jane Liu
// Programming Assignment 4
// Due: 9/28/22
// Write a program that will create a HashMap that maps the names of the U.S. states 
// to their corresponding capitals.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapOfStatesTomLe {
    public static void main(String[] args) {
        // Create a scanner object
        Scanner input = new Scanner(System.in);

        // Create a map using the StateCapital function
        Map<String, String> map = StateCapital();

        // Prompt the user to enter a state's name
        System.out.print("Enter a state: ");
        String state = input.nextLine();

        // Create an if statement to print the state capital 
        if (map.get(state) != null) {
            System.out.println("The capital of " + state + " is " + map.get(state));
        } else {
            System.out.println("No such state");
        }

        input.close();
    }

    public static Map<String, String> StateCapital() {
        // Create a HashMap
        Map<String, String> hashMap = new HashMap<>();

        // Create a String array using state-capital pairs
        String[][] stateCapital = {
            {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"}, {"California", "Sacramento"}, {"Colorado", "Denver"},
            {"Connecticut", "Hartford"}, {"Delaware", "Dover"}, {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"}, {"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
            {"Illinois", "Springfield"}, {"Indiana", "Indianapolis"}, {"Iowa", "Des Moines"},
            {"Kansas", "Topeka"}, {"Kentucky", "Frankfort"}, {"Louisiana", "Baton Rouge"},
            {"Maine", "Augusta"}, {"Maryland", "Annapolis"}, {"Massachusetts", "Boston"},
            {"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"}, {"Mississippi", "Jackson"},
            {"Missouri", "Jefferson City"}, {"Montana", "Helena"}, {"Nebraska", "Lincoln"},
            {"Nevada", "Carson City"}, {"New Hampshire", "Concord"}, {"New Jersey", "Trenton"},
            {"New York", "Albany"}, {"New Mexico", "Santa Fe"}, {"North Carolina", "Raleigh"},
            {"North Dakota", "Bismarck"}, {"Ohio", "Columbus"}, {"Oklahoma", "Oklahoma City"},
            {"Oregon", "Salem"}, {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"},
            {"South Carolina", "Columbia"}, {"South Dakota", "Pierre"}, {"Tennessee", "Nashville"},
            {"Texas", "Austin"}, {"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"},
            {"Virginia", "Richmond"}, {"Washington", "Olympia"}, {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"}, {"Wyoming", "Cheyenne"}
        };

        // Create a for loop to loop through the states and capitals
        for (int i = 0; i < stateCapital.length; i++) {
            hashMap.put(stateCapital[i][0], stateCapital[i][1]);
        }

        return hashMap;
    }
}
