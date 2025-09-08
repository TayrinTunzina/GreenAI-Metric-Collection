def compute_grundy(m, k):
    if m == 1:
        return 1
    depth = 0
    while m > 1:
        m = max(1, m // k)
        depth += 1
    return depth % 2

g = int(input())
for _ in range(g):
    n = int(input())
    xor_sum = 0
    for _ in range(n):
        m, k = map(int, input().split())
        xor_sum ^= compute_grundy(m, k)
    print("BOB" if xor_sum != 0 else "BEN")
