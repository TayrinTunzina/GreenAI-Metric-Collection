import math

def chiefHopper(arr):
    """
    Calculates the minimum starting energy by working backward from the last building.
    """
    required_energy = 0
    
    # Iterate through the building heights in reverse order
    for h in reversed(arr):
        # Calculate the energy needed before this jump.
        # (required_energy + h + 1) // 2 is an efficient way to compute
        # the ceiling of (required_energy + h) / 2 using integer math.
        required_energy = (required_energy + h + 1) // 2
        
    return required_energy

if __name__ == '__main__':
    n = int(input().strip())
    arr = list(map(int, input().rstrip().split()))
    
    result = chiefHopper(arr)
    print(result)