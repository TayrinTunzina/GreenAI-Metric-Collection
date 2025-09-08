def calculate_max_xor(nums):
    """
    Calculates max XOR between elements and their next/previous smaller elements
    using a monotonic stack.
    """
    stack = []
    max_val = 0
    for num in nums:
        while stack and stack[-1] > num:
            # Current 'num' is the next smaller element for stack.pop()
            max_val = max(max_val, stack.pop() ^ num)
        stack.append(num)
    return max_val

def main():
    """
    Main function to take manual input and solve the problem.
    """
    # Taking inputs manually
    try:
        n_str = input("Enter the number of elements (N): ")
        n = int(n_str)
        
        arr_str = input(f"Enter {n} space-separated integers for the array A[]: ")
        arr = list(map(int, arr_str.split()))

        if len(arr) != n:
            print("Error: Number of elements entered does not match N.")
            return
            
    except (IOError, ValueError):
        print("Invalid input. Please enter integers only.")
        return

    # Pass 1: Left to right (finds max XOR with next smaller elements)
    max1 = calculate_max_xor(arr)
    
    # Pass 2: Right to left (finds max XOR with previous smaller elements)
    arr.reverse()
    max2 = calculate_max_xor(arr)

    print(f"\nMaximum possible value of Si: {max(max1, max2)}")

# Run the program
main()