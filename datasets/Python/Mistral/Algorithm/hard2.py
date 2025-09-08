def chief_hopper(arr):
    n = len(arr)
    min_energy = 0

    for i in range(n - 1, -1, -1):
        current_energy = (min_energy + arr[i] + 1) // 2
        min_energy = current_energy

    return min_energy

# Input
n = int(input("Enter the number of buildings: "))
arr = list(map(int, input("Enter the heights of the buildings: ").split()))

# Output
print("Minimum starting energy:", chief_hopper(arr))
