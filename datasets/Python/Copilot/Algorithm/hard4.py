from collections import deque

def reverse_factorization(N, A):
    A.sort()
    visited = set()
    q = deque([(1, [1])])
    while q:
        curr, path = q.popleft()
        for a in A:
            next_val = curr * a
            if next_val > N or next_val in visited or N % next_val != 0:
                continue
            visited.add(next_val)
            new_path = path + [next_val]
            if next_val == N:
                return new_path
            q.append((next_val, new_path))
    return [-1]

# Manual Input
N_K = input("Enter N and K (e.g. 12 3): ").strip().split()
N, K = int(N_K[0]), int(N_K[1])
A = list(map(int, input(f"Enter {K} integers for A: ").strip().split()))

result = reverse_factorization(N, A)
print("Answer:", ' '.join(map(str, result)))
