#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>
using namespace std;

vector<int> matchingStrings(vector<string> stringList, vector<string> queries) {
    unordered_map<string, int> countMap;
    for (const string &s : stringList) {
        countMap[s]++;
    }
    vector<int> result;
    for (const string &q : queries) {
        result.push_back(countMap[q]);
    }
    return result;
}

int main() {
    // Taking input manually from the user
    int n;
    cout << "Enter the number of strings in the list: ";
    cin >> n;
    vector<string> stringList(n);
    for (int i = 0; i < n; ++i) {
        cout << "Enter string " << i+1 << ": ";
        cin >> stringList[i];
    }
    int q;
    cout << "Enter the number of queries: ";
    cin >> q;
    vector<string> queries(q);
    for (int i = 0; i < q; ++i) {
        cout << "Enter query " << i+1 << ": ";
        cin >> queries[i];
    }
    vector<int> results = matchingStrings(stringList, queries);
    cout << "Results: ";
    for (int res : results) {
        cout << res << " ";
    }
    cout << endl;
    return 0;
}
