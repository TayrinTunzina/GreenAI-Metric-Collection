def can_place_word(grid, word, row, col, direction):
    length = len(word)
    if direction == 'H':  # Horizontal
        if col + length > 10:
            return False
        for i in range(length):
            if grid[row][col + i] not in ('-', word[i]):
                return False
    elif direction == 'V':  # Vertical
        if row + length > 10:
            return False
        for i in range(length):
            if grid[row + i][col] not in ('-', word[i]):
                return False
    return True

def place_word(grid, word, row, col, direction):
    length = len(word)
    if direction == 'H':  # Horizontal
        for i in range(length):
            grid[row][col + i] = word[i]
    elif direction == 'V':  # Vertical
        for i in range(length):
            grid[row + i][col] = word[i]

def unplace_word(grid, word, row, col, direction):
    length = len(word)
    if direction == 'H':  # Horizontal
        for i in range(length):
            grid[row][col + i] = '-'
    elif direction == 'V':  # Vertical
        for i in range(length):
            grid[row + i][col] = '-'

def solve_crossword(grid, words, index):
    if index == len(words):
        return True

    word = words[index]
    for row in range(10):
        for col in range(10):
            if grid[row][col] == '-' or grid[row][col] == word[0]:
                # Try placing horizontally
                if can_place_word(grid, word, row, col, 'H'):
                    place_word(grid, word, row, col, 'H')
                    if solve_crossword(grid, words, index + 1):
                        return True
                    unplace_word(grid, word, row, col, 'H')

                # Try placing vertically
                if can_place_word(grid, word, row, col, 'V'):
                    place_word(grid, word, row, col, 'V')
                    if solve_crossword(grid, words, index + 1):
                        return True
                    unplace_word(grid, word, row, col, 'V')
    return False

def crosswordPuzzle(crossword, words):
    # Sort words by length in descending order
    words = sorted(words.split(';'), key=len, reverse=True)

    # Convert crossword grid to a list of lists for easier manipulation
    grid = [list(row) for row in crossword]

    # Solve the crossword
    if solve_crossword(grid, words, 0):
        # Convert the grid back to strings
        return [''.join(row) for row in grid]
    else:
        return ["No solution found"]

def main():
    # Read the crossword grid
    crossword = []
    print("Enter the crossword grid (10 rows of 10 characters each, use '-' for fillable cells and '+' for blocked cells):")
    for i in range(10):
        while True:
            row = input(f"Row {i + 1}: ").strip()
            if len(row) == 10 and all(c in '+-' for c in row):
                crossword.append(row)
                break
            else:
                print("Invalid input. Please enter exactly 10 characters, each being either '+' or '-'.")

    # Read the list of words
    words = input("Enter the list of words separated by semicolons: ").strip()

    # Solve the crossword puzzle
    solution = crosswordPuzzle(crossword, words)
    print("\nSolution:")
    for row in solution:
        print(row)

if __name__ == "__main__":
    main()
