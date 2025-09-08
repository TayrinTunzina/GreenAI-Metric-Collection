def grundy(m):
    if m == 2:
        return 0
    elif m % 2 == 1:
        return 1
    else:
        return 2

g = int(input())
for _ in range(g):
    n = int(input())
    xor_val = 0
    for _ in range(n):
        m, k = map(int, input().split())
        xor_val ^= grundy(m)
    print("BOB" if xor_val != 0 else "BEN")