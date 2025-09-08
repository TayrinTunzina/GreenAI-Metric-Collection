#include <iostream>
#include <string>

using namespace std;

long long repeatedString(string s, long long n) {
    long long countA = 0;
    long long length = s.length();

    // Count 'a' in the string s
    for (char c : s) {
        if (c == 'a') {
            countA++;
        }
    }

    // Calculate the number of complete strings that fit in n
    long long fullRepetitions = n / length;
    long long totalCount = fullRepetitions * countA;

    // Calculate the remaining characters and count 'a' in them
    long long remainder = n % length;
    for (long long i = 0; i < remainder; i++) {
        if (s[i] == 'a') {
            totalCount++;
        }
    }

    return totalCount;
}

int main() {
    string s;
    long long n;

    // Input the string s
    cout << "Enter the string: ";
    cin >> s;

    // Input the number n
    cout << "Enter the number of characters to consider: ";
    cin >> n;

    // Output the result
    cout << repeatedString(s, n) << endl;

    return 0;
}
