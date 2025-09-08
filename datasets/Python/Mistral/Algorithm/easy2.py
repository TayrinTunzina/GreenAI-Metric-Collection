def repeatedString(s, n):
    count_a_in_s = s.count('a')
    full_repeats = n // len(s)
    remaining = n % len(s)
    count_a_in_remaining = s[:remaining].count('a')
    total_count = full_repeats * count_a_in_s + count_a_in_remaining
    return total_count

# Read input manually
s = input("Enter the string s: ")
n = int(input("Enter the integer n: "))

# Call the function and print the result
result = repeatedString(s, n)
print(f"The number of 'a's in the first {n} letters of the infinite string is: {result}")
