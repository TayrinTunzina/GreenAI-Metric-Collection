from collections import deque

def reverse_factorization(N, K, A):
    A.sort()  # For lexicographical order
    queue = deque()
    queue.append((1, [1]))
    visited = set()
    visited.add(1)

    while queue:
        current, path = queue.popleft()
        if current == N:
            return path
        for a in A:
            next_val = current * a
            if next_val <= N and N % next_val == 0 and next_val not in visited:
                visited.add(next_val)
                queue.append((next_val, path + [next_val]))

    return -1

def main():
    N, K = map(int, input("Enter N and K: ").split())
    A = list(map(int, input(f"Enter {K} elements of A: ").split()))
    result = reverse_factorization(N, K, A)
    if result == -1:
        print(-1)
    else:
        print(' '.join(map(str, result)))

main()
