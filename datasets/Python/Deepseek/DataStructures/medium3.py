import math

def min_moves(Q, queries):
    max_N = max(queries)
    dp = [0] * (max_N + 1)
    
    for i in range(1, max_N + 1):
        dp[i] = dp[i - 1] + 1  # Operation 2
        for a in range(2, int(math.sqrt(i)) + 1):
            if i % a == 0:
                b = i // a
                dp[i] = min(dp[i], dp[max(a, b)] + 1)
    
    results = [dp[n] for n in queries]
    return results

# Manual input
Q = int(input("Enter the number of queries (Q): "))
queries = []
for i in range(Q):
    N = int(input(f"Enter N for query {i + 1}: "))
    queries.append(N)

# Compute results
results = min_moves(Q, queries)

# Output results
print("Minimum moves required for each query:")
for res in results:
    print(res)