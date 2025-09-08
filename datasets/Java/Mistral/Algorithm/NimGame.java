import java.util.Scanner;

public class NimGame {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(countGames(n, m));
        scanner.close();
    }

    public static long countGames(int n, int m) {
        long maxStones = (1L << m) - 1;
        if (n > maxStones) {
            return 0;
        }

        // Calculate the number of permutations of n distinct piles
        long total = permutation(maxStones, n);

        // For n=2, all games are winning games since XOR of two distinct numbers cannot be zero
        long winningPositions = total % MOD;
        return winningPositions;
    }

    // Function to calculate permutation (n permute k)
    public static long permutation(long n, int k) {
        if (k > n) {
            return 0;
        }

        long result = 1;
        for (int i = 0; i < k; ++i) {
            result = result * (n - i) % MOD;
        }
        return result;
    }
}
