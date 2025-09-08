#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

// Function to count occurrences of queries in stringList
vector<int> matchingStrings(vector<string> stringList, vector<string> queries) {
    vector<int> result;
    unordered_map<string, int> frequency;
    
    // Count frequency of each string in stringList
    for (const string& str : stringList) {
        frequency[str]++;
    }
    
    // For each query, check its frequency in the map
    for (const string& query : queries) {
        if (frequency.find(query) != frequency.end()) {
            result.push_back(frequency[query]);
        } else {
            result.push_back(0);
        }
    }
    
    return result;
}

int main() {
    int n;
    cout << "Enter the size of stringList: ";
    cin >> n;
    vector<string> stringList(n);
    cout << "Enter the strings in stringList:" << endl;
    for (int i = 0; i < n; i++) {
        cin >> stringList[i];
    }
    
    int q;
    cout << "Enter the size of queries: ";
    cin >> q;
    vector<string> queries(q);
    cout << "Enter the query strings:" << endl;
    for (int i = 0; i < q; i++) {
        cin >> queries[i];
    }
    
    // Call the function and print the result
    vector<int> result = matchingStrings(stringList, queries);
    cout << "Results: ";
    for (int count : result) {
        cout << count << " ";
    }
    cout << endl;
    
    return 0;
}
