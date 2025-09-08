#include <iostream>
#include <vector>
#include <stack>
#include <string>
#include <sstream>
using namespace std;

vector<int> getMax(vector<string> operations) {
    stack<int> s;
    stack<int> max_s;
    vector<int> result;
    for (string op : operations) {
        if (op[0] == '1') {
            int num = stoi(op.substr(2));
            s.push(num);
            if (max_s.empty() || num >= max_s.top()) {
                max_s.push(num);
            }
        } else if (op == "2") {
            if (s.top() == max_s.top()) {
                max_s.pop();
            }
            s.pop();
        } else if (op == "3") {
            result.push_back(max_s.top());
        }
    }
    return result;
}

int main() {
    int n;
    cin >> n;
    cin.ignore();
    vector<string> operations(n);
    for (int i = 0; i < n; i++) {
        getline(cin, operations[i]);
    }
    vector<int> output = getMax(operations);
    for (int num : output) {
        cout << num << endl;
    }
    return 0;
}