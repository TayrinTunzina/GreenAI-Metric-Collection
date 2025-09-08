def main():
    print("=== Find Maximum Si ===")
    
    # Step 1: Get N
    n = int(input("Enter the value of N: "))
    
    if n < 2:
        print("Maximum possible value of Si: 0")
        return

    # Step 2: Get array elements one by one
    A = []
    for i in range(n):
        num = int(input(f"Enter element {i+1}: "))
        A.append(num)
    
    # Arrays to store left and right smaller element indices
    left = [-1] * n
    right = [n] * n
    stack = []

    # Find next smaller element to the right
    for i in range(n):
        while stack and A[stack[-1]] > A[i]:
            idx = stack.pop()
            right[idx] = i
        stack.append(i)

    stack = []
    
    # Find previous smaller element to the left
    for i in range(n-1, -1, -1):
        while stack and A[stack[-1]] > A[i]:
            idx = stack.pop()
            left[idx] = i
        stack.append(i)

    max_si = 0

    # For each element as minimum, find smallest greater element in its range
    for i in range(n):
        candidate = None

        # Check left side: from i-1 down to left[i] + 1
        for j in range(i-1, left[i], -1):
            if A[j] > A[i]:
                if candidate is None or A[j] < candidate:
                    candidate = A[j]

        # Check right side: from i+1 to right[i] - 1
        for j in range(i+1, right[i]):
            if A[j] > A[i]:
                if candidate is None or A[j] < candidate:
                    candidate = A[j]

        # If a valid second smallest exists
        if candidate is not None:
            si = A[i] ^ candidate
            if si > max_si:
                max_si = si

    print(f"Maximum possible value of Si: {max_si}")

if __name__ == "__main__":
    main()