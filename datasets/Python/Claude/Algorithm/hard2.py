import math

def chiefHopper(arr):
    # Work backwards from the last building
    # We need at least 1 energy after completing all buildings
    min_energy_needed = 1
    
    # Go through buildings in reverse order
    for i in range(len(arr) - 1, -1, -1):
        height = arr[i]
        # To have min_energy_needed after jumping, we need:
        # 2 * before_energy - height >= min_energy_needed
        # before_energy >= (min_energy_needed + height) / 2
        min_energy_needed = math.ceil((min_energy_needed + height) / 2)
    
    return min_energy_needed

# Test with the given example
def test_example():
    arr = [2, 3, 4, 3, 2]
    result = chiefHopper(arr)
    print(f"Example: arr = {arr}")
    print(f"Minimum starting energy: {result}")
    
    # Verify the solution
    energy = result
    print(f"\nVerification:")
    print(f"Starting energy: {energy}")
    
    for i, height in enumerate(arr):
        new_energy = 2 * energy - height
        print(f"Building {i}: height={height}, energy: {energy} -> {new_energy}")
        energy = new_energy
        if energy < 0:
            print("Energy went below 0! Solution is incorrect.")
            break
    print(f"Final energy: {energy}")

# Main function to take input and solve
def main():
    print("Enter the number of buildings:")
    n = int(input())
    
    print("Enter the heights of buildings (space-separated):")
    heights = list(map(int, input().split()))
    
    if len(heights) != n:
        print(f"Error: Expected {n} buildings, got {len(heights)}")
        return
    
    result = chiefHopper(heights)
    print(f"Minimum starting energy required: {result}")

if __name__ == "__main__":
    # Run test first
    test_example()
    print("\n" + "="*50 + "\n")
    
    # Then run main program
    main()