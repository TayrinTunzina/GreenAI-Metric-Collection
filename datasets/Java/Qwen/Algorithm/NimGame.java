import java.util.Scanner;

public class NimGame {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        // If m is large, 2^m - 1 is huge, so we only care about comparison with n
        // We need to compute U = 2^m - 1, but may be very large
        // We only need to know if U < n, else compute falling factorial

        long U;
        if (m > 60) {
            U = Long.MAX_VALUE; // effectively > n since n <= 10^7
        } else {
            U = (1L << m) - 1;
        }

        if (n > U) {
            System.out.println(0);
            return;
        }

        // Calculate total = P(U, n) = U * (U-1) * ... * (U-n+1) mod MOD
        long total = 1;
        for (int i = 0; i < n; i++) {
            total = (total * ((U - i) % MOD)) % MOD;
        }

        // Calculate losing = P(2^{m-1} - 1, n)
        long V;
        if (m - 1 > 60) {
            V = Long.MAX_VALUE;
        } else {
            V = (1L << (m - 1)) - 1;
        }

        long losing = 0;
        if (n <= V) {
            losing = 1;
            for (int i = 0; i < n; i++) {
                losing = (losing * ((V - i) % MOD)) % MOD;
            }
        } else {
            losing = 0;
        }

        // The number of winning games
        long answer = (total - losing + MOD) % MOD;
        System.out.println(answer);
    }
}