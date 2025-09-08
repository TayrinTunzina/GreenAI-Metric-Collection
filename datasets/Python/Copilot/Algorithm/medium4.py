def can_place(word, board, i, j, dir):
    if dir == 'H':
        if j + len(word) > 10 or (j > 0 and board[i][j-1] != '+') or (j + len(word) < 10 and board[i][j + len(word)] != '+'):
            return False
        for k in range(len(word)):
            if board[i][j+k] not in ('-', word[k]):
                return False
        return True
    else:
        if i + len(word) > 10 or (i > 0 and board[i-1][j] != '+') or (i + len(word) < 10 and board[i + len(word)][j] != '+'):
            return False
        for k in range(len(word)):
            if board[i+k][j] not in ('-', word[k]):
                return False
        return True

def place_word(word, board, i, j, dir):
    if dir == 'H':
        for k in range(len(word)):
            board[i][j+k] = word[k]
    else:
        for k in range(len(word)):
            board[i+k][j] = word[k]

def remove_word(word, board, i, j, dir):
    if dir == 'H':
        for k in range(len(word)):
            if board[i][j+k] == word[k]:
                board[i][j+k] = '-'
    else:
        for k in range(len(word)):
            if board[i+k][j] == word[k]:
                board[i+k][j] = '-'

def solve(board, words, idx):
    if idx == len(words):
        return True
    for i in range(10):
        for j in range(10):
            for dir in ['H', 'V']:
                if can_place(words[idx], board, i, j, dir):
                    place_word(words[idx], board, i, j, dir)
                    if solve(board, words, idx + 1):
                        return True
                    remove_word(words[idx], board, i, j, dir)
    return False

crossword = [list(input()) for _ in range(10)]
words = input().split(';')

solve(crossword, words, 0)

for row in crossword:
    print(''.join(row))