import java.io.BufferedReader; // For efficient reading of input lines
import java.io.IOException;    // For handling input/output exceptions
import java.io.InputStreamReader; // To bridge byte streams to character streams
import java.util.ArrayList;    // For using ArrayList
import java.util.List;         // For using List interface

public class MatchingStrings {

    // Function to count occurrences of query strings
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        List<Integer> results = new ArrayList<>();
        for (String query : queries) {
            int count = 0;
            for (String s : stringList) {
                // In Java, use .equals() for string content comparison
                if (s.equals(query)) {
                    count++;
                }
            }
            results.add(count);
        }
        return results;
    }

    public static void main(String[] args) throws IOException {
        // --- Input section ---
        // Using BufferedReader for faster input, especially for competitive programming
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of strings in stringList (n):");
        int n = Integer.parseInt(bufferedReader.readLine().trim()); // Read line and parse to int

        // Corrected line: Using string concatenation
        System.out.println("Enter " + n + " strings for stringList, one per line:");
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stringList.add(bufferedReader.readLine()); // Read string line by line
        }

        System.out.println("\nEnter the number of query strings (q):");
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        // Corrected line: Using String.format()
        System.out.println(String.format("Enter %d query strings, one per line:", q));
        List<String> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            queries.add(bufferedReader.readLine());
        }

        // --- Processing and Output section ---
        List<Integer> results = matchingStrings(stringList, queries);

        System.out.println("\n--- Results ---");
        for (int res : results) {
            System.out.println(res);
        }

        bufferedReader.close(); // Close the BufferedReader to release system resources
    }
}