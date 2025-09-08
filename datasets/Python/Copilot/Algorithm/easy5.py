def gameOfStones(n):
    dp = [False] * (n + 1)
    for i in range(1, n + 1):
        if i >= 2 and not dp[i - 2]:
            dp[i] = True
        elif i >= 3 and not dp[i - 3]:
            dp[i] = True
        elif i >= 5 and not dp[i - 5]:
            dp[i] = True
    return "First" if dp[n] else "Second"

# Manual Input
t = int(input("Enter number of test cases: "))
for _ in range(t):
    n = int(input("Enter number of stones: "))
    print(gameOfStones(n))
