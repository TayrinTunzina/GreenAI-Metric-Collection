def bigSorting(unsorted):
    return sorted(unsorted, key=lambda x: (len(x), x))

n = int(input())
unsorted = [input().strip() for _ in range(n)]
sorted_arr = bigSorting(unsorted)
print('\n'.join(sorted_arr))