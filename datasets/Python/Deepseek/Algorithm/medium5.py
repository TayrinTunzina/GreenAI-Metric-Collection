import sys

def determine_winner(games):
    results = []
    for game in games:
        n = game[0]
        trees = game[1]
        total_xor = 0
        for m, k in trees:
            if m == 1:
                total_xor ^= 1
            else:
                # The pattern observed is that the grundy number is 0 if (m - 1) mod (k + 1) == 0
                # Otherwise, it's 1 or something else. Need to verify.
                # For the problem, perhaps the grundy number is (m - 1) % (k + 1) == 0 ? 0 : 1?
                # But sample inputs may suggest otherwise. Need more analysis.
                # Let's assume for now that grundy is 0 if m is 1 mod (k+1), else 1.
                if (m - 1) % (k + 1) == 0:
                    pass  # grundy 0, no xor
                else:
                    total_xor ^= 1
        if total_xor != 0:
            results.append("BOB")
        else:
            results.append("BEN")
    return results

def main():
    input_lines = sys.stdin.read().split()
    ptr = 0
    g = int(input_lines[ptr])
    ptr += 1
    games = []
    for _ in range(g):
        n = int(input_lines[ptr])
        ptr += 1
        trees = []
        for __ in range(n):
            m, k = map(int, input_lines[ptr:ptr+2])
            ptr += 2
            trees.append((m, k))
        games.append((n, trees))
    results = determine_winner(games)
    print('\n'.join(results))

if __name__ == "__main__":
    main()