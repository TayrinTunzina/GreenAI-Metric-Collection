#include <iostream>
#include <vector>
#include <stack>
#include <string>
#include <sstream>
#include <algorithm>
using namespace std;

vector<int> getMax(vector<string>& operations) {
    stack<int> mainStack;
    stack<int> maxStack;
    vector<int> results;
    
    for (const string& operation : operations) {
        stringstream ss(operation);
        int opType;
        ss >> opType;
        
        if (opType == 1) {  // Push element
            int x;
            ss >> x;
            mainStack.push(x);
            
            // Update maxStack
            if (maxStack.empty()) {
                maxStack.push(x);
            } else {
                maxStack.push(max(x, maxStack.top()));
            }
            
        } else if (opType == 2) {  // Pop element
            if (!mainStack.empty()) {
                mainStack.pop();
                maxStack.pop();
            }
            
        } else if (opType == 3) {  // Get maximum
            if (!maxStack.empty()) {
                results.push_back(maxStack.top());
            }
        }
    }
    
    return results;
}

int main() {
    int n;
    cout << "Enter the number of operations: ";
    cin >> n;
    cin.ignore(); // Clear the newline from buffer
    
    vector<string> operations(n);
    cout << "Enter " << n << " operations:" << endl;
    cout << "Format: '1 x' for push, '2' for pop, '3' for get max" << endl;
    
    for (int i = 0; i < n; i++) {
        getline(cin, operations[i]);
    }
    
    vector<int> results = getMax(operations);
    
    cout << "\nResults for type 3 operations (get maximum):" << endl;
    for (int result : results) {
        cout << result << endl;
    }
    
    return 0;
}