def find_starting_pump(pumps):
    n = len(pumps)
    total_petrol = 0
    current_petrol = 0
    start_index = 0
    
    for i in range(n):
        total_petrol += pumps[i][0] - pumps[i][1]
        current_petrol += pumps[i][0] - pumps[i][1]
        
        if current_petrol < 0:
            start_index = i + 1
            current_petrol = 0
            
    return start_index if total_petrol >= 0 else -1

if __name__ == "__main__":
    n = int(input("Enter the number of petrol pumps: "))
    pumps = []
    for _ in range(n):
        petrol, distance = map(int, input().split())
        pumps.append((petrol, distance))
    
    result = find_starting_pump(pumps)
    print("The smallest index from which we can start the tour is:", result)
