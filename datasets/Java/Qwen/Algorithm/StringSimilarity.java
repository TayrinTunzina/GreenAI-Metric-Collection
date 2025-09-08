import java.util.Scanner;

public class StringSimilarity {
    public static int[] zAlgorithm(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }

    public static long sumOfSimilarities(String s) {
        int[] z = zAlgorithm(s);
        long total = s.length(); // Similarity of string with itself
        for (int val : z) {
            total += val;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        while (t-- > 0) {
            System.out.print("Enter the string: ");
            String s = scanner.nextLine();
            System.out.println(sumOfSimilarities(s));
        }
        scanner.close();
    }
}