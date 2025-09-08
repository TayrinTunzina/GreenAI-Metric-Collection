def repeatedString(s, n):
    # Count the number of 'a's in the original string
    count_a_in_s = s.count('a')
    
    # Find how many full repetitions of `s` fit into `n`
    full_repetitions = n // len(s)
    
    # Find how many extra characters are left after the full repetitions
    remainder_length = n % len(s)
    
    # Count the number of 'a's in the remaining substring (efficient slicing)
    count_a_in_remainder = s[:remainder_length].count('a')
    
    # Total number of 'a's is the sum of 'a's in full repetitions and remainder
    total_count_a = count_a_in_s * full_repetitions + count_a_in_remainder
    
    return total_count_a

# Input format
if __name__ == "__main__":
    # Prompt the user for input
    s = input("Enter the string (s): ").strip()
    n = int(input("Enter the number of characters to consider (n): "))
    
    # Compute and print the result
    result = repeatedString(s, n)
    print(f"The number of 'a's in the first {n} characters: {result}")