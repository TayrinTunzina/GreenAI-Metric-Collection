#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

bool compare(const string &a, const string &b) {
    if (a.length() != b.length()) {
        return a.length() < b.length();
    } else {
        return a < b;
    }
}

int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;
    cin.ignore(); // Ignore the newline character after reading n

    vector<string> unsorted(n);
    for (int i = 0; i < n; ++i) {
        getline(cin, unsorted[i]);
    }

    sort(unsorted.begin(), unsorted.end(), compare);

    cout << "Sorted array:" << endl;
    for (const string &num : unsorted) {
        cout << num << endl;
    }

    return 0;
}
