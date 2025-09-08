import math

def chiefHopper(arr):
    energy = 0
    for height in reversed(arr):
        energy = math.ceil((energy + height) / 2)
    return energy

# Manual input
n = int(input("Enter number of buildings: "))
arr = list(map(int, input("Enter building heights: ").split()))
print("Minimum starting energy:", chiefHopper(arr))
