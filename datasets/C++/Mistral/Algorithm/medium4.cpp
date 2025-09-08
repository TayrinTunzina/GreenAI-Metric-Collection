#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

bool canPlaceWord(vector<string>& grid, const string& word, int row, int col, bool horizontal) {
    int length = word.length();
    if (horizontal) {
        if (col + length > 10) return false;
        for (int i = 0; i < length; ++i) {
            if (grid[row][col + i] != '-' && grid[row][col + i] != word[i]) {
                return false;
            }
        }
    } else {
        if (row + length > 10) return false;
        for (int i = 0; i < length; ++i) {
            if (grid[row + i][col] != '-' && grid[row + i][col] != word[i]) {
                return false;
            }
        }
    }
    return true;
}

void placeWord(vector<string>& grid, const string& word, int row, int col, bool horizontal) {
    int length = word.length();
    if (horizontal) {
        for (int i = 0; i < length; ++i) {
            grid[row][col + i] = word[i];
        }
    } else {
        for (int i = 0; i < length; ++i) {
            grid[row + i][col] = word[i];
        }
    }
}

void unplaceWord(vector<string>& grid, const string& word, int row, int col, bool horizontal) {
    int length = word.length();
    if (horizontal) {
        for (int i = 0; i < length; ++i) {
            grid[row][col + i] = '-';
        }
    } else {
        for (int i = 0; i < length; ++i) {
            grid[row + i][col] = '-';
        }
    }
}

bool solveCrossword(vector<string>& grid, const vector<string>& words, int index) {
    if (index == words.size()) return true;

    const string& word = words[index];
    for (int row = 0; row < 10; ++row) {
        for (int col = 0; col < 10; ++col) {
            if (grid[row][col] == '-' || grid[row][col] == word[0]) {
                if (canPlaceWord(grid, word, row, col, true)) {
                    placeWord(grid, word, row, col, true);
                    if (solveCrossword(grid, words, index + 1)) return true;
                    unplaceWord(grid, word, row, col, true);
                }
                if (canPlaceWord(grid, word, row, col, false)) {
                    placeWord(grid, word, row, col, false);
                    if (solveCrossword(grid, words, index + 1)) return true;
                    unplaceWord(grid, word, row, col, false);
                }
            }
        }
    }
    return false;
}

vector<string> crosswordPuzzle(vector<string>& crossword, const string& wordsInput) {
    vector<string> words;
    string word;
    for (char c : wordsInput) {
        if (c == ';') {
            words.push_back(word);
            word.clear();
        } else {
            word += c;
        }
    }
    if (!word.empty()) words.push_back(word);

    sort(words.begin(), words.end(), [](const string& a, const string& b) {
        return a.length() > b.length();
    });

    if (solveCrossword(crossword, words, 0)) {
        return crossword;
    } else {
        return {"No solution found"};
    }
}

int main() {
    vector<string> crossword(10);
    cout << "Enter the crossword grid (10 rows of 10 characters each, use '-' for fillable cells and '+' for blocked cells):" << endl;
    for (int i = 0; i < 10; ++i) {
        while (true) {
            cout << "Row " << i + 1 << ": ";
            cin >> crossword[i];
            if (crossword[i].length() == 10 && all_of(crossword[i].begin(), crossword[i].end(), [](char c) { return c == '+' || c == '-'; })) {
                break;
            } else {
                cout << "Invalid input. Please enter exactly 10 characters, each being either '+' or '-'." << endl;
            }
        }
    }

    string words;
    cout << "Enter the list of words separated by semicolons: ";
    cin >> words;

    vector<string> solution = crosswordPuzzle(crossword, words);
    cout << "\nSolution:" << endl;
    for (const string& row : solution) {
        cout << row << endl;
    }

    return 0;
}
