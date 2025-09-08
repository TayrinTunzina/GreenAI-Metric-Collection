def can_complete_circuit(petrol, distance):
    """
    Finds the starting petrol pump index to complete the circuit.

    Args:
        petrol: List of petrol amounts at each pump.
        distance: List of distances between pumps.

    Returns:
        Index of the starting petrol pump, or -1 if no solution exists.
    """
    n = len(petrol)
    start = 0
    tank = 0
    total_deficit = 0

    for i in range(n):
        tank += petrol[i] - distance[i]
        if tank < 0:
            start = i + 1
            total_deficit += tank
            tank = 0

    return start if tank + total_deficit >= 0 else -1

if __name__ == "__main__":
    n = int(input())
    petrol = []
    distance = []
    for _ in range(n):
        p, d = map(int, input().split())
        petrol.append(p)
        distance.append(d)
    print(can_complete_circuit(petrol, distance))
