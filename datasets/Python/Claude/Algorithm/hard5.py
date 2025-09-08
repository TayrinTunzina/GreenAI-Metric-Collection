def solve():
    MOD = 10**9 + 7
    
    # Read input
    n, m = map(int, input().split())
    
    # Available values: 1, 2, ..., 2^m - 1
    max_val = (1 << m) - 1  # 2^m - 1
    
    if n > max_val:
        print(0)
        return
    
    # We need to count ordered arrangements (permutations) of n distinct values
    # from {1, 2, ..., 2^m - 1} where first player wins (Nim-sum ≠ 0)
    
    # Mathematical approach:
    # 1. Total permutations = P(2^m - 1, n) = (2^m - 1)! / (2^m - 1 - n)!
    # 2. Subtract permutations where Nim-sum = 0
    
    # For Nim-sum = 0: we need sets of n values whose XOR is 0
    # Key insight: among all possible combinations of n distinct values,
    # exactly C(2^(m-1) - 1, n-1) combinations have XOR = 0 (when n > 1)
    # Each such combination contributes n! permutations
    
    # Precompute factorials (limit to reasonable size)
    max_fact = min(max_val + 1, 2*10**6)
    fact = [1] * max_fact
    for i in range(1, max_fact):
        fact[i] = (fact[i-1] * i) % MOD
    
    def mod_inverse(x):
        return pow(x, MOD-2, MOD)
    
    def permutation(n, r):
        if r > n or r < 0 or n >= max_fact:
            return 0
        return fact[n] * mod_inverse(fact[n-r]) % MOD
    
    def combination(n, r):
        if r > n or r < 0 or n >= max_fact:
            return 0
        return fact[n] * mod_inverse(fact[r]) % MOD * mod_inverse(fact[n-r]) % MOD
    
    # Total permutations
    if max_val < max_fact:
        total_perms = permutation(max_val, n)
    else:
        # For very large max_val, use different approach
        total_perms = 1
        for i in range(n):
            total_perms = (total_perms * (max_val - i)) % MOD
    
    # Permutations with Nim-sum = 0
    if n == 1:
        zero_nim_perms = 0  # Single positive value never has XOR = 0
    elif n == 2:
        # For n=2: XOR of two distinct positive values is never 0
        # (since a ⊕ b = 0 implies a = b, but we need distinct values)
        zero_nim_perms = 0
    else:
        # For n > 2: Use the mathematical property
        # Number of combinations with XOR = 0 is C(2^(m-1) - 1, n-1)
        if m == 1:
            zero_nim_perms = 0
        else:
            half_max = (1 << (m-1)) - 1
            if half_max >= max_fact or n-1 > half_max:
                zero_nim_combos = 0
            else:
                zero_nim_combos = combination(half_max, n-1)
            
            # Each combination gives n! permutations
            if n < max_fact:
                zero_nim_perms = (zero_nim_combos * fact[n]) % MOD
            else:
                zero_nim_perms = 0
    
    result = (total_perms - zero_nim_perms + MOD) % MOD
    print(result)

if __name__ == "__main__":
    solve()
