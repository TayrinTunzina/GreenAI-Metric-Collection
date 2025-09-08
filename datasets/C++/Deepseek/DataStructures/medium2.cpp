#include <iostream>
#include <stack>
#include <unordered_map>
#include <string>
using namespace std;

string isBalanced(string s) {
    stack<char> stack;
    unordered_map<char, char> mapping = {{')', '('}, {'}', '{'}, {']', '['}};
    
    for (char c : s) {
        if (mapping.find(c) != mapping.end()) {
            char topElement = stack.empty() ? '#' : stack.top();
            stack.pop();
            if (topElement != mapping[c]) {
                return "NO";
            }
        } else {
            stack.push(c);
        }
    }
    
    return stack.empty() ? "YES" : "NO";
}

int main() {
    int n;
    cout << "Enter the number of strings: ";
    cin >> n;
    cin.ignore(); // To ignore the newline after the integer input
    
    for (int i = 0; i < n; i++) {
        string s;
        cout << "Enter string " << i+1 << ": ";
        getline(cin, s);
        cout << isBalanced(s) << endl;
    }
    
    return 0;
}