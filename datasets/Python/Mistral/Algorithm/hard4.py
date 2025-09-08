from collections import deque

def reverse_factorization(N, A):
    A.sort()
    queue = deque()
    queue.append((1, []))  # (current value, sequence)

    while queue:
        current_value, sequence = queue.popleft()

        if current_value == N:
            return sequence

        for a in A:
            next_value = current_value * a
            if next_value <= N:
                queue.append((next_value, sequence + [next_value]))

    return [-1]

# Input
N, K = map(int, input("Enter N and K: ").split())
A = list(map(int, input("Enter the elements of A: ").split()))

# Calculate and print the result
result = reverse_factorization(N, A)
if result == [-1]:
    print(-1)
else:
    print(' '.join(map(str, [1] + result)))
