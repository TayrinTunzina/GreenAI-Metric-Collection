#include <iostream>
#include <stack>
#include <unordered_map>
using namespace std;

string isBalanced(string s) {
    stack<char> stack;
    unordered_map<char, char> bracket_map = {{')', '('}, {'}', '{'}, {']', '['}};
    
    for (char ch : s) {
        if (bracket_map.find(ch) == bracket_map.end()) {
            stack.push(ch);
        } else {
            if (stack.empty() || stack.top() != bracket_map[ch]) {
                return "NO";
            }
            stack.pop();
        }
    }
    return stack.empty() ? "YES" : "NO";
}

int main() {
    int n;
    cout << "Enter the number of strings: ";
    cin >> n;
    for (int i = 0; i < n; i++) {
        string s;
        cout << "Enter the string of brackets: ";
        cin >> s;
        cout << isBalanced(s) << endl;
    }
    return 0;
}
