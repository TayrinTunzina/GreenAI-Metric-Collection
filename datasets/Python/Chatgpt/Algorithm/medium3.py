def commonChild(s1, s2):
    n = len(s1)
    dp = [[0] * (n + 1) for _ in range(n + 1)]

    for i in range(n):
        for j in range(n):
            if s1[i] == s2[j]:
                dp[i+1][j+1] = dp[i][j] + 1
            else:
                dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j])

    return dp[n][n]

# Manual input
s1 = input("Enter first string: ").strip()
s2 = input("Enter second string: ").strip()

print("Length of common child:", commonChild(s1, s2))
