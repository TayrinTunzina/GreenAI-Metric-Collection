#include <iostream>
#include <map>
#include <queue>
#include <vector>
using namespace std;

struct Node {
    int val;
    Node *left, *right;
    Node(int v) : val(v), left(NULL), right(NULL) {}
};

Node* build_tree(int n, vector<int>& values, int e, vector<tuple<int, int, char>>& edges) {
    if (n == 0) return NULL;
    map<int, Node*> nodes;
    for (int val : values)
        nodes[val] = new Node(val);
    for (auto [p, c, lr] : edges) {
        if (nodes.find(p) == nodes.end() || nodes.find(c) == nodes.end()) continue;
        if (lr == 'L') nodes[p]->left = nodes[c];
        else if (lr == 'R') nodes[p]->right = nodes[c];
    }
    return nodes[values[0]];
}

void top_view(Node* root) {
    if (!root) return;
    map<int, int> hd_map;
    queue<pair<Node*, int>> q;
    q.push({root, 0});
    while (!q.empty()) {
        auto [node, hd] = q.front(); q.pop();
        if (hd_map.find(hd) == hd_map.end())
            hd_map[hd] = node->val;
        if (node->left) q.push({node->left, hd - 1});
        if (node->right) q.push({node->right, hd + 1});
    }
    for (auto [hd, val] : hd_map)
        cout << val << " ";
    cout << endl;
}

int main() {
    int n, e;
    cout << "Enter number of nodes: ";
    cin >> n;
    if (n == 0) {
        cout << "No nodes in the tree.\n";
        return 0;
    }
    vector<int> values(n);
    cout << "Enter node values: ";
    for (int i = 0; i < n; ++i) cin >> values[i];
    cout << "Enter number of edges: ";
    cin >> e;
    vector<tuple<int, int, char>> edges;
    cout << "Enter edges (parent child L/R):\n";
    for (int i = 0; i < e; ++i) {
        int p, c; char lr;
        cin >> p >> c >> lr;
        if (lr == 'L' || lr == 'R')
            edges.push_back({p, c, lr});
    }
    Node* root = build_tree(n, values, e, edges);
    cout << "Top view of the tree:\n";
    top_view(root);
    return 0;
}
