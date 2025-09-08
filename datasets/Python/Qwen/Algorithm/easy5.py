def gameOfStones(n):
    # dp[i] represents whether the current player can win with i stones
    if n <= 1:
        return "Second"
    
    # Create dp array
    dp = [False] * (n + 1)
    
    # Base cases
    # dp[0] = False (no moves possible)
    # dp[1] = False (no valid moves)
    
    # Fill dp array
    for i in range(2, n + 1):
        # Check if we can make a move that leads to opponent's loss
        if i >= 2 and not dp[i - 2]:  # Take 2 stones
            dp[i] = True
        elif i >= 3 and not dp[i - 3]:  # Take 3 stones
            dp[i] = True
        elif i >= 5 and not dp[i - 5]:  # Take 5 stones
            dp[i] = True
        # If none of the above, dp[i] remains False
    
    return "First" if dp[n] else "Second"

# Read input and solve
t = int(input())
for _ in range(t):
    n = int(input())
    print(gameOfStones(n))