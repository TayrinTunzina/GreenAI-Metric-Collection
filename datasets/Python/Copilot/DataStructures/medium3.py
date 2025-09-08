def min_moves(N):
    if N == 0:
        return 0
    moves = 0
    while N > 0:
        for i in range(2, int(N**0.5) + 1):
            if N % i == 0:
                N = max(i, N // i)
                break
        else:
            N -= 1
        moves += 1
    return moves

# Input and output handling
Q = int(input("Enter the number of queries: "))
for _ in range(Q):
    N = int(input("Enter the value of N: "))
    print(min_moves(N))
