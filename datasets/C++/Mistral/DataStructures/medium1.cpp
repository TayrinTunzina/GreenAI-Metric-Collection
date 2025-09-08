#include <iostream>
#include <vector>
#include <string>
#include <map>

using namespace std;

vector<int> matchingStrings(vector<string>& stringList, vector<string>& queries) {
    map<string, int> frequencyMap;
    for (const string& str : stringList) {
        frequencyMap[str]++;
    }

    vector<int> result;
    for (const string& query : queries) {
        result.push_back(frequencyMap[query]);
    }

    return result;
}

int main() {
    int n;
    cout << "Enter the size of stringList: ";
    cin >> n;
    cin.ignore(); // Ignore the newline character

    vector<string> stringList(n);
    for (int i = 0; i < n; ++i) {
        getline(cin, stringList[i]);
    }

    int q;
    cout << "Enter the size of queries: ";
    cin >> q;
    cin.ignore(); // Ignore the newline character

    vector<string> queries(q);
    for (int i = 0; i < q; ++i) {
        getline(cin, queries[i]);
    }

    vector<int> result = matchingStrings(stringList, queries);
    for (int count : result) {
        cout << count << " ";
    }
    cout << endl;

    return 0;
}
