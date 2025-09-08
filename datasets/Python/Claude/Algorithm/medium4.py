def can_place_horizontally(board, word, row, col):
    if col + len(word) > 10 or (col > 0 and board[row][col - 1] != '+') or (col + len(word) < 10 and board[row][col + len(word)] != '+'):
        return False
    for i in range(len(word)):
        if board[row][col + i] not in ['-', word[i]]:
            return False
    return True

def can_place_vertically(board, word, row, col):
    if row + len(word) > 10 or (row > 0 and board[row - 1][col] != '+') or (row + len(word) < 10 and board[row + len(word)][col] != '+'):
        return False
    for i in range(len(word)):
        if board[row + i][col] not in ['-', word[i]]:
            return False
    return True

def place_horizontally(board, word, row, col):
    changes = []
    for i in range(len(word)):
        if board[row][col + i] == '-':
            board[row][col + i] = word[i]
            changes.append((row, col + i))
    return changes

def place_vertically(board, word, row, col):
    changes = []
    for i in range(len(word)):
        if board[row + i][col] == '-':
            board[row + i][col] = word[i]
            changes.append((row + i, col))
    return changes

def unplace(board, changes):
    for row, col in changes:
        board[row][col] = '-'

def solve(board, words, idx):
    if idx == len(words):
        return True
    word = words[idx]
    for r in range(10):
        for c in range(10):
            if can_place_horizontally(board, word, r, c):
                changes = place_horizontally(board, word, r, c)
                if solve(board, words, idx + 1):
                    return True
                unplace(board, changes)
            if can_place_vertically(board, word, r, c):
                changes = place_vertically(board, word, r, c)
                if solve(board, words, idx + 1):
                    return True
                unplace(board, changes)
    return False

# === Manual input ===
grid = [list(input()) for _ in range(10)]
words = input().split(';')

if solve(grid, words, 0):
    for row in grid:
        print(''.join(row))
else:
    print("No solution found.")