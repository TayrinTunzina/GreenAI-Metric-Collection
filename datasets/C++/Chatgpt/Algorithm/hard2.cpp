#include <bits/stdc++.h>
using namespace std;

int chiefHopper(vector<int>& arr) {
    long long energy = 0;
    for (int i = arr.size() - 1; i >= 0; i--) {
        energy = (energy + arr[i] + 1) / 2; // ceiling division
    }
    return energy;
}

int main() {
    int n;
    cout << "Enter number of buildings: ";
    cin >> n;
    vector<int> arr(n);
    cout << "Enter building heights: ";
    for (int i = 0; i < n; i++) cin >> arr[i];
    cout << "Minimum starting energy: " << chiefHopper(arr) << "\n";
}
