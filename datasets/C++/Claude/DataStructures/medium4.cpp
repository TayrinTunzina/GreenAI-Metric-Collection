#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <sstream>
using namespace std;

class TrieNode {
public:
    unordered_map<char, TrieNode*> children;
    int count;
    
    TrieNode() : count(0) {}
};

class Trie {
private:
    TrieNode* root;
    
public:
    Trie() {
        root = new TrieNode();
    }
    
    void add(const string& word) {
        TrieNode* node = root;
        for (char c : word) {
            if (node->children.find(c) == node->children.end()) {
                node->children[c] = new TrieNode();
            }
            node = node->children[c];
            node->count++;
        }
    }
    
    int find(const string& prefix) {
        TrieNode* node = root;
        for (char c : prefix) {
            if (node->children.find(c) == node->children.end()) {
                return 0;
            }
            node = node->children[c];
        }
        return node->count;
    }
};

vector<int> contacts(vector<string>& queries) {
    Trie trie;
    vector<int> results;
    
    for (const string& query : queries) {
        stringstream ss(query);
        string operation, name;
        ss >> operation;
        
        if (operation == "add") {
            ss >> name;
            trie.add(name);
        } else if (operation == "find") {
            ss >> name;
            int count = trie.find(name);
            results.push_back(count);
        }
    }
    
    return results;
}

int main() {
    int n;
    cout << "Enter the number of operations: ";
    cin >> n;
    cin.ignore(); // Clear newline from buffer
    
    vector<string> queries(n);
    cout << "Enter " << n << " operations:" << endl;
    cout << "Format: 'add name' or 'find partial'" << endl;
    
    for (int i = 0; i < n; i++) {
        getline(cin, queries[i]);
    }
    
    vector<int> results = contacts(queries);
    
    cout << "\nResults for find operations:" << endl;
    for (int result : results) {
        cout << result << endl;
    }
    
    return 0;
}