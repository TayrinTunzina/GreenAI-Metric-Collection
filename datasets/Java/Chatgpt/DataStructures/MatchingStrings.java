import java.util.*;

public class MatchingStrings {
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        List<Integer> result = new ArrayList<>();
        for (String query : queries) {
            int count = 0;
            for (String s : stringList) {
                if (s.equals(query)) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of input strings:");
        int n = Integer.parseInt(scanner.nextLine());
        List<String> stringList = new ArrayList<>();

        System.out.println("Enter the input strings one by one:");
        for (int i = 0; i < n; i++) {
            stringList.add(scanner.nextLine().trim());
        }

        System.out.println("Enter number of queries:");
        int q = Integer.parseInt(scanner.nextLine());
        List<String> queries = new ArrayList<>();

        System.out.println("Enter the queries one by one:");
        for (int i = 0; i < q; i++) {
            queries.add(scanner.nextLine().trim());
        }

        List<Integer> results = matchingStrings(stringList, queries);
        System.out.println("Query Results:");
        for (int r : results) {
            System.out.println(r);
        }
    }
}
