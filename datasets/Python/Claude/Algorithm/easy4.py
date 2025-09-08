def bigSorting(unsorted):
    """
    Sort array of numeric strings in ascending order of their integer values.
    
    Key insight: For numeric strings without leading zeros:
    1. Shorter strings represent smaller numbers
    2. For strings of same length, lexicographic order = numeric order
    """
    def compare_strings(s1, s2):
        # First compare by length
        if len(s1) != len(s2):
            return len(s1) - len(s2)
        # If same length, compare lexicographically
        if s1 < s2:
            return -1
        elif s1 > s2:
            return 1
        else:
            return 0
    
    # Using Python's built-in sort with custom key
    # Sort by (length, string_value)
    return sorted(unsorted, key=lambda x: (len(x), x))

def main():
    print("Enter the number of strings:")
    n = int(input())
    
    print(f"Enter {n} numeric strings:")
    unsorted = []
    for i in range(n):
        unsorted.append(input().strip())
    
    result = bigSorting(unsorted)
    
    print("\nSorted array:")
    for num in result:
        print(num)

if __name__ == "__main__":
    main()