def commonChild(s1, s2):
    m = len(s1)
    n = len(s2)
    # Create a DP table to store lengths of longest common suffixes of substrings
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    # Fill the DP table
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s1[i - 1] == s2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

    return dp[m][n]

# Taking inputs manually
s1 = input().strip()
s2 = input().strip()

print(commonChild(s1, s2))
