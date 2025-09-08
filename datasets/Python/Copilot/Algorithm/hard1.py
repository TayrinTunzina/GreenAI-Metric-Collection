def matrixRotation(matrix, r):
    m, n = len(matrix), len(matrix[0])
    layers = min(m, n) // 2

    for layer in range(layers):
        elements = []
        # top
        for i in range(layer, n - layer):
            elements.append(matrix[layer][i])
        # right
        for i in range(layer + 1, m - layer):
            elements.append(matrix[i][n - layer - 1])
        # bottom
        for i in range(n - layer - 2, layer - 1, -1):
            elements.append(matrix[m - layer - 1][i])
        # left
        for i in range(m - layer - 2, layer, -1):
            elements.append(matrix[i][layer])

        rot = r % len(elements)
        rotated = elements[rot:] + elements[:rot]

        idx = 0
        for i in range(layer, n - layer):
            matrix[layer][i] = rotated[idx]
            idx += 1
        for i in range(layer + 1, m - layer):
            matrix[i][n - layer - 1] = rotated[idx]
            idx += 1
        for i in range(n - layer - 2, layer - 1, -1):
            matrix[m - layer - 1][i] = rotated[idx]
            idx += 1
        for i in range(m - layer - 2, layer, -1):
            matrix[i][layer] = rotated[idx]
            idx += 1

    for row in matrix:
        print(' '.join(map(str, row)))

# 👇 Input handling
if __name__ == "__main__":
    m, n, r = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(m)]
    matrixRotation(matrix, r)
