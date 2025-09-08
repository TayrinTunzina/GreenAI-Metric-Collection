#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <algorithm>
using namespace std;

void printTopView() {
    int n;
    cin >> n;
    if (n == 0) {
        cout << endl;
        return;
    }

    vector<int> nodes(n);
    map<int, int> nodeToIndex;
    for (int i = 0; i < n; ++i) {
        cin >> nodes[i];
        nodeToIndex[nodes[i]] = i;
    }
    int rootVal = nodes[0];

    map<int, vector<pair<int, char>>> adj;
    int e;
    cin >> e;
    while (e--) {
        int parent, child;
        char lr;
        cin >> parent >> child >> lr;
        adj[parent].push_back({child, lr});
    }

    map<int, int> hdMap;  // HD -> node value
    queue<pair<int, int>> q;  // {node, HD}
    q.push({rootVal, 0});

    while (!q.empty()) {
        auto [node, hd] = q.front();
        q.pop();

        if (hdMap.find(hd) == hdMap.end()) {
            hdMap[hd] = node;
        }

        for (auto [child, lr] : adj[node]) {
            if (lr == 'L') {
                q.push({child, hd - 1});
            } else {
                q.push({child, hd + 1});
            }
        }
    }

    for (auto [hd, val] : hdMap) {
        cout << val << " ";
    }
    cout << endl;
}

int main() {
    printTopView();
    return 0;
}
