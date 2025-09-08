def crosswordPuzzle(crossword, words_str):
    """
    Solves a 10x10 crossword puzzle using a backtracking algorithm.
    """
    grid = [list(row) for row in crossword]
    words = words_str.split(';')

    def can_place_horizontal(word, r, c):
        """Checks if a word can be placed horizontally at (r, c)."""
        if c + len(word) > 10:
            return False
        # Check left boundary
        if c > 0 and grid[r][c-1] != '+':
            return False
        # Check right boundary
        if c + len(word) < 10 and grid[r][c+len(word)] != '+':
            return False
        # Check if cells are compatible
        for i in range(len(word)):
            if grid[r][c+i] != '-' and grid[r][c+i] != word[i]:
                return False
        return True

    def can_place_vertical(word, r, c):
        """Checks if a word can be placed vertically at (r, c)."""
        if r + len(word) > 10:
            return False
        # Check top boundary
        if r > 0 and grid[r-1][c] != '+':
            return False
        # Check bottom boundary
        if r + len(word) < 10 and grid[r+len(word)][c] != '+':
            return False
        # Check if cells are compatible
        for i in range(len(word)):
            if grid[r+i][c] != '-' and grid[r+i][c] != word[i]:
                return False
        return True

    def solve(word_index):
        """Recursively places words from the words list."""
        # Base case: All words have been placed
        if word_index == len(words):
            return True

        current_word = words[word_index]
        # Iterate through every cell to find a starting point
        for r in range(10):
            for c in range(10):
                if grid[r][c] == '-' or grid[r][c] == current_word[0]:
                    # Try placing horizontally
                    if can_place_horizontal(current_word, r, c):
                        # Place the word and save the original state of the slot
                        original_slot = [grid[r][c+i] for i in range(len(current_word))]
                        for i in range(len(current_word)):
                            grid[r][c+i] = current_word[i]
                        
                        # Recurse for the next word
                        if solve(word_index + 1):
                            return True
                        
                        # Backtrack: Restore the grid
                        for i in range(len(current_word)):
                            grid[r][c+i] = original_slot[i]

                    # Try placing vertically
                    if can_place_vertical(current_word, r, c):
                        # Place the word and save the original state
                        original_slot = [grid[r+i][c] for i in range(len(current_word))]
                        for i in range(len(current_word)):
                            grid[r+i][c] = current_word[i]

                        # Recurse for the next word
                        if solve(word_index + 1):
                            return True

                        # Backtrack: Restore the grid
                        for i in range(len(current_word)):
                            grid[r+i][c] = original_slot[i]
        
        # If no placement is found for the current word
        return False

    # Start the backtracking process
    solve(0)
    return ["".join(row) for row in grid]

# --- Main execution for manual input ---
if __name__ == '__main__':
    print("Enter the 10x10 crossword grid:")
    crossword_input = []
    for _ in range(10):
        crossword_input.append(input())
    
    print("\nEnter the semicolon-separated words:")
    words_input = input()

    result = crosswordPuzzle(crossword_input, words_input)

    print("\nSolved Crossword:")
    for row in result:
        print(row)