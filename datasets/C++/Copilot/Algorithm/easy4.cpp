#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(const string &a, const string &b) {
    if (a.size() == b.size())
        return a < b;
    return a.size() < b.size();
}

int main() {
    int n;
    cin >> n;
    vector<string> unsorted(n);

    for (int i = 0; i < n; ++i)
        cin >> unsorted[i];

    sort(unsorted.begin(), unsorted.end(), compare);

    for (const string &num : unsorted)
        cout << num << endl;

    return 0;
}
