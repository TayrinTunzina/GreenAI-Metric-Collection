#include <iostream>
#include <vector>
using namespace std;

int findStartingPoint(int n, vector<pair<int, int>>& petrolPumps) {
    int start = 0;
    long long totalPetrol = 0, totalDistance = 0;
    long long currentPetrol = 0;
    for (int i = 0; i < n; ++i) {
        int petrol = petrolPumps[i].first;
        int distance = petrolPumps[i].second;
        totalPetrol += petrol;
        totalDistance += distance;
        currentPetrol += petrol - distance;
        if (currentPetrol < 0) {
            start = i + 1;
            currentPetrol = 0;
        }
    }
    if (totalPetrol >= totalDistance) {
        return start % n;
    } else {
        return -1;
    }
}

int main() {
    int n;
    cout << "Enter the number of petrol pumps: ";
    cin >> n;
    vector<pair<int, int>> petrolPumps(n);
    for (int i = 0; i < n; ++i) {
        cout << "Enter petrol and distance (space-separated): ";
        cin >> petrolPumps[i].first >> petrolPumps[i].second;
    }
    int result = findStartingPoint(n, petrolPumps);
    cout << "The starting point is: " << result << endl;
    return 0;
}