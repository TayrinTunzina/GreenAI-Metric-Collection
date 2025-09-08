#include <iostream>
#include <vector>

using namespace std;

void extraLongFactorials(int n) {
    vector<int> result(1, 1); // Initialize result with 1

    for (int i = 2; i <= n; i++) {
        int carry = 0;
        for (int j = 0; j < result.size(); j++) {
            int product = result[j] * i + carry;
            result[j] = product % 10;
            carry = product / 10;
        }
        while (carry > 0) {
            result.push_back(carry % 10);
            carry /= 10;
        }
    }

    // Print the result in reverse order
    for (int i = result.size() - 1; i >= 0; i--) {
        cout << result[i];
    }
    cout << endl;
}

int main() {
    int n;
    cout << "Enter an integer: ";
    cin >> n;

    extraLongFactorials(n);

    return 0;
}
