#include <iostream>
#include <stack>
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

string isBalanced(string s) {
    stack<char> st;
    unordered_map<char, char> bracket_map = {{')', '('}, {'}', '{'}, {']', '['}};
    
    for (char ch : s) {
        if (ch == '(' || ch == '{' || ch == '[') {  // Opening bracket
            st.push(ch);
        } else if (ch == ')' || ch == '}' || ch == ']') {  // Closing bracket
            if (st.empty() || st.top() != bracket_map[ch]) {
                return "NO";
            }
            st.pop();
        }
    }
    
    return st.empty() ? "YES" : "NO";
}

int main() {
    int n;
    cout << "Enter the number of strings: ";
    cin >> n;
    cin.ignore();  // To ignore the newline after the integer input
    
    vector<string> results;
    for (int i = 0; i < n; i++) {
        string s;
        cout << "Enter a string of brackets: ";
        getline(cin, s);
        results.push_back(isBalanced(s));
    }
    
    for (const string& res : results) {
        cout << res << endl;
    }
    
    return 0;
}