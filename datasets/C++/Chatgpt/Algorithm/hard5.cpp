#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int MOD = 1e9 + 7;

// Compute XOR of a vector
int computeXOR(const vector<int>& arr) {
    int res = 0;
    for (int val : arr)
        res ^= val;
    return res;
}

int countNimGames(int n, int m) {
    int limit = (1 << m);  // 2^m
    vector<int> nums;

    // Only values from 1 to 2^m - 1
    for (int i = 1; i < limit; ++i)
        nums.push_back(i);

    int total = 0;
    vector<int> temp;

    // Generate all combinations of n values
    int size = nums.size();
    vector<bool> select(size, false);
    fill(select.end() - n, select.end(), true);

    do {
        temp.clear();
        for (int i = 0; i < size; ++i)
            if (select[i]) temp.push_back(nums[i]);

        // Generate all permutations of this combination
        sort(temp.begin(), temp.end());
        do {
            if (computeXOR(temp) != 0)
                total++;
        } while (next_permutation(temp.begin(), temp.end()));

    } while (next_permutation(select.begin(), select.end()));

    return total % MOD;
}

int main() {
    int n, m;
    cin >> n >> m;
    cout << countNimGames(n, m) << endl;
    return 0;
}
