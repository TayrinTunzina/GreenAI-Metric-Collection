#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    int n;
    cout << "Enter the size of string list: ";
    cin >> n;
    
    cout << "Enter " << n << " strings (one per line):" << endl;
    vector<string> stringList(n);
    for (int i = 0; i < n; i++) {
        cin >> stringList[i];
    }
    
    int q;
    cout << "Enter the number of queries: ";
    cin >> q;
    
    cout << "Enter " << q << " query strings (one per line):" << endl;
    vector<string> queries(q);
    for (int i = 0; i < q; i++) {
        cin >> queries[i];
    }
    
    cout << "\nResults:" << endl;
    // Process and output results
    vector<int> results;
    for (int i = 0; i < q; i++) {
        int count = 0;
        for (const string& str : stringList) {
            if (str == queries[i]) {
                count++;
            }
        }
        cout << "Query '" << queries[i] << "': " << count << endl;
        results.push_back(count);
    }
    
    cout << "\nAnswer array: [";
    for (int i = 0; i < results.size(); i++) {
        cout << results[i];
        if (i < results.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
    
    return 0;
}
