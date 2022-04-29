import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static String fileName = "";
    private static String text = "";
    private static String[] words;

    public static void main(String[] args) {
        System.out.println("Please enter the filename");
        fileName = input.next();

        // Try & catch to read and convert file
        try { readFile(); } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }

        countHash();
    }

    // Read and convert file
    public static void readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/" + fileName));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.toUpperCase();
            line = line.replaceAll("[^A-Za-z0-9]", " ");
            text += line;
        }

        words = text.split("\\s+");
    }

    public static void countHash() {
        int count;
        TreeMap<String, Integer> myTreeMap = new TreeMap<>(); // declare with a String and an integer:
        /*place the word and count into myTreeMap using the put method
        Use an iterator to print the each entry's Key and Value*/

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

        /*for (Map.Entry entry : myTreeMap.entrySet()) {

        }*/
        // Print out counts of all numbers
        System.out.println("\nCounts");
        for( Map.Entry<String, Integer> entry : myTreeMap.entrySet() ){
            System.out.println( entry.getKey() + ": " + entry.getValue() );
        }
    }
}
