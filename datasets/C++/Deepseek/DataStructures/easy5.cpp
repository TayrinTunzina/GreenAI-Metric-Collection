#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <algorithm>
using namespace std;

struct Node {
    int value;
    Node* left;
    Node* right;
    Node(int val) : value(val), left(nullptr), right(nullptr) {}
};

void printTopView(Node* root) {
    if (root == nullptr) return;
    
    map<int, int> topView; // key: horizontal distance, value: node value
    queue<pair<Node*, int>> q; // pair of node and its horizontal distance
    q.push({root, 0});
    
    while (!q.empty()) {
        auto current = q.front();
        q.pop();
        Node* node = current.first;
        int hd = current.second;
        
        if (topView.find(hd) == topView.end()) {
            topView[hd] = node->value;
        }
        
        if (node->left != nullptr) {
            q.push({node->left, hd - 1});
        }
        if (node->right != nullptr) {
            q.push({node->right, hd + 1});
        }
    }
    
    for (auto const& entry : topView) {
        cout << entry.second << " ";
    }
    cout << endl;
}

int main() {
    int n;
    cin >> n;
    if (n == 0) return 0;
    
    vector<int> values(n);
    for (int i = 0; i < n; ++i) {
        cin >> values[i];
    }
    
    int e;
    cin >> e;
    
    map<int, Node*> nodes;
    for (int val : values) {
        nodes[val] = new Node(val);
    }
    
    Node* root = nodes[values[0]];
    
    for (int i = 0; i < e; ++i) {
        int parentVal, childVal;
        char direction;
        cin >> parentVal >> childVal >> direction;
        Node* parent = nodes[parentVal];
        Node* child = nodes[childVal];
        if (direction == 'L') {
            parent->left = child;
        } else {
            parent->right = child;
        }
    }
    
    printTopView(root);
    
    // Clean up memory
    for (auto entry : nodes) {
        delete entry.second;
    }
    
    return 0;
}