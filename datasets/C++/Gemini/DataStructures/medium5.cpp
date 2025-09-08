#include <iostream>
#include <queue>
#include <string>
#include <limits>       // Required for numeric_limits
#include <sstream>      // <--- ADD THIS LINE

// Define a Node structure for the binary tree
struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int d) : data(d), left(nullptr), right(nullptr) {}
};

// Helper function for BST validation
bool isBSTHelper(Node* node, long long min_val, long long max_val) {
    // An empty tree is a valid BST
    if (node == nullptr) {
        return true;
    }

    // Check if the current node's data is within the valid range
    // Using long long for min_val/max_val to handle edge cases with INT_MIN/INT_MAX data
    if (node->data <= min_val || node->data >= max_val) {
        return false;
    }

    // Recursively check left subtree: update max_val to current node's data
    // Recursively check right subtree: update min_val to current node's data
    return isBSTHelper(node->left, min_val, node->data) &&
           isBSTHelper(node->right, node->data, max_val);
}

// Main function to check if a binary tree is a BST
bool isBinarySearchTree(Node* root) {
    // Initialize with numeric_limits for the root's range
    return isBSTHelper(root, std::numeric_limits<long long>::min(), std::numeric_limits<long long>::max());
}

// Function to build a tree from level-order input
Node* buildTreeFromInput() {
    std::cout << "Enter tree nodes in level order (BFS), separated by spaces." << std::endl;
    std::cout << "Use 'null' for missing children (e.g., 3 5 2 1 4 6 null):" << std::endl;
    std::string line;
    std::getline(std::cin, line);

    // This is the line that caused the error, now fixed by adding <sstream>
    std::stringstream ss(line);
    std::string token;

    ss >> token;
    if (token == "null") {
        return nullptr;
    }

    Node* root = new Node(std::stoi(token));
    std::queue<Node*> q;
    q.push(root);

    while (!q.empty() && ss >> token) {
        Node* current_node = q.front();
        q.pop();

        // Left child
        if (token != "null") {
            current_node->left = new Node(std::stoi(token));
            q.push(current_node->left);
        }

        // Right child
        if (ss >> token) { // Try to read next token for right child
            if (token != "null") {
                current_node->right = new Node(std::stoi(token));
                q.push(current_node->right);
            }
        }
    }
    return root;
}

// Function to deallocate tree memory (good practice)
void deleteTree(Node* node) {
    if (node == nullptr) {
        return;
    }
    deleteTree(node->left);
    deleteTree(node->right);
    delete node;
}


int main() {
    Node* root = buildTreeFromInput();

    if (isBinarySearchTree(root)) {
        std::cout << "Yes" << std::endl;
    } else {
        std::cout << "No" << std::endl;
    }

    deleteTree(root); // Clean up memory
    return 0;
}