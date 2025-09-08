import java.util.Scanner;

public class StringSimilarity {
    public static int[] calculateZArray(String s) {
        int n = s.length();
        int[] Z = new int[n];
        Z[0] = n;
        int l = 0, r = 0;
        for (int i = 1; i < n; ++i) {
            if (i > r) {
                l = r = i;
                while (r < n && s.charAt(r - l) == s.charAt(r)) {
                    r++;
                }
                Z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (Z[k] < r - i + 1) {
                    Z[i] = Z[k];
                } else {
                    l = i;
                    while (r < n && s.charAt(r - l) == s.charAt(r)) {
                        r++;
                    }
                    Z[i] = r - l;
                    r--;
                }
            }
        }
        return Z;
    }

    public static int sumOfSimilarities(String s) {
        int[] Z = calculateZArray(s);
        int sum = 0;
        for (int z : Z) {
            sum += z;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        String[] testCases = new String[t];

        // Read each test case
        for (int i = 0; i < t; i++) {
            System.out.print("Enter test case " + (i + 1) + ": ");
            testCases[i] = scanner.nextLine();
        }

        // Calculate and print the sum of similarities for each test case
        for (int i = 0; i < t; i++) {
            System.out.println("Sum of similarities for \"" + testCases[i] + "\": " + sumOfSimilarities(testCases[i]));
        }

        scanner.close();
    }
}