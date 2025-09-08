#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cout << "Enter N: ";
    cin >> n;
    
    vector<int> arr(n);
    cout << "Enter " << n << " elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    
    long long max_si = 0;
    
    // Optimized - check all pairs (O(n^2))
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            long long si = (long long)arr[i] ^ arr[j];
            max_si = max(max_si, si);
        }
    }
    
    cout << "Maximum possible value of Si: " << max_si << endl;
    
    return 0;
}