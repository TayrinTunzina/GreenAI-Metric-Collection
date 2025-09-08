#include <iostream>
#include <vector>
#include <stack>
#include <climits>
using namespace std;

int main() {
    cout << "=== Find Maximum Si ===" << endl;

    int n;
    cout << "Enter the value of N: ";
    cin >> n;

    if (n < 2) {
        cout << "Maximum possible value of Si: 0" << endl;
        return 0;
    }

    vector<long long> A(n);
    for (int i = 0; i < n; i++) {
        cout << "Enter element " << i+1 << ": ";
        cin >> A[i];
    }

    vector<int> left(n, -1);
    vector<int> right(n, n);
    stack<int> st;

    // Find next smaller to the right
    for (int i = 0; i < n; i++) {
        while (!st.empty() && A[st.top()] > A[i]) {
            right[st.top()] = i;
            st.pop();
        }
        st.push(i);
    }

    while (!st.empty()) st.pop();

    // Find previous smaller to the left
    for (int i = n-1; i >= 0; i--) {
        while (!st.empty() && A[st.top()] > A[i]) {
            left[st.top()] = i;
            st.pop();
        }
        st.push(i);
    }

    long long max_si = 0;

    for (int i = 0; i < n; i++) {
        long long candidate = -1;  // smallest value > A[i] in range

        // Left side
        for (int j = i-1; j > left[i]; j--) {
            if (A[j] > A[i]) {
                if (candidate == -1 || A[j] < candidate) {
                    candidate = A[j];
                }
            }
        }

        // Right side
        for (int j = i+1; j < right[i]; j++) {
            if (A[j] > A[i]) {
                if (candidate == -1 || A[j] < candidate) {
                    candidate = A[j];
                }
            }
        }

        if (candidate != -1) {
            long long si = A[i] ^ candidate;
            if (si > max_si) {
                max_si = si;
            }
        }
    }

    cout << "Maximum possible value of Si: " << max_si << endl;
    return 0;
}