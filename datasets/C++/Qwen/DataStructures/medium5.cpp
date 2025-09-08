#include <iostream>
#include <climits>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    
    Node(int val) {
        data = val;
        left = nullptr;
        right = nullptr;
    }
};

bool isBSTUtil(Node* node, long long min_val, long long max_val) {
    // An empty tree is BST
    if (node == nullptr) {
        return true;
    }
    
    // False if this node violates the min/max constraint
    if (node->data < min_val || node->data > max_val) {
        return false;
    }
    
    // Otherwise check the subtrees recursively
    // tightening the min or max constraint
    return (isBSTUtil(node->left, min_val, (long long)node->data - 1) &&
            isBSTUtil(node->right, (long long)node->data + 1, max_val));
}

bool isBST(Node* root) {
    return isBSTUtil(root, LLONG_MIN, LLONG_MAX);
}

Node* insertNode() {
    cout << "Enter node value (or -1 to skip): ";
    int val;
    cin >> val;
    
    if (val == -1) {
        return nullptr;
    }
    
    Node* node = new Node(val);
    cout << "Enter left child of " << val << ":" << endl;
    node->left = insertNode();
    cout << "Enter right child of " << val << ":" << endl;
    node->right = insertNode();
    
    return node;
}

int main() {
    cout << "Enter the binary tree:" << endl;
    cout << "Enter -1 for null nodes" << endl;
    Node* root = insertNode();
    
    if (isBST(root)) {
        cout << "Yes" << endl;
    } else {
        cout << "No" << endl;
    }
    
    return 0;
}