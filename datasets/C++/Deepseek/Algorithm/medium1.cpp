#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Function to multiply a number represented as a vector of digits by an integer
void multiply(vector<int>& digits, int multiplier) {
    int carry = 0;
    for (size_t i = 0; i < digits.size(); ++i) {
        int product = digits[i] * multiplier + carry;
        digits[i] = product % 10;
        carry = product / 10;
    }
    while (carry) {
        digits.push_back(carry % 10);
        carry /= 10;
    }
}

void extraLongFactorials(int n) {
    vector<int> digits;
    digits.push_back(1); // Start with 1

    for (int i = 2; i <= n; ++i) {
        multiply(digits, i);
    }

    // Print the result in reverse order
    reverse(digits.begin(), digits.end());
    for (int digit : digits) {
        cout << digit;
    }
    cout << endl;
}

int main() {
    int n;
    cout << "Enter an integer (1 <= n <= 100): ";
    cin >> n;
    extraLongFactorials(n);
    return 0;
}