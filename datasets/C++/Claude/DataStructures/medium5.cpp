#include <iostream>
#include <vector>
#include <queue>
#include <climits>
#include <sstream>
using namespace std;

struct TreeNode {
    int data;
    TreeNode* left;
    TreeNode* right;
    
    TreeNode(int val) : data(val), left(nullptr), right(nullptr) {}
};

bool validate(TreeNode* node, long minVal, long maxVal) {
    if (!node) return true;
    
    if (node->data <= minVal || node->data >= maxVal) {
        return false;
    }
    
    return validate(node->left, minVal, node->data) && 
           validate(node->right, node->data, maxVal);
}

bool checkBST(TreeNode* root) {
    return validate(root, LONG_MIN, LONG_MAX);
}

TreeNode* buildTree() {
    cout << "Enter the tree nodes level by level (use -1 for null nodes):" << endl;
    cout << "Example: 3 5 2 1 4 6 -1 -1 -1 -1 -1 -1 -1" << endl;
    
    vector<int> values;
    string line;
    getline(cin, line);
    
    stringstream ss(line);
    int val;
    while (ss >> val) {
        values.push_back(val);
    }
    
    if (values.empty() || values[0] == -1) {
        return nullptr;
    }
    
    TreeNode* root = new TreeNode(values[0]);
    queue<TreeNode*> q;
    q.push(root);
    
    int i = 1;
    while (!q.empty() && i < values.size()) {
        TreeNode* node = q.front();
        q.pop();
        
        // Left child
        if (i < values.size() && values[i] != -1) {
            node->left = new TreeNode(values[i]);
            q.push(node->left);
        }
        i++;
        
        // Right child
        if (i < values.size() && values[i] != -1) {
            node->right = new TreeNode(values[i]);
            q.push(node->right);
        }
        i++;
    }
    
    return root;
}

void printTree(TreeNode* root, int level = 0, string prefix = "Root: ") {
    if (root != nullptr) {
        cout << string(level * 4, ' ') << prefix << root->data << endl;
        if (root->left != nullptr || root->right != nullptr) {
            printTree(root->left, level + 1, "L--- ");
            printTree(root->right, level + 1, "R--- ");
        }
    }
}

int main() {
    TreeNode* root = buildTree();
    
    if (root) {
        cout << "\nBuilt tree:" << endl;
        printTree(root);
        
        bool result = checkBST(root);
        cout << "\nIs BST: " << (result ? "Yes" : "No") << endl;
    } else {
        cout << "Empty tree - considered valid BST: Yes" << endl;
    }
    
    return 0;
}