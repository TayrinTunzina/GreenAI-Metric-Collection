import java.util.*;
import java.io.*;

public class NimGame {
    static final int MOD = (int)1e9 + 7;

    static long powMod(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = res * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int maxNum = 1 << m;
        if (n > maxNum - 1) {
            System.out.println(0);
            return;
        }
        
        long[] fact = new long[maxNum];
        fact[0] = 1;
        for (int i = 1; i < maxNum; i++) {
            fact[i] = fact[i-1] * i % MOD;
        }
        
        long ans = fact[maxNum - 1] * powMod(fact[maxNum - 1 - n], MOD - 2) % MOD;
        System.out.println(ans);
    }
}