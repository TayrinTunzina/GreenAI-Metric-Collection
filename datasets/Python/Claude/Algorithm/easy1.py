def alternate(s):
    def is_alternating(string, char1, char2):
        """Check if string alternates between char1 and char2"""
        if len(string) < 2:
            return True
        
        # Filter string to contain only char1 and char2
        filtered = ''.join([c for c in string if c == char1 or c == char2])
        
        if len(filtered) < 2:
            return True
        
        # Check if it alternates
        for i in range(1, len(filtered)):
            if filtered[i] == filtered[i-1]:
                return False
        
        return True
    
    # Get all unique characters
    unique_chars = list(set(s))
    max_length = 0
    
    # Try all pairs of characters
    for i in range(len(unique_chars)):
        for j in range(i + 1, len(unique_chars)):
            char1, char2 = unique_chars[i], unique_chars[j]
            
            # Create string with only these two characters
            filtered_string = ''.join([c for c in s if c == char1 or c == char2])
            
            # Check if this filtered string alternates
            if is_alternating(filtered_string, char1, char2):
                max_length = max(max_length, len(filtered_string))
    
    return max_length

# Main function to take input
def main():
    print("=== Python Solution ===")
    
    # Take manual input
    n = int(input("Enter the length of string: "))
    s = input("Enter the string: ")
    
    result = alternate(s)
    print(f"Length of longest alternating string: {result}")

if __name__ == "__main__":
    main()