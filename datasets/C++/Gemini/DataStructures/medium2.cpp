#include <iostream>
#include <stack>
#include <map>
#include <string>

using namespace std;

string isBalanced(string s) {
    stack<char> stack;
    map<char, char> mappings = {{')', '('}, {'}', '{'}, {']', '['}};

    for (char c : s) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else if (c == ')' || c == '}' || c == ']') {
            if (stack.empty() || stack.top() != mappings[c]) {
                return "NO";
            }
            stack.pop();
        }
    }

    return stack.empty() ? "YES" : "NO";
}

int main() {
    int t;
    cin >> t;

    for (int t_itr = 0; t_itr < t; t_itr++) {
        string s;
        cin >> s;

        string result = isBalanced(s);

        cout << result << "\n";
    }

    return 0;
}
