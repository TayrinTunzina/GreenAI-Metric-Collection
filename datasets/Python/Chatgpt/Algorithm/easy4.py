def bigSorting(unsorted):
    # Sort by length first, then by lexicographical order
    return sorted(unsorted, key=lambda x: (len(x), x))

# Manual input
n = int(input("Enter number of elements: "))
unsorted = []
for _ in range(n):
    unsorted.append(input())

sorted_list = bigSorting(unsorted)
print("Sorted output:")
for number in sorted_list:
    print(number)