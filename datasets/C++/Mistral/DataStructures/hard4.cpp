#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

int main() {
    int N;
    cout << "Enter the number of elements in the array: ";
    cin >> N;
    vector<int> A(N);
    cout << "Enter the elements of the array separated by space: ";
    for (int i = 0; i < N; ++i) {
        cin >> A[i];
    }

    int max_si_value = INT_MIN;

    for (int L = 0; L < N; ++L) {
        for (int R = L + 1; R < N; ++R) {
            vector<int> subarray(A.begin() + L, A.begin() + R + 1);
            sort(subarray.begin(), subarray.end());
            int M1 = subarray[0];
            int M2 = subarray[1];
            int Si = (((M1 & M2) ^ (M1 | M2)) & (M1 ^ M2));
            if (Si > max_si_value) {
                max_si_value = Si;
            }
        }
    }

    cout << "The maximum possible value of Si is: " << max_si_value << endl;

    return 0;
}
