#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

struct TrieNode {
    unordered_map<char, TrieNode*> children;
    bool isEndOfWord = false;
};

class Trie {
public:
    Trie() {
        root = new TrieNode();
    }

    bool insert(const string& word) {
        TrieNode* current = root;
        for (char ch : word) {
            if (current->children.find(ch) == current->children.end()) {
                current->children[ch] = new TrieNode();
            }
            current = current->children[ch];
            if (current->isEndOfWord) {
                return false;
            }
        }
        if (!current->children.empty()) {
            return false;
        }
        current->isEndOfWord = true;
        return true;
    }

private:
    TrieNode* root;
};

void noPrefix(vector<string>& words) {
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
    int n;
    cout << "Enter the number of words: ";
    cin >> n;
    vector<string> words(n);
    for (int i = 0; i < n; ++i) {
        cin >> words[i];
    }
    noPrefix(words);
    return 0;
}
