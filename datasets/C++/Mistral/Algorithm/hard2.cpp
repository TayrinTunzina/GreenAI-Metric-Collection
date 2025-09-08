#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int chiefHopper(vector<int>& arr) {
    int n = arr.size();
    int minEnergy = 0;

    for (int i = n - 1; i >= 0; i--) {
        int currentEnergy = (minEnergy + arr[i] + 1) / 2;
        minEnergy = currentEnergy;
    }

    return minEnergy;
}

int main() {
    int n;
    cout << "Enter the number of buildings: ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter the heights of the buildings: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cout << "Minimum starting energy: " << chiefHopper(arr) << endl;

    return 0;
}
