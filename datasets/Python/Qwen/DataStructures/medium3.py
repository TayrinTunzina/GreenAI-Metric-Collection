def preprocess_dp(max_n):
    # Initialize DP array
    dp = [float('inf')] * (max_n + 1)
    dp[0] = 0  # Base case

    for i in range(1, max_n + 1):
        # Option 1: Decrease by 1
        dp[i] = dp[i - 1] + 1

        # Option 2: Factorize i into a and b
        for a in range(2, int(i**0.5) + 1):
            if i % a == 0:  # a is a divisor of i
                b = i // a
                dp[i] = min(dp[i], dp[max(a, b)] + 1)

    return dp


# Input and Output
if __name__ == "__main__":
    Q = int(input("Enter the number of queries: "))
    queries = []
    for _ in range(Q):
        N = int(input("Enter a number: "))
        queries.append(N)

    # Preprocess DP array
    max_n = max(queries) if queries else 0
    dp = preprocess_dp(max_n)

    # Answer queries
    for N in queries:
        print(dp[N])