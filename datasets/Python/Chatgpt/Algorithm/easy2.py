def repeatedString(s, n):
    # Count the number of 'a' in the given string s
    count_a_in_s = s.count('a')
    
    # Find out how many times the string s is repeated to cover n characters
    full_repeats = n // len(s)
    
    # Count how many 'a's are in the full repeated part
    total_a = full_repeats * count_a_in_s
    
    # Add the 'a's in the remaining part of the string
    remainder = n % len(s)
    total_a += s[:remainder].count('a')
    
    return total_a

# Example usage:
s = input("Enter the string: ")
n = int(input("Enter the number of characters to consider: "))
result = repeatedString(s, n)
print("Number of 'a's in the first", n, "characters of the infinite string:", result)
