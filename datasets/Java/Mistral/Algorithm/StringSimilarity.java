import java.util.Scanner;

public class StringSimilarity {

    public static int calculateSimilaritySum(String s) {
        int n = s.length();
        int totalSimilarity = 0;
        for (int i = 0; i < n; ++i) {
            String suffix = s.substring(i);
            int similarity = 0;
            for (int j = 0; j < suffix.length(); ++j) {
                if (s.charAt(j) == suffix.charAt(j)) {
                    similarity++;
                } else {
                    break;
                }
            }
            totalSimilarity += similarity;
        }
        return totalSimilarity;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        int[] results = new int[t];
        for (int i = 0; i < t; ++i) {
            System.out.print("Enter the string: ");
            String s = scanner.nextLine();
            results[i] = calculateSimilaritySum(s);
        }
        for (int result : results) {
            System.out.println(result);
        }
        scanner.close();
    }
}
