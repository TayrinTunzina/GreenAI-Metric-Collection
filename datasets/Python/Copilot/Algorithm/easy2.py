def repeatedString(s, n):
    # Step 1: Compute the number of times 'a' appears in the original string `s`.
    a_count_in_s = s.count('a')
    
    # Step 2: Determine how many full repetitions of `s` fit within `n` characters.
    full_repeats = n // len(s)
    
    # Step 3: Calculate the remaining substring (if `n` is not a multiple of `len(s)`).
    remaining_chars = n % len(s)
    
    # Step 4: Count the occurrences of 'a' in the remaining substring.
    a_count_in_remaining = s[:remaining_chars].count('a')
    
    # Step 5: Compute the total count of 'a'.
    total_a_count = full_repeats * a_count_in_s + a_count_in_remaining
    
    return total_a_count

# Taking input from the user
s = input("Enter the string: ")
n = int(input("Enter the number of characters to consider: "))

# Printing the result
print(repeatedString(s, n))
