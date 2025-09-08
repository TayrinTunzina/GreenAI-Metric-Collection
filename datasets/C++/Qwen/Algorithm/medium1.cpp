#include <iostream>
#include <vector>
using namespace std;

// Function to multiply a number with a large number represented as a vector
void multiply(int num, vector<int> &result) {
    int carry = 0;
    for (int i = 0; i < result.size(); i++) {
        int prod = result[i] * num + carry;
        result[i] = prod % 10;
        carry = prod / 10;
    }
    while (carry) {
        result.push_back(carry % 10);
        carry /= 10;
    }
}

// Function to calculate factorial
void extraLongFactorials(int n) {
    vector<int> result;
    result.push_back(1); // Initialize result as 1

    for (int i = 2; i <= n; i++) {
        multiply(i, result);
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