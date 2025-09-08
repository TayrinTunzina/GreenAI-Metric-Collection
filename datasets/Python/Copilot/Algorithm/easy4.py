def bigSorting(unsorted):
    # Sort using length first, then lexicographic
    return sorted(unsorted, key=lambda x: (len(x), x))

# Manual input
n = int(input("Enter number of elements: "))
unsorted = [input() for _ in range(n)]

sorted_array = bigSorting(unsorted)
print("Sorted array:", sorted_array)