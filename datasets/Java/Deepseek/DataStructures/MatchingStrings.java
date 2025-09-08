import java.util.*;

public class MatchingStrings {
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : stringList) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (String q : queries) {
            result.add(countMap.getOrDefault(q, 0));
        }
        return result;
    }

    public static void main(String[] args) {
        // Taking input manually from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings in the list: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i+1) + ": ");
            stringList.add(scanner.nextLine());
        }
        System.out.print("Enter the number of queries: ");
        int q = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        List<String> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            System.out.print("Enter query " + (i+1) + ": ");
            queries.add(scanner.nextLine());
        }
        List<Integer> results = matchingStrings(stringList, queries);
        System.out.println("Results: " + results);
        scanner.close();
    }
}
