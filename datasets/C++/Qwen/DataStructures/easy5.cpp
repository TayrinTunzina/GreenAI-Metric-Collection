#include <iostream>
#include <vector>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <cctype>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

int main() {
    int n;
    string line;

    // Read n
    if (!getline(cin, line) || line.empty()) {
        cout << endl;
        return 0;
    }
    n = stoi(line);

    if (n == 0) {
        cout << endl;
        return 0;
    }

    // Read node values
    getline(cin, line);
    stringstream ss(line);
    vector<int> values;
    int val;
    while (ss >> val) {
        values.push_back(val);
    }

    // Create node map
    map<int, TreeNode*> nodeMap;
    for (int v : values) {
        nodeMap[v] = new TreeNode(v);
    }

    // Read number of edges
    int e = 0;
    getline(cin, line);
    if (!line.empty()) {
        e = stoi(line);
    }

    set<int> children;

    // Read e edges
    for (int i = 0; i < e; ++i) {
        getline(cin, line);
        if (line.empty()) continue;

        stringstream ss_edge(line);
        string part;
        vector<string> parts;
        while (ss_edge >> part) {
            parts.push_back(part);
        }

        if (parts.size() != 3) continue;

        try {
            int parent_val = stoi(parts[0]);
            int child_val = stoi(parts[1]);
            string& dir = parts[2];

            if (nodeMap.find(parent_val) == nodeMap.end() || 
                nodeMap.find(child_val) == nodeMap.end()) {
                continue;
            }

            TreeNode* parent = nodeMap[parent_val];
            TreeNode* child = nodeMap[child_val];

            if (dir == "L") {
                parent->left = child;
            } else if (dir == "R") {
                parent->right = child;
            }

            children.insert(child_val);
        } catch (...) {
            continue;
        }
    }

    // Find root (not a child)
    TreeNode* root = nullptr;
    for (int v : values) {
        if (children.find(v) == children.end()) {
            root = nodeMap[v];
            break;
        }
    }

    // Fallback: use first node as root
    if (!root) {
        root = nodeMap[values[0]];
    }

    // BFS for top view
    map<int, int> hdMap; // hd -> node value
    queue<pair<TreeNode*, int>> q;
    q.push({root, 0});

    while (!q.empty()) {
        auto node = q.front().first;
        int hd = q.front().second;
        q.pop();

        // Only set if this hd hasn't been seen
        if (hdMap.find(hd) == hdMap.end()) {
            hdMap[hd] = node->val;
        }

        if (node->left) {
            q.push({node->left, hd - 1});
        }
        if (node->right) {
            q.push({node->right, hd + 1});
        }
    }

    // Output left to right
    bool first = true;
    for (auto& kv : hdMap) {
        if (!first) cout << " ";
        cout << kv.second;
        first = false;
    }
    cout << endl;

    // Optional: free memory (not required in competitive programming)
    for (auto& pair : nodeMap) {
        delete pair.second;
    }

    return 0;
}