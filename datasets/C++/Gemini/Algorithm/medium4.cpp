#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

// Function to check if a word can be placed horizontally
bool can_place_horizontal(const vector<string>& grid, const string& word, int r, int c) {
    if (c + word.length() > 10) return false;
    if (c > 0 && grid[r][c - 1] != '+') return false;
    if (c + word.length() < 10 && grid[r][c + word.length()] != '+') return false;
    for (size_t i = 0; i < word.length(); ++i) {
        if (grid[r][c + i] != '-' && grid[r][c + i] != word[i]) {
            return false;
        }
    }
    return true;
}

// Function to check if a word can be placed vertically
bool can_place_vertical(const vector<string>& grid, const string& word, int r, int c) {
    if (r + word.length() > 10) return false;
    if (r > 0 && grid[r - 1][c] != '+') return false;
    if (r + word.length() < 10 && grid[r + word.length()][c] != '+') return false;
    for (size_t i = 0; i < word.length(); ++i) {
        if (grid[r + i][c] != '-' && grid[r + i][c] != word[i]) {
            return false;
        }
    }
    return true;
}

// The main recursive backtracking function
bool solve_crossword(vector<string>& grid, const vector<string>& words, int word_index) {
    if (word_index == words.size()) {
        return true; // Base case: all words are placed
    }

    const string& current_word = words[word_index];
    for (int r = 0; r < 10; ++r) {
        for (int c = 0; c < 10; ++c) {
            if (grid[r][c] == '-' || grid[r][c] == current_word[0]) {
                // Try placing horizontally
                if (can_place_horizontal(grid, current_word, r, c)) {
                    vector<string> grid_backup = grid;
                    for (size_t i = 0; i < current_word.length(); ++i) {
                        grid[r][c + i] = current_word[i];
                    }
                    if (solve_crossword(grid, words, word_index + 1)) {
                        return true;
                    }
                    grid = grid_backup; // Backtrack
                }

                // Try placing vertically
                if (can_place_vertical(grid, current_word, r, c)) {
                    vector<string> grid_backup = grid;
                    for (size_t i = 0; i < current_word.length(); ++i) {
                        grid[r + i][c] = current_word[i];
                    }
                    if (solve_crossword(grid, words, word_index + 1)) {
                        return true;
                    }
                    grid = grid_backup; // Backtrack
                }
            }
        }
    }
    return false;
}

int main() {
    cout << "Enter the 10x10 crossword grid:" << endl;
    vector<string> grid(10);
    for (int i = 0; i < 10; ++i) {
        cin >> grid[i];
    }

    cout << "\nEnter the semicolon-separated words:" << endl;
    string words_line;
    cin >> words_line;
    vector<string> words;
    stringstream ss(words_line);
    string word;
    while (getline(ss, word, ';')) {
        words.push_back(word);
    }
    
    solve_crossword(grid, words, 0);

    cout << "\nSolved Crossword:" << endl;
    for (int i = 0; i < 10; ++i) {
        cout << grid[i] << endl;
    }

    return 0;
}