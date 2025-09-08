import math

def min_moves_to_zero(N):
    if N == 0:
        return 0
    if N <= 3:
        return N
    max_factor = int(math.sqrt(N))
    for i in range(2, max_factor + 1):
        if N % i == 0:
            return 1 + min(min_moves_to_zero(N // i), min_moves_to_zero(i))
    return N

Q = int(input("Enter the number of queries: "))
results = []
for _ in range(Q):
    N = int(input("Enter the value of N: "))
    results.append(min_moves_to_zero(N))

for result in results:
    print(result)
