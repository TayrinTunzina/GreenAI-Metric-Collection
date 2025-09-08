#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int chiefHopper(vector<int>& arr) {
    // Work backwards from the last building
    // We need at least 1 energy after completing all buildings
    int minEnergyNeeded = 1;
    
    // Go through buildings in reverse order
    for (int i = arr.size() - 1; i >= 0; i--) {
        int height = arr[i];
        // To have minEnergyNeeded after jumping, we need:
        // 2 * before_energy - height >= minEnergyNeeded
        // before_energy >= (minEnergyNeeded + height) / 2
        minEnergyNeeded = (minEnergyNeeded + height + 1) / 2; // Ceiling division
    }
    
    return minEnergyNeeded;
}

void testExample() {
    vector<int> arr = {2, 3, 4, 3, 2};
    int result = chiefHopper(arr);
    
    cout << "Example: arr = [";
    for (int i = 0; i < arr.size(); i++) {
        cout << arr[i];
        if (i < arr.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
    cout << "Minimum starting energy: " << result << endl;
    
    // Verify the solution
    int energy = result;
    cout << "\nVerification:" << endl;
    cout << "Starting energy: " << energy << endl;
    
    for (int i = 0; i < arr.size(); i++) {
        int height = arr[i];
        int newEnergy = 2 * energy - height;
        cout << "Building " << i << ": height=" << height 
             << ", energy: " << energy << " -> " << newEnergy << endl;
        energy = newEnergy;
        if (energy < 0) {
            cout << "Energy went below 0! Solution is incorrect." << endl;
            break;
        }
    }
    cout << "Final energy: " << energy << endl;
}

int main() {
    // Run test first
    testExample();
    cout << "\n" << string(50, '=') << "\n" << endl;
    
    // Main program
    int n;
    cout << "Enter the number of buildings: ";
    cin >> n;
    
    vector<int> heights(n);
    cout << "Enter the heights of buildings (space-separated): ";
    for (int i = 0; i < n; i++) {
        cin >> heights[i];
    }
    
    int result = chiefHopper(heights);
    cout << "Minimum starting energy required: " << result << endl;
    
    return 0;
}