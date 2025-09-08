#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;

long long pow_mod(long long base, long long exp) {
    long long res = 1;
    while (exp > 0) {
        if (exp % 2 == 1) {
            res = (res * base) % MOD;
        }
        base = (base * base) % MOD;
        exp /= 2;
    }
    return res;
}

void solve() {
    int n, m;
    cin >> n >> m;
    int max_num = 1 << m;
    if (n > max_num - 1) {
        cout << 0 << endl;
        return;
    }
    
    vector<long long> fact(max_num);
    fact[0] = 1;
    for (int i = 1; i < max_num; ++i) {
        fact[i] = fact[i-1] * i % MOD;
    }
    
    long long ans = fact[max_num - 1] * pow_mod(fact[max_num - 1 - n], MOD - 2) % MOD;
    cout << ans << endl;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    solve();
    return 0;
}