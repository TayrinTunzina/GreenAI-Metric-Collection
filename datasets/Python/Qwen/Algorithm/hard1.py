def matrixRotation(matrix, r):
    m, n = len(matrix), len(matrix[0])
    num_rings = min(m, n) // 2

    for ring in range(num_rings):
        height = m - 2 * ring
        width = n - 2 * ring
        if height == 1 or width == 1:
            perimeter = height * width
        else:
            perimeter = 2 * (height + width - 2)
        
        effective_r = r % perimeter
        if effective_r == 0:
            continue

        layer = []
        # 1. Left column: top to bottom
        for i in range(ring, ring + height):
            layer.append(matrix[i][ring])
        # 2. Bottom row: left to right (exclude corners)
        for j in range(ring + 1, ring + width - 1):
            layer.append(matrix[ring + height - 1][j])
        # 3. Right column: bottom to top
        for i in range(ring + height - 1, ring - 1, -1):
            layer.append(matrix[i][ring + width - 1])
        # 4. Top row: right to left (exclude corners)
        for j in range(ring + width - 2, ring, -1):
            layer.append(matrix[ring][j])

        # Clockwise rotation: right rotate by effective_r
        shift = perimeter - effective_r
        rotated_layer = layer[shift:] + layer[:shift]

        # Put back
        idx = 0
        for i in range(ring, ring + height):
            matrix[i][ring] = rotated_layer[idx]
            idx += 1
        for j in range(ring + 1, ring + width - 1):
            matrix[ring + height - 1][j] = rotated_layer[idx]
            idx += 1
        for i in range(ring + height - 1, ring - 1, -1):
            matrix[i][ring + width - 1] = rotated_layer[idx]
            idx += 1
        for j in range(ring + width - 2, ring, -1):
            matrix[ring][j] = rotated_layer[idx]
            idx += 1

    # Print result
    for row in matrix:
        print(' '.join(map(str, row)))


# === Read Input ===
if __name__ == '__main__':
    m, n, r = map(int, input().split())
    matrix = []
    for _ in range(m):
        row = list(map(int, input().split()))
        matrix.append(row)

    matrixRotation(matrix, r)