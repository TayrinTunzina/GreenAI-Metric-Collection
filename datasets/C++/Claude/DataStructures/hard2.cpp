#include <iostream>
#include <vector>
using namespace std;

int findStartingPoint(vector<long>& petrol, vector<long>& distance, int n) {
    // If only one petrol pump
    if (n == 1) {
        return (petrol[0] >= distance[0]) ? 0 : -1;
    }
    
    int start = 0;
    long curr_petrol = 0;
    long total_petrol = 0;
    
    for (int i = 0; i < n; i++) {
        // Add the difference of petrol and distance
        curr_petrol += petrol[i] - distance[i];
        total_petrol += petrol[i] - distance[i];
        
        // If at any point curr_petrol becomes negative
        if (curr_petrol < 0) {
            // Start from the next point
            start = i + 1;
            // Reset current petrol
            curr_petrol = 0;
        }
    }
    
    // If total petrol is negative, no solution exists
    if (total_petrol < 0) {
        return -1;
    }
    
    return start;
}

int main() {
    int n;
    cin >> n;
    
    vector<long> petrol(n);
    vector<long> distance(n);
    
    // Read n lines of input
    for (int i = 0; i < n; i++) {
        cin >> petrol[i] >> distance[i];
    }
    
    // Find and print the result
    int result = findStartingPoint(petrol, distance, n);
    cout << result << endl;
    
    return 0;
}