import sys
from itertools import combinations, permutations

MOD = 10**9 + 7

def xor(lst):
    res = 0
    for val in lst:
        res ^= val
    return res

def count_nim_games(n, m):
    nums = list(range(1, 1 << m))  # [1, 2, ..., 2^m - 1]
    total = 0
    for comb in combinations(nums, n):
        for perm in permutations(comb):
            if xor(perm) != 0:
                total += 1
    return total % MOD

if __name__ == "__main__":
    n, m = map(int, input().split())
    print(count_nim_games(n, m))
