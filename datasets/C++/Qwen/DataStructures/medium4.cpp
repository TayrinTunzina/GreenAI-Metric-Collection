#include <iostream>
#include <vector>
#include <string>
#include <map>
using namespace std;

struct TrieNode {
    map<char, TrieNode*> children;
    int count = 0;
};

vector<int> contacts(vector<string> queries) {
    TrieNode* root = new TrieNode();
    vector<int> result;

    for (string& query : queries) {
        string op, s;
        int pos = query.find(' ');
        op = query.substr(0, pos);
        s = query.substr(pos + 1);

        TrieNode* node = root;

        if (op == "add") {
            for (char c : s) {
                if (node->children.find(c) == node->children.end()) {
                    node->children[c] = new TrieNode();
                }
                node = node->children[c];
                node->count++;
            }
        } else if (op == "find") {
            bool found = true;
            for (char c : s) {
                if (node->children.find(c) == node->children.end()) {
                    found = false;
                    break;
                }
                node = node->children[c];
            }
            result.push_back(found ? node->count : 0);
        }
    }

    // Cleanup: free memory (optional for competition)
    // Omit for simplicity in contests

    return result;
}

int main() {
    int n;
    cin >> n;
    cin.ignore();

    vector<string> queries;
    for (int i = 0; i < n; i++) {
        string line;
        getline(cin, line);
        queries.push_back(line);
    }

    vector<int> results = contacts(queries);
    for (int res : results) {
        cout << res << endl;
    }

    return 0;
}