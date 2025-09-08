#include <iostream>
#include <vector>
using namespace std;

int findStartingPetrolPump(int N, vector<pair<int, int>>& petrolPumps) {
    int start = 0;
    int totalPetrol = 0;
    int currentPetrol = 0;
    
    for (int i = 0; i < N; ++i) {
        int petrol = petrolPumps[i].first;
        int distance = petrolPumps[i].second;
        totalPetrol += petrol - distance;
        currentPetrol += petrol - distance;
        
        if (currentPetrol < 0) {
            start = i + 1;
            currentPetrol = 0;
        }
    }
    
    return (totalPetrol >= 0) ? start : -1;
}

int main() {
    int N;
    cout << "Enter the number of petrol pumps: ";
    cin >> N;
    
    vector<pair<int, int>> petrolPumps(N);
    for (int i = 0; i < N; ++i) {
        int petrol, distance;
        cout << "Enter the amount of petrol at pump " << i << ": ";
        cin >> petrol;
        cout << "Enter the distance to the next pump from pump " << i << ": ";
        cin >> distance;
        petrolPumps[i] = make_pair(petrol, distance);
    }
    
    int result = findStartingPetrolPump(N, petrolPumps);
    cout << "The starting petrol pump index is: " << result << endl;
    
    return 0;
}