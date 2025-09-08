#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

class TrieNode {
public:
    unordered_map<char, TrieNode*> children;
    bool isEnd;
    
    TrieNode() {
        isEnd = false;
    }
};

class Trie {
private:
    TrieNode* root;
    
public:
    Trie() {
        root = new TrieNode();
    }
    
    bool insertAndCheck(string word) {
        TrieNode* current = root;
        
        // Check if this word is a prefix of any existing word
        for(char ch : word) {
            if(current->children.find(ch) == current->children.end()) {
                current->children[ch] = new TrieNode();
            }
            current = current->children[ch];
            // If we hit a word end while still having characters, it's a prefix
            if(current->isEnd) {
                return true;
            }
        }
        
        // Mark current node as end of word
        current->isEnd = true;
        
        // Check if this word is a prefix of any existing word
        return !current->children.empty();
    }
};

void noPrefix(vector<string>& words) {
    Trie trie;
    
    for(const string& word : words) {
        if(trie.insertAndCheck(word)) {
            cout << "BAD SET" << endl;
            cout << word << endl;
            return;
        }
    }
    
    cout << "GOOD SET" << endl;
}

int main() {
    int n;
    cin >> n;
    
    vector<string> words(n);
    for(int i = 0; i < n; i++) {
        cin >> words[i];
    }
    
    noPrefix(words);
    
    return 0;
}