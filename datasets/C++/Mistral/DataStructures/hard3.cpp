#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

void noPrefix(const std::vector<std::string>& words) {
    std::vector<std::string> sortedWords = words;
    std::sort(sortedWords.begin(), sortedWords.end());

    for (size_t i = 0; i < sortedWords.size() - 1; ++i) {
        if (sortedWords[i+1].find(sortedWords[i]) == 0) {
            std::cout << "BAD SET" << std::endl;
            std::cout << sortedWords[i+1] << std::endl;
            return;
        }
    }
    std::cout << "GOOD SET" << std::endl;
}

int main() {
    int n;
    std::cout << "Enter the number of strings: ";
    std::cin >> n;
    std::vector<std::string> words(n);
    std::cout << "Enter the strings:" << std::endl;
    for (int i = 0; i < n; ++i) {
        std::cin >> words[i];
    }

    noPrefix(words);
    return 0;
}
