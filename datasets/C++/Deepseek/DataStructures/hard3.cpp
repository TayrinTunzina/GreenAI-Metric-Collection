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
public:
    TrieNode* root;

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
                return false;
            }
        }
        node->is_end_of_word = true;
        return true;
    }
};

void noPrefix(const vector<string>& words) {
    Trie trie;
    for (const string& word : words) {
        if (!trie.insert(word)) {
            cout << "BAD SET" << endl;
            cout << word << endl;
            return;
        }
    }
    cout << "GOOD SET" << endl;
}

int main() {
    // Manual input
    int n;
    cout << "Enter the number of words: ";
    cin >> n;

    vector<string> words(n);
    cout << "Enter the words:" << endl;
    for (int i = 0; i < n; ++i) {
        cin >> words[i];
    }

    noPrefix(words);
    return 0;
}