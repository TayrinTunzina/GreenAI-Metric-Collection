#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int val): data(val), left(nullptr), right(nullptr) {}
};

bool isBST(Node* node, int minVal, int maxVal) {
    if (!node) return true;
    if (node->data <= minVal || node->data >= maxVal)
        return false;
    return isBST(node->left, minVal, node->data) &&
           isBST(node->right, node->data, maxVal);
}

Node* buildTree(const vector<int>& arr) {
    if (arr.empty() || arr[0] == -1) return nullptr;
    Node* root = new Node(arr[0]);
    queue<Node*> q;
    q.push(root);
    int i = 1;

    while (!q.empty() && i < arr.size()) {
        Node* curr = q.front(); q.pop();

        if (i < arr.size() && arr[i] != -1) {
            curr->left = new Node(arr[i]);
            q.push(curr->left);
        }
        i++;
        if (i < arr.size() && arr[i] != -1) {
            curr->right = new Node(arr[i]);
            q.push(curr->right);
        }
        i++;
    }
    return root;
}

int main() {
    cout << "Enter nodes in level order (-1 for null): ";
    vector<int> arr;
    int val;
    while (cin.peek() != '\n' && cin >> val) {
        arr.push_back(val);
    }
    Node* root = buildTree(arr);
    cout << (isBST(root, INT_MIN, INT_MAX) ? "Yes" : "No") << endl;
    return 0;
}
