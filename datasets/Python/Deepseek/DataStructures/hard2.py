def find_starting_petrol_pump(N, petrol_pumps):
    start = 0
    total_petrol = 0
    current_petrol = 0
    
    for i in range(N):
        petrol, distance = petrol_pumps[i]
        total_petrol += petrol - distance
        current_petrol += petrol - distance
        
        if current_petrol < 0:
            start = i + 1
            current_petrol = 0
    
    return start if total_petrol >= 0 else -1

# Manual input
N = int(input("Enter the number of petrol pumps: "))
petrol_pumps = []
for i in range(N):
    petrol = int(input(f"Enter the amount of petrol at pump {i}: "))
    distance = int(input(f"Enter the distance to the next pump from pump {i}: "))
    petrol_pumps.append((petrol, distance))

# Finding the starting point
result = find_starting_petrol_pump(N, petrol_pumps)
print("The starting petrol pump index is:", result)