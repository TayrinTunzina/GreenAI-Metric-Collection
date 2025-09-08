import java.util.*;

public class MinimumMoves {
    public static int minMoves(int n) {
        int moves = 0;
        while (n > 0) {
            boolean reduced = false;
            for (int i = (int) Math.sqrt(n); i > 1; i--) {
                if (n % i == 0) { // Found factors a and b
                    n = Math.max(i, n / i);
                    moves++;
                    reduced = true;
                    break;
                }
            }
            if (!reduced) {
                n -= 1;
                moves++;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        int[] results = new int[q]; // Store results to avoid mixed outputs

        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt();
            results[i] = minMoves(n);
        }

        for (int res : results) {
            System.out.println(res);
        }

        scanner.close();
    }
}
