#include <iostream>
#include <vector>
#include <stack>
#include <string>
using namespace std;

vector<int> getMax(vector<string>& operations) {
    stack<int> s, maxs;
    vector<int> result;

    for (const string& op : operations) {
        if (op[0] == '1') {
            int val = stoi(op.substr(2));
            s.push(val);
            maxs.push(maxs.empty() ? val : max(val, maxs.top()));
        } else if (op[0] == '2') {
            if (!s.empty()) {
                s.pop();
                maxs.pop();
            }
        } else if (op[0] == '3') {
            result.push_back(maxs.top());
        }
    }
    return result;
}

int main() {
    int n;
    cout << "Enter number of operations: ";
    cin >> n;
    cin.ignore();
    vector<string> operations;
    for (int i = 0; i < n; ++i) {
        string op;
        getline(cin, op);
        operations.push_back(op);
    }
    vector<int> result = getMax(operations);
    cout << "Results of max queries:\n";
    for (int val : result)
        cout << val << "\n";
    return 0;
}
