def crosswordPuzzle(crossword, words):
    # Convert the crossword to a list of lists for easier manipulation
    grid = [list(row) for row in crossword]
    word_list = words.split(';')
    
    # Find all horizontal and vertical slots
    slots = []
    
    # Find horizontal slots (left to right)
    for i in range(10):
        j = 0
        while j < 10:
            if grid[i][j] == '-':
                start = j
                while j < 10 and grid[i][j] == '-':
                    j += 1
                length = j - start
                if length > 1:
                    slots.append(('h', i, start, length))
            else:
                j += 1
    
    # Find vertical slots (top to bottom)
    for j in range(10):
        i = 0
        while i < 10:
            if grid[i][j] == '-':
                start = i
                while i < 10 and grid[i][j] == '-':
                    i += 1
                length = i - start
                if length > 1:
                    slots.append(('v', start, j, length))
            else:
                i += 1
    
    # Sort slots by length (descending) to try longer words first
    slots.sort(key=lambda x: -x[3])
    
    # Backtracking function
    def backtrack(word_index):
        if word_index == len(word_list):
            return True
        
        current_word = word_list[word_index]
        
        for slot in slots:
            direction, row, col, length = slot
            if length != len(current_word):
                continue
            
            # Check if this word can fit in this slot
            can_place = True
            original_chars = []
            
            if direction == 'h':
                for k in range(length):
                    cell = grid[row][col + k]
                    if cell != '-' and cell != current_word[k]:
                        can_place = False
                        break
                    original_chars.append(cell)
            else:  # vertical
                for k in range(length):
                    cell = grid[row + k][col]
                    if cell != '-' and cell != current_word[k]:
                        can_place = False
                        break
                    original_chars.append(cell)
            
            if can_place:
                # Place the word
                if direction == 'h':
                    for k in range(length):
                        grid[row][col + k] = current_word[k]
                else:
                    for k in range(length):
                        grid[row + k][col] = current_word[k]
                
                # Recurse
                if backtrack(word_index + 1):
                    return True
                
                # Backtrack
                if direction == 'h':
                    for k in range(length):
                        grid[row][col + k] = original_chars[k]
                else:
                    for k in range(length):
                        grid[row + k][col] = original_chars[k]
        
        return False
    
    # Start backtracking
    backtrack(0)
    
    # Convert the grid back to strings
    return [''.join(row) for row in grid]

# Read input
crossword = [input().strip() for _ in range(10)]
words = input().strip()

# Solve and print
result = crosswordPuzzle(crossword, words)
for row in result:
    print(row)