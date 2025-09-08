from collections import deque

def solve_reverse_factorization():
    # Manual input - user enters values during runtime
    print("Enter N and K (space separated):")
    n, k = map(int, input().split())
    print(f"Enter {k} elements of array A (space separated):")
    a = list(map(int, input().split()))
    
    # Sort the array to ensure lexicographic ordering
    a.sort()
    
    # BFS to find shortest path
    queue = deque([(1, [1])])  # (current_value, path)
    visited = {1}
    
    while queue:
        current, path = queue.popleft()
        
        if current == n:
            print(*path)
            return
        
        # Try multiplying with each element in sorted order
        for multiplier in a:
            next_val = current * multiplier
            
            # Pruning: if next_val > n, skip
            if next_val > n:
                continue
                
            # If not visited, add to queue
            if next_val not in visited:
                visited.add(next_val)
                new_path = path + [next_val]
                queue.append((next_val, new_path))
    
    # If we reach here, no solution exists
    print(-1)

# Example usage with manual input
if __name__ == "__main__":
    print("=== Reverse Factorization Problem ===")
    print("Find the lexicographically smallest path with minimum states from 1 to N")
    print("Example: N=12, A=[2,3,4] should give output: 1 3 12")
    print()
    solve_reverse_factorization()