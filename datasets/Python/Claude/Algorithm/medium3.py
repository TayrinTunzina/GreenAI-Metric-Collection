def commonChild(s1, s2):
    """
    Find the length of the longest common subsequence (LCS) of two strings.
    
    Args:
        s1: First string
        s2: Second string
    
    Returns:
        int: Length of the longest common child string
    """
    n, m = len(s1), len(s2)
    
    # Create DP table where dp[i][j] represents LCS length of s1[0:i] and s2[0:j]
    dp = [[0] * (m + 1) for _ in range(n + 1)]
    
    # Fill the DP table
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if s1[i-1] == s2[j-1]:
                # Characters match, add 1 to diagonal value
                dp[i][j] = dp[i-1][j-1] + 1
            else:
                # Characters don't match, take maximum from left or top
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    
    return dp[n][m]

# Main function to take inputs manually
def main():
    s1 = input().strip()
    s2 = input().strip()
    
    result = commonChild(s1, s2)
    print(result)

if __name__ == "__main__":
    main()