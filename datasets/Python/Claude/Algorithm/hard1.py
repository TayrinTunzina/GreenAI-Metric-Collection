def matrixRotation(matrix, r):
    m, n = len(matrix), len(matrix[0])
    rings = min(m, n) // 2
    
    for ring in range(rings):
        # Extract ring elements
        elements = []
        
        # Top row (left to right)
        for j in range(ring, n - ring):
            elements.append(matrix[ring][j])
        
        # Right column (top to bottom, excluding corners)
        for i in range(ring + 1, m - ring):
            elements.append(matrix[i][n - ring - 1])
        
        # Bottom row (right to left, excluding corner if not single row)
        if m - ring - 1 > ring:
            for j in range(n - ring - 2, ring - 1, -1):
                elements.append(matrix[m - ring - 1][j])
        
        # Left column (bottom to top, excluding corners if not single column)
        if n - ring - 1 > ring:
            for i in range(m - ring - 2, ring, -1):
                elements.append(matrix[i][ring])
        
        # Calculate effective rotations
        ring_size = len(elements)
        if ring_size == 0:
            continue
        effective_r = r % ring_size
        
        # Rotate elements
        rotated = elements[effective_r:] + elements[:effective_r]
        
        # Place back rotated elements
        idx = 0
        
        # Top row
        for j in range(ring, n - ring):
            matrix[ring][j] = rotated[idx]
            idx += 1
        
        # Right column
        for i in range(ring + 1, m - ring):
            matrix[i][n - ring - 1] = rotated[idx]
            idx += 1
        
        # Bottom row
        if m - ring - 1 > ring:
            for j in range(n - ring - 2, ring - 1, -1):
                matrix[m - ring - 1][j] = rotated[idx]
                idx += 1
        
        # Left column
        if n - ring - 1 > ring:
            for i in range(m - ring - 2, ring, -1):
                matrix[i][ring] = rotated[idx]
                idx += 1
    
    # Print the result
    for row in matrix:
        print(' '.join(map(str, row)))

# Read input and solve
if __name__ == "__main__":
    # Read first line: m, n, r
    m, n, r = map(int, input().split())
    
    # Read matrix
    matrix = []
    for i in range(m):
        row = list(map(int, input().split()))
        matrix.append(row)
    
    # Solve and print result
    matrixRotation(matrix, r)