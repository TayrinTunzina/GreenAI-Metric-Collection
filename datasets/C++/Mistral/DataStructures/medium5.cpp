#include <iostream>
#include <vector>
#include <sstream>
#include <climits>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int val) : data(val), left(nullptr), right(nullptr) {}
};

bool isBST(Node* node, int min_val = INT_MIN, int max_val = INT_MAX) {
    if (node == nullptr) {
        return true;
    }
    if (node->data <= min_val || node->data >= max_val) {
        return false;
    }
    return isBST(node->left, min_val, node->data) && isBST(node->right, node->data, max_val);
}

Node* insertLevelOrder(const vector<int>& arr, int i) {
    if (i < arr.size() && arr[i] != -1) {
        Node* root = new Node(arr[i]);
        root->left = insertLevelOrder(arr, 2 * i + 1);
        root->right = insertLevelOrder(arr, 2 * i + 2);
        return root;
    }
    return nullptr;
}

int main() {
    cout << "Enter the tree nodes in level order (use -1 for None), separated by spaces: ";
    string input;
    getline(cin, input);
    istringstream iss(input);
    vector<int> arr;
    int value;
    while (iss >> value) {
        arr.push_back(value);
    }
    Node* root = insertLevelOrder(arr, 0);
    cout << (isBST(root) ? "Yes" : "No") << endl;
    return 0;
}
