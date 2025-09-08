#include <iostream>
#include <vector>
using namespace std;

int canCompleteCircle(vector<pair<int, int>>& petrol_pumps) {
    int n = petrol_pumps.size();
    int total_petrol = 0, total_distance = 0, current_petrol = 0, start_index = 0;

    for (int i = 0; i < n; ++i) {
        int petrol = petrol_pumps[i].first;
        int distance = petrol_pumps[i].second;
        total_petrol += petrol;
        total_distance += distance;
        current_petrol += petrol - distance;

        if (current_petrol < 0) {
            start_index = i + 1;
            current_petrol = 0;
        }
    }

    return (total_petrol >= total_distance) ? start_index : -1;
}

int main() {
    int n;
    cout << "Enter the number of petrol pumps: ";
    cin >> n;
    vector<pair<int, int>> petrol_pumps(n);

    for (int i = 0; i < n; ++i) {
        int petrol, distance;
        cout << "Enter petrol and distance: ";
        cin >> petrol >> distance;
        petrol_pumps[i] = {petrol, distance};
    }

    int start_index = canCompleteCircle(petrol_pumps);
    cout << "Starting index: " << start_index << endl;
    return 0;
}
