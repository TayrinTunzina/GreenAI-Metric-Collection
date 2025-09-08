#include <iostream>
#include <vector>
#include <string>

// Define the TrieNode structure
struct TrieNode {
    TrieNode* children[26];
    int count;

    TrieNode() {
        for (int i = 0; i < 26; ++i) {
            children[i] = nullptr;
        }
        count = 0;
    }
};

// Function to add a name to the Trie
void addName(TrieNode* root, const std::string& name) {
    TrieNode* current = root;
    for (char ch : name) {
        int index = ch - 'a';
        if (!current->children[index]) {
            current->children[index] = new TrieNode();
        }
        current = current->children[index];
        current->count++;
    }
}

// Function to find the count of names with a given partial prefix
int findPartial(TrieNode* root, const std::string& partial) {
    TrieNode* current = root;
    for (char ch : partial) {
        int index = ch - 'a';
        if (!current->children[index]) {
            return 0; // Prefix not found
        }
        current = current->children[index];
    }
    return current->count;
}

std::vector<int> contacts(const std::vector<std::vector<std::string>>& queries) {
    TrieNode* root = new TrieNode();
    std::vector<int> results;

    for (const auto& query : queries) {
        const std::string& operation = query[0];
        const std::string& value = query[1];

        if (operation == "add") {
            addName(root, value);
        } else if (operation == "find") {
            results.push_back(findPartial(root, value));
        }
    }
    // In a real application, you'd deallocate the Trie memory here.
    return results;
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int n;
    std::cin >> n;

    std::vector<std::vector<std::string>> queries(n, std::vector<std::string>(2));
    for (int i = 0; i < n; ++i) {
        std::cin >> queries[i][0] >> queries[i][1];
    }

    std::vector<int> results = contacts(queries);

    for (int res : results) {
        std::cout << res << "\n";
    }

    return 0;
}