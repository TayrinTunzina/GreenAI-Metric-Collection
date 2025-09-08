#include <iostream>
#include <vector>

using namespace std;

int canCompleteCircuit(vector<int>& petrol, vector<int>& distance) {
    int n = petrol.size();
    int start = 0;
    int tank = 0;
    int total_deficit = 0;

    for (int i = 0; i < n; ++i) {
        tank += petrol[i] - distance[i];
        if (tank < 0) {
            start = i + 1;
            total_deficit += tank;
            tank = 0;
        }
    }

    return (tank + total_deficit >= 0) ? start : -1;
}

int main() {
    int n;
    cin >> n;
    vector<int> petrol(n), distance(n);

    for (int i = 0; i < n; ++i) {
        cin >> petrol[i] >> distance[i];
    }

    cout << canCompleteCircuit(petrol, distance) << endl;
    return 0;
}
