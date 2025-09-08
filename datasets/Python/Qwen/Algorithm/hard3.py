def z_algorithm(s):
    n = len(s)
    z = [0] * n
    l, r = 0, 0
    for i in range(1, n):
        if i <= r:
            z[i] = min(r - i + 1, z[i - l])
        while i + z[i] < n and s[z[i]] == s[i + z[i]]:
            z[i] += 1
        if i + z[i] - 1 > r:
            l, r = i, i + z[i] - 1
    return z

def sum_of_similarities(s):
    z = z_algorithm(s)
    # The similarity of the string with itself is its length
    return len(s) + sum(z)

# Manual input
t = int(input("Enter the number of test cases: "))
results = []
for _ in range(t):
    s = input("Enter the string: ")
    results.append(sum_of_similarities(s))

# Output results
for res in results:
    print(res)