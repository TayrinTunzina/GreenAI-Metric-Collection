def min_moves(n):
    moves = 0
    while n > 0:
        # Check for factorization
        for i in range(int(n**0.5), 1, -1):
            if n % i == 0:  # Found factors a and b
                n = max(i, n // i)
                moves += 1
                break
        else:
            # No factors found, decrease by 1
            n -= 1
            moves += 1
    return moves

if __name__ == "__main__":
    q = int(input())
    results = []
    for _ in range(q):
        n = int(input())
        results.append(min_moves(n))
    print("\n".join(map(str, results)))
