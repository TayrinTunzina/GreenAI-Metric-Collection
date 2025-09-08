#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int minMoves(int n) {
    int moves = 0;
    while (n > 0) {
        bool reduced = false;
        for (int i = sqrt(n); i > 1; i--) {
            if (n % i == 0) { // Found factors a and b
                n = max(i, n / i);
                moves++;
                reduced = true;
                break;
            }
        }
        if (!reduced) {
            n -= 1;
            moves++;
        }
    }
    return moves;
}

int main() {
    int q;
    cin >> q;
    vector<int> results(q); // Store results to avoid mixed outputs

    for (int i = 0; i < q; i++) {
        int n;
        cin >> n;
        results[i] = minMoves(n);
    }

    for (int res : results) {
        cout << res << endl;
    }

    return 0;
}
