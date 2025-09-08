#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

int maxSi(vector<int>& arr) {
    stack<int> st;
    int max_xor = 0;

    for (int num : arr) {
        while (!st.empty() && st.top() < num) {
            max_xor = max(max_xor, st.top() ^ num);
            st.pop();
        }
        if (!st.empty()) {
            max_xor = max(max_xor, st.top() ^ num);
        }
        st.push(num);
    }

    return max_xor;
}

int main() {
    int N;
    cout << "Enter N: ";
    cin >> N;
    vector<int> A(N);
    cout << "Enter array elements: ";
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    cout << maxSi(A) << endl;
    return 0;
}
