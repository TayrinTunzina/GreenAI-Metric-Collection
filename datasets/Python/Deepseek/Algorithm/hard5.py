import sys
MOD = 10**9 + 7

def solve():
    n, m = map(int, sys.stdin.readline().split())
    max_num = 1 << m
    if n > max_num - 1:
        print(0)
        return
    
    # Precompute factorial modulo MOD up to max_num - 1
    fact = [1] * (max_num)
    for i in range(1, max_num):
        fact[i] = fact[i-1] * i % MOD
    
    # The answer is P(max_num - 1, n) since all configurations are winning when n=2
    ans = fact[max_num - 1] * pow(fact[max_num - 1 - n], MOD - 2, MOD) % MOD
    print(ans)

solve()