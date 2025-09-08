#include <iostream>
using namespace std;

int grundy(long long m) {
    if (m == 2) return 0;
    else if (m % 2 == 1) return 1;
    else return 2;
}

int main() {
    int g;
    cin >> g;
    while (g--) {
        int n;
        cin >> n;
        int xor_val = 0;
        for (int i = 0; i < n; i++) {
            long long m, k;
            cin >> m >> k;
            xor_val ^= grundy(m);
        }
        cout << (xor_val != 0 ? "BOB" : "BEN") << endl;
    }
    return 0;
}