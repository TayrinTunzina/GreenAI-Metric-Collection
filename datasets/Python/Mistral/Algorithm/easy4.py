def bigSorting(unsorted):
    return sorted(unsorted, key=lambda x: (len(x), x))

n = int(input("Enter the number of elements: "))
unsorted = [input().strip() for _ in range(n)]
sorted_array = bigSorting(unsorted)
print("Sorted array:")
for num in sorted_array:
    print(num)