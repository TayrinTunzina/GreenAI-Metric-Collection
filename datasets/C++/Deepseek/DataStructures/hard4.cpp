#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

struct BitNode {
    unordered_map<int, BitNode*> children;
};

int max_xor_two_numbers(vector<int>& arr) {
    int max_xor = 0;
    BitNode* root = new BitNode();
    
    for (int num : arr) {
        BitNode* node = root;
        BitNode* xor_node = root;
        int current_xor = 0;
        
        for (int i = 31; i >= 0; --i) {
            int bit = (num >> i) & 1;
            // Insert the number into the trie
            if (node->children.find(bit) == node->children.end()) {
                node->children[bit] = new BitNode();
            }
            node = node->children[bit];
            
            // Compute current_xor by choosing the opposite bit if available
            int toggled_bit = 1 - bit;
            if (xor_node->children.find(toggled_bit) != xor_node->children.end()) {
                current_xor += (1 << i);
                xor_node = xor_node->children[toggled_bit];
            } else {
                xor_node = xor_node->children[bit];
            }
        }
        
        if (current_xor > max_xor) {
            max_xor = current_xor;
        }
    }
    
    return max_xor;
}

int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;
    
    vector<int> arr(n);
    cout << "Enter the elements separated by space: ";
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }
    
    cout << "Maximum XOR: " << max_xor_two_numbers(arr) << endl;
    
    return 0;
}