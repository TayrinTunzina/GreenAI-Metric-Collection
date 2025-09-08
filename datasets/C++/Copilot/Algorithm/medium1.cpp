#include <iostream>
using namespace std;

void extraLongFactorials(int n) {
    // Using an array to store the factorial digits
    const int MAX = 500;
    int result[MAX];
    
    // Initialize result
    result[0] = 1;
    int result_size = 1;

    // Apply factorial
    for (int x = 2; x <= n; x++) {
        int carry = 0;
        for (int i = 0; i < result_size; i++) {
            int prod = result[i] * x + carry;
            result[i] = prod % 10;
            carry = prod / 10;
        }

        while (carry) {
            result[result_size] = carry % 10;
            carry /= 10;
            result_size++;
        }
    }

    // Print the result
    for (int i = result_size - 1; i >= 0; i--) {
        cout << result[i];
    }
    cout << endl;
}

int main() {
    int n;
    cout << "Enter an integer n: ";
    cin >> n;
    extraLongFactorials(n);
    return 0;
}
