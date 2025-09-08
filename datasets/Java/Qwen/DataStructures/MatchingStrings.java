import java.util.*;

public class MatchingStrings {
    // Function to count occurrences of queries in stringList
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> frequency = new HashMap<>();
        
        // Count frequency of each string in stringList
        for (String str : stringList) {
            frequency.put(str, frequency.getOrDefault(str, 0) + 1);
        }
        
        // For each query, check its frequency in the map
        for (String query : queries) {
            result.add(frequency.getOrDefault(query, 0));
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input size of stringList
        System.out.print("Enter the size of stringList: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        List<String> stringList = new ArrayList<>();
        System.out.println("Enter the strings in stringList:");
        for (int i = 0; i < n; i++) {
            stringList.add(scanner.nextLine());
        }
        
        // Input size of queries
        System.out.print("Enter the size of queries: ");
        int q = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        List<String> queries = new ArrayList<>();
        System.out.println("Enter the query strings:");
        for (int i = 0; i < q; i++) {
            queries.add(scanner.nextLine());
        }
        
        // Call the function and print the result
        List<Integer> result = matchingStrings(stringList, queries);
        System.out.print("Results: ");
        for (int count : result) {
            System.out.print(count + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}