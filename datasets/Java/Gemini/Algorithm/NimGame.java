import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class NimGame {
    static final int MOD = 1_000_000_007;

    static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long p2m = power(2, m);
        long winning_games = 1;
        long p2i = 1; // This will hold 2^i

        for (int i = 0; i < n; i++) {
            long term = (p2m - p2i + MOD) % MOD;
            winning_games = (winning_games * term) % MOD;
            p2i = (p2i * 2) % MOD;
        }
        
        System.out.println(winning_games);
    }
}