#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

long long arrayManipulation(int n, vector<vector<int>>& queries) {
    vector<long long> arr(n + 1, 0);

    for (const auto& query : queries) {
        int a = query[0];
        int b = query[1];
        int k = query[2];
        arr[a - 1] += k;
        if (b <= n) {
            arr[b] -= k;
        }
    }

    long long max_value = 0;
    long long running_sum = 0;

    for (const auto& value : arr) {
        running_sum += value;
        if (running_sum > max_value) {
            max_value = running_sum;
        }
    }

    return max_value;
}

int main() {
    int n, m;
    cout << "Enter the number of elements in the array: ";
    cin >> n;
    cout << "Enter the number of operations: ";
    cin >> m;
    vector<vector<int>> queries(m, vector<int>(3));
    for (int i = 0; i < m; ++i) {
        cout << "Enter the start index (a), end index (b), and value to add (k): ";
        cin >> queries[i][0] >> queries[i][1] >> queries[i][2];
    }

    long long result = arrayManipulation(n, queries);
    cout << "The maximum value in the array is: " << result << endl;

    return 0;
}
