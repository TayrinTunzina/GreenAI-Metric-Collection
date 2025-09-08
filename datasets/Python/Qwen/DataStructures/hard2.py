def find_starting_point(n, petrol_pumps):
    start = 0
    total_petrol = 0
    total_distance = 0
    current_petrol = 0
    for i in range(n):
        petrol, distance = petrol_pumps[i]
        total_petrol += petrol
        total_distance += distance
        current_petrol += petrol - distance
        if current_petrol < 0:
            start = i + 1
            current_petrol = 0
    if total_petrol >= total_distance:
        return start % n
    else:
        return -1

# Input handling
if __name__ == "__main__":
    n = int(input("Enter the number of petrol pumps: "))
    petrol_pumps = []
    for _ in range(n):
        petrol, distance = map(int, input("Enter petrol and distance (space-separated): ").split())
        petrol_pumps.append((petrol, distance))
    
    result = find_starting_point(n, petrol_pumps)
    print("The starting point is:", result)