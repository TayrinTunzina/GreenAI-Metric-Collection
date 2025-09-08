#include <iostream>
#include <vector>
using namespace std;

const int MOD = 1000000007;
const int MAXN = 2000000;

long long fact[MAXN];
bool fact_computed = false;

long long power(long long base, long long exp, long long mod) {
    long long result = 1;
    base %= mod;
    while (exp > 0) {
        if (exp & 1) {
            result = (result * base) % mod;
        }
        base = (base * base) % mod;
        exp >>= 1;
    }
    return result;
}

long long modInverse(long long a) {
    return power(a, MOD - 2, MOD);
}

void computeFactorials() {
    if (fact_computed) return;
    fact[0] = 1;
    for (int i = 1; i < MAXN; i++) {
        fact[i] = (fact[i-1] * (long long)i) % MOD;
    }
    fact_computed = true;
}

long long permutation(int n, int r) {
    if (r > n || r < 0 || n >= MAXN) return 0;
    return (fact[n] * modInverse(fact[n-r])) % MOD;
}

long long combination(int n, int r) {
    if (r > n || r < 0 || n >= MAXN) return 0;
    return (fact[n] * modInverse(fact[r]) % MOD * modInverse(fact[n-r])) % MOD;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, m;
    cin >> n >> m;
    
    long long max_val = (1LL << m) - 1;  // 2^m - 1
    
    if (n > max_val) {
        cout << 0 << endl;
        return 0;
    }
    
    computeFactorials();
    
    // Total permutations
    long long total_perms;
    if (max_val < MAXN) {
        total_perms = permutation(max_val, n);
    } else {
        total_perms = 1;
        for (int i = 0; i < n; i++) {
            total_perms = (total_perms * ((max_val - i) % MOD)) % MOD;
        }
    }
    
    // Permutations with Nim-sum = 0
    long long zero_nim_perms = 0;
    
    if (n == 1 || n == 2) {
        zero_nim_perms = 0;  // XOR of distinct positive values can't be 0 for n=1,2
    } else {
        if (m > 1) {
            long long half_max = (1LL << (m-1)) - 1;
            if (half_max < MAXN && n-1 <= half_max) {
                long long zero_nim_combos = combination(half_max, n-1);
                if (n < MAXN) {
                    zero_nim_perms = (zero_nim_combos * fact[n]) % MOD;
                }
            }
        }
    }
    
    long long result = (total_perms - zero_nim_perms + MOD) % MOD;
    cout << result << endl;
    
    return 0;
}