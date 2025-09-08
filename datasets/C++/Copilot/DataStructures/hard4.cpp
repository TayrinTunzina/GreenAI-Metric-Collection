#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N;
    cout << "Enter number of elements: ";
    cin >> N;
    
    vector<int> A(N);
    cout << "Enter the elements: ";
    for (int i = 0; i < N; ++i) cin >> A[i];

    int max_si = 0;
    for (int i = 0; i < N - 1; ++i) {
        int m1 = min(A[i], A[i+1]);
        int m2 = max(A[i], A[i+1]);
        int si = ((m1 & m2) ^ (m1 | m2)) & (m1 ^ m2);
        max_si = max(max_si, si);
    }

    cout << "Maximum Si: " << max_si << endl;
    return 0;
}
