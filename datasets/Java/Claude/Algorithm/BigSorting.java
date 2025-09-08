import java.util.*;
import java.util.Scanner;

public class BigSorting {
    
    public static List<String> bigSorting(List<String> unsorted) {
        // Sort using custom comparator
        Collections.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // First compare by length
                if (s1.length() != s2.length()) {
                    return Integer.compare(s1.length(), s2.length());
                }
                // If same length, compare lexicographically
                return s1.compareTo(s2);
            }
        });
        
        return unsorted;
    }
    
    // Alternative using lambda expression (Java 8+)
    public static List<String> bigSortingLambda(List<String> unsorted) {
        Collections.sort(unsorted, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            }
            return s1.compareTo(s2);
        });
        
        return unsorted;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        List<String> unsorted = new ArrayList<>();
        System.out.println("Enter " + n + " numeric strings:");
        
        for (int i = 0; i < n; i++) {
            unsorted.add(scanner.nextLine().trim());
        }
        
        List<String> result = bigSorting(unsorted);
        
        System.out.println("\nSorted array:");
        for (String num : result) {
            System.out.println(num);
        }
        
        scanner.close();
    }
}