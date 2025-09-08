#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int chiefHopper(vector<int>& arr) {
    int left = 0;
    int max_height = *max_element(arr.begin(), arr.end());
    int right = max_height;
    int answer = right;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        long long current_energy = mid;
        bool possible = true;
        for (int height : arr) {
            if (current_energy > height) {
                current_energy += (current_energy - height);
            } else {
                current_energy -= (height - current_energy);
            }
            if (current_energy < 0) {
                possible = false;
                break;
            }
        }
        if (possible) {
            answer = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return answer;
}

int main() {
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }
    cout << chiefHopper(arr) << endl;
    return 0;
}