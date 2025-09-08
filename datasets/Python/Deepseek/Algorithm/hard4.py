from collections import deque

def solve():
    N, K = map(int, input().split())
    A = list(map(int, input().split()))
    A.sort()  # To help in lex order processing
    
    # We'll use BFS where each node is (current value, path)
    visited = {}
    queue = deque()
    queue.append((1, [1]))
    visited[1] = 1  # tracks the minimal steps to reach this number
    
    found_paths = []
    
    while queue:
        current, path = queue.popleft()
        if current == N:
            found_paths.append(path)
            continue  # continue to process other paths in the same level
        
        for num in A:
            next_val = current * num
            if next_val > N:
                continue
            if next_val not in visited or len(path) + 1 <= visited[next_val]:
                if next_val in visited:
                    if len(path) + 1 > visited[next_val]:
                        continue
                # Only proceed if this path is better or equal in steps and lex order
                new_path = path + [next_val]
                if next_val not in visited or len(new_path) < visited[next_val]:
                    visited[next_val] = len(new_path)
                    queue.append((next_val, new_path))
                elif len(new_path) == visited[next_val]:
                    # Check if the new path is lex smaller than any existing path
                    # Since BFS processes in order, the first encountered might be lex smaller
                    # So we need to compare and keep the lex smallest
                    # To handle this, we can defer comparison until after collecting all candidates
                    queue.append((next_val, new_path))
    
    if not found_paths:
        print(-1)
        return
    
    # Filter paths with minimal length
    min_len = min(len(path) for path in found_paths)
    candidates = [path for path in found_paths if len(path) == min_len]
    
    # Find lex smallest
    lex_smallest = min(candidates)
    print(' '.join(map(str, lex_smallest)))

solve()