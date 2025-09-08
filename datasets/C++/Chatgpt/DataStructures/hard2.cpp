#include <iostream>
#include <vector>

using namespace std;

int findStartingPump(int n, vector<pair<int, int>> &pumps) {
    int total_surplus = 0, current_surplus = 0, start_index = 0;

    for (int i = 0; i < n; i++) {
        int petrol = pumps[i].first, distance = pumps[i].second;
        int surplus = petrol - distance;
        total_surplus += surplus;
        current_surplus += surplus;

        if (current_surplus < 0) {
            start_index = i + 1;
            current_surplus = 0;
        }
    }

    return (total_surplus >= 0) ? start_index : -1;
}

int main() {
    int n;
    cin >> n;
    vector<pair<int, int>> pumps(n);

    for (int i = 0; i < n; i++) {
        cin >> pumps[i].first >> pumps[i].second;
    }

    cout << findStartingPump(n, pumps) << endl;
    return 0;
}
