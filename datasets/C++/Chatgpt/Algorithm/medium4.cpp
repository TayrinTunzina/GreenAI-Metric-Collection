#include <iostream>
#include <vector>
#include <string>
using namespace std;

bool canPlaceHorizontally(vector<string>& board, string& word, int row, int col) {
    if (col + word.length() > 10 || (col > 0 && board[row][col - 1] != '+') || 
        (col + word.length() < 10 && board[row][col + word.length()] != '+'))
        return false;
    for (int i = 0; i < word.length(); i++) {
        if (board[row][col + i] != '-' && board[row][col + i] != word[i])
            return false;
    }
    return true;
}

bool canPlaceVertically(vector<string>& board, string& word, int row, int col) {
    if (row + word.length() > 10 || (row > 0 && board[row - 1][col] != '+') || 
        (row + word.length() < 10 && board[row + word.length()][col] != '+'))
        return false;
    for (int i = 0; i < word.length(); i++) {
        if (board[row + i][col] != '-' && board[row + i][col] != word[i])
            return false;
    }
    return true;
}

vector<pair<int, int>> placeHorizontally(vector<string>& board, string& word, int row, int col) {
    vector<pair<int, int>> changes;
    for (int i = 0; i < word.length(); i++) {
        if (board[row][col + i] == '-') {
            board[row][col + i] = word[i];
            changes.push_back({row, col + i});
        }
    }
    return changes;
}

vector<pair<int, int>> placeVertically(vector<string>& board, string& word, int row, int col) {
    vector<pair<int, int>> changes;
    for (int i = 0; i < word.length(); i++) {
        if (board[row + i][col] == '-') {
            board[row + i][col] = word[i];
            changes.push_back({row + i, col});
        }
    }
    return changes;
}

void unplace(vector<string>& board, vector<pair<int, int>>& changes) {
    for (auto& ch : changes)
        board[ch.first][ch.second] = '-';
}

bool solve(vector<string>& board, vector<string>& words, int idx) {
    if (idx == words.size()) return true;
    for (int r = 0; r < 10; r++) {
        for (int c = 0; c < 10; c++) {
            if (canPlaceHorizontally(board, words[idx], r, c)) {
                auto changes = placeHorizontally(board, words[idx], r, c);
                if (solve(board, words, idx + 1)) return true;
                unplace(board, changes);
            }
            if (canPlaceVertically(board, words[idx], r, c)) {
                auto changes = placeVertically(board, words[idx], r, c);
                if (solve(board, words, idx + 1)) return true;
                unplace(board, changes);
            }
        }
    }
    return false;
}

int main() {
    vector<string> board(10);
    for (int i = 0; i < 10; i++) cin >> board[i];

    string wordLine;
    cin >> wordLine;

    vector<string> words;
    size_t pos = 0;
    while ((pos = wordLine.find(';')) != string::npos) {
        words.push_back(wordLine.substr(0, pos));
        wordLine.erase(0, pos + 1);
    }
    words.push_back(wordLine);

    if (solve(board, words, 0)) {
        for (string row : board)
            cout << row << endl;
    } else {
        cout << "No solution found.\n";
    }

    return 0;
}
