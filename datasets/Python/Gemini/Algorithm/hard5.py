import sys

def solve():
    """
    Calculates the number of winning Nim games (ordered tuples) with n distinct piles,
    each with < 2^m stones.
    The number of winning games equals the number of ways to choose n linearly 
    independent vectors from GF(2)^m.
    """
    try:
        n_str, m_str = sys.stdin.readline().split()
        n = int(n_str)
        m = int(m_str)
    except (IOError, ValueError):
        return

    MOD = 10**9 + 7

    def power(base, exp):
        res = 1
        base %= MOD
        while exp > 0:
            if exp % 2 == 1:
                res = (res * base) % MOD
            base = (base * base) % MOD
            exp //= 2
        return res

    # If n > 2^m, it's impossible to choose n distinct vectors,
    # but the loop condition handles this naturally as (2^m - 2^i) will become 0.
    
    p2m = power(2, m)
    winning_games = 1
    p2i = 1  # This will hold 2^i

    for i in range(n):
        term = (p2m - p2i + MOD) % MOD
        winning_games = (winning_games * term) % MOD
        p2i = (p2i * 2) % MOD
        
    print(winning_games)

solve()