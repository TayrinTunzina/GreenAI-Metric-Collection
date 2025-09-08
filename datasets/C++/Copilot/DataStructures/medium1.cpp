#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<int> matchingStrings(const vector<string>& stringList, const vector<string>& queries) {
    vector<int> results;
    for (const string& query : queries) {
        int count = 0;
        for (const string& s : stringList) {
            if (s == query) count++;
        }
        results.push_back(count);
    }
    return results;
}

int main() {
    int n;
    cout << "Enter number of strings in stringList: ";
    cin >> n;
    vector<string> stringList(n);
    cout << "Enter the strings:" << endl;
    for (int i = 0; i < n; ++i) {
        cin >> stringList[i];
    }

    int q;
    cout << "Enter number of queries: ";
    cin >> q;
    vector<string> queries(q);
    cout << "Enter the queries:" << endl;
    for (int i = 0; i < q; ++i) {
        cin >> queries[i];
    }

    vector<int> results = matchingStrings(stringList, queries);
    cout << "Query results:" << endl;
    for (int count : results) {
        cout << count << endl;
    }

    return 0;
}
