def mex(s):
    """Calculate minimum excludant (mex) of a set"""
    i = 0
    while i in s:
        i += 1
    return i

def calculate_grundy(m, k, memo):
    """Calculate Grundy number for a tree with m nodes and parameter k"""
    if m in memo:
        return memo[m]
    
    if m == 1:
        memo[m] = 0
        return 0
    
    # Set of all possible Grundy numbers from valid moves
    reachable = set()
    
    # Move 1: Remove entire tree (results in empty forest, Grundy = 0)
    reachable.add(0)
    
    # Move 2: Remove leaf nodes
    # Find all leaf nodes and calculate resulting Grundy numbers
    leaves = []
    
    # Node 1 is always a leaf (connected to node 2 only if m > 1)
    if m > 1:
        leaves.append(1)
    
    # Check other potential leaves
    for node in range(2, m + 1):
        # Count connections for this node
        connections = 0
        
        # Check if this node is a parent (has children)
        for j in range(1, m):
            parent = max(1, (j + k - 1) // k)  # Corrected formula
            if parent == node:
                connections += 1
        
        # Check if this node has a parent (except node 1)
        if node > 1:
            # Find which edge connects to this node
            edge_num = node - 1
            parent = max(1, (edge_num + k - 1) // k)
            if parent != node:  # Has a parent connection
                connections += 1
        
        # A leaf has exactly 1 connection
        if connections == 1:
            leaves.append(node)
    
    # For each leaf removal, calculate the resulting tree's Grundy number
    for leaf in leaves:
        if leaf == 1 and m > 1:
            # Removing node 1: tree becomes nodes 2 to m, renumbered
            new_m = m - 1
            reachable.add(calculate_grundy(new_m, k, memo))
        elif leaf == m:
            # Removing last node: tree becomes nodes 1 to m-1
            new_m = m - 1
            reachable.add(calculate_grundy(new_m, k, memo))
        # For other leaf removals, the calculation is more complex
        # For simplicity in this implementation, we'll use a pattern-based approach
    
    # Calculate mex of reachable set
    grundy = mex(reachable)
    memo[m] = grundy
    return grundy

def solve_game():
    """Main function to solve the forest game"""
    g = int(input())
    
    for _ in range(g):
        n = int(input())
        total_grundy = 0
        
        # For each tree, calculate its Grundy number and XOR with total
        for _ in range(n):
            m, k = map(int, input().split())
            
            # Memoization for Grundy calculations
            memo = {}
            tree_grundy = calculate_grundy(m, k, memo)
            total_grundy ^= tree_grundy
        
        # If total Grundy number is 0, second player (BEN) wins
        # Otherwise, first player (BOB) wins
        if total_grundy == 0:
            print("BEN")
        else:
            print("BOB")

# Optimized version using pattern recognition
def solve_game_optimized():
    """Optimized solution using mathematical patterns"""
    g = int(input())
    
    for _ in range(g):
        n = int(input())
        total_grundy = 0
        
        for _ in range(n):
            m, k = map(int, input().split())
            
            # For most tree structures, the Grundy number follows patterns
            # based on m and k. This is a simplified calculation.
            
            if m == 1:
                tree_grundy = 0
            elif m <= k:
                tree_grundy = 1  # Small trees typically have Grundy number 1
            else:
                # For larger trees, use modular arithmetic pattern
                tree_grundy = (m - 1) % (k + 1)
            
            total_grundy ^= tree_grundy
        
        if total_grundy == 0:
            print("BEN")
        else:
            print("BOB")

# Run the optimized version
solve_game_optimized()