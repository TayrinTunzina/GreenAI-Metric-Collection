#include <iostream>
#include <stack>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>

/**
 * @brief Processes a vector of stack operations and returns the results of all type 3 queries.
 * @param operations A vector of strings, where each string is a query.
 * @return A vector of integers containing the answers to each type 3 query.
 */
std::vector<int> getMax(const std::vector<std::string>& operations) {
    std::stack<int> main_stack;
    std::stack<int> max_stack;
    std::vector<int> results;

    for (const auto& op : operations) {
        std::stringstream ss(op);
        int type;
        ss >> type;

        if (type == 1) {
            int val;
            ss >> val;
            main_stack.push(val);
            if (max_stack.empty() || val >= max_stack.top()) {
                max_stack.push(val);
            }
        } else if (type == 2) {
            if (!main_stack.empty()) {
                int popped = main_stack.top();
                main_stack.pop();
                if (popped == max_stack.top()) {
                    max_stack.pop();
                }
            }
        } else if (type == 3) {
            if (!max_stack.empty()) {
                results.push_back(max_stack.top());
            }
        }
    }
    return results;
}

int main() {
    // Fast I/O
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int n;
    std::cin >> n;
    // Consume the rest of the line after reading n
    std::cin.ignore(); 

    std::vector<std::string> ops(n);
    for (int i = 0; i < n; ++i) {
        std::getline(std::cin, ops[i]);
    }

    std::vector<int> res = getMax(ops);

    for (int val : res) {
        std::cout << val << "\n";
    }

    return 0;
}