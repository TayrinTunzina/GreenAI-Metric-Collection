#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
#include <cctype>
#include <sstream>

using namespace std;

vector<vector<char>> grid;
vector<string> words;
map<int, vector<string>> wordLengthMap;

struct Slot {
    char dir; // 'H' or 'V'
    int r, c, len;
    Slot(char d, int row, int col, int length) : dir(d), r(row), c(col), len(length) {}
};

vector<Slot> getSlots() {
    vector<Slot> slots;

    // Horizontal slots
    for (int i = 0; i < 10; ++i) {
        int j = 0;
        while (j < 10) {
            if (grid[i][j] == '-') {
                int start = j;
                while (j < 10 && grid[i][j] == '-') {
                    j++;
                }
                int length = j - start;
                if (length > 1) {
                    slots.emplace_back('H', i, start, length);
                }
            } else {
                j++;
            }
        }
    }

    // Vertical slots
    for (int j = 0; j < 10; ++j) {
        int i = 0;
        while (i < 10) {
            if (grid[i][j] == '-') {
                int start = i;
                while (i < 10 && grid[i][j] == '-') {
                    i++;
                }
                int length = i - start;
                if (length > 1) {
                    slots.emplace_back('V', start, j, length);
                }
            } else {
                i++;
            }
        }
    }

    // Sort by length descending
    sort(slots.begin(), slots.end(), [](const Slot& a, const Slot& b) {
        return a.len > b.len;
    });

    return slots;
}

bool fits(const string& word, const Slot& slot) {
    if (word.length() != slot.len) return false;

    if (slot.dir == 'H') {
        for (int i = 0; i < slot.len; ++i) {
            if (grid[slot.r][slot.c + i] != '-' && grid[slot.r][slot.c + i] != word[i])
                return false;
        }
    } else {
        for (int i = 0; i < slot.len; ++i) {
            if (grid[slot.r + i][slot.c] != '-' && grid[slot.r + i][slot.c] != word[i])
                return false;
        }
    }
    return true;
}

vector<pair<int, int>> place(const string& word, const Slot& slot) {
    vector<pair<int, int>> placed;
    if (slot.dir == 'H') {
        for (int i = 0; i < slot.len; ++i) {
            if (grid[slot.r][slot.c + i] == '-') {
                grid[slot.r][slot.c + i] = word[i];
                placed.push_back({slot.r, slot.c + i});
            }
        }
    } else {
        for (int i = 0; i < slot.len; ++i) {
            if (grid[slot.r + i][slot.c] == '-') {
                grid[slot.r + i][slot.c] = word[i];
                placed.push_back({slot.r + i, slot.c});
            }
        }
    }
    return placed;
}

void unplace(const vector<pair<int, int>>& placed) {
    for (auto& p : placed) {
        grid[p.first][p.second] = '-';
    }
}

vector<Slot> slots;

bool solve(int idx) {
    if (idx == slots.size()) return true;

    Slot slot = slots[idx];
    auto& candidates = wordLengthMap[slot.len];
    vector<string> tempCandidates = candidates; // copy

    for (const string& word : tempCandidates) {
        if (!fits(word, slot)) continue;

        vector<pair<int, int>> placed = place(word, slot);
        // Remove word from candidates
        auto it = find(candidates.begin(), candidates.end(), word);
        if (it != candidates.end()) {
            candidates.erase(it);
        }

        if (solve(idx + 1)) return true;

        // Backtrack
        candidates.insert(it, word);
        unplace(placed);
    }
    return false;
}

int main() {
    // Read grid
    grid.resize(10, vector<char>(10));
    for (int i = 0; i < 10; ++i) {
        string row;
        cin >> row;
        for (int j = 0; j < 10; ++j) {
            grid[i][j] = row[j];
        }
    }

    // Read words
    string wordsLine;
    cin >> wordsLine;
    stringstream ss(wordsLine);
    string word;
    while (getline(ss, word, ';')) {
        words.push_back(word);
    }

    // Build wordLengthMap
    for (const string& w : words) {
        wordLengthMap[w.size()].push_back(w);
    }

    // Get slots
    slots = getSlots();

    // Solve
    solve(0);

    // Output
    for (int i = 0; i < 10; ++i) {
        for (int j = 0; j < 10; ++j) {
            cout << grid[i][j];
        }
        cout << endl;
    }

    return 0;
}