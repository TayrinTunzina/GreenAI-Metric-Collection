def repeatedString(s: str, n: int) -> int:
    """
    Calculate the number of 'a's in the first n characters of infinitely repeated string s.
    
    Args:
        s (str): The string to be repeated
        n (int): Number of characters to consider
        
    Returns:
        int: Count of letter 'a' in the first n characters
    """
    # Return 0 if string is empty
    if not s:
        return 0
        
    # Count 'a' in the original string
    count_in_string = s.count('a')
    
    # Calculate complete strings
    complete_strings = n // len(s)
    
    # Calculate remaining characters
    remaining_chars = n % len(s)
    
    # Calculate total count
    total_count = (count_in_string * complete_strings) + s[:remaining_chars].count('a')
    
    return total_count

def validate_input(s: str, n: int) -> None:
    """
    Validate the input string and number according to constraints.
    
    Args:
        s (str): The input string
        n (int): The number of characters to consider
        
    Raises:
        ValueError: If any validation fails
    """
    # Validate string
    if not isinstance(s, str):
        raise ValueError("Input must be a string")
    
    if not (1 <= len(s) <= 100):
        raise ValueError("String length must be between 1 and 100")
        
    if not s.islower():
        raise ValueError("String must contain only lowercase letters")
    
    # Validate n
    if not isinstance(n, int):
        raise ValueError("n must be an integer")
        
    if not (1 <= n <= 10**12):
        raise ValueError("n must be between 1 and 10^12")

def main():
    try:
        # Get string input
        print("Enter the string:", end=" ")
        s = input().strip()
        
        # Get number input
        print("Enter n:", end=" ")
        n = int(input().strip())
        
        # Validate inputs
        validate_input(s, n)
        
        # Calculate result
        result = repeatedString(s, n)
        
        # Print result
        print(f"Result: {result}")
        
    except ValueError as e:
        print(f"Error: {e}")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")

if __name__ == "__main__":
    main()