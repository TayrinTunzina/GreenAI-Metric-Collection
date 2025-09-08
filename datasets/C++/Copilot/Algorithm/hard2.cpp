#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int chiefHopper(vector<int>& arr) {
    int energy = 0;
    for (int i = arr.size() - 1; i >= 0; --i) {
        energy = ceil((energy + arr[i]) / 2.0);
    }
    return energy;
}

int main() {
    int n;
    cout << "Enter number of buildings: ";
    cin >> n;
    vector<int> arr(n);
    cout << "Enter building heights: ";
    for (int i = 0; i < n; ++i) cin >> arr[i];
    cout << "Minimum starting energy: " << chiefHopper(arr) << endl;
    return 0;
}
