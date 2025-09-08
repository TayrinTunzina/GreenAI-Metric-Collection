#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <sstream>

using namespace std;

vector<string> grid;
vector<string> word_list;
vector<tuple<char, int, int, int>> slots;

bool backtrack(int word_index) {
    if (word_index == word_list.size()) {
        return true;
    }
    
    string current_word = word_list[word_index];
    
    for (auto& slot : slots) {
        char direction = get<0>(slot);
        int row = get<1>(slot);
        int col = get<2>(slot);
        int length = get<3>(slot);
        
        if (length != current_word.length()) {
            continue;
        }
        
        bool can_place = true;
        vector<char> original_chars;
        
        if (direction == 'h') {
            for (int k = 0; k < length; k++) {
                char cell = grid[row][col + k];
                if (cell != '-' && cell != current_word[k]) {
                    can_place = false;
                    break;
                }
                original_chars.push_back(cell);
            }
        } else { // vertical
            for (int k = 0; k < length; k++) {
                char cell = grid[row + k][col];
                if (cell != '-' && cell != current_word[k]) {
                    can_place = false;
                    break;
                }
                original_chars.push_back(cell);
            }
        }
        
        if (can_place) {
            // Place the word
            if (direction == 'h') {
                for (int k = 0; k < length; k++) {
                    grid[row][col + k] = current_word[k];
                }
            } else {
                for (int k = 0; k < length; k++) {
                    grid[row + k][col] = current_word[k];
                }
            }
            
            // Recurse
            if (backtrack(word_index + 1)) {
                return true;
            }
            
            // Backtrack
            if (direction == 'h') {
                for (int k = 0; k < length; k++) {
                    grid[row][col + k] = original_chars[k];
                }
            } else {
                for (int k = 0; k < length; k++) {
                    grid[row + k][col] = original_chars[k];
                }
            }
        }
    }
    
    return false;
}

vector<string> crosswordPuzzle(vector<string> crossword, string words) {
    grid = crossword;
    
    // Split words by semicolon
    stringstream ss(words);
    string word;
    while (getline(ss, word, ';')) {
        word_list.push_back(word);
    }
    
    // Find all horizontal and vertical slots
    // Horizontal slots
    for (int i = 0; i < 10; i++) {
        int j = 0;
        while (j < 10) {
            if (grid[i][j] == '-') {
                int start = j;
                while (j < 10 && grid[i][j] == '-') {
                    j++;
                }
                int length = j - start;
                if (length > 1) {
                    slots.emplace_back('h', i, start, length);
                }
            } else {
                j++;
            }
        }
    }
    
    // Vertical slots
    for (int j = 0; j < 10; j++) {
        int i = 0;
        while (i < 10) {
            if (grid[i][j] == '-') {
                int start = i;
                while (i < 10 && grid[i][j] == '-') {
                    i++;
                }
                int length = i - start;
                if (length > 1) {
                    slots.emplace_back('v', start, j, length);
                }
            } else {
                i++;
            }
        }
    }
    
    // Sort slots by length (descending)
    sort(slots.begin(), slots.end(), 
        [](const auto& a, const auto& b) {
            return get<3>(a) > get<3>(b);
        });
    
    // Start backtracking
    backtrack(0);
    
    return grid;
}

int main() {
    vector<string> crossword(10);
    for (int i = 0; i < 10; i++) {
        cin >> crossword[i];
    }
    
    string words;
    cin >> words;
    
    vector<string> result = crosswordPuzzle(crossword, words);
    for (const string& row : result) {
        cout << row << endl;
    }
    
    return 0;
}