def findStartingPoint(petrol, distance, n):
    # If only one petrol pump
    if n == 1:
        return 0 if petrol[0] >= distance[0] else -1
    
    start = 0
    curr_petrol = 0
    total_petrol = 0
    
    for i in range(n):
        # Add the difference of petrol and distance
        curr_petrol += petrol[i] - distance[i]
        total_petrol += petrol[i] - distance[i]
        
        # If at any point curr_petrol becomes negative
        if curr_petrol < 0:
            # Start from the next point
            start = i + 1
            # Reset current petrol
            curr_petrol = 0
    
    # If total petrol is negative, no solution exists
    if total_petrol < 0:
        return -1
        
    return start

if __name__ == "__main__":
    # Input processing
    n = int(input())
    petrol = []
    distance = []
    
    # Read n lines of input
    for _ in range(n):
        p, d = map(int, input().split())
        petrol.append(p)
        distance.append(d)
    
    # Find and print the result
    result = findStartingPoint(petrol, distance, n)
    print(result)