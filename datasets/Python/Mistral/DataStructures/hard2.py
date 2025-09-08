def can_complete_circle(petrol_pumps):
    n = len(petrol_pumps)
    total_petrol = 0
    total_distance = 0
    current_petrol = 0
    start_index = 0

    for i in range(n):
        petrol, distance = petrol_pumps[i]
        total_petrol += petrol
        total_distance += distance
        current_petrol += petrol - distance

        if current_petrol < 0:
            start_index = i + 1
            current_petrol = 0

    return start_index if total_petrol >= total_distance else -1

# Reading input manually
n = int(input("Enter the number of petrol pumps: "))
petrol_pumps = []
for _ in range(n):
    petrol, distance = map(int, input("Enter petrol and distance: ").split())
    petrol_pumps.append((petrol, distance))

start_index = can_complete_circle(petrol_pumps)
print("Starting index:", start_index)
