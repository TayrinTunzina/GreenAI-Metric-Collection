#include <iostream>
#include <vector>
using namespace std;

int findStartingPump(vector<pair<int, int>>& pumps) {
    int n = pumps.size();
    int totalPetrol = 0;
    int currentPetrol = 0;
    int startIndex = 0;

    for (int i = 0; i < n; ++i) {
        totalPetrol += pumps[i].first - pumps[i].second;
        currentPetrol += pumps[i].first - pumps[i].second;

        if (currentPetrol < 0) {
            startIndex = i + 1;
            currentPetrol = 0;
        }
    }

    return (totalPetrol >= 0) ? startIndex : -1;
}

int main() {
    int n;
    cout << "Enter the number of petrol pumps: ";
    cin >> n;
    vector<pair<int, int>> pumps(n);

    for (int i = 0; i < n; ++i) {
        cin >> pumps[i].first >> pumps[i].second;
    }

    int result = findStartingPump(pumps);
    cout << "The smallest index from which we can start the tour is: " << result << endl;

    return 0;
}
