#include <iostream>
#include <string>

using namespace std;

int repeatedString(string s, long long n) {
    int a_count = 0;
    for (char c : s) {
        if (c == 'a') {
            a_count++;
        }
    }

    long long full_repeats = n / s.length();
    long long remaining = n % s.length();

    int total_a_count = a_count * full_repeats;
    for (int i = 0; i < remaining; i++) {
        if (s[i] == 'a') {
            total_a_count++;
        }
    }

    return total_a_count;
}

int main() {
    string s;
    long long n;
    cin >> s >> n;

    int result = repeatedString(s, n);
    cout << result << endl;

    return 0;
}
