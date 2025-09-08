import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MatchingStrings {
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : stringList) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (String query : queries) {
            result.add(frequencyMap.getOrDefault(query, 0));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of stringList: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            stringList.add(scanner.nextLine());
        }

        System.out.print("Enter the size of queries: ");
        int q = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<String> queries = new ArrayList<>();
        for (int i = 0; i < q; ++i) {
            queries.add(scanner.nextLine());
        }

        List<Integer> result = matchingStrings(stringList, queries);
        for (int count : result) {
            System.out.print(count + " ");
        }
        System.out.println();

        scanner.close();
    }
}
