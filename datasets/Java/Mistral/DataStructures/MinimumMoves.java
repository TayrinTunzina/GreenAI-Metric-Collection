import java.util.Scanner;

public class MinimumMoves {
    public static int minMovesToZero(int N) {
        if (N == 0) return 0;
        if (N <= 3) return N;
        int maxFactor = (int) Math.sqrt(N);
        for (int i = 2; i <= maxFactor; ++i) {
            if (N % i == 0) {
                return 1 + Math.min(minMovesToZero(N / i), minMovesToZero(i));
            }
        }
        return N;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of queries: ");
        int Q = scanner.nextInt();
        int[] results = new int[Q];
        for (int i = 0; i < Q; ++i) {
            System.out.print("Enter the value of N: ");
            int N = scanner.nextInt();
            results[i] = minMovesToZero(N);
        }
        for (int result : results) {
            System.out.println(result);
        }
        scanner.close();
    }
}
