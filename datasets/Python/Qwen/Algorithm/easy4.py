def bigSorting(unsorted):
    # Sort by length first, then lexicographically
    return sorted(unsorted, key=lambda x: (len(x), x))

# Read input and solve
n = int(input())
unsorted = []
for _ in range(n):
    unsorted.append(input().strip())

result = bigSorting(unsorted)
for item in result:
    print(item)