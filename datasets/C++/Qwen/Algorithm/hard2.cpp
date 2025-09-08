#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int chiefHopper(vector<int>& arr) {
    double required = 0;
    for (int i = arr.size() - 1; i >= 0; i--) {
        required = ceil((required + arr[i]) / 2.0);
    }
    return (int)required;
}

int main() {
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    cout << chiefHopper(arr) << endl;
    return 0;
}