#include <iostream>
#include <vector>
using namespace std;

int computeGrundy(int m, int k) {
    return m - (m / k);
}

void determineWinner(const vector<pair<int, vector<pair<int, int>>>>& games) {
    for (const auto& game : games) {
        int n = game.first;
        const auto& trees = game.second;
        int xorSum = 0;
        for (const auto& tree : trees) {
            int m = tree.first;
            int k = tree.second;
            int grundy = computeGrundy(m, k);
            xorSum ^= grundy;
        }
        if (xorSum != 0) {
            cout << "BOB" << endl;
        } else {
            cout << "BEN" << endl;
        }
    }
}

int main() {
    int g;
    cout << "Enter the number of games: ";
    cin >> g;
    vector<pair<int, vector<pair<int, int>>>> games;
    for (int i = 0; i < g; ++i) {
        int n;
        cout << "Enter the number of trees in the forest: ";
        cin >> n;
        vector<pair<int, int>> trees;
        for (int j = 0; j < n; ++j) {
            int m, k;
            cout << "Enter m and k for the tree: ";
            cin >> m >> k;
            trees.emplace_back(m, k);
        }
        games.emplace_back(n, trees);
    }
    determineWinner(games);
    return 0;
}
