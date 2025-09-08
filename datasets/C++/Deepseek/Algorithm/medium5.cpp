#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<string> determine_winner(const vector<pair<int, vector<pair<int, int>>>>& games) {
    vector<string> results;
    for (const auto& game : games) {
        int n = game.first;
        const auto& trees = game.second;
        int total_xor = 0;
        for (const auto& tree : trees) {
            int m = tree.first;
            int k = tree.second;
            if (m == 1) {
                total_xor ^= 1;
            } else {
                if ((m - 1) % (k + 1) == 0) {
                    // grundy number is 0, do nothing
                } else {
                    total_xor ^= 1;
                }
            }
        }
        if (total_xor != 0) {
            results.push_back("BOB");
        } else {
            results.push_back("BEN");
        }
    }
    return results;
}

int main() {
    int g;
    cin >> g;
    vector<pair<int, vector<pair<int, int>>>> games;
    for (int i = 0; i < g; ++i) {
        int n;
        cin >> n;
        vector<pair<int, int>> trees;
        for (int j = 0; j < n; ++j) {
            int m, k;
            cin >> m >> k;
            trees.emplace_back(m, k);
        }
        games.emplace_back(n, trees);
    }
    vector<string> results = determine_winner(games);
    for (const auto& result : results) {
        cout << result << endl;
    }
    return 0;
}