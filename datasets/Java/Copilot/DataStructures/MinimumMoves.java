import java.util.Scanner;

public class MinimumMoves {
    public static int minMoves(int N) {
        if (N == 0) return 0;
        int moves = 0;
        while (N > 0) {
            boolean divided = false;
            for (int i = 2; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    N = Math.max(i, N / i);
                    divided = true;
                    break;
                }
            }
            if (!divided) {
                N--;
            }
            moves++;
        }
        return moves;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of queries: ");
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            System.out.print("Enter the value of N: ");
            int N = scanner.nextInt();
            System.out.println(minMoves(N));
        }
    }
}
