def min_moves(n):
    if n == 0:
        return 0
    if n == 1:
        return 1

    # Initialize a list to store the minimum moves for each number 
    dp = [float('inf')] * (n + 1) 
    dp[0] = 0
    dp[1] = 1

    for i in range(2, n + 1):
        for j in range(2, int(i**0.5) + 1):
            if i % j == 0:
                dp[i] = min(dp[i], 1 + dp[max(j, i // j)])

        if dp[i] == float('inf'):  # If no divisors were found, decrement by 1
            dp[i] = dp[i - 1] + 1

    return dp[n]

if __name__ == "__main__":
    q = int(input())
    results = []
    for _ in range(q):
        n = int(input())
        results.append(min_moves(n))

    for result in results:
        print(result)
