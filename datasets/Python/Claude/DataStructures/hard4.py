# Taking inputs manually
n = int(input("Enter N: "))
print("Enter", n, "elements:")
arr = list(map(int, input().split()))

max_si = 0

# For each pair of elements, they can be M1 and M2 in some interval
# We just need to check all pairs
for i in range(n):
    for j in range(i + 1, n):
        # Calculate XOR of the pair
        si = arr[i] ^ arr[j]
        max_si = max(max_si, si)

print("Maximum possible value of Si:", max_si)