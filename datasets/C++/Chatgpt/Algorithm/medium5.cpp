#include <bits/stdc++.h>
using namespace std;

int grundy(long long m, int k) {
    int g = 0;
    while (m > 1) {
        m = (m + k - 2) / k; // ceil((m-1)/k)
        g ^= 1;
    }
    return g;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int G;
    cout << "Enter number of games: ";
    cin >> G;
    while (G--) {
        int n;
        cout << "Enter number of trees: ";
        cin >> n;
        int xor_sum = 0;
        for (int i = 0; i < n; i++) {
            long long m;
            int k;
            cin >> m >> k;
            xor_sum ^= grundy(m, k);
        }
        cout << (xor_sum ? "BOB" : "BEN") << "\n";
    }
}
