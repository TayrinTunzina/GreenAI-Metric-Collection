#include <iostream>
using namespace std;

const int MOD = 1000000007;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    long long n, m;
    cin >> n >> m;

    // Compute N = 2^m - 1
    // If m >= 30, 2^m > 1e9, so use modular logic carefully
    // But we only need N as a number for comparison and multiplication

    long long N;
    if (m >= 60) {
        // 2^m - 1 is huge, definitely > n (since n <= 1e7)
        N = (1LL << 60) - 1; // symbolic, but we can't compute directly
        // Instead, handle with care
        // For m >= 60, 2^m - 1 > 1e18, so n (<=1e7) is always <= N
        // So we can just compute the product
        long long result = 1;
        for (long long i = 0; i < n; i++) {
            // (2^m - 1 - i) mod MOD
            // But 2^m mod MOD is not 0, but we can't compute 2^m directly
            // We need a better way
            // Actually, we can compute (2^m - 1 - i) mod MOD
            // But 2^m mod MOD can be computed with modular exponentiation
            // However, the falling factorial is over integers, not mod 2^m
            // This is a problem
        }
        // This approach fails for large m
    }

    if (m > 60) {
        // 2^m - 1 > 1e18, so n (<=1e7) < 2^m - 1
        // So we compute the product: ∏_{i=0}^{n-1} ( (2^m - 1 - i) mod MOD )
        long long result = 1;
        // Compute 2^m mod MOD
        long long pow2 = 1;
        long long base = 2;
        long long exp = m;
        while (exp > 0) {
            if (exp & 1) {
                pow2 = (pow2 * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        // Now pow2 = 2^m mod MOD
        // So (2^m - 1 - i) mod MOD = (pow2 - 1 - i) % MOD
        for (long long i = 0; i < n; i++) {
            long long term = (pow2 - 1 - i) % MOD;
            if (term < 0) term += MOD;
            result = (result * term) % MOD;
        }
        cout << result << endl;
    } else {
        N = (1LL << m) - 1;
        if (n > N) {
            cout << 0 << endl;
        } else {
            long long result = 1;
            for (long long i = 0; i < n; i++) {
                result = (result * (N - i)) % MOD;
            }
            cout << result << endl;
        }
    }

    return 0;
}