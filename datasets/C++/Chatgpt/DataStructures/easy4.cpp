#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;
    stack<int> s, maxStack;
    vector<int> results;

    for (int i = 0; i < n; ++i) {
        int type;
        cin >> type;
        if (type == 1) {
            int x;
            cin >> x;
            s.push(x);
            if (maxStack.empty() || x >= maxStack.top()) {
                maxStack.push(x);
            }
        } else if (type == 2) {
            if (!s.empty()) {
                if (s.top() == maxStack.top()) {
                    maxStack.pop();
                }
                s.pop();
            }
        } else if (type == 3) {
            if (!maxStack.empty()) {
                cout << maxStack.top() << endl;
            }
        }
    }

    return 0;
}
