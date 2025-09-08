#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

long repeatedString(string s, long n) {
    long a_count_in_s = count(s.begin(), s.end(), 'a');
    long full_repeats = n / s.length();
    long remaining_chars = n % s.length();
    long total_a_count = full_repeats * a_count_in_s;

    for (long i = 0; i < remaining_chars; i++) {
        if (s[i] == 'a') {
            total_a_count++;
        }
    }
    return total_a_count;
}

int main() {
    string s;
    long n;
    cout << "Enter the string: ";
    cin >> s;
    cout << "Enter the number of characters to consider: ";
    cin >> n;
    cout << repeatedString(s, n) << endl;
    return 0;
}
