#include <iostream>
#include <unordered_map>
#include <vector>  //  Include vector for using std::vector
using namespace std;

struct TrieNode {
    unordered_map<char, TrieNode*> children;
    bool is_end;
    TrieNode() : is_end(false) {}
};

class Trie {
public:
    TrieNode* root;
    Trie() { root = new TrieNode(); }

    bool insert(string word) {
        TrieNode* node = root;
        for (char ch : word) {
            if (!node->children.count(ch)) 
                node->children[ch] = new TrieNode();
            node = node->children[ch];
            if (node->is_end) return false;  // Prefix exists
        }
        if (!node->children.empty()) return false;  // Current word is a prefix
        node->is_end = true;
        return true;
    }
};

void noPrefix(vector<string>& words) {
    Trie trie;
    for (const string& word : words) {
        if (!trie.insert(word)) {
            cout << "BAD SET\n" << word << endl;
            return;
        }
    }
    cout << "GOOD SET" << endl;
}

int main() {
    int n;
    cin >> n;
    vector<string> words(n);  //  Define vector correctly
    for (int i = 0; i < n; i++) 
        cin >> words[i];
    
    noPrefix(words);
    return 0;
}
