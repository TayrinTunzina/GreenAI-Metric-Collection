MOD = 10**9 + 7

def permutation(n, k):
    if k > n:
        return 0
    result = 1
    for i in range(k):
        result = result * (n - i) % MOD
    return result

def count_games(n, m):
    max_stones = 2**m - 1
    if n > max_stones:
        return 0

    # Calculate the number of permutations of n distinct piles
    total = permutation(max_stones, n)

    # For n=2, all games are winning games since XOR of two distinct numbers cannot be zero
    winning_positions = total % MOD
    return winning_positions

# Example usage
n, m = map(int, input().split())
print(count_games(n, m))
