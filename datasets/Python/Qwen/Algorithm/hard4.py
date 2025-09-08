import sys

def main():
    # Read first line: N and K
    line1 = input().split()
    N = int(line1[0])
    K = int(line1[1])
    
    # Read second line: K integers
    A = list(map(int, input().split()))
    
    # Special case: if N is 1
    if N == 1:
        print(1)
        return
    
    # best_path[x] = list of numbers in the path from 1 to x
    best_path = {}
    best_path[1] = [1]
    
    # Current level (frontier of BFS)
    level = [1]
    
    while level:
        # Dictionary to store the lexicographically smallest path to each number at this level
        next_level_candidates = {}
        
        # Process nodes in sorted order to help with lex order
        for u in sorted(level):
            if u not in best_path:
                continue
            for a in A:
                v = u * a
                if v > N:
                    continue
                new_path = best_path[u] + [v]
                # If we haven't seen v in this level or found a lexicographically smaller path
                if v not in next_level_candidates or new_path < next_level_candidates[v]:
                    next_level_candidates[v] = new_path
        
        # Update best_path and prepare next level
        next_level = []
        for v, path in next_level_candidates.items():
            if v not in best_path:
                best_path[v] = path
                next_level.append(v)
            else:
                old_path = best_path[v]
                if len(path) < len(old_path):
                    best_path[v] = path
                    next_level.append(v)
                elif len(path) == len(old_path) and path < old_path:
                    best_path[v] = path
                    next_level.append(v)
        
        # If we've reached N, we can stop (since BFS ensures shortest path)
        if N in best_path:
            break
        
        # Remove duplicates for next level
        level = list(set(next_level))
    
    # Output result
    if N in best_path:
        print(' '.join(map(str, best_path[N])))
    else:
        print(-1)

if __name__ == "__main__":
    main()