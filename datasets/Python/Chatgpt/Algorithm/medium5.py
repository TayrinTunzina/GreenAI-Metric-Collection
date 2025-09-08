def grundy(m, k):
    # Special fast computation
    g = 0
    while m > 1:
        m = (m + k - 2) // k  # equivalent to ceil((m-1)/k)
        g ^= 1
    return g

def main():
    g = int(input("Enter number of games: "))
    for _ in range(g):
        n = int(input("Enter number of trees: "))
        xor_sum = 0
        for _ in range(n):
            m, k = map(int, input().split())
            xor_sum ^= grundy(m, k)
        print("BOB" if xor_sum else "BEN")

if __name__ == "__main__":
    main()
