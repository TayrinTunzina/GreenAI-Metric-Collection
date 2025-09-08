def gameOfStones(n):
    # Initialize a dp array to store the result of subproblems
    dp = [False] * (n + 1)

    # Base cases
    dp[0] = False  # If there are no stones, the current player loses

    # Fill the dp array
    for i in range(1, n + 1):
        if i >= 2 and not dp[i - 2]:
            dp[i] = True
        elif i >= 3 and not dp[i - 3]:
            dp[i] = True
        elif i >= 5 and not dp[i - 5]:
            dp[i] = True
        else:
            dp[i] = False

    return "First" if dp[n] else "Second"

# Read the number of test cases
t = int(input("Enter the number of test cases: "))

# Process each test case
for _ in range(t):
    n = int(input("Enter the number of stones: "))
    print(gameOfStones(n))
