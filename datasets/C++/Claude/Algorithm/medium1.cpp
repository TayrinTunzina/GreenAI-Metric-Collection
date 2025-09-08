#include <iostream>
#include <vector>
#include <string>
using namespace std;

class BigInteger {
    vector<int> digits;
    
public:
    BigInteger() {
        digits.push_back(1);
    }
    
    void multiply(int num) {
        int carry = 0;
        
        for(int i = 0; i < digits.size(); i++) {
            long long product = (long long)digits[i] * num + carry;
            digits[i] = product % 10;
            carry = product / 10;
        }
        
        while(carry) {
            digits.push_back(carry % 10);
            carry /= 10;
        }
    }
    
    void print() {
        for(int i = digits.size() - 1; i >= 0; i--)
            cout << digits[i];
        cout << endl;
    }
};

void extraLongFactorials(int n) {
    BigInteger result;
    for(int i = 1; i <= n; i++)
        result.multiply(i);
    result.print();
}

int main() {
    int n;
    cout << "Enter a number to calculate its factorial: ";
    cin >> n;
    extraLongFactorials(n);
    return 0;
}