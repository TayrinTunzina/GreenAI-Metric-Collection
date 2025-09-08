import java.util.*;

public class MatchingStrings {
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        List<Integer> results = new ArrayList<>();
        for (String query : queries) {
            int count = 0;
            for (String str : stringList) {
                if (str.equals(query)) count++;
            }
            results.add(count);
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of strings in stringList: ");
        int n = Integer.parseInt(scanner.nextLine());
        List<String> stringList = new ArrayList<>();
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            stringList.add(scanner.nextLine().trim());
        }

        System.out.print("Enter number of queries: ");
        int q = Integer.parseInt(scanner.nextLine());
        List<String> queries = new ArrayList<>();
        System.out.println("Enter the queries:");
        for (int i = 0; i < q; i++) {
            queries.add(scanner.nextLine().trim());
        }

        List<Integer> results = matchingStrings(stringList, queries);
        System.out.println("Query results:");
        for (int res : results) {
            System.out.println(res);
        }

        scanner.close();
    }
}
