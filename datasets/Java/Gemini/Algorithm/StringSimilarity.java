import java.util.Scanner;

public class StringSimilarity {

    public static int sumOfSimilarities(String s) {
        int n = s.length();
        int sumSimilarities = 0;

        for (int i = 0; i < n; i++) { // Iterate through each suffix
            int j = 0;
            while (i + j < n && s.charAt(j) == s.charAt(i + j)) {
                j++;
            }
            sumSimilarities += j;
        }

        return sumSimilarities;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            System.out.println(sumOfSimilarities(s));
        }
    }
}
