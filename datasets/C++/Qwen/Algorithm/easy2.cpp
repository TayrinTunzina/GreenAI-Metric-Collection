#include <iostream>
#include <string>
using namespace std;

long repeatedString(string s, long n) {
    long len = s.length();
    long count_a = 0;
    // Count 'a's in the entire string
    for (char c : s) {
        if (c == 'a') {
            count_a++;
        }
    }
    // Calculate full repetitions and remaining characters
    long full_repeats = n / len;
    long remainder = n % len;
    // Count 'a's in the remaining part of the string
    long remainder_a = 0;
    for (int i = 0; i < remainder; i++) {
        if (s[i] == 'a') {
            remainder_a++;
        }
    }
    // Total 'a's is sum of 'a's from full repeats and remainder
    return full_repeats * count_a + remainder_a;
}

int main() {
    string s;
    cin >> s;
    long n;
    cin >> n;
    cout << repeatedString(s, n) << endl;
    return 0;
}