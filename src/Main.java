import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

/*
Creator Names: Shane Smith and Chad Green.
Goal: Read in a specific text file, edit the words, then count and print them.
 */

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static String fileName = "";
    private static String text = "";
    private static String[] words;

    public static void main(String[] args) {
        System.out.print("Please enter the filename: ");
        fileName = input.next();

        // Try & catch to read and convert text in file
        try { readFile(); } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }

        countHash();
    }

    // Read and convert text in the file
    public static void readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/" + fileName));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.toUpperCase();
            line = line.replaceAll("[^A-Za-z0-9]", " ");
            text += line;
        }

        words = text.split("\\s+"); // Add all the words into an array
    }

    public static void countHash() {
        TreeMap<String, Integer> myTreeMap = new TreeMap<>(); // declare treemap with a String and an integer
        int count;

        // Checks current value & puts number into hashmap or increment count if value already exists
        for(int i=0; i < words.length; i++) {
            if (myTreeMap.get(words[i]) == null) {
                myTreeMap.put(words[i], 1);
            } else {
                count = myTreeMap.get((words[i]));
                count++;
                myTreeMap.put(words[i], count);
            }
        }

        // Print out words & their counts
        System.out.println("\nCounts: ");
        for( Map.Entry<String, Integer> entry : myTreeMap.entrySet() ){
            System.out.println( entry.getKey() + ": " + entry.getValue() );
        }
    }
}
