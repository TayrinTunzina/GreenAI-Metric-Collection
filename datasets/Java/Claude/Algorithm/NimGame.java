import java.util.*;
import java.io.*;

public class NimGame {
    private static final int MOD = 1000000007;
    private static final int MAXN = 2000000;
    private static long[] fact = new long[MAXN];
    private static boolean factComputed = false;
    
    public static long power(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
    
    public static long modInverse(long a) {
        return power(a, MOD - 2, MOD);
    }
    
    public static void computeFactorials() {
        if (factComputed) return;
        fact[0] = 1;
        for (int i = 1; i < MAXN; i++) {
            fact[i] = (fact[i-1] * i) % MOD;
        }
        factComputed = true;
    }
    
    public static long permutation(long n, long r) {
        if (r > n || r < 0 || n >= MAXN) return 0;
        return (fact[(int)n] * modInverse(fact[(int)(n-r)])) % MOD;
    }
    
    public static long combination(long n, long r) {
        if (r > n || r < 0 || n >= MAXN) return 0;
        return (fact[(int)n] * modInverse(fact[(int)r]) % MOD * modInverse(fact[(int)(n-r)])) % MOD;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long maxVal = (1L << m) - 1;  // 2^m - 1
        
        if (n > maxVal) {
            System.out.println(0);
            return;
        }
        
        computeFactorials();
        
        // Total permutations
        long totalPerms;
        if (maxVal < MAXN) {
            totalPerms = permutation(maxVal, n);
        } else {
            totalPerms = 1;
            for (int i = 0; i < n; i++) {
                totalPerms = (totalPerms * ((maxVal - i) % MOD)) % MOD;
            }
        }
        
        // Permutations with Nim-sum = 0
        long zeroNimPerms = 0;
        
        if (n == 1 || n == 2) {
            zeroNimPerms = 0;  // XOR of distinct positive values can't be 0 for n=1,2
        } else {
            if (m > 1) {
                long halfMax = (1L << (m-1)) - 1;
                if (halfMax < MAXN && n-1 <= halfMax) {
                    long zeroNimCombos = combination(halfMax, n-1);
                    if (n < MAXN) {
                        zeroNimPerms = (zeroNimCombos * fact[n]) % MOD;
                    }
                }
            }
        }
        
        long result = (totalPerms - zeroNimPerms + MOD) % MOD;
        System.out.println(result);
    }
}