def alternate(s):
    # Generate all pairs of characters
    chars = set(s)
    max_length = 0

    # Check all possible pairs
    for char1 in chars:
        for char2 in chars:
            if char1 == char2:
                continue
            # Create a new string by removing all characters except char1 and char2
            filtered = [c for c in s if c == char1 or c == char2]
            valid = True
            # Check if the filtered string is alternating
            for i in range(len(filtered) - 1):
                if filtered[i] == filtered[i + 1]:
                    valid = False
                    break
            if valid and len(filtered) > max_length:
                max_length = len(filtered)

    return max_length

# Input reading
length = int(input("Enter the length of the string: "))
s = input("Enter the string: ")

# Function call
result = alternate(s)
print(result)