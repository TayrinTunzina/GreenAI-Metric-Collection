from itertools import combinations

def alternate(s):
    # Get unique characters
    chars = list(set(s))
    max_length = 0

    # Try all pairs of distinct characters
    for pair in combinations(chars, 2):
        # Filter string to only include characters in this pair
        filtered = [c for c in s if c in pair]
        
        # Check if the filtered string has alternating characters
        valid = True
        for i in range(len(filtered) - 1):
            if filtered[i] == filtered[i+1]:
                valid = False
                break
        
        if valid and len(filtered) >= 2:
            max_length = max(max_length, len(filtered))
    
    return max_length

# Input
n = int(input().strip())
s = input().strip()

# Output
print(alternate(s))