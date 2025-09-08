def get_factors(n):
    factors = []
    i = 2
    while i * i <= n:
        if n % i == 0:
            factors.append((i, n//i))
        i += 1
    return factors

def min_moves(n):
    # Base cases
    if n == 0:
        return 0
    if n == 1:
        return 1
    
    # Try factorization
    min_steps = n  # Maximum possible steps would be decrementing n times
    for a, b in get_factors(n):
        min_steps = min(min_steps, 1 + min_moves(max(a, b)))
    
    # Try decrementing by 1
    min_steps = min(min_steps, 1 + min_moves(n - 1))
    return min_steps

def main():
    # Create cache for memoization
    cache = {}
    
    def min_moves_with_cache(n):
        if n in cache:
            return cache[n]
        
        if n == 0:
            return 0
        if n == 1:
            return 1
        
        min_steps = n
        for a, b in get_factors(n):
            min_steps = min(min_steps, 1 + min_moves_with_cache(max(a, b)))
        min_steps = min(min_steps, 1 + min_moves_with_cache(n - 1))
        
        cache[n] = min_steps
        return min_steps
    
    Q = int(input())
    for _ in range(Q):
        N = int(input())
        print(min_moves_with_cache(N))

if __name__ == "__main__":
    main()