#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

vector<int> getMax(const vector<string>& operations) {
    vector<int> stack;
    vector<int> maxStack;
    vector<int> output;

    for (const string& operation : operations) {
        istringstream iss(operation);
        int type, x;
        iss >> type;
        if (type == 1) {
            iss >> x;
            stack.push_back(x);
            if (maxStack.empty() || x >= maxStack.back()) {
                maxStack.push_back(x);
            }
        } else if (type == 2) {
            if (!stack.empty()) {
                int popped = stack.back();
                stack.pop_back();
                if (!maxStack.empty() && popped == maxStack.back()) {
                    maxStack.pop_back();
                }
            }
        } else if (type == 3) {
            if (!maxStack.empty()) {
                output.push_back(maxStack.back());
            }
        }
    }

    return output;
}

int main() {
    int n;
    cout << "Enter the number of operations: ";
    cin >> n;
    cin.ignore(); // Ignore the newline character after reading n

    vector<string> operations(n);
    for (int i = 0; i < n; ++i) {
        cout << "Enter operation: ";
        getline(cin, operations[i]);
    }

    vector<int> results = getMax(operations);
    for (int result : results) {
        cout << result << endl;
    }

    return 0;
}
