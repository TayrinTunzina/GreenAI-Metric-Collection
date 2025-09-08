#include <iostream>
#include <vector>
using namespace std;

long arrayManipulation(int n, const vector<vector<int>>& queries) {
    vector<long> arr(n + 1, 0);

    for (const auto& query : queries) {
        int a = query[0], b = query[1], k = query[2];
        arr[a - 1] += k;
        if (b < n) arr[b] -= k;
    }

    long max_value = 0, x = 0;
    for (int i = 0; i < n; ++i) {
        x += arr[i];
        if (x > max_value) max_value = x;
    }

    return max_value;
}

int main() {
    int n, m;
    cout << "Enter the size of the array and the number of operations: ";
    cin >> n >> m;
    vector<vector<int>> queries(m, vector<int>(3));
    for (int i = 0; i < m; ++i) {
        cout << "Enter the operation (a b k) for operation " << (i + 1) << ": ";
        cin >> queries[i][0] >> queries[i][1] >> queries[i][2];
    }

    cout << "The maximum value in the resultant array is: " << arrayManipulation(n, queries) << endl;
    return 0;
}
