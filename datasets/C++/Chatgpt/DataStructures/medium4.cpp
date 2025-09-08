#include <iostream>
#include <unordered_map>
#include <vector>
#include <string>
using namespace std;

struct TrieNode {
    unordered_map<char, TrieNode*> children;
    int count = 0;
};

class Contacts {
    TrieNode* root;

public:
    Contacts() {
        root = new TrieNode();
    }

    void add(const string& name) {
        TrieNode* node = root;
        for (char c : name) {
            if (node->children.count(c) == 0)
                node->children[c] = new TrieNode();
            node = node->children[c];
            node->count++;
        }
    }

    int find(const string& partial) {
        TrieNode* node = root;
        for (char c : partial) {
            if (node->children.count(c) == 0)
                return 0;
            node = node->children[c];
        }
        return node->count;
    }
};

int main() {
    int n;
    cin >> n;
    cin.ignore();
    Contacts contacts;
    vector<int> result;

    for (int i = 0; i < n; ++i) {
        string op, arg;
        cin >> op >> arg;
        if (op == "add") {
            contacts.add(arg);
        } else if (op == "find") {
            result.push_back(contacts.find(arg));
        }
    }

    for (int val : result) {
        cout << val << endl;
    }

    return 0;
}
