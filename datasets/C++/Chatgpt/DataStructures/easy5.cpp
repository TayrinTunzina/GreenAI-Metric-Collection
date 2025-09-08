#include <iostream>
#include <map>
#include <queue>
#include <unordered_map>
#include <unordered_set>
using namespace std;

struct Node {
    int data;
    Node *left, *right;
    Node(int d) : data(d), left(NULL), right(NULL) {}
};

void topView(Node* root) {
    if (!root) return;
    map<int, int> hd_map;
    queue<pair<Node*, int>> q;
    q.push({root, 0});
    while (!q.empty()) {
        auto [node, hd] = q.front(); q.pop();
        if (!hd_map.count(hd))
            hd_map[hd] = node->data;
        if (node->left) q.push({node->left, hd - 1});
        if (node->right) q.push({node->right, hd + 1});
    }
    for (auto &p : hd_map) cout << p.second << " ";
    cout << endl;
}

int main() {
    int n;
    cout << "Enter number of nodes:\n";
    cin >> n;
    if (n == 0) return 0;

    unordered_map<int, Node*> nodes;
    cout << "Enter node values (unique IDs):\n";
    for (int i = 0; i < n; i++) {
        int val; cin >> val;
        nodes[val] = new Node(val);
    }

    int e;
    cout << "Enter number of edges:\n";
    cin >> e;
    if (e > n - 1) {
        cout << "Error: too many edges\n";
        return 0;
    }

    unordered_set<int> children;
    cout << "Enter edges in format: parent child L/R\n";
    for (int i = 0; i < e; i++) {
        int p, c; char dir;
        cin >> p >> c >> dir;
        if (!nodes.count(p) || !nodes.count(c)) {
            cout << "Error: invalid node ID\n";
            return 0;
        }
        children.insert(c);
        if (dir == 'L') nodes[p]->left = nodes[c];
        else if (dir == 'R') nodes[p]->right = nodes[c];
        else {
            cout << "Error: direction must be L or R\n";
            return 0;
        }
    }

    // Find root (node that is never a child)
    int rootVal = -1;
    for (auto &kv : nodes) {
        if (children.find(kv.first) == children.end()) {
            rootVal = kv.first;
            break;
        }
    }
    if (rootVal == -1) {
        cout << "Error: no root found\n";
        return 0;
    }

    topView(nodes[rootVal]);
}
