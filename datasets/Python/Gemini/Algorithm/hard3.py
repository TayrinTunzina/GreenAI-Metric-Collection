def sum_of_similarities(s):
    """
    Calculates the sum of similarities of a string S with each of its suffixes.

    Args:
        s: The input string.

    Returns:
        The sum of similarities.
    """
    n = len(s)
    sum_similarities = 0
    
    for i in range(n):  # Iterate through each suffix
        j = 0  # Pointer for the original string
        while j < n - i and s[j] == s[i + j]:
            j += 1
        sum_similarities += j
    
    return sum_similarities

if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        s = input()
        print(sum_of_similarities(s))
