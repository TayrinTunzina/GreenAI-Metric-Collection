import java.util.*;

public class MatchingStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of string list: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.println("Enter " + n + " strings (one per line):");
        String[] stringList = new String[n];
        for (int i = 0; i < n; i++) {
            stringList[i] = scanner.nextLine().trim();
        }
        
        System.out.print("Enter the number of queries: ");
        int q = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.println("Enter " + q + " query strings (one per line):");
        String[] queries = new String[q];
        for (int i = 0; i < q; i++) {
            queries[i] = scanner.nextLine().trim();
        }
        
        System.out.println("\nResults:");
        // Process and output results
        int[] results = new int[q];
        for (int i = 0; i < q; i++) {
            int count = 0;
            for (String str : stringList) {
                if (str.equals(queries[i])) {
                    count++;
                }
            }
            System.out.println("Query '" + queries[i] + "': " + count);
            results[i] = count;
        }
        
        System.out.println("\nAnswer array: " + Arrays.toString(results));
        
        scanner.close();
    }
}
