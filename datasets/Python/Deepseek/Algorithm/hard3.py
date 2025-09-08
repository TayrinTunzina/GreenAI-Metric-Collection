def calculate_z_array(s):
    n = len(s)
    Z = [0] * n
    Z[0] = n
    l, r = 0, 0
    for i in range(1, n):
        if i > r:
            l = r = i
            while r < n and s[r - l] == s[r]:
                r += 1
            Z[i] = r - l
            r -= 1
        else:
            k = i - l
            if Z[k] < r - i + 1:
                Z[i] = Z[k]
            else:
                l = i
                while r < n and s[r - l] == s[r]:
                    r += 1
                Z[i] = r - l
                r -= 1
    return Z

def sum_of_similarities(s):
    Z = calculate_z_array(s)
    return sum(Z)

# Manual input
t = int(input("Enter the number of test cases: "))  # Number of test cases
test_cases = []
for i in range(t):
    s = input(f"Enter test case {i+1}: ")  # Prompt for each test case
    test_cases.append(s)

# Calculate and print the sum of similarities for each test case
for s in test_cases:
    print(f"Sum of similarities for '{s}': {sum_of_similarities(s)}")