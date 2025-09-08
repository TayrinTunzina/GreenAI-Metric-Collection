#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(const string &a, const string &b) {
    if (a.size() != b.size())
        return a.size() < b.size();
    return a < b; // lexicographical comparison
}

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;
    vector<string> unsorted(n);
    for (int i = 0; i < n; ++i) {
        cin >> unsorted[i];
    }

    sort(unsorted.begin(), unsorted.end(), compare);

    cout << "Sorted output:\n";
    for (const string &num : unsorted) {
        cout << num << endl;
    }

    return 0;
}
