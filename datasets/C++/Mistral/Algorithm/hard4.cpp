#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<int> reverseFactorization(int N, vector<int> A) {
    sort(A.begin(), A.end());
    queue<pair<int, vector<int>>> q;
    q.push({1, {}});

    while (!q.empty()) {
        auto current = q.front();
        q.pop();
        int currentValue = current.first;
        vector<int> sequence = current.second;

        if (currentValue == N) {
            return sequence;
        }

        for (int a : A) {
            long long nextValue = static_cast<long long>(currentValue) * a;
            if (nextValue <= N) {
                vector<int> newSequence = sequence;
                newSequence.push_back(nextValue);
                q.push({static_cast<int>(nextValue), newSequence});
            }
        }
    }

    return {-1};
}

int main() {
    int N, K;
    cout << "Enter N and K: ";
    cin >> N >> K;

    vector<int> A(K);
    cout << "Enter the elements of A: ";
    for (int i = 0; i < K; ++i) {
        cin >> A[i];
    }

    vector<int> result = reverseFactorization(N, A);
    if (result.size() == 1 && result[0] == -1) {
        cout << -1 << endl;
    } else {
        cout << "1 ";
        for (int num : result) {
            cout << num << " ";
        }
        cout << endl;
    }

    return 0;
}
