def gameOfStones(n):
    # dp[i] = True if current player can win with i stones
    dp = [False] * (n + 1)
    
    # Base cases: if we can make a move (remove 2, 3, or 5 stones)
    # and the opponent will be in a losing position, we win
    for i in range(2, n + 1):
        # Try removing 2, 3, or 5 stones
        moves = [2, 3, 5]
        for move in moves:
            if i >= move and not dp[i - move]:
                dp[i] = True
                break
    
    return "First" if dp[n] else "Second"

def main():
    print("Enter the number of test cases:")
    t = int(input())
    
    print(f"Enter {t} test case(s), each containing the number of stones:")
    
    for i in range(t):
        n = int(input())
        result = gameOfStones(n)
        print(result)

if __name__ == "__main__":
    main()