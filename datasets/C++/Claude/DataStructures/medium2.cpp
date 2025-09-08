#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
using namespace std;

string isBalanced(string s) {
    stack<char> st;
    unordered_map<char, char> brackets = {
        {')', '('},
        {']', '['},
        {'}', '{'}
    };
    
    for(char c : s) {
        if(c == '(' || c == '[' || c == '{') {
            st.push(c);
        }
        else if(c == ')' || c == ']' || c == '}') {
            if(st.empty() || st.top() != brackets[c]) {
                return "NO";
            }
            st.pop();
        }
    }
    
    return st.empty() ? "YES" : "NO";
}

int main() {
    int n;
    cin >> n;
    cin.ignore();  // Clear newline
    
    for(int i = 0; i < n; i++) {
        string s;
        getline(cin, s);
        cout << isBalanced(s) << endl;
    }
    
    return 0;
}