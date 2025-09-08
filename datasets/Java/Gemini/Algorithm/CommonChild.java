import java.util.Scanner;
import java.util.Arrays;

public class CommonChild {

    public static int commonChild(String s1, String s2) {
        int n = s1.length();

        // Space optimized DP with two arrays.
        // prevDp for row i-1, currentDp for row i.
        int[] prevDp = new int[n + 1];
        int[] currentDp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Characters match: extend the common subsequence.
                    currentDp[j] = prevDp[j - 1] + 1;
                } else {
                    // Characters don't match: take the best of the alternatives.
                    currentDp[j] = Math.max(prevDp[j], currentDp[j - 1]);
                }
            }
            // The current row now becomes the previous row for the next iteration.
            // System.arraycopy is an efficient way to copy arrays.
            System.arraycopy(currentDp, 0, prevDp, 0, n + 1);
        }

        return prevDp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        scanner.close();

        int result = commonChild(s1, s2);
        System.out.println(result);
    }
}