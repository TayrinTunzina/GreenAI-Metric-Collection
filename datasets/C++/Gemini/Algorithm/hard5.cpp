#include <iostream>
#include <vector>

using namespace std;

long long power(long long base, long long exp) {
    long long res = 1;
    long long MOD = 1000000007;
    base %= MOD;
    while (exp > 0) {
        if (exp % 2 == 1) res = (res * base) % MOD;
        base = (base * base) % MOD;
        exp /= 2;
    }
    return res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    long long m;
    cin >> n >> m;

    long long MOD = 1000000007;

    long long p2m = power(2, m);
    long long winning_games = 1;
    long long p2i = 1; // This will hold 2^i

    for (int i = 0; i < n; ++i) {
        long long term = (p2m - p2i + MOD) % MOD;
        winning_games = (winning_games * term) % MOD;
        p2i = (p2i * 2) % MOD;
    }

    cout << winning_games << endl;

    return 0;
}