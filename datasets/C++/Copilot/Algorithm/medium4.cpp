#include <iostream>
#include <vector>
#include <string>
using namespace std;

bool canPlaceH(string word, vector<string>& board, int i, int j) {
    if (j + word.length() > 10) return false;
    if (j > 0 && board[i][j - 1] != '+') return false;
    if (j + word.length() < 10 && board[i][j + word.length()] != '+') return false;

    for (int k = 0; k < word.length(); k++) {
        if (board[i][j + k] != '-' && board[i][j + k] != word[k]) return false;
    }
    return true;
}

bool canPlaceV(string word, vector<string>& board, int i, int j) {
    if (i + word.length() > 10) return false;
    if (i > 0 && board[i - 1][j] != '+') return false;
    if (i + word.length() < 10 && board[i + word.length()][j] != '+') return false;

    for (int k = 0; k < word.length(); k++) {
        if (board[i + k][j] != '-' && board[i + k][j] != word[k]) return false;
    }
    return true;
}

void placeH(string word, vector<string>& board, int i, int j) {
    for (int k = 0; k < word.length(); k++) {
        board[i][j + k] = word[k];
    }
}

void placeV(string word, vector<string>& board, int i, int j) {
    for (int k = 0; k < word.length(); k++) {
        board[i + k][j] = word[k];
    }
}

void removeH(string word, vector<string>& board, int i, int j) {
    for (int k = 0; k < word.length(); k++) {
        board[i][j + k] = '-';
    }
}

void removeV(string word, vector<string>& board, int i, int j) {
    for (int k = 0; k < word.length(); k++) {
        board[i + k][j] = '-';
    }
}

bool solve(vector<string>& board, vector<string>& words, int idx) {
    if (idx == words.size()) return true;
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (canPlaceH(words[idx], board, i, j)) {
                placeH(words[idx], board, i, j);
                if (solve(board, words, idx + 1)) return true;
                removeH(words[idx], board, i, j);
            }
            if (canPlaceV(words[idx], board, i, j)) {
                placeV(words[idx], board, i, j);
                if (solve(board, words, idx + 1)) return true;
                removeV(words[idx], board, i, j);
            }
        }
    }
    return false;
}

int main() {
    vector<string> board(10);
    for (int i = 0; i < 10; i++) cin >> board[i];

    string input;
    cin >> input;
    vector<string> words;
    size_t pos = 0;
    while ((pos = input.find(';')) != string::npos) {
        words.push_back(input.substr(0, pos));
        input.erase(0, pos + 1);
    }
    words.push_back(input);

    solve(board, words, 0);

    for (const string& row : board) cout << row << endl;
}
