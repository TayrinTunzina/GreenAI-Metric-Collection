#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>

class TrieNode {
public:
    std::unordered_map<char, TrieNode*> children;
    int count;

    TrieNode() : count(0) {}
};

class Contacts {
private:
    TrieNode* root;

public:
    Contacts() {
        root = new TrieNode();
    }

    void add(const std::string& name) {
        TrieNode* node = root;
        for (char c : name) {
            if (node->children.find(c) == node->children.end()) {
                node->children[c] = new TrieNode();
            }
            node = node->children[c];
            node->count++;
        }
    }

    int find(const std::string& partial) {
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

std::vector<int> contacts(const std::vector<std::string>& queries) {
    Contacts contactsApp;
    std::vector<int> results;
    for (const std::string& query : queries) {
        if (query.rfind("add ", 0) == 0) {
            std::string name = query.substr(4);
            contactsApp.add(name);
        } else if (query.rfind("find ", 0) == 0) {
            std::string partial = query.substr(5);
            results.push_back(contactsApp.find(partial));
        }
    }
    return results;
}

int main() {
    int n;
    std::cout << "Enter the number of operations: ";
    std::cin >> n;
    std::cin.ignore(); // Ignore the newline character after reading n

    std::vector<std::string> queries(n);
    for (int i = 0; i < n; ++i) {
        std::cout << "Enter operation: ";
        std::getline(std::cin, queries[i]);
    }

    std::vector<int> results = contacts(queries);
    for (int result : results) {
        std::cout << result << std::endl;
    }

    return 0;
}
