def repeatedString(s, n):
    """Calculates the number of 'a' characters in the first n characters of an infinitely repeated string s.

    Args:
        s: The string to repeat.
        n: The number of characters to consider.

    Returns:
        The number of 'a' characters in the first n characters of the repeated string.
    """

    # Count the number of 'a' characters in the original string
    a_count = s.count('a')

    # Calculate the number of full repetitions of the string in the first n characters
    full_repeats = n // len(s)

    # Calculate the number of 'a' characters in the full repetitions
    total_a_count = a_count * full_repeats

    # Calculate the remaining characters to consider
    remaining = n % len(s)

    # Count the number of 'a' characters in the remaining substring
    for i in range(remaining):
        if s[i] == 'a':
            total_a_count += 1

    return total_a_count

if __name__ == "__main__":
    s = input("Enter the string: ")
    n = int(input("Enter the number of characters: "))
    result = repeatedString(s, n)
    print("Number of 'a' characters:", result)
