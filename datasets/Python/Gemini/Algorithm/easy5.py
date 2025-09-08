def gameOfStones(n):
    # dp[i] will be True if the current player can win with i stones, False otherwise.
    # We need to consider up to n stones, so size n+1
    dp = [False] * (n + 1)

    # Base cases
    # dp[0] = False (no stones, current player loses)
    # dp[1] = False (cannot remove 2, 3, or 5, current player loses)
    # dp[2] = True (can remove 2, leaving 0 which is a losing state for opponent)
    # dp[3] = True (can remove 3, leaving 0)
    # dp[4] = True (can remove 3, leaving 1. dp[1] is False, so winning move)
    # dp[5] = True (can remove 5, leaving 0)

    # Calculate dp states
    for i in range(2, n + 1):
        # A position is winning if any move leads to a losing position for the opponent
        can_win = False

        # Try removing 2 stones
        if i - 2 >= 0 and not dp[i - 2]:
            can_win = True
        # Try removing 3 stones
        if not can_win and i - 3 >= 0 and not dp[i - 3]:
            can_win = True
        # Try removing 5 stones
        if not can_win and i - 5 >= 0 and not dp[i - 5]:
            can_win = True

        dp[i] = can_win

    # If dp[n] is True, First player wins. Otherwise, Second player wins.
    return "First" if dp[n] else "Second"

if __name__ == '__main__':
    print("Enter the number of test cases (t):")
    t = int(input().strip())

    results = []
    for t_itr in range(t):
        print(f"Enter the number of stones for test case {t_itr + 1}:")
        n = int(input().strip())
        winner = gameOfStones(n)
        results.append(winner)

    print("\n--- Winners ---")
    for res in results:
        print(res)