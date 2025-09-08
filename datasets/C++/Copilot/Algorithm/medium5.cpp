#include <iostream>
using namespace std;

int computeGrundy(long long m, int k) {
    if (m == 1) return 1;
    int depth = 0;
    while (m > 1) {
        m = max(1LL, m / k);
        depth++;
    }
    return depth % 2;
}

int main() {
    int g;
    cin >> g;
    while (g--) {
        int n;
        cin >> n;
        int xor_sum = 0;
        for (int i = 0; i < n; ++i) {
            long long m;
            int k;
            cin >> m >> k;
            xor_sum ^= computeGrundy(m, k);
        }
        cout << (xor_sum ? "BOB" : "BEN") << endl;
    }
    return 0;
}
