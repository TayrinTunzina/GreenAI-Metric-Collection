import sys

# It might be necessary for deep recursion with different constraints,
# but it's not required for this problem's limits.
# sys.setrecursionlimit(2000)

# Memoization dictionary to store results for subproblems
memo = {}
# The given set of multipliers will be stored here
A = []

def solve(n):
    """Recursively finds the optimal path to 'n'."""
    # Base case: The path to 1 is just [1]
    if n == 1:
        return [1]
    # If we have already computed the path for 'n', return it
    if n in memo:
        return memo[n]

    best_path = None # None signifies an impossible path

    # Iterate through all possible multipliers
    for a in A: # A is pre-sorted in descending order
        if n % a == 0:
            # Recursively find the path to the previous number (n / a)
            prev_path = solve(n // a)

            # If a path to the previous number exists
            if prev_path:
                current_path = prev_path + [n]

                # Check if the new path is better than the best one found so far.
                # Python's list comparison handles lexicographical order correctly.
                if (best_path is None or
                        len(current_path) < len(best_path) or
                        (len(current_path) == len(best_path) and current_path < best_path)):
                    best_path = current_path
    
    # Store the result in the memoization dictionary and return it
    memo[n] = best_path
    return best_path

def main():
    """Main function to handle input/output."""
    global A
    # Read input
    try:
        n_str, k_str = input("Enter N and K: ").split()
        N = int(n_str)
        K = int(k_str)
        
        a_str_list = input(f"Enter the {K} elements of set A: ").split()
        A = [int(x) for x in a_str_list]
    except (IOError, ValueError) as e:
        print(f"Invalid input: {e}")
        return

    # Sort A in descending order for a better heuristic
    A.sort(reverse=True)

    # Solve the problem for N
    result = solve(N)

    # Print the output
    print("Output: ", end="")
    if result is None:
        print(-1)
    else:
        print(*result)

if __name__ == "__main__":
    main()