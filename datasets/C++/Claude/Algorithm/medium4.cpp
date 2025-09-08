#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <set>

using namespace std;

struct Slot {
    char direction; // 'H' for horizontal, 'V' for vertical
    int row, col, length;
    
    Slot(char d, int r, int c, int l) : direction(d), row(r), col(c), length(l) {}
};

class CrosswordSolver {
private:
    vector<string> grid;
    vector<string> words;
    vector<Slot> slots;
    
    vector<Slot> findSlots() {
        vector<Slot> result;
        
        // Find horizontal slots
        for (int i = 0; i < 10; i++) {
            int j = 0;
            while (j < 10) {
                if (grid[i][j] == '-') {
                    int start = j;
                    int length = 0;
                    while (j < 10 && grid[i][j] == '-') {
                        length++;
                        j++;
                    }
                    if (length > 1) {
                        result.push_back(Slot('H', i, start, length));
                    }
                } else {
                    j++;
                }
            }
        }
        
        // Find vertical slots
        for (int j = 0; j < 10; j++) {
            int i = 0;
            while (i < 10) {
                if (grid[i][j] == '-') {
                    int start = i;
                    int length = 0;
                    while (i < 10 && grid[i][j] == '-') {
                        length++;
                        i++;
                    }
                    if (length > 1) {
                        result.push_back(Slot('V', start, j, length));
                    }
                } else {
                    i++;
                }
            }
        }
        
        return result;
    }
    
    bool canPlaceWord(const string& word, const Slot& slot) {
        if (word.length() != slot.length) {
            return false;
        }
        
        if (slot.direction == 'H') {
            for (int k = 0; k < slot.length; k++) {
                char cell = grid[slot.row][slot.col + k];
                if (cell != '-' && cell != word[k]) {
                    return false;
                }
            }
        } else { // Vertical
            for (int k = 0; k < slot.length; k++) {
                char cell = grid[slot.row + k][slot.col];
                if (cell != '-' && cell != word[k]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    string placeWord(const string& word, const Slot& slot) {
        string previousState = "";
        
        if (slot.direction == 'H') {
            for (int k = 0; k < slot.length; k++) {
                previousState += grid[slot.row][slot.col + k];
                grid[slot.row][slot.col + k] = word[k];
            }
        } else { // Vertical
            for (int k = 0; k < slot.length; k++) {
                previousState += grid[slot.row + k][slot.col];
                grid[slot.row + k][slot.col] = word[k];
            }
        }
        
        return previousState;
    }
    
    void removeWord(const Slot& slot, const string& previousState) {
        if (slot.direction == 'H') {
            for (int k = 0; k < slot.length; k++) {
                grid[slot.row][slot.col + k] = previousState[k];
            }
        } else { // Vertical
            for (int k = 0; k < slot.length; k++) {
                grid[slot.row + k][slot.col] = previousState[k];
            }
        }
    }
    
    bool solve(int wordIndex, set<int>& usedSlots) {
        if (wordIndex == words.size()) {
            return true;
        }
        
        string word = words[wordIndex];
        
        for (int i = 0; i < slots.size(); i++) {
            if (usedSlots.count(i)) {
                continue;
            }
            
            if (canPlaceWord(word, slots[i])) {
                string previousState = placeWord(word, slots[i]);
                usedSlots.insert(i);
                
                if (solve(wordIndex + 1, usedSlots)) {
                    return true;
                }
                
                // Backtrack
                removeWord(slots[i], previousState);
                usedSlots.erase(i);
            }
        }
        
        return false;
    }
    
    vector<string> splitWords(const string& wordsStr) {
        vector<string> result;
        stringstream ss(wordsStr);
        string word;
        
        while (getline(ss, word, ';')) {
            result.push_back(word);
        }
        
        return result;
    }
    
public:
    vector<string> crosswordPuzzle(vector<string>& crossword, const string& wordsStr) {
        grid = crossword;
        words = splitWords(wordsStr);
        slots = findSlots();
        
        set<int> usedSlots;
        if (solve(0, usedSlots)) {
            return grid;
        }
        
        return vector<string>();
    }
};

int main() {
    CrosswordSolver solver;
    
    // Test case
    vector<string> testCrossword = {
        "++++++++++",
        "+------+++",
        "+++-++++++",
        "+++-++++++",
        "+++-----++",
        "+++-++-+++",
        "++++++-+++",
        "++++++-+++",
        "++++++-+++",
        "++++++++++"
    };
    string testWords = "POLAND;LHASA;SPAIN;INDIA";
    
    cout << "Test case result:" << endl;
    vector<string> result = solver.crosswordPuzzle(testCrossword, testWords);
    for (const string& row : result) {
        cout << row << endl;
    }
    
    cout << "\n" << string(50, '=') << endl;
    cout << "Manual input mode:" << endl;
    
    // Manual input
    vector<string> crossword(10);
    cout << "Enter the 10x10 crossword grid (10 lines):" << endl;
    for (int i = 0; i < 10; i++) {
        cin >> crossword[i];
    }
    
    string words;
    cout << "Enter the semicolon-separated words:" << endl;
    cin >> words;
    
    CrosswordSolver manualSolver;
    vector<string> manualResult = manualSolver.crosswordPuzzle(crossword, words);
    
    cout << "\nSolved crossword:" << endl;
    for (const string& row : manualResult) {
        cout << row << endl;
    }
    
    return 0;
}