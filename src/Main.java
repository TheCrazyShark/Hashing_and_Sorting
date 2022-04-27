import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static String fileName = "";
    private static String text = "";

    public static void main(String[] args) {
        System.out.println("Please enter the filename");
        fileName = input.next();

        // Try & catch to read and convert file
        try { readFile(); } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }

    // Read and convert file
    public static void readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/" + fileName));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.toUpperCase();
            text += line;
        }
        text = text.replaceAll("[^A-Za-z0-9]", " ");
    }

    public static void countHash() {
        // declare with a String and an integer:
        TreeMap myTreeMap = new TreeMap<>();
        /*place the word and count into myTreeMap using the put method
        Use an iterator to print the each entry's Key and Value*/
        for (Map.Entry entry : myTreeMap.entrySet()) {

        }
    }
}
