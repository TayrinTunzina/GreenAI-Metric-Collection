#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>

using namespace std;

struct TrieNode {
    unordered_map<char, TrieNode*> children;
    bool isEnd;

    TrieNode() : isEnd(false) {}
};

void noPrefix(vector<string>& words) {
    TrieNode* root = new TrieNode();
    bool isGoodSet = true;
    string badWord;

    for (const string& word : words) {
        TrieNode* current = root;
        for (char c : word) {
            if (current->children.find(c) == current->children.end()) {
                current->children[c] = new TrieNode();
            }
            current = current->children[c];
            if (current->isEnd) { 
                isGoodSet = false;
                badWord = word;
                break; // Exit the loop immediately if a prefix is found
            }
        }
        if (!isGoodSet) { 
            break; // Exit the outer loop if a bad word is found
        }
        current->isEnd = true; 
    }

    if (isGoodSet) {
        cout << "GOOD SET" << endl;
    } else {
        cout << "BAD SET" << endl;
        cout << badWord << endl;
    }

    // Deallocate Trie nodes (optional)
    // ...
}

int main() {
    int n;
    cin >> n;
    vector<string> words(n);
    for (int i = 0; i < n; ++i) {
        cin >> words[i];
    }
    noPrefix(words);
    return 0;
}
