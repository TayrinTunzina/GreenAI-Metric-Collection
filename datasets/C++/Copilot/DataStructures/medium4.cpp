#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

struct TrieNode {
    int count = 0;
    unordered_map<char, TrieNode*> children;
};

class Contacts {
    TrieNode* root;
public:
    Contacts() { root = new TrieNode(); }

    void add(const string& name) {
        TrieNode* node = root;
        for (char c : name) {
            if (!node->children.count(c))
                node->children[c] = new TrieNode();
            node = node->children[c];
            node->count++;
        }
    }

    int find(const string& partial) {
        TrieNode* node = root;
        for (char c : partial) {
            if (!node->children.count(c)) return 0;
            node = node->children[c];
        }
        return node->count;
    }
};

int main() {
    int n;
    cout << "Enter number of operations: ";
    cin >> n;
    cin.ignore();
    Contacts contacts;
    vector<int> results;

    for (int i = 0; i < n; ++i) {
        string op, arg;
        getline(cin, op);
        size_t space = op.find(' ');
        string cmd = op.substr(0, space);
        string val = op.substr(space + 1);
        if (cmd == "add") contacts.add(val);
        else if (cmd == "find") results.push_back(contacts.find(val));
    }

    cout << "Results:\n";
    for (int r : results) cout << r << "\n";
    return 0;
}
