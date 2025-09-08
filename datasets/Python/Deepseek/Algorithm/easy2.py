def repeatedString(s, n):
    # Count the number of 'a's in the string s
    count_a = s.count('a')
    
    # Calculate the number of full repetitions of s in n characters
    full_repeats = n // len(s)
    
    # Calculate the number of 'a's in the full repetitions
    total_a = full_repeats * count_a
    
    # Calculate the remaining characters
    remainder = n % len(s)
    
    # Add the number of 'a's in the remaining characters
    total_a += s[:remainder].count('a')
    
    return total_a

# Input
s = input("Enter the string: ")
n = int(input("Enter the value of n: "))

# Output
print("Number of 'a's in the first", n, "characters:", repeatedString(s, n))