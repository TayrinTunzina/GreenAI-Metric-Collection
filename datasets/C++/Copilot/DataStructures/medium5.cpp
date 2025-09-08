#include <iostream>
#include <limits>
#include <climits>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int val) : data(val), left(NULL), right(NULL) {}
};

Node* insertManual(const string& prompt) {
    cout << prompt;
    string input;
    getline(cin, input);
    if (input.empty()) return NULL;
    int val = stoi(input);
    Node* node = new Node(val);
    node->left = insertManual("Left of " + to_string(val) + ": ");
    node->right = insertManual("Right of " + to_string(val) + ": ");
    return node;
}

bool isBST(Node* node, int minVal, int maxVal) {
    if (!node) return true;
    if (node->data <= minVal || node->data >= maxVal) return false;
    return isBST(node->left, minVal, node->data) && isBST(node->right, node->data, maxVal);
}

int main() {
    cout << "Press Enter for null value.\n";
    Node* root = insertManual("Root: ");
    cout << (isBST(root, INT_MIN, INT_MAX) ? "Yes" : "No") << endl;
    return 0;
}
