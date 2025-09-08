#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

class TrieNode {
public:
    unordered_map<char, TrieNode*> children;
    bool is_end_of_word;

    TrieNode() : is_end_of_word(false) {}
};

class Trie {
private:
    TrieNode* root;

public:
    Trie() {
        root = new TrieNode();
    }

    bool insert(const string& word) {
        TrieNode* node = root;
        for (char ch : word) {
            if (node->children.find(ch) == node->children.end()) {
                node->children[ch] = new TrieNode();
            }
            node = node->children[ch];
            if (node->is_end_of_word) {
                return false; // Prefix conflict detected
            }
        }
        if (!node->children.empty()) {
            return false; // Current word is a prefix of another word
        }
        node->is_end_of_word = true;
        return true;
    }
};

int main() {
    int n;
    cout << "Enter the number of words: ";
    cin >> n;

    vector<string> words(n);
    for (int i = 0; i < n; ++i) {
        cout << "Enter word " << i + 1 << ": ";
        cin >> words[i];
    }

    Trie trie;
    for (const string& word : words) {
        if (!trie.insert(word)) {
            cout << "BAD SET\n" << word << endl;
            return 0;
        }
    }

    cout << "GOOD SET" << endl;
    return 0;
}