def commonChild(s1, s2):
    """
    Calculates the length of the longest common child (subsequence).
    """
    n = len(s1)
    
    # We only need two rows for the DP table for space optimization.
    # prev_dp stores the results from the previous row (i-1).
    # current_dp calculates the results for the current row (i).
    prev_dp = [0] * (n + 1)
    current_dp = [0] * (n + 1)

    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if s1[i - 1] == s2[j - 1]:
                # Characters match, so we extend the previous best subsequence.
                current_dp[j] = prev_dp[j - 1] + 1
            else:
                # Characters don't match. Take the best of the two possibilities.
                current_dp[j] = max(prev_dp[j], current_dp[j - 1])
        
        # The current row becomes the previous row for the next iteration.
        prev_dp = current_dp[:]

    return prev_dp[n]

# Main part to take input
if __name__ == '__main__':
    string1 = input()
    string2 = input()
    result = commonChild(string1, string2)
    print(result)