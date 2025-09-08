#include <iostream>
#include <vector>

using namespace std;

void extraLongFactorials(int n) {
    // Initialize result as a vector of 1 (since 1! = 1)
    vector<int> result(1, 1);  

    // Multiply result by every number from 2 to n
    for (int i = 2; i <= n; i++) {
        int carry = 0;
        for (int j = 0; j < result.size(); j++) {
            int prod = result[j] * i + carry;  
            result[j] = prod % 10;  
            carry = prod / 10;  
        }

        // Handle remaining carry, if any
        while (carry) {
            result.push_back(carry % 10);
            carry /= 10;
        }
    }

    // Output the factorial (in reverse order)
    for (int i = result.size() - 1; i >= 0; i--) {
        cout << result[i];
    }
    cout << endl;
}

int main() {
    int n;
    cout << "Enter a number: ";
    cin >> n;
    extraLongFactorials(n);
    return 0;
}
