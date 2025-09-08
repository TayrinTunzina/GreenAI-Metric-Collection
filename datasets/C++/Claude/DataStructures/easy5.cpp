#include <iostream>
#include <vector>
#include <map>
#include <unordered_map>
#include <unordered_set>
#include <queue>
#include <string>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

TreeNode* buildTree(vector<int>& nodes, vector<tuple<int, int, char>>& edges) {
    if (nodes.empty()) return nullptr;
    
    // Create node objects
    unordered_map<int, TreeNode*> nodeMap;
    for (int val : nodes) {
        nodeMap[val] = new TreeNode(val);
    }
    
    // Find root (node that doesn't appear as a child)
    unordered_set<int> children;
    unordered_set<int> parents;
    
    for (auto& edge : edges) {
        int parent = get<0>(edge);
        int child = get<1>(edge);
        char direction = get<2>(edge);
        
        parents.insert(parent);
        children.insert(child);
        
        if (direction == 'L') {
            nodeMap[parent]->left = nodeMap[child];
        } else { // direction == 'R'
            nodeMap[parent]->right = nodeMap[child];
        }
    }
    
    // Root is in parents but not in children
    int rootVal = -1;
    for (int parent : parents) {
        if (children.find(parent) == children.end()) {
            rootVal = parent;
            break;
        }
    }
    
    // If no edges, first node is root
    if (rootVal == -1 && !nodes.empty()) {
        rootVal = nodes[0];
    }
    
    return nodeMap[rootVal];
}

vector<int> topView(TreeNode* root) {
    vector<int> result;
    if (!root) return result;
    
    // Map to store the first node at each horizontal distance
    map<int, int> topViewMap;
    
    // Queue for level order traversal: (node, horizontal_distance)
    queue<pair<TreeNode*, int>> q;
    q.push({root, 0});
    
    while (!q.empty()) {
        auto [node, hd] = q.front();
        q.pop();
        
        // If this horizontal distance is seen for the first time,
        // this node is part of top view
        if (topViewMap.find(hd) == topViewMap.end()) {
            topViewMap[hd] = node->val;
        }
        
        // Add left child with hd-1
        if (node->left) {
            q.push({node->left, hd - 1});
        }
        
        // Add right child with hd+1
        if (node->right) {
            q.push({node->right, hd + 1});
        }
    }
    
    // Extract values in order of horizontal distance
    for (auto& p : topViewMap) {
        result.push_back(p.second);
    }
    
    return result;
}

int main() {
    // Read number of nodes
    int n;
    cin >> n;
    
    if (n == 0) {
        cout << endl;
        return 0;
    }
    
    // Read node values
    vector<int> nodes(n);
    for (int i = 0; i < n; i++) {
        cin >> nodes[i];
    }
    
    // Read number of edges
    int e;
    cin >> e;
    
    // Read edges
    vector<tuple<int, int, char>> edges;
    for (int i = 0; i < e; i++) {
        int parent, child;
        char direction;
        cin >> parent >> child >> direction;
        edges.push_back(make_tuple(parent, child, direction));
    }
    
    // Build tree
    TreeNode* root = buildTree(nodes, edges);
    
    // Get top view
    vector<int> result = topView(root);
    
    // Print result
    for (int i = 0; i < result.size(); i++) {
        if (i > 0) cout << " ";
        cout << result[i];
    }
    cout << endl;
    
    return 0;
}