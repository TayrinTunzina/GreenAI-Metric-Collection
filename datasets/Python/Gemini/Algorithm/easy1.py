import sys
from itertools import combinations

def alternate(s: str) -> int:
    """
    Calculates the length of the longest possible string of two alternating characters.

    Args:
        s: The input string.

    Returns:
        The length of the longest alternating string, or 0 if none can be formed.
    """
    # Get a sorted list of unique characters from the string
    unique_chars = sorted(list(set(s)))
    
    # It's impossible to form a pair with fewer than 2 unique characters
    if len(unique_chars) < 2:
        return 0

    max_len = 0

    # Generate all unique pairs of characters
    for c1, c2 in combinations(unique_chars, 2):
        # Build a temporary list containing only characters from the current pair
        temp_list = [char for char in s if char == c1 or char == c2]
        
        is_valid = True
        # Check if the sequence is alternating by looking for adjacent identical characters
        for i in range(len(temp_list) - 1):
            if temp_list[i] == temp_list[i+1]:
                is_valid = False
                break
        
        # If the sequence is valid, update the maximum length found so far
        if is_valid:
            max_len = max(max_len, len(temp_list))

    return max_len

if __name__ == "__main__":
    # Read the length of the string (per input format)
    l = int(sys.stdin.readline())
    # Read the string itself
    s = sys.stdin.readline().strip()
    
    result = alternate(s)
    print(result)