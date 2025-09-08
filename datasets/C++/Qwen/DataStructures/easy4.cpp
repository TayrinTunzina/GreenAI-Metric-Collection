#include <iostream>
#include <vector>
#include <stack>
#include <string>
#include <sstream>

using namespace std;

vector<int> getMax(vector<string> operations) {
    stack<int> stk;
    stack<int> maxStk;
    vector<int> result;
    
    for (string op : operations) {
        if (op[0] == '1') {
            // Push operation
            stringstream ss(op);
            string type;
            int x;
            ss >> type >> x;
            stk.push(x);
            if (maxStk.empty() || x >= maxStk.top()) {
                maxStk.push(x);
            }
        } else if (op[0] == '2') {
            // Pop operation
            if (!stk.empty()) {
                int popped = stk.top();
                stk.pop();
                if (!maxStk.empty() && popped == maxStk.top()) {
                    maxStk.pop();
                }
            }
        } else if (op[0] == '3') {
            // Print maximum
            if (!maxStk.empty()) {
                result.push_back(maxStk.top());
            }
        }
    }
    
    return result;
}

int main() {
    int n;
    cin >> n;
    cin.ignore(); // Ignore newline
    
    vector<string> operations;
    for (int i = 0; i < n; i++) {
        string op;
        getline(cin, op);
        operations.push_back(op);
    }
    
    vector<int> result = getMax(operations);
    for (int res : result) {
        cout << res << endl;
    }
    
    return 0;
}