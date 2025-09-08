#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<int> matchingStrings(const vector<string>& stringList, const vector<string>& queries) {
    vector<int> result;
    for (const string& query : queries) {
        int count = 0;
        for (const string& s : stringList) {
            if (s == query) {
                count++;
            }
        }
        result.push_back(count);
    }
    return result;
}

int main() {
    int n;
    cout << "Enter number of input strings:" << endl;
    cin >> n;

    vector<string> stringList(n);
    cout << "Enter the input strings one by one:" << endl;
    for (int i = 0; i < n; ++i) {
        cin >> stringList[i];
    }

    int q;
    cout << "Enter number of queries:" << endl;
    cin >> q;

    vector<string> queries(q);
    cout << "Enter the queries one by one:" << endl;
    for (int i = 0; i < q; ++i) {
        cin >> queries[i];
    }

    vector<int> results = matchingStrings(stringList, queries);
    cout << "Query Results:" << endl;
    for (int r : results) {
        cout << r << endl;
    }

    return 0;
}
