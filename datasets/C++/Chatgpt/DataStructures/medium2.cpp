#include <iostream>
#include <stack>
#include <unordered_map>
using namespace std;

string isBalanced(string s) {
    stack<char> st;
    unordered_map<char, char> bracketMap = {{')', '('}, {'}', '{'}, {']', '['}};

    for (char ch : s) {
        if (bracketMap.count(ch) == 0) { // Opening bracket
            st.push(ch);
        } else { // Closing bracket
            if (st.empty() || st.top() != bracketMap[ch]) {
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
    cin.ignore(); // Ignore newline

    for (int i = 0; i < n; i++) {
        string s;
        getline(cin, s);
        cout << isBalanced(s) << endl;
    }

    return 0;
}
