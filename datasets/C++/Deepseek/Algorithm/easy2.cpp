#include <iostream>
#include <string>
using namespace std;

long repeatedString(string s, long n) {
    // Count the number of 'a's in the string s
    long count_a = 0;
    for (char ch : s) {
        if (ch == 'a') count_a++;
    }

    // Calculate the number of full repetitions of s in n characters
    long full_repeats = n / s.length();

    // Calculate the number of 'a's in the full repetitions
    long total_a = full_repeats * count_a;

    // Calculate the remaining characters
    long remainder = n % s.length();

    // Add the number of 'a's in the remaining characters
    for (int i = 0; i < remainder; i++) {
        if (s[i] == 'a') total_a++;
    }

    return total_a;
}

int main() {
    string s;
    long n;

    cout << "Enter the string: ";
    cin >> s;
    cout << "Enter the value of n: ";
    cin >> n;

    cout << "Number of 'a's in the first " << n << " characters: " << repeatedString(s, n) << endl;

    return 0;
}