#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>

using namespace std;

class TrieNode {
public:
    unordered_map<char, TrieNode*> children;
    int count = 0;
};

class Contacts {
private:
    TrieNode* root;

public:
    Contacts() {
        root = new TrieNode();
    }

    void add(const string& name) {
        TrieNode* node = root;
        for (char c : name) {
            if (node->children.find(c) == node->children.end()) {
                node->children[c] = new TrieNode();
            }
            node = node->children[c];
            node->count++;
        }
    }

    int find(const string& partial) {
        TrieNode* node = root;
        for (char c : partial) {
            if (node->children.find(c) == node->children.end()) {
                return 0;
            }
            node = node->children[c];
        }
        return node->count;
    }
};

vector<int> contacts(const vector<string>& queries) {
    Contacts contactList;
    vector<int> results;
    for (const string& query : queries) {
        size_t space_pos = query.find(' ');
        string cmd = query.substr(0, space_pos);
        string arg = query.substr(space_pos + 1);
        if (cmd == "add") {
            contactList.add(arg);
        } else if (cmd == "find") {
            results.push_back(contactList.find(arg));
        }
    }
    return results;
}

int main() {
    int n;
    cin >> n;
    cin.ignore();
    vector<string> queries(n);
    for (int i = 0; i < n; ++i) {
        getline(cin, queries[i]);
    }
    vector<int> output = contacts(queries);
    for (int result : output) {
        cout << result << endl;
    }
    return 0;
}