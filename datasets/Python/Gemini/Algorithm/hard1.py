import sys

def matrixRotation(matrix, m, n, r):
    """
    Rotates a 2D matrix layer by layer in an anti-clockwise direction.

    Args:
        matrix: A list of lists representing the m x n matrix.
        m: The number of rows.
        n: The number of columns.
        r: The number of anti-clockwise rotations.
    """
    num_layers = min(m, n) // 2

    for i in range(num_layers):
        # Define boundaries for the current layer
        top, bottom = i, m - 1 - i
        left, right = i, n - 1 - i

        # A layer that is just a line has 0 perimeter, so skip
        if left >= right or top >= bottom:
            break

        # 1. Extract layer elements into a 1D list (anti-clockwise)
        layer_1d = []
        # Move down the left column
        for row in range(top, bottom + 1):
            layer_1d.append(matrix[row][left])
        # Move right across the bottom row
        for col in range(left + 1, right + 1):
            layer_1d.append(matrix[bottom][col])
        # Move up the right column
        for row in range(bottom - 1, top - 1, -1):
            layer_1d.append(matrix[row][right])
        # Move left across the top row
        for col in range(right - 1, left, -1):
            layer_1d.append(matrix[top][col])
            
        # 2. Calculate effective rotations
        perimeter = len(layer_1d)
        effective_rotations = r % perimeter
        
        # If no effective rotation needed, continue
        if effective_rotations == 0:
            continue

        # 3. Rotate the 1D list (right shift for anti-clockwise matrix rotation)
        rotated_layer = layer_1d[-effective_rotations:] + layer_1d[:-effective_rotations]
        
        # 4. Place rotated elements back into the matrix
        idx = 0
        # Move down the left column
        for row in range(top, bottom + 1):
            matrix[row][left] = rotated_layer[idx]
            idx += 1
        # Move right across the bottom row
        for col in range(left + 1, right + 1):
            matrix[bottom][col] = rotated_layer[idx]
            idx += 1
        # Move up the right column
        for row in range(bottom - 1, top - 1, -1):
            matrix[row][right] = rotated_layer[idx]
            idx += 1
        # Move left across the top row
        for col in range(right - 1, left, -1):
            matrix[top][col] = rotated_layer[idx]
            idx += 1
            
    # Print the final matrix
    for row in matrix:
        print(*row)

if __name__ == '__main__':
    # Reading input from stdin
    m, n, r = map(int, sys.stdin.readline().rstrip().split())
    matrix = []
    for _ in range(m):
        matrix.append(list(map(int, sys.stdin.readline().rstrip().split())))
    
    matrixRotation(matrix, m, n, r)