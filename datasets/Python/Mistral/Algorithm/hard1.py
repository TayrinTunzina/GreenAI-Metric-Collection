def matrix_rotation(matrix, m, n, r):
    for layer in range(min(m, n) // 2):
        first_row = layer
        first_col = layer
        last_row = m - 1 - layer
        last_col = n - 1 - layer

        # Extract the elements of the current layer
        elements = []
        for i in range(first_col, last_col + 1):
            elements.append(matrix[first_row][i])
        for i in range(first_row + 1, last_row + 1):
            elements.append(matrix[i][last_col])
        for i in range(last_col - 1, first_col - 1, -1):
            elements.append(matrix[last_row][i])
        for i in range(last_row - 1, first_row, -1):
            elements.append(matrix[i][first_col])

        # Perform the rotation
        length = len(elements)
        r_mod = r % length
        rotated_elements = elements[r_mod:] + elements[:r_mod]

        # Place the rotated elements back into the matrix
        index = 0
        for i in range(first_col, last_col + 1):
            matrix[first_row][i] = rotated_elements[index]
            index += 1
        for i in range(first_row + 1, last_row + 1):
            matrix[i][last_col] = rotated_elements[index]
            index += 1
        for i in range(last_col - 1, first_col - 1, -1):
            matrix[last_row][i] = rotated_elements[index]
            index += 1
        for i in range(last_row - 1, first_row, -1):
            matrix[i][first_col] = rotated_elements[index]
            index += 1

    # Print the rotated matrix
    for row in matrix:
        print(' '.join(map(str, row)))

# Read input
m, n, r = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(m)]

# Perform matrix rotation
matrix_rotation(matrix, m, n, r)
