def compute_grundy(m, k):
    leaves = 0
    # The number of leaves is m - floor(m / k)
    # This is because nodes from floor(m / k) + 1 to m are leaves
    leaves = m - (m // k)
    return leaves

def determine_winner(games):
    for game in games:
        n = game[0]
        trees = game[1]
        xor_sum = 0
        for m, k in trees:
            grundy = compute_grundy(m, k)
            xor_sum ^= grundy
        if xor_sum != 0:
            print("BOB")
        else:
            print("BEN")

# Example usage:
g = int(input("Enter the number of games: "))
games = []
for _ in range(g):
    n = int(input("Enter the number of trees in the forest: "))
    trees = []
    for _ in range(n):
        m, k = map(int, input("Enter m and k for the tree: ").split())
        trees.append((m, k))
    games.append((n, trees))

determine_winner(games)
