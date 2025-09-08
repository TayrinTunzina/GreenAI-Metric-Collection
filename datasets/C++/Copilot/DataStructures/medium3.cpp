#include <iostream>
#include <cmath>
using namespace std;

int min_moves(int N) {
    if (N == 0) return 0;
    int moves = 0;
    while (N > 0) {
        bool divided = false;
        for (int i = 2; i <= sqrt(N); ++i) {
            if (N % i == 0) {
                N = max(i, N / i);
                divided = true;
                break;
            }
        }
        if (!divided) {
            --N;
        }
        ++moves;
    }
    return moves;
}

int main() {
    int Q;
    cout << "Enter the number of queries: ";
    cin >> Q;
    for (int i = 0; i < Q; ++i) {
        int N;
        cout << "Enter the value of N: ";
        cin >> N;
        cout << min_moves(N) << endl;
    }
    return 0;
}
