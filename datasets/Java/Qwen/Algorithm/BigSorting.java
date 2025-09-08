import java.util.*;
import java.math.BigInteger;

public class BigSorting {
    public static List<String> bigSorting(List<String> unsorted) {
        // Sort using custom comparator
        Collections.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // First compare by length
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                }
                // If same length, compare lexicographically
                return a.compareTo(b);
            }
        });
        return unsorted;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        List<String> unsorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            unsorted.add(scanner.nextLine().trim());
        }
        
        List<String> result = bigSorting(unsorted);
        for (String item : result) {
            System.out.println(item);
        }
        
        scanner.close();
    }
}