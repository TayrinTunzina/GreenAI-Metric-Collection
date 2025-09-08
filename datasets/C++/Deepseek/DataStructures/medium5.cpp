#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <sstream>
#include <climits>

using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int val) : data(val), left(nullptr), right(nullptr) {}
};

Node* buildTree(const vector<int>& arr) {
    if (arr.empty() || arr[0] == -1) return nullptr;
    Node* root = new Node(arr[0]);
    queue<Node*> q;
    q.push(root);
    int index = 1;
    while (!q.empty() && index < arr.size()) {
        Node* current = q.front();
        q.pop();
        if (index < arr.size() && arr[index] != -1) {
            current->left = new Node(arr[index]);
            q.push(current->left);
        }
        index++;
        if (index < arr.size() && arr[index] != -1) {
            current->right = new Node(arr[index]);
            q.push(current->right);
        }
        index++;
    }
    return root;
}

bool isBST(Node* root) {
    stack<Node*> s;
    Node* current = root;
    Node* prev = nullptr;
    while (current || !s.empty()) {
        while (current) {
            s.push(current);
            current = current->left;
        }
        current = s.top();
        s.pop();
        if (prev && current->data <= prev->data) {
            return false;
        }
        prev = current;
        current = current->right;
    }
    return true;
}

int main() {
    cout << "Enter the tree in level-order (use -1 for null nodes):\n";
    
    string input;
    getline(cin, input);
    stringstream ss(input);
    vector<int> arr;
    int val;
    while (ss >> val) {
        arr.push_back(val);
    }
    
    Node* root = buildTree(arr);
    cout << (isBST(root) ? "Yes" : "No") << endl;
    
    return 0;
}