#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>

std::string isBalanced(const std::string& s) {
    std::stack<char> stack;
    std::unordered_map<char, char> matching_bracket = { {')', '('}, {']', '['}, {'}', '{'}};
    for (char c : s) {
        if (matching_bracket.find(c) == matching_bracket.end()) {
            stack.push(c);
        } else {
            if (stack.empty() || stack.top() != matching_bracket[c]) {
                return "NO";
            }
            stack.pop();
        }
    }
    return stack.empty() ? "YES" : "NO";
}

int main() {
    int n;
    std::cout << "Enter the number of strings: ";
    std::cin >> n;
    std::cin.ignore();
    std::string results[n];
    for (int i = 0; i < n; ++i) {
        std::string s;
        std::cout << "Enter a string of brackets: ";
        std::getline(std::cin, s);
        results[i] = isBalanced(s);
    }
    for (const std::string& result : results) {
        std::cout << result << std::endl;
    }
    return 0;
}
