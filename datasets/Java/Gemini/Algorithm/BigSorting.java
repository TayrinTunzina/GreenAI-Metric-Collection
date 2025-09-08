import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BigSorting {

    public static List<String> bigSorting(List<String> unsorted) {
        // Custom Comparator for sorting strings representing large numbers
        Collections.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 1. Compare by length first
                if (s1.length() != s2.length()) {
                    return Integer.compare(s1.length(), s2.length());
                } else {
                    // 2. If lengths are same, compare lexicographically
                    // (which is equivalent to numerical comparison for same-length numbers)
                    return s1.compareTo(s2);
                }
            }
        });
        return unsorted;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Manual Input:
        System.out.println("Enter the number of strings (n):");
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter string " + (i + 1) + ":");
            String unsortedItem = bufferedReader.readLine();
            unsorted.add(unsortedItem);
        }

        // For competitive programming, typically input is just read without prompts:
        /*
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> unsorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            unsorted.add(bufferedReader.readLine());
        }
        */

        List<String> result = bigSorting(unsorted);

        System.out.println("\n--- Sorted Array ---");
        for (String item : result) {
            System.out.println(item);
        }

        bufferedReader.close();
    }
}