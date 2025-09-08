def crosswordPuzzle(crossword, words_str):
    # Convert to mutable 2D grid
    grid = [list(row) for row in crossword]
    words = words_str.split(';')
    from collections import defaultdict

    def get_slots():
        slots = []
        # Horizontal slots
        for i in range(10):
            j = 0
            while j < 10:
                if grid[i][j] == '-':
                    start = j
                    while j < 10 and grid[i][j] == '-':
                        j += 1
                    length = j - start
                    if length > 1:
                        slots.append(('H', i, start, length))
                else:
                    j += 1
        # Vertical slots
        for j in range(10):
            i = 0
            while i < 10:
                if grid[i][j] == '-':
                    start = i
                    while i < 10 and grid[i][j] == '-':
                        i += 1
                    length = i - start
                    if length > 1:
                        slots.append(('V', start, j, length))
                else:
                    i += 1
        # Sort by length (descending) for efficiency
        slots.sort(key=lambda x: x[3], reverse=True)
        return slots

    def fits(word, slot):
        direction, r, c, length = slot
        if len(word) != length:
            return False
        if direction == 'H':
            for i in range(length):
                if grid[r][c + i] != '-' and grid[r][c + i] != word[i]:
                    return False
        else:  # 'V'
            for i in range(length):
                if grid[r + i][c] != '-' and grid[r + i][c] != word[i]:
                    return False
        return True

    def place(word, slot):
        placed = []
        direction, r, c, length = slot
        for i in range(length):
            if direction == 'H':
                if grid[r][c + i] == '-':
                    grid[r][c + i] = word[i]
                    placed.append((r, c + i))
            else:
                if grid[r + i][c] == '-':
                    grid[r + i][c] = word[i]
                    placed.append((r + i, c))
        return placed

    def unplace(placed):
        for r, c in placed:
            grid[r][c] = '-'

    slots = get_slots()

    # We'll use a list of available words (mutable)
    available_words = words[:]

    def solve(idx):
        if idx == len(slots):
            return True

        slot = slots[idx]
        for word in available_words:
            if len(word) == slot[3] and fits(word, slot):
                # Try placing this word
                placed = place(word, slot)
                available_words.remove(word)

                if solve(idx + 1):
                    return True

                # Backtrack
                available_words.append(word)
                available_words.sort()  # Optional: keep consistent order
                unplace(placed)
        return False

    solve(0)
    return [''.join(row) for row in grid]


# === Input Handling ===
if __name__ == '__main__':
    crossword = []
    for _ in range(10):
        crossword.append(input().strip())
    words_str = input().strip()

    result = crosswordPuzzle(crossword, words_str)
    for row in result:
        print(row)