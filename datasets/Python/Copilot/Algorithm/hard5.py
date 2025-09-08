MOD = 10**9 + 7

def countGames(n, m):
    limit = (1 << m)
    nums = list(range(1, limit))
    
    from itertools import permutations
    count = 0
    for perm in permutations(nums, n):
        xor = 0
        for num in perm:
            xor ^= num
        if xor != 0:
            count += 1
    print(count % MOD)

# Input reading
n, m = map(int, input().split())
countGames(n, m)
