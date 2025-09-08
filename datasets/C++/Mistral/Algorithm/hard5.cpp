#include <iostream>
using namespace std;

const int MOD = 1e9 + 7;

long long permutation(long long n, int k) {
    if (k > n) {
        return 0;
    }
    long long result = 1;
    for (int i = 0; i < k; ++i) {
        result = result * (n - i) % MOD;
    }
    return result;
}

long long countGames(int n, int m) {
    long long maxStones = (1LL << m) - 1;
    if (n > maxStones) {
        return 0;
    }

    // Calculate the number of permutations of n distinct piles
    long long total = permutation(maxStones, n);

    // For n=2, all games are winning games since XOR of two distinct numbers cannot be zero
    long long winningPositions = total % MOD;
    return winningPositions;
}

int main() {
    int n, m;
    cin >> n >> m;
    cout << countGames(n, m) << endl;
    return 0;
}
